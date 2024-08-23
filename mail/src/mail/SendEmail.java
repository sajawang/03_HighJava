package mail;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//java mail
public class SendEmail {

    public static void main(String[] args) {
        // Sender's email ID needs to be mentioned
        String from = "your-email@example.com";
        final String username = "your-email@example.com"; // change accordingly
        final String password = "your-email-password"; // change accordingly

        // Assuming you are sending email through smtp.example.com
        String host = "smtp.example.com"; // or smtp.gmail.com for Gmail

        /*System.getProperties()는 static method다( system클래스의, 리턴값Properties)
         * 리턴값 propertiese(현재 시스템의 properties를 나타내는)
         * 이때는 new쓰지 않는다. (왜냐하면 이 메소드는 참조를 제공하기 위해 디자인 되었기 때문)
         * 
         */
        // Get system properties
        Properties properties = System.getProperties();

        /*
         * Properties class의 목적 : key-value쌍을 관리하기 위해
         * 1.properties : 클래스의 객체. 키와 밸류값이 모두 string일때 그 값을 저장
         * 2.setProperty(String key, String value)메소드. property를 
         *  "mail.smtp.host"는 SMTP서버호스트를 구체화하기 위해 사용
         *  뒤에 온 host는 host이름(SMTP서버의) 
         */
        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "587"); // or the appropriate port
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true"); // For secure connection

        /*
         * 1.Session클래스는 JavaMailAPI의 일부이다.
         * 
         * 1.Session.getDefaultInstance(Properties props, Authenticator auth)
         * 는 Session객체를 반환한다.
         * properties->컴퓨터 구성(SMTP서버 세팅과 같은)
         * auth->인증정보
         * 
         * 2.new Authenticator()
         * 익명 내부클래스. (extends Authenticator)
         * ->getPasswordAuthentication() 메소드를제공한다.
         * -> 이 메소드는 이름과 비밀번호를 필요로함(인증을 위함
         */
        // Get the default Session object
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
        	/*
        	 * MimeMessage클래스는 이메일 메시지를 나타낸다
        	 * 
        	 * 1. Session 객체는 구조 정보를 갖고 있다.(SMTP host, port, and authentication details.같은)
        	 * 		MimeMessgae를 session을 이용해서 만들면
        	 * 		이 세션은 메시지가 적절하게 구성되었는지 보장해준다.
        	 * 
        	 * 2. MIME(Multipurpose Internet Mail Extension)표준에 따라 이메일을 다루기 위함
        	 * 	이 클래스는 첨부, html, 여러명의 수신인 기능을 지원
        	 * 
        	 * 3. 
        	 */
            // Create a default MimeMessage object
            MimeMessage message = new MimeMessage(session);

            // Set From: header field
            message.setFrom(new InternetAddress(from));

            // Set To: header field
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("recipient@example.com"));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is the actual message");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
