from gtts import gTTS 
from playsound import playsound
import os,sys
speech_text = ""
try:
    with open('D:/GitHub Repository/Personal-Planner-Java/src/msg.txt') as file:
        for i in file:
            speech_text += i
except:
    print("Something")
language = 'en'
myobj = gTTS(text=speech_text, lang=language, slow=False)
myobj.save("./src/welcome.mp3") 
playsound('./src/welcome.mp3')
