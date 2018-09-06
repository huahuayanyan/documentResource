package com.huateng.scf.bas.pbc.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliOrderBussInfo;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliOrderBussInfoExample;
import java.util.List;

public interface IBPbcAppliOrderBussInfoDAO {
    int countByExample(BPbcAppliOrderBussInfoExample example);

    int deleteByExample(BPbcAppliOrderBussInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BPbcAppliOrderBussInfo record);

    void insertSelective(BPbcAppliOrderBussInfo record);

    List<BPbcAppliOrderBussInfo> selectByExample(BPbcAppliOrderBussInfoExample example);

    BPbcAppliOrderBussInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BPbcAppliOrderBussInfo record, BPbcAppliOrderBussInfoExample example);

    int updateByExample(BPbcAppliOrderBussInfo record, BPbcAppliOrderBussInfoExample example);

    int updateByPrimaryKeySelective(BPbcAppliOrderBussInfo record);

    int updateByPrimaryKey(BPbcAppliOrderBussInfo record);

    List<BPbcAppliOrderBussInfo> selectByPage(BPbcAppliOrderBussInfoExample example, Page page);
}