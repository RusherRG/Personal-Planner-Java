import smtplib,email.message,sys,datetime,time
email_content = '''<html>
<body style=" font: 1.2em/1.4 'Oswald', sans-serif;
  color: #fff;
  text-align: right;">
<ul style="text-align: center;
  padding: 0;
  margin: 0;  position: absolute;
  width: 50%; 
  left: 50%;
  margin-left: -25%;">
'''
tasks = '''<li style="padding: 1em;
margin-bottom: .125em;
display: block;
list-style: none;
text-transform: uppercase;
transform-origin: 50% 0;
background-color: #333;
visibility: visible;
">'''
try:
    with open('D:/GitHub Repository/Personal-Planner-Java/src/mail_content.txt') as file:
        for i in file:
            email_content += tasks + i[:-1] + '''</li>'''
except:
    print("something")
email_content += '''</ul>
</body>
</html>'''

to_email = str(sys.argv[1])
time_ = str(sys.argv[2])
curr_time = str(datetime.datetime.now()).split()[1]
time_ = list(map(float,time_.split(':')))
curr_time = list(map(float,curr_time.split(':')))
diff = [i[0]-i[1] for i in zip(time_,curr_time)]
secs = diff[0]*3600 + diff[1]*60 + diff[2]
time.sleep(secs)

file = open('D:/GitHub Repository/Personal-Planner-Java/src/email.html','w')
file.write(email_content)

msg = email.message.Message()
msg['Subject'] = "Reminder"
msg.add_header('Content-Type','text/html')
msg.set_payload(email_content)

smtpObj = smtplib.SMTP('smtp.gmail.com',587)
smtpObj.starttls()
smtpObj.login('rushang101@gmail.com','rskprzieupvuaooi')
smtpObj.sendmail('rushang101@gmail.com',to_email,msg.as_string())
smtpObj.quit()