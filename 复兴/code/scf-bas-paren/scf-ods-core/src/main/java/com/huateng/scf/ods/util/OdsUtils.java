package com.huateng.scf.ods.util;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.database.DatabaseMeta;
import org.pentaho.di.repository.kdr.KettleDatabaseRepository;
import org.pentaho.di.repository.kdr.KettleDatabaseRepositoryMeta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OdsUtils {
	private static final String DB_IP="170.252.200.55";
	private static final String DB_PORT="1521";
	private static final String DB_USER="scf";
	private static final String DB_PW="scf";
	private static final String DB_SIT="dev";
	private static final String REPOSITORY_USER="admin";
	private static final String REPOSITORY_PW="admin";
	private static final OdsUtils utils=new OdsUtils();
	
	private Logger logger = LoggerFactory.getLogger(OdsUtils.class);
	
	private OdsUtils(){
		
	}
	
	public static OdsUtils getUtils(){
		return utils;
	}
	
	public KettleDatabaseRepository getConn(){
		try {
			KettleEnvironment.init();
			//EnvUtil.environmentInit();
			DatabaseMeta dataMeta=new DatabaseMeta("ETL-DB", "ORACLE", "Native (JDBC)", DB_IP, DB_SIT, DB_PORT, DB_USER, DB_PW);
			
			KettleDatabaseRepositoryMeta repInfo=new KettleDatabaseRepositoryMeta();
			repInfo.setConnection(dataMeta);
			KettleDatabaseRepository rep=new KettleDatabaseRepository();
			rep.init(repInfo);
			rep.connect(REPOSITORY_USER, REPOSITORY_PW);
			
			if(rep.isConnected()){
				return rep;
			}else{
				throw new Exception("获取ETL资源数据库连接失败！");
			}
		} catch (Exception e) {
			logger.error("获取ETL资源数据库连接失败！", e);
		}
		return null;
	}
}
