package com.huateng.scf.bas.pbc.dao.ext;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyConVO;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo;
import com.huateng.scf.bas.pbc.dao.model.ext.BPbcMtgChkStockInfoVO;
import com.huateng.scf.bas.pbc.dao.vo.BPbcAppliMtgInfoVO;
import com.huateng.scf.bas.pbc.dao.vo.BPbcMtgBaseInfoVO;

/**
 * 对账信息
 * @author gongzhao
 *
 */
public interface ExtIBPbcMtgChkStockBaseInfoDAO {
	
	/**
	 * 对账信息查询
	 * @param omap
	 * @param page
	 * @return
	 */
    List<BPbcMtgChkStockInfoVO> getCheckAccountInfoByPara(HashMap<String, Object> omap, Page page);

	/**
	 * 对账信息查询个数
	 * @param omap
	 * @return
	 */
    int countCheckAccountInfoByPara(HashMap<String, Object> omap);
    
	/**
	 * 质押合同信息查询
	 * @param omap
	 * @param page
	 * @return
	 */
    List<BCrrGntyConVO> getContSlaveInfoByProduct(HashMap<String, Object> omap, Page page);

	/**
	 * 质押合同查询个数
	 * @param omap
	 * @return
	 */
    int countContSlaveInfoByProduct(HashMap<String, Object> omap);
    
    /**
	 * 查看质押合同下押品 
	 * @param omap
	 * @param page
	 * @return
	 */
    List<Map<String, String>> getTblMortgageBaseInfoPageByParam(HashMap<String, Object> omap, Page page);
    
    /**
     * 押品价格总价
     * @param omap
     * @return
     */
    BigDecimal getSumTblMortgageBaseInfoByParam(HashMap<String, Object> omap);

}