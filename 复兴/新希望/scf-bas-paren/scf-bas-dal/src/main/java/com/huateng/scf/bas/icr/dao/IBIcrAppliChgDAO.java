package com.huateng.scf.bas.icr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.icr.dao.model.BIcrAppliChg;
import com.huateng.scf.bas.icr.dao.model.BIcrAppliChgExample;

import java.util.List;

public interface IBIcrAppliChgDAO {
    int countByExample(BIcrAppliChgExample example);

    int deleteByExample(BIcrAppliChgExample example);

    int deleteByPrimaryKey(String id);

    void insert(BIcrAppliChg record);

    void insertSelective(BIcrAppliChg record);

    List<BIcrAppliChg> selectByExample(BIcrAppliChgExample example);

    BIcrAppliChg selectByPrimaryKey(String id);

    int updateByExampleSelective(BIcrAppliChg record, BIcrAppliChgExample example);

    int updateByExample(BIcrAppliChg record, BIcrAppliChgExample example);

    int updateByPrimaryKeySelective(BIcrAppliChg record);

    int updateByPrimaryKey(BIcrAppliChg record);

    List<BIcrAppliChg> selectByPage(BIcrAppliChgExample example, Page page);
}