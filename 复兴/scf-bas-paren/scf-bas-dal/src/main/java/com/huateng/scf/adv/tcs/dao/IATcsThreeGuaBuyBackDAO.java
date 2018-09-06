/**
 * 
 */
package com.huateng.scf.adv.tcs.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.tcs.dao.model.ThreeBalanceRefundLnciVO;
import com.huateng.scf.adv.tcs.dao.model.ThreeBalanceRefundVO;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 	2016年12月20日上午10:29:53
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年12月20日上午10:29:53	     新增
 *
 * </pre>
 */
public interface IATcsThreeGuaBuyBackDAO {
	/**
	 * 担保差额退款申请添加待退款列表
	 * @param map
	 * @param page
	 * @return
	 */
	 List<ThreeBalanceRefundLnciVO> getBalRefundLnciByProtocolNo(Map<String, Object> map, Page page);
	 
	/**
	 *  根据申请编号查询差额退款基本信息 
	 * @param map
	 * @return
	 */
	 ThreeBalanceRefundVO getThreeBalanceRefundByAppno(Map<String, Object> map);
	 /**
	  * 差额退款根据申请编号查询借据列表
	  * @param map
	  * @param page
	  * @return
	  */
	 List<ThreeBalanceRefundLnciVO> getInvoiceBuybackAppliByAppno(Map<String, Object> map, Page page);
	 
	 

}
