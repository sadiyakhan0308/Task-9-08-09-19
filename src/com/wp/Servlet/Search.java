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

import com.mysql.jdbc.ResultSet;

@WebServlet("/Search")
public class Search extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Subject = request.getParameter("subjectBook");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "root");
			String sqlsearch = "select * from bookinfo where bookcategory = ";
			sqlsearch = sqlsearch + "'" + Subject + "'";
			PreparedStatement ps = con.prepareStatement(sqlsearch);
			java.sql.ResultSet rs = ps.executeQuery();
			out.println("<html>");
			out.println("<html><body>");
			out.println("<h3>BOOK-DETAILS</h3>");
			out.println("<hr>");
			while (rs.next()) {
				String bookid = rs.getString(1);
				String name = rs.getString(2);
				String author = rs.getString(3);
				String booklocation = rs.getString(4);
				String price = rs.getString(5);
				String bookcategory = rs.getString(6);
				out.println("<table border=2>");
				out.println("<tr>");
				out.println("<td>BookId</td>");
				out.println("<td>" + bookid + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Book_Name</td>");
				out.println("<td>" + name + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Author</td>");
				out.println("<td>" + author + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>BookLocation</td>");
				out.println("<td>" + booklocation + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Book Category</td>");
				out.println("<td>" + bookcategory + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Price</td>");
				out.println("<td>" + price + "</td>");
				out.println("</tr>");
				out.println("</table>");
			}
			out.println("<hr>");
			out.println("</body></html>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}