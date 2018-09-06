package com.huateng.scf.bas.batch.seq;

import java.sql.Connection;

public abstract class AbstractInsertHelper implements InsertHelper {
	protected static Object lock;
	protected Connection conn = null;
	protected String identity = null;
	public AbstractInsertHelper(Connection conn,String identity)
	{
		this.conn = conn;
		this.identity = identity; 
	}
}
