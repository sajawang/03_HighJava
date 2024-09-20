package kr.or.ddit.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.CustomerServiceImpl;
import kr.or.ddit.service.ICustomerService;
import kr.or.ddit.vo.CustomerVO;
import kr.or.ddit.vo.MemberVO;

/**
 * Servlet implementation class PasswordFind
 */
@WebServlet("/newPassword.do")
public class NewPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	System.out.println("1");
    	
    	//입력받은 email와 이름 가져오기
    	String id = (String)request.getParameter("id");
    	String email = (String)request.getParameter("mail");
//    	String name = (String)request.getAttribute("userName");
//    	String email = (String)request.getAttribute("userEmail");
    	
    	System.out.println("2");
    	System.out.println(id);
    	System.out.println(email);
//이메일 보내기 할려면 2단계 인증을 풀어야함
    	
    	//여기서 랜덤값 생성시킨 후에 전송보내는 내용으로 랜덤변수를 전달한다.
    	//파라미터를 String email로 받아서 보내는 아이디에 넣고
    	//비밀번호에 랜덤번호와 아이디가 일치하면 로그인 수행을 한다.
    	
    	//랜덤 인증번호 생성 - 
    	int ran = (int)(Math.random()*888888)+111111;
    	
    	String num = String.valueOf(ran);
    	
    	ICustomerService service = CustomerServiceImpl.getInstance();
    	
    	//아이디와 이메일 세팅하고 비밀번호를 검색했을때 1 이 나오면 그때 비밀번호를 수정한다.
    	
    	MemberVO memVo = new MemberVO();
    	memVo.setCus_id(id);
    	memVo.setMem_mail(email);
    	
    	int cnt = service.newPassIdCheck(memVo);
    	
    	System.out.println("cnt 값 체크"+ cnt);
    	
    if(cnt==1) {
    	
    	System.out.println("아이디 체크 성공");
    	
    	
    	CustomerVO cusVo = new CustomerVO();
    	cusVo.setCus_pw(num);
    	cusVo.setCus_id(id);
    	
    	
//    	cusVo.setCus_id(name);
//    	cusVo.setCus_pw(num);
    	
    	//아이디와 이메일을 받고 memberVO의 id에 해당하는 password를 업데이트한다.

    	int upt = service.newPassUpdate(cusVo);
    	
    	request.setAttribute("newPass", num);
    	
    	System.out.println("업뎃"+upt);
    	
        final String username = "dltjr6834@naver.com";  // 발신자 이메일
        final String password = "cool683427";                   	  // 발신자 이메일 비밀번호
//        final String recipient = "dltjr6834@naver.com";     // 수신자 이메일
        final String recipient = email;     // 수신자 이메일
        
        // SMTP 서버 설정
        Properties props = new Properties();    		// SMTP 서버 설정을 저장할 'Properties' 객체를 생성합니다.
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
            message.setSubject("비밀번호 찾기에 대한 메일입니다.");  // 이메일 제목 설정
            message.setText(id+"님의 해당 아이디 임시 비밀번호는 "+num+ "입니다. 해당번호가 외부에 유출되지 않도록 주의해주시고 비밀번호를 변경하시길 바랍니다.");  	 // 이메일 본문 내용 설정 | 인코딩 설정
 
            // 메일 전송
            Transport.send(message); // 메일 전송

            System.out.println("이메일 전송 성공!!!"); // 이메일 전송 성공 메시지 출력

        } catch (MessagingException e) { 		 // 이메일 전송 중 예외가 발생할 경우 처리
            e.printStackTrace(); 				 // 예외 발생 시 스택 트레이스 출력
            System.out.println("이메일 전송 실패..."); // 이메일 전송 실패 메시지 출력
        }
    	
        request.setAttribute("result", cnt);

//		request.getRequestDispatcher("/boardView/result.jsp").forward(request, response);
		request.getRequestDispatcher("/WEB-INF/view/LoginInsertUserMember/result.jsp").forward(request, response);

    }
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
