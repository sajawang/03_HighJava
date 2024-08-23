package JavaMail;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


/*
-------------------------------------------------------------------------------------

    참고 자료 : https://blog.naver.com/ghldbssla1997/222328725188
    그리고 채찍피티(Chatgpt)
  
-------------------------------------------------------------------------------------

의문점 : MimeBodyPart가  여러 개 사용되는 이유 

MimeBodyPart 객체가 여러 개 사용되는 이유는 이메일 메시지의 다양한 부분(본문, 첨부파일 등)을
별도로 구성하기 위해서입니다. 각 MimeBodyPart 객체는 이메일 메시지의 한 부분을 나타냅니다. 
예를 들어, 본문 내용은 하나의 MimeBodyPart로, 첨부파일은 또 다른 MimeBodyPart로 
각각 구성됩니다.

여기서 각 부분을 구성하는 과정을 더 자세히 설명하겠습니다:

1. 이메일 본문을 위한 MimeBodyPart:
  - 이메일의 텍스트 본문을 담고 있습니다.
  - MimeBodyPart 객체를 생성하여 본문 내용을 설정합니다.
  
2. 첨부파일을 위한 MimeBodyPart:
  - 이메일에 첨부될 파일을 담고 있습니다.
  - 별도의 MimeBodyPart 객체를 생성하여 파일을 첨부합니다.
  
 각 MimeBodyPart를 Multipart 객체에 추가하여 최종적으로 이메일 메시지를 구성합니다.
 이렇게 하면 이메일 본문과 첨부파일이 모두 포함된 이메일을 전송할 수 있습니다.

※ 이유 요약 : 
1. 분리된 구성: 각 부분을 독립적으로 설정하고 추가할 수 있습니다.
2. 유연성: 본문과 첨부파일 외에도 다른 유형의 콘텐츠(예: 이미지, HTML 본문 등)를 추가
                    할 수 있습니다.
3. 구조화: 이메일을 구조적으로 구성할 수 있어 유지보수 및 확장이 용이합니다.

따라서, MimeBodyPart 객체를 여러 개 사용함으로써 이메일의 각 부분을 명확하게 정의하고 
관리할 수 있습니다.

--------------------------------------------------------------------------------------

의문점 : messageBodyPart.setText와  message.setText중에서 messageBodyPart.setText가 적용되는 이유

이메일을 전송할 때 messageBodyPart.setText가 적용되는 이유는 이메일 본문과 첨부파일을 
포함한 모든 콘텐츠가 Multipart 객체에 추가되고, 최종적으로 이 Multipart 객체가 이메일
메시지(Message 객체)의 내용으로 설정되기 때문입니다. 반면, message.setText는
Multipart 객체를 설정하지 않을 때 간단한 텍스트 이메일을 구성할 때 사용됩니다.

이를 좀 더 구체적으로 설명해보겠습니다:

1. message.setText
  - message.setText 메서드는 이메일 메시지의 본문을 단순 텍스트로 설정합니다.
  - 이 메서드는 주로 텍스트만 포함된 단순한 이메일을 보낼 때 사용됩니다.
  - Multipart 객체를 사용하지 않기 때문에 첨부파일을 추가할 수 없습니다.
  
2. messageBodyPart.setText
  - messageBodyPart.setText 메서드는 MimeBodyPart 객체의 본문 내용을 설정합니다.
  - MimeBodyPart 객체는 Multipart 객체의 구성 요소로 사용됩니다.
  - Multipart 객체를 사용하면 본문 내용 외에도 첨부파일과 같은 다양한 콘텐츠를 추가할 수 있습니다.
  - 여러 MimeBodyPart 객체를 Multipart 객체에 추가하여 복잡한 이메일을 구성할 수 있습니다.
  
3. 적용 이유:
  - Multipart 객체가 설정된 경우, message.setContent(multipart) 메서드를
         사용하여 이메일 메시지의 내용을 Multipart 객체로 설정합니다.
  - Multipart 객체에는 여러 MimeBodyPart 객체가 포함되며, 각 MimeBodyPart
         객체는 본문 내용 또는 첨부파일을 나타냅니다.
  - 따라서 MimeBodyPart에 설정된 본문 내용과 첨부파일이 최종 이메일 메시지에 포함됩니다.
  
----------------------------------------------------------------------------------

	핸들과 핸들링

1. 핸들    : 운영 체제나 프로그램이 리소스를 식별하고 관리하는 데 사용하는 추상적이고 고유한 참조자입니다.
                     핸들은 포인터와 유사하게 작동하지만, 시스템 리소스를 직접 참조하지 않고,
                     이를 관리하는 시스템에서 간접적으로 참조합니다.
                  
2. 핸들러 : 프로그램이 핸들을 사용하여 특정 작업을 수행하거나 이벤트에 응답하는 과정을 의미합니다.
                     핸들링에는 주로 리소스 관리와 예외 처리가 포함됩니다.
                     
                     
ex) 식당이라는 객체가 있다고 가정하면 식당에서 일하는 사람은 요리사, 웨이터, 매니저가 있다.
	요리사는 요리를 하는 사람, 웨이터는 요리를 손님에게 가져다주는 사람이다.
	매니저는 요리나 서빙을 하지 않는데 매니저의 역할은 여기서 핸들러이다. 

----------------------------------------------------------------------------------
SSL TLS 보안
----------------------------------------------------------------------------------
 */

public class javaMailTest02 {
    public static void main(String[] args) {
        final String username    = "qudrnrrhdwb@naver.com";  // 발신자 이메일
        final String password    = "";  					  // 발신자 이메일 비밀번호
        final String recipient   = "rqr1109@naver.com, qudrnrrhdwb@naver.com";     // 수신자 이메일       | 여러 명을 수신할 때에는 , 를 사용해서 이메일 구분
        final String references  = "";     // 참조자 이메일       | 여러 명을 참조할 때에는 , 를 사용해서 이메일 구분
        final String hReferences = "";     // 숨김참조자 이메일 | 여러 명을 숨김참조할 때에는 , 를 사용해서 이메일 구분
                
        // SMTP 서버 설정
        Properties props = new Properties(); 			  // SMTP 서버 설정을 저장할 'Properties' 객체를 생성합니다.
        props.put("mail.smtp.auth", "true"); 			  // SMTP 서버 인증 사용
        props.put("mail.smtp.starttls.enable", "true");   // STARTTLS 명령 활성화 | 암호화된 연결을 설정하기 위해 필요
        props.put("mail.smtp.host", "smtp.naver.com");    // SMTP 서버 호스트 설정 | 'naver'의 SMTP 서버 사용
        props.put("mail.smtp.port", "587");				  // SMTP 서버 포트 설정 (TLS용) | SMTP서버와 통신하는 포트 설정  : naver나 gmail은 공통으로 "587" : TLS / "465" : SSL

        // 세션 생성
        Session session = Session.getInstance(props, new javax.mail.Authenticator() { // 설정된 속성을 사용하여 이메일 세션 생성 | 인증정보 제공함
            protected PasswordAuthentication getPasswordAuthentication() {			  // 이메일 서버 인증을 위한 'PasswordAuthentication'메소드 Override
                return new PasswordAuthentication(username, password);  			  // 발신자 이메일 계정 정보로 인증 | 사용자 이름과 비밀번호로 인증
            }
        });
        
        

        try { // 이메일 전송 시도
            // 메일 메시지 구성
            Message message = new MimeMessage(session); 	 // 새로운 이메일 메시지 객체 생성
            message.setFrom(new InternetAddress(username));  // 발신자 이메일 주소 설정
            message.setRecipients(Message.RecipientType.TO,  InternetAddress.parse(recipient));   // 수신자 이메일 주소 설정
            message.setRecipients(Message.RecipientType.CC,  InternetAddress.parse(references));  // 참조자 이메일 주소 설정
            message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(hReferences)); // 숨김참조자 이메일 주소 설정
            message.setSubject("김한비는 천재다 제목");  // 이메일 제목 설정
            String content = "김한비는 천재다<br>다음 줄로 가니??"; 		  // 본문 내용 설정 
            message.setText(content);  			  // 이메일 본문 설정 (첨부파일 미 설정시)
            
            // 첨부파일 설정
            Multipart multipart = new MimeMultipart(); 				  // 여러 개의 MimeBodyPart를 포함하는 Multipart 객체 생성  | 이메일의 본문과 첨부파일을 모두 포함할 수 있음
            /*
             * JavaMail API
             * MIME message
             * Multipurpose Internet Mail Extensions
             * 마임이라 읽음
             */
            MimeBodyPart messageBodyPart = new MimeBodyPart();        // MimeBodyPart 객체 생성 | 이메일 본문이나 첨부파일을 나타냄
            String filePath = "d://D_Other/test.txt"; 				  // 첨부파일 경로 정의
            DataSource source = new FileDataSource(filePath); 		  // 지정된 파일 경로를 사용하여 파일 데이터 소스를 생성 후 설정
            messageBodyPart.setDataHandler(new DataHandler(source));  // 파일 데이터 소스를 사용하여 데이터 핸들러를 생성 후 설정
            messageBodyPart.setFileName("file.txt"); 				  // 첨부파일의 이름을 설정
            multipart.addBodyPart(messageBodyPart);  				  // 첨부파일을 Multipart객체에 추가
            
            // 본문 설정 | 첨부파일 설정 시 
            messageBodyPart = new MimeBodyPart();   // 이메일 본문을 설정하기 위한 MimeBodyPart 객체 생성
            messageBodyPart.setText(content, "UTF-8");	    // 이메일 본문을 설정
            messageBodyPart.setHeader("content-Type", "text/html"); // 본문내용 HTML 설정
            multipart.addBodyPart(messageBodyPart); // 이메일 본문을 Multipart 객체에 추가

            // 메일에 멀티파트 설정(그냥 첨부파일 없이 보낼때는 필요 없다.)
            message.setContent(multipart); 			// 이메일 메시지에 Multipart 객체를 설정하여 본문과 첨부파일을 포함시킴
            
            
            // 메일 전송
            Transport.send(message); // 메시지 전송

            System.out.println("이메일 전송 성공!!!"); // 이메일 전송 성공 메시지 출력

        } catch (MessagingException e) { // 이메일 전송 중 예외가 발생할 경우 처리
            e.printStackTrace(); 		 // 예외 발생 시 스택 트레이스 출력
        }
    }
}