package com.huateng.scf.sto.nwr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.sto.nwr.dao.model.BPbcPricingMtg;
import com.huateng.scf.sto.nwr.dao.model.BPbcPricingMtgExample;
import java.util.List;

public interface IBPbcPricingMtgDAO {
    int countByExample(BPbcPricingMtgExample example);

    int deleteByExample(BPbcPricingMtgExample example);

    int deleteByPrimaryKey(String id);

    void insert(BPbcPricingMtg record);

    void insertSelective(BPbcPricingMtg record);

    List<BPbcPricingMtg> selectByExample(BPbcPricingMtgExample example);

    BPbcPricingMtg selectByPrimaryKey(String id);

    int updateByExampleSelective(BPbcPricingMtg record, BPbcPricingMtgExample example);

    int updateByExample(BPbcPricingMtg record, BPbcPricingMtgExample example);

    int updateByPrimaryKeySelective(BPbcPricingMtg record);

    int updateByPrimaryKey(BPbcPricingMtg record);

    List<BPbcPricingMtg> selectByPage(BPbcPricingMtgExample example, Page page);
}