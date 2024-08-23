package mail;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;


//주제 : POP3CFecher.java
//내용 : 일정한 시간 간격으로  POP3 호스트를 검사해서 새로 수신된 메일이 있을 경우 그 메일을 읽어온다.
//단계 : 
//1. Session 객체 구함
//2. 알맞은 프로토콜을 사용하여 호스트에 접속(Store 객체 사용)
//3. 메일이 저장된 폴더 구함(Folder 객체 사용)
//4. Folder로부터 Message 객체 구함
//5. Message 출력
//6. 읽어온 메시지를 호스트에서 삭제한다.
public class Mail1 {
	public static void main(String[] args) {
		
	}
	
	public void process() throws Exception{
		//Session객체를 구한다
		java.util.Properties sysProperties =System.getProperties();
		Session session = Session.getDefaultInstance(sysProperties,null);
		session.setDebug(true); //디버깅 정보를 화면에 보여준다.
		
		//POP3 호스트에 접속한다.
		Store store = session.getStore("pop3");
		store.addConnectionListener(pop3Host,-1,user,password);
		
		//기본폴더를 구한다
		Folder folder = store.getDefaultFolder();
		if(folder==null) {
			throw new NullPointerException("디폴트 메일 폴더 없음");
			
		//INBOX 폴더를 구한다.
		folder=folder.getFolder("INBOX");
		if(folder==null) 
			throw new NullPointerException("INBOX 폴더를 구할 수 없음");
		
		//메시지 개수를 구한다.
		folder.open(Folder.READ_WRITE);
		int totalMessages = folder.getMessageCount();
		if(totalMessages==0) {
			System.out.println(folder+"가 비었습니다.");
			folder.close(false);
			store.close();
			return;
		}
		
		//각 메시지의 속성과 플래그를 구한다.
		Message[] messages = folder.getMessages();
		FetchProfile fp = new FetchProfile();
		fp.add(FetchProfile.Item.ENVELOPE);
		fp.add(FetchProfile.Item.FLAGS);
		fp.add("X-Mailer");
		folder.fetch(messages,fp);
		
		for (int i = 0; i < messages.length; i++) {
			if(!messages[i].isSet(Flags.Flag.SEEN)) {
				printMessage(messages[i]);
			}
			
			//읽어온 메시지를 호스트에서 삭제한다.
			messages[i].setFlag(Flag.FLAGGED.DELETED,true);
		}
		
		folder.close(true);
		store.close();
			
			
		}
		
	}

	
	//주제 : 파라미터로 전달받은 Message객체를 화면에 출력해주는 부분
	private void printMessage(Message message) throws Exception {
		String replyTo = null, subject;
		Object content;
		java.util.Date sentDate;
		Address[] a = null;
		
		if( (a=message.getFrom()) != null ) replyTo = a[0].toString();
		
		subject = message.getSubject();
		sentDate = message.getSentDate();
		DataHandler dataHandler = message.getDataHandler();
		String contentType = dataHandler.getContentType();
		
		System.out.println("=====================");
		System.out.println("보낸사람 : "+replyTo);
		System.out.println("보내시각 : "+sentDate);
		System.out.println("주제 : "+subject);
		System.out.println("=====================");
		
		
		//DataHndler의 객체가 처리하고있는 데이터 타입이 "text/html"이거나 "text/plain"인 경우에 화면에 출력하도록
		if( ( contentType.indexOf("text/html") != -1 ) || ( contentType.indexOf("text/plain") != -1)) {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(
							dataHandler.getInputStream()));
			char[] buff = new char[512];
			int len;
			while( (len = br.read(buff)) != -1) {
				System.out.print( new String(buff,0,len) );
			}
			br.close();
		}
		System.out.println("\n==================\n");
	}
	
}












































