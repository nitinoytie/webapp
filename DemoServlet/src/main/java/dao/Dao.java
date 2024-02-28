package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modal.Users;

public class Dao {
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","root");
		return con;
	} 
	
	public static int save(Users us) throws SQLException, ClassNotFoundException {
		Connection con=getConnection();
		
		String sql="insert into users (fname,lname,age,email,pass) values(?,?,?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		
		
		ps.setString(1, us.getFname());
		ps.setString(2, us.getLname());
		ps.setInt(3, us.getAge());
		ps.setString(4, us.getEmail_id());
		ps.setString(5, us.getPass());
		
		int st=ps.executeUpdate();
		
		return st;
		
	}
	public static List<Users> getAllUsers(int start, int total) throws SQLException, ClassNotFoundException{
		
		List<Users> list=new ArrayList<Users>();
		
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement("select * from users limit "+Integer.toString(start-1)+","+Integer.toString(total)+"");
		
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			Users us=new Users();
			us.setId(rs.getInt(1));
			us.setFname(rs.getString(2));
			us.setLname(rs.getString(3));
			us.setAge(rs.getInt(4));
			us.setEmail_id(rs.getString(5));
			us.setPass(rs.getString(6));
			
			list.add(us);

		}
		return list;
		
	}

	public static Users getUserById(int id) throws ClassNotFoundException, SQLException {
		
		Connection con=getConnection();
		
		String sql="select * from users where id=?";
		
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1, id);
		
		ResultSet rs=st.executeQuery();
		Users us=new Users();
		
		while (rs.next()) {
			us.setId(rs.getInt(1));
			us.setFname(rs.getString(2));
			us.setLname(rs.getString(3));
			us.setAge(rs.getInt(4));
			us.setEmail_id(rs.getString(5));
			us.setPass(rs.getString(6));
		}
		return us;
	}

	public static int updateUser(Users us) throws ClassNotFoundException, SQLException {
		
		Connection con=getConnection();
		
		String sql="update users set fname=?,lname=?,age=?,email=?,pass=? where id=?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, us.getFname());
		ps.setString(2, us.getLname());
		ps.setInt(3, us.getAge());
		ps.setString(4, us.getEmail_id());
		ps.setString(5, us.getPass());
		ps.setInt(6, us.getId());
		int st=ps.executeUpdate();
		
		return st;
		
	}

	public static int deleteuser(Users us) throws ClassNotFoundException, SQLException {
		
		Connection con=getConnection();
		
		String sql="delete from users where id=?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setInt(1, us.getId());
		
		int st=ps.executeUpdate();
		
		return st;
		
	}

	public static boolean checkuser(String email, String pass) throws ClassNotFoundException, SQLException {
		boolean st=false;
		Connection con=getConnection();
		String sql="select * from users where email=? and pass=?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, email);
		ps.setString(2, pass);
		
		ResultSet rs=ps.executeQuery();
		st=rs.next();
		return st;
		
	}

	
}
