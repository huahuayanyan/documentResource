package com.huateng.scf.bas.crr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.dao.model.BCrrLnApp;
import com.huateng.scf.bas.crr.dao.model.BCrrLnAppExample;
import java.util.List;
/**
 * 
 * <p>BCrrLnApp数据库访问层通用实现类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:35:31
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:35:31	     新增
 *
 * </pre>
 */
public interface IBCrrLnAppDAO {
    int countByExample(BCrrLnAppExample example);

    int deleteByExample(BCrrLnAppExample example);

    int deleteByPrimaryKey(String appId);

    void insert(BCrrLnApp record);

    void insertSelective(BCrrLnApp record);

    List<BCrrLnApp> selectByExample(BCrrLnAppExample example);

    BCrrLnApp selectByPrimaryKey(String appId);

    int updateByExampleSelective(BCrrLnApp record, BCrrLnAppExample example);

    int updateByExample(BCrrLnApp record, BCrrLnAppExample example);

    int updateByPrimaryKeySelective(BCrrLnApp record);

    int updateByPrimaryKey(BCrrLnApp record);

    List<BCrrLnApp> selectByPage(BCrrLnAppExample example, Page page);

	int batchDelete(List<BCrrLnApp> list);
}