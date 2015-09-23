package edu.sjsu.cmpe275.lab2;

import java.util.HashMap;

public interface UserService {
	
	public HashMap<String, HomePage> getHashmap();
	public HomePage getUser(String userId);
	public void storeUser(HomePage home);
    public void updateUser(HomePage home);
    public void deleteUser(HomePage home);
}
