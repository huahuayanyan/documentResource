package com.huateng.scf.bas.icr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.icr.dao.model.BIcrType;
import com.huateng.scf.bas.icr.dao.model.BIcrTypeExample;

import java.util.List;

public interface IBIcrTypeDAO {
    int countByExample(BIcrTypeExample example);

    int deleteByExample(BIcrTypeExample example);

    int deleteByPrimaryKey(String id);

    void insert(BIcrType record);

    void insertSelective(BIcrType record);

    List<BIcrType> selectByExample(BIcrTypeExample example);

    BIcrType selectByPrimaryKey(String id);

    int updateByExampleSelective(BIcrType record, BIcrTypeExample example);

    int updateByExample(BIcrType record, BIcrTypeExample example);

    int updateByPrimaryKeySelective(BIcrType record);

    int updateByPrimaryKey(BIcrType record);

    List<BIcrType> selectByPage(BIcrTypeExample example, Page page);
    
    //ext
    int batchDelete(List list);
    /**
     * 额度筛选
     * @param bIcrType
     * @param page
     * @return
     */
    public List<BIcrType> selectBIcrType(BIcrType bIcrType, Page page) ;
    
    /**
     * 根据额度种类信息获得额度种类信息
     * @param bIcrType
     * @return
     */
    public List<BIcrType> findBIcrTypeByBIcrType(BIcrType bIcrType);
    
    
  
    
}