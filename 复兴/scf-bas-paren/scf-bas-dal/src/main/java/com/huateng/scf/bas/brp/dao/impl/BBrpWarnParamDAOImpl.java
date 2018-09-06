package com.huateng.scf.bas.brp.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.brp.dao.IBBrpWarnParamDAO;
import com.huateng.scf.bas.brp.dao.model.BBrpWarnParam;
import com.huateng.scf.bas.brp.dao.model.BBrpWarnParamExample;
import com.huateng.scf.bas.brp.dao.model.WarnParamVO;

@Repository("BBrpWarnParamDAO")
public class BBrpWarnParamDAOImpl extends IbatisDaoAnnotation4Template implements IBBrpWarnParamDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public BBrpWarnParamDAOImpl() {
		super();
	}

	public int countByExample(BBrpWarnParamExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_BRP_WARN_PARAM.countByExample", example);
		return count;
	}

	public int deleteByExample(BBrpWarnParamExample example) {
		int rows = getSqlMapClientTemplate().delete("B_BRP_WARN_PARAM.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(String warnNo) {
		BBrpWarnParam _key = new BBrpWarnParam();
		_key.setWarnNo(warnNo);
		int rows = getSqlMapClientTemplate().delete("B_BRP_WARN_PARAM.deleteByPrimaryKey", _key);
		return rows;
	}

	public void insert(BBrpWarnParam record) {
		getSqlMapClientTemplate().insert("B_BRP_WARN_PARAM.insert", record);
	}

	public void insertSelective(BBrpWarnParam record) {
		getSqlMapClientTemplate().insert("B_BRP_WARN_PARAM.insertSelective", record);
	}

	@SuppressWarnings("unchecked")
	public List<BBrpWarnParam> selectByExample(BBrpWarnParamExample example) {
		List<BBrpWarnParam> list = getSqlMapClientTemplate().queryForList("B_BRP_WARN_PARAM.selectByExample", example);
		return list;
	}

	public BBrpWarnParam selectByPrimaryKey(String warnNo) {
		BBrpWarnParam _key = new BBrpWarnParam();
		_key.setWarnNo(warnNo);
		BBrpWarnParam record = (BBrpWarnParam) getSqlMapClientTemplate()
				.queryForObject("B_BRP_WARN_PARAM.selectByPrimaryKey", _key);
		return record;
	}

	public int updateByExampleSelective(BBrpWarnParam record, BBrpWarnParamExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_BRP_WARN_PARAM.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(BBrpWarnParam record, BBrpWarnParamExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_BRP_WARN_PARAM.updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(BBrpWarnParam record) {
		int rows = getSqlMapClientTemplate().update("B_BRP_WARN_PARAM.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(BBrpWarnParam record) {
		int rows = getSqlMapClientTemplate().update("B_BRP_WARN_PARAM.updateByPrimaryKey", record);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<BBrpWarnParam> selectByPage(BBrpWarnParamExample example, Page page) {
		List<BBrpWarnParam> list = this.searchListPageMyObject("B_BRP_WARN_PARAM.selectByExample", example, page);
		return list;
	}

	/**
	 * 获取预警信息
	 * @param omap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<WarnParamVO> getWarningInfo(Map<String, Object> omap,Page page) {
		//List<WarnParamVO> list = getSqlMapClientTemplate().queryForList("B_BRP_WARN_PARAM.getWarningInfo", omap);
		List<WarnParamVO> list = this.searchListPageMyObject("B_BRP_WARN_PARAM.getWarningInfo", omap,page);
		return list;
	}
	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends BBrpWarnParamExample {
		private Object record;

		public UpdateByExampleParms(Object record, BBrpWarnParamExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}