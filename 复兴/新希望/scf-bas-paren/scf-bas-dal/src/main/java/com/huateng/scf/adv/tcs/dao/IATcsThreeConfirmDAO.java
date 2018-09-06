/**
 * 
 */
package com.huateng.scf.adv.tcs.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.tcs.dao.model.ThreeBuyMortgageInfoVO;
import com.huateng.scf.adv.tcs.dao.model.ThreeConfirmVO;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 	2016年12月8日下午8:29:53
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年12月8日下午8:29:53	     新增
 *
 * </pre>
 */
public interface IATcsThreeConfirmDAO {
	/**
	 *  收款确认查询列表
	 * @param map
	 * @param page
	 * @return
	 */
	 Page selectThreeConfirmList( Map map, Page page);
	 /**
	  * 根据合同查询协议合同信息
	  * @param map
	  * @return
	  */
	 ThreeConfirmVO getContOrProByMastContno( Map map);
	 /**
	  * 根据借据号查询收款确认信息
	  * @param map
	  * @return
	  */
	 public ThreeConfirmVO getThreeConfirmByDebet(Map map);
	 /**
	  * 根据借据号查询开票信息
	  * @param map
	  * @param page
	  * @return
	  */
	 List getThreeConfirmBillInfo( Map map, Page page);
	 /**
	  * 根据借据号查询购销合同信息
	  * @param map
	  * @param page
	  * @return
	  */
	List getConfirmContTradeInfo(Map map, Page page);
	
	/**
	 * 根据购销合同号获得购销合同详情
	 * @param map
	 * @return
	 */
	public ThreeBuyMortgageInfoVO getContBuyInfoDtl(Map map);
	/**
	 * 根据购销合同号查询购销合同货物列表
	 * @param map
	 * @param page
	 * @return
	 */
	List getContBuyMprotList(Map map, Page page);

}
