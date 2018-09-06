package com.huateng.scf.bas.crr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyInfo;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyInfoExample;
import java.util.List;
/**
 * 
 * <p>BCrrGntyInfo数据库访问层通用实现类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:35:49
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:35:49	     新增
 *
 * </pre>
 */
public interface IBCrrGntyInfoDAO {
    int countByExample(BCrrGntyInfoExample example);

    int deleteByExample(BCrrGntyInfoExample example);

    int deleteByPrimaryKey(String gntyId);

    void insert(BCrrGntyInfo record);

    void insertSelective(BCrrGntyInfo record);

    List<BCrrGntyInfo> selectByExample(BCrrGntyInfoExample example);

    BCrrGntyInfo selectByPrimaryKey(String gntyId);

    int updateByExampleSelective(BCrrGntyInfo record, BCrrGntyInfoExample example);

    int updateByExample(BCrrGntyInfo record, BCrrGntyInfoExample example);

    int updateByPrimaryKeySelective(BCrrGntyInfo record);

    int updateByPrimaryKey(BCrrGntyInfo record);

    List<BCrrGntyInfo> selectByPage(BCrrGntyInfoExample example, Page page);
}