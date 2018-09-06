package com.huateng.scf.bas.batch.seq.informix;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.huateng.scf.bas.batch.seq.AbstractInsertHelper;
import com.huateng.scf.bas.batch.seq.IdentityBatch;
import com.huateng.scf.bas.batch.seq.exception.BatchException;


public class InsertHelper extends AbstractInsertHelper {
	private boolean insertBegined = false;
	private Statement stmt = null;
	
	public InsertHelper(Connection conn, String identity) {
		super(conn, identity);
	}

	public void beginInsert() throws SQLException {
		stmt = conn.createStatement();
		insertBegined = true;
	}

	public PreparedStatement createPrepareStatement(String insertQL) throws SQLException, BatchException {
		if(!insertBegined)throw new BatchException("YOU.SOULD.CALL.beginInsert.FIRST");
		String strIdentity = "\\Q@identity\\E";
		insertQL = insertQL.replaceAll(strIdentity, "0");
		PreparedStatement preparedStatement = conn.prepareStatement(insertQL);
		return preparedStatement;
	}

	public PreparedStatement createPrepareStatement(String insertQL, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
			throws SQLException, BatchException {
		if(!insertBegined)throw new BatchException("YOU.SOULD.CALL.beginInsert.FIRST");
		String strIdentity = "\\Q@identity\\E";
		insertQL = insertQL.replaceAll(strIdentity, "0");
		PreparedStatement preparedStatement = conn.prepareStatement(insertQL,resultSetType,resultSetConcurrency,resultSetHoldability);
		return preparedStatement;
	}

	public void endInsert() throws SQLException {
		if (insertBegined){
			stmt.close();
		}
		insertBegined = false;
	}

	public int executeInsert(String insertQL) throws SQLException, BatchException {
		if(!insertBegined)throw new BatchException("YOU.SOULD.CALL.beginInsert.FIRST");
		String strIdentity = "\\Q@identity\\E";
		insertQL = insertQL.replaceAll(strIdentity, "0");
		stmt.executeUpdate(insertQL);//Update();
		ResultSet rs = stmt.executeQuery("select first 1 case when dbinfo('serial8') = 0 then " +
		         "(select dbinfo('sqlca.sqlerrd1') from systables where tabid = 1 ) " +
		         "else (select dbinfo('serial8') from systables where tabid = 1 )+0 " +
		         "end from systables");
		rs.next();
		int result = rs.getInt(1);
		rs.close();
		return result;
	}

	public IdentityBatch genIdentifyBatch(int size) throws SQLException, BatchException {
		throw new BatchException("INFORMIX NOT SUPPORT IDENTITYBATCH");
//		if(!insertBegined)throw new BatchException("YOU.SOULD.CALL.beginInsert.FIRST");
//		batchUitls.informix.IdentityBatch identityBatch = new batchUitls.informix.IdentityBatch(conn,identity);
//		identityBatch.setSize(size);
//		return identityBatch;
	}

	public int getCurrentValue() throws SQLException, BatchException {
		if(!insertBegined)throw new BatchException("YOU.SOULD.CALL.beginInsert.FIRST");
		ResultSet resultSet = stmt.executeQuery("select first 1 case when dbinfo('serial8') = 0 then " +
		         "(select dbinfo('sqlca.sqlerrd1') from systables where tabid = 1 ) " +
		         "else (select dbinfo('serial8') from systables where tabid = 1 )+0 " +
		         "end from systables");
		resultSet.next();
		int result = resultSet.getInt(1);
		return result;
	}

	public int getNextValue() throws SQLException, BatchException {
		throw new BatchException("INFORMIX NOT SUPPORT GETNEXTVALUE");
//		if(!insertBegined)throw new BatchException("YOU.SOULD.CALL.beginInsert.FIRST");
//		ResultSet resultSet = stmt.executeQuery("select first 1 case when dbinfo('serial8') = 0 then " +
//		         "(select dbinfo('sqlca.sqlerrd1') from systables where tabid = 1 ) " +
//		         "else (select dbinfo('serial8') from systables where tabid = 1 )+0 " +
//		         "end from systables");
//		resultSet.next();
//		int result = resultSet.getInt(1)+1;
//		return result;
	}

}
