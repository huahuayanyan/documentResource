package com.huateng.scf.bas.batch.seq.db2;

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
	public InsertHelper(Connection conn, String _identity) {
		//modify by hui.liu 2011-05-12 SCF SEQ
//		super(conn, "SEQ_BMS_"+_identity);
		super(conn, "SEQ_SCF_"+_identity);
		if (_identity.length()>4 && _identity.substring(0,4).equalsIgnoreCase("TBL_")){
			this.identity="SEQ_"+_identity.substring(4);
		}
	}

	public void beginInsert() throws SQLException {
		stmt = conn.createStatement();
		insertBegined = true;
	}

	public PreparedStatement createPrepareStatement(String insertQL)
			throws SQLException, BatchException {
		if(!insertBegined)throw new BatchException("YOU.SOULD.CALL.beginInsert.FIRST");
		String strIdentity = "\\Q@identity\\E";
		insertQL = insertQL.replaceAll(strIdentity, "(NEXTVAL FOR "+identity+")");
		PreparedStatement preparedStatement = conn.prepareStatement(insertQL);
		return preparedStatement;
	}

	public PreparedStatement createPrepareStatement(String insertQL,
			int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException, BatchException {
		if(!insertBegined)throw new BatchException("YOU.SOULD.CALL.beginInsert.FIRST");
		String strIdentity = "\\Q@identity\\E";
		insertQL = insertQL.replaceAll(strIdentity, "(NEXTVAL FOR "+identity+")");
		PreparedStatement preparedStatement = conn.prepareStatement(insertQL,resultSetType,resultSetConcurrency,resultSetHoldability);
		return preparedStatement;
	}

	public void endInsert() throws SQLException {
		if (insertBegined){
			stmt.close();
		}
		insertBegined = false;
	}

	public int executeInsert(String insertQL) throws SQLException,
			BatchException {
		if(!insertBegined)throw new BatchException("YOU.SOULD.CALL.beginInsert.FIRST");
		String strIdentity = "\\Q@identity\\E";
		insertQL = insertQL.replaceAll(strIdentity, "(NEXTVAL FOR "+identity+")");
		stmt.executeUpdate(insertQL);
		ResultSet rs = stmt.executeQuery("VALUES PREVVAL FOR "+identity);
		rs.next();
		int result = rs.getInt(1);
		rs.close();
		return result;
	}

	public IdentityBatch genIdentifyBatch(int size) throws SQLException,
			BatchException {
		if(!insertBegined)throw new BatchException("YOU.SOULD.CALL.beginInsert.FIRST");
		com.huateng.scf.bas.batch.seq.db2.IdentityBatch identityBatch = new com.huateng.scf.bas.batch.seq.db2.IdentityBatch(conn,identity);
		identityBatch.setSize(size);
		return identityBatch;
	}

	public int getCurrentValue() throws SQLException, BatchException {
		if(!insertBegined)throw new BatchException("YOU.SOULD.CALL.beginInsert.FIRST");
		ResultSet resultSet = stmt.executeQuery("(VALUES PREVVAL FOR "+identity+")");
		resultSet.next();
		int result = resultSet.getInt(1);
		return result;
	}

	public int getNextValue() throws SQLException, BatchException {
		if(!insertBegined)throw new BatchException("YOU.SOULD.CALL.beginInsert.FIRST");
		ResultSet resultSet = stmt.executeQuery("VALUES NEXTVAL FOR "+identity);
		resultSet.next();
		int result = resultSet.getInt(1);
		return result;
	}

}
