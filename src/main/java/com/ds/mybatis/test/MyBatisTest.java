package com.ds.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisTest {
	
	public void demo1(){
		try {
			String resource = "com/ds/config/mybatis-config.xml";
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			System.out.println(session);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void demo2(){
		
	}
	
	
	public static void main(String[] args) {
		MyBatisTest myBatisTest = new MyBatisTest();
		myBatisTest.demo1();
	}
}
