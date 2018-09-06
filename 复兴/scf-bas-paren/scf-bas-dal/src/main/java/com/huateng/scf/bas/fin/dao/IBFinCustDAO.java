package com.huateng.scf.bas.fin.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.fin.dao.model.BFinCnfgCl;
import com.huateng.scf.bas.fin.dao.model.BFinCust;
import com.huateng.scf.bas.fin.dao.model.BFinCustExample;

import java.util.List;
/**
 * 
 * <p>BFinCust数据库访问层通用实现类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月12日上午9:51:02
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月12日上午9:51:02	     新增
 *
 * </pre>
 */
public interface IBFinCustDAO {
    int countByExample(BFinCustExample example);

    int deleteByExample(BFinCustExample example);

    int deleteByPrimaryKey(String finId);
    
    void insert(BFinCust record);
    
    void insertSelective(BFinCust record);

    List<BFinCust> selectByExample(BFinCustExample example);

    BFinCust selectByPrimaryKey(String finId);

    int updateByExampleSelective(BFinCust record, BFinCustExample example);

    int updateByExample(BFinCust record, BFinCustExample example);

    int updateByPrimaryKeySelective(BFinCust record);

    int updateByPrimaryKey(BFinCust record);

    List<BFinCust> selectByPage(BFinCustExample example, Page page);
    
    List<BFinCnfgCl> selectByMldCl(String mdlCl);
}