package commonsEmail;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class commonsEmail03 {

    public static void main(String[] args) {
    	/*
    	 * 이메일에 첨부파일이 있을때 사용
    	 * 목적 : 파일을 추가하는 것을 간소화시킴
    	 */
        EmailAttachment attachment = new EmailAttachment();		// EmailAttachment클래스의 인스턴스 생성 | 이메일에 첨부할 파일을 설정하는 데 사용
        attachment.setPath("d:\\D_Other\\test.txt"); 			// 첨부 파일의 경로를 설정
        
        /*
         * 배치타입을 설정할 때 쓴다.
         * 1)attachment : traditional email attachment
         * 2)inline : displayed within the body of the email
         */
        attachment.setDisposition(EmailAttachment.ATTACHMENT);	// 첨부 파일의 배치를 설정
        //컴퓨터가 알 수 있게
        attachment.setDescription("test.txt");
        attachment.setName("test.txt"); 						// 첨부 파일의 이름을 설정

        MultiPartEmail email = new MultiPartEmail();			// MultiPartEmail 클래스의 인스턴스 생성 | 여러 부분으로 구성된 이메일(텍스트, 첨부파일 등)을 전송하는 데 사용
        email.setCharset("euc-kr");								// 이메일 본문의 한글이 깨지지 않도록 이메일의 문자 인코딩을 euc-kr로 설정
        email.setHostName("smtp.naver.com"); 					// 이메일을 전송할 SMTP 서버를 설정 | 네이버 SMTP 서버 설정
        email.setSslSmtpPort("465"); 							// SSL 포트 | 네이버 SMTP 포트 465를 사용
        email.setSSLOnConnect(true); 							// SSL 사용하여 SMTP 서버에 연결하도록 설정 | 이메일 전송 시 보안 강화 
        email.setAuthentication("qudrnrrhdwb@naver.com", "");   // 네이버 계정 인증 (아이디, 비밀번호)

        try {
        	email.addTo("rqr1109@naver.com"); 					// 수신자 이메일 설정 (수신자 이메일) | 수신자 이름이 없으면 이메일로 출력
            email.addTo("rqr1109@naver.com",  "수신자이름"); 		// 수신자 이메일 설정 (수신자 이메일, 수신자 이름) | 수신자 이름이 있으면 수신자이름으로 출력
            email.addTo("qudrnrrhdwb@naver.com",  "수신자이름"); 	// 여러 명의 수신자 이메일 설정 (수신자 이메일, 수신자 이름)
            email.addCc("qudrnrrhdwb@naver.com",  "참조자이름"); 	// 참조자 이메일 설정 (수신자 이메일, 수신자 이름)
            email.addBcc("qudrnrrhdwb@naver.com", "숨김참조자이름"); // 숨김참조자 이메일 설정 (수신자 이메일, 수신자 이름)
            email.setFrom("qudrnrrhdwb@naver.com", "보내는사람");  // 발신자 이메일 설정 (발신자 이메일, 발신자 이름)
            email.setSubject("첨부 파일 테스트 메일입니다.");				// 이메일 제목 설정
            email.setMsg("이건 내용입니다.");						// 이메일 본문 내용 설정

            email.attach(attachment);   
            email.send();										// 이메일 전송

            System.out.println("이메일 전송에 성공하였습니다.");			// 이메일 전송 성공 메시지
        } catch (EmailException e) {							// 'EmailException'이 발생할 경우 catch 블록 시작
            e.printStackTrace();								// 예외가 발생한 경우 예외의 스택 추적을 콘솔에 출력
            System.out.println("이메일 전송에 실패하였습니다: " + e.getMessage());	// 이메일 전송 실패 메시지와 예외 메시지 출력
        }
    }
}