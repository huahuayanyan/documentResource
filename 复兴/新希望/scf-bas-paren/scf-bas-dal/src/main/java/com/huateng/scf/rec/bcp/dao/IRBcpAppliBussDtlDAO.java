package com.huateng.scf.rec.bcp.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtlExample;
import java.util.List;
import java.util.Map;

public interface IRBcpAppliBussDtlDAO {
    int countByExample(RBcpAppliBussDtlExample example);

    int deleteByExample(RBcpAppliBussDtlExample example);
    
    int deleteByPrimaryKey(String id);

    void insert(RBcpAppliBussDtl record);

    void insertSelective(RBcpAppliBussDtl record);

    List<RBcpAppliBussDtl> selectByExample(RBcpAppliBussDtlExample example);

    RBcpAppliBussDtl selectByPrimaryKey(String id);

    int updateByExampleSelective(RBcpAppliBussDtl record, RBcpAppliBussDtlExample example);

    int updateByExample(RBcpAppliBussDtl record, RBcpAppliBussDtlExample example);

    int updateByPrimaryKeySelective(RBcpAppliBussDtl record);

    int updateByPrimaryKey(RBcpAppliBussDtl record);

    List<RBcpAppliBussDtl> selectByPage(RBcpAppliBussDtlExample example, Page page);
    
    List<RBcpAppliBussDtl> selectByAppno(String appno);

	@SuppressWarnings("rawtypes")
	List selectAppliBussDtlByAppno(String appno);

	List<String> selectBillsNoBySallerBuyerAndContno(Map<String, Object> parameters);

	//TODO
//	List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl> queryAppliBussDetailByAppno(String appno, String bussType);
	List<RBcpAppliBussDtl> queryAppliBussDetailByAppno(String appno,String bussType);

}