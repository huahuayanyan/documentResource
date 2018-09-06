/**
 * 
 */
package com.huateng.scf.bas.lan.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.BCntBuyInfo;
import com.huateng.scf.bas.cnt.service.IBCntBuyInfoService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.lan.constant.BLanErrorConstant;
import com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.IBLanLnciBuyInfoDAO;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBuyInfoExample;
import com.huateng.scf.bas.lan.model.ApplyBuyContVO;
import com.huateng.scf.bas.lan.model.BLanLnciBuyInfo;
import com.huateng.scf.bas.lan.service.IBLanLnciBuyInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>放款申请购销合同信息(申请)服务</p>
 *
 * @author 	shangxiujuan
 * @date 2017年4月17日下午5:55:18
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年4月17日下午5:55:18              新增
 *
 * </pre>
 */
@ScubeService
@Service("BLanLnciBuyInfoServiceImpl")
public class BLanLnciBuyInfoServiceImpl implements IBLanLnciBuyInfoService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BLanLnciBuyInfoDAO")
	IBLanLnciBuyInfoDAO bLanLnciBuyInfoDAO;
	@Resource(name = "BCntBuyInfoServiceImpl")
	IBCntBuyInfoService bCntBuyInfoService;
	@Override
	@Transactional
	public BLanLnciBuyInfo addBLanLnciBuyInfo(BLanLnciBuyInfo bLanLnciBuyInfo) throws ScubeBizException {
	
		com.huateng.scf.bas.lan.dao.model.BLanLnciBuyInfo bLanLnciBuyInfodal = new com.huateng.scf.bas.lan.dao.model.BLanLnciBuyInfo();
		bLanLnciBuyInfo.setId(UUIDGeneratorUtil.generate());
		try {
			BeanUtils.copyProperties(bLanLnciBuyInfo, bLanLnciBuyInfodal);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("放款申请购销合同信息转换异常！"+e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10012), BLanErrorConstant.SCF_BAS_LAN_10012);
		}
		try {
			bLanLnciBuyInfoDAO.insert(bLanLnciBuyInfodal);
		} catch (Exception e) {
			// e.printStackTrace();
			log.error("放款申请购销合同信息插入异常！"+e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10013), BLanErrorConstant.SCF_BAS_LAN_10013);
		}
		return bLanLnciBuyInfo;

	}

	@Override
	@Transactional
	public int updateBLanLnciBuyInfo(BLanLnciBuyInfo bLanLnciBuyInfo) throws ScubeBizException {
		com.huateng.scf.bas.lan.dao.model.BLanLnciBuyInfo bLanLnciBuyInfodal = new com.huateng.scf.bas.lan.dao.model.BLanLnciBuyInfo();
		try {
			BeanUtils.copyProperties(bLanLnciBuyInfo, bLanLnciBuyInfodal);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("放款申请购销合同信息转换异常！"+e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10012), BLanErrorConstant.SCF_BAS_LAN_10012);
		}
		int i = 0;
		try {
			// TODO 最后更新人==
			i = bLanLnciBuyInfoDAO.updateByPrimaryKey(bLanLnciBuyInfodal);
		} catch (Exception e) {
			// e.printStackTrace();
			log.error("放款申请购销合同信息更新异常！"+e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10014), BLanErrorConstant.SCF_BAS_LAN_10014);
		}
		return i;
	}

	@Override
	@Transactional
	public int deleteBLanLnciBuyInfo(String key) throws ScubeBizException {
		int i = 0;
		try {
			i = bLanLnciBuyInfoDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("放款申请购销合同信息删除异常！"+e.getMessage());
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10015), BLanErrorConstant.SCF_BAS_LAN_10015);
		}
		return i;
	}

	@Override
	public BLanLnciBuyInfo findBLanLnciBuyInfoByKey(String key) throws ScubeBizException{
		// TODO Auto-generated method stub
		BLanLnciBuyInfo bLanLnciBuyInfo = new BLanLnciBuyInfo();
		com.huateng.scf.bas.lan.dao.model.BLanLnciBuyInfo  bLanLnciBuyInfoDal = bLanLnciBuyInfoDAO.selectByPrimaryKey(key);
		if(bLanLnciBuyInfoDal!=null){
			BeanUtils.copyProperties(bLanLnciBuyInfoDal, bLanLnciBuyInfo);	
		}
		return bLanLnciBuyInfo;
	}

	/**
	 * 根据申请编号查询购销合同信息
	 * 返回对象为购销合同表中的审批中出账金额
	 */
	@Override
	public Page getLoanApplyBuyContnoInfo(int pageNo, int pageSize, BLanLnciBuyInfo bLanLnciBuyInfo) throws ScubeBizException {
		BLanLnciBuyInfoExample example = new BLanLnciBuyInfoExample();
		Page p = new Page(pageSize, pageNo, 0);
		// 查询条件
		if (bLanLnciBuyInfo != null) {
			BLanLnciBuyInfoExample.Criteria criteria = example.createCriteria();
			if (StringUtil.isStrNotEmpty(bLanLnciBuyInfo.getAppno())) {
				criteria.andAppnoEqualTo(bLanLnciBuyInfo.getAppno());
			}
			 List<com.huateng.scf.bas.lan.dao.model.BLanLnciBuyInfo> applibuyList =bLanLnciBuyInfoDAO.selectByPage(example, p);
			
			Iterator it = applibuyList.iterator();
			List<ApplyBuyContVO> list = new ArrayList<ApplyBuyContVO>();
			while(it.hasNext()){
				com.huateng.scf.bas.lan.dao.model.BLanLnciBuyInfo buyInfo = (com.huateng.scf.bas.lan.dao.model.BLanLnciBuyInfo) it.next();
				ApplyBuyContVO contVO = new ApplyBuyContVO();
				BeanUtils.copyProperties(buyInfo,contVO);
				BCntBuyInfo bCntBuyInfo =bCntBuyInfoService.findBCntBuyInfoByKey(contVO.getTradeContno());
				if(bCntBuyInfo!=null){
					contVO.setRemainAmt(bCntBuyInfo.getRemainAmt()==null?BigDecimal.ZERO:bCntBuyInfo.getRemainAmt());//审批中出账金额
					list.add(contVO);
				}
			}
			p.setRecords(list);
		}
		return p;
	}
	
	   /**
	    * 根据appno查询放款申请购销合同信息(申请)
	    */
		@Override
		public List<BLanLnciBuyInfo> findBLanLnciBuyInfoByAppno(String appno) throws ScubeBizException {
			List<BLanLnciBuyInfo> list =  new ArrayList<BLanLnciBuyInfo>(); 
			BLanLnciBuyInfo bLanLnciBuyInfo = new BLanLnciBuyInfo();
			BLanLnciBuyInfoExample example = new BLanLnciBuyInfoExample();
			BLanLnciBuyInfoExample.Criteria criteria = example.createCriteria();
			if(StringUtil.isStrNotEmpty(appno)){
				criteria.andAppnoEqualTo(appno);
			}
			List<com.huateng.scf.bas.lan.dao.model.BLanLnciBuyInfo> listdal=  bLanLnciBuyInfoDAO.selectByExample(example);
			for(com.huateng.scf.bas.lan.dao.model.BLanLnciBuyInfo info:listdal){
				BeanUtils.copyProperties(info, bLanLnciBuyInfo);
				list.add(bLanLnciBuyInfo);
			}
			return list;
		}
	/**
	 * 保存购销合同申请表信息
	 */
	@Transactional
	@Override
	public void saveLoanApplyBuyContnoInfo(List<ApplyBuyContVO> buyContnoList, String appno, boolean okFlag)throws ScubeBizException {
		// TODO Auto-generated method stub
		Iterator it = buyContnoList.iterator();
		//1、删除该申请编号当中的申请信息
		List<BLanLnciBuyInfo> list=this.findBLanLnciBuyInfoByAppno(appno);
		if(list!=null&&list.size()>0){
			for (BLanLnciBuyInfo info:list) {
				bLanLnciBuyInfoDAO.deleteByPrimaryKey(info.getId());
			}
		}
		

		while(it.hasNext()){
			ApplyBuyContVO contVO = (ApplyBuyContVO)it.next();
			contVO.setAppno(appno);
			BLanLnciBuyInfo buyInfo = new BLanLnciBuyInfo();
			BeanUtils.copyProperties(contVO,buyInfo);
			//2、统计累计出账金额信息
			//buyInfo.setAccuLoanAmt(buyInfo.getAccuLoanAmt().add(contVO.getLoanAmt()));
			/*Map<String,TblAppliLnciBuyInfo> map = buyInfoDAO.getApplyBuyContnoByAppno(contVO.getAppno());
			//根据获取情况对购销合同申请表进行新增、修改、删除操作；
			for (Object object : buyContnoList) {
				contVO = (ApplyBuyContVO) object;
				TblAppliLnciBuyInfo buyInfo = new TblAppliLnciBuyInfo();
				CommonFunction.copyProperties(buyInfo, contVO);
				//1. 根据购销合同号获取不为空时为修改
				if(map.get(buyInfo.getTradeContno())!=null){
					map.remove(buyInfo.getTradeContno());
				}
				//2.获取为空则为新增
				buyInfoDAO.saveApplyBuyContno(buyInfo);
				//3.将map中已经匹配的进行剔除，剩下的则为删除
			}
			Set<String> set = map.keySet();
			for (String string : set) {
				buyInfoDAO.delete(map.get(string));
			}*/
			//3、将申请表中的信息重新保存(可能数据会不全)
			//将本次出账金额存于购销合同审核中出账金额当中，用于判断购销合同是否处于业务状态以及显示
			//Modify by changhao.huang 2013-9-27
			if(okFlag){
				BigDecimal currentAmt = contVO.getLoanAmt();//本次出账金额
				BCntBuyInfo contBuyInfo =bCntBuyInfoService.findBCntBuyInfoByKey(contVO.getTradeContno());
				if(contBuyInfo!=null){
					BigDecimal remainAmtOut=contBuyInfo.getRemainAmt()==null?BigDecimal.ZERO:contBuyInfo.getRemainAmt();
					contBuyInfo.setRemainAmt(remainAmtOut.add(currentAmt));//累计审批中出账金额
					bCntBuyInfoService.updateBCntBuyInfoObject(contBuyInfo);
				}
			}
            //TODO 
			this.addBLanLnciBuyInfo(buyInfo);
	
		}
		
	}

}
