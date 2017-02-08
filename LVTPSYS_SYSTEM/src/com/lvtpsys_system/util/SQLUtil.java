package com.lvtpsys_system.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lvtpsys_system.entity.LYJD;
import com.lvtpsys_system.entity.SR;
import com.lvtpsys_system.entity.SR_item;
import com.lvtpsys_system.entity.Student;
import com.lvtpsys_system.entity.XF;
import com.lvtpsys_system.entity.XF_item;
import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

public class SQLUtil {
	// 用于连接Mysql类
	public static Connection oConnection;
	// 用于操作数据库语句类
	public PreparedStatement oStatement;
	// 用于查询后，保存查询的数据信息，类似于安卓客户端的cusor
	public ResultSet oSet;
	
	public int add_sr_info(int id,float money){
		int type=0;
		String sql1="select money from tb_in where id=?";
		String sql="update tb_in set money=? where id=?";
		oConnection=DbHelper.getconnection();
		if (oConnection!=null) {
			try {
				oStatement=oConnection.prepareStatement(sql1);
				oStatement.setInt(1, id);
				oSet=oStatement.executeQuery();
				if (oSet.next()) {
					float mon=oSet.getFloat("money");
					oStatement=oConnection.prepareStatement(sql);
					oStatement.setFloat(1, mon+money);
					oStatement.setInt(2, id);
					int count=oStatement.executeUpdate();
					if (count>0) {
						type=1;
					}
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return type;
	}
	
	public SR getsr_info(){
		SR sr=null;
		List<SR_item> srItems=new ArrayList<SR_item>();
		String sql="select * from tb_in";
		oConnection=DbHelper.getconnection();
		if (oConnection!=null) {
			sr=new SR();
			try {
				oStatement=oConnection.prepareStatement(sql);
				oSet=oStatement.executeQuery();
				float sr_money=0;
				float zf_money=0;
				while (oSet.next()) {
					int id=oSet.getInt("id");
					String name=oSet.getString("in_type");
					float money=oSet.getFloat("money");
					String type=oSet.getString("type");
					SR_item item=new SR_item(id, name, money, type);
					srItems.add(item);
					if (type.equals("收入")) {
						sr_money=sr_money+money;
					}
					if (type.equals("负债")) {
						zf_money=zf_money+money;
					}
				}
				sr.setSrItems(srItems);
				sr.setZfz(zf_money);
				sr.setZsr(sr_money);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return sr;
	}

	public int add_xf_info(String fenlei,String xianjin,String beizhu,String shijian){
		int type=0;
		String sql="insert into tb_out(type,money,info,time) values(?,?,?,?)";
		oConnection=DbHelper.getconnection();
		if (oConnection!=null) {
			try {
				oStatement=oConnection.prepareStatement(sql);
				oStatement.setString(1, fenlei);
				oStatement.setFloat(2, Float.valueOf(xianjin));
				oStatement.setString(3, beizhu);
				oStatement.setString(4, shijian);
				int count=oStatement.executeUpdate();
				if (count>0) {
					type=1;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return type;
	}
	public XF getxf_info() {
		XF xf = null;
		List<XF_item> xfs=new ArrayList<XF_item>();
		String sql = "select * from tb_out";
		String sql1="select money from tb_out";
		String sql2="select money from tb_in";
		oConnection = DbHelper.getconnection();
		if (oConnection != null) {
			try {
				oStatement = oConnection.prepareStatement(sql);
				oSet = oStatement.executeQuery();
				xf=new XF();
				while (oSet.next()) {
					int id = oSet.getInt("id");
					String info = oSet.getString("type");
					String type1 = info.split("/")[0];
					String type2 = info.split("/")[1];
					float money = oSet.getInt("money");
					String info1 = oSet.getString("info");
					String time = oSet.getString("time");
					String year = time.split("/")[0];
					String month = time.split("/")[1];
					String day = time.split("/")[2];
					XF_item item = new XF_item(id, Integer.parseInt(year),
							Integer.parseInt(month), Integer.parseInt(day),money,
							type1, type2, info1);
					xfs.add(item);
				}
				xf.setXfs(xfs);
				oStatement= oConnection.prepareStatement(sql1);
				oSet = oStatement.executeQuery();
				float out_money=0;
				while (oSet.next()) {
					float	out_money1=oSet.getFloat("money");
					out_money=out_money+out_money1;
				}
				xf.setZhichu(out_money);
				oStatement= oConnection.prepareStatement(sql2);
				oSet = oStatement.executeQuery();
				float in_money=0;
				while (oSet.next()) {
					float in_money1=oSet.getFloat("money");
					in_money=in_money+in_money1;
				}
				xf.setShouru(in_money);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return xf;
	}

	public int login_user(String name, String psd) {
		int type = 0;
		String sql = "select * from tb_user where name=? and psd=?";
		oConnection = DbHelper.getconnection();
		if (oConnection != null) {
			try {
				oStatement = oConnection.prepareStatement(sql);
				oStatement.setString(1, name);
				oStatement.setString(2, psd);
				oSet = oStatement.executeQuery();
				if (oSet.next()) {
					type = 1;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return type;
	}

	public int register_user(String name, String psd) {
		int type = 0;
		String sql = "insert into tb_user(name,psd) values(?,?)";
		oConnection = DbHelper.getconnection();
		if (oConnection != null) {
			try {
				oStatement = oConnection.prepareStatement(sql);
				oStatement.setString(1, name);
				oStatement.setString(2, psd);
				int count = oStatement.executeUpdate();
				if (count > 0) {
					type = 1;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DbHelper.closeConnectionAndStatement(oConnection, oStatement,
						oSet);
			}

		}
		return type;
	}

	/**
	 * 注册
	 * 
	 * @param student
	 * @return
	 */
	public int register_student(Student student) {
		int type = 0;
		String sql = "insert into student(xuehao,name,psd,sex,age,xueyuan,banji,dianhua) values(?,?,?,?,?,?,?,?)";
		oConnection = DbHelper.getconnection();
		if (oConnection != null) {
			try {
				oStatement = oConnection.prepareStatement(sql);
				oStatement.setInt(1, student.getXuehao());
				oStatement.setString(2, student.getName());
				oStatement.setString(3, student.getPsd());
				oStatement.setString(4, student.getSex());
				oStatement.setInt(5, student.getAge());
				oStatement.setString(6, student.getXueyuan());
				oStatement.setString(7, student.getBanji());
				oStatement.setString(8, student.getDianhua());
				int count = oStatement.executeUpdate();
				if (count > 0) {
					type = 1;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DbHelper.closeConnectionAndStatement(oConnection, oStatement,
						oSet);
			}
		}
		return type;
	}

	public Student Login_sql(String name, String psd) {
		Student student = null;
		String sql = "select * from student where name=? and psd=?";
		oConnection = DbHelper.getconnection();
		if (oConnection != null) {
			try {
				oStatement = oConnection.prepareStatement(sql);
				oStatement.setString(1, name);
				oStatement.setString(2, psd);
				oSet = oStatement.executeQuery();
				if (oSet.next()) {

					int id = oSet.getInt("id");
					int xuehao = oSet.getInt("xuehao");
					String name1 = oSet.getString("name");
					String psd1 = oSet.getString("psd");
					String sex = oSet.getString("sex");
					int age = oSet.getInt("age");
					String xueyuan = oSet.getString("xueyuan");
					String banji = oSet.getString("banji");
					String dianhua = oSet.getString("dianhua");
					student = new Student(id, xuehao, name1, psd1, sex, age,
							xueyuan, banji, dianhua);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DbHelper.closeConnectionAndStatement(oConnection, oStatement,
						oSet);
			}
		}

		return student;
	}

	public List<LYJD> getLYJDInfo() {
		List<LYJD> list = null;
		String sql = "select * from lvjd ";
		oConnection = DbHelper.getconnection();
		if (oConnection != null) {
			list = new ArrayList<LYJD>();

			try {
				oStatement = oConnection.prepareStatement(sql);
				oSet = oStatement.executeQuery();
				while (oSet.next()) {
					int id = oSet.getInt("id");
					String lName = oSet.getString("l_name");
					String jianjie = oSet.getString("jianjie");
					String meishi = oSet.getString("meishi");
					String jiaotong = oSet.getString("jiaotong");
					int lNumber = oSet.getInt("l_number");
					String ltime = oSet.getString("l_time");
					LYJD lyjd = new LYJD(id, lName, jianjie, meishi, jiaotong,
							ltime, lNumber);
					list.add(lyjd);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DbHelper.closeConnectionAndStatement(oConnection, oStatement,
						oSet);
			}

		}
		return list;
	}

	public boolean tp_sql(int id, String time) {
		boolean is = false;
		String sql1 = "select l_time,l_number from lvjd where id=?";
		String sql2 = "update lvjd set l_number=? where id=?";
		oConnection = DbHelper.getconnection();
		if (oConnection != null) {
			try {
				oStatement = oConnection.prepareStatement(sql1);
				oStatement.setInt(1, id);
				oSet = oStatement.executeQuery();
				if (oSet.next()) {
					String l_time = oSet.getString("l_time");
					int l_number = oSet.getInt("l_number");
					boolean istime = Common.isOrder(l_time.split("-"), time);
					if (istime) {
						oStatement = oConnection.prepareStatement(sql2);
						oStatement.setInt(1, l_number + 1);
						oStatement.setInt(2, id);
						int count = oStatement.executeUpdate();
						if (count > 0) {
							is = true;
						}
					} else {
						is = false;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DbHelper.closeConnectionAndStatement(oConnection, oStatement,
						oSet);
			}
		}
		return is;
	}

	public boolean update_psd_sql(int id, String psd) {
		boolean is = false;
		oConnection = DbHelper.getconnection();
		String sql = "update student set psd=? where id=?";
		if (oConnection != null) {
			try {
				oStatement = oConnection.prepareStatement(sql);
				oStatement.setString(1, psd);
				oStatement.setInt(2, id);
				int count = oStatement.executeUpdate();
				if (count > 0) {
					is = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DbHelper.closeConnectionAndStatement(oConnection, oStatement,
						oSet);
			}
		}
		return is;
	}

	public List<Map<String, Object>> getNumber() {
		List<Map<String, Object>> oList = null;
		String sql = "select l_name,l_number,l_time  from lvjd ";
		oConnection = DbHelper.getconnection();
		if (oConnection != null) {
			oList = new ArrayList<Map<String, Object>>();
			try {
				oStatement = oConnection.prepareStatement(sql);
				oSet = oStatement.executeQuery();
				while (oSet.next()) {
					Map<String, Object> oMap = new HashMap<String, Object>();
					String name = oSet.getString("l_name");
					String time = oSet.getString("l_time");
					int number = oSet.getInt("l_number");
					oMap.put("name", name);
					oMap.put("number", number);
					oMap.put("time", time);
					oList.add(oMap);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DbHelper.closeConnectionAndStatement(oConnection, oStatement,
						oSet);
			}
		}
		return oList;
	}

	public LYJD getLYJDInfo(int id) {
		LYJD lyjd = null;
		String sql = "select * from lvjd where id=?";
		oConnection = DbHelper.getconnection();
		if (oConnection != null) {
			try {
				oStatement = oConnection.prepareStatement(sql);
				oStatement.setInt(1, id);
				oSet = oStatement.executeQuery();
				if (oSet.next()) {
					int idS = oSet.getInt("id");
					String l_name = oSet.getString("l_name");
					String jianjie = oSet.getString("jianjie");
					String meishi = oSet.getString("meishi");
					String jiaotong = oSet.getString("jiaotong");
					int l_number = oSet.getInt("l_number");
					String l_time = oSet.getString("l_time");
					lyjd = new LYJD(idS, l_name, jianjie, meishi, jiaotong,
							l_time, l_number);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DbHelper.closeConnectionAndStatement(oConnection, oStatement,
						oSet);
			}
		}
		return lyjd;
	}

}
