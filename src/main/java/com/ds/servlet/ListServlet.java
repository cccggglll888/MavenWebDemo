package com.ds.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.bean.Tablea;

public class ListServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String cola = req.getParameter("cola");
		req.setAttribute("cola", cola);
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","ccggll");
			StringBuffer sql = new StringBuffer("select cola, colb, colc, cold from tablea where cola=?");
			PreparedStatement statement = conn.prepareStatement(sql.toString());
			
			statement.setString(1, cola);
			
			ResultSet rs = statement.executeQuery();
			List<Tablea> tablea = new ArrayList<Tablea>();
			while (rs.next()) {
				Tablea ta = new Tablea();
				tablea.add(ta);
				ta.setCola(rs.getString("cola"));
				ta.setColb(rs.getString("colb"));
				ta.setColc(rs.getString("colc"));
				ta.setCold(rs.getString("cold"));
			}
			req.setAttribute("tablealist", tablea);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
	
}
