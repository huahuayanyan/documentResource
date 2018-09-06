package com.huateng.scf.bas.crr.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.cnt.dao.model.FourProtocolVO;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyConExample;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyConVO;

/**
 * 
 * <p>
 * BCrrGntyCon数据库访问层通用接口类（ibatis自动生成）
 * </p>
 *
 * @author mengjiajia
 * @date 2016年11月14日下午5:32:12
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:32:12	     新增
 *
 *            </pre>
 */
@Repository("IBCrrGntyConDAO")
public class BCrrGntyConDAOImpl extends IbatisDaoAnnotation4Template implements IBCrrGntyConDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public BCrrGntyConDAOImpl() {
		super();
	}

	public int deleteByExample(BCrrGntyConExample example) {
		int rows = getSqlMapClientTemplate().delete("B_CRR_GNTY_CON.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(String conId) {
		BCrrGntyCon _key = new BCrrGntyCon();
		_key.setConId(conId);
		int rows = getSqlMapClientTemplate().delete("B_CRR_GNTY_CON.deleteByPrimaryKey", _key);
		return rows;
	}

	public void insert(BCrrGntyCon record) {
		getSqlMapClientTemplate().insert("B_CRR_GNTY_CON.insert", record);
	}

	public void insertSelective(BCrrGntyCon record) {
		getSqlMapClientTemplate().insert("B_CRR_GNTY_CON.insertSelective", record);
	}

	public BCrrGntyCon selectByPrimaryKey(String conId) {
		BCrrGntyCon _key = new BCrrGntyCon();
		_key.setConId(conId);
		BCrrGntyCon record = (BCrrGntyCon) getSqlMapClientTemplate().queryForObject("B_CRR_GNTY_CON.selectByPrimaryKey", _key);
		return record;
	}

	public int updateByExampleSelective(BCrrGntyCon record, BCrrGntyConExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_CRR_GNTY_CON.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(BCrrGntyCon record, BCrrGntyConExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_CRR_GNTY_CON.updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(BCrrGntyCon record) {
		int rows = getSqlMapClientTemplate().update("B_CRR_GNTY_CON.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(BCrrGntyCon record) {
		int rows = getSqlMapClientTemplate().update("B_CRR_GNTY_CON.updateByPrimaryKey", record);
		return rows;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends BCrrGntyConExample {
		private Object record;

		public UpdateByExampleParms(Object record, BCrrGntyConExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

	public int countByExample(BCrrGntyConExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_CRR_GNTY_CON.countByExample", example);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<BCrrGntyCon> selectByPage(BCrrGntyConExample example, Page page) {
		List<BCrrGntyCon> list = this.searchListPageMyObject("B_CRR_GNTY_CON.selectByExample", example, page);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<BCrrGntyCon> selectByExample(BCrrGntyConExample example) {
		List<BCrrGntyCon> list = getSqlMapClientTemplate().queryForList("B_CRR_GNTY_CON.selectByExample", example);
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO#getSlaveContList(java.util.
	 * Map, com.huateng.base.common.beans.Page)
	 */
	@Override
	public List getSlaveContList(Map map, Page page) {
		List<FourProtocolVO> list = this.searchListPageMyObject("EXT_B_CRR_GNTY_CON.getSlaveContList", map, page);
		return list;
	}

	/*
	 * 
	 * 
	 * 
	 */
	@Override
	public List<BCrrGntyConVO> getWarnDropCtlInfoByParamForCompensate(Map map, Page page) {
		List<BCrrGntyConVO> list = this.searchListPageMyObject("EXT_B_CRR_GNTY_CON.getWarnDropCtlInfoByParam", map, page);
		return list;
	}
	@Override
	public List<BCrrGntyCon> getSlaveContList2(Map map, Page page) {
		List<BCrrGntyCon> list = this.searchListPageMyObject("EXT_B_CRR_GNTY_CON.getSlaveContList", map, page);
		return list;
	}
}