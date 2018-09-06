/*
 * 创建日期 2007-8-31
 *
 * 更改所生成文件模板为
 * 窗口 > 首选项 > Java > 代码生成 > 代码和注释
 */
package com.huateng.scf.bas.batch.common.service;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

/**
 * @author ShaoZhiGang
 * 
 * 更改所生成类型注释的模板为 窗口 > 首选项 > Java > 代码生成 > 代码和注释
 */
public class DefaultConnectionPool implements ConnectionPool {

	private int connectionLimit;

	private int connLowLimit;

	private Connection[] connections;

	private int[] status;

	private boolean inited = false;

	private Integer lock = new Integer(0);

	private final int FREE = 0;

	private final int USED = 1;

	// init parameter
	int defaultTimeout;

	private String jdbcDriver;

	private String jdbcUrl;

	private Properties prop = new Properties();

	/**
	 * 
	 */
	public DefaultConnectionPool() {
		super();
		// TODO 自动生成构造函数存根
	}

	public synchronized void destroy() throws ServiceDestroyFailedException {
		if (!inited) {
			return;
		}

		try {
			for (int i = 0; i < connectionLimit; i++) {
				if (connections[i] != null) {
					connections[i].commit();
					connections[i].close();
				}

			}
		} catch (SQLException e) {
			throw new ServiceDestroyFailedException(e);
		}

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.huateng.bocompl.batch.common.service.ConnectionPool#get()
	 */
	public Connection get() throws SQLException, ServiceNotInitialException {
		// TODO 自动生成方法存根
		return get(defaultTimeout);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.huateng.bocompl.batch.common.service.ConnectionPool#get(int)
	 */
	public Connection get(int timeout) throws SQLException,
			ServiceNotInitialException {
		// TODO 自动生成方法存根
		int loop = 0;
		while (true) {
			synchronized (lock) {
				if (!inited) {
					throw new ServiceNotInitialException();
				}
				for (int i = 0; i < connectionLimit; i++) {
					if (status[i] == FREE) {
						Connection connection = connections[i];
						if (connection != null) {
							try {
								connection.commit();
							} catch (SQLException e) {
								// reInitialize this connection
								try {
									connection.close();
								} catch (SQLException ex) {
									ex.printStackTrace();
								}
								try {
									connection = DriverManager.getConnection(
											jdbcUrl, prop);
								} catch (SQLException sqle) {
									System.out.println("///////////////");
									sqle.printStackTrace();
									System.out.println("///////////////");
								}

								connection.setAutoCommit(false);
								connections[i] = connection;
							}
						} else {

							connection = DriverManager.getConnection(jdbcUrl,
									prop);

							connection.setAutoCommit(false);
							connections[i] = connection;
						}
						status[i] = USED;
						return connection;
					}
				}
				if (loop == 0) {
					try {
						lock.wait(timeout);
						loop++;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					throw (new SQLException(
							"time out : no connection available"));
				}
			}
		}
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.huateng.bocompl.batch.common.service.ConnectionPool#release(java.sql.Connection)
	 */
	public void release(Connection connection) {
		// TODO 自动生成方法存根
		if (connection == null)
			return;
		int i;
		for (i = 0; i < connectionLimit; i++) {
			if (connections[i] == connection) {
				synchronized (lock) {
					if (status[i] != FREE) {
						status[i] = FREE;
						if (i >= connLowLimit) {
							try {
								connection.commit();
							} catch (SQLException e) {
							}
							try {
								connection.close();
							} catch (SQLException e) {
							}
							connections[i] = null;
						}
						lock.notify();
					} else {
						// connection was already released;
					}
					return;
				}
			}
		}
		// invalid connection which isn't in the connection pool
		try {
			connection.close();
		} catch (SQLException e) {
		}
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.huateng.bocompl.batch.common.service.Pool#initialize(java.util.HashMap)
	 */
	public void initialize(HashMap params) throws ServiceInitialFailedException {
		// TODO 自动生成方法存根
		Iterator iter = params.keySet().iterator();
		String key, value;
		while (iter.hasNext()) {
			key = (String) iter.next();
			value = (String) params.get(key);
			if (key.equals("minSize")) {
				connLowLimit = Integer.parseInt(value);
			} else if (key.equals("maxSize")) {
				connectionLimit = Integer.parseInt(value);
			} else if (key.equals("timeout")) {
				defaultTimeout = Integer.parseInt(value);
			} else if (key.equals("jdbcDriver")) {
				jdbcDriver = value;
			} else if (key.equals("jdbcUrl")) {
				jdbcUrl = value;
			} else {
				// All other things are properties.
				prop.put(key, value);
			}
		}
		init();
	}

	private synchronized void init() throws ServiceInitialFailedException {
		if (!inited) {
			try {
				Class driver = Class.forName(jdbcDriver);
				Driver driverInstance = (Driver) (driver.newInstance());
				DriverManager.registerDriver(driverInstance);
			} catch (Exception e) {
				throw new ServiceInitialFailedException(e);
			}
			connections = new Connection[connectionLimit];
			status = new int[connectionLimit];
			for (int i = 0; i < connectionLimit; i++) {
				status[i] = FREE;
			}
			inited = true;
		}
	}

}
