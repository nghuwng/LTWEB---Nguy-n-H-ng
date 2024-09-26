package hungvt.dao;

import java.util.List;

import hungvt.models.UserModel;

public interface IUserDao {
	
	List<UserModel> findAll();
	
	UserModel findById(int id);
	
	void insert(UserModel user);
	
	UserModel findByUserName(String username);

	boolean containsKey(String username);

	void put(String username, UserModel user);

}
