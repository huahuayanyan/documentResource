package com.huateng.scf.bas.crr.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.MastContQryVO;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfoExample;
import com.huateng.scf.bas.crr.dao.IBCrrLnAppDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLnAppRelaDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLnConDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLnConRelaDAO;
import com.huateng.scf.bas.crr.dao.ext.ExtBCrrDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrLnConRela;
import com.huateng.scf.bas.crr.dao.model.BCrrLnConRelaExample;
import com.huateng.scf.bas.crr.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.dao.model.BCrrLnApp;
import com.huateng.scf.bas.crr.dao.model.BCrrLnAppRela;
import com.huateng.scf.bas.crr.dao.model.BCrrLnAppRelaExample;
import com.huateng.scf.bas.crr.dao.model.BCrrLnConExample;
import com.huateng.scf.bas.crr.dao.model.BCrrLnConExample.Criteria;
import com.huateng.scf.bas.crr.model.BCrrLnCon;
import com.huateng.scf.bas.crr.model.BCrrLnConDetail;
import com.huateng.scf.bas.crr.service.IBCrrGntyConService;
import com.huateng.scf.bas.crr.service.IBCrrLnConService;
import com.huateng.scf.bas.crr.service.IBCrrPrdMdService;
import com.huateng.scf.bas.crr.util.BCrrModelCommonUtil;
import com.huateng.scf.bas.lan.model.vo.ContSlaveQryVO;
import com.huateng.scf.bas.mrn.vo.MastContVO;
import com.huateng.scf.bas.mrn.vo.OldCommonQueryVO;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.prd.model.BPrdInfo;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>
 * BCrrLnCon接口实现类
 * </p>
 *
 * @author mengjiajia
 * @date 2016年11月14日下午8:53:30
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午8:53:30	     新增
 *
 *            </pre>
 */
@SuppressWarnings("deprecation")
@ScubeService
@Service("BCrrLnConServiceImpl")
public class BCrrLnConServiceImpl implements IBCrrLnConService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IBCrrLnConDAO")
	IBCrrLnConDAO bcrrlncondao;

	@Resource(name = "IBCrrLnConRelaDAO")
	IBCrrLnConRelaDAO bcrrlnconreladao;

	@Resource(name = "IBCrrLnAppDAO")
	IBCrrLnAppDAO bcrrlnappdao;

	@Resource(name = "IBCrrLnAppRelaDAO")
	IBCrrLnAppRelaDAO bcrrlnappreladao;

	@Resource(name = "BSysSerialNoServiceImpl")
	IBSysSerialNoService ibSysSerialNoService;

	@Resource(name = "BCrrGntyConServiceImpl")
	IBCrrGntyConService bcrrgntyconservice;

	@Resource(name = "BPrdInfoServiceImpl")
	IBPrdInfoService bprdinfoservice;

	@Resource(name = "BCrrPrdMdServiceImpl")
	IBCrrPrdMdService bcrrprdmdservice;

	@Resource(name = "BPrdInfoDAO")
	IBPrdInfoDAO ibPrdInfoDAO;

	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bcrmbaseinfodao;
	
	@Resource(name = "ExtBCrrDAO")
	ExtBCrrDAO extbcrrdao;
	
	@Override
	@Transactional
	public void add(BCrrLnCon bCrrLnCon) {
		// 关联流水号为贷款合同合同流水号
		String relaId = bCrrLnCon.getAppId();
		// 合同流水号为贷款合同主键ID
		String appId = ibSysSerialNoService.genSerialNo("LN_CON_NO");
		bCrrLnCon.setAppStat("0");
		bCrrLnCon.setAppId(appId);
		bCrrLnCon.setRelaId(relaId);
		bCrrLnCon.setLnSum(bCrrLnCon.getLnAmt());
		bCrrLnCon.setAppDt(ScfDateUtil.formatDate(new Date()));
		// BCrrModelCommonUtil.setAddField(bCrrLnCon);
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.crr.dao.model.BCrrLnCon bCrrLnCondal = new com.huateng.scf.bas.crr.dao.model.BCrrLnCon();
		try {
			BeanUtils.copyProperties(bCrrLnCon, bCrrLnCondal);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		try {
			bcrrlncondao.insertSelective(bCrrLnCondal);
		} catch (BeansException e) {
			throw new ScubeBizException("贷款合同生成异常");
		}
		BCrrLnAppRelaExample example = new BCrrLnAppRelaExample();
		com.huateng.scf.bas.crr.dao.model.BCrrLnAppRelaExample.Criteria cri = example.createCriteria();
		cri.andSerialnoEqualTo(relaId);
		List<BCrrLnAppRela> listdal = bcrrlnappreladao.selectByExample(example);
		if (listdal.size() > 0) {
			for (BCrrLnAppRela bCrrLnAppReladal : listdal) {
				BCrrLnConRela bCrrLnConRela = new BCrrLnConRela();
				try {
					BeanUtils.copyProperties(bCrrLnAppReladal, bCrrLnConRela);
				} catch (BeansException e) {
					throw new ScubeBizException("转换异常");
				}
				bCrrLnConRela.setSerialno(appId);
				bCrrLnConRela.setRltTyp("02");
				try {
					bcrrlnconreladao.insertSelective(bCrrLnConRela);
				} catch (BeansException e) {
					throw new ScubeBizException("合同附加信息插入异常");
				}
			}
		}
	}

	@Override
	@Transactional
	public int update(BCrrLnCon bCrrLnCon) {
		BCrrModelCommonUtil.setUpdateField(bCrrLnCon);
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.crr.dao.model.BCrrLnCon bCrrLnCondal = new com.huateng.scf.bas.crr.dao.model.BCrrLnCon();
		try {
			BeanUtils.copyProperties(bCrrLnCon, bCrrLnCondal);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		int i;
		try {
			i = bcrrlncondao.updateByPrimaryKeySelective(bCrrLnCondal);
		} catch (BeansException e) {
			throw new ScubeBizException("更新异常");
		}
		return i;
	}

	@Override
	@Transactional
	public void submit(BCrrLnCon bCrrLnCon) {
		BCrrModelCommonUtil.setUpdateField(bCrrLnCon);
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.crr.dao.model.BCrrLnCon bCrrLnCondal = new com.huateng.scf.bas.crr.dao.model.BCrrLnCon();
		try {
			BeanUtils.copyProperties(bCrrLnCon, bCrrLnCondal);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		try {
			bcrrlncondao.updateByPrimaryKeySelective(bCrrLnCondal);
		} catch (BeansException e) {
			throw new ScubeBizException("确认签订异常");
		}
		// 更新担保合同状态
		BCrrLnConRelaExample example = new BCrrLnConRelaExample();
		com.huateng.scf.bas.crr.dao.model.BCrrLnConRelaExample.Criteria cri = example.createCriteria();
		cri.andSerialnoEqualTo(bCrrLnCon.getAppId());
		List<BCrrLnConRela> conrelalist = bcrrlnconreladao.selectByExample(example);
		if (conrelalist.size() > 0) {
			for (BCrrLnConRela conrela : conrelalist) {
				String rltNo = conrela.getRltNo();
				BCrrGntyCon gntycon = new BCrrGntyCon();
				gntycon.setConStat("1");
				gntycon.setConId(rltNo);
				bcrrgntyconservice.update(gntycon);
			}
		}
	}

	@Override
	@Transactional
	public int batchDelete(List<BCrrLnCon> list) {
		int rows = 0;
		if (list.size() > 0) {
			for (BCrrLnCon bCrrLnCon : list) {
				String appId = bCrrLnCon.getAppId();
				// 贷款申请appId
				String relaId = bCrrLnCon.getRelaId();
				BCrrLnApp bCrrLnApp = new BCrrLnApp();
				bCrrLnApp.setAppId(relaId);
				String appStat = WorkflowConstant.APPLI_STATUS_DTL_WRITING;
				bCrrLnApp.setAppStat(appStat);
				bCrrLnApp.setLstUpdDt(ScfDateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				try {
					bcrrlnappdao.updateByPrimaryKeySelective(bCrrLnApp);
				} catch (BeansException e) {
					throw new ScubeBizException("更新业务申请异常");
				}
				BCrrLnConRelaExample example = new BCrrLnConRelaExample();
				com.huateng.scf.bas.crr.dao.model.BCrrLnConRelaExample.Criteria cri = example.createCriteria();
				cri.andSerialnoEqualTo(appId);
				try {
					bcrrlnconreladao.deleteByExample(example);
				} catch (BeansException e) {
					throw new ScubeBizException("信贷合同关联信息删除异常");
				}
				try {
					rows += bcrrlncondao.deleteByPrimaryKey(appId);
				} catch (BeansException e) {
					throw new ScubeBizException("删除异常");
				}
			}
		}
		return rows;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page findBCrrLnConByPage(int pageNo, int pageSize, BCrrLnCon bCrrLnCon) {

		BCrrLnConExample example = new BCrrLnConExample();
		Criteria cri = example.createCriteria();

		if (bCrrLnCon != null) {
			// 业务流水号
			if (bCrrLnCon.getAppId() != null && bCrrLnCon.getAppId().length() > 0) {
				cri.andAppIdLike("%" + bCrrLnCon.getAppId() + "%");
			}
			// 客户名称
			if (bCrrLnCon.getCustNm() != null && bCrrLnCon.getCustNm().length() > 0) {
				cri.andCustNmLike("%" + bCrrLnCon.getCustNm() + "%");
			}
			// 产品名称
			if (bCrrLnCon.getPrdNm() != null && bCrrLnCon.getPrdNm().length() > 0) {
				cri.andPrdNmEqualTo(bCrrLnCon.getPrdNm());
			}
			// 合同状态
			if (bCrrLnCon.getAppStat() != null && bCrrLnCon.getAppStat().length() > 0) {
				cri.andAppStatEqualTo(bCrrLnCon.getAppStat());
			}
			if (bCrrLnCon.getLnSum() != null && !bCrrLnCon.getLnSum().equals("")) {
				cri.andLnSumGreaterThan(BigDecimal.valueOf(0));
			}
			if (bCrrLnCon.getVidNo() != null && !bCrrLnCon.getVidNo().equals("")) {
				if (bCrrLnCon.getVidNo().equals("#")) {
					cri.andVidNoIsNotNull();
				} else {
					cri.andVidNoLike(bCrrLnCon.getVidNo());
				}
			}
			// 供应链业务品种
			if(!StringUtil.isEmpty(bCrrLnCon.getVidBusiTyp()))
			{
				cri.andVidBusiTypEqualTo(bCrrLnCon.getVidBusiTyp());
			}
			// cri.andTlrNoEqualTo(ContextHolder.getUserInfo().getTlrNo());
		}
		example.setOrderByClause("LST_UPD_DT DESC");

		int total = bcrrlncondao.countByExample(example);
		Page p = new Page(pageSize, pageNo, total);

		log.info("totalPage=" + p.getTotalPage());
		log.info("totalPage=" + p.getTotalPage());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("current=" + p.getCurrent());
		log.info("current=" + p.getCurrent());

		Page result = new Page();
		result.setRecords(bcrrlncondao.selectByPage(example, p));
		List<com.huateng.scf.bas.crr.dao.model.BCrrLnCon> listdal = result.getRecords();
		List<com.huateng.scf.bas.crr.dao.model.BCrrLnCon> list = new ArrayList<com.huateng.scf.bas.crr.dao.model.BCrrLnCon>();
		if (listdal.size() > 0) {
			for (com.huateng.scf.bas.crr.dao.model.BCrrLnCon lncon : listdal) {
				String productId = lncon.getVidBusiTyp();
				String prdId = lncon.getPrdId();
				String loanWay = bcrrprdmdservice.findBCrrPrdMdByPrdId(prdId).getLoanWay();
				lncon.setLoanWay(loanWay);
				String productNm = "";
				String parentId = "";
				if (StringUtil.isStrNotEmpty(productId)) {
					BPrdInfo bPrdInfo = new BPrdInfo();
					bPrdInfo.setProductId(productId);
					BPrdInfo binfo = bprdinfoservice.findBPrdInfoByKey(bPrdInfo);
					productNm = binfo.getProductName();
					parentId = binfo.getParentId();
				}
				lncon.setVidPrdNm(productNm);
				lncon.setParentId(parentId);
				list.add(lncon);
			}
		}

		p.setRecords(list);
		log.info("p.toString()=" + p.toString());
		return p;
	}

	@Override
	public BCrrLnCon findBCrrLnConByAppId(String appId) {
		com.huateng.scf.bas.crr.dao.model.BCrrLnCon bCrrLnCondal = bcrrlncondao.selectByPrimaryKey(appId);
		String vidBusTyp = bCrrLnCondal.getVidBusiTyp();
		com.huateng.scf.bas.prd.dao.model.BPrdInfo bPrdInfo = ibPrdInfoDAO.selectByPrimaryKey(vidBusTyp);
		String bigpro = "";
		if (bPrdInfo != null) {
			bigpro = bPrdInfo.getParentId();
		}
		// VO转PO 展现层对象转换DAO层对象
		BCrrLnConDetail bCrrLnCon = new BCrrLnConDetail();
		try {
			BeanUtils.copyProperties(bCrrLnCondal, bCrrLnCon);
			bCrrLnCon.setBigProductId(bigpro);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		return bCrrLnCon;
	}

	/**
	 * @Description: 借款合同查询
	 * @author mengjiajia
	 * @Created 2012-8-3下午02:21:57
	 * @param mastContQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	@SuppressWarnings({ "rawtypes" })
	@Override
	public List getMastContExceptLCMastCont(MastContQryVO mastContQryVO) throws ScubeBizException {
		/**
		 * 信贷合同
		 */
		BCrrLnConExample example = new BCrrLnConExample();
		BCrrLnConExample.Criteria cri = example.createCriteria();
		if(!StringUtil.isEmpty(mastContQryVO.getCustcd())){//客户号
			cri.andCustIdEqualTo(mastContQryVO.getCustcd());
		}
		if (!StringUtil.isEmpty(mastContQryVO.getMastContno())) { //主合同号(ID)
			cri.andAppIdEqualTo(mastContQryVO.getMastContno());
		}
		if (!StringUtil.isEmpty(mastContQryVO.getMastContCode())) { //主合同代码
		}
		if(!StringUtil.isEmpty(mastContQryVO.getCname())){//客户名称
		}
		if(!StringUtil.isEmpty(mastContQryVO.getContType())){//合同类型
		}
		//合同状态有效
		cri.andAppStatEqualTo("1");
		
		List<com.huateng.scf.bas.crr.dao.model.BCrrLnCon> listresult = bcrrlncondao.selectByExample(example);
		List<MastContVO> list = new ArrayList<MastContVO>();
		Iterator iter = listresult.iterator();
		MastContVO vo = null;
		com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo tblCustBaseInfo = null;
		com.huateng.scf.bas.crr.dao.model.BCrrLnCon tblContBaseInfo = null;
		while(iter.hasNext()){
			vo = new MastContVO();
			tblContBaseInfo = (com.huateng.scf.bas.crr.dao.model.BCrrLnCon) iter.next();
			/**
			 * 用户信息
			 */
			BCrmBaseInfoExample crmExample = new BCrmBaseInfoExample();
			BCrmBaseInfoExample.Criteria crm = crmExample.createCriteria();
			crm.andCustcdEqualTo(tblContBaseInfo.getCustId());
			if(!StringUtil.isEmpty(mastContQryVO.getCname())){//客户名称
				crm.andCnameLike(mastContQryVO.getCname());
			}
			List<com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo> listcrm = bcrmbaseinfodao.selectByExample(crmExample);
			if(listcrm.size()>0)
			{
				tblCustBaseInfo = listcrm.get(0);
			}
			BeanUtils.copyProperties(tblContBaseInfo,vo);
			BeanUtils.copyProperties(tblCustBaseInfo,vo);
			list.add(vo);
		}
		return list;
	}
	
	/**
	 * @Description: 根据指定条件查询主合同
	 * @author xiong_xiaolong
	 * @Created 2012-11-5下午3:07:53
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public Page getMastContByPara(OldCommonQueryVO commonQueryVO) throws ScubeBizException {
		HashMap<String, Object> omap = new HashMap<String, Object>();
		if(!StringUtil.isEmpty(commonQueryVO.getCustcd_Q())){//客户号
			omap.put("custcd", commonQueryVO.getCustcd_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getMastContno_Q())) { //主合同号(ID)
			omap.put("mastContno", commonQueryVO.getMastContno_Q());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getMastContcode_Q())) { //主合同代码
			//信贷合同中无该字段
		}
		if(!StringUtil.isEmpty(commonQueryVO.getContType_Q())){
			//信贷合同中无该字段
		}
		if(!StringUtil.isEmpty(commonQueryVO.getCname_Q())){//客户名称
			omap.put("cname", commonQueryVO.getCname_Q());
		}
		//增加合同隶属机构条件限制 add by xiaolong.xiong 2012-11-05
		if(!StringUtil.isEmpty(commonQueryVO.getBrcode())){//客户名称
			omap.put("brcode", commonQueryVO.getBrcode());
			String brcode = ContextHolder.getOrgInfo().getBrNo();
			omap.put("parentBrcode", brcode);
			omap.put("affiliationType", ScfBasConstant.BCTL_AFFILIATION_BELONG);
		}
		//增加合同隶属客户经理条件限制 add by xiaolong.xiong 2012-11-05
		omap.put("tlrNo", ContextHolder.getUserInfo().getTlrNo());
		//合同状态有效
		omap.put("appStat", "1");

		Page page = new Page(10, 1, 0);
		page.setRecords(extbcrrdao.getMastContByPara(omap, page));
		page.setTotalRecord(extbcrrdao.countMastContByPara(omap));
		
		return page;
	}
	
	public Page queryBCrrLnConLst(int pageNo, int pageSize, Map<String, String> value) {
		BCrrLnConExample example = new BCrrLnConExample();
		Criteria cri = example.createCriteria();
		
		if(value!=null)
		{
			if(value.get("custcd")!=null)
			{
				cri.andCustIdEqualTo(value.get("custcd"));
			}
			//产品名称
			if(value.get("prdId")!=null)
			{
				cri.andVidBusiTypEqualTo(value.get("prdId"));
			}
			//合同状态
			if(value.get("appStat")!=null)
			{
				cri.andAppStatEqualTo(value.get("appStat"));
			}
		}
		example.setOrderByClause("LST_UPD_DT DESC");
		Page p = new Page(pageSize, pageNo, 0);
		bcrrlncondao.selectByPage(example, p);
		return p;
	}
	
	/**
	 * 质押合同下信贷合同
	 * @param contSlaveQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月10日下午4:57:05
	 */
	@Override
	public Page getContBaseInfoListBySlaveContno(ContSlaveQryVO contSlaveQryVO) throws ScubeBizException
	{
		BCrrLnConExample example = new BCrrLnConExample();
		BCrrLnConExample.Criteria cri = example.createCriteria();
		cri.andVidNoEqualTo(contSlaveQryVO.getSlaveContno());
		
		int total = bcrrlncondao.countByExample(example);
		Page page = new Page(contSlaveQryVO.getPageSize(), contSlaveQryVO.getPageIndex(), total);
		page.setRecords(bcrrlncondao.selectByPage(example, page));
		return page;
	}
}
