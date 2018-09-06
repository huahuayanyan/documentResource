package com.huateng.scf.bas.icr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.icr.dao.model.BIcrAppliBrcodeList;
import com.huateng.scf.bas.icr.dao.model.BIcrPrdBind;
import com.huateng.scf.bas.icr.dao.model.BIcrPrdBindExample;

import java.util.List;

public interface IBIcrPrdBindDAO {
    int countByExample(BIcrPrdBindExample example);

    int deleteByExample(BIcrPrdBindExample example);

    int deleteByPrimaryKey(String id);

    void insert(BIcrPrdBind record);

    void insertSelective(BIcrPrdBind record);

    List<BIcrPrdBind> selectByExample(BIcrPrdBindExample example);

    BIcrPrdBind selectByPrimaryKey(String id);

    int updateByExampleSelective(BIcrPrdBind record, BIcrPrdBindExample example);

    int updateByExample(BIcrPrdBind record, BIcrPrdBindExample example);

    int updateByPrimaryKeySelective(BIcrPrdBind record);

    int updateByPrimaryKey(BIcrPrdBind record);

    List<BIcrPrdBind> selectByPage(BIcrPrdBindExample example, Page page);
    
    List<BIcrPrdBind> selectByPid(String prdid);
    //ext 
    //根据额度种类删除额度与产品的绑定关系
    public int deleteBIcrPrdBindByCreditType(BIcrPrdBind bIcrPrdBind);
}