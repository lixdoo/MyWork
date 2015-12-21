package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import util.ConnectionUtils;

public class UserDao {
	private static final String findAll = "select username,password from user ";
	
	private static final String validateUser ="select username,password from user where username=? and password=? ";
	
	public List<User> findAll(){
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = ConnectionUtils.openConnection();
			stmt = con.prepareStatement(findAll);
			rs = stmt.executeQuery();
			List<User> userList = new ArrayList<User>();
			while(rs.next()){
				User user = new User();
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				userList.add(user);
			}
			return userList;
		}catch (Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
		
	}
	
	public User validate(String username,String password){
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = ConnectionUtils.openConnection();
			stmt=con.prepareStatement(validateUser);
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			User user = new User();
			while(rs.next()){
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				
			}
			return user;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args){
		UserDao userDao = new UserDao();
		System.out.println(userDao.validate("lixdoo","123456").getUsername());
	}
}
