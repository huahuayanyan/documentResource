package com.huateng.scf.nrec.bcp.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;

import com.huateng.scf.nrec.bcp.service.INRBcpAppliRepaymentService;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliRepaymentDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliRepaymentExample;
import com.huateng.scf.rec.bcp.model.RBcpAppliRepayment;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service(INRBcpAppliRepaymentService.BEAN_ID)
public class NRBcpAppliRepaymentServiceImpl implements INRBcpAppliRepaymentService {

	@Resource(name = "IRBcpAppliRepaymentDAO")
	IRBcpAppliRepaymentDAO rbcpapplirepaymentdao;

	/**
	 * 通过APPNO清空还款表对应数据
	 * 
	 * @param appno
	 * @throws ScubeBizException
	 * @author Qinwei
	 * @date 2017年6月2日 下午5:05:00
	 * @returnType
	 */
	@Override
	public void clearTblAppliRepaymentInfo(String appno) throws ScubeBizException {
		List<RBcpAppliRepayment> list = this.queryTblAppliRepaymentInfoByAppno(appno);
		if (list != null && list.size() > 0) {
			Iterator<RBcpAppliRepayment> iter = list.iterator();
			while (iter.hasNext()) {
				RBcpAppliRepayment applyVO = (RBcpAppliRepayment) iter.next();
				rbcpapplirepaymentdao.deleteByPrimaryKey(applyVO.getId());
			}
		}

	}

	/**
	 * 根据appno查询还款申请表数据
	 * 
	 * @param appno
	 * @return
	 * @author Qinwei
	 * @date 2017年6月2日 下午5:06:26
	 * @returnType
	 */
	@Override
	public List<RBcpAppliRepayment> queryTblAppliRepaymentInfoByAppno(String appno) {
		RBcpAppliRepaymentExample rBcpAppliRepaymentExample = new RBcpAppliRepaymentExample();
		RBcpAppliRepaymentExample.Criteria criteria = rBcpAppliRepaymentExample.createCriteria();
		criteria.andAppnoEqualTo(appno);
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliRepayment> rBcpAppliRepaymentList = rbcpapplirepaymentdao
				.selectByExample(rBcpAppliRepaymentExample);
		List<RBcpAppliRepayment> list = new ArrayList<RBcpAppliRepayment>();
		if (rBcpAppliRepaymentList != null && rBcpAppliRepaymentList.size() > 0) {
			for (com.huateng.scf.rec.bcp.dao.model.RBcpAppliRepayment payment : rBcpAppliRepaymentList) {
				RBcpAppliRepayment rBcpAppliRepayment = new RBcpAppliRepayment();
				try {
					BeanUtils.copyProperties(payment, rBcpAppliRepayment);
				} catch (BeansException e) {
					throw new ScubeBizException("转换异常");
				}
				list.add(rBcpAppliRepayment);
			}
		}
		return list;
	}

}
