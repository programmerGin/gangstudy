package com.jts.gangstudy.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.jts.gangstudy.domain.User;
import com.jts.gangstudy.domain.Booking;

import com.jts.gangstudy.mapper.UserMapper;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private UserMapper userMapper;

	
	
	
	@Override
	public User selectAdmin(String id) {
		// 관리자 찾기
		return userMapper.selectAdmin(id);
	}
	
	@Override
	public List<User> blackList() {
		// 블랙리스트
		return userMapper.blackList();
	}

	
	
	@Override
	public boolean insertUser(User user) {
		return userMapper.insertUser(user);
	}
	@Override
	public boolean insertKakaoUser(User user) {
		return userMapper.insertUser(user);
	}

	@Override
	public List<User> selectAll() {
		String id = "#";
		return userMapper.selectAll(id);
	}
	
	@Override
	public User selectById(String id) {
		// TODO Auto-generated method stub
		return userMapper.selectById(id);
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUser(user);
	}

	@Override
	public boolean idDuplicateCheck(String id) {

		return userMapper.idDuplicateCheck(id);
	}

	@Override
	public boolean pwMatch(String pw) {

		return userMapper.pwMatch(pw);
	}

	@Override
	public boolean deleteUser(String id, String email) {
		// TODO Auto-generated method stub
		return userMapper.delete(id, email);
	}

	@Override
	public User findId(String email, String name) {
		// TODO Auto-generated method stub
		return userMapper.find_id(email, name);
	}
	@Override
	public User findPw(String id, String email, String phone) {
		// TODO Auto-generated method stub
		return userMapper.findPw(id, email,phone);
	}  

	@Override
	public User temporaryPw(String pw, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> UserList() {

		return userMapper.userList();
	}

	@Override
	public List<User> findUserList(String search) {
		// TODO Auto-generated method stub
		return userMapper.findUserList(search);
	}

	@Override
	public boolean deleteMember(String pw, String email, String retire) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean accountOn(String mRetire, String mEmail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> userBookingList() {
		// TODO Auto-generated method stub
		return userMapper.userBookingList();
	}

	@Override
	public User getUser(int user_no) {
		// TODO Auto-generated method stub
		return userMapper.getUser(user_no);
	}
	
	@Override
	public boolean updatePoints(int user_no, Float points) {
		// TODO Auto-generated method stub
		return userMapper.updatePoints(user_no, points);
	}

	@Override
	public boolean deleteUser(Integer user_no) {
		return userMapper.deleteByUserNo(user_no);
	}
	@Override
	public boolean updateNote(Integer user_no, String note) {
		// TODO Auto-generated method stub
		return userMapper.updateNote(user_no, note);
	}
	@Override
	public boolean updateRate(Integer user_no, Float rate) {
		// TODO Auto-generated method stub
		return userMapper.updateRate(user_no, rate);
	}

	@Override
	public User getUserByNo(int user_no) {
		// TODO Auto-generated method stub
		return userMapper.getUserByno(user_no);
	}

	@Override
	public String getPw(String id) {
		// 암호화된 비번 불러와서 디코딩때 비교하기위함 
		return userMapper.getPw(id);
	}

	@Override
	public boolean changePw(String id, String pw) {
		// TODO Auto-generated method stub
		return userMapper.updatePw(id, pw);
	}

	

	
	
}
