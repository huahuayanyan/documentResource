package com.huateng.scf.bas.fin.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.fin.dao.model.BFinCnfgCl;
import com.huateng.scf.bas.fin.dao.model.BFinCnfgClExample;

import java.util.List;
/**
 * 
 * <p>BFinCnfgCl数据库访问层通用实现类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月3日下午2:20:04
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月3日下午2:20:04	     新增
 *
 * </pre>
 */
public interface IBFinCnfgClDAO {
	int countByExample(BFinCnfgClExample example);

    int deleteByExample(BFinCnfgClExample example);

    int deleteByPrimaryKey(String mdlId);
    
    String insert(BFinCnfgCl record);

    String insertSelective(BFinCnfgCl record);

    BFinCnfgCl selectByPrimaryKey(String mdlId);
    
    List<BFinCnfgCl> selectByMldCl(BFinCnfgCl record);
    
    int updateByExampleSelective(BFinCnfgCl record, BFinCnfgClExample example);

    int updateByExample(BFinCnfgCl record, BFinCnfgClExample example);

    int updateByPrimaryKeySelective(BFinCnfgCl record);

    int updateByPrimaryKey(BFinCnfgCl record);

    List<BFinCnfgCl> selectByPage(BFinCnfgClExample example, Page page);
    
    List<BFinCnfgCl> selectByExample(BFinCnfgClExample example);

	List<BFinCnfgCl> selectByMldCl(String mdlCl);

	BFinCnfgCl selectByMdlNm(String mdlNm);

	List<BFinCnfgCl> selectByMdl(BFinCnfgCl bFinCnfgCl);

	List<BFinCnfgCl> selectByMdlTyp(BFinCnfgCl bFinCnfgCl);

	List<BFinCnfgCl> selectByMdlTypById(BFinCnfgCl bFinCnfgCl);
}