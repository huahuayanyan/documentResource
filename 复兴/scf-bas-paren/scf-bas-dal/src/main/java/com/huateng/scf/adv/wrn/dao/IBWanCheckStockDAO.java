package com.huateng.scf.adv.wrn.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.wrn.dao.model.BWanCheckStock;
import com.huateng.scf.adv.wrn.dao.model.BWanCheckStockExample;

import java.util.List;

public interface IBWanCheckStockDAO {
    int countByExample(BWanCheckStockExample example);

    int deleteByExample(BWanCheckStockExample example);

    int deleteByPrimaryKey(String id);

    void insert(BWanCheckStock record);

    void insertSelective(BWanCheckStock record);

    List<BWanCheckStock> selectByExample(BWanCheckStockExample example);

    BWanCheckStock selectByPrimaryKey(String id);

    int updateByExampleSelective(BWanCheckStock record, BWanCheckStockExample example);

    int updateByExample(BWanCheckStock record, BWanCheckStockExample example);

    int updateByPrimaryKeySelective(BWanCheckStock record);

    int updateByPrimaryKey(BWanCheckStock record);

    List<BWanCheckStock> selectByPage(BWanCheckStockExample example, Page page);
}