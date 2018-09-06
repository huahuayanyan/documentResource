package com.huateng.scf.adv.qry.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.qry.dao.model.ThreeWareVO;

public interface IThreeWareColligateDAO {
	List<ThreeWareVO> selectByPage(Map<String,Object> param, Page page);
	Map<String,Object> getLnciAmtByProtocolNo(String protocolNo);
	Map<String,Object> getLnciBalByProtocolNo(String protocolNo);
	Map<String,Object> getBailAmountByProtocolNo(String protocolNo);
	Map<String,Object> getCashEqtAmountByProtocolNo(String protocolNo);
	Map<String,Object> getAmountInByProtocolNo(String protocolNo);
	Map<String,Object> getAmountOutByProtocolNo(String protocolNo);
	BigDecimal getContRiskAmtByCycle(Map<String,String> param);
}
