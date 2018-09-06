package com.huateng.scf.bas.pbc.dao;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgMktPrice;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgMktPriceExample;

public interface IBPbcMtgMktPriceDAO {
	int countByExample(BPbcMtgMktPriceExample example);

	int deleteByExample(BPbcMtgMktPriceExample example);

	int deleteByPrimaryKey(String id);

	void insert(BPbcMtgMktPrice record);

	void insertSelective(BPbcMtgMktPrice record);

	List<BPbcMtgMktPrice> selectByExample(BPbcMtgMktPriceExample example);

	BPbcMtgMktPrice selectByPrimaryKey(String id);

	int updateByExampleSelective(BPbcMtgMktPrice record, BPbcMtgMktPriceExample example);

	int updateByExample(BPbcMtgMktPrice record, BPbcMtgMktPriceExample example);

	int updateByPrimaryKeySelective(BPbcMtgMktPrice record);

	int updateByPrimaryKey(BPbcMtgMktPrice record);

	List<BPbcMtgMktPrice> selectByPage(BPbcMtgMktPriceExample example, Page page);

	BPbcMtgMktPrice selectObjectByPrimaryKey(BPbcMtgMktPriceExample example);
}