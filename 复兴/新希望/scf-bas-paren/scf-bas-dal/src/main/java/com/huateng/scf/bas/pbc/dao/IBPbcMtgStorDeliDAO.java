package com.huateng.scf.bas.pbc.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgStorDeli;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgStorDeliExample;
import java.util.List;

public interface IBPbcMtgStorDeliDAO {
    int countByExample(BPbcMtgStorDeliExample example);

    int deleteByExample(BPbcMtgStorDeliExample example);

    int deleteByPrimaryKey(String id);

    void insert(BPbcMtgStorDeli record);

    void insertSelective(BPbcMtgStorDeli record);

    List<BPbcMtgStorDeli> selectByExample(BPbcMtgStorDeliExample example);

    BPbcMtgStorDeli selectByPrimaryKey(String id);

    int updateByExampleSelective(BPbcMtgStorDeli record, BPbcMtgStorDeliExample example);

    int updateByExample(BPbcMtgStorDeli record, BPbcMtgStorDeliExample example);

    int updateByPrimaryKeySelective(BPbcMtgStorDeli record);

    int updateByPrimaryKey(BPbcMtgStorDeli record);

    List<BPbcMtgStorDeli> selectByPage(BPbcMtgStorDeliExample example, Page page);
    //EXT
    /**
     * 根据appno查询押品申请表信息
     * @param appno
     * @return
     */
    List<BPbcMtgStorDeli> selectByAppno(String appno);
}