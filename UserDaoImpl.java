package hungvt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hungvt.configs.DBConnectMySQL;
import hungvt.dao.IUserDao;
import hungvt.models.UserModel;

public class UserDaoImpl extends DBConnectMySQL implements IUserDao {
	
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	

	@Override
	public List<UserModel> findAll() {
		
		String sql ="select * from users";
		
		List<UserModel> list = new ArrayList<>(); //Tạo 1 List để truyền dữ liệu 
		
		try {
			conn = super.getDatabaseConnection(); //Kết nối database 
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next() /*Next từng DÒNG tới cuối bảng*/) {
				list.add(
						new UserModel(
								rs.getInt("id"), 
								rs.getString("username"), 
								rs.getString("email"), 
								rs.getString("password"), 
								rs.getString("fullname"), 
								rs.getString("images")
								)
						); //Add vào				
			}
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception 
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public UserModel findById(int id) {
		String sql = "SELECT * FROM users WHERE id = ?";
				
		try {
			conn = super.getDatabaseConnection(); //Kết nối database 
			
			ps = conn.prepareStatement(sql); 			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				UserModel user = new UserModel();
			    user.setId(rs.getInt("id"));
			return user;
			}
			
		} catch (Exception e) {
			// TODO: handle exception 
			e.printStackTrace();
		}
			
		return null;
	}

	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO users(id, username, email, password, fullname, images) VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			conn = super.getDatabaseConnection(); //Kết nối database 
			
			ps = conn.prepareStatement(sql); //ném câu sql vào cho thực thi
			
			ps.setInt(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getFullname());
			ps.setString(6, user.getImages());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		UserDaoImpl userDao = new UserDaoImpl();
		
		userDao.insert(new UserModel(8, "tu", "tu@gmail.com", "12345678", "Trương Cẩm Tú", ""));
		
		List<UserModel> list = userDao.findAll();
		
		for (UserModel user : list) {
			System.out.println(user);
		}
	}

}
