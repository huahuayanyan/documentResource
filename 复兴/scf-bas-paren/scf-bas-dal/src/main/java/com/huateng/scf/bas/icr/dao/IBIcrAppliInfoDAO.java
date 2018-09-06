package com.huateng.scf.bas.icr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.icr.dao.model.BIcrAppliInfo;
import com.huateng.scf.bas.icr.dao.model.BIcrAppliInfoExample;
import com.huateng.scf.bas.icr.dao.model.BIcrInfo;

import java.util.List;

public interface IBIcrAppliInfoDAO {
    int countByExample(BIcrAppliInfoExample example);

    int deleteByExample(BIcrAppliInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BIcrAppliInfo record);

    void insertSelective(BIcrAppliInfo record);

    List<BIcrAppliInfo> selectByExample(BIcrAppliInfoExample example);

    BIcrAppliInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BIcrAppliInfo record, BIcrAppliInfoExample example);

    int updateByExample(BIcrAppliInfo record, BIcrAppliInfoExample example);

    int updateByPrimaryKeySelective(BIcrAppliInfo record);

    int updateByPrimaryKey(BIcrAppliInfo record);

    List<BIcrAppliInfo> selectByPage(BIcrAppliInfoExample example, Page page);
    
    //ext
    /**
     * 根据额度编号更新额度申请信息状态和分项额度申请信息状态
     * @param bIcrAppliInfo
     * @return
     */
    int updateAppliInfoOrUpBycreditNo(BIcrAppliInfo  bIcrAppliInfo);
    /**
     *根据额度编号查询额度申请信息
     */
    BIcrAppliInfo queryBIcrAppliInfoByCreditNo(BIcrAppliInfo  bIcrAppliInfo);
}