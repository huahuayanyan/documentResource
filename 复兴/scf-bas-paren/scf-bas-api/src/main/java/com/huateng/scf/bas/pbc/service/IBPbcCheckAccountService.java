package com.huateng.scf.bas.pbc.service;

import java.math.BigDecimal;
import java.util.HashMap;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.pbc.model.BPbcMtgChkStockInfoVO;
import com.huateng.scf.bas.pbc.model.MortgageEnterDO;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 对账信息
 * @author gongzhao
 *
 */
public interface IBPbcCheckAccountService {

	public Page queryChkStockListByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize, @ScubeParam("map") HashMap<String, Object> map);

	/**
	 * 获取现货与普单的担保合同
	 * @param pageNo
	 * @param pageSize
	 * @param map
	 * @return
	 */
	public Page getContSlaveInfoByProduct(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize, @ScubeParam("map") HashMap<String, Object> map);
	
	/**
	 * 获取押品列表（分页）押品明细查询
	 * @param pageNo
	 * @param pageSize
	 * @param map
	 * @return
	 */
	public Page getTblMortgageBaseInfoPageByParam(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize, @ScubeParam("map") HashMap<String, Object> map);

	/**
	 *  新增对账信息
	 * @param conId
	 */
	public void addCheckAccount(@ScubeParam("conId") String conId);
	
	/**
	 *  对账确认
	 * @param conId
	 */
	public void checkAccountConfirm(@ScubeParam("bPbcMtgChkStockInfoVO") BPbcMtgChkStockInfoVO bPbcMtgChkStockInfoVO);
	
	/**
	 * 统计押品总价
	 * @param map
	 * @return
	 */
	public BigDecimal getSumTblMortgageBaseInfoByParam( @ScubeParam("map") HashMap<String, Object> map);

}
