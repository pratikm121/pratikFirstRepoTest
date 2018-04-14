package com.pratik.mail;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class Reader {

	public static void check(String host, String storeType, String user,
		      String password) 
		   {
		      try {

		      //create properties field
		      Properties properties = new Properties();

		      properties.put("mail.pop3.host", host);
		      properties.put("mail.pop3.port", "995");
		      properties.put("mail.pop3.starttls.enable", "true");
		      Session emailSession = Session.getDefaultInstance(properties);
		  
		      //create the POP3 store object and connect with the pop server
		      Store store = emailSession.getStore("pop3s");

		      store.connect(host, user, password);

		      //create the folder object and open it
		      Folder emailFolder = store.getFolder("INBOX");
		      emailFolder.open(Folder.READ_ONLY);

		      // retrieve the messages from the folder in an array and print it
		      Message[] messages = emailFolder.getMessages();
		      System.out.println("messages.length---" + messages.length);
		      

		      for (int i = 0, n = messages.length; i < 2; i++) {
		         Message message = messages[i];
		         System.out.println("---------------------------------");
		         System.out.println("Email Number " + (i + 1));
		         System.out.println("Subject: " + message.getSubject());
		         System.out.println("From: " + message.getFrom()[0]);
		        // System.out.println("Text: " + message.getContent().toString());
		         
		         Multipart multipart = (Multipart) message.getContent();
			     for(int k = 0; k < multipart.getCount(); k++){
			       BodyPart bodyPart = multipart.getBodyPart(k);  
			       System.out.println(bodyPart.getContent());
			       /*InputStream stream = (InputStream) bodyPart.getInputStream();  
			       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));  	
			       System.out.println(bufferedReader.toString());*/
			       /* while (bufferedReader.ready()) {  
			        	//if (bufferedReader.readLine().contains("Greetings for the day !!")){
			        		
			        		System.out.println(bufferedReader.readLine());
			        	//}
			    	         
			    	}*/  
			    	   System.out.println();  
			      }
		      }
		      
		       

		      //close the store and folder objects
		      emailFolder.close(false);
		      store.close();

		      } catch (NoSuchProviderException e) {
		         e.printStackTrace();
		      } catch (MessagingException e) {
		         e.printStackTrace();
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		   }

		   public static void main(String[] args) {

		      String host = "pop.gmail.com";// change accordingly
		      String mailStoreType = "pop3";
		      String username = "pratik.rotterdam@gmail.com";// change accordingly
		      String password = "PratikManvi";// change accordingly

		      check(host, mailStoreType, username, password);

		   }

}
