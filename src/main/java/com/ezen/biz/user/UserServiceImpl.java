package com.ezen.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.biz.dao.UserDAO;
import com.ezen.biz.dto.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;
	
	@Override
	public UserVO getUser(UserVO vo) {
		
		return userDao.getUser(vo);
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

}
