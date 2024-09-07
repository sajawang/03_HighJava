package kr.or.ddit.fileupload.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.FileinfoVO;

public class FileInfoDaoImpl implements IFileInfoDao {
	private FileInfoDaoImpl() {}
	
	private static FileInfoDaoImpl dao;
	public static FileInfoDaoImpl getInstance() {
		if(dao==null) dao = new FileInfoDaoImpl();
		return dao;
	}
	
	
	@Override
	public int insertFileInfo(FileinfoVO fileInfoVo) {
		int cnt=0;
		SqlSession sql = null;
		
		try {
			sql = MybatisUtil.getSqlSession();
			cnt = sql.insert("fileinfo.insertFileInfo",fileInfoVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.commit();
			sql.close();
		}
		
		return cnt;
	}

	@Override
	public List<FileinfoVO> getAllFileInfo() {
		SqlSession sql=null;
		List<FileinfoVO> list=null;
		
		try {
			sql = MybatisUtil.getSqlSession();
			list = sql.selectList("fileinfo.getAllFileInfo");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		return list;
	}

	@Override
	public FileinfoVO getFileInfo(int fileNo) {
		SqlSession sql = null;
		FileinfoVO fileVo = null;
		
		try {
			sql = MybatisUtil.getSqlSession();
			fileVo = sql.selectOne("fileinfo.getFileInfo",fileNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		return fileVo;
	}
	
	
	

}
