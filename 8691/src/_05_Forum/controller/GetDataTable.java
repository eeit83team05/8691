package _05_Forum.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.json.simple.JSONValue;

@WebServlet("/GetDataTable")
public class GetDataTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataSource datasource = null;
	
	public GetDataTable() {
		try {
			Context context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/8691");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;		

		String query = "select Seller_visitor.name, comment, rating from Forum join Seller_visitor on Forum.seller_UID = Seller_visitor.Account_UID ";
		
		try{
			conn = datasource.getConnection();
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			
			 List  l1 = new LinkedList();
			 while (rs.next()) {
				 Map m1 = new HashMap();       
		 		 m1.put("name",rs.getString(1));
		 		 m1.put("comment", rs.getString(2));
		 		 m1.put("rating", rs.getString(3));
				 l1.add(m1);
			 }
			 String jsonString = JSONValue.toJSONString(l1);                    
			 out.println(jsonString);
		}
		catch(SQLException e){
			out.println("Error:" + e.getMessage());
		}
		finally{
			if(rs != null){
			   try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if(stmt != null){
			 try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
