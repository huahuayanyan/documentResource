package com.huateng.scf.bas.fin.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.fin.dao.model.BFinCnfgDef;
import com.huateng.scf.bas.fin.dao.model.BFinCnfgDefExample;

import java.util.List;
/**
 * 
 * <p>BFinCnfgDef数据库访问层通用实现类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月3日下午2:20:19
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月3日下午2:20:19	     新增
 *
 * </pre>
 */
public interface IBFinCnfgDefDAO {
    int countByExample(BFinCnfgDefExample example);

    int deleteByExample(BFinCnfgDefExample example);

    int deleteByPrimaryKey(String serialno);
    
    String insert(BFinCnfgDef record);

    String insertSelective(BFinCnfgDef record);

    List<BFinCnfgDef> selectByExample(BFinCnfgDefExample example);

    BFinCnfgDef selectByPrimaryKey(String serialno);

    int updateByExampleSelective(BFinCnfgDef record, BFinCnfgDefExample example);

    int updateByExample(BFinCnfgDef record, BFinCnfgDefExample example);

    int updateByPrimaryKeySelective(BFinCnfgDef record);

    int updateByPrimaryKey(BFinCnfgDef record);

    List<BFinCnfgDef> selectByPage(BFinCnfgDefExample example, Page page);
    
    List<BFinCnfgDef> selectByFinId(BFinCnfgDef bFinCnfgDef, Page page);
    
    List<BFinCnfgDef> selectByFinId(BFinCnfgDef bFinCnfgDef);
    
    List<BFinCnfgDef> selectByMdlId(String mdlId);
    
    List<BFinCnfgDef> selectBySubjId(String subjId);

	BFinCnfgDef selectBySubjIdAndmdlId(BFinCnfgDef bFinCnfgDef);
	/**
	 * 根据模型ID和科目编号查询模型信息
	 * @param bFinCnfgDef
	 * @return List<BFinCnfgDef>
	 */
	public List<BFinCnfgDef> selectBySubjIdAndmdlIdList(BFinCnfgDef bFinCnfgDef);

	int deleteByMdlId(String mdlId);
}