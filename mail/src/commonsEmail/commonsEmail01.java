package commonsEmail;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/*
 * 참고 : POP3, IMAP은 이메일 회사마다 방식이 다르다 (참고로 지메일이랑 네이버는 이거 두개 다 씀, outlook은 POP3만 씀)
 */
public class commonsEmail01 {

    public static void main(String[] args) {
    	/*
    	 * SimpleEmail 클래스 : Apache Commons Email library를 제공
    	 *  - Email 클래스를 extends한다. (상속) 
    	 *  - SimpleEmail : 글자만 보낼 수 있다.
    	 */
    	SimpleEmail email = new SimpleEmail();	//  SimpleEmail클래스의 인스턴스 생성  | 이메일을 구성하고 전송하는데 사용
        
    	/*
         * smtp.naver.com ->SMTP server for Naver (각 Email provider has its own SMTP server)
         * 				  ->SimpleEmail 객체가 메일을 보내기 위해 NAVER의 SMTP서버를 사용한다는 것을 말한다
         * 				  ->메일을 보내기 위해선 어떤 SMTP서버를 사용할지 알아야 하기 때문에 중요(없다면 어디로 메일 보내야할지 모름)
         */
        email.setHostName("smtp.naver.com");    // 이메일을 전송할 SMTP 서버를 설정 | 네이버 SMTP 서버 설정
       
        /*
         * 1.SMPT Port
         * 1)Port->communication endpoint다.
         * 		 ->각기 다른 port들은 다양한 네트워크 서비스들들을 위해 사용됨
         * 2)SMTP Port -> 이메일을 보낼때 나의 응용프로그램은 구체적인 port를 통해 SMTP서버에 연결된다.
         * 			   -> Port 번호는 서버에게 말해준다. 어떤 종류의 연결이나 서비스가 요청될지
         * 
         * 2.Secure(보안) Email Transmission(전달)
         * 1)SSL(Secure Sockets Layer) ->둘다 앱과 SMTP서버와의 연결을 암호화하기 위해 사용된다.
         * 2)TLS(Transport Layer Security) ->이메일과 다른 어떤 민감 정보들(로그인정보) 악의있는 가로채기가 안되도록 보장한다
         * 
         * 3.Port465
         * 1)보통 SSL을 활용한 SMTP에 사용됨 ->465로 포트를 설정하면 암호화해서 메일이 보내지도록 지정하는 것이다.
         * 2)어떤 email provider들은 SSL이나 TLS를 필요로 한다. client와 SMTP사이의 대화를 지키는걸 가능하게 하기 위해.
         */
        email.setSslSmtpPort("465");            // SSL 포트 | 네이버 SMTP 포트 465를 사용
        
        /*
         *  위,아래코드 차이점 : 465는 SSL을 활성화시키지는 않는다. 포트만 지정해주는 것 뿐.
         *  			   아래코드는 SSL연결을 실제로 활성화시킨다. 아래 코드가 보안 연결을 위한 키 메소드다!
         */
        email.setSSLOnConnect(true);            // SSL 사용하여 SMTP 서버에 연결하도록 설정 | 이메일 전송 시 보안 강화 
        
        /*
         *SMTP서버에서 메일을 보낼때 인증정보(아이디, 패스워드)를  설정하기 위해 사용.
         *이메일을 보낼때는 메일서버와의 인증을 통해 너가 인정을 받았는지를 종종 필요로 한다.
         *보장하기 위해 너가 인증되었는지 메시지를 보내기 위해 그것을 통해
         */
        email.setAuthentication("qudrnrrhdwb@naver.com", ""); // 네이버 계정 인증 (아이디, 비밀번호)

        try {
            email.addTo("gksql2421@nate.com", "강병국");       // 수신자 이메일 설정 (수신자 이메일, 수신자 이름)
            email.setFrom("qudrnrrhdwb@naver.com", "국병강"); // 발신자 이메일 설정 (발신자 이메일, 발신자 이름)
            email.setSubject("조소희에게 보내보겠습니다!");			// 이메일 제목 설정
            email.setMsg("안녕하세요 조소희씨 ^-^ 바보");			// 이메일 본문 내용 설정
            email.send();									// send() 메소드 | 이메일 전송
            
            System.out.println("이메일 전송에 성공하였습니다.");		// 이메일 전송 성공 메시지
        } catch (EmailException e) {
            e.printStackTrace();
            System.out.println("이메일 전송에 실패하였습니다: " + e.getMessage()); // 이메일 전송 실패 메시지
        }
    }
}


















