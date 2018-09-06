package com.huateng.scf.bas.batch.seq.oracle;

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
	
	public void setSize(int size) throws SQLException 
	{
		idList = new Vector(size);
		Statement statement = conn.createStatement();
		for(int i=0;i<size;i++)
		{
			ResultSet rs = statement.executeQuery("SELECT ("+identity+".nextval) FROM DUAL");
			rs.next();
			idList.add(new Integer(rs.getInt(1)));
			rs.close();
		}
		statement.close();
	}
	public int nextId() throws BatchException {
		if(currentPos>=idList.size())
		{
			throw new BatchException("no more id");
		}
		return ((Integer)idList.get(currentPos++)).intValue();
	}

}
