package com.huateng.scf.bas.lan.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.UserInfo;
import com.huateng.flowsharp.api.IProcessService;
import com.huateng.flowsharp.api.ITaskService;
import com.huateng.flowsharp.entity.FlowsharpException;
import com.huateng.scf.bas.cnt.dao.IBCntBuyInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntBuyInfo;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crr.dao.IBCrrLnConDAO;
import com.huateng.scf.bas.crr.dao.IBCrrPrdMdDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrLnCon;
import com.huateng.scf.bas.crr.dao.model.BCrrPrdMd;
import com.huateng.scf.bas.crr.model.BCrrDueBillDetail;
import com.huateng.scf.bas.lan.constant.BLanErrorConstant;
import com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.IBLanLnciBuyBizDAO;
import com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.model.BLanLnciBuyBiz;
import com.huateng.scf.bas.lan.service.IBLanCommonService;
import com.huateng.scf.bas.lan.service.IBLanRepayYcSubmitService;
import com.huateng.scf.bas.pbc.constant.BPbcErrorConstant;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author liph
 * @date 2016年12月10日下午1:39:20
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * liph		2016年12月10日下午1:39:20	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("BLanRepayYcSubmitServiceImpl")
public class BLanRepayYcSubmitServiceImpl implements IBLanRepayYcSubmitService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "IBCrrLnConDAO")
	IBCrrLnConDAO ibCrrLnConDAO;
	@Resource(name = "BPrdInfoDAO")
	IBPrdInfoDAO ibPrdInfoDAO;
	@Resource(name = "BLanAppliLnciBaseDAO")
	IBLanAppliLnciBaseDAO ibLanAppliLnciBaseDAO;
	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO ibPbcAppliBaseInfoDAO;
	@Resource(name = "BLanLnciBaseDAO")
	IBLanLnciBaseDAO ibLanLnciBaseDAO;
	@Resource(name = "IBCrrPrdMdDAO")
	IBCrrPrdMdDAO bcrrprdmddao;
	@Resource(name = "BLanCommonServiceImpl")
	IBLanCommonService ibLanCommonService;
	@Resource(name = "BCntBuyInfoDAO")
	IBCntBuyInfoDAO ibCntBuyInfoDAO;
	@Resource(name = "BLnaLnciBuyBizDAO")
	IBLanLnciBuyBizDAO ibLanLnciBuyBizDAO;
	@Autowired
	private ITaskService taskService;
	@Autowired
	private IProcessService processService;
	
	/**
	 *@author liph
	 * 银承提交业务逻辑处理 
	 * @throws FlowsharpException 
	 */
	@Override
	@Transactional
	public void ycSubmit(BCrrDueBillDetail bCrrDueBillDetail, List<BLanLnciBuyBiz> list) throws FlowsharpException {
		String appno=bCrrDueBillDetail.getId();
		BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(bCrrDueBillDetail.getAppId());
		if(bCrrLnCon == null){
			log.info("未关联到信贷合同");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20018),BLanErrorConstant.SCF_BAS_LAN_20018);
		}
		BCrrPrdMd bCrrPrdMd = bcrrprdmddao.selectByPrimaryKey(bCrrLnCon.getPrdId());
		if(bCrrPrdMd == null){
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20002),BLanErrorConstant.SCF_BAS_LAN_20002);
		}
		String loanWay = bCrrPrdMd.getLoanWay();
		String businessnoType = "";
		String workApplyType  = "";
		if(ScfBasConstant.ACCOUNT_WAY_BILL.equals(loanWay)){//银承
			businessnoType = WorkflowConstant.APPLI_TYPE_THREE_BILLPPLI;
			workApplyType = WorkflowConstant.PROCNAME_THREE_BILL_APPLY;
		}
		BPbcAppliBaseInfo bPbcAppliBaseInfo = ibPbcAppliBaseInfoDAO.selectByPrimaryKey(appno);
		BLanAppliLnciBase bLanAppliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(appno);
		bPbcAppliBaseInfo.setAmt(bLanAppliLnciBase.getLnciAmt()==null?BigDecimal.ZERO:bLanAppliLnciBase.getLnciAmt());
		bPbcAppliBaseInfo.setBusinessno(bCrrLnCon.getVidNo());
		bPbcAppliBaseInfo.setStartBrcode(bCrrDueBillDetail.getBrCd());
		bPbcAppliBaseInfo.setAppBrcode(bCrrDueBillDetail.getBrCd());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String date = sdf.format(new Date());
		bPbcAppliBaseInfo.setAppDate(date);
		bPbcAppliBaseInfo.setAppTlrcd(bCrrDueBillDetail.getTlrNo());
		bPbcAppliBaseInfo.setStartTime(new Date());
		bPbcAppliBaseInfo.setStratDate(date);
		bPbcAppliBaseInfo.setStartTlrcd(bCrrDueBillDetail.getTlrNo());
		bPbcAppliBaseInfo.setProtocolNo(bCrrLnCon.getVidNo());
		try {
			ibPbcAppliBaseInfoDAO.updateByPrimaryKey(bPbcAppliBaseInfo);
		} catch (Exception e) {
			log.info("业务申请表更新异常");
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_10002),BPbcErrorConstant.SCF_BAS_PBC_10002);			
		}
		
		//金额校验
		BigDecimal appInitCashEqtAmt = bCrrDueBillDetail.getCsxjdjwbl();
		try {
			ibLanCommonService.checkLoanApplyInfo(appno, appInitCashEqtAmt);
		} catch (Exception e) {
			log.info("金额校验异常");
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20016),BLanErrorConstant.SCF_BAS_LAN_20016);
		}
		//金额校验--购销合同数据
		for(int i=0;i<list.size();i++){
			BLanLnciBuyBiz bLanLnciBuyBiz = list.get(i);
			BigDecimal totAmt=bLanLnciBuyBiz.getAccuLoanAmt()==null?BigDecimal.ZERO:bLanLnciBuyBiz.getAccuLoanAmt();
			BigDecimal currOutAmt=bLanLnciBuyBiz.getLoanAmt()==null?BigDecimal.ZERO:bLanLnciBuyBiz.getLoanAmt();
			BigDecimal amt=bLanLnciBuyBiz.getContAmt()==null?BigDecimal.ZERO:bLanLnciBuyBiz.getContAmt();
			BCntBuyInfo buyInfo = ibCntBuyInfoDAO.selectByPrimaryKey(bLanLnciBuyBiz.getTradeContno());
			if(buyInfo != null){
				BigDecimal remainAmt=buyInfo.getRemainAmt()==null?BigDecimal.ZERO:buyInfo.getRemainAmt();//审批中出账金额
				BigDecimal allLoanAmt=totAmt.add(currOutAmt).add(remainAmt);
				if(allLoanAmt.compareTo(amt)>0){
					log.info("累计合同金额，不能超过购销合同总额");
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20017),BLanErrorConstant.SCF_BAS_LAN_20017);
				}
			}else{
				log.info("购销合同不存在");
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20002),BLanErrorConstant.SCF_BAS_LAN_20002);
			}
		}
		//保存借据申请表的信息
		//1、出账基本信息保存
		try {
			this.lnciLoanAppSaveOrUpdate(bCrrDueBillDetail);
		} catch (Exception e) {
			log.info("借据申请表保存异常");
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10001),BLanErrorConstant.SCF_BAS_LAN_10001);
		}
		//2、购销合同基本信息保存
		try {
			this.saveLoanBasicInfo(list,bCrrDueBillDetail,false);
		} catch (Exception e) {
			log.info("更新购销合同异常");
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10011),BLanErrorConstant.SCF_BAS_LAN_10011);			
		}
		
		//----------------------------间接额度处理------------------------
		
		//节点跳转转移
		String processId= bPbcAppliBaseInfo.getPiid();
		UserInfo user = ContextHolder.getUserInfo();
		String userId = user.getTlrNo();
		String taskId = WorkflowConstant.WORKFLOW_BCRRDUEBILL_ADD;
		taskService.takeTask(taskId, processId, userId);
		
		String comment = "申请提交";
		if(!StringUtil.isEmpty(bCrrDueBillDetail.getTaskComment()))
		{
			comment = bCrrDueBillDetail.getTaskComment();
		}
		taskService.completeTask(taskId, processId, userId, comment);
		// 节点转移
		processService.signal(processId, WorkflowConstant.WORKFLOW_BCRRDUEBILL_CONFIRM);
		
		bPbcAppliBaseInfo.setApprover(userId); // 当前已审批人员
		bPbcAppliBaseInfo.setApproveBrcode(user.getBrNo()); // 当前已审批机构
		bPbcAppliBaseInfo.setApproveDate(ScfDateUtil.getStringDate(new Date())); // 当前已审批日期
		bPbcAppliBaseInfo.setApproveTime(new Date()); // 当前已审批时间
		bPbcAppliBaseInfo.setAppliStatusDtl(WorkflowConstant.APPLI_STATUS_DTL_WAITCMS);
		bPbcAppliBaseInfo.setAppliStatus(WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE);
		/*com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo appliBaseInfo = new com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo();
		BeanUtils.copyProperties(bPbcAppliBaseInfo, appliBaseInfo);*/
		ibPbcAppliBaseInfoDAO.updateByPrimaryKey(bPbcAppliBaseInfo);
	}
	
	/**
	 * 借据申请信息保存
	 */
	public void lnciLoanAppSaveOrUpdate(BCrrDueBillDetail bCrrDueBillDetail){
		BLanAppliLnciBase bLanAppliLnciBase = null;
		String appno = bCrrDueBillDetail.getId();
		bLanAppliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(appno);
		int a = 0;
		if(bLanAppliLnciBase == null){
			a = a + 1;
		}else{
			a = a + 2;
		}
		bLanAppliLnciBase.setInitCashEqtAmt(bCrrDueBillDetail.getCsxjdjwbl());
		bLanAppliLnciBase.setProtocolNo(bCrrDueBillDetail.getVidNo());
		bLanAppliLnciBase.setMgrno(bCrrDueBillDetail.getTlrNo());
		BigDecimal bigDecimal = bCrrDueBillDetail.getDrawbackTerm()==null?BigDecimal.ZERO:bCrrDueBillDetail.getDrawbackTerm();
		bLanAppliLnciBase.setDrawbackTerm(bigDecimal);
		bLanAppliLnciBase.setSlaveLimit(bCrrDueBillDetail.getDrawbackTerm()==null?"0":bCrrDueBillDetail.getDrawbackTerm().toString());
		if(StringUtil.isEmpty(bLanAppliLnciBase.getId())){
			bLanAppliLnciBase.setId(UUIDGeneratorUtil.generate());
		}
		if(StringUtil.isEmpty(bLanAppliLnciBase.getDebetNo())){
			bLanAppliLnciBase.setDebetNo(UUIDGeneratorUtil.generate());
		}
		if(a == 1){
			ibLanAppliLnciBaseDAO.insertSelective(bLanAppliLnciBase);
		}else{
			ibLanAppliLnciBaseDAO.updateByPrimaryKey(bLanAppliLnciBase);
		}
	}
	/**
	 * 更新购销合同信息
	 */
	/**
	 * 更新购销合同流水信息
	 */
	public void saveLoanBasicInfo(List tradeContList,BCrrDueBillDetail bCrrDueBillDetail,boolean okFlag){
		String appno = bCrrDueBillDetail.getId();
		BLanAppliLnciBase bLanAppliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(appno);
		List<com.huateng.scf.bas.lan.dao.model.BLanLnciBuyBiz> list = ibLanLnciBuyBizDAO.selectByAppno(appno);
		for(int i=0;i<list.size();i++){
			com.huateng.scf.bas.lan.dao.model.BLanLnciBuyBiz bLanLnciBuyBiz = list.get(i);
			ibLanLnciBuyBizDAO.deleteByPrimaryKey(bLanLnciBuyBiz.getId());
		}
		com.huateng.scf.bas.lan.dao.model.BLanLnciBuyBiz bean = null;
		for(int m=0;m<tradeContList.size();m++){
			BLanLnciBuyBiz vo = (BLanLnciBuyBiz) tradeContList.get(m);
			BigDecimal totAmt=vo.getAccuLoanAmt()==null?BigDecimal.ZERO:vo.getAccuLoanAmt();
			BigDecimal currOutAmt=vo.getLoanAmt()==null?BigDecimal.ZERO:vo.getLoanAmt();
			bean = new com.huateng.scf.bas.lan.dao.model.BLanLnciBuyBiz();
			bean.setId(UUIDGeneratorUtil.generate());
			bean.setTradeContcode(vo.getTradeContcode());//购销合同号
			bean.setDebetNo(bLanAppliLnciBase.getDebetNo());//借据表信息
			bean.setTradeContno(vo.getTradeContno());//目前存的/购销合同号
			bean.setStartDate(vo.getStartDate());//签订日期
			bean.setEndDate(vo.getEndDate());//到期日
			bean.setContAmt(vo.getContAmt());//合同金额
			bean.setAccuLoanAmt(totAmt);//累计出账金额
			bean.setLoanAmt(currOutAmt);//本次出账金额
			bean.setAppno(appno);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String date = sdf.format(new Date());
			bean.setInsertDate(date);
			ibLanLnciBuyBizDAO.insertSelective(bean);
		}
	}
}
