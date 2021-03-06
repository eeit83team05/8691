package _12_UpdateInfo;

import java.sql.*;
import javax.sql.DataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class AddrUpdateDAOjdbc{
//	private static final String URL = "jdbc:sqlserver://raab1str2m.database.windows.net:1433;database=DB02";
//	private static final String USERNAME = "eeit83team05@raab1str2m";
//	private static final String PASSWORD = "Sa123456";
	
	DataSource ds=null;
	public AddrUpdateDAOjdbc(){
	try {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/8691");
	} catch (NamingException e) {
		e.printStackTrace();
	 }
	}
	
	public static void main(String[] args){
//		MemberDAOjdbc dao = new MemberDAOjdbc();
//		select
//	    MemberBean beanSelect = dao.select("87B6061E-4C34-4F1A-843F-032EC7D44125");
//		System.out.println(beanSelect);

		//select all
//		List<MemberBean> SelectAll = dao.select();
//		System.out.println(SelectAll);
		
//      insert
//	    MemberBean beanIns = new MemberBean("117EA040-ECA2-4B05-A70D-9EFEA6346796","Marcus wo", "男", "7782406836","A","106","110","1號1樓","Marcuswo@Foodmail.com","0910111111");
//	                                                      account_UID, member_ID, name, gender, tel, GUAR_CT, GUAR_AR, GUAR_ROAD, GUAR_NO, email2, cel, insdate
//	    dao.insert(beanIns);
//		System.out.println(beanIns);
		
//      update
//		MemberBean update = dao.update("Marcus Lo",null,"男","7782406836","A","106","110","1號1樓","Marcuslo@Foodmail.com","0910111111",null,"46886F5D-34AE-4F43-9CB5-79BF388535A6");
//		                                System.out.println(update);
//      delete	
//		int beanDel = dao.delete("11");
//		System.out.println(beanDel);
	}

	private static final String UPDATE =
			"update Member set GUAR_CT=?, GUAR_AR=?, GUAR_ROAD=?, GUAR_NO=? where account_UID=?";
//  
public String AddrUpdate(
		String GUAR_CT,
		String GUAR_AR,
		String GUAR_ROAD,
		String GUAR_NO,
		String account_UID)
{
	String result = null;
		Connection conn = null;
		PreparedStatement psStrUpd = null;
		try {
			conn = ds.getConnection();
			//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			psStrUpd = conn.prepareStatement(UPDATE);
			psStrUpd.setString(1, GUAR_CT);
			psStrUpd.setString(2, GUAR_AR);
			psStrUpd.setString(3, GUAR_ROAD);
			psStrUpd.setString(4, GUAR_NO);
//			if (insdate != null) {
//				long time = insdate.getTime();
//				psStrUpd.setDate(11, new java.sql.Date(time));
//			} else {
//				psStrUpd.setDate(11, null);
//			}
			psStrUpd.setString(5, account_UID);
			int i = psStrUpd.executeUpdate();
			if(i==1){
				System.out.println(result);
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (psStrUpd != null) {
				try {
					psStrUpd.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}