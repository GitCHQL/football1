package com.lvtpsys_system.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.lvtpsys_system.entity.LYJD;
import com.lvtpsys_system.util.SQLUtil;

public class ShowLYJDServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ShowLYJDServlet() {
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
		int id=Integer.parseInt(request.getParameter("id"));
		LYJD lyjd=new SQLUtil().getLYJDInfo(id);
		if (lyjd!=null) {
			JSONObject object=new JSONObject();
			try {
				object.put("id", lyjd.getId());
				object.put("l_name", lyjd.getL_name());
				object.put("jianjie", lyjd.getJianjie());
				object.put("meishi", lyjd.getMeishi());
				object.put("jiaootng", lyjd.getJiaotong());
				object.put("l_number", lyjd.getL_number());
				object.put("l_time", lyjd.getL_time());
				out.print(object.toString());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
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

		doPost(request, response);
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
