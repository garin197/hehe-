package com.java.dao;

import java.util.List;

import com.java.model.User;
import com.java.util.stringUtil;

public interface UserDAO {
	public List queryALL() throws Exception;
	public User queryByKeyword(String key)throws Exception;
	public boolean delect(User user)throws Exception;
	public boolean insert(User user)throws Exception;
	public boolean update(User user)throws Exception;
}
