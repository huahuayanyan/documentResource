package com.huateng.scf.bas.fin.dao;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.fin.dao.model.BFinCustDir;
import com.huateng.scf.bas.fin.dao.model.BFinCustDirExample;
import com.huateng.scf.bas.fin.dao.model.BFinCustDs;
/**
 * 
 * <p>BFinCustDir数据库访问层通用实现类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月12日上午9:51:28
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月12日上午9:51:28	     新增
 *
 * </pre>
 */
public interface IBFinCustDirDAO {
    int countByExample(BFinCustDirExample example);

    int deleteByExample(BFinCustDirExample example);

    int deleteByPrimaryKey(String finDirId);

    void insert(BFinCustDir record);

    void insertSelective(BFinCustDir record);

    List<BFinCustDir> selectByExample(BFinCustDirExample example);

    BFinCustDir selectByPrimaryKey(String finDirId);
    
    List<BFinCustDir> selectByFinId(String finId);

    int updateByExampleSelective(BFinCustDir record, BFinCustDirExample example);

    int updateByExample(BFinCustDir record, BFinCustDirExample example);

    int updateByPrimaryKeySelective(BFinCustDir record);

    int updateByPrimaryKey(BFinCustDir record);

    List<BFinCustDir> selectByPage(BFinCustDirExample example, Page page);
    
    String selectByFinDt(String finDt);
    
    List<BFinCustDir> selectByMdlId(String mdlId);

	int deleteByFinId(String finId);
	
}