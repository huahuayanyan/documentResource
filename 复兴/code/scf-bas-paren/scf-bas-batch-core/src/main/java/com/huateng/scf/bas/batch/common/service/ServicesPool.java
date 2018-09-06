/**
 *
 */
package com.huateng.scf.bas.batch.common.service;

import java.util.HashMap;

import com.huateng.scf.bas.batch.common.BatchConstant;
import com.huateng.scf.bas.batch.common.BatchUtil;
import com.huateng.scf.bas.batch.security.CryptionData;
import com.huateng.scf.bas.batch.common.service.ConnectionPool;
import com.huateng.scf.bas.batch.common.service.Pool;
import com.huateng.scf.bas.batch.common.service.ServiceDestroyFailedException;
import com.huateng.scf.bas.batch.common.service.ServiceInitialFailedException;
import com.huateng.scf.bas.batch.common.service.ServiceNotFoundException;


public class ServicesPool {
	private static HashMap cache = new HashMap();
	private static HashMap connectionPoolParam = new HashMap();

	public ServicesPool() {
	}

	public static ConnectionPool getConnectionPool()
		throws ServiceNotFoundException {

		Object service =
			cache.get((String) connectionPoolParam.get("serviceName"));
		if (service == null) {
			throw new ServiceNotFoundException();
		}
		return (ConnectionPool) service;
	}

	public static void destroyConnectionPool()
		throws ServiceDestroyFailedException {
		ConnectionPool pool =
			(ConnectionPool) cache.get(
				(String) connectionPoolParam.get("serviceName"));

		if (pool == null) {
			throw new ServiceDestroyFailedException("No pool to be destroyed");
		}

		pool.destroy();
	}

	public static void initialize() throws ServiceInitialFailedException {

		try {

			connectionPoolParam.put(
				"classname",
				BatchUtil.getBatchProperty(
					"DataBase_ClassName",
					"com.huateng.scf.bas.batch.common.service.DefaultConnectionPool"));
			connectionPoolParam.put(
				"serviceName",
				BatchUtil.getBatchProperty(
					"DataBase_ServiceName",
					"connectionpool"));
			connectionPoolParam.put(
				"maxSize",
				BatchUtil.getBatchProperty("DataBase_MaxSize", "10"));
			connectionPoolParam.put(
				"minSize",
				BatchUtil.getBatchProperty("DataBase_MinSize", "5"));
			connectionPoolParam.put(
				"timeout",
				BatchUtil.getBatchProperty("DataBase_TimeOut", "500"));

			connectionPoolParam.put(
				"jdbcDriver",
				BatchUtil.getBatchProperty(
					"DataBase_Driver",
					"COM.ibm.db2.jdbc.app.DB2Driver"));
			/**
			 * modify by weikun wang 2008.7.16 change jdbc:db2:BOCOMPL  to jdbc:db2://182.119.171.145:55000/SEMSDB
			 */
			connectionPoolParam.put(
				"jdbcUrl",
				BatchUtil.getBatchProperty("DataBase_URL", "jdbc:db2://182.119.171.145:55000/SEMSDB"));
			/**
			 * modify by weikun wang 2008.7.16 change db2ipl  to sems
			 */
			connectionPoolParam.put(
				"user",
				BatchUtil.getBatchProperty("DataBase_UserID", "sems"));

			CryptionData cryptionData =
				new CryptionData(BatchConstant.DEFAULT_PASSWORD_KEY);

			/*
			 * 放开批量数据库口令加解密
			 */
			//modify by hui.liu 2011-05-12 SCF 更新 密码不加密 begin
//			connectionPoolParam.put(
//				"password",
//				cryptionData.DecryptionStringData(
//					BatchUtil.getBatchProperty(
//						"DataBase_Password",
//						"3N3gtY5e5pw=")));
			connectionPoolParam.put(
					"password",	BatchUtil.getBatchProperty(
						"DataBase_Password",	""));
			//modify by hui.liu 2011-05-12 SCF 更新 密码不加密 end

			Class serviceClass =
				Class.forName((String) connectionPoolParam.get("classname"));
			Pool serviceInstance = (Pool) (serviceClass.newInstance());
			// Initialize each service instance
			serviceInstance.initialize(connectionPoolParam);
			cache.put(
				(String) connectionPoolParam.get("serviceName"),
				serviceInstance);
		} catch (Exception e) {
			throw new ServiceInitialFailedException(e);
		}

	}

}
