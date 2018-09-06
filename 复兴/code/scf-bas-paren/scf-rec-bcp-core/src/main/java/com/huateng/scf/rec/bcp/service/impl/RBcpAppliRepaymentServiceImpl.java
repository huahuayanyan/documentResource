package com.huateng.scf.rec.bcp.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;

import com.huateng.scf.rec.bcp.dao.IRBcpAppliRepaymentDAO;
import com.huateng.scf.rec.bcp.model.RBcpAppliRepayment;
import com.huateng.scf.rec.bcp.service.IRBcpAppliRepaymentService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("RBcpAppliRepaymentServiceImpl")
public class RBcpAppliRepaymentServiceImpl implements IRBcpAppliRepaymentService {
	
	@Resource(name = "IRBcpAppliRepaymentDAO")
	IRBcpAppliRepaymentDAO rbcpapplirepaymentdao;
	
	@Override
	public List<RBcpAppliRepayment> queryTblAppliRepaymentInfoByAppno(String appno) {
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliRepayment> listdal = 
				rbcpapplirepaymentdao.selectByRBcpAppliRepaymentByAppno(appno);
		List<RBcpAppliRepayment> list = new ArrayList<RBcpAppliRepayment>();
		if(listdal.size()>0)
		{
			for(com.huateng.scf.rec.bcp.dao.model.RBcpAppliRepayment payment:listdal)
			{
				RBcpAppliRepayment rBcpAppliRepayment = new RBcpAppliRepayment();
				try
				{
					BeanUtils.copyProperties(payment, rBcpAppliRepayment);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("转换异常");
				}
				list.add(rBcpAppliRepayment);
			}
		}
		return list;
	}

	/**
	 * 通过APPNO清空还款表对应数据
	 */
	@Override
	public void clearTblAppliRepaymentInfo(String appno) throws ScubeBizException {
		List list = this.queryTblAppliRepaymentInfoByAppno(appno);
		if(list!=null && list.size()>0){
			Iterator iter = list.iterator();
			while(iter.hasNext()){
				RBcpAppliRepayment applyVO = (RBcpAppliRepayment)iter.next();
				rbcpapplirepaymentdao.deleteByPrimaryKey(applyVO.getId());
			}
		}
		
	}

	
}
