package test.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyUsersDao {
	
	@Autowired
	private SqlSession session;
	public HashMap<String, Object> isMember(HashMap<String, Object> map){
		return session.selectOne("mybatis.MyUsersMapper.isMember",map);
	}
}
