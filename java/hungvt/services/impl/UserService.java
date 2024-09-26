package hungvt.services.impl;

import hungvt.dao.IUserDao;
import hungvt.dao.impl.UserDaoImpl;
import hungvt.models.UserModel;
import hungvt.services.IUserService;

public class UserService implements IUserService {
	// Lấy toàn bộ hàm trong tầng Dao của user 
	IUserDao userDao = new UserDaoImpl();

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.FindByUserName(username);
		 if (user != null && password.equals(user.getPassword())) {
		 return user;
		 }
		 return null;
	}

	@Override
	public UserModel FindByUserName(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUserName(username);
	}
	
	//Test chương trình. Kích hoạt chuột chọn run as -> java application
	 public static void main(String[] args) {
		 try {
			 IUserService userService = new UserService();
			 System.out.println(userService.FindByUserName("admin"));
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	 }

	@Override
	public boolean checkUserExist(String username) {
		return userDao.containsKey(username);
	}

	@Override
	public void register(UserModel user) {
		userDao.put(user.getUsername(), user);
		
	}
}
