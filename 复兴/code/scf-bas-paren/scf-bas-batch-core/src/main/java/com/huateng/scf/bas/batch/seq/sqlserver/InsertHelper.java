package com.huateng.scf.bas.batch.seq.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.huateng.scf.bas.batch.seq.AbstractInsertHelper;
import com.huateng.scf.bas.batch.seq.IdentityBatch;
import com.huateng.scf.bas.batch.seq.exception.BatchException;


public class InsertHelper extends AbstractInsertHelper{
	private boolean insertBegined = false;
	private Statement stmt = null;
	public InsertHelper(Connection conn, String identity) {
		super(conn, identity);
	}

	public void beginInsert() throws SQLException {
		stmt = conn.createStatement();
		stmt.execute("set IDENTITY_INSERT "+identity+" on;");
		insertBegined = true;
	}

	public void endInsert() throws SQLException {
		if ( insertBegined ){
			stmt.execute("set IDENTITY_INSERT "+identity+" off;");
			stmt.close();
		}	
		insertBegined = false;
	}

	public IdentityBatch genIdentifyBatch(int size) throws SQLException, BatchException {
		if(!insertBegined)throw new BatchException("YOU.SOULD.CALL.beginInsert.FIRST");
		com.huateng.scf.bas.batch.seq.sqlserver.IdentityBatch identityBatch = new com.huateng.scf.bas.batch.seq.sqlserver.IdentityBatch(conn,identity);
		identityBatch.setSize(size);
		return identityBatch;
	}

	public int getCurrentValue() throws SQLException, BatchException {
		if(!insertBegined)throw new BatchException("YOU.SOULD.CALL.beginInsert.FIRST");
		ResultSet rs = stmt.executeQuery("SELECT IDENT_CURRENT('"+identity+"')");
		rs.next();
		int result = rs.getInt(1);
		rs.close();
		return result;
	}

	public int getNextValue() throws SQLException, BatchException {
		if(!insertBegined)throw new BatchException("YOU.SOULD.CALL.beginInsert.FIRST");
		synchronized (lock) {
			ResultSet rs = stmt.executeQuery("SELECT IDENT_CURRENT('"+identity+"')+IDENT_INCR('"+identity+"');");
			rs.next();
			int result = rs.getInt(1);
			rs.close();
			PreparedStatement preparedStatement = conn.prepareStatement("DBCC CHECKIDENT('"+identity+"',RESEED,?)");
			preparedStatement.setInt(1, result);
			preparedStatement.execute();
			return result;
		}
	}

	public int executeInsert(String insertQL) throws SQLException, BatchException {
		if(!insertBegined)throw new BatchException("YOU.SOULD.CALL.beginInsert.FIRST");
		String strIdentity = "\\Q@identity\\E";
		insertQL = insertQL.replaceAll(strIdentity, "IDENT_CURRENT('"+identity+"')+IDENT_INCR('"+identity+"')");
		stmt.executeUpdate(insertQL);
		ResultSet rs = stmt.executeQuery("SELECT IDENT_CURRENT('"+identity+"')");
		rs.next();
		int result = rs.getInt(1);
		rs.close();
		return result;
	}

	public PreparedStatement createPrepareStatement(String insertQL)
			throws SQLException, BatchException {
		if(!insertBegined)throw new BatchException("YOU.SOULD.CALL.beginInsert.FIRST");
		String strIdentity = "\\Q@identity\\E";
		insertQL = insertQL.replaceAll(strIdentity, "IDENT_CURRENT('"+identity+"')+IDENT_INCR('"+identity+"')");
		PreparedStatement preparedStatement = conn.prepareStatement(insertQL);
		return preparedStatement;
	}

	public PreparedStatement createPrepareStatement (String insertQL, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
			throws SQLException, BatchException {
		if(!insertBegined)throw new BatchException("YOU.SOULD.CALL.beginInsert.FIRST");
		String strIdentity = "\\Q@identity\\E";
		insertQL = insertQL.replaceAll(strIdentity, "IDENT_CURRENT('"
				+ identity + "')+IDENT_INCR('" + identity + "')");
		PreparedStatement preparedStatement = conn.prepareStatement(insertQL,resultSetType,resultSetConcurrency,resultSetHoldability);
		return preparedStatement;
	}


}
