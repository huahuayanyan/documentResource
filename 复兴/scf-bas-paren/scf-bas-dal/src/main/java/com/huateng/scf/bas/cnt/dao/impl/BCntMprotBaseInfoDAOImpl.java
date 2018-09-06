package com.huateng.scf.bas.cnt.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.cnt.dao.IBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfoExample;
import com.huateng.scf.bas.cnt.dao.model.FourProtocolVO;
import com.huateng.scf.bas.cnt.dao.model.ThreeProtocolVO;

@Repository("BCntMprotBaseInfoDAO")
public class BCntMprotBaseInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBCntMprotBaseInfoDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public BCntMprotBaseInfoDAOImpl() {
		super();
	}

	public int countByExample(BCntMprotBaseInfoExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_CNT_MPROT_BASE_INFO.countByExample", example);
		return count;
	}

	public int deleteByExample(BCntMprotBaseInfoExample example) {
		int rows = getSqlMapClientTemplate().delete("B_CNT_MPROT_BASE_INFO.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(String protocolNo) {
		BCntMprotBaseInfo _key = new BCntMprotBaseInfo();
		_key.setProtocolNo(protocolNo);
		int rows = getSqlMapClientTemplate().delete("B_CNT_MPROT_BASE_INFO.deleteByPrimaryKey", _key);
		return rows;
	}

	public void insert(BCntMprotBaseInfo record) {
		getSqlMapClientTemplate().insert("B_CNT_MPROT_BASE_INFO.insert", record);
	}

	public void insertSelective(BCntMprotBaseInfo record) {
		getSqlMapClientTemplate().insert("B_CNT_MPROT_BASE_INFO.insertSelective", record);
	}

	@SuppressWarnings("unchecked")
	public List<BCntMprotBaseInfo> selectByExample(BCntMprotBaseInfoExample example) {
		List<BCntMprotBaseInfo> list = getSqlMapClientTemplate().queryForList("B_CNT_MPROT_BASE_INFO.selectByExample", example);
		return list;
	}

	public BCntMprotBaseInfo selectByPrimaryKey(String protocolNo) {
		BCntMprotBaseInfo _key = new BCntMprotBaseInfo();
		_key.setProtocolNo(protocolNo);
		BCntMprotBaseInfo record = (BCntMprotBaseInfo) getSqlMapClientTemplate().queryForObject("B_CNT_MPROT_BASE_INFO.selectByPrimaryKey", _key);
		return record;
	}

	public int updateByExampleSelective(BCntMprotBaseInfo record, BCntMprotBaseInfoExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_CNT_MPROT_BASE_INFO.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(BCntMprotBaseInfo record, BCntMprotBaseInfoExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_CNT_MPROT_BASE_INFO.updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(BCntMprotBaseInfo record) {
		int rows = getSqlMapClientTemplate().update("B_CNT_MPROT_BASE_INFO.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(BCntMprotBaseInfo record) {
		int rows = getSqlMapClientTemplate().update("B_CNT_MPROT_BASE_INFO.updateByPrimaryKey", record);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<BCntMprotBaseInfo> selectByPage(BCntMprotBaseInfoExample example, Page page) {
		List<BCntMprotBaseInfo> list = this.searchListPageMyObject("B_CNT_MPROT_BASE_INFO.selectByExample", example, page);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Map> selectByCondition(Map map) {
		List<Map> list = getSqlMapClientTemplate().queryForList("B_CNT_MPROT_BASE_INFO.selectByCondition", map);
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.cnt.dao.IBCntMprotBaseInfoDAO#queryThreeProtocolList(
	 * com.huateng.base.common.beans.Page, java.util.Map, boolean)
	 */
	@Override
	public Page queryThreeProtocolList(Page page, Map map, boolean isBypPage) {
		if (isBypPage) {
			// 分页查询
			// int
			// totalCount=(Integer)this.getSqlMapClientTemplate().queryForObject("B_CNT_MPROT_BASE_INFO.queryThreeProtocolListCount",
			// map);
			Page scfPage = new Page(page.getPageSize(), page.getPageNo(), 0);
			// searchListPageMyObject("B_SYS_APPLY_DTL.queryBsysApplyDtlList",
			// map, scfPage);
			List<ThreeProtocolVO> threeProtocolVOList = this.searchListPageMyObject("B_CNT_MPROT_BASE_INFO.queryThreeProtocolList", map, scfPage);
			// List<ThreeProtocolVO>
			// threeProtocolVOList=getSqlMapClientTemplate().queryForList("B_CNT_MPROT_BASE_INFO.queryThreeProtocolList",
			// map,page.getStartIndex(),page.getPageSize());
			scfPage.setRecords(threeProtocolVOList);
			return scfPage;
		} else {
			// 不分页查询
			Page scfPage = new Page();
			List<ThreeProtocolVO> threeProtocolVOList = getSqlMapClientTemplate().queryForList("B_CNT_MPROT_BASE_INFO.queryThreeProtocolList", map);
			scfPage.setRecords(threeProtocolVOList);
			return scfPage;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.bas.cnt.dao.IBCntMprotBaseInfoDAO#
	 * queryThreeProtocolForOneObject(java.util.Map)
	 */
	@Override
	public List<BCntMprotBaseInfo> queryThreeProtocolForOneObject(Map map) {
		// TODO Auto-generated method stub
		return null;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends BCntMprotBaseInfoExample {
		private Object record;

		public UpdateByExampleParms(Object record, BCntMprotBaseInfoExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.cnt.dao.IBCntMprotBaseInfoDAO#selectForRelateAdvanced
	 * (java.util.Map)
	 */
	@Override
	public List<BCntMprotBaseInfo> selectForRelateAdvanced(Map map) {
		List<BCntMprotBaseInfo> list = getSqlMapClientTemplate().queryForList("EXT_B_CNT_MPROT_PART_INFO.selectForRelateAdvanced", map);
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.cnt.dao.IBCntMprotBaseInfoDAO#getFourAgreementQuery(
	 * java.util.Map, com.huateng.base.common.beans.Page)
	 */
	@Override
	public List<FourProtocolVO> getFourAgreementQuery(Map map, Page page) {
		List<FourProtocolVO> list = this.searchListPageMyObject("EXT_B_CNT_MPROT_PART_INFO.getFourAgreementQuery", map, page);
		return list;
	}
}