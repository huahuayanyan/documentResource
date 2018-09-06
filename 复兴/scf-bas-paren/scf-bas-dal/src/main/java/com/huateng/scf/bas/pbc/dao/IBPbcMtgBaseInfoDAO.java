package com.huateng.scf.bas.pbc.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfoExample;

public interface IBPbcMtgBaseInfoDAO {
	int countByExample(BPbcMtgBaseInfoExample example);

	int deleteByExample(BPbcMtgBaseInfoExample example);

	int deleteByPrimaryKey(String mortgageNo);

	void insert(BPbcMtgBaseInfo record);

	void insertSelective(BPbcMtgBaseInfo record);

	List<BPbcMtgBaseInfo> selectByExample(BPbcMtgBaseInfoExample example);

	BPbcMtgBaseInfo selectByPrimaryKey(String mortgageNo);

	int updateByExampleSelective(BPbcMtgBaseInfo record, BPbcMtgBaseInfoExample example);

	int updateByExample(BPbcMtgBaseInfo record, BPbcMtgBaseInfoExample example);

	int updateByPrimaryKeySelective(BPbcMtgBaseInfo record);

	int updateByPrimaryKey(BPbcMtgBaseInfo record);

	List<BPbcMtgBaseInfo> selectByPage(BPbcMtgBaseInfoExample example, Page page);

	@SuppressWarnings("rawtypes")
	List<Map> selectByCondition(String contno);
}