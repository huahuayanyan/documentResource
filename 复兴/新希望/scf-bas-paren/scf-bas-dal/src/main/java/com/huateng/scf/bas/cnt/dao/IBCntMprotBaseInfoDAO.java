package com.huateng.scf.bas.cnt.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfoExample;
import com.huateng.scf.bas.cnt.dao.model.FourProtocolVO;

public interface IBCntMprotBaseInfoDAO {
	int countByExample(BCntMprotBaseInfoExample example);

	int deleteByExample(BCntMprotBaseInfoExample example);

	int deleteByPrimaryKey(String protocolNo);

	void insert(BCntMprotBaseInfo record);

	void insertSelective(BCntMprotBaseInfo record);

	List<BCntMprotBaseInfo> selectByExample(BCntMprotBaseInfoExample example);

	BCntMprotBaseInfo selectByPrimaryKey(String protocolNo);

	int updateByExampleSelective(BCntMprotBaseInfo record, BCntMprotBaseInfoExample example);

	int updateByExample(BCntMprotBaseInfo record, BCntMprotBaseInfoExample example);

	int updateByPrimaryKeySelective(BCntMprotBaseInfo record);

	int updateByPrimaryKey(BCntMprotBaseInfo record);

	List<BCntMprotBaseInfo> selectByPage(BCntMprotBaseInfoExample example, Page page);

	/**
	 * 查询审批意见列表
	 * 
	 * @param page
	 *            Page对象
	 * @param map
	 *            Map对象
	 * @param isBypPage
	 *            boolean-[true-分页查询,false-不分页]
	 * @return
	 */
	public Page queryThreeProtocolList(Page page, Map map, boolean isBypPage);

	/**
	 * 四方 先票/款后货
	 * 
	 * 
	 */
	public List<FourProtocolVO> getFourAgreementQuery(Map map, Page page);

	/**
	 * 初始化页面的用户及机构信息
	 * 
	 * @param map
	 *            Map对象
	 * @return
	 */
	List<BCntMprotBaseInfo> queryThreeProtocolForOneObject(Map map);

	List<Map> selectByCondition(Map map);

	/**
	 * 合同关联（预付类查询）
	 * 
	 * @param map
	 *            Map对象
	 * @return
	 */
	List<BCntMprotBaseInfo> selectForRelateAdvanced(Map map);

}