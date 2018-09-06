package com.huateng.scf.bas.pbc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtInfoVO;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfoExample;
import com.huateng.scf.rec.bcp.dao.model.DebtBussInfoVO;

public interface IBPbcAppliBaseInfoDAO {
	int countByExample(BPbcAppliBaseInfoExample example);

	int deleteByExample(BPbcAppliBaseInfoExample example);

	int deleteByPrimaryKey(String appno);

	void insert(BPbcAppliBaseInfo record);

	void insertSelective(BPbcAppliBaseInfo record);

	List<BPbcAppliBaseInfo> selectByExample(BPbcAppliBaseInfoExample example);

	BPbcAppliBaseInfo selectByPrimaryKey(String appno);

	List<BPbcAppliBaseInfo> getFkStatus(String protocolno);

	int updateByExampleSelective(BPbcAppliBaseInfo record, BPbcAppliBaseInfoExample example);

	int updateByExample(BPbcAppliBaseInfo record, BPbcAppliBaseInfoExample example);

	int updateByPrimaryKeySelective(BPbcAppliBaseInfo record);

	int updateByPrimaryKey(BPbcAppliBaseInfo record);

	List<BPbcAppliBaseInfo> selectByPage(BPbcAppliBaseInfoExample example, Page page);

	// ext
	/**
	 * 根据协议号查询未结束流程的差额退款
	 * 
	 * @param map
	 * @return
	 */
	List<BPbcAppliBaseInfo> getBPbcAppInfoByProtocolNo(Map<String, Object> map);

	/**
	 * 查询涉及业务的抵/质押合同
	 * 
	 * @param map
	 * @return
	 */
	List<BPbcAppliBaseInfo> getListBySlaveContno(Map<String, Object> map);

	public String saveBillsVendorAppliBaseInfo(DebtBussInfoVO debtVO, String businessnoType, String workApplyType);

	BCntDebtInfoVO selectBCntDebtInfoVOByMap(Map<String, Object> map);

	// 根据产品id获取相对应放款审批列表
	List<BPbcAppliBaseInfo> selectByProductId(Map<String, Object> map, Page page);

	@SuppressWarnings("rawtypes")
	List getFlowRiskAmtByBusinessNo(HashMap<String, String> omap);

    BPbcAppliBaseInfo selectByIfspAppno(String ifspAppno);
    
    /**
     * 统计业务申请表中各审批状态的条数
     * @param Object
     * @return
     * @return List<HashMap<String,Object>>
     */
    List<HashMap<String, Object>> countAppliStatusList(Map<String, Object> omap);

}