package com.lvtpsys_system.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbHelper {
	
	 /**
	  * 建立链接
	  * */
	public static Connection getconnection() {
		try{
			//获得操作管理者的驱动程序，也就是DriverManager
			Class.forName("com.mysql.jdbc.Driver");
			//通过jdbc连接mysql，获得连接对象
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/lvtp", "root", "admin");
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//关闭连接
	public static void closeConnectionAndStatement(Connection con,Statement st,ResultSet oSet){
		try {
			if(st!=null)st.close();
			if(con!=null)con.close();
			if (oSet!=null) {
				oSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
