package com.huateng.scf.bas.crr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.dao.model.BCrrLnCon;
import com.huateng.scf.bas.crr.dao.model.BCrrLnConExample;
import java.util.List;
import java.util.Map;
/**
 * 
 * <p>BCrrLnCon数据库访问层通用实现类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:35:19
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:35:19	     新增
 *
 * </pre>
 */
public interface IBCrrLnConDAO {
    int countByExample(BCrrLnConExample example);

    int deleteByExample(BCrrLnConExample example);

    int deleteByPrimaryKey(String appId);

    void insert(BCrrLnCon record);

    void insertSelective(BCrrLnCon record);

    List<BCrrLnCon> selectByExample(BCrrLnConExample example);

    BCrrLnCon selectByPrimaryKey(String appId);

    int updateByExampleSelective(BCrrLnCon record, BCrrLnConExample example);

    int updateByExample(BCrrLnCon record, BCrrLnConExample example);

    int updateByPrimaryKeySelective(BCrrLnCon record);

    int updateByPrimaryKey(BCrrLnCon record);

    List<BCrrLnCon> selectByPage(BCrrLnConExample example, Page page);
    
    List<Map> getLoanPercent(Map map);
}