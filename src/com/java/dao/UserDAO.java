package com.java.dao;

import java.util.List;

import com.java.model.User;

public interface UserDAO {
	public List queryALL() throws Exception;
	public boolean delect(User user)throws Exception;
	public boolean insert(User user)throws Exception;
	public boolean update(User user)throws Exception;
}
