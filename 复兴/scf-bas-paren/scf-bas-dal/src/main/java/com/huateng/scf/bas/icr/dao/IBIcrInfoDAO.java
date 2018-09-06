package com.huateng.scf.bas.icr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.icr.dao.model.BIcrInfo;
import com.huateng.scf.bas.icr.dao.model.BIcrInfoExample;

import java.util.List;
import java.util.Map;

public interface IBIcrInfoDAO {
    int countByExample(BIcrInfoExample example);

    int deleteByExample(BIcrInfoExample example);

    int deleteByPrimaryKey(String creditNo);

    void insert(BIcrInfo record);

    void insertSelective(BIcrInfo record);

    List<BIcrInfo> selectByExample(BIcrInfoExample example);

    BIcrInfo selectByPrimaryKey(String creditNo);

    int updateByExampleSelective(BIcrInfo record, BIcrInfoExample example);

    int updateByExample(BIcrInfo record, BIcrInfoExample example);

    int updateByPrimaryKeySelective(BIcrInfo record);

    int updateByPrimaryKey(BIcrInfo record);

    List<BIcrInfo> selectByPage(BIcrInfoExample example, Page page);
    
    List<BIcrInfo> selectByParam(BIcrInfo bIcrInfo);
    //ext
    /**
     * 额度信息列表
     * @param bIcrInfo
     * @param page
     * @return
     */
    List<BIcrInfo> selectListByPage(BIcrInfo bIcrInfo, Page page);
    /**
     * 根据总额度编号查询已领用生效额度列表
     * @param bIcrInfo
     * @param page
     * @return
     */
    List<BIcrInfo> selectDrawInfoListByCreditNo(BIcrInfo bIcrInfo,Page page);
    /**
     * 根据总额度编号查询已领用生效额度列表
     * @param bIcrInfo
     * @param page
     * @return
     */
    List<BIcrInfo> selectDrawInfoList(BIcrInfo bIcrInfo,Page page);
    /**
     * 分项额度信息查询
     * @param bIcrInfo
     * @param page
     * @return
     */
    List<BIcrInfo> selectSubInfoList(BIcrInfo bIcrInfo,Page page);
    
    /**
     * 根据额度编号查询额度信息及上级额度信息
     * @param creditNo
     * @return
     */
    BIcrInfo selectInfoOrUpByCreditNo(BIcrInfo bIcrInfo);
    /**
     * 根据额度编号更新额度状态和分项额度状态
     * @param bIcrInfo
     * @return
     */
     int updateInfoOrUpBycreditNo(BIcrInfo  bIcrInfo);
     
     /**
      * 可以领用间接额度查询
      * @param bIcrInfo
      * @param page
      * @return
      */
     List<BIcrInfo> findBIcrInfoDrawByPage(BIcrInfo bIcrInfo,Page page);
     /**
      * 根据额度编号查询额度信息
      * @param bIcrInfo
      * @return
      */
     BIcrInfo selectInfoMainByCreditNo(BIcrInfo bIcrInfo);
     /*****************间接额度回收Recover begin************************/
     List<BIcrInfo> findBIcrInfoRecoverByPage(BIcrInfo bIcrInfo,Page page);
     /*****************间接额度回收 Recoverend************************/
     /******************间接额度使用流水查询**************************/
     /**
      * 间接额度使用流水查询
      * @param bIcrInfo
      * @param page
      * @return
      */
     List<BIcrInfo> findBIcrInfoFlowQryByPage(BIcrInfo bIcrInfo,Page page);
     
     
 	/**
 	 * 额度检查接口
 	 * 
 	 * @param map
 	 * @return
 	 */
     List<BIcrInfo> checkCredit(Map map);
}