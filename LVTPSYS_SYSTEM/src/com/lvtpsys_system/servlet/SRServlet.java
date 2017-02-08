package com.lvtpsys_system.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.lvtpsys_system.entity.SR;
import com.lvtpsys_system.util.SQLUtil;

public class SRServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SRServlet() {
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
		SR sr=new SQLUtil().getsr_info();
		JSONObject object=new JSONObject();
		JSONArray array=new JSONArray();
		try {
			object.put("zsr", sr.getZsr());
			object.put("zfz", sr.getZfz());
			for (int i = 0; i < sr.getSrItems().size(); i++) {
				JSONObject object2=new JSONObject();
				object2.put("id", sr.getSrItems().get(i).getId());
				object2.put("name", sr.getSrItems().get(i).getName());
				object2.put("money", sr.getSrItems().get(i).getMoney());
				object2.put("type", sr.getSrItems().get(i).getType());
				array.put(object2);
			}
			object.put("sr_item", array);
			out.print(object.toString());
		} catch (JSONException e) {
			e.printStackTrace();
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
