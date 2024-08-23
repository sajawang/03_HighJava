package JavaMail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/*
 * 
-------------------------------------------------------------------------------------

    참고 자료 : https://blog.naver.com/ghldbssla1997/222328725188
    그리고 채찍피티(Chatgpt)
    
-------------------------------------------------------------------------------------
    
1. SMTP (Simple Mail Transfer Protocol)
  - 간이 전자 우편 전송 프로토콜은 인터넷에서 이메일을 보내기 위해 이용되는 프로토콜이다.
  
2. 프로토콜 (Protocol)
  - 복수의 컴퓨터 사이나 중앙컴퓨터와 단말기 사이에서 데이터 통신을 원활하게 하기 위한 '통신 규약'이다.
  
-------------------------------------------------------------------------------------

 */

public class javaMailTest01 {
    public static void main(String[] args) {
        final String username = "qudrnrrhdwb@naver.com";  // 발신자 이메일
        final String password = "";                   	  // 발신자 이메일 비밀번호
        final String recipient = "gksql2421@nate.com";     // 수신자 이메일
        

        
        // SMTP 서버 설정
        Properties props = new Properties();             // SMTP 서버 설정을 저장할 'Properties' 객체를 생성합니다.
        props.put("mail.smtp.auth", "true");             // SMTP 서버 인증 사용
        // props.put("mail.smtp.ssl.enable", "true");    // SSL 사용시 | SSL 명령 활성화            | 암호화된 연결을 설정하기 위해 필요 
        props.put("mail.smtp.starttls.enable", "true");  // TLS 사용시 | STARTTLS 명령 활성화 | 암호화된 연결을 설정하기 위해 필요
        props.put("mail.smtp.host", "smtp.naver.com");   // SMTP 서버 호스트 설정              | 'naver'의 SMTP 서버 사용 | 구글이라면 ex) "smpt.naver.com" 
        props.put("mail.smtp.port", "587");              // SMTP 서버 포트 설정 (TLS용) | SMTP서버와 통신하는 포트 설정 
        												 // SSL 포트 : '465' | TLS 포트 : '587' | 기본포트 : '25' (보안성이 낮아 사용되지 않음) 

        // 세션 생성
        Session session = Session.getInstance(props, new javax.mail.Authenticator() { // 설정된 속성을 사용하여 이메일 세션 생성 | 인증정보 제공함
            protected PasswordAuthentication getPasswordAuthentication() {            // 이메일 서버 인증을 위한 'PasswordAuthentication'메소드 Override
                return new PasswordAuthentication(username, password);  			  // 발신자 이메일 계정 정보로 인증 | 사용자 이름과 비밀번호로 인증
            }
        });
        

        try { // 이메일 전송 시도
            // 메일 메시지 구성
            Message message = new MimeMessage(session); 	 // 새로운 이메일 메시지 객체 생성
            message.setFrom(new InternetAddress(username));  // 발신자 이메일 주소 설정
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));  // 수신자 이메일 주소 설정
            message.setSubject("제목입니다!");  // 이메일 제목 설정
            message.setText("내용입니다!");  	 // 이메일 본문 내용 설정 | 인코딩 설정

            // 메일 전송
            Transport.send(message); // 메일 전송

            System.out.println("이메일 전송 성공!!!"); // 이메일 전송 성공 메시지 출력

        } catch (MessagingException e) { 		 // 이메일 전송 중 예외가 발생할 경우 처리
            e.printStackTrace(); 				 // 예외 발생 시 스택 트레이스 출력
            System.out.println("이메일 전송 실패..."); // 이메일 전송 실패 메시지 출력
        }
    }
}