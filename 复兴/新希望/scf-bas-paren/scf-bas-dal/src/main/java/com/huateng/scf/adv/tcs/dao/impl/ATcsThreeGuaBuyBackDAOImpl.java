package com.huateng.scf.adv.tcs.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.tcs.dao.IATcsThreeGuaBuyBackDAO;
import com.huateng.scf.adv.tcs.dao.model.ThreeBalanceRefundLnciVO;
import com.huateng.scf.adv.tcs.dao.model.ThreeBalanceRefundVO;

@Repository("ATcsThreeGuaBuyBackDAO")
public class ATcsThreeGuaBuyBackDAOImpl extends IbatisDaoAnnotation4Template implements IATcsThreeGuaBuyBackDAO{
	@Resource(name="sqlMapClientTemplate")
	private IbatisTemplate template;
	   public ATcsThreeGuaBuyBackDAOImpl() {
	        super();
	    }
	    public IbatisTemplate getSqlMapClientTemplate() {
	        return this.template;
	    }


	/**
	 * 担保差额退款申请添加待退款列表
	 */
	@Override
	public List<ThreeBalanceRefundLnciVO> getBalRefundLnciByProtocolNo(Map<String, Object> map, Page page) {
		 List<ThreeBalanceRefundLnciVO> list = this.searchListPageMyObject("EXT_A_TCS_THREE_GUABUYBACK.getBalRefundLnciByProtocolNo", map, page);
		return list;
	}
	/**
	 *  根据申请编号查询差额退款基本信息 
	 */
	@Override
	public ThreeBalanceRefundVO getThreeBalanceRefundByAppno(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return (ThreeBalanceRefundVO)getSqlMapClientTemplate().queryForObject("EXT_A_TCS_THREE_GUABUYBACK.getThreeBalanceRefundByAppno",map);
	}

	/**
	 * 差额退款根据申请编号查询借据列表
	 */
	@Override
	public List<ThreeBalanceRefundLnciVO> getInvoiceBuybackAppliByAppno(Map<String, Object> map, Page page) {
		 List<ThreeBalanceRefundLnciVO> list = this.searchListPageMyObject("EXT_A_TCS_THREE_GUABUYBACK.getInvoiceBuybackAppliByAppno", map, page);
		return list;
	}

}
