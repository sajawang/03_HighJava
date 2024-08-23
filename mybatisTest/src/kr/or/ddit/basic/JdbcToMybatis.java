package kr.or.ddit.basic;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.LprodVO;

//JDBC예제 중 'JdbcTest05.java'를 MyBatis로 처리하기
public class JdbcToMybatis {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			int i1 = session.selectOne("jdbc.select1");
			
			String lprodGu="";
			int i2=0;
			do {
				System.out.println("select 작업시작");
				System.out.println("검색할 Lprod_gu 입력>> ");
				lprodGu = scan.next();
				i2 = session.selectOne("jdbc.select2",lprodGu);
				if(i2>0) {
					System.out.println("입력한 LPROD_GU인 " + lprodGu + "는(은) 이미 등록된 값 입니다.");
					System.out.println("다시 입력하세요...");
					System.out.println();
				}
				
			}while(i2>0);
			
			System.out.print("LPROD_NM값 입력 >> ");
			String nm = scan.next();
			
			LprodVO lvo = new LprodVO();
			lvo.setLprod_id(i1);
			lvo.setLprod_gu(lprodGu);
			lvo.setLprod_nm(nm);
			int insertCnt = session.insert("lprod.insertLprod", lvo);
			if(insertCnt>0) {
				session.commit();
				System.out.println("insert작업 성공!!!");
			} else {
				System.out.println("insert 작업 실패~~");
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		/*
		 * SqlSession session = null; try { session = MybatisUtil.getSqlSession(); int
		 * i1 = session.selectOne("jdbc.select1");
		 * 
		 * System.out.println(i1); } catch (Exception e) { e.printStackTrace(); }
		 * finally { session.close(); }
		 */

			
	}
}



































