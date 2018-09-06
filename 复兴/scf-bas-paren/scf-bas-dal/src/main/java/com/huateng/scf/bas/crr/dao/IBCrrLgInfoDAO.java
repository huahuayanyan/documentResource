package com.huateng.scf.bas.crr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.dao.model.BCrrLgInfo;
import com.huateng.scf.bas.crr.dao.model.BCrrLgInfoExample;
import java.util.List;
/**
 * 
 * <p>BCrrLgInfo数据库访问层通用实现类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:35:35
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:35:35	     新增
 *
 * </pre>
 */
public interface IBCrrLgInfoDAO {
    int countByExample(BCrrLgInfoExample example);

    int deleteByExample(BCrrLgInfoExample example);

    int deleteByPrimaryKey(String lgId);

    void insert(BCrrLgInfo record);

    void insertSelective(BCrrLgInfo record);

    List<BCrrLgInfo> selectByExample(BCrrLgInfoExample example);

    BCrrLgInfo selectByPrimaryKey(String lgId);

    int updateByExampleSelective(BCrrLgInfo record, BCrrLgInfoExample example);

    int updateByExample(BCrrLgInfo record, BCrrLgInfoExample example);

    int updateByPrimaryKeySelective(BCrrLgInfo record);

    int updateByPrimaryKey(BCrrLgInfo record);

    List<BCrrLgInfo> selectByPage(BCrrLgInfoExample example, Page page);

}