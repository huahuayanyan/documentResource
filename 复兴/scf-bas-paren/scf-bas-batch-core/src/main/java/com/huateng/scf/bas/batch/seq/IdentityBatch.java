package com.huateng.scf.bas.batch.seq;

import com.huateng.scf.bas.batch.seq.exception.BatchException;

public interface IdentityBatch {
	int nextId() throws BatchException;
}
 