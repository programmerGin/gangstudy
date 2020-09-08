package com.jts.gangstudy.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import com.jts.gangstudy.domain.Admin;
import com.jts.gangstudy.domain.User;


public interface UserDao {

	

	
	
	// 회원 가입 Create
	boolean newUser(User user);
	
	// 회원 정보 + 예약정보 조회
	User UserInfo(String name);
	
	//회원 수정
	boolean updateUser(User user);
	
	//아이디 중복체크 
	boolean idDuplicateCheck(String id);
	
	//비밀번호 일치여부 체크
	boolean pwMatch(String pw);
	
	//회원 탈퇴
	boolean deleteUser(String id, String pw);
	
	//아이디 찾기
	User findId(String email, String name);
	
	//비밀번호 찾기
	User findPw(String id, String email);
	
	// 임시비밀번호 발급
	User temporaryPw(String pw, String id);
	
	// 회원 목록
	List<User> UserList();
	
	//회원들 이름으로 검색
	List<User> SearchUser(String search);

	
	
	
	
	
	
}
