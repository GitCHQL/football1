package com.lvtpsys_system.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lvtpsys_system.entity.Student;
import com.lvtpsys_system.util.SQLUtil;

public class RegisterServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		String xuehao=request.getParameter("xuehao");
		int xuehao_id=Integer.parseInt(xuehao);
		String name=new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
		String psd=request.getParameter("psd");
		String sex=request.getParameter("sex");
		System.out.println(sex);
		String age_str=request.getParameter("age");
		int age=Integer.parseInt(age_str);
		String xueyuan=new String(request.getParameter("xueyuan").getBytes("ISO-8859-1"), "UTF-8");
		String banji=new String(request.getParameter("banji").getBytes("ISO-8859-1"), "UTF-8");
		String dianhua=request.getParameter("dianhua");
		Student student=new Student(0, xuehao_id, name, psd, sex, age, xueyuan, banji, dianhua);
		
		SQLUtil util=new SQLUtil();
		int type=util.register_student(student);
		System.out.print(student.toString());
		if (type==0) {
			out.print("注册失败");
		}
		if (type==1) {
			out.print("注册成功");
		}
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
