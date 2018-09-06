package com.huateng.scf.adv.qry.dao.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.qry.dao.IThreeWareColligateDAO;
import com.huateng.scf.adv.qry.dao.model.ThreeWareVO;
@Repository("ThreeWareColligateDAO")
public class ThreeWareColligateDAOImpl extends IbatisDaoAnnotation4Template implements IThreeWareColligateDAO {
	@Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;
	 public ThreeWareColligateDAOImpl() {
	        super();
	    }
	 public IbatisTemplate getSqlMapClientTemplate() {
	        return this.template;
	    }
	 
	@Override
	public List<ThreeWareVO> selectByPage(Map<String, Object> param, Page page) {
		@SuppressWarnings("unchecked")
		List<ThreeWareVO> list =  this.searchListPageMyObject("EXT_THREEWARECOLLIGATE.queryColligate",param, page);
        return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getLnciAmtByProtocolNo(String protocolNo) {
		List<Map<String, Object>> list = getSqlMapClientTemplate().queryForList("EXT_THREEWARECOLLIGATE.getLnciAmtByProtocolNo", protocolNo);
		if(null!=list&&list.size()!=0){
			return list.get(0);
		}else{
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getLnciBalByProtocolNo(String protocolNo) {
		List<Map<String, Object>> list = getSqlMapClientTemplate().queryForList("EXT_THREEWARECOLLIGATE.getLnciBalByProtocolNo", protocolNo);
		if(null!=list&&list.size()!=0){
			return list.get(0);
		}else{
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getBailAmountByProtocolNo(String protocolNo) {
		List<Map<String, Object>> list = getSqlMapClientTemplate().queryForList("EXT_THREEWARECOLLIGATE.getBailAmountByProtocolNo", protocolNo);
		if(null!=list&&list.size()!=0){
			return list.get(0);
		}else{
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getCashEqtAmountByProtocolNo(String protocolNo) {
		List<Map<String, Object>> list = getSqlMapClientTemplate().queryForList("EXT_THREEWARECOLLIGATE.getCashEqtAmountByProtocolNo", protocolNo);
		if(null!=list&&list.size()!=0){
			return list.get(0);
		}else{
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getAmountInByProtocolNo(String protocolNo) {
		List<Map<String, Object>> list = getSqlMapClientTemplate().queryForList("EXT_THREEWARECOLLIGATE.getAmountInByProtocolNo", protocolNo);
		if(null!=list&&list.size()!=0){
			return list.get(0);
		}else{
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getAmountOutByProtocolNo(String protocolNo) {
		List<Map<String, Object>> list = getSqlMapClientTemplate().queryForList("EXT_THREEWARECOLLIGATE.getAmountOutByProtocolNo", protocolNo);
		if(null!=list&&list.size()!=0){
			return list.get(0);
		}else{
			return null;
		}
	}
	@Override
	public BigDecimal getContRiskAmtByCycle(Map<String, String> param) {
		// TODO Auto-generated method stub
		return null;
	}
}
