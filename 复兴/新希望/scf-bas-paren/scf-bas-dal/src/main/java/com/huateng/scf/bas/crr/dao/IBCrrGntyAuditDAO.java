package com.huateng.scf.bas.crr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyAudit;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyAuditExample;
import java.util.List;
/**
 * 
 * <p>BCrrGntyAudit数据库访问层通用实现类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:36:04
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:36:04	     新增
 *
 * </pre>
 */
public interface IBCrrGntyAuditDAO {
    int countByExample(BCrrGntyAuditExample example);

    int deleteByExample(BCrrGntyAuditExample example);

    int deleteByPrimaryKey(String serialno);

    void insert(BCrrGntyAudit record);

    void insertSelective(BCrrGntyAudit record);

    List<BCrrGntyAudit> selectByExample(BCrrGntyAuditExample example);

    BCrrGntyAudit selectByPrimaryKey(String serialno);

    int updateByExampleSelective(BCrrGntyAudit record, BCrrGntyAuditExample example);

    int updateByExample(BCrrGntyAudit record, BCrrGntyAuditExample example);

    int updateByPrimaryKeySelective(BCrrGntyAudit record);

    int updateByPrimaryKey(BCrrGntyAudit record);

    List<BCrrGntyAudit> selectByPage(BCrrGntyAuditExample example, Page page);
}