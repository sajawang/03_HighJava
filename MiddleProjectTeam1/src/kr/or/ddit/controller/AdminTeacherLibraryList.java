package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.AdminTeacherLibraryServiceImpl;
import kr.or.ddit.service.IAdminTeacherLibraryService;
import kr.or.ddit.vo.FileVO;
import kr.or.ddit.vo.PostVO;


@WebServlet("/AdminTeacherLibraryList.do")
public class AdminTeacherLibraryList extends HttpServlet {
   private static final long serialVersionUID = 1L;

   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      IAdminTeacherLibraryService service = AdminTeacherLibraryServiceImpl.getInstance();
      request.setCharacterEncoding("UTF-8");

      int boardNo = 4;
      // 게시글 목록 가져오기
        List<PostVO> libraryList = service.selectLibraryList(boardNo);
   
       List<FileVO> fileList = (List<FileVO>)service.selectFile();
         
      
           // 조회된 게시글과 파일 목록을 request에 담아서 JSP로 전달
           request.setAttribute("libraryList", libraryList);
           request.setAttribute("fileList", fileList);
           request.getRequestDispatcher("/WEB-INF/view/adminTeacherLibrary/TeacherLibraryList.jsp").forward(request, response);
   }

   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}
