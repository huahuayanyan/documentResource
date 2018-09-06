package com.huateng.scf.bas.batch.seq.informix;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import com.huateng.scf.bas.batch.seq.AbstractIdentityBatch;
import com.huateng.scf.bas.batch.seq.exception.BatchException;


public class IdentityBatch extends AbstractIdentityBatch {
	private List idList = null;
	private int currentPos = 1;
	
	public IdentityBatch(Connection conn, String identity) {
		super(conn, identity);
	}

	public int nextId() throws BatchException {
		if(currentPos>=idList.size())
		{
			throw new BatchException("no more id");
		}
		return ((Integer)idList.get(currentPos++)).intValue();
	}

	public void setSize(int size) throws SQLException {
		idList = new Vector(size);
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery("select first 1 case when dbinfo('serial8') = 0 then " +
		         "(select dbinfo('sqlca.sqlerrd1') from systables where tabid = 1 ) " +
		         "else (select dbinfo('serial8') from systables where tabid = 1 )+0 " +
		         "end from systables");
		rs.next();
		for(int i=0;i<size;i++)
		{
			idList.add(new Integer(rs.getInt(1)+i));
			rs.close();
		}
		statement.close();
	}

}
