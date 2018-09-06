package com.huateng.scf.bas.nte.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.nte.dao.IBNteNoticeBaseDAO;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBaseExample;
import com.huateng.scf.bas.nte.dao.model.NoticeQryVO;

@Repository("BNteNoticeBaseDAO")
public class BNteNoticeBaseDAOImpl extends IbatisDaoAnnotation4Template implements IBNteNoticeBaseDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public BNteNoticeBaseDAOImpl() {
		super();
	}

	public int countByExample(BNteNoticeBaseExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_NTE_NOTICE_BASE.countByExample", example);
		return count;
	}

	public int deleteByExample(BNteNoticeBaseExample example) {
		int rows = getSqlMapClientTemplate().delete("B_NTE_NOTICE_BASE.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(String id) {
		BNteNoticeBase _key = new BNteNoticeBase();
		_key.setId(id);
		int rows = getSqlMapClientTemplate().delete("B_NTE_NOTICE_BASE.deleteByPrimaryKey", _key);
		return rows;
	}

	public void insert(BNteNoticeBase record) {
		getSqlMapClientTemplate().insert("B_NTE_NOTICE_BASE.insert", record);
	}

	public void insertSelective(BNteNoticeBase record) {
		getSqlMapClientTemplate().insert("B_NTE_NOTICE_BASE.insertSelective", record);
	}

	@SuppressWarnings("unchecked")
	public List<BNteNoticeBase> selectByExample(BNteNoticeBaseExample example) {
		List<BNteNoticeBase> list = getSqlMapClientTemplate().queryForList("B_NTE_NOTICE_BASE.selectByExample", example);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<BNteNoticeBase> selectByCondition(BNteNoticeBase record) {
		List<BNteNoticeBase> list = getSqlMapClientTemplate().queryForList("B_NTE_NOTICE_BASE.selectByCondition", record);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<BNteNoticeBase> queryNteBaseInfo(Map map, Page page) {
		List<BNteNoticeBase> list = this.searchListPageMyObject("B_NTE_NOTICE_BASE.queryNteBaseInfo", map, page);
		return list;
	}

	public BNteNoticeBase selectByPrimaryKey(String id) {
		BNteNoticeBase _key = new BNteNoticeBase();
		_key.setId(id);
		BNteNoticeBase record = (BNteNoticeBase) getSqlMapClientTemplate().queryForObject("B_NTE_NOTICE_BASE.selectByPrimaryKey", _key);
		return record;
	}

	public int updateByExampleSelective(BNteNoticeBase record, BNteNoticeBaseExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_NTE_NOTICE_BASE.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(BNteNoticeBase record, BNteNoticeBaseExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_NTE_NOTICE_BASE.updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(BNteNoticeBase record) {
		int rows = getSqlMapClientTemplate().update("B_NTE_NOTICE_BASE.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(BNteNoticeBase record) {
		int rows = getSqlMapClientTemplate().update("B_NTE_NOTICE_BASE.updateByPrimaryKey", record);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<BNteNoticeBase> selectByPage(BNteNoticeBaseExample example, Page page) {
		List<BNteNoticeBase> list = this.searchListPageMyObject("B_NTE_NOTICE_BASE.selectByExample", example, page);
		return list;
	}

	// 预付类发货通知管理
	@SuppressWarnings("unchecked")
	public List<NoticeQryVO> getAdvDeliveryNotifyByParam(Map map, Page page) {
		List<NoticeQryVO> list = this.searchListPageMyObject("EXT_B_NTE_NOTICE_BASE.getAdvDeliveryNotifyByParamDao", map, page);
		return list;
	}

	// 预付类发货通知管理-收款确认查询
	@SuppressWarnings("unchecked")
	public List<NoticeQryVO> getAdvDeliveryNotifyConfirmByParam(Map map, Page page) {
		List<NoticeQryVO> list = this.searchListPageMyObject("EXT_B_NTE_NOTICE_BASE.getAdvDeliveryNotifyConfirmByParamDao", map, page);
		return list;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends BNteNoticeBaseExample {
		private Object record;

		public UpdateByExampleParms(Object record, BNteNoticeBaseExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

	// ext
	/**
	 * 通过APPNO和NOTICETYPE查找通知书
	 */
	@Override
	public List<BNteNoticeBase> findBNteNoticeBaseByAppno(BNteNoticeBase bNteNoticeBase) {
		List<BNteNoticeBase> list = getSqlMapClientTemplate().queryForList("EXT_B_NTE_NOTICE_BASE.findBNteNoticeBaseByAppno", bNteNoticeBase);
		return list;
	}

	/**
	 * 根据appno删除对应的通知书
	 */
	public int deleteBNteNoticeBaseByAppno(String appno) {
		int rows = getSqlMapClientTemplate().delete("EXT_B_NTE_NOTICE_BASE.deleteBNteNoticeBaseByAppno", appno);
		return rows;
	}

	/*
	 * 
	 * 通知书查询
	 * 
	 */
	@Override
	public List<NoticeQryVO> selectNoticePageByParamForPage(Map map, Page page) {
		List<NoticeQryVO> list = this.searchListPageMyObject("EXT_B_NTE_NOTICE_BASE.selectNoticePageByParamForPage", map, page);
		return list;
	}
}