package com.huateng.scf.bas.prd.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.dao.model.BPrdIndustryType;
import com.huateng.scf.bas.prd.dao.model.BPrdIndustryTypeExample;
import java.util.List;

public interface IBPrdIndustryTypeDAO {
    int countByExample(BPrdIndustryTypeExample example);

    int deleteByExample(BPrdIndustryTypeExample example);

    int deleteByPrimaryKey(String id);

    void insert(BPrdIndustryType record);

    void insertSelective(BPrdIndustryType record);

    List<BPrdIndustryType> selectByExample(BPrdIndustryTypeExample example);

    BPrdIndustryType selectByPrimaryKey(String id);

    int updateByExampleSelective(BPrdIndustryType record, BPrdIndustryTypeExample example);

    int updateByExample(BPrdIndustryType record, BPrdIndustryTypeExample example);

    int updateByPrimaryKeySelective(BPrdIndustryType record);

    int updateByPrimaryKey(BPrdIndustryType record);

    List<BPrdIndustryType> selectByPage(BPrdIndustryTypeExample example, Page page);
    
    BPrdIndustryType selectByProductId(String productId);
}