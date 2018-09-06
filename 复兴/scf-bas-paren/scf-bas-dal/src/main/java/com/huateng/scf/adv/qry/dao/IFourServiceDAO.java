package com.huateng.scf.adv.qry.dao;

import java.math.BigDecimal;
import java.util.Map;

public interface IFourServiceDAO {
	/**
     * @Description: 获取协议下的累计融资金额，累计已发货金额，剩余提货金额，累计提货金额,向核心厂商累计提货
     * @param protocolNo
     * @return
     */
	public Map<String, Object> getKindsOfSum(String protocolNo);
	/**
	 * @Description: 在押货物总价值
	 * @param protocolNo
	 * @return
	 */
	public BigDecimal getSumPriceByParam(String protocolNo);
	/**
     * @Description: 获取先票/款后货的已发货金额，未发货金额，借据金额
     * @param protocolNo
     * @return
     */
	public Map<String, Object> getFourWareDeliveryAmt(String protocolNo);
	/**
     * @Description: 根据先票/款后货协议号统计查询：融资金额、融资余额、保证金金额总汇、现金等价物金额
     * @param protocolNo
     * @return
     */
	public Map<String, Object> getFourProtocolTotalLnciAmtByProtocolNo(String protocolNo);
	
}
