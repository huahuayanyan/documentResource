package com.huateng.scf.sto.nwr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.sto.nwr.dao.model.BPbcPricingBaseInfo;
import com.huateng.scf.sto.nwr.dao.model.BPbcPricingBaseInfoExample;
import java.util.List;

public interface IBPbcPricingBaseInfoDAO {
    int countByExample(BPbcPricingBaseInfoExample example);

    int deleteByExample(BPbcPricingBaseInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BPbcPricingBaseInfo record);

    void insertSelective(BPbcPricingBaseInfo record);

    List<BPbcPricingBaseInfo> selectByExample(BPbcPricingBaseInfoExample example);

    BPbcPricingBaseInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BPbcPricingBaseInfo record, BPbcPricingBaseInfoExample example);

    int updateByExample(BPbcPricingBaseInfo record, BPbcPricingBaseInfoExample example);

    int updateByPrimaryKeySelective(BPbcPricingBaseInfo record);

    int updateByPrimaryKey(BPbcPricingBaseInfo record);

    List<BPbcPricingBaseInfo> selectByPage(BPbcPricingBaseInfoExample example, Page page);
}