package kr.or.ddit.basic;

import org.apache.log4j.Logger;

public class Log4jTest {
	static Logger logger = Logger.getLogger(Log4jTest.class);
	
	public static void main(String[] args) {
		// 로그 메시지 설정하기
		// 형식 ) Logger객체.로그레벨명("출력할 메시지");
		
		logger.trace("이 메시지는 TRACE모드의 로그 메시지 입니다...");
		logger.debug("DEBUG레벨의 메시지 입니다..");
		logger.info("INFO레베르이 메시지는 INFOMATION을 의미합니다...");
		logger.warn("WARN은 경고 메시지를 주로 지정합니다...");
		logger.error("ERROR레벨은 오류에 대한 메시지를 지정합니다...");
		logger.fatal("FATAL레벨은 아주 심각한 오류에 대한 메시지를 지정합니다...");
	}
}
