package com.huateng.scf.bas.icr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.icr.dao.model.BIcrDtl;
import com.huateng.scf.bas.icr.dao.model.BIcrDtlExample;

import java.util.List;

public interface IBIcrDtlDAO {
    int countByExample(BIcrDtlExample example);

    int deleteByExample(BIcrDtlExample example);

    int deleteByPrimaryKey(String id);

    void insert(BIcrDtl record);

    void insertSelective(BIcrDtl record);

    List<BIcrDtl> selectByExample(BIcrDtlExample example);

    BIcrDtl selectByPrimaryKey(String id);

    int updateByExampleSelective(BIcrDtl record, BIcrDtlExample example);

    int updateByExample(BIcrDtl record, BIcrDtlExample example);

    int updateByPrimaryKeySelective(BIcrDtl record);

    int updateByPrimaryKey(BIcrDtl record);

    List<BIcrDtl> selectByPage(BIcrDtlExample example, Page page);
}