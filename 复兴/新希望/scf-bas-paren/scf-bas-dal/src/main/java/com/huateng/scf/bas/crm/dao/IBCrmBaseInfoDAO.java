package com.huateng.scf.bas.crm.dao;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfoExample;

public interface IBCrmBaseInfoDAO {
	int countByExample(BCrmBaseInfoExample example);

	int deleteByExample(BCrmBaseInfoExample example);

	void insert(BCrmBaseInfo record);

	void insertSelective(BCrmBaseInfo record);

	List<BCrmBaseInfo> selectByExample(BCrmBaseInfoExample example);

	int updateByExampleSelective(BCrmBaseInfo record, BCrmBaseInfoExample example);

	int updateByExample(BCrmBaseInfo record, BCrmBaseInfoExample example);

	List<BCrmBaseInfo> selectByPage(BCrmBaseInfoExample example, Page page);

	BCrmBaseInfo selectById(String custcd);
	// ext批量删除
	int batchDelete(List custcd2List);
}