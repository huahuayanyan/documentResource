package com.huateng.scf.bas.crr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.dao.model.BCrrDuebill;
import com.huateng.scf.bas.crr.dao.model.BCrrDuebillExample;
import java.util.List;
/**
 * 
 * <p>BCrrDuebill数据库访问层通用实现类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:36:11
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:36:11	     新增
 *
 * </pre>
 */
public interface IBCrrDuebillDAO {
    int countByExample(BCrrDuebillExample example);

    int deleteByExample(BCrrDuebillExample example);

    int deleteByPrimaryKey(String cino);

    void insert(BCrrDuebill record);

    void insertSelective(BCrrDuebill record);

    List<BCrrDuebill> selectByExample(BCrrDuebillExample example);

    BCrrDuebill selectByPrimaryKey(String cino);

    int updateByExampleSelective(BCrrDuebill record, BCrrDuebillExample example);

    int updateByExample(BCrrDuebill record, BCrrDuebillExample example);

    int updateByPrimaryKeySelective(BCrrDuebill record);

    int updateByPrimaryKey(BCrrDuebill record);

    List<BCrrDuebill> selectByPage(BCrrDuebillExample example, Page page);

	int deleteByRelaId(String relaId);
}