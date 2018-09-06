/**
 * 
 */
package com.huateng.scf.adv.tcs.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.tcs.dao.model.ThreeBuyMortgageInfoVO;
import com.huateng.scf.adv.tcs.dao.model.ThreeConfirmVO;
import com.huateng.scf.adv.tcs.dao.model.ThreeDeliveryVO;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2016年12月25日下午2:39:08
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2016年12月25日下午2:39:08              新增
 *
 * </pre>
 */
public interface IATcsThreeDeliveryDAO {
	/**
	 *  提货申请查询列表
	 * @param map
	 * @param page
	 * @return
	 */
	 List<ThreeDeliveryVO> selectThreeDeliveryList( Map map, Page page);
	 /**
	  * 根据申请编号查询提货申请信息
	  * @param map
	  * @return
	  */
	 public ThreeDeliveryVO getThreeDeliveryInfoByAppno(Map map);
	 /**
	  * 根据借据号查询提货信息
	  * @param map
	  * @return
	  */
	 public ThreeDeliveryVO getThreeDeliveryInfoByDebetNo(Map map);
	/**
	 * 根据借据号查询对应出账的贸易合同押品信息
	 * @param map
	 * @param page
	 * @return
	 */
	List<ThreeBuyMortgageInfoVO> getTripartiteDeliveryAppMortList(Map<String, Object> map, Page page);
	
	/**
	 * 根据申请编号查询冻结保证金信息
	 * @param appno
	 * @param page
	 * @return
	 */
	List getAddBailAmountListByAppno( String appno, Page page);

}
