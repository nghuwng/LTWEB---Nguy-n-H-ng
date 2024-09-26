package hungvt.services;

import hungvt.models.UserModel;

public interface IUserService {
	UserModel login(String username, String password);
	
	UserModel FindByUserName(String username);

	boolean checkUserExist(String username);

	void register(UserModel user); 
}
