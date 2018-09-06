package com.huateng.scf.bas.sys.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.dao.model.BSysChkCnfg;
import com.huateng.scf.bas.sys.dao.model.BSysChkCnfgExample;

import java.util.List;
import java.util.Map;

public interface BSysChkCnfgDAO {
	
    int countByExample(BSysChkCnfgExample example);

    int deleteByExample(BSysChkCnfgExample example);

    int deleteByPrimaryKey(String chkItId);

    String insert(BSysChkCnfg record);

    String insertSelective(BSysChkCnfg record);

    List<BSysChkCnfg> selectByExample(BSysChkCnfgExample example);

    BSysChkCnfg selectByPrimaryKey(String chkItId);

    int updateByExampleSelective(BSysChkCnfg record, BSysChkCnfgExample example);

    int updateByExample(BSysChkCnfg record, BSysChkCnfgExample example);

    int updateByPrimaryKeySelective(BSysChkCnfg record);

    int updateByPrimaryKey(BSysChkCnfg record);

    List<BSysChkCnfg> selectByPage(BSysChkCnfgExample example, Page page);

	List<String> findListByColumnName(String columnName);
	
	public List<BSysChkCnfg> findAllList();
}