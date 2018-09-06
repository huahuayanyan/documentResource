package com.huateng.scf.sto.nwr.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.scf.sto.nwr.dao.ISBcpProductBillDAO;
import com.huateng.scf.sto.nwr.dao.ext.ExtSBcpNwrDAO;
import com.huateng.scf.sto.nwr.service.ISBcpProductBillService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("SBcpProductBillServiceImpl")
public class SBcpProductBillServiceImpl implements ISBcpProductBillService 
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "ISBcpProductBillDAO")
	ISBcpProductBillDAO isbcpproductbilldao;
	
	@Resource(name = "ExtSBcpNwrDAO")
	ExtSBcpNwrDAO extsbcpnwrdao;
	
	/**
	 * 根据仓单类型获取仓单小类
	 * @param billType
	 * @return
	 * @throws CommonException
	 * @author 	mengjiajia
	 * @date 	2017年4月12日下午5:31:39
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String getBillByMidProductId(String billType) throws ScubeBizException{
		log.debug("billType="+billType);
		String productId = new String();
		List list = extsbcpnwrdao.getBillByMidProductId(billType);
		if(list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{
				Map<String, String> map = (Map<String, String>) list.get(i);
				productId+=map.get("productId").toString()+",";
			}
		}
		if(productId.length()>0){
			productId = productId.substring(0, productId.length()-1);
		}
		return productId;
	}
}
