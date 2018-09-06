package com.huateng.scf.bas.icr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.icr.dao.model.BIcrAppliBrcodeList;
import com.huateng.scf.bas.icr.dao.model.BIcrBrcodeList;
import com.huateng.scf.bas.icr.dao.model.BIcrBrcodeListExample;

import java.util.List;

public interface IBIcrBrcodeListDAO {
    int countByExample(BIcrBrcodeListExample example);

    int deleteByExample(BIcrBrcodeListExample example);

    int deleteByPrimaryKey(String id);

    void insert(BIcrBrcodeList record);

    void insertSelective(BIcrBrcodeList record);

    List<BIcrBrcodeList> selectByExample(BIcrBrcodeListExample example);

    BIcrBrcodeList selectByPrimaryKey(String id);

    int updateByExampleSelective(BIcrBrcodeList record, BIcrBrcodeListExample example);

    int updateByExample(BIcrBrcodeList record, BIcrBrcodeListExample example);

    int updateByPrimaryKeySelective(BIcrBrcodeList record);

    int updateByPrimaryKey(BIcrBrcodeList record);

    List<BIcrBrcodeList> selectByPage(BIcrBrcodeListExample example, Page page);
    
    /**
     * 根据额度编号删除额度适用机构映射
     */
    public int deleteBrcodeListByNo(BIcrBrcodeList bIcrBrcodeList);
}