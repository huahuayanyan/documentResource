package com.huateng.scf.bas.crr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.dao.model.BCrrLnAppRela;
import com.huateng.scf.bas.crr.dao.model.BCrrLnAppRelaExample;
import com.huateng.scf.bas.crr.dao.model.BCrrLnAppRelaKey;

import java.util.List;
/**
 * 
 * <p>BCrrLnAppRela数据库访问层通用实现类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:35:27
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:35:27	     新增
 *
 * </pre>
 */
public interface IBCrrLnAppRelaDAO {
	int countByExample(BCrrLnAppRelaExample example);

    int deleteByExample(BCrrLnAppRelaExample example);

    int deleteByPrimaryKey(BCrrLnAppRelaKey _key);

    void insert(BCrrLnAppRela record);

    void insertSelective(BCrrLnAppRela record);

    List<BCrrLnAppRela> selectByExample(BCrrLnAppRelaExample example);

    BCrrLnAppRela selectByPrimaryKey(BCrrLnAppRela _key);

    int updateByExampleSelective(BCrrLnAppRela record, BCrrLnAppRelaExample example);

    int updateByExample(BCrrLnAppRela record, BCrrLnAppRelaExample example);

    int updateByPrimaryKeySelective(BCrrLnAppRela record);

    int updateByPrimaryKey(BCrrLnAppRela record);

    List<BCrrLnAppRela> selectByPage(BCrrLnAppRelaExample example, Page page);
}