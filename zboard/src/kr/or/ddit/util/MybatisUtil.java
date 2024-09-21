package kr.or.ddit.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//1. MyBatis의 환경 설정 파일(mybatis-config.xml)을 읽어와서 그 내용을 처리한 후 
//	처리된 결과를 갖는 SqlSessionFactory객체를 생성하고
//	SqlSession객체를 반환하는 메소드로 구생된 class 작성하기.
public class MybatisUtil {
	//SqlSessionFactory 객체 변수 선언
	static SqlSessionFactory sqlSessionFactory;
	
	static {	
		InputStream in = null;//스트림 객체 변수 선언
		try {
			
			//1-1 환경 설정 파일을 읽어올 스트림 객체 생성
			in = Resources.getResourceAsStream(
					"kr/or/ddit/project/config/mybatis-config.xml");
			
			//1-2 환경 설정 파일을 읽어와 환경 설정 작업을 수행하고 작업이 완료되면
			//		SqlSessionFactory 객체를 생성한다.
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
			
			
		} catch (Exception e) {
			System.out.println("MyBatis 초기화 실패");
			e.printStackTrace();
		} finally {
			if(in!=null) try {in.close();} catch (Exception e2) {}
		}
	}
	// SqlSession 객체를 생성해서 반환하는 메소드
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}

}