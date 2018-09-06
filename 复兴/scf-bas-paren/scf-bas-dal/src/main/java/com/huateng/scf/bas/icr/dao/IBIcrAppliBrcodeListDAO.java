package com.huateng.scf.bas.icr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.icr.dao.model.BIcrAppliBrcodeList;
import com.huateng.scf.bas.icr.dao.model.BIcrAppliBrcodeListExample;
import com.huateng.scf.bas.icr.dao.model.BIcrAppliInfo;

import java.util.List;

public interface IBIcrAppliBrcodeListDAO {
    int countByExample(BIcrAppliBrcodeListExample example);

    int deleteByExample(BIcrAppliBrcodeListExample example);

    int deleteByPrimaryKey(String id);

    void insert(BIcrAppliBrcodeList record);

    void insertSelective(BIcrAppliBrcodeList record);

    List<BIcrAppliBrcodeList> selectByExample(BIcrAppliBrcodeListExample example);

    BIcrAppliBrcodeList selectByPrimaryKey(String id);

    int updateByExampleSelective(BIcrAppliBrcodeList record, BIcrAppliBrcodeListExample example);

    int updateByExample(BIcrAppliBrcodeList record, BIcrAppliBrcodeListExample example);

    int updateByPrimaryKeySelective(BIcrAppliBrcodeList record);

    int updateByPrimaryKey(BIcrAppliBrcodeList record);

    List<BIcrAppliBrcodeList> selectByPage(BIcrAppliBrcodeListExample example, Page page);
    
    //ext
    /**
     * 根据额度编号和申请编号删除额度适用机构映射
     */
    public int deleteAppliBrcodeListByNo(BIcrAppliBrcodeList bIcrAppliBrcodeList);
    
    /**
     *根据额度编号查询额度申请业务适用机构映
     */
    List<BIcrAppliBrcodeList> queryBIcrAppliBrcodeListByCreditNo(BIcrAppliBrcodeList  bIcrAppliBrcodeList);
}