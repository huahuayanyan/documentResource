package com.huateng.scf.rec.bcp.dao.ext;

import java.util.List;

import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtlExample;



public interface ExtBcpAppliBussDtlDAO {
	 List<RBcpAppliBussDtl> selectByExample(RBcpAppliBussDtlExample example);
	
}