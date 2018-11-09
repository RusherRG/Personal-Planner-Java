public class SendEmail  
{
   public static void main(String [] args)  {        
	   try {
			String s = "python D:/\"GitHub Repository\"/Personal-Planner-Java/src/mail.py";
			Process p = Runtime.getRuntime().exec(s);
			System.out.println(s);
		}
		catch(Exception e) {System.out.println(e);}
   }
   public void sendmail(String email) {
	   try {
			String s = "python D:/\"GitHub Repository\"/Personal-Planner-Java/src/mail.py " + email;
			Process p = Runtime.getRuntime().exec(s);
			System.out.println(s);
		}
		catch(Exception e) {System.out.println(e);}
	}
}
