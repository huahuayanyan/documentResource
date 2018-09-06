package com.huateng.scf.bas.pbc.service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.DataItemsDO;
import com.huateng.scf.bas.pbc.model.BPbcMtgMktPriceVO;
import com.huateng.scf.bas.pbc.model.MortMaketPriceQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * @author htrad0055 手工市价维护
 */
public interface IBPbcMtgMktPriceService {

	/**
	 * @param pageNo
	 * @param pageSize
	 * @param commonQueryVO
	 * @return
	 */
	Page getTblMortMarPriPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("commonQueryVO") MortMaketPriceQryVO commonQueryVO);

	/**
	 * @param pageNo
	 * @param pageSize
	 * @param commonQueryVO
	 * @return
	 */
	Page getTblMortMarPriPageForMoreCondition(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("commonQueryVO") MortMaketPriceQryVO commonQueryVO);

	/**
	 * @param pageNo
	 * @param pageSize
	 * @param commonQueryVO
	 * @return
	 */
	Page getMortMarketPriceHandHisInfoPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("commonQueryVO") MortMaketPriceQryVO commonQueryVO);

	/**
	 * @param record
	 * @return
	 */
	public String addOrUpdate(@ScubeParam("bPbcMtgMktPrice") BPbcMtgMktPriceVO record) throws ScubeBizException;

	/**
	 * @param PageNo
	 * @param pageSize
	 * @param dataItemsDO
	 * @return
	 */
	Page findMortgageLevelByPage(@ScubeParam("pageNo") int PageNo, @ScubeParam("pageSize") int pageSize, @ScubeParam("value") DataItemsDO value);

	/**
	 * @param PageNo
	 * @param pageSize
	 * @param dataItemsDO
	 * @return
	 */
	public Page getBaiInfoMarketPri(@ScubeParam("pageNo") int PageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") MortMaketPriceQryVO commonQueryVO);

}
