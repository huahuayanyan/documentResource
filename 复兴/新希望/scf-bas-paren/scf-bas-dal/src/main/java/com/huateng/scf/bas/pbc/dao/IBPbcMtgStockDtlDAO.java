package com.huateng.scf.bas.pbc.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgStockDtl;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgStockDtlExample;

import java.util.List;

public interface IBPbcMtgStockDtlDAO {
    int countByExample(BPbcMtgStockDtlExample example);

    int deleteByExample(BPbcMtgStockDtlExample example);

    int deleteByPrimaryKey(String id);

    void insert(BPbcMtgStockDtl record);

    void insertSelective(BPbcMtgStockDtl record);

    List<BPbcMtgStockDtl> selectByExample(BPbcMtgStockDtlExample example);

    BPbcMtgStockDtl selectByPrimaryKey(String id);

    int updateByExampleSelective(BPbcMtgStockDtl record, BPbcMtgStockDtlExample example);

    int updateByExample(BPbcMtgStockDtl record, BPbcMtgStockDtlExample example);

    int updateByPrimaryKeySelective(BPbcMtgStockDtl record);

    int updateByPrimaryKey(BPbcMtgStockDtl record);

    List<BPbcMtgStockDtl> selectByPage(BPbcMtgStockDtlExample example, Page page);

    //EXT
	/**
	 * 根据appno查询押品信息变更明细
	 * @param appno
	 * @return
	 */
	List<BPbcMtgStockDtl> selectByAppno(String appno);
}