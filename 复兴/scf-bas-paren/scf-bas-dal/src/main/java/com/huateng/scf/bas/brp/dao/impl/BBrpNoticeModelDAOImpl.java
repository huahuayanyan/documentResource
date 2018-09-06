package com.huateng.scf.bas.brp.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.brp.dao.IBBrpNoticeModelDAO;
import com.huateng.scf.bas.brp.dao.model.BBrpNoticeModel;
import com.huateng.scf.bas.brp.dao.model.BBrpNoticeModelExample;

@Repository("BBrpNoticeModelDAO")
public class BBrpNoticeModelDAOImpl extends IbatisDaoAnnotation4Template implements IBBrpNoticeModelDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public BBrpNoticeModelDAOImpl() {
		super();
	}



	@Override
	public List<BBrpNoticeModel> selectByPage(BBrpNoticeModelExample example, Page page) {
		List<BBrpNoticeModel> list = this.searchListPageMyObject("B_BRP_NOTICE_MODEL.selectByExample", example, page);
		return list;
	}
	
	@Override
	public void insert(BBrpNoticeModel record) {
		getSqlMapClientTemplate().insert("B_BRP_NOTICE_MODEL.insert", record);
	}

	@Override
	public List<BBrpNoticeModel> selectByExample(BBrpNoticeModelExample example) {
		List<BBrpNoticeModel> list = getSqlMapClientTemplate().queryForList("B_BRP_NOTICE_MODEL.selectByExample", example);
		return list;
	}
	
	@Override
	public int updateByPrimaryKey(BBrpNoticeModel record) {
		int rows = getSqlMapClientTemplate().update("B_BRP_NOTICE_MODEL.updateByPrimaryKey", record);
		return rows;
	}
	@Override
	public int deleteByPrimaryKey(String id) {
		BBrpNoticeModel _key = new BBrpNoticeModel();
		_key.setId(id);
		int rows = getSqlMapClientTemplate().delete("B_BRP_NOTICE_MODEL.deleteByPrimaryKey", _key);
		return rows;
	}
	@Override
	public BBrpNoticeModel selectByPrimaryKey(String id) {
		BBrpNoticeModel _key = new BBrpNoticeModel();
		_key.setId(id);
		BBrpNoticeModel record = (BBrpNoticeModel) getSqlMapClientTemplate()
				.queryForObject("B_BRP_NOTICE_MODEL.selectByPrimaryKey", _key);
		return record;
	}
	@Override
	public BBrpNoticeModel selectByNoticeType(String noticeType) {
		BBrpNoticeModel record = new BBrpNoticeModel();
		record.setNoticeType(noticeType);
		List<BBrpNoticeModel> list = getSqlMapClientTemplate().queryForList("B_BRP_NOTICE_MODEL.selectByNoticeType", record);
		if(list!=null) {
			record=list.get(0);
		}
		return record;
	}
	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends BBrpNoticeModelExample {
		private Object record;

		public UpdateByExampleParms(Object record, BBrpNoticeModelExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}


}

