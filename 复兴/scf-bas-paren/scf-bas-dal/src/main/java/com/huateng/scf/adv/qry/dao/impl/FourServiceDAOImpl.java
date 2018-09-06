package com.huateng.scf.adv.qry.dao.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.qry.dao.IFourServiceDAO;

@Repository("FourServiceDAO")
public class FourServiceDAOImpl extends IbatisDaoAnnotation4Template implements IFourServiceDAO {
	@Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;
	 public FourServiceDAOImpl() {
	        super();
	    }
	 public IbatisTemplate getSqlMapClientTemplate() {
	        return this.template;
	    }
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getKindsOfSum(String protocolNo) {
		List<Map<String, Object>> list = getSqlMapClientTemplate().queryForList("EXT_FOURPROTOCOL.getKindsOfSum", protocolNo);
		if(null!=list&&list.size()!=0){
			return list.get(0);
		}else{
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public BigDecimal getSumPriceByParam(String protocolNo) {
		BigDecimal sum = BigDecimal.ZERO;
		List<Map<String, Object>> list = getSqlMapClientTemplate().queryForList("EXT_FOURPROTOCOL.getSumPriceByParam", protocolNo);
		if(null!=list&&list.size()!=0){
			Map<String,Object> sumMap = list.get(0);
			if(null!=sumMap){
				sum=sumMap.get("TOTPRICE")!=null?(BigDecimal)sumMap.get("TOTPRICE"):BigDecimal.ZERO;
			}
		} 
		return sum;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getFourWareDeliveryAmt(String protocolNo) {
		List<Map<String, Object>> list = getSqlMapClientTemplate().queryForList("EXT_FOURPROTOCOL.getFourWareDeliveryAmt", protocolNo);
		if(null!=list&&list.size()!=0){
			return list.get(0);
		}else{
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getFourProtocolTotalLnciAmtByProtocolNo(String protocolNo) {
		List<Map<String, Object>> list = getSqlMapClientTemplate().queryForList("EXT_FOURPROTOCOL.getFourProtocolTotalLnciAmt", protocolNo);
		if(null!=list&&list.size()!=0){
			return list.get(0);
		}else{
			return null;
		}
	}
		 
}
