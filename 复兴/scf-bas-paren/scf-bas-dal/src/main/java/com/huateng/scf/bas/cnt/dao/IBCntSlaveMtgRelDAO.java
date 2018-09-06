package com.huateng.scf.bas.cnt.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.dao.model.BCntSlaveMtgRel;
import com.huateng.scf.bas.cnt.dao.model.BCntSlaveMtgRelExample;

/**
 * 
 * <p>
 * BCntSlaveMtgRel数据库访问层通用实现类（ibatis自动生成）
 * </p>
 *
 * @author mengjiajia
 * @date 2016年12月24日下午1:58:54
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月24日下午1:58:54	     新增
 *
 *            </pre>
 */
public interface IBCntSlaveMtgRelDAO {
	int countByExample(BCntSlaveMtgRelExample example);

	int deleteByExample(BCntSlaveMtgRelExample example);

	int deleteByPrimaryKey(String id);

	void insert(BCntSlaveMtgRel record);

	void insertSelective(BCntSlaveMtgRel record);

	List<BCntSlaveMtgRel> selectByExample(BCntSlaveMtgRelExample example);

	BCntSlaveMtgRel selectByPrimaryKey(String id);

	int updateByExampleSelective(BCntSlaveMtgRel record, BCntSlaveMtgRelExample example);

	int updateByExample(BCntSlaveMtgRel record, BCntSlaveMtgRelExample example);

	int updateByPrimaryKeySelective(BCntSlaveMtgRel record);

	int updateByPrimaryKey(BCntSlaveMtgRel record);

	List<BCntSlaveMtgRel> selectByPage(BCntSlaveMtgRelExample example, Page page);

	// 页面一级二级押品名称转译
	List<BCntSlaveMtgRel> findOneAndTwoMortage(Map map, Page page);
}