package _12_UpdateInfo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _00_Account.model.AccountBean;
import _04_Member.model.MemberBean;
import _04_Member.model.MemberDAOjdbc;

@WebServlet("/InfoUpdate")
public class InfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MemberDAOjdbc dao = new MemberDAOjdbc();
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
//    	request.getAttribute("LoginOK");
    	
    	//接收資料	
    	String  aaa = (String) session.getAttribute("LoginOK");
    			
    			String name = request.getParameter("name");
    			String member_photo = request.getParameter("member_photo");
    			String tel = request.getParameter("tel");
    			String email2 = request.getParameter("email2");
    			String cel = request.getParameter("cel");

    			
    			
    			//String account_UID = (String)request.getAttribute("LoginOK");
    	//驗證資料// 轉型態
    			Map<String, String> error = new HashMap<String, String>();
    			request.setAttribute("error", error);

    			if(name==null || name.trim().length()==0) {
    				error.put("name", "請輸入您的姓名");
    			}System.out.println(name);
    			
    			if(tel==null || tel.trim().length()==0) {
    				error.put("tel", "請輸入您的電話號碼");
    			}System.out.println(tel);

    			if(email2==null || email2.trim().length()==0) {
    				error.put("email2", "請輸入您的備用e-mail");
    			}System.out.println(email2);
    			
    			if(cel==null || cel.trim().length()==0) {
    				error.put("cel", "請輸入您的手機號碼");
    			}System.out.println(cel);
    			
    			//處理前面的資料驗證，有錯就先return
    			if (error!= null&&!error.isEmpty()) {
    				error.put("action", "修改失敗");
    				RequestDispatcher rd = request.getRequestDispatcher("/_04_Members/InfoUpdate.jsp");
    				rd.forward(request, response);	
    				return;
    			}
	
    			//呼叫member update by uid方法
    			UpdateInfoService updateInfoService = new UpdateInfoService();
    			
    			MemberBean bean2 = new MemberBean();
    			
    				//bean1.setAccount_UID(bean.getAccount_UID());
    				bean2.setName(name);
    				bean2.setMember_photo("");
    				//bean2.setGender(gender);
    				bean2.setTel(tel);
    				bean2.setEmail2(email2);
    				bean2.setCel(cel);
    				bean2.setAccount_UID(aaa);
    				System.out.println("bean2: "+ bean2);
    				updateInfoService.update(bean2);
    				
    				if (aaa!= null) {
        				RequestDispatcher rd = request.getRequestDispatcher("/_04_Members/UpdateSuccess.jsp");
        				rd.forward(request, response);}else{
        					RequestDispatcher rd = request.getRequestDispatcher("/_02_Login/Login.jsp");
        				rd.forward(request, response);
        			
        				}	
//    				} else if("Update".equals(orderaction)) {
//    				OrdersTotalBean result = ordersTotalService.update(bean);
//    				if(result==null) {
//    					error.put("action", "Update failed");
//    				} else {
//    					request.setAttribute("update", result);
//    				}
//    				request.getRequestDispatcher(
//    						"/_03_Orders/OrdersTotal.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		this.doGet(request, response);
	}

}
