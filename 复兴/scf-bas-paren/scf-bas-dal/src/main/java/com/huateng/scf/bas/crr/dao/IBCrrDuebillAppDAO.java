package com.huateng.scf.bas.crr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp;
import com.huateng.scf.bas.crr.dao.model.BCrrDuebillAppExample;
import java.util.List;
/**
 * 
 * <p>BCrrDuebillApp数据库访问层通用实现类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:36:14
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:36:14	     新增
 *
 * </pre>
 */
public interface IBCrrDuebillAppDAO {
    int countByExample(BCrrDuebillAppExample example);

    int deleteByExample(BCrrDuebillAppExample example);

    int deleteByPrimaryKey(String id);

    void insert(BCrrDuebillApp record);

    void insertSelective(BCrrDuebillApp record);

    List<BCrrDuebillApp> selectByExample(BCrrDuebillAppExample example);

    BCrrDuebillApp selectByPrimaryKey(String id);

    int updateByExampleSelective(BCrrDuebillApp record, BCrrDuebillAppExample example);

    int updateByExample(BCrrDuebillApp record, BCrrDuebillAppExample example);

    int updateByPrimaryKeySelective(BCrrDuebillApp record);

    int updateByPrimaryKey(BCrrDuebillApp record);

    List<BCrrDuebillApp> selectByPage(BCrrDuebillAppExample example, Page page);
    public BCrrDuebillApp findBCrrDuebillAppByIfspAppno(String ifspAppno);
    public void insertIfspSelective(BCrrDuebillApp record);
}