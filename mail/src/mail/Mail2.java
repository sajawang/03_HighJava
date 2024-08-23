package mail;

public class Mail2 {
	public static void main(String[] args) {
		
	}
	
	
	
	//1. 세션 생성
	//JavaMail API는 메일과 관련된 모든 작업을 처리하기 위해, 먼저 세션 생성
	//STMP와 관련된 세션을 생성하기 위해서는 SMTP 서버와 관련된 정보를 지정해 주어야 한다.
	//일반적으로  javaa.util.Properties 클래스를 사용하여 세션을 생성할때 필요한 값을 설정한 후
	//javax.mail.Session을 사용하여 세션을 생성한다
	/*
	 * <세션을 생성하는 코드>
	 * Properties prop = new Properties();
	 * *여기서 "mail.smtp.host"속성은 이메일 발송을 처리해줄 STMP서버를 나타낸다
	 * prop.put("mail.smtp.host", "mail.myHost.com");
	 * *여기서 "mail.smtp.user" 속성은 SMTP 서버에 있는 사용자의 계정(또는 아이디)를 나타낸다
	 * prop.put("mail.smtp.user","webmaster");
	 * 
	 * *Session 클래스의 getDefaultInstance()메소드는
	 * 	파라미터로 전달받은 Properties에 저장되어있는 속성값을 사용하여 세션을 생성한다.
	 * Session session = Session.getDefaultInstance(prop,null);
	 */
	
	//2.메시지 작성
	//세션을 생성했다면, 그 다음으로 해야 할 일은 메시지를 작성하는 것이다.
	//메시지 작성은 javax.mail.Message클래스를 통해서 이루어진다.
	//오늘날 사용되는 대부분의 이메일은 다양한  Mime 타입을 지원하기 때문에, MimeMessage클래스를 사용해야 할 것이다.
	//MimeMessage 클래스는 Message 클래스를 상속받았으며, 
	//Message 메시지는(즉, MimeMessage클래스는) 보내는 사람, 받는 사람, 제목, 내용과 같이 메일과 관련된 내용을 지정할 수 있도록 해준다.
	/*
	 * <MimeMessage 클래스를 사용하여 전송할 메시지를 작성하는 코드>
	 * MimeMessage message = new MimeMessage(session);
	 * InternetAddress from = new InternetAddress("webmaster@myHost.com");
	 *  **Message 클래스는  'setFrom()메소드->보내는 사람' 지정
	 * message.setFrom(from);
	 * 
	 *  *InternetAddress 클래스는 이메일 주소를 나타낼때 사용되는 클래스
	 *  *-> Message 클래스의 수취인과 발신인을 지정할떄 사용된다.
	 * InternetAddress to = new InternetAddress("era13@hanmail.net","beom-kyun");
	 * InternetAddress[] toList={to};
	 *  *Message 클래스는 'setRecipients()메소드->받는사람' 지정
	 * message.setRecipients(Message.RecipientType.TO,toList);
	 *  *Message클래스는 'setSubject()메소드->메시지 주제 설정'
	 * message.setSubject("mail subject");
	 *  *Message클래스는 'setContent()->메시지의 내용 설정'
	 * message.setContent("메일의 내용","text/plain");
	 *  *단순히 텍스트 뿐만 아니라  HTML형식을 비롯한 다양한 MIME 타입의 메일의 내용 지정
	 *   예를들어, HTML형식의 메일을 전송하고자 할 경우에는 다음과 같이 setContent()메소드를 호출하면 됨
	 *   message.setContent("메일내용....","text/html");
	 *   
	 *  *동시에 여러개의 MIME타입을 전송도 가능
	 *   이를 위해서는 MultiPart클래스를 사용하면 됨
	 *   이뿐만 아니라 다양한 형태의 데이터를 전송하기 위해 JavaBean Activation Framework API를 사용할 수도 있다
	 *   JAF API를 사용하면 파일 첨부와 같이 바이너리를 비롯한 모든 데이터를 원하는 형태로 전송가능
	 */
	
	//3.메시지 전송
	// 메시지 전송은 단순히 Transport클래스의 send()메소드를 호출함으로 이루어짐
	/*
	 * <메시지 객체인 message를 전송하는 방법 : Transport.send()메소드를 호출하면됨>
	 * Transport.send(message);
	 */
	
	//4.웹기반의 메일전송
	//많은 사이트에서 기본적으로 이메일 서비스 제공
	//이 사이트 들은 대부분 이메일 전송을 위해 SMTP를 사용함
	//대부분의 메일링리스트 역시 SMTP를 이용하여 메일을 발송함
	//몇몇 사이트는 게시판에 답변글이 올라올 경우 그 답변글을 메일로 전송하기도 함
	//이런 기능을 구현하기 위해서는 웹 어플리케이션이 메일을 전송할 수 있어야 한다.
	//웹 기반의 메일전송은 이 글의 앞에서 살펴본 내용만으로 충분히 구현할 수 있다.
	//최대한 간단하게 구현하기 위해 '메일의 내용을 입력할 수 있는 폼을 보여주는  MailInputForm.html' 구현
	//'메일을 전송해주는 sendMail.jsp' 구현
	
	/*
	 * HTML 참고!!(vscode에 있음)
	 */
}










































































