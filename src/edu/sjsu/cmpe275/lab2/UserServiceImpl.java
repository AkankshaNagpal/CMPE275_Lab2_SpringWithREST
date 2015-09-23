package edu.sjsu.cmpe275.lab2;

import java.util.HashMap;

public class UserServiceImpl implements UserService {
	
	private HashMap<String, HomePage> user;

	
	public void setUser(HashMap<String, HomePage> user) {
		this.user = user;
	}

	@Override
	public HashMap<String, HomePage> getHashmap() {
		// TODO Auto-generated method stub
		return user ;
	}

	@Override
	public HomePage getUser(String userId) {
		// TODO Auto-generated method stub
		if(!user.containsKey(userId)){return null;}
		else{return user.get(userId);}
			}

	@Override
	public void storeUser(HomePage home) {
		// TODO Auto-generated method stub
		user.put(home.getId(), home);
	}
	
	 public void updateUser(HomePage home)
	 {
		 user.put(home.getId(), home);
		 //user.get(home.getId());
		// HomePage updatehome =  .get(id);
		 
	 }
	 
	 public void deleteUser(HomePage home){
		user.remove(home.getId());
	 }
	 

}
