package _09_SendMail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TestMailServlet")
public class TestMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public TestMailServlet() {
        super();
          }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	
//    public static void sendmail(String email ,String url){
    	String email=request.getParameter("email");
    	String url=request.getParameter("url");
    	
			  String host = "smtp.gmail.com";
			  int port = 587;
			  final String username = "eeit83team05@gmail.com";
			  final String password = "P3n154n41";//your password

			  Properties props = new Properties();
			  props.put("mail.smtp.host", host);
			  props.put("mail.smtp.auth", "true");
			  props.put("mail.smtp.starttls.enable", "true");
			  props.put("mail.smtp.port", port);
			  Session session = Session.getInstance(props, new Authenticator() {
			   protected PasswordAuthentication getPasswordAuthentication() {
			    return new PasswordAuthentication(username, password);
			   }
			  });
			  
			  

			  try {
				  	


			   Message message = new MimeMessage(session);
			   message.setFrom(new InternetAddress("eeit83team05@gmail.com"));
			   message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			   message.setSubject("測試寄信.");
			   message.setSentDate(new java.util.Date()); 
				  MimeBodyPart textPart = new MimeBodyPart();
				   StringBuffer html = new StringBuffer();
//				   html.append("<a href='http://localhost:8080/8691/index.jsp'>按我回首頁</a>");
				   
				   String pathurl = "<a href='"+url+"'>按我回首頁</a>";	
//				   System.out.println(pathurl);
				   html.append(pathurl);
				   html.append("此為系統自動發送之信件，請勿直接回覆！"); 
				
				   
				   html.append("8691管理團隊  敬上");
				
				   textPart.setContent(html.toString(), "text/html; charset=UTF-8");
				  
			   
			   
			//   message.setText("Dear Levin, \n\n 測試 測試 測試 測試 測試 測試 email !  " +html);
			   
			//   String pathurl = HttpServletRequest.getContextPath()+"/index.jsp";
			//
			//   String url = "<a href='"+pathurl+"'>按我回首頁</a>";
			//   String subject = "【查詢密碼通知】這是來自Travel To Taiwan系統通知信，請勿直接回覆此信";
//				String content = "Dear " + memberVO.getName_En() + "\n\n您的臨時密碼改為：" + randomPassword
//						+ "\n\n請於30分鐘內以此密碼登入，並至會員中心修改您的密碼。"
//						+ "\n\n\nTravel To Taiwan祝您旅遊愉快\n\n\n\n\n\t\t\t\t\t\tTravel To Taiwan  管理團隊  敬上"
//						+ "\n\n\n\n\n\n**********此為系統自動發送之信件，請勿直接回覆！**********";
			   
				   //文字部分
				  
			   Multipart email1 = new MimeMultipart();
			   email1.addBodyPart(textPart);
			   message.setContent(email1);
			   
			   
			   Transport transport = session.getTransport("smtp");
			   transport.connect(host, port, username, password);

			   Transport.send(message);

			   System.out.println("寄送email結束.");
			   

			  } catch (MessagingException e) {
			   throw new RuntimeException(e);
			  }
			  
//			 }
    
    }
		

//			public static void main(String[] args){
//				  TestMail mail= new TestMail();
//					mail.sendmail("w1225hg@hotmail.com","https://tw.yahoo.com/");
//			System.out.println("結束~");	
//			}	



			
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
