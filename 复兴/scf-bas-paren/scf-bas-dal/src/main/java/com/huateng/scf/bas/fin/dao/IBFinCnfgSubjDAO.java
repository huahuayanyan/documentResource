package com.huateng.scf.bas.fin.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.fin.dao.model.BFinCnfgSubj;
import com.huateng.scf.bas.fin.dao.model.BFinCnfgSubjExample;

import java.util.List;
/**
 * 
 * <p>BFinCnfgSubj数据库访问层通用实现类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月3日下午2:19:21
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月3日下午2:19:21	     新增
 *
 * </pre>
 */
public interface IBFinCnfgSubjDAO {
	int countByExample(BFinCnfgSubjExample example);

    int deleteByExample(BFinCnfgSubjExample example);

    int deleteByPrimaryKey(String subjId);
    
    String insert(BFinCnfgSubj record);

    String insertSelective(BFinCnfgSubj record);

    List<BFinCnfgSubj> selectByExample(BFinCnfgSubjExample example);
    
    BFinCnfgSubj selectByPrimaryKey(String subjId);
    
    BFinCnfgSubj selectBySubjNm(String subjNm);

    int updateByExampleSelective(BFinCnfgSubj record, BFinCnfgSubjExample example);

    int updateByExample(BFinCnfgSubj record, BFinCnfgSubjExample example);

    int updateByPrimaryKeySelective(BFinCnfgSubj record);

    int updateByPrimaryKey(BFinCnfgSubj record);

    List<BFinCnfgSubj> selectByPage(BFinCnfgSubjExample example, Page page);
    
	List<BFinCnfgSubj> selectBySubj(BFinCnfgSubj bFinCnfgSubj);
}