package cn.second_hand.user.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.second_hand.user.domain.User;
import cn.second_hand.user.utils.TxQueryRunner;

public class UserDao {
	private QueryRunner qr = new TxQueryRunner();

	public void register(User user) {
		String sql = "insert into loginInfo(email,password) values(?,?)";
		Object[] param = {
				user.getEmail(),user.getPassword()};
		try {
			qr.update(sql, param);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public User findByEmail(String email) {
		String sql = "select * from loginInfo where email=?";
		try {
			return qr.query(sql, new BeanHandler<User>(User.class),email);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		
		}
	}

}
