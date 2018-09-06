package com.huateng.scf.adv.bcp.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.bcp.dao.model.ABcpMoreDvyChkStock;
import com.huateng.scf.adv.bcp.dao.model.ABcpMoreDvyChkStockExample;
import com.huateng.scf.adv.bcp.dao.model.ThreeCheckStockDebetVO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface IABcpMoreDvyChkStockDAO {
    int countByExample(ABcpMoreDvyChkStockExample example);

    int deleteByExample(ABcpMoreDvyChkStockExample example);

    int deleteByPrimaryKey(String id);

    void insert(ABcpMoreDvyChkStock record);

    void insertSelective(ABcpMoreDvyChkStock record);

    List<ABcpMoreDvyChkStock> selectByExample(ABcpMoreDvyChkStockExample example);

    ABcpMoreDvyChkStock selectByPrimaryKey(String id);

    int updateByExampleSelective(ABcpMoreDvyChkStock record, ABcpMoreDvyChkStockExample example);

    int updateByExample(ABcpMoreDvyChkStock record, ABcpMoreDvyChkStockExample example);

    int updateByPrimaryKeySelective(ABcpMoreDvyChkStock record);

    int updateByPrimaryKey(ABcpMoreDvyChkStock record);

    List<ABcpMoreDvyChkStock> selectByPage(ABcpMoreDvyChkStockExample example, Page page);

    /**EXT 
     * 发货对账 查询**/
    List<ABcpMoreDvyChkStock> queryCheckStock(Map<String,Object> param, Page page);

    /**EXT 
     * 根据协议号查询借据提货信息**/ 
    List<ThreeCheckStockDebetVO> getThreeCheckStockDebetQry(Map<String,String> param, Page page);
    /**EXT 
     * 根据协议号查询借据提货信息 条数**/ 
    int getThreeCheckStockDebetNum(Map<String,String> param);
    /**EXT 
     * 根据协议号查询借据提货信息 不分页**/ 
    List<ThreeCheckStockDebetVO> getThreeCheckStockDebetQry(Map<String,String> param);
    /**EXT 
     * 根据购销合同编号查询相应押品的发货数量**/ 
    List<Map<String,String>>  getSumQuantityByDebetNo(Map<String,String> param);
    /**EXT 
     * 查询相应押品的发货数量**/ 
    List<Map<String, Object>>  getSumQuantityByNoticeType(Map<String,String> param);
    /**EXT 
     * 根据先票/款后货协议查询发货金额信息**/ 
    List<Map<String,Object>>  getCheckStockAmtByProtocol(Map<String,String> param);
   
}