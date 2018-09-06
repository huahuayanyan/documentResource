package com.huateng.scf.bas.cnt.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.bcp.constant.ABcpErrorConstant;
import com.huateng.scf.adv.bcp.dao.IABcpMoreDvyChkStockDAO;
import com.huateng.scf.adv.bcp.dao.IABcpMoreDvyChkStockDtlDAO;
import com.huateng.scf.adv.bcp.dao.model.ABcpMoreDvyChkStock;
import com.huateng.scf.adv.bcp.dao.model.ABcpMoreDvyChkStockDtl;
import com.huateng.scf.adv.bcp.dao.model.CheckStockVO;
import com.huateng.scf.adv.bcp.dao.model.ThreeCheckStockDebetVO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotPartInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfoExample;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfoExample;
import com.huateng.scf.bas.cnt.model.ThreeProtocolVO;
import com.huateng.scf.bas.cnt.service.IBCntFourCheckStockService;
import com.huateng.scf.bas.common.constant.NoticeConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.lan.dao.IBLanLnciBuyBizDAO;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBuyBiz;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBuyBizExample;
import com.huateng.scf.bas.nte.constant.BNteConstant;
import com.huateng.scf.bas.nte.dao.IBNteNoticeBaseDAO;
import com.huateng.scf.bas.nte.dao.IBNteNoticeLnciDAO;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBaseExample;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeLnci;
import com.huateng.scf.bas.sys.constant.BSysConstant;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
@ScubeService
@Service("BCntFourCheckStockServiceImpl")
public class BCntFourCheckStockServiceImpl implements IBCntFourCheckStockService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
//	@Resource(name = ICheckStockService.BEAN_ID)
//	ICheckStockService checkStockService; 
	@Resource(name = "ABcpMoreDvyChkStockDAO")
	private IABcpMoreDvyChkStockDAO aBcpMoreDvyChkStockDAO;
	@Resource(name = "ABcpMoreDvyChkStockDtlDAO")
	private IABcpMoreDvyChkStockDtlDAO aBcpMoreDvyChkStockDtlDAO;
	@Resource(name = "BLnaLnciBuyBizDAO")
	IBLanLnciBuyBizDAO ibLanLnciBuyBizDAO;
	@Resource(name = "BCntMprotBaseInfoDAO")
	private IBCntMprotBaseInfoDAO bCntMprotBaseInfoDAO;
	@Resource(name = "BNteNoticeBaseDAO")
	private IBNteNoticeBaseDAO bNteNoticeBaseDAO;
	@Resource(name = "BCntMprotPartInfoDAO")
	private IBCntMprotPartInfoDAO bCntMprotPartInfoDAO;
	@Resource(name = "BNteNoticeLnciDAO")
	private IBNteNoticeLnciDAO bNteNoticeLnciDAO;
	@Resource(name = "scubeUserService")
	ScubeUserService scubeUserService;
	@Resource(name = "BSysSerialNoServiceImpl")
	private  IBSysSerialNoService bSysSerialNoService;//流水号生成服务
	@SuppressWarnings("unchecked")
	@Override
	public Page queryFourCheckStockByPage(int pageNo, int pageSize, Map<String, Object> param)
			throws ScubeBizException {
		log.info("发货对账查询");
		 //数据权限控制：1、默认查询出当前登录人机构及其以下机构信息 2、查询条件已经选了机构的,根据已选择的查询信息
		UserInfo user = ContextHolder.getUserInfo(); 
	    String brCode=user.getBrNo();
	    ArrayList<String> arrBr = new ArrayList<String>();
		if(param.get("brcode")!=null){
			arrBr.add(param.get("brcode").toString());
 		}else{
			List<BctlVO> bctList = scubeUserService.getBrListByBrNo(brCode,ScfCommonUtil.getBrManagerNo(scubeUserService));
			for(BctlVO bctlVO : bctList){
				String brNo = bctlVO.getBrNo();
				arrBr.add(brNo);
			}
		}
		Page page = new Page(pageSize, pageNo, 0);
		param.put("arrBr", arrBr);
		param.put("roleCredit", ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);
		param.put("roleCore", ScfBasConstant.PROTOCOL_PART_ROLE_CORE);
		
		aBcpMoreDvyChkStockDAO.queryCheckStock(param, page);
		List<CheckStockVO> list = page.getRecords();
		List<CheckStockVO> response = new ArrayList<CheckStockVO>();
		if(list!=null&&list.size()>0){
			Iterator<?> iter=list.iterator();
			while(iter.hasNext()){
				CheckStockVO VO= (CheckStockVO) iter.next();
				if(StringUtil.isStrNotEmpty(VO.getCheckBrcode())){
					BctlVO bctl = scubeUserService.selectBctlByBrNo(VO.getCheckBrcode(),ScfCommonUtil.getBrManagerNo(scubeUserService));
					VO.setCheckBrCodeName(bctl.getBrName());
				}
				if(StringUtil.isStrNotEmpty(VO.getTlrno())){
					UserInfo userInfo = scubeUserService.selectUserByTlrNo(VO.getTlrno(),ScfCommonUtil.getBrManagerNo(scubeUserService));
					VO.setTlrname(userInfo.getTlrName());
				}
				response.add(VO);
			}
		}
		
		page.setRecords(response);
		return page;
	}


	@Override
	public Page fourCheckStockDebetByPage(int pageNo, int pageSize, Map<String, String> param)
			throws ScubeBizException {
		log.info("发货对账管理发货情况查询");
		Page page = new Page(pageSize, pageNo, 0);
		param.put("status", NoticeConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);
		/*param.put("noticeType75", NoticeConstant.NOTICE_TYPE_75);
		param.put("noticeType78", NoticeConstant.NOTICE_TYPE_78);*/
		param.put("noticeType122", NoticeConstant.NOTICE_TYPE_122);
		param.put("state", BSysConstant.FLAG_OFF);
		param.put("isSettle", BSysConstant.FLAG_OFF);
		aBcpMoreDvyChkStockDAO.getThreeCheckStockDebetQry(param, page);
		List<ThreeCheckStockDebetVO> list = page.getRecords();
		for (int i = 0; i <list.size(); i++) {
			//统计累计发货数量 start
			//查询借据项下的发货通知押品发货信息
			String debetNo = list.get(i).getDebetNo();
			Map<String, Object> sumQuantity = getSumQuantityByNoticeType(debetNo);
			BigDecimal quantity = BigDecimal.ZERO;
			if(sumQuantity!=null&&sumQuantity.size()>0){
				Object o = sumQuantity.get("QUANTITY");
				if(o != null)
					quantity =(BigDecimal)o;
			}
			list.get(i).setTotQuantity(quantity);
		}
		return page;
	}
	
	@Override
	public int fourCheckStockNum(Map<String, String> param) throws ScubeBizException {
		return aBcpMoreDvyChkStockDAO.getThreeCheckStockDebetNum(param);
	}
	
	@Override
	public List<com.huateng.scf.adv.bcp.model.ThreeCheckStockDebetVO> fourCheckStockDebt(Map<String, String> param) throws ScubeBizException {
		// TODO Auto-generated method stub
		log.info("发货对账管理提货信息查询");
		param.put("status", NoticeConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);
		/*param.put("noticeType75", NoticeConstant.NOTICE_TYPE_75);
		param.put("noticeType78", NoticeConstant.NOTICE_TYPE_78);*/
		param.put("noticeType122", NoticeConstant.NOTICE_TYPE_122);
		param.put("state", BSysConstant.FLAG_OFF);
		param.put("isSettle", BSysConstant.FLAG_OFF);
		List<ThreeCheckStockDebetVO> list = aBcpMoreDvyChkStockDAO.getThreeCheckStockDebetQry(param);
		List<com.huateng.scf.adv.bcp.model.ThreeCheckStockDebetVO> tarList = new ArrayList<com.huateng.scf.adv.bcp.model.ThreeCheckStockDebetVO>();
		for(ThreeCheckStockDebetVO temp: list ){
			com.huateng.scf.adv.bcp.model.ThreeCheckStockDebetVO tarTemp = new com.huateng.scf.adv.bcp.model.ThreeCheckStockDebetVO() ;
			BeanUtils.copyProperties(temp, tarTemp);
			tarList.add(tarTemp);
		}
		log.info(tarList.toString());
		return  tarList;
	}


	@Override
	@Transactional
	public void fourCheckStockApply(ThreeProtocolVO threeProtocolVO,
			List<com.huateng.scf.adv.bcp.model.ThreeCheckStockDebetVO> debetList) {
    // 保存对账信息
	  String appno = this.saveFourCheckStockInfo(threeProtocolVO, debetList);
	//保存通知书对账基本信息 B_NTE_NOTICE_BASE
	  BNteNoticeBase noticeBaseInfo = this.saveFourCheckStockBaseNotice(appno,threeProtocolVO, debetList);
	//保存通知书对账借据信息
	  this.saveFourCheckStockLnciNotice(noticeBaseInfo, debetList);
		
	}
	 
	/**保存对账借据信息**/
	private void saveFourCheckStockLnciNotice(BNteNoticeBase noticeBaseInfo,
			List<com.huateng.scf.adv.bcp.model.ThreeCheckStockDebetVO> debetList) {
		for(com.huateng.scf.adv.bcp.model.ThreeCheckStockDebetVO lncivo:debetList){
			BNteNoticeLnci info = new BNteNoticeLnci();
			BeanUtils.copyProperties(lncivo, info);
			info.setAppno(noticeBaseInfo.getAppno());
			info.setCustcd(noticeBaseInfo.getCustcd());
			info.setCname(noticeBaseInfo.getCustName());
			info.setThrCd(noticeBaseInfo.getOtherCustcd());
			info.setThrName(noticeBaseInfo.getOtherCustName());
			info.setPid(noticeBaseInfo.getId());
			info.setDebetNo(lncivo.getDebetNo());
			info.setDebetId(lncivo.getDebetId());
			info.setStartDate(lncivo.getStartDate());
			info.setDeliveryValue(lncivo.getAmountOut());
			//已发货数量
			Map<String,String> sumQuantity = getSumQuantityByDebetNo(lncivo.getDebetNo());

			BigDecimal quantity = BigDecimal.ZERO;
			if(sumQuantity!=null&&sumQuantity.size()>0){
				String num = sumQuantity.get("num");
				if(null!=num){
					quantity =new BigDecimal(num);
				}
			}
			info.setDeliveryQuantity(quantity); //已发货数量
			info.setId(UUIDGeneratorUtil.generate());
			
			bNteNoticeLnciDAO.insert(info);
		}
		
	}

	/***根据购销合同编号查询相应押品的发货数量**/
	private Map<String,String> getSumQuantityByDebetNo(String debetNo) {
		Map<String,String> param = new HashMap<String,String>();
		param.put("debetNo", debetNo);
		List<Map<String,String>> list =  aBcpMoreDvyChkStockDAO.getSumQuantityByDebetNo(param);
		if(null!=list&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	     
	}
	
	/***根据购销合同编号查询相应押品的发货数量**/
	private Map<String,Object> getSumQuantityByNoticeType(String debetNo) {
		Map<String,String> param = new HashMap<String,String>();
		param.put("debetNo", debetNo);
		List<Map<String,Object>> list =  aBcpMoreDvyChkStockDAO.getSumQuantityByNoticeType(param);
		if(null!=list&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
		
	}


	/**保存通知书对账基本信息*/
	private BNteNoticeBase saveFourCheckStockBaseNotice(String appno, ThreeProtocolVO vo,
		List<com.huateng.scf.adv.bcp.model.ThreeCheckStockDebetVO> debetList) {
		// 获取当前用户 
		UserInfo user = ContextHolder.getUserInfo(); 
		String tlrNo=user.getTlrNo();
		String brCode=user.getBrNo();
		String date = ScfDateUtil.formatDate(new Date());
		//担保提货协议信息
		BCntMprotBaseInfoExample example = new BCntMprotBaseInfoExample();
		com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfoExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotEmpty(vo.getProtocolNo())) {
			criteria.andProtocolNoEqualTo(vo.getProtocolNo());
		}
		List<com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo> bcmList = bCntMprotBaseInfoDAO.selectByExample(example); 
		if(null==bcmList||bcmList.size()==0){
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ABcpErrorConstant.SCF_ADV_BCP_20000),ABcpErrorConstant.SCF_ADV_BCP_20000);
		}
		BigDecimal amount = BigDecimal.ZERO;
		if(debetList!=null && debetList.size()>0){
			@SuppressWarnings("rawtypes")
			Iterator iter = debetList.iterator();
			while(iter.hasNext()){
				com.huateng.scf.adv.bcp.model.ThreeCheckStockDebetVO lncivo = (com.huateng.scf.adv.bcp.model.ThreeCheckStockDebetVO)iter.next();
				amount = amount.add(lncivo.getLnciAmt()==null?BigDecimal.ZERO:lncivo.getLnciAmt());
			}
		}
		BNteNoticeBase noticeBaseInfo = new BNteNoticeBase();
		noticeBaseInfo.setId(UUIDGeneratorUtil.generate());
		String num = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_FHDZ_T_NOTICE_NO); 
		noticeBaseInfo.setNum(num);
		//通过协议号查询参与方
		BCntMprotPartInfoExample example1 = new BCntMprotPartInfoExample();
		com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfoExample.Criteria criteria1 = example1.createCriteria();
		if (StringUtils.isNotEmpty(vo.getProtocolNo())) {
			criteria1.andProtocolNoEqualTo(vo.getProtocolNo());
		}
		List<BCntMprotPartInfo> partList = bCntMprotPartInfoDAO.selectByExample(example1); 
		for(BCntMprotPartInfo partTemp : partList){
			if(ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT.equals(partTemp.getRole())){//授信客户
				noticeBaseInfo.setCustcd(partTemp.getCustcd());//借款人
				noticeBaseInfo.setCustName(partTemp.getCname());
			}else if(ScfBasConstant.PROTOCOL_PART_ROLE_MONI.equals(partTemp.getRole())){//监管公司
			}else if(ScfBasConstant.PROTOCOL_PART_ROLE_CORE.equals(partTemp.getRole())){//核心厂商
				noticeBaseInfo.setOtherCustcd(partTemp.getCustcd());//
				noticeBaseInfo.setOtherCustName(partTemp.getCname());
			}else if(ScfBasConstant.PROTOCOL_PART_ROLE_BACKCORE.equals(partTemp.getRole())){//回购厂商
			}
		}
		noticeBaseInfo.setAppno(appno);
		noticeBaseInfo.setNoticeType(NoticeConstant.NOTICE_TYPE_99);
		noticeBaseInfo.setCommonNum(null!=debetList?String.valueOf(debetList.size()):"0");//借据记录数
		noticeBaseInfo.setBrcode(brCode);//分支行编号
		noticeBaseInfo.setAppliDate(date);
		noticeBaseInfo.setSignDate(date);
		noticeBaseInfo.setProtocolCode(bcmList.get(0).getProtocolCode());//三方协议纸质编号
		noticeBaseInfo.setProtocolNo(bcmList.get(0).getProtocolNo());//三方协议号
		noticeBaseInfo.setStatus(NoticeConstant.NOTICE_BASE_STATUS_UNCONFIRM );
		//设置业务品种
		noticeBaseInfo.setBussType(bcmList.get(0).getProductId());
		noticeBaseInfo.setTlrn(tlrNo);
		noticeBaseInfo.setCommonAmt(amount);
		bNteNoticeBaseDAO.insert(noticeBaseInfo);
		return noticeBaseInfo;
}


	/**
	 * DESCRIPTION:担保提货保存对账信息
	 * A_BCP_MORE_DVY_CHK_STOCK
		A_BCP_MORE_DVY_CHK_STOCK_DTL
	 */
	public String saveFourCheckStockInfo(ThreeProtocolVO vo ,List<com.huateng.scf.adv.bcp.model.ThreeCheckStockDebetVO> debetList) {
		 // 获取当前用户 
		UserInfo user = ContextHolder.getUserInfo(); 
		String tlrNo=user.getTlrNo();
		String brCode=user.getBrNo();
		ABcpMoreDvyChkStock chkStock = new ABcpMoreDvyChkStock();
		ABcpMoreDvyChkStockDtl chkStockDtl = new ABcpMoreDvyChkStockDtl();
		String date = ScfDateUtil.formatDate(new Date());
		BeanUtils.copyProperties(vo, chkStock);
		String checkId = UUIDGeneratorUtil.generate();
		chkStock.setId(checkId);
		chkStock.setCheckDate(date);
		chkStock.setUpCustcd(vo.getCoreCustcd());
		//卖方发起将增加条件判断（网银端）
		chkStock.setCheckType(ScfBasConstant.CHECK_STOCK_WAY_CUST);
		String appno = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_FHDZ_T_APP_NO); 
		chkStock.setAppno(appno);
		chkStock.setStatus(ScfBasConstant.CHECK_STOCK_STATUS_CHECKING);
		chkStock.setCheckBrcode(brCode);
		chkStock.setCheckTlrno(tlrNo);
		aBcpMoreDvyChkStockDAO.insert(chkStock);
		for(com.huateng.scf.adv.bcp.model.ThreeCheckStockDebetVO temp:debetList){
			chkStockDtl.setCheckId(checkId);
			chkStockDtl.setDebetNo(temp.getDebetNo());
			//销售合同
			BLanLnciBuyBizExample example = new BLanLnciBuyBizExample();
			com.huateng.scf.bas.lan.dao.model.BLanLnciBuyBizExample.Criteria criteria = example.createCriteria();
			if (StringUtils.isNotEmpty(temp.getDebetNo())) {
				criteria.andDebetNoEqualTo(temp.getDebetNo());
			}
			List<BLanLnciBuyBiz> conList = ibLanLnciBuyBizDAO.selectByExample(example);
			if(null!=conList&&conList.size()>0){
				for(BLanLnciBuyBiz bytemp : conList){
					chkStockDtl.setTradeContno(bytemp.getTradeContno());
					String id = UUIDGeneratorUtil.generate();
					chkStockDtl.setId(id);	
					aBcpMoreDvyChkStockDtlDAO.insert(chkStockDtl);
				}
			}else{
				String id = UUIDGeneratorUtil.generate();
				chkStockDtl.setId(id);	
				aBcpMoreDvyChkStockDtlDAO.insert(chkStockDtl);
			}
		}
		return appno;
	}


	@Override
	@Transactional
	public void fourCheckStockVerify(com.huateng.scf.adv.bcp.model.CheckStockVO baseInfo) {
		 //更新对账状态
		updateFourCheckStockInfo(baseInfo);
		updaterNoticeStatus(baseInfo.getAppno(),NoticeConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);
	}

    /***更新对账状态***/
    public void updateFourCheckStockInfo(com.huateng.scf.adv.bcp.model.CheckStockVO baseInfo){
    	String date = ScfDateUtil.formatDate(new Date());
		ABcpMoreDvyChkStock chkStock = new ABcpMoreDvyChkStock();
		chkStock.setId(baseInfo.getId());
		chkStock.setStatus(ScfBasConstant.CHECK_STOCK_STATUS_FINISHED);
		chkStock.setResult(baseInfo.getResult());
		chkStock.setRemark(baseInfo.getRemark());
		chkStock.setCheckConfirmDate(date);
		chkStock.setSellerChecker(baseInfo.getSellerChecker());
		aBcpMoreDvyChkStockDAO.updateByPrimaryKeySelective(chkStock);
    }
	/***担保提货更改通知书状态公共方法***/
    public void updaterNoticeStatus(String appNo,String status){
    	String date = ScfDateUtil.formatDate(new Date());
    	BNteNoticeBaseExample example = new BNteNoticeBaseExample();
    	com.huateng.scf.bas.nte.dao.model.BNteNoticeBaseExample.Criteria criteria = example.createCriteria();
    	List<BNteNoticeBase> list = new ArrayList<BNteNoticeBase>();
    	if (StringUtils.isNotEmpty(appNo)) {
			criteria.andAppnoEqualTo(appNo);
			list = bNteNoticeBaseDAO.selectByExample(example);
		}
		if(null!=list&&list.size()>0){
			for(BNteNoticeBase baseInfo: list){
		    	if(BNteConstant.NOTICE_BASE_STATUS_CONFIRM_APPROVED.equals(status)){
		    		baseInfo.setStatus(BNteConstant.NOTICE_BASE_STATUS_CONFIRM_APPROVED);//已签发
		    		baseInfo.setSignDate(date);//签发日期
		    	}else if(BNteConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE.equals(status)){
		    		baseInfo.setStatus(BNteConstant.NOTICE_BASE_STATUS_CONFIRM_AGREE);//已回执
		    		baseInfo.setCommonDate(date);//回执日期
		    	}
		    	bNteNoticeBaseDAO.updateByPrimaryKeySelective(baseInfo);
			}
		}else{
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ABcpErrorConstant.SCF_ADV_BCP_20001),ABcpErrorConstant.SCF_ADV_BCP_20001);
		}
		
    }


	@Override
	public Map<String, Object> fourCheckStockDebtSum(Map<String, String> param) throws ScubeBizException {
		
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		BigDecimal lnciAmtSum = BigDecimal.ZERO;
		BigDecimal amountOutSum = BigDecimal.ZERO;
		BigDecimal amountInSum = BigDecimal.ZERO;
		
		Page page = this.fourCheckStockDebetByPage(1,10,param);
		if(page !=null && page.getRecords()!= null && page.getRecords().size()>0){
			List<Map<String, Object>> list = aBcpMoreDvyChkStockDAO.getCheckStockAmtByProtocol(param);
			if(!StringUtil.isEmpty(list) && list.size() > 0){
				lnciAmtSum = (BigDecimal)list.get(0).get("LNCI_AMT");
				amountOutSum =(BigDecimal)list.get(0).get("ACCU_SEND_AMT");
	//			lnciAmtSum = BigDecimal.valueOf(Double.valueOf(list.get(0).get("LNCI_AMT")));
	//			amountOutSum = BigDecimal.valueOf(Double.valueOf(list.get(0).get("ACCU_SEND_AMT")));
				amountInSum = lnciAmtSum.subtract(amountOutSum);
			}
			resultMap.put("lnciAmtSum", lnciAmtSum);
			resultMap.put("amountOutSum", amountOutSum);
			resultMap.put("amountInSum", amountInSum);
		}
		return resultMap;
	}






}
