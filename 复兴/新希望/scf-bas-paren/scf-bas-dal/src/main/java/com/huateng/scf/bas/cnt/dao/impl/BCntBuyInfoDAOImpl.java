package com.huateng.scf.bas.cnt.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.cnt.dao.IBCntBuyInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntBuyInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntBuyInfoExample;
import com.huateng.scf.bas.cnt.dao.model.ContSelectVO;

@Repository("BCntBuyInfoDAO")
public class BCntBuyInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBCntBuyInfoDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public BCntBuyInfoDAOImpl() {
		super();
	}

	public int countByExample(BCntBuyInfoExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_CNT_BUY_INFO.countByExample", example);
		return count;
	}

	public int deleteByExample(BCntBuyInfoExample example) {
		int rows = getSqlMapClientTemplate().delete("B_CNT_BUY_INFO.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(String tradeContno) {
		BCntBuyInfo _key = new BCntBuyInfo();
		_key.setTradeContno(tradeContno);
		int rows = getSqlMapClientTemplate().delete("B_CNT_BUY_INFO.deleteByPrimaryKey", _key);
		return rows;
	}

	public String insert(BCntBuyInfo record) {
		return (String) getSqlMapClientTemplate().insert("B_CNT_BUY_INFO.insert", record);
	}

	public void insertSelective(BCntBuyInfo record) {
		getSqlMapClientTemplate().insert("B_CNT_BUY_INFO.insertSelective", record);
	}

	@SuppressWarnings("unchecked")
	public List<BCntBuyInfo> selectByExample(BCntBuyInfoExample example) {
		List<BCntBuyInfo> list = getSqlMapClientTemplate().queryForList("B_CNT_BUY_INFO.selectByExample", example);
		return list;
	}

	public BCntBuyInfo selectByPrimaryKey(String tradeContno) {
		BCntBuyInfo _key = new BCntBuyInfo();
		_key.setTradeContno(tradeContno);
		BCntBuyInfo record = (BCntBuyInfo) getSqlMapClientTemplate().queryForObject("B_CNT_BUY_INFO.selectByPrimaryKey", _key);
		return record;
	}

	public List<BCntBuyInfo> selectByProtocolNo(String protocolNo) {
		BCntBuyInfo _key = new BCntBuyInfo();
		_key.setProtocolNo(protocolNo);
		List<BCntBuyInfo> list = getSqlMapClientTemplate().queryForList("B_CNT_BUY_INFO.selectByProtocolNo", _key);
		return list;
	}

	public int updateByExampleSelective(BCntBuyInfo record, BCntBuyInfoExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_CNT_BUY_INFO.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(BCntBuyInfo record, BCntBuyInfoExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_CNT_BUY_INFO.updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(BCntBuyInfo record) {
		int rows = getSqlMapClientTemplate().update("B_CNT_BUY_INFO.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(BCntBuyInfo record) {
		int rows = getSqlMapClientTemplate().update("B_CNT_BUY_INFO.updateByPrimaryKey", record);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<BCntBuyInfo> selectByPage(BCntBuyInfoExample example, Page page) {
		List<BCntBuyInfo> list = this.searchListPageMyObject("B_CNT_BUY_INFO.selectByExample", example, page);
		return list;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends BCntBuyInfoExample {
		private Object record;

		public UpdateByExampleParms(Object record, BCntBuyInfoExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BCntBuyInfo> selectContBuyInfoByDebetNo(String debetNo, Page page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("debetNo", debetNo);
		List<BCntBuyInfo> list = this.searchListPageByMap("B_CNT_BUY_INFO.selectContBuyInfoByDebetNo", param, page);
		return list;
	}

	@Override
	public Integer selectContBuyCountByDebetNo(String debetNo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("debetNo", debetNo);
		Integer count = (Integer) this.getSqlMapClientTemplate().queryForObject("B_CNT_BUY_INFO.selectContBuyCountByDebetNo", param);
		return count;
	}

	@Override
	public Page selectThreeProtocolList(Map map, Page page) {
		List<ContSelectVO> list = this.searchListPageMyObject("EXT_B_CNT_BUY_INFO.selectThreeProtocolList", map, page);
		page.setRecords(list);
		return page;
	}

	/**
	 * 购销合同列表查询
	 */
	@Override
	public Page queryBCntBuyInfoListByPage(Map map, Page page) {
		List<BCntBuyInfo> list = this.searchListPageMyObject("EXT_B_CNT_BUY_INFO.queryBCntBuyInfoList", map, page);
		page.setRecords(list);
		return page;
	}

	/**
	 * 购销合同列表查询(预付类发货通知管理)
	 */
	@Override
	public Page getDeliveryNotifyBuycontInfo(Map map, Page page) {
		List<BCntBuyInfo> list = this.searchListPageMyObject("EXT_B_CNT_BUY_INFO.getDeliveryNotifyBuycontInfo", map, page);
		page.setRecords(list);
		return page;
	}
}