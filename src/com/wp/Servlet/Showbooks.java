package com.wp.Servlet;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Showbooks")
public class Showbooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Showbooks() {
        super();
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		File file= new File("G:\\BookSale\\");
		if(file.exists()){
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			for(String s:file.list())
			{
				out.println("<a href= 'GetFile?file="+s+"'>"+s+"</a><br>");
			}
				out.println("</body>");
				out.println("</html>");
			}
			else
			{
				System.out.println("file not found");
			}
			
		}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
