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

//common mail
public class EmailSender {

    public static void main(String[] args) {
        // SMTP server configuration
        String host = "www.naver.com"; // Replace with your SMTP server
        final String user = "chltjgp1539@naver.com"; // Replace with your email address
        final String password = "tjgP4kfkdgo!"; // Replace with your email password

        // Set up properties for the mail session
        Properties props = new Properties();
        
        /*SMTP서버와 연결할때 인증할때 사용
         * props -> java.util.Properties의 객체
         * put ->key와 value넣을때 사용
         * Key -> "mail.smtp.auth" : SMTP인증이 필요한지 구체화하기 위해 사용
         * Valaue -> true니까 SMTP인증이 필요하다는 것을 말한다
         * 
         * 목적 : SMTP(Simple Mail Transter Protocol)은 이메일을 보낼때 사용
         * 많은  SMTP서버는 메일보내기 전에 인증을 필요로 한다.
         * 인증은 이름, 비밀번호를 제공하는 것과 관련되어 있다.
         * 
         * 자바메일은 제공받은 이름과 비밀번호를 SMTP서버와 인증하는데 사용할거다
         * 이걸 통해 설정 ->
         * 				Session.getDefultInstance(properties, new Authenticator(){...})
         * 서버가 인증을 필요로 하고 이 property가 준비되지 않았다면, 이메일이 잘 안보내질거다.
         * 
         */
        props.put("mail.smtp.auth", "true");
        
        
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587"); // Use 465 for SSL

        // Get the default Session object
        /*
         * Session 오브젝트를 만들기 위함
         * Mail거야.
         * 자바메일을 만드는데 필수적
         * 
         * Session.getInstance(props, authenticator)
         * -> 구체적인 properties와 인증정보를 제공하기 위한 메소드
         * 
         * props는 SMTP서버호스트, 포트, 인증을 
         * authenticator은 Authenticator의 예시다
         * 
         * props는 Properties객체다. 인증 세팅을 가지고 있는.
         * properties에는 
         * 1.mail.smtp.host ->SMTP server address
         * 2.mail.smtp.port -> port number
         * 3.mail.smtp.auth ->인증이 필요한지 검사하는
         * 이런것들이 있다.
         * 
         * new Authenticator
         * 추상클래스다. 인증정보(SMTP서버에 들어가는) 를 받을 수 있는
         * 너는 제공하는데 익명의 Authenticator의 서브클래스와
         * getPasswordAuthentication메소드(PasswordAuthentication객체를 리턴하기 위해) 를 override한다 
         * 
         * getPasswordAuthentication()
         * PasswordAuthentication을 리턴하게 위해 오버라이드 당함
         * 이 객체는 이름과 비밀번호를 포함하는데 SMTP서버에 인증하기 위해
         * 
         * PasswordAuthentication(user,password)는 생성자이다.
         * PasswordAuthentication객체를 특정 이름과 비밀번호로 생성하기 위한!!
         */
        Session session = Session.getInstance(props,
        		//인증정보가져온다
            new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user, password);
                }
            });

        try {
            // Create a default MimeMessage object
            Message message = new MimeMessage(session);

            // Set From: header field
            message.setFrom(new InternetAddress(user));

            /*
             * message.setRecipients()
             * 수신자를 정한다. 두가지 매개변수 필요로 함
             * 1)Message.RecipientType.To
             * ->recipient의 타입을 구체화 한다.
             * ->enum임.
             * -> 수신자의 타입을 정의하는데 'TO' 'CC' 'BCC'같은(carbon copy, blind carbon copy)
             * 
             * 2)INternetAddress.parse()
             * ->이메일 주소를 InternetAddress배열로 parse한다
             */
            // Set To: header field
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("recipient@example.com")); // Replace with recipient's email address

            // Set Subject: header field
            message.setSubject("Test Email");

            // Set the actual message
            message.setText("This is a test email sent from a Java application.");

            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully...");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}






















