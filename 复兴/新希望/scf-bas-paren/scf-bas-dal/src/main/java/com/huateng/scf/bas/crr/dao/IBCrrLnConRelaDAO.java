package com.huateng.scf.bas.crr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.dao.model.BCrrLnConRela;
import com.huateng.scf.bas.crr.dao.model.BCrrLnConRelaExample;
import com.huateng.scf.bas.crr.dao.model.BCrrLnConRelaKey;

import java.util.List;
/**
 * 
 * <p>BCrrLnConRela数据库访问层通用实现类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:35:15
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:35:15	     新增
 *
 * </pre>
 */
public interface IBCrrLnConRelaDAO {
	int countByExample(BCrrLnConRelaExample example);

    int deleteByExample(BCrrLnConRelaExample example);

    int deleteByPrimaryKey(BCrrLnConRelaKey _key);

    void insert(BCrrLnConRela record);

    void insertSelective(BCrrLnConRela record);

    List<BCrrLnConRela> selectByExample(BCrrLnConRelaExample example);

    BCrrLnConRela selectByPrimaryKey(BCrrLnConRelaKey _key);

    int updateByExampleSelective(BCrrLnConRela record, BCrrLnConRelaExample example);

    int updateByExample(BCrrLnConRela record, BCrrLnConRelaExample example);

    int updateByPrimaryKeySelective(BCrrLnConRela record);

    int updateByPrimaryKey(BCrrLnConRela record);

    List<BCrrLnConRela> selectByPage(BCrrLnConRelaExample example, Page page);

//	List<BCrrLnConRelaKey> selectBySerialno(String appId);
//
//	int update(BCrrLnConRelaKey record);
//
//	BCrrLnConRelaKey selectByAppIdAndConId(BCrrLnConRelaKey bCrrLnConRela);
}