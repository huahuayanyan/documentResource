package com.huateng.scf.bas.cnt.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.dao.model.BCntInsuranceBaseInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntInsuranceBaseInfoExample;

import java.util.List;
/**
 * 
 * <p>BCntInsuranceBaseInfo数据库访问层通用实现类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年12月24日下午1:47:12
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月24日下午1:47:12	     新增
 *
 * </pre>
 */
public interface IBCntInsuranceBaseInfoDAO {
    int countByExample(BCntInsuranceBaseInfoExample example);

    int deleteByExample(BCntInsuranceBaseInfoExample example);

    int deleteByPrimaryKey(String insuranceNo);

    void insert(BCntInsuranceBaseInfo record);

    void insertSelective(BCntInsuranceBaseInfo record);

    List<BCntInsuranceBaseInfo> selectByExample(BCntInsuranceBaseInfoExample example);

    BCntInsuranceBaseInfo selectByPrimaryKey(String insuranceNo);

    int updateByExampleSelective(BCntInsuranceBaseInfo record, BCntInsuranceBaseInfoExample example);

    int updateByExample(BCntInsuranceBaseInfo record, BCntInsuranceBaseInfoExample example);

    int updateByPrimaryKeySelective(BCntInsuranceBaseInfo record);

    int updateByPrimaryKey(BCntInsuranceBaseInfo record);

    List<BCntInsuranceBaseInfo> selectByPage(BCntInsuranceBaseInfoExample example, Page page);
}