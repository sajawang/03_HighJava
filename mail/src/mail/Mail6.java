package mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail6 {
	public static void main(String[] args) {
		final String user = "chltjgp1539@gmail.com";//발신자의 이메일 아이디를 입력
		final String password = "tjgP4kfkdgo!";
		
		Properties prop = new Properties();
		prop.put("mail.smstp.host","smtp.gmail.com");
		prop.put("mail.smtp.port",465);
		prop.put("mail.smtp.auth","true");
		prop.put("mail.smtp.ssl.enable","true");
		prop.put("mail.smtp.ssl.trust","smtp.gmail.com");
		
		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user,password);
			}
		});
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			
			//수신자의 메일주소
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("chltjgp1539@gmail.com"));
			
			//Subject
			message.setSubject("제목을입력하세요");
			
			//Text
			message.setText("내용을 입력하세요");
			
			Transport.send(message);
			System.out.println("message sent successfully..");
		} catch(AddressException e) {
			e.printStackTrace();
		} catch(MessagingException e) {
			e.printStackTrace();
		}
	}
}






























