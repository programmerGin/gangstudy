package com.jts.gangstudy.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.jts.gangstudy.domain.User;
import com.jts.gangstudy.mapper.UserMapper;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	UserMapper usermapper;
	
	
	@Override
	public boolean newUser(User user) {
		return usermapper.insertUser(user);
	}

	@Override
	public User UserInfo(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean idDuplicateCheck(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pwMatch(String pw) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findId(String email, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findPw(String id, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User temporaryPw(String pw, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> UserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> SearchUser(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUser(String id, String pw) {
		// TODO Auto-generated method stub
		return false;
	}


}
