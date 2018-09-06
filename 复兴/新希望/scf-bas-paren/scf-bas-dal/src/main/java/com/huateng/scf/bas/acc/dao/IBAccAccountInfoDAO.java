package com.huateng.scf.bas.acc.dao;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.acc.dao.model.BAccAccountInfo;
import com.huateng.scf.bas.acc.dao.model.BAccAccountInfoExample;

public interface IBAccAccountInfoDAO {
	int countByExample(BAccAccountInfoExample example);

	int deleteByExample(BAccAccountInfoExample example);

	int deleteByPrimaryKey(String id);

	void insert(BAccAccountInfo record);

	void insertSelective(BAccAccountInfo record);

	List<BAccAccountInfo> selectByExample(BAccAccountInfoExample example);

	BAccAccountInfo selectByPrimaryKey(String id);

	int updateByExampleSelective(BAccAccountInfo record, BAccAccountInfoExample example);

	int updateByExample(BAccAccountInfo record, BAccAccountInfoExample example);

	int updateByPrimaryKeySelective(BAccAccountInfo record);

	int updateByPrimaryKey(BAccAccountInfo record);

	List<BAccAccountInfo> selectByPage(BAccAccountInfoExample example, Page page);

	// ext批量删除
	int batchDelete(List idList2);
}