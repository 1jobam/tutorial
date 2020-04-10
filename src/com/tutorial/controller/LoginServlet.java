package com.tutorial.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tutorial.exception.NotFoundLoginException;
import com.tutorial.service.member.MemberServiceImpl;
import com.tutorial.util.ViewResolver;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "commons/loginForm";
		ViewResolver.view(request, response, url);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "main.do";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		HttpSession session = request.getSession();
		
		try {
			MemberServiceImpl.getServiceInstance().login(id, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("500error");
		} catch (NotFoundLoginException e) {
			e.printStackTrace();
			System.out.println("아이디패스워드오류");
		}
		
		
		
		
	}

}
