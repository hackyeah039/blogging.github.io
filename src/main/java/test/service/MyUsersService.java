package test.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.dao.MyUsersDao;

@Service
public class MyUsersService {
	
	@Autowired
	private MyUsersDao dao;
	
	public boolean isMember(HashMap<String, Object> map) {
		HashMap<String, Object> user=dao.isMember(map);
		if(user==null) {
			return false;
		}else {
			return true;
		}
	}
}
