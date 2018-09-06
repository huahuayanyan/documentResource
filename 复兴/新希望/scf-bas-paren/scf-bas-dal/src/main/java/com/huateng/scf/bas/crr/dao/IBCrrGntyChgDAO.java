package com.huateng.scf.bas.crr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyChg;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyChgExample;
import java.util.List;
/**
 * 
 * <p>BCrrGntyChg数据库访问层通用实现类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:35:59
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:35:59	     新增
 *
 * </pre>
 */
public interface IBCrrGntyChgDAO {
    int countByExample(BCrrGntyChgExample example);

    int deleteByExample(BCrrGntyChgExample example);

    int deleteByPrimaryKey(String serialno);

    void insert(BCrrGntyChg record);

    void insertSelective(BCrrGntyChg record);

    List<BCrrGntyChg> selectByExample(BCrrGntyChgExample example);

    BCrrGntyChg selectByPrimaryKey(String serialno);

    int updateByExampleSelective(BCrrGntyChg record, BCrrGntyChgExample example);

    int updateByExample(BCrrGntyChg record, BCrrGntyChgExample example);

    int updateByPrimaryKeySelective(BCrrGntyChg record);

    int updateByPrimaryKey(BCrrGntyChg record);

    List<BCrrGntyChg> selectByPage(BCrrGntyChgExample example, Page page);
}