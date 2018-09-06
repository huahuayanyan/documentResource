package com.huateng.scf.bas.pbc.dao;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgMktPriceHis;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgMktPriceHisExample;

public interface IBPbcMtgMktPriceHisDAO {
	int countByExample(BPbcMtgMktPriceHisExample example);

	int deleteByExample(BPbcMtgMktPriceHisExample example);

	int deleteByPrimaryKey(String id);

	void insert(BPbcMtgMktPriceHis record);

	void insertSelective(BPbcMtgMktPriceHis record);

	List<BPbcMtgMktPriceHis> selectByExample(BPbcMtgMktPriceHisExample example);

	BPbcMtgMktPriceHis selectByPrimaryKey(String id);

	int updateByExampleSelective(BPbcMtgMktPriceHis record, BPbcMtgMktPriceHisExample example);

	int updateByExample(BPbcMtgMktPriceHis record, BPbcMtgMktPriceHisExample example);

	int updateByPrimaryKeySelective(BPbcMtgMktPriceHis record);

	int updateByPrimaryKey(BPbcMtgMktPriceHis record);

	List<BPbcMtgMktPriceHis> selectByPage(BPbcMtgMktPriceHisExample example, Page page);
}