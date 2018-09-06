package com.huateng.scf.bas.batch.seq;

import java.sql.Connection;
 
public abstract class AbstractIdentityBatch implements IdentityBatch {
	protected Connection conn = null;
	protected String identity = null;
	public AbstractIdentityBatch(Connection conn,String identity) {
		this.conn = conn;
		this.identity = identity;
	}
}
