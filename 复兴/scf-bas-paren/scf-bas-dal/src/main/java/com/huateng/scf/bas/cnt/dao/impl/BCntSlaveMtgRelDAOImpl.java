package com.huateng.scf.bas.cnt.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.cnt.dao.IBCntSlaveMtgRelDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntSlaveMtgRel;
import com.huateng.scf.bas.cnt.dao.model.BCntSlaveMtgRelExample;

/**
 * 
 * <p>
 * BCntSlaveMtgRel数据库访问层通用接口类（ibatis自动生成）
 * </p>
 *
 * @author mengjiajia
 * @date 2016年12月24日下午1:58:27
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月24日下午1:58:27	     新增
 *
 *            </pre>
 */
@Repository("IBCntSlaveMtgRelDAO")
public class BCntSlaveMtgRelDAOImpl extends IbatisDaoAnnotation4Template implements IBCntSlaveMtgRelDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public BCntSlaveMtgRelDAOImpl() {
		super();
	}

	public int countByExample(BCntSlaveMtgRelExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_CNT_SLAVE_MTG_REL.countByExample", example);
		return count;
	}

	public int deleteByExample(BCntSlaveMtgRelExample example) {
		int rows = getSqlMapClientTemplate().delete("B_CNT_SLAVE_MTG_REL.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(String id) {
		BCntSlaveMtgRel _key = new BCntSlaveMtgRel();
		_key.setId(id);
		int rows = getSqlMapClientTemplate().delete("B_CNT_SLAVE_MTG_REL.deleteByPrimaryKey", _key);
		return rows;
	}

	public void insert(BCntSlaveMtgRel record) {
		getSqlMapClientTemplate().insert("B_CNT_SLAVE_MTG_REL.insert", record);
	}

	public void insertSelective(BCntSlaveMtgRel record) {
		getSqlMapClientTemplate().insert("B_CNT_SLAVE_MTG_REL.insertSelective", record);
	}

	@SuppressWarnings("unchecked")
	public List<BCntSlaveMtgRel> selectByExample(BCntSlaveMtgRelExample example) {
		List<BCntSlaveMtgRel> list = getSqlMapClientTemplate().queryForList("B_CNT_SLAVE_MTG_REL.selectByExample", example);
		return list;
	}

	public BCntSlaveMtgRel selectByPrimaryKey(String id) {
		BCntSlaveMtgRel _key = new BCntSlaveMtgRel();
		_key.setId(id);
		BCntSlaveMtgRel record = (BCntSlaveMtgRel) getSqlMapClientTemplate().queryForObject("B_CNT_SLAVE_MTG_REL.selectByPrimaryKey", _key);
		return record;
	}

	public int updateByExampleSelective(BCntSlaveMtgRel record, BCntSlaveMtgRelExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_CNT_SLAVE_MTG_REL.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(BCntSlaveMtgRel record, BCntSlaveMtgRelExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_CNT_SLAVE_MTG_REL.updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(BCntSlaveMtgRel record) {
		int rows = getSqlMapClientTemplate().update("B_CNT_SLAVE_MTG_REL.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(BCntSlaveMtgRel record) {
		int rows = getSqlMapClientTemplate().update("B_CNT_SLAVE_MTG_REL.updateByPrimaryKey", record);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<BCntSlaveMtgRel> selectByPage(BCntSlaveMtgRelExample example, Page page) {
		List<BCntSlaveMtgRel> list = this.searchListPageMyObject("B_CNT_SLAVE_MTG_REL.selectByExample", example, page);
		return list;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends BCntSlaveMtgRelExample {
		private Object record;

		public UpdateByExampleParms(Object record, BCntSlaveMtgRelExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

	@Override
	public List<BCntSlaveMtgRel> findOneAndTwoMortage(Map map, Page page) {
		List<BCntSlaveMtgRel> list = this.searchListPageMyObject("EXT_B_PBC_MTG_CLASS.findBPbcMtgClassForMortageDao", map, page);
		return list;
	}
}