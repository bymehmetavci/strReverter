package com.mavci.str.reverter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/reverseStrServlet"})
public class StrReverterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost...");
		handleReq(req);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String str = handleReq(req);
		resp.getWriter().write("<h2>"+str+"</h2>");
	}
	public String handleReq(HttpServletRequest req){
		String str = req.getParameter("kelime");
		return reverseString(str);
	}
	public String reverseString(String str){
		String reverStr = "";
		if(str != null){
			for(int i = str.length()-1; i >= 0; i--){
				reverStr += str.charAt(i);
			}
		}
		return reverStr;
	}
	public static void main(String[] args) {
		StrReverterServlet servlet = new StrReverterServlet();
		System.out.println(servlet.reverseString("Mehmet"));
	}
}
		