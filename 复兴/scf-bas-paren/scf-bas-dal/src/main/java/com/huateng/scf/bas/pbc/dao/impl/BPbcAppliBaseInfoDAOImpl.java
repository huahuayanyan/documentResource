package com.huateng.scf.bas.pbc.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtInfoVO;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfoExample;
import com.huateng.scf.rec.bcp.dao.model.DebtBussInfoVO;

@Repository("BPbcAppliBaseInfoDAO")
public class BPbcAppliBaseInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBPbcAppliBaseInfoDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	public BPbcAppliBaseInfoDAOImpl() {
		super();
	}

	public int countByExample(BPbcAppliBaseInfoExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_PBC_APPLI_BASE_INFO.countByExample", example);
		return count;
	}

	public int deleteByExample(BPbcAppliBaseInfoExample example) {
		int rows = getSqlMapClientTemplate().delete("B_PBC_APPLI_BASE_INFO.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(String appno) {
		BPbcAppliBaseInfo _key = new BPbcAppliBaseInfo();
		_key.setAppno(appno);
		int rows = getSqlMapClientTemplate().delete("B_PBC_APPLI_BASE_INFO.deleteByPrimaryKey", _key);
		return rows;
	}

	public void insert(BPbcAppliBaseInfo record) {
		getSqlMapClientTemplate().insert("B_PBC_APPLI_BASE_INFO.insert", record);
	}

	public void insertSelective(BPbcAppliBaseInfo record) {
		getSqlMapClientTemplate().insert("B_PBC_APPLI_BASE_INFO.insertSelective", record);
	}

	@SuppressWarnings("unchecked")
	public List<BPbcAppliBaseInfo> selectByExample(BPbcAppliBaseInfoExample example) {
		List<BPbcAppliBaseInfo> list = getSqlMapClientTemplate().queryForList("B_PBC_APPLI_BASE_INFO.selectByExample", example);
		return list;
	}

	public BPbcAppliBaseInfo selectByPrimaryKey(String appno) {
		BPbcAppliBaseInfo _key = new BPbcAppliBaseInfo();
		_key.setAppno(appno);
		BPbcAppliBaseInfo record = (BPbcAppliBaseInfo) getSqlMapClientTemplate().queryForObject("B_PBC_APPLI_BASE_INFO.selectByPrimaryKey", _key);
		return record;
	}

	@SuppressWarnings("unchecked")
	public List<BPbcAppliBaseInfo> getFkStatus(String protocolno) {
		List<BPbcAppliBaseInfo> record = getSqlMapClientTemplate().queryForList("B_PBC_APPLI_BASE_INFO.getFkStatus", protocolno);
		return record;
	}

	public int updateByExampleSelective(BPbcAppliBaseInfo record, BPbcAppliBaseInfoExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_PBC_APPLI_BASE_INFO.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(BPbcAppliBaseInfo record, BPbcAppliBaseInfoExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("B_PBC_APPLI_BASE_INFO.updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(BPbcAppliBaseInfo record) {
		int rows = getSqlMapClientTemplate().update("B_PBC_APPLI_BASE_INFO.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(BPbcAppliBaseInfo record) {
		int rows = getSqlMapClientTemplate().update("B_PBC_APPLI_BASE_INFO.updateByPrimaryKey", record);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<BPbcAppliBaseInfo> selectByPage(BPbcAppliBaseInfoExample example, Page page) {
		List<BPbcAppliBaseInfo> list = this.searchListPageMyObject("B_PBC_APPLI_BASE_INFO.selectByExample", example, page);
		return list;
	}

	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	protected static class UpdateByExampleParms extends BPbcAppliBaseInfoExample {
		private Object record;

		public UpdateByExampleParms(Object record, BPbcAppliBaseInfoExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

	// ext
	/**
	 * 根据协议号查询未结束流程的差额退款
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BPbcAppliBaseInfo> getBPbcAppInfoByProtocolNo(Map<String, Object> map) {
		List<BPbcAppliBaseInfo> list = getSqlMapClientTemplate().queryForList("EXT_B_PBC_APPLI_BASE_INFO.getBPbcAppInfoByProtocolNo", map);
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BPbcAppliBaseInfo> getListBySlaveContno(Map<String, Object> map) {
		List<BPbcAppliBaseInfo> list = getSqlMapClientTemplate().queryForList("EXT_B_PBC_APPLI_BASE_INFO.getListBySlaveContno", map);
		return list;
	}
	/*
	 *
	 * 保存到B_PBC_APPLI_BASE_INFO[业务申请基本信息表]---国内保理业务 saveBillsVendorAppliBaseInfo
	 * 方法
	 * 
	 * @param debtVO
	 * 
	 * @param businessnoType
	 * 
	 * @param workApplyType
	 * 
	 * @return
	 * 
	 * @throws CommonException
	 */

	@Override
	public String saveBillsVendorAppliBaseInfo(DebtBussInfoVO debtVO, String businessnoType, String workApplyType) {
		return null;
	}

	@Override
	public BCntDebtInfoVO selectBCntDebtInfoVOByMap(Map<String, Object> map) {
		BCntDebtInfoVO record = (BCntDebtInfoVO) getSqlMapClientTemplate().queryForObject("EXT_B_PBC_APPLI_BASE_INFO.queryBCntDebtInfoByContno", map);
		return record;

	}

	// 根据产品id获取列表
	@SuppressWarnings("unchecked")
	public List<BPbcAppliBaseInfo> selectByProductId(Map<String, Object> map, Page page) {
		List<BPbcAppliBaseInfo> list = this.searchListPageMyObject("B_PBC_APPLI_BASE_INFO.selectByProductId", map, page);
		return list;
	}

	/**
	 * @Description: 根据业务合同号查询流程中的借据敞口余额汇总
	 * @author xiaolong.xiong
	 * @Created 2013-9-27下午6:00:54
	 * @param businessNo
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List getFlowRiskAmtByBusinessNo(HashMap<String, String> omap) {
		List list = getSqlMapClientTemplate().queryForList("EXT_B_PBC_APPLI_BASE_INFO.getFlowRiskAmtByBusinessNo", omap);
		return list;
	}
	/**
	 * @Description: 根据申请编号查业务流水
	 * @author zhangcheng
	 * @Created 2017-03-27下午6:00:54
	 * @param ifpsappno
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Override
   public BPbcAppliBaseInfo selectByIfspAppno(String ifspAppno) {
	        BPbcAppliBaseInfo _key = new BPbcAppliBaseInfo();
	        _key.setIfspAppno(ifspAppno);
	        BPbcAppliBaseInfo record = (BPbcAppliBaseInfo) getSqlMapClientTemplate().queryForObject("B_PBC_APPLI_BASE_INFO.selectByIfspAppno", _key);
	        return record;
	    }
	
	/**
     * 统计业务申请表中各审批状态的条数
     * @param Object
     * @return
     * @return List<HashMap<String,Object>>
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<HashMap<String, Object>> countAppliStatusList(Map<String, Object> omap){
		 List<HashMap<String, Object>> list =  getSqlMapClientTemplate().queryForList("EXT_B_PBC_APPLI_BASE_INFO.countAppliStatusList", omap);
		 return list; 
	}
}