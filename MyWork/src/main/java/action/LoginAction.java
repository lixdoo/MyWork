package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;
import util.CTLServlet;

public class LoginAction extends CTLServlet{

	/**
	 * 登陆
	 */
	private static final long serialVersionUID = 1L;
	
	private User user ;
	
	private	UserDao userDao = new UserDao();
	
	public LoginAction(){
		super();
	}
	
	public void vailteLogin(HttpServletRequest request,HttpServletResponse response) throws IllegalAccessException, InvocationTargetException, IOException{
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");  
		response.setCharacterEncoding("UTF-8");
		User user = new User(request);
		User validate = userDao.validate(user.getUsername(), user.getPassword());
		if(validate.getUsername()!=null){
			out.print("success");
		}else {
			out.print("fail");
		}
		out.flush();
		out.close();
	}
	
	
}
