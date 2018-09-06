package com.huateng.scf.adv.fcs.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.fcs.dao.model.FourDeliveryVO;
import com.huateng.scf.adv.fcs.dao.model.FourMortgageVO;

public interface IFourDAO {
	
	public List<FourMortgageVO> getFHPledgeDeliveryMortInfoList(Map<String, Object> map, Page page);
	
	/**
	 *  提货申请查询列表
	 * @param map
	 * @param page
	 * @return
	 */
	 List<FourDeliveryVO> selectFourDeliveryList(Map<String, Object> map, Page page);
	 
	 
	 /**
	  * 根据申请编号查询提货申请信息
	  * @param map
	  * @return
	  */
	 public FourDeliveryVO getFourDeliveryInfoByAppno(Map<String, Object> map);
	 /**
	  * 根据借据号查询提货信息
	  * @param map
	  * @return
	  */
	 public FourDeliveryVO getFourDeliveryInfoByDebetNo(Map<String, Object> map);
}
