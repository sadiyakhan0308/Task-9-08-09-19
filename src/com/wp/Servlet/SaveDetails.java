package com.wp.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveDetails")
public class SaveDetails extends HttpServlet {

	private Connection con;
	private PreparedStatement ps;

	public void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "root");
			String sql = "insert into bookinfo values(?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// reads-request
		String bookid = request.getParameter("bookid");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String author = request.getParameter("author");
		String booklocation = request.getParameter("booklocation");
		String bookcategory = request.getParameter("bookcategory");

		try {
			ps.setString(1, bookid);
			ps.setString(2, name);
			ps.setString(3, price);
			ps.setString(4, author);
			ps.setString(5, booklocation);
			ps.setString(6, bookcategory);

			int n = ps.executeUpdate();
			out.println("Details Saved");

		} catch (Exception e) {
			out.println(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
