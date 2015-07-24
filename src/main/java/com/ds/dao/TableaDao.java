package com.ds.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ds.bean.Tablea;
import com.ds.db.DBAccess;

public class TableaDao {
	public List<Tablea> queryTablea(String cola){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			List<Tablea> rs = sqlSession.selectList("queryTablea");
			for (Tablea tablea : rs) {
				System.out.print(tablea.getCola());
				System.out.print(tablea.getColb());
				System.out.print(tablea.getColc());
				System.out.println(tablea.getCold());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (null != sqlSession) {
				sqlSession.close();
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		TableaDao tableaDao = new TableaDao();
		tableaDao.queryTablea("aa");
	}
}
