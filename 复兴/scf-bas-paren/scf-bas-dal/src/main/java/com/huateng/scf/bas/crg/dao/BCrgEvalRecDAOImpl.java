package com.huateng.scf.bas.crg.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crg.dao.model.BCrgEvalRec;
import com.huateng.scf.bas.crg.dao.model.BCrgEvalRecExample;

@Repository("BCrgEvalRecDAO")
public class BCrgEvalRecDAOImpl extends IbatisDaoAnnotation4Template implements BCrgEvalRecDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public BCrgEvalRecDAOImpl() {
		super();
	}

	public int countByExample(BCrgEvalRecExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_CRG_EVAL_REC.countByExample", example);
		return count;
	}

	public int deleteByExample(BCrgEvalRecExample example) {
		int rows = getSqlMapClientTemplate().delete("B_CRG_EVAL_REC.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(String evalId) {
		BCrgEvalRec _key = new BCrgEvalRec();
		_key.setEvalId(evalId);
		int rows = getSqlMapClientTemplate().delete("B_CRG_EVAL_REC.deleteByPrimaryKey", _key);
		return rows;
	}

	public void insert(BCrgEvalRec record) {
		getSqlMapClientTemplate().insert("B_CRG_EVAL_REC.insert", record);
	}

	public void insertSelective(BCrgEvalRec record) {
		getSqlMapClientTemplate().insert("B_CRG_EVAL_REC.insertSelective", record);
	}

	@SuppressWarnings("unchecked")
	public List<BCrgEvalRec> selectByExampleWithBLOBs(BCrgEvalRecExample example) {
		List<BCrgEvalRec> list = getSqlMapClientTemplate().queryForList("B_CRG_EVAL_REC.selectByExampleWithBLOBs",
				example);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<BCrgEvalRec> selectByExampleWithoutBLOBs(BCrgEvalRecExample example) {
		List<BCrgEvalRec> list = getSqlMapClientTemplate().queryForList("B_CRG_EVAL_REC.selectByExample", example);
		return list;
	}

	public BCrgEvalRec selectByPrimaryKey(String evalId) {
		BCrgEvalRec _key = new BCrgEvalRec();
		_key.setEvalId(evalId);
		BCrgEvalRec record = (BCrgEvalRec) getSqlMapClientTemplate().queryForObject("B_CRG_EVAL_REC.selectByPrimaryKey",
				_key);
		return record;
	}

	public int updateByExampleSelective(BCrgEvalRec record, BCrgEvalRecExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_CRG_EVAL_REC.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExampleWithBLOBs(BCrgEvalRec record, BCrgEvalRecExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_CRG_EVAL_REC.updateByExampleWithBLOBs", parms);
		return rows;
	}

	public int updateByExampleWithoutBLOBs(BCrgEvalRec record, BCrgEvalRecExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_CRG_EVAL_REC.updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(BCrgEvalRec record) {
		int rows = getSqlMapClientTemplate().update("B_CRG_EVAL_REC.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKeyWithBLOBs(BCrgEvalRec record) {
		int rows = getSqlMapClientTemplate().update("B_CRG_EVAL_REC.updateByPrimaryKeyWithBLOBs", record);
		return rows;
	}

	public int updateByPrimaryKeyWithoutBLOBs(BCrgEvalRec record) {
		int rows = getSqlMapClientTemplate().update("B_CRG_EVAL_REC.updateByPrimaryKey", record);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<BCrgEvalRec> selectByPage(BCrgEvalRecExample example, Page page) {
		List<BCrgEvalRec> list = this.searchListPageMyObject("B_CRG_EVAL_REC.selectByExample", example, page);
		return list;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends BCrgEvalRecExample {
		private Object record;

		public UpdateByExampleParms(Object record, BCrgEvalRecExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

	@Override
	public int updateByExample(BCrgEvalRec record, BCrgEvalRecExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_CRG_EVAL_REC.updateByExample", parms);
		return rows;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BCrgEvalRec> selectByExample(BCrgEvalRecExample example) {
		List<BCrgEvalRec> list = getSqlMapClientTemplate().queryForList("B_CRG_EVAL_REC.selectByExample", example);
		return list;
	}

	@Override
	public BCrgEvalRec selectByProcessId(String processId) {
		BCrgEvalRec _key = new BCrgEvalRec();
        _key.setProcessId(processId);
        BCrgEvalRec record = (BCrgEvalRec) getSqlMapClientTemplate().queryForObject("B_CRG_EVAL_REC.selectByProcessId", _key);
        return record;
	}

	@Override
	public int updateByPrimaryKey(BCrgEvalRec record) {
		int rows = getSqlMapClientTemplate().update("B_CRG_EVAL_REC.updateByPrimaryKey", record);
		return rows;
	}
}