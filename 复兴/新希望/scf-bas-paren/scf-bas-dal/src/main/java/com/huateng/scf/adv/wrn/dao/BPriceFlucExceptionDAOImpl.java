package com.huateng.scf.adv.wrn.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.wrn.dao.model.BWanMortFlucPriceVO;
import com.huateng.scf.adv.wrn.dao.model.WarnQryVO;

/**
 * @author htrad0055
 *	价格跌幅预警查询
 *
 */
@Repository(IBPriceFlucExceptionDAO.BeanID)
public class BPriceFlucExceptionDAOImpl extends IbatisDaoAnnotation4Template implements IBPriceFlucExceptionDAO {
	
	@Resource(name="sqlMapClientTemplate")
	IbatisTemplate template;
	
	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BWanMortFlucPriceVO> getPriceFluctuationExceptionList(Map<String, Object> params, Page page) {
		List<BWanMortFlucPriceVO> list =this.searchListPageMyObject("EXT_B_WRN_FLUC_PRICE.selectPriceFluctuationException", params, page);		
		return list;
	}

	@Override
	public Integer countPriceFluctuationException(Map<String, Object> params) {
		Integer count =(Integer) this.getSqlMapClientTemplate().queryForObject("EXT_B_WRN_FLUC_PRICE.countPriceFluctuationException", params);
		return count;
	}



}
