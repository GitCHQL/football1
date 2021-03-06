package com.lvtpsys_system.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.lvtpsys_system.entity.Student;
import com.lvtpsys_system.util.SQLUtil;

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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
		response.setContentType("text/html");
		 request.setCharacterEncoding("UTF-8");
		 response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		String name=new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
		String psd=request.getParameter("psd");
		Student student=new SQLUtil().Login_sql(name, psd);
		if (student!=null) {
			JSONObject object=new JSONObject();
			try {
				object.put("id", student.getId());
				object.put("xuehao", student.getXuehao());
				object.put("name", student.getName());
				object.put("psd", student.getPsd());
				object.put("sex", student.getSex());
				object.put("age", student.getAge());
				object.put("xueyuan", student.getXueyuan());
				object.put("banji", student.getBanji());
				object.put("dianhua", student.getDianhua());
				out.print(object.toString());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}else {
			out.print("登陆失败");
		}
		out.flush();
		out.close();
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

		doGet(request, response);
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
