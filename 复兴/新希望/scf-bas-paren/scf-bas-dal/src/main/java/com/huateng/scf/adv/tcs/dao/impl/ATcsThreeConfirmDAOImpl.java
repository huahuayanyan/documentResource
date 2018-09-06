package com.huateng.scf.adv.tcs.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.tcs.dao.IATcsThreeConfirmDAO;
import com.huateng.scf.adv.tcs.dao.model.ThreeBuyMortgageInfoVO;
import com.huateng.scf.adv.tcs.dao.model.ThreeConfirmVO;

@Repository("ATcsThreeConfirmDAO")
public class ATcsThreeConfirmDAOImpl extends IbatisDaoAnnotation4Template implements IATcsThreeConfirmDAO {
	@Resource(name="sqlMapClientTemplate")
	private IbatisTemplate template;
	   public ATcsThreeConfirmDAOImpl() {
	        super();
	    }
	    public IbatisTemplate getSqlMapClientTemplate() {
	        return this.template;
	    }
/**
 *  收款确认查询列表
 */
	@Override
	public Page selectThreeConfirmList(Map map, Page page) {
        List<ThreeConfirmVO> list = this.searchListPageMyObject("EXT_A_TCS_THREE_CONFIRM.selectThreeConfirmList", map, page);
        page.setRecords(list);
        return page;
	}

  /***
   * 根据合同查询协议合同信息
   */
	@Override
	public ThreeConfirmVO getContOrProByMastContno(Map map) {
		// TODO Auto-generated method stub
		return (ThreeConfirmVO) getSqlMapClientTemplate().queryForObject("EXT_A_TCS_THREE_CONFIRM.getContOrProByMastContno",map);
	}
	/**
	 * 根据借据号查询收款确认信息
	 * @param map
	 * @return
	 */
	public ThreeConfirmVO getThreeConfirmByDebet(Map map) {
		// TODO Auto-generated method stub
		return (ThreeConfirmVO) getSqlMapClientTemplate().queryForObject("EXT_A_TCS_THREE_CONFIRM.getThreeConfirmByDebet",map);
	}
	/**
	 * 根据借据号查询开票信息
	 */
	@Override
	public List getThreeConfirmBillInfo(Map map, Page page) {
		 List<ThreeConfirmVO> list = this.searchListPageMyObject("EXT_A_TCS_THREE_CONFIRM.getThreeConfirmBillInfo", map, page);
		return list;
	}
	/**
	 * 根据借据号查询购销信息
	 */
	@Override
	public List getConfirmContTradeInfo(Map map, Page page) {
		 List<ThreeBuyMortgageInfoVO> list = this.searchListPageMyObject("EXT_A_TCS_THREE_CONFIRM.getConfirmContTradeInfo", map, page);
		return list;
	}
	/**
	 * 根据购销合同号获得购销合同详情
	 */
	public ThreeBuyMortgageInfoVO getContBuyInfoDtl(Map map) {
		// TODO Auto-generated method stub
		return (ThreeBuyMortgageInfoVO) getSqlMapClientTemplate().queryForObject("EXT_A_TCS_THREE_CONFIRM.getContBuyInfoDtl",map);
	}
	
	/**
	 * 根据购销合同号查询购销合同货物列表
	 */
	@Override
	public List getContBuyMprotList(Map map, Page page) {
		 List<ThreeBuyMortgageInfoVO> list = this.searchListPageMyObject("EXT_A_TCS_THREE_CONFIRM.getContBuyMprotList", map, page);
		return list;
	}
}
