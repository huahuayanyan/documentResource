package com.huateng.scf.bas.batch.seq.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.huateng.scf.bas.batch.seq.AbstractIdentityBatch;
import com.huateng.scf.bas.batch.seq.exception.BatchException;

 
public class IdentityBatch extends AbstractIdentityBatch{
	private int startIdentity = 0;
	private int size = 0;
	private int currentPos = 1;
	private int step = 0;
	public IdentityBatch(Connection conn, String identity) {
		super(conn, identity);
	}
	void setSize(int size) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT IDENT_CURRENT('"+identity+"'),IDENT_INCR('"+identity+"')");
		rs.next();
		startIdentity = rs.getInt(1);
		step = rs.getInt(2);
		this.size=size;
		rs.close();
		stmt.close();
		PreparedStatement preparedStatement = conn.prepareStatement("DBCC CHECKIDENT('"+identity+"',RESEED,?)");
		preparedStatement.setInt(1, startIdentity+size*step);
		preparedStatement.execute();
		preparedStatement.close();
	}
	public int nextId() throws BatchException {
		if(size==currentPos++)
		{
			throw new BatchException("no more id");
		}
		return (startIdentity+=step);
	}

}
