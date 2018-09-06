package com.huateng.scf.bas.crr.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyConExample;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyConVO;

/**
 * 
 * <p>
 * BCrrGntyCon数据库访问层通用实现类（ibatis自动生成）
 * </p>
 *
 * @author mengjiajia
 * @date 2016年11月14日下午5:35:54
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:35:54	     新增
 *
 *            </pre>
 */
public interface IBCrrGntyConDAO {
	int deleteByExample(BCrrGntyConExample example);

	int deleteByPrimaryKey(String conId);

	void insert(BCrrGntyCon record);

	void insertSelective(BCrrGntyCon record);

	BCrrGntyCon selectByPrimaryKey(String conId);

	int updateByExampleSelective(BCrrGntyCon record, BCrrGntyConExample example);

	int updateByExample(BCrrGntyCon record, BCrrGntyConExample example);

	int updateByPrimaryKeySelective(BCrrGntyCon record);

	int updateByPrimaryKey(BCrrGntyCon record);

	int countByExample(BCrrGntyConExample example);

	List<BCrrGntyCon> selectByPage(BCrrGntyConExample example, Page page);

	List getSlaveContList(Map map, Page page);

	List<BCrrGntyConVO> getWarnDropCtlInfoByParamForCompensate(Map map, Page page);

	List<BCrrGntyCon> selectByExample(BCrrGntyConExample example);
	
	List<BCrrGntyCon> getSlaveContList2(Map map, Page page);

}