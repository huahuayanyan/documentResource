package com.huateng.scf.bas.pbc.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfoExample;
import java.util.List;

public interface IBPbcAppliMtgInfoDAO {
    int countByExample(BPbcAppliMtgInfoExample example);

    int deleteByExample(BPbcAppliMtgInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BPbcAppliMtgInfo record);

    void insertSelective(BPbcAppliMtgInfo record);

    List<BPbcAppliMtgInfo> selectByExample(BPbcAppliMtgInfoExample example);

    BPbcAppliMtgInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BPbcAppliMtgInfo record, BPbcAppliMtgInfoExample example);

    int updateByExample(BPbcAppliMtgInfo record, BPbcAppliMtgInfoExample example);

    int updateByPrimaryKeySelective(BPbcAppliMtgInfo record);

    int updateByPrimaryKey(BPbcAppliMtgInfo record);

    List<BPbcAppliMtgInfo> selectByPage(BPbcAppliMtgInfoExample example, Page page);
    
    //ext
    //根据appno查询押品申请表信息
    List<BPbcAppliMtgInfo> selectByAppno(String appno);
    
    /**
     *  根据appno获取本次申请下的购销合同已提货金额
     * @param appno
     * @return
     */
    List<BPbcAppliMtgInfo> getTradeAppliTotPriceByAppno(String appno);
}