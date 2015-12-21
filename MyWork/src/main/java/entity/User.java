package entity;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
/*
 * 用户实体
 * 
 */
public class User {
	private String username;
	
	private	String password;
	
	public User(){
		
	}
	
	public User(HttpServletRequest request) throws IllegalAccessException, InvocationTargetException, UnsupportedEncodingException	{
		BeanUtils.populate(this, request.getParameterMap());
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
