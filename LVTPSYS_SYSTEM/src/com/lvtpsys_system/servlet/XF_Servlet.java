package com.lvtpsys_system.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.lvtpsys_system.entity.XF;
import com.lvtpsys_system.entity.XF_item;
import com.lvtpsys_system.util.SQLUtil;

public class XF_Servlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public XF_Servlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		SQLUtil util=new SQLUtil();
		XF xf=util.getxf_info();
		JSONObject object=new JSONObject();
		try {
			object.put("shouru", xf.getShouru());
			object.put("zhichu", xf.getZhichu());
			List<XF_item> xfItems=xf.getXfs();
			JSONArray array=new JSONArray();
			for (int i = 0; i < xfItems.size(); i++) {
				JSONObject object2=new JSONObject();
				object2.put("id", xfItems.get(i).getId());
				object2.put("day", xfItems.get(i).getDay());
				object2.put("month", xfItems.get(i).getMother());
				object2.put("year", xfItems.get(i).getYear());
				object2.put("jianjie", xfItems.get(i).getInfo());
				object2.put("item_type", xfItems.get(i).getItem_type());
				object2.put("money", xfItems.get(i).getMoney());
				object2.put("type", xfItems.get(i).getType());
				array.put(object2);
			}
			object.put("item", array);
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
