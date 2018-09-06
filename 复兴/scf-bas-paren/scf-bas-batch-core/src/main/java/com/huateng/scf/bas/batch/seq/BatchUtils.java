package com.huateng.scf.bas.batch.seq;

import java.io.IOException;
import java.sql.Connection;

import com.huateng.scf.bas.batch.common.BatchConstant;
import com.huateng.scf.bas.batch.common.BatchUtil;
import com.huateng.scf.bas.batch.seq.InsertHelper;

/**
 * �����?����
 * @author cixiang
 *
 */
public class BatchUtils {
	private BatchUtils(){}
	public static final String DB_TYPE_SQLSERVER_2005 = "DB_TYPE_SQLSERVER_2005";
	public static final String DB_TYPE_DB_2 = "DB_TYPE_DB_2";
	public static final String DB_TYPE_ORACLE_9I = "DB_TYPE_ORACLE_9I";
	public static final String DB_TYPE_INFORMIX = "DB_TYPE_INFORMIX";
	private static String currentIdentityType=DB_TYPE_SQLSERVER_2005;
	/**
	 * ���õ�ǰ��ݿ�����
	 * @param dbType ��ݿ������ַ�Ŀǰ��ȡDB_TYPE_SQLSERVER_2005��DB_TYPE_DB_2��DB_TYPE_ORACLE_9I֮һ��Ĭ��ΪDB_TYPE_SQLSERVER_2005
	 */
	public static void setCurrentDbType(String dbType)
	{
		currentIdentityType = dbType;
	}
	/**
	 * 默认数据库，在batch.properties里面指定。DataBase_type=DB_TYPE_SQLSERVER_2005
	 *DB_TYPE_DB_2，DB_TYPE_ORACLE_9I，DB_TYPE_SQLSERVER_2005
	 */
	public static void setCurrentDbType()
	{
		String str;
		try {
			str = BatchUtil.getBatchProperty(BatchConstant.DataBase_type,"");
			currentIdentityType=str;
		} catch (IOException e) {			
			e.printStackTrace();
		}		
	}
	/**
	 * ��ȡһ��InsertHelper��
	 * @param conn ��ݿ�l��
	 * @param identityName ��ʶ���
	 * @return InsertHelper��
	 */
	public static InsertHelper getInsertHelper(Connection conn,String identityName)
	{
		if(DB_TYPE_SQLSERVER_2005.equals(currentIdentityType))
		{
			return new com.huateng.scf.bas.batch.seq.sqlserver.InsertHelper(conn,identityName);
		}
		if(DB_TYPE_DB_2.equals(currentIdentityType))
		{
			return new com.huateng.scf.bas.batch.seq.db2.InsertHelper(conn,identityName);
		}
		if(DB_TYPE_ORACLE_9I.equals(currentIdentityType))
		{
			return new com.huateng.scf.bas.batch.seq.oracle.InsertHelper(conn,identityName);
		}
		if(DB_TYPE_INFORMIX.equals(currentIdentityType))
		{
			return new com.huateng.scf.bas.batch.seq.informix.InsertHelper(conn,identityName);
		}
		return null;
	}
	
}
