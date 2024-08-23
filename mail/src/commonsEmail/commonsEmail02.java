package commonsEmail;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class commonsEmail02 {

    public static void main(String[] args) throws EmailException {
    	/*
    	 * 이메일을 보낼때 HTML내용이 포함되어 있다면 보통 Apache Commons Email라이브러리를 쓴다.
    	 * HTML email을 보낼때 특화되어있는 클래스이다.
    	 * 1)기본적인 이메일 클래스 : SimpleEmail, HTMLEmail 클래스 등
    	 *   -> 유용성 : 이미지, 스타일처리된 문자, 표, 링크 등을 포함한 무거운 이메일을 보낼때 유용함
    	 * 2)인라인 이미지를 추가(본문에 이미지 바로 넣는 기능), 첨부 기능 등을 지원한다.  
    	 */
    	HtmlEmail email = new HtmlEmail();					    // HtmlEmail클래스의 인스턴스 생성 | HTML 형식의 이메일을 구성하고 전송하는 데 사용
        email.setHostName("smtp.naver.com");       			    // 이메일을 전송할 SMTP 서버를 설정 | 네이버 SMTP 서버 설정
        email.setSslSmtpPort("465");               			    // SSL 포트 | 네이버 SMTP 포트 465를 사용
        email.setSSLOnConnect(true);               			    // SSL 사용하여 SMTP 서버에 연결하도록 설정 | 이메일 전송 시 보안 강화 
        email.setAuthentication("qudrnrrhdwb@naver.com", "");   // 네이버 계정 인증 (아이디, 비밀번호)

        /*
         *문자encoding을 구체화하기 위해 사용.
         *euc-kr은 한국어를 인코딩을 하기 위해 사용.
         *(extended unix code for korean)
         */
        /*
         * utf-8 and euc-kr : 둘다 써도 상관 노노?
         * html보낼때도 안써도 상관 노노??
         */
        //인코딩 형식 -> 본문의 내용이 깨지지 않게 하기 위해
        email.setCharset("euc-kr");

        try {
        	email.addTo("rqr1109@naver.com", "받는사람"); 			// 수신자 이메일 설정 (수신자 이메일, 수신자 이름)
        	email.setFrom("qudrnrrhdwb@naver.com", "보내는사람");  // 발신자 이메일 설정 (발신자 이메일, 발신자 이름)
        	email.setSubject("HTML 테스트 메일입니다.");				// 이메일 제목 설정
        	
        	/*
        	 * Apache Commons Email에서 HTML로 이메일 내용을 설정하기 위해 사용
        	 * 이미지, 링크, 등 무거운 메일을 처리할때 사용
        	 * 1) HTML태그를 사용한 이메일(헤더,문단,리스트,표,폰트스타일,색깔)
        	 * 2) 링크 버튼, 이미지와 동영상 등을 보내기 가능.
        	 */
        	email.setHtmlMsg("<html>아파치 로고 - <img src=\"http://www.apache.org/images/asf_logo_wide.gif\"></html>"); // 이메일 본문 내용 설정(HTML태그를 적용)
        	email.send(); // 이메일 전송
            
            System.out.println("이메일 전송에 성공하였습니다.");  					// 이메일 전송 성공 메시지
        } catch (EmailException e) {										// 'EmailException'이 발생할 경우 catch 블록 시작
            e.printStackTrace();
            System.out.println("이메일 전송에 실패하였습니다: " + e.getMessage());	// 이메일 전송 실패 메시지와 예외 메시지 출력
        }
    }
}






















