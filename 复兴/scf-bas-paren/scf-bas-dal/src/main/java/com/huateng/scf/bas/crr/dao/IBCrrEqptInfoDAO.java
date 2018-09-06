package com.huateng.scf.bas.crr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.dao.model.BCrrEqptInfo;
import com.huateng.scf.bas.crr.dao.model.BCrrEqptInfoExample;
import java.util.List;
/**
 * 
 * <p>BCrrEqptInfo数据库访问层通用实现类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:36:08
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:36:08	     新增
 *
 * </pre>
 */
public interface IBCrrEqptInfoDAO {
    int countByExample(BCrrEqptInfoExample example);

    int deleteByExample(BCrrEqptInfoExample example);

    int deleteByPrimaryKey(String eqptId);

    void insert(BCrrEqptInfo record);

    void insertSelective(BCrrEqptInfo record);

    List<BCrrEqptInfo> selectByExample(BCrrEqptInfoExample example);

    BCrrEqptInfo selectByPrimaryKey(String eqptId);

    int updateByExampleSelective(BCrrEqptInfo record, BCrrEqptInfoExample example);

    int updateByExample(BCrrEqptInfo record, BCrrEqptInfoExample example);

    int updateByPrimaryKeySelective(BCrrEqptInfo record);

    int updateByPrimaryKey(BCrrEqptInfo record);

    List<BCrrEqptInfo> selectByPage(BCrrEqptInfoExample example, Page page);
}