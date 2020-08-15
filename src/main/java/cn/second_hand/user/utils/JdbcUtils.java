package cn.second_hand.user.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * To use the methods of this class, you must provide a c3p0-copnfig.xml file
 */
public class JdbcUtils {
	// 饿汉式
	private static DataSource ds = new ComboPooledDataSource();
	
	/**
	* Null means there are no transactions
	* It is not null to indicate that there is a transaction
	* When a transaction is started, it needs to be assigned a value
	* When the transaction ends, it needs to be assigned null
	* And have multiple methods of the DAO share the Connection when a transaction is started
	 */
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	public static DataSource getDataSource() {
		return ds;
	}
	
	/**
	 * The dao uses this method to get the connection
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		
		Connection con = tl.get();
		if(con != null) return con;
		return ds.getConnection();
	}
	
	/**
	 * Open the transaction
	 * @throws SQLException 
	 */
	public static void beginTransaction() throws SQLException {
		Connection con = tl.get();
		if(con != null) throw new SQLException("Transactions have been opened, cannot be opened repeatedly!");
		con = ds.getConnection();
		con.setAutoCommit(false);
		tl.set(con);
	}
	
	/**
	 * commit transaction
	 * @throws SQLException 
	 */
	public static void commitTransaction() throws SQLException {
		Connection con = tl.get();
		if(con == null) throw new SQLException("No transaction cannot be committed!");
		con.commit();
		con.close();
		con = null;
		tl.remove();
	}
	
	/**
	 * roll back
	 * @throws SQLException 
	 */
	public static void rollbackTransaction() throws SQLException {
		Connection con = tl.get();
		if(con == null) throw new SQLException("No transaction cannot be rolled back!");
		con.rollback();
		con.close();
		con = null;
		tl.remove();
	}
	
	/**
	 * release Connection
	 * @param con
	 * @throws SQLException 
	 */
	public static void releaseConnection(Connection connection) throws SQLException {
		Connection con = tl.get();
		if(connection != con) {
			if(connection != null &&!connection.isClosed()) {
				connection.close();
			}
		}
	}
}
