package mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//
//1.Session을 호출하여 객체를 생성합니다. Session.getDecaultInstance(properties)
//    여기서 properties에는 SMTP서버의 호스트 이름과 같은 중요한 속성이 모두 포함되어 있습니다.
//2. 이전 단계에서 얻은  MimeMessage객체를 전달하여 객체를 만듭니다.
//Session이 개체에는 이메일 수신자, 제목, 메시지본문, 첨부파일 등과 같은 다양한 속성 집합이 있습니다.
//3. 이메일이 객체가 될 수 있는 javax.mail.Transprot 정적 메소드를 호출하여 이메일을 보내는데 사용합니다.
//객체를 생성하기 위해 전달하는 속성 수는 Session SMTP 서버 유형에 따라 다릅니다.
//예를 들어 인증이 필요하지 않은 SMTP서버를 사용하는 경우 Session smtp와 같이 하나의 속성만 사용하여 객체를 생성할 수 있습니다.
public class Mail4 {
		public static void main(String[] args) {
			String to = "chltjgp1539@gmail.com"; //sender email
			String from = "praniel99@gmail.com"; //receiver email
			String host = "127.0.0.1";	//mail server host
			
			Properties properties = System.getProperties();
			properties.setProperty("mail.smtp.host", host);
			
			Session session = Session.getDefaultInstance(properties); //decault session
			
			try {
				MimeMessage message = new MimeMessage(session); //email message
				
				message.setFrom(new InternetAddress(from)); //setting header fields
				
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				
				message.setSubject("Test Mail from java Program");//subject line
				
				//actual mail body
				message.setText("You can send mail from Java program by using mail API,but you nee to couple of mor JAR files e.g. smtp.jar and activation.jar ");
				
				//Send message
				Transport.send(message);
				System.out.println("Email Sent successfully");
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}

}
