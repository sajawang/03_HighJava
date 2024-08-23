package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil2;
import kr.or.ddit.util.DBUtil3;

/*
 * 회원을 관리하는 프로그램을 작성하시오.(MYMEMBER 테이블 이용)
 * 
 * 	아래의 메뉴의 기능을 모두 구현하시오.(CRUD 기능 구현하기)
 * 메뉴 예시)
 * 	==작업 선택==
 *  1.자료 추가 -->insert-c
 *  2.자료 삭제 -->delete-d
 * 3.자료 수정 -->update-u
 * 4.전체 자료 출력 -->select-r
 * 0.작업 끝...
 * =========
 * 
 * 조건)
 * 1. 자료 추가에서 '회원ID'는 중복되지 않는다. (중복되면 다시 입력 받는다.)
 * 2. 자료 삭제에서는 '회원ID'를 입력받아서 처리한다.
 * 3. 자료 수정에서 '회원ID'는 변경되지 않는다. 
 * 
 */
public class JdbcTest07 {
	
	private Scanner scan = new Scanner(System.in);
	/*
	 * 선언되고 null로 초기화된 상태
	 * 이 자원들이 try-catch-finally로 관리되는것이 보장되는것이 필요하다
	 * 만약 nullpointexception이 발생했다면 
	 * -> 이 변수들 하나가 초기화되지 않았거나
	 * -> 값을 할당하기 전에 사용을 해버려서 그렇다.
	 */
	
	/*
	 * 이것은 나타내는데 database로의 연결을
	 * conn이 null이면 이것은 데이터베이스로의 연결이 적절히 생성되지 않았다는 것을 말한다
	 */
	Connection conn = null;
	
	/*
	 * 이것은 나타내는데 미리 컴파일된 SQL구문이라는 것을
	 * 만약 pstmt가 null이면 이것은 SQL구문이 준비되지 않았다는 것을 실행전에.
	 */
	PreparedStatement pstmt = null;
	
	/*
	 * 이것은 나타내는데 결과 집합을
	 * 쿼리를 실행하면서 얻어진
	 * rs가 null이라면 이것은 의미하는데 쿼리가 실행되지 않았다는 것을
	 */
	ResultSet rs = null;
	
	
	/*
	 * nullpointexception이 발생하는 주요 이유
	 * 1. 연결문제 : conn변수가 null이라면 이슈를 가지고 있을 수 있는데(데이터베이스 연결)
	 * 			-> 이것은 잘못된 신임장?, 데이터베이스 URL이 없거나, 네트워크 이슈일 수 있음
	 * 2. SQL 준비되지 않은 문제 : pstmt가 null이라면 이것은 SQL구문의 준비문제 일 수 있다.(구문에 오타가 난다던지...)
	 * 
	 * 3. Result Set문제 : rs가 null이라면 이것은 나타내는데 쿼리가 실행되지 않았따는 것을.
	 * 					-> 아니면 잘못된 메소드가 불러졌다던지(excuteUpdate()와 executeQuery()를 혼용해서 사용한 경우)
	 */
	
	/*
	 * nullpointException을 피하는 방법
	 * 1. 연결을 체크하자 : conn이 잘 만들어졌는지 확인하자
	 * 2. 쿼리를 잘 준비하자 : pstmt를 확인하자.
	 * 3. 올바른 메소드를 사용하자 : executeQuery()는 select에만, executeUpdate()는 insert,update,delete에만
	 * 4. 항상 자원들을 닫자 : rs, pstmt, conn을 finally구문에서 꼭 닫도록 하자. 자원들이 세거나 예외 문제가 일어나는것을 막을 수 있다!!
	 */
	public static void main(String[] args) {
		new JdbcTest07().testStart();
	}

	private void testStart() {
		
		
		while(true) {
			int choice = displayMenu();
			switch(choice) {
			case 1: //추가
				insert();
				break;
			case 2: //삭제
				delete();
				break;
			case 3: //전체 항목 수정
				update();
				break;
			case 4: //전체자료 출력
				displayAll();
				break;
			case 5://자료수정2 ==>원하는 항목 1개만 수정
				update1();
				break;
			case 0: //종룔
				System.out.println("작업 끝..");
				break;
			default:
				System.out.println("번호를 잘못입력했습니다");
				System.out.println("다시선택하세요");
			}
		}
	}

	private void update1() {
		System.out.println("수정할 아이디를 입력>>");
	    String id = scan.next();
	    
	    int count = getMemberCount(id);
	    
	    if(count==0) {
	    	//없는 회원이면
	    	System.out.println(id+"는 없는 회원id입니다");
	    	System.out.println("수정작업을 마칩니다...");
	    	return;
	    }
		
	    
	    int num; //선택한 항목 번호가 저장될 변수
	    String updateField=null;	//변경할 컬러명이 저장될 변수
	    String titleMsg = null;	//변경할 값을 입력 받을 때 나타나는 메시지가 저장될 변수
	    
	    do {
			System.out.println();
			System.out.println("수정할 항목을 선택하세요");
			System.out.println("1.비밀번호 2.회원이름 3.전화번호 4.회원주소");
			System.out.println("---------------------");
			System.out.println("수정할 항목 선택>> ");
			num = scan.nextInt();
			
			switch (num) {
			case 1: updateField="mem_pass"; titleMsg="비밀번호"; break;
			case 2: updateField="mem_name"; titleMsg="회원이름"; break;
			case 3: updateField="mem_tel"; titleMsg="전화번호"; break;
			case 4: updateField="mem_addr"; titleMsg="회원주소"; break;
			default: System.out.println("수정할 항목 선택이 잘못되었습니다. 다시 선택하세요.");
			}
		} while (num<1 || num>4 );
	    
	    System.out.println();
	    System.out.println("새로운"+titleMsg+"입력>> ");
	    scan.nextLine();//입력버퍼 비우기
	    String updateData = scan.nextLine();

	    try {
			conn=DBUtil.getConnection();
			String sql="update mymember set "+updateField+" = ? where mem_id= ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setNString(1, updateData);
			pstmt.setNString(2, id);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println("수정작업완료!!!");
			} else {
				System.out.println("수정작업 실패");
			}
	    } catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try { if(pstmt != null) pstmt.close(); } catch (SQLException e) {}
			try { if(conn != null) conn.close(); } catch (SQLException e) {}
		}
		
	}

	private void displayAll() {
		try {
			//연결을 만든다!!!
			//conn=DBUtil.getConnection();
			//conn=DBUtil2.getConnection();
			conn=DBUtil3.getConnection();
			
			//SQL구문을 준비한다!!!!(preparing)
			String sql="select * from mymember";
			pstmt = conn.prepareStatement(sql);
			
			/*
			 * pstmt.executeQuery() -> 검색하는 SQL을 실행한다.(SELECT 구문 같은) 
			 * pstmt.executeUpdate() -> 데이터베이스를 modify(수정)할때 사용(insert,update,delete) 
			 */
			
			//쿼리를 실행하고  result set을 얻는다!!!!
			rs = pstmt.executeQuery();
			
			System.out.println();
			System.out.println("\t===검색결과===");
			System.out.println("아이디\t비밀번호\t이름\t전화번호\t주소");
			System.out.println("-----------------------------");
			
			//result set을 처리한다!!
			while(rs.next()) {
				//result set으로부터 데이터를 추출한다
				String id = rs.getString("mem_id");
				String pa = rs.getNString("mem_pass");
				String name = rs.getString("mem_name");
				String tel = rs.getNString("mem_tel");
				String addr = rs.getNString("mem_addr");
				
				System.out.println(id+"\t"+pa+"\t"+name+"\t"+tel+"\t"+addr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch (SQLException e) {}
			try { if(pstmt != null) pstmt.close(); } catch (SQLException e) {}
			try { if(conn != null) conn.close(); } catch (SQLException e) {}
		}
		
		
	}

	private void update() { // ==>전체 항목 수정하기
	    System.out.println("수정할 아이디를 입력>>");
	    String id = scan.next();
	    
	    int count = getMemberCount(id);
	    
	    if(count==0) {
	    	//없는 회원이면
	    	System.out.println(id+"는 없는 회원id입니다");
	    	System.out.println("수정작업을 마칩니다...");
	    	return;
	    }
	    
	    System.out.println("패스워드>>");
	    String pa = scan.next();

	    System.out.println("이름>> ");
	    String name = scan.next();
	    
	    System.out.println("전화번호>>");
	    String tel = scan.next();
	    
	    scan.nextLine();//입력 버퍼 비우긱
	    System.out.println("주소>>");
	    String addr = scan.nextLine();
	    
	    try {
	    	//Establishing the connection!!!!!!!!!!!!!!!!!!!!!
	        conn = DBUtil.getConnection();
	        
	        //Preparing the SQL statement!!!!!!!!!!!!!!!!!!!!!!!!
	        String sql = "UPDATE mymember SET mem_pass = ?, mem_name = ?, mem_tel = ?, mem_addr = ? WHERE mem_id = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, pa);
	        pstmt.setString(2, name);
	        pstmt.setString(3, tel);
	        pstmt.setString(4, addr);
	        pstmt.setString(5, id);
	        
	        //Executing the query and obtaining the result set!!!!!!!!!!!!!!!!!!!!!!!!!!
	        int cnt = pstmt.executeUpdate();
	        
	        if (cnt > 0) {
	            System.out.println("수정 작업 성공!");
	        } else {
	            System.out.println("수정 작업 실패!");
	        }
	    } catch (SQLException e) {
	    	// 메소드임
	    	/*
	    	 * print하기 위해 사용됨. stack traced의 
	    	 * 
	    	 * e -> 나타내는데. 예외 객체를. catch에서 나온.
	    	 * 	 -> e 타입은 다양화되는데 의존하는 예외를. (보통 sqlexception, ioexception,exception)
	    	 * 
	    	 * pringtStackTrace() ->메소드이다. Throwable클래스에서 사용가능한
	    	 * 					  -> stack trace란 프로그램의 실행 과정에서 호출된 메서드들의 순서와 위치 정보를 나타내는 것.
	    	 */
	        e.printStackTrace();
	    } finally {
	        try { if (pstmt != null) pstmt.close(); } catch (SQLException e) {}
	        try { if (conn != null) conn.close(); } catch (SQLException e) {}
	    }
	}


	private void delete() {
		System.out.println("삭제할 아이디를 입력>>");
		String id = scan.next();
		
		try {
			conn=DBUtil.getConnection();
			
			String sql="delete from mymember where mem_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println("삭제 작업성공!!!");
			} else {
				System.out.println("삭제 작업 실패~~~");
			} 

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(pstmt != null) pstmt.close(); } catch (SQLException e) {}
			try { if(conn != null) conn.close(); } catch (SQLException e) {}
		}
		
	}

	
	//회원ID를 매개변수로 받아서 해당 회원ID의 개수를 반환하는 메서드(여러번 쓸 수 있어서 따로 만드는 거임)
	private int getMemberCount(String memId) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select count(*) cnt from mymember where mem_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, memId);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try { rs.close();} catch(SQLException e) {}
			if(pstmt != null) try { pstmt.close();} catch(SQLException e) {}
			if(conn != null) try { conn.close();} catch(SQLException e) {}
		}
		
		return count;
	}
	
	private void insert() {
		
		String id = null;
		int count = 0;
		do {
			System.out.println("아이디>>");
			id =scan.next();
			
			count = getMemberCount(id);
			
			if(count>0) {
				System.out.println(id+"는 이미 등록된 아이디 입니다.");
			}
		} while (count>0);
		
	
		System.out.println("패스워드>>");
		String pa = scan.next();

		System.out.println("이름>> ");
		String name = scan.next();
		
		System.out.println("전화번호>>");
		String tel = scan.next();
		
		scan.nextLine();//입력버퍼 비워주는 역할, nextLine은 앞을 검사한다고 함
		System.out.println("주소>>");
		//주소에는 띄워쓰기가 많기 때문에
		String addr = scan.nextLine();
		
		try {
			conn=DBUtil.getConnection();
			
			String sql="insert into mymember values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pa);
			pstmt.setString(3, name);
			pstmt.setString(4, tel);
			pstmt.setString(5, addr);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println("추가작업성공");
			} else {
				System.out.println("추가작업 실패!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(pstmt != null) pstmt.close(); } catch (SQLException e) {}
			try { if(conn != null) conn.close(); } catch (SQLException e) {}
		}
	}

	private int displayMenu() {
		System.out.println("==작업==");
		System.out.println("1.추가");
		System.out.println("2.삭제");
		System.out.println("3.수정");
		System.out.println("4.전체자료출력");
		System.out.println("0.종료");
		System.out.println("번호입력");
		
		return scan.nextInt();
	}

}































