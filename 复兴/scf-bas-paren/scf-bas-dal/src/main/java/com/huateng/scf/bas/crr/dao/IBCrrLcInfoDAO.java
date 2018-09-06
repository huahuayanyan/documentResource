package com.huateng.scf.bas.crr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.dao.model.BCrrLcInfo;
import com.huateng.scf.bas.crr.dao.model.BCrrLcInfoExample;
import java.util.List;
/**
 * 
 * <p>BCrrLcInfo数据库访问层通用实现类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:35:38
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:35:38	     新增
 *
 * </pre>
 */
public interface IBCrrLcInfoDAO {
    int countByExample(BCrrLcInfoExample example);

    int deleteByExample(BCrrLcInfoExample example);

    int deleteByPrimaryKey(String lcId);

    void insert(BCrrLcInfo record);

    void insertSelective(BCrrLcInfo record);

    List<BCrrLcInfo> selectByExample(BCrrLcInfoExample example);

    BCrrLcInfo selectByPrimaryKey(String lcId);

    int updateByExampleSelective(BCrrLcInfo record, BCrrLcInfoExample example);

    int updateByExample(BCrrLcInfo record, BCrrLcInfoExample example);

    int updateByPrimaryKeySelective(BCrrLcInfo record);

    int updateByPrimaryKey(BCrrLcInfo record);

    List<BCrrLcInfo> selectByPage(BCrrLcInfoExample example, Page page);
}