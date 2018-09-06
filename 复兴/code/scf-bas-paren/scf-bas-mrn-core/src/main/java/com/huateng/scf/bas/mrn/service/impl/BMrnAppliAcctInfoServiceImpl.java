package com.huateng.scf.bas.mrn.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.mrn.dao.IBMrnAppliAcctInfoDAO;
import com.huateng.scf.bas.mrn.dao.ext.ExtBMrnDAO;
import com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfoExample;
import com.huateng.scf.bas.mrn.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.mrn.service.IBMrnAppliAcctInfoService;
import com.huateng.scf.bas.mrn.vo.OldCommonQueryVO;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.sys.model.BSysAcctBctl;
import com.huateng.scf.bas.sys.service.IBSysAcctBctlService;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo;
import com.huateng.scf.sto.dmp.model.SBcpAppliLowerPrice;
import com.huateng.scf.bas.crr.model.BCrrLnCon;
import com.huateng.scf.bas.crr.service.IBCrrLnConService;
import com.huateng.scf.bas.crr.util.BCrrModelCommonUtil;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.model.BLanLnciBase;
import com.huateng.scf.bas.lan.service.IBLanLnciBaseService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfoExample.Criteria;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * 
 * <p>BMrnAppliAcctInfo接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年12月13日上午9:52:00
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月13日上午9:52:00	     新增
 *
 * </pre>
 */
@SuppressWarnings("deprecation")
@ScubeService
@Service("BMrnAppliAcctInfoServiceImpl")
public class BMrnAppliAcctInfoServiceImpl implements IBMrnAppliAcctInfoService {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	//缓存保证金追加借据表信息
	private final static List<com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo> listmrn = 
			new ArrayList<com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo>();

	@Resource(name = "IBMrnAppliAcctInfoDAO")
	IBMrnAppliAcctInfoDAO bmrnappliacctinfodao;
	
	@Resource(name = "ExtBMrnDAO")
	ExtBMrnDAO extbmrndao;
	
	@Resource(name = "BLanLnciBaseServiceImpl")
	IBLanLnciBaseService blanlncibaseservice;
	
	@Resource(name = "BLanLnciBaseDAO")
	IBLanLnciBaseDAO blanlncibasedao;

	//敞口计算
	@Resource(name = "AmountServiceImpl")
	IAmountService service;
	
	//银行网点
	@Resource(name = "BSysAcctBctlServiceImpl")
	IBSysAcctBctlService ibsysacctbctlservice;
	
	@Resource(name = "BCrrLnConServiceImpl")	
	IBCrrLnConService  bcrrlnconservice;
	
	/**
	 * 最低控货价值保证金追加缓存
	 */
	@Override
	public void cacheAdd(List<BLanLnciBase> list, SBcpAppliLowerPrice lowerprice) {
		log.debug("开始缓存=============");
		if(list.size()>0)
		{
			for(BLanLnciBase bLanLnciBase:list)
			{
				com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo bMrnAppliAcctInfodal = 
						new com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo();
				try
				{
					BeanUtils.copyProperties(bLanLnciBase, bMrnAppliAcctInfodal);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("转换异常");
				}
				String id = UUIDGeneratorUtil.generate();
				bMrnAppliAcctInfodal.setId(id);
				bMrnAppliAcctInfodal.setAppno(lowerprice.getAppno());
				bMrnAppliAcctInfodal.setSlaveContno(lowerprice.getSlaveContno());
				bMrnAppliAcctInfodal.setProtocolNo(lowerprice.getProtocolNo());
				listmrn.add(bMrnAppliAcctInfodal);
			}
		}
	}
	
	/**
	 * 最低控货价值保证金追加保存
	 */
	@Override
	@Transactional
	public void save(List<BMrnAppliAcctInfo> list) {
		log.debug("保证金追加保存==========");
		if(list.size()>0)
		{
			//删除已存在保证金追加列表信息
			String appno = list.get(0).getAppno();
			BMrnAppliAcctInfoExample example = new BMrnAppliAcctInfoExample();
			Criteria cri = example.createCriteria();
			cri.andAppnoEqualTo(appno);
			bmrnappliacctinfodao.deleteByExample(example);
			for(BMrnAppliAcctInfo bMrnAppliAcctInfo:list)
			{
				//新增
				bMrnAppliAcctInfo.setBailAmount(bMrnAppliAcctInfo.getAddBailAmount());
				bMrnAppliAcctInfo.setMastContno(bMrnAppliAcctInfo.getMastContno());
				bMrnAppliAcctInfo.setCustcd(bMrnAppliAcctInfo.getCustcd());
				bMrnAppliAcctInfo.setBailType(ScfBasConstant.BAIL_TYPE_NORMAL);//保证金
				bMrnAppliAcctInfo.setInitType(ScfBasConstant.INIT_TYPE_INIT);//追加
				bMrnAppliAcctInfo.setConfirmStatus(ScfBasConstant.CONFIRM_STATUS_CONFIRMED);//已确认
				bMrnAppliAcctInfo.setProtocolNo(bMrnAppliAcctInfo.getProtocolNo());
				bMrnAppliAcctInfo.setSlaveContno(bMrnAppliAcctInfo.getSlaveContno());
				bMrnAppliAcctInfo.setAmount(bMrnAppliAcctInfo.getAddBailAmount());
				BCrrModelCommonUtil.setAddField(bMrnAppliAcctInfo);
				com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo bMrnAppliAcctInfodal = 
						new com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo();
				try
				{
					BeanUtils.copyProperties(bMrnAppliAcctInfo, bMrnAppliAcctInfodal);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("转换异常");
				}
				String newid = UUIDGeneratorUtil.generate();
				bMrnAppliAcctInfodal.setId(newid);
				try
				{
					bmrnappliacctinfodao.insertSelective(bMrnAppliAcctInfodal);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("插入异常");
				}
				//更新借据表追加保证金信息
				BLanLnciBase bLanLnciBase = new BLanLnciBase();
				bLanLnciBase.setDebetNo(bMrnAppliAcctInfo.getDebetNo());
				bLanLnciBase.setAddBailAmount(bMrnAppliAcctInfo.getAddBailAmount());
				blanlncibaseservice.updateBLanLnciBase(bLanLnciBase);
			}
		}
	}
	
	@Override
	@Transactional
	public void add(BMrnAppliAcctInfo bMrnAppliAcctInfo) {
		log.debug("保证金申请添加");
		BCrrModelCommonUtil.setAddField(bMrnAppliAcctInfo);
		if(StringUtil.isEmpty(bMrnAppliAcctInfo.getId()))
		{
			String id = UUIDGeneratorUtil.generate();
			bMrnAppliAcctInfo.setId(id);
		}
		com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo bmrappdal = 
				new com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo();
		try
		{
			BeanUtils.copyProperties(bMrnAppliAcctInfo, bmrappdal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		try
		{
			bmrnappliacctinfodao.insertSelective(bmrappdal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("插入异常");
		}
	}

	@Override
	@Transactional
	public int update(BMrnAppliAcctInfo bMrnAppliAcctInfo) {
		BCrrModelCommonUtil.setUpdateField(bMrnAppliAcctInfo);
	    com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo bmrappdal = 
				new com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo();
	    try
		{
			BeanUtils.copyProperties(bMrnAppliAcctInfo, bmrappdal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
	    int i;
		try
		{
			i = bmrnappliacctinfodao.updateByPrimaryKeySelective(bmrappdal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("插入异常");
		}
		return i;
	}

	@Override
	@Transactional
	public int delete(BMrnAppliAcctInfo bMrnAppliAcctInfo) {
		String id = bMrnAppliAcctInfo.getId();
		int i;
		try
		{
			i = bmrnappliacctinfodao.deleteByPrimaryKey(id);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("删除异常");
		}
		return i;
	}

	@Override
	@Transactional
	public int batchDelete(List<BMrnAppliAcctInfo> list) {
		int rows = 0;
		if(list.size()>0)
		{
			for(BMrnAppliAcctInfo bMrnAppliAcctInfo:list)
			{
				String mrnid = bMrnAppliAcctInfo.getId();
				com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo acctinfo = bmrnappliacctinfodao.selectByPrimaryKey(mrnid);
				if(acctinfo!=null)
				{
					rows += delete(bMrnAppliAcctInfo);
				}
				else
				{
					if(listmrn.size()>0)
					{
						for(com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo cachemrn:listmrn)
						{
							String cacheid = cachemrn.getId();
							if(mrnid.equals(cacheid))
							{
								listmrn.remove(cachemrn);
								rows ++;
								break;
							}
						}
					}
				}
			}
		}
		return rows;
	}

	/**
	 * 普通分页查询
	 * @param pageNo
	 * @param pageSize
	 * @param bMrnAppliAcctInfo
	 * @return
	 */
	@Override
	public Page findBMrnAppliAcctInfoByPageConNo(int pageNo, int pageSize, String appId) {
		BCrrLnCon bCrrLnCon = bcrrlnconservice.findBCrrLnConByAppId(appId);
		BMrnAppliAcctInfoExample example = new BMrnAppliAcctInfoExample();
		Criteria cri = example.createCriteria();
		
		if(bCrrLnCon!=null)
		{
			if(bCrrLnCon.getRelaId()!=null&&bCrrLnCon.getRelaId().length()>0)
			{
				cri.andAppnoEqualTo(bCrrLnCon.getRelaId());
			}
		}
		example.setOrderByClause("INP_DT DESC");
		
		int total = bmrnappliacctinfodao.countByExample(example);
		Page p = new Page(pageSize, pageNo, total);
		
		log.info("totalPage="+p.getTotalPage());
		log.info("totalPage="+p.getTotalPage());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("current="+p.getCurrent());
		log.info("current="+p.getCurrent());
		
		List<com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo> listdal = bmrnappliacctinfodao.selectByPage(example, p);
		List<com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo> resultlist = 
				new ArrayList<com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo>();
		for(com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo mrninfo:listdal)
		{
			if(StringUtil.isStrNotEmpty(mrninfo.getActBrCd()))
			{
				BSysAcctBctl bctl = ibsysacctbctlservice.findBSysAcctBctlByBrcode(mrninfo.getActBrCd());
				if(bctl!=null)
				{
					mrninfo.setActBrNm(bctl.getBrname());
				}
			}
			resultlist.add(mrninfo);
		}
		p.setRecords(resultlist);
		log.info("p.toString()="+p.toString());
		return p;
	}
	
	/**
	 * 票据信息保证金申请分页查询
	 * @param pageNo
	 * @param pageSize
	 * @param list
	 * @return
	 */
//	@Override
//	public Page findBMrnAppliAcctInfoByPagebCrrBillInfo(int pageNo, int pageSize, List<BCrrBillInfo> list) {
//		BMrnAppliAcctInfoExample example = new BMrnAppliAcctInfoExample();
//		Criteria cri = example.createCriteria();
//		
//		List<String> billIds = new ArrayList<String>();
//		if(list.size()>0)
//		{
//			for(BCrrBillInfo bCrrBillInfo:list)
//			{
//				String billId = bCrrBillInfo.getBillId();
//				billIds.add(billId);
//			}
//			cri.andBillIdIn(billIds);
//		}
//		else
//		{
//			cri.andBillIdIsNull();
//		}
//		example.setOrderByClause("INP_DT DESC");
//		
//		int total = bmrnappliacctinfodao.countByExample(example);
//		Page p = new Page(pageSize, pageNo, total);
//		
//		log.info("totalPage="+p.getTotalPage());
//		log.info("totalPage="+p.getTotalPage());
//		log.info("totalRecord="+p.getTotalRecord());
//		log.info("totalRecord="+p.getTotalRecord());
//		log.info("current="+p.getCurrent());
//		log.info("current="+p.getCurrent());
//		
//		p.setRecords(bmrnappliacctinfodao.selectByPage(example, p));
//		log.info("p.toString()="+p.toString());
//		return p;
//	}

	/**
	 * 发票信息保证金申请分页查询
	 * @param pageNo
	 * @param pageSize
	 * @param list
	 * @return
	 */
//	@Override
//	public Page findBMrnAppliAcctInfoByPagebCrrInvInfo(int pageNo, int pageSize, List<BCrrInvInfo> list) {
//		BMrnAppliAcctInfoExample example = new BMrnAppliAcctInfoExample();
//		Criteria cri = example.createCriteria();
//		
//		List<String> billIds = new ArrayList<String>();
//		if(list.size()>0)
//		{
//			for(BCrrInvInfo bCrrInvInfo:list)
//			{
//				String billId = bCrrInvInfo.getInvId();
//				billIds.add(billId);
//			}
//			cri.andBillIdIn(billIds);
//		}
//		else
//		{
//			cri.andBillIdIsNull();
//		}
//		example.setOrderByClause("INP_DT DESC");
//		
//		int total = bmrnappliacctinfodao.countByExample(example);
//		Page p = new Page(pageSize, pageNo, total);
//		
//		log.info("totalPage="+p.getTotalPage());
//		log.info("totalPage="+p.getTotalPage());
//		log.info("totalRecord="+p.getTotalRecord());
//		log.info("totalRecord="+p.getTotalRecord());
//		log.info("current="+p.getCurrent());
//		log.info("current="+p.getCurrent());
//		
//		p.setRecords(bmrnappliacctinfodao.selectByPage(example, p));
//		log.info("p.toString()="+p.toString());
//		return p;
//	}
	
//	@Override
//	public List<BMrnAppliAcctInfo> findBMrnAppliAcctInfoByBillId(String extId) {
//		List<com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo> listdal = bmrnappliacctinfodao.selectByBillId(extId);
//		List<BMrnAppliAcctInfo> list = new ArrayList<BMrnAppliAcctInfo>();
//		if(listdal.size()>0)
//		{
//			for(com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo bmrnappdal : listdal)
//			{
//				BMrnAppliAcctInfo bmrnapp = new BMrnAppliAcctInfo();
//				try
//				{
//					BeanUtils.copyProperties(bmrnappdal, bmrnapp);
//					list.add(bmrnapp);
//				}
//				catch(BeansException e)
//				{
//					throw new ScubeBizException("转换异常");
//				}
//			}
//		}
//		return list;
//	}

	/**
	 * 普通分页查询
	 * @param pageNo
	 * @param pageSize
	 * @param bMrnAppliAcctInfo
	 * @return
	 */
	@Override
	public Page findBMrnAppliAcctInfoByPage(int pageNo, int pageSize, BMrnAppliAcctInfo bMrnAppliAcctInfo) {
//		String appNo = bMrnAppliAcctInfo.getAppno();
//		BCrrDuebillApp bCrrDuebillApp = ibCrrDuebillAppDAO.selectByPrimaryKey(appNo);
//		String appId = "";
//		if(bCrrDuebillApp != null){
//			appId = bCrrDuebillApp.getAppId();
//		}
//		
//		BCrrLnCon bCrrLnCon = bcrrlnconservice.findBCrrLnConByAppId(appId);
		BMrnAppliAcctInfoExample example = new BMrnAppliAcctInfoExample();
		Criteria cri = example.createCriteria();
		
//		if(bCrrLnCon!=null)
//		{
//			if(bCrrLnCon.getRelaId()!=null&&bCrrLnCon.getRelaId().length()>0)
//			{
//				cri.andAppnoEqualTo(bCrrLnCon.getRelaId());
//			}
//		}
		if(bMrnAppliAcctInfo!=null)
		{
			if(bMrnAppliAcctInfo.getAppno()!=null&&bMrnAppliAcctInfo.getAppno().length()>0)
			{
				cri.andAppnoEqualTo(bMrnAppliAcctInfo.getAppno());
			}
		}
		example.setOrderByClause("INP_DT DESC");
		
		int total = bmrnappliacctinfodao.countByExample(example);
		Page p = new Page(pageSize, pageNo, total);
		
		log.info("totalPage="+p.getTotalPage());
		log.info("totalPage="+p.getTotalPage());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("current="+p.getCurrent());
		log.info("current="+p.getCurrent());
		
		List<com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo> listdal = bmrnappliacctinfodao.selectByPage(example, p);
		List<com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo> resultlist = 
				new ArrayList<com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo>();
		for(com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo mrninfo:listdal)
		{
			if(StringUtil.isStrNotEmpty(mrninfo.getActBrCd()))
			{
				BSysAcctBctl bctl = ibsysacctbctlservice.findBSysAcctBctlByBrcode(mrninfo.getActBrCd());
				if(bctl!=null)
				{
					mrninfo.setActBrNm(bctl.getBrname());
				}
			}
			resultlist.add(mrninfo);
		}
		p.setRecords(resultlist);
		log.info("p.toString()="+p.toString());
		return p;
	}
	
	/***
	 * 根据申请编号查询冻结保证金申请信息
	 */
	public List<BMrnAppliAcctInfo> findBMrnAppliAcctInfoByAppno(String appno) {
		List<com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo> listdal = bmrnappliacctinfodao.selectByAppno(appno);
		List<BMrnAppliAcctInfo> list = new ArrayList<BMrnAppliAcctInfo>();
		if(listdal.size()>0)
		{
			for(com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo bmrnappdal : listdal)
			{
				BMrnAppliAcctInfo bmrnapp = new BMrnAppliAcctInfo();
				try
				{
					BeanUtils.copyProperties(bmrnappdal, bmrnapp);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("转换异常");
				}
				if(StringUtil.isStrNotEmpty(bmrnapp.getActBrCd()))
				{
					BSysAcctBctl bctl = ibsysacctbctlservice.findBSysAcctBctlByBrcode(bmrnapp.getActBrCd());
					if(bctl!=null)
					{
						bmrnapp.setActBrNm(bctl.getBrname());
					}
				}
				list.add(bmrnapp);
			}
		}
		return list;
	}
	/**
	 * 最低控货价值保证金追加列表
	 * @param pageNo
	 * @param pageSize
	 * @param bMrnAppliAcctInfo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page findBMrnAppliAcctInfoByPageAndSlaveContno(int pageNo, int pageSize, BMrnAppliAcctInfo bMrnAppliAcctInfo, String cache) {
		if(cache.equals("0")||cache=="0")
		{
			listmrn.clear();
		}
		
		HashMap<String, String> omap = new HashMap<String, String>();
		if(bMrnAppliAcctInfo!=null)
		{
			if(bMrnAppliAcctInfo.getAppno()!=null&&bMrnAppliAcctInfo.getAppno().length()>0)
			{
				omap.put("appno", bMrnAppliAcctInfo.getAppno());
			}
			if(bMrnAppliAcctInfo.getSlaveContno()!=null&&bMrnAppliAcctInfo.getSlaveContno().length()>0)
			{
				omap.put("slaveContno", bMrnAppliAcctInfo.getSlaveContno());
			}
		}
		
		int total = extbmrndao.countMrnAppli(omap)+listmrn.size();
		Page p = new Page(pageSize, pageNo, total);
		
		log.info("totalPage="+p.getTotalPage());
		log.info("totalPage="+p.getTotalPage());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("current="+p.getCurrent());
		log.info("current="+p.getCurrent());
		
		Page result = new Page();
		result.setRecords(extbmrndao.queryMrnAppli(omap, p));
		List<com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo> listdal = result.getRecords();
		if(listmrn.size()>0)
		{
			listdal.addAll(listmrn);
		}
		
		//计算敞口信息
		List<com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo> list = 
				new ArrayList<com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo>();
		for(com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo actinfo:listdal)
		{
			String debetNo = actinfo.getDebetNo();
			com.huateng.scf.bas.lan.dao.model.BLanLnciBase tblLnciBaseInfo = blanlncibasedao.selectByPrimaryKey(debetNo);
			BLanLnciBase bLanLnciBase = new BLanLnciBase();
			try
			{
				BeanUtils.copyProperties(tblLnciBaseInfo, bLanLnciBase);
			}
			catch(BeansException e)
			{
				throw new ScubeBizException("转换异常");
			}
			actinfo.setRiskAmt(service.getLnciRiskAmt(bLanLnciBase));  //敞口余额
			//应收欠息
			BigDecimal receivableInt=tblLnciBaseInfo.getReceivableInt()==null?BigDecimal.ZERO:tblLnciBaseInfo.getReceivableInt();
			BigDecimal receivablePunishInt=tblLnciBaseInfo.getReceivablePunishInt()==null?BigDecimal.ZERO:tblLnciBaseInfo.getReceivablePunishInt();
			//催收欠息
			BigDecimal collectionInt=tblLnciBaseInfo.getCollectionInt()==null?BigDecimal.ZERO:tblLnciBaseInfo.getCollectionInt();
			BigDecimal collectionPunishInt=tblLnciBaseInfo.getCollectionPunishInt()==null?BigDecimal.ZERO:tblLnciBaseInfo.getCollectionPunishInt();
			BigDecimal compoundInt=tblLnciBaseInfo.getCompoundInt()==null?BigDecimal.ZERO:tblLnciBaseInfo.getCompoundInt();
			//表内欠息
			BigDecimal tabIntAmt=receivableInt.add(receivablePunishInt);
			//表外欠息
			BigDecimal tabOutAmt=collectionInt.add(collectionPunishInt).add(compoundInt);
			actinfo.setReceivableInt(tabIntAmt.add(tabOutAmt));
			
			list.add(actinfo);
		}
		
		p.setRecords(list);
		log.info("p.toString()="+p.toString());
		return p;
	}

	/**
	 * 通过APPNO清空保证金表对应数据
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void clearTblAppliCustAccountInfo(String appno) throws ScubeBizException {
		List list = this.findBMrnAppliAcctInfoByAppno(appno);
		if(list!=null && list.size()>0){
			Iterator iter = list.iterator();
			while(iter.hasNext()){
				BMrnAppliAcctInfo applyVO = (BMrnAppliAcctInfo)iter.next();
				bmrnappliacctinfodao.deleteByPrimaryKey(applyVO.getId());
			}
		}
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public BMrnAppliAcctInfo getTblAliCustAccInfoByAppnoAndDebetNo(String appno,String debetNo) throws ScubeBizException{
		BMrnAppliAcctInfoExample example = new BMrnAppliAcctInfoExample();
		BMrnAppliAcctInfoExample.Criteria cri = example.createCriteria();
		cri.andAppnoEqualTo(appno.trim());
		cri.andDebetNoEqualTo(debetNo.trim());
		example.setOrderByClause("LST_UPD_DT desc");
		List list = bmrnappliacctinfodao.selectByExample(example);
		BMrnAppliAcctInfo tblAppliCustAccountInfo = new BMrnAppliAcctInfo();
		if(list!=null && list.size()>0){
			tblAppliCustAccountInfo = (BMrnAppliAcctInfo)list.get(0);
		}
		return tblAppliCustAccountInfo;
	}
	
	/**
	 *
	 * @Description: 根据协议好删除保证金申请信息
	 * @author mengjiajia
	 * @Created 2012-11-13上午10:50:22
	 * @param appno
	 * @throws ScubeBizException
	 */
	@Override
	public void deleteByAppno(String appno) throws ScubeBizException{
		List<BMrnAppliAcctInfo> list = this.findBMrnAppliAcctInfoByAppno(appno);
		for(int i=0;i<list.size();i++){
			BMrnAppliAcctInfo bean = (BMrnAppliAcctInfo)list.get(i);
			delete(bean);
		}
	}
	
	@Override
	public List<BMrnAppliAcctInfo> findByProperty(String appno) {
		BMrnAppliAcctInfoExample example = new BMrnAppliAcctInfoExample();
		BMrnAppliAcctInfoExample.Criteria cri = example.createCriteria();
		cri.andAppnoEqualTo(appno);
		List<com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo> listdal = bmrnappliacctinfodao.selectByExample(example);
		List<BMrnAppliAcctInfo> list = new ArrayList<BMrnAppliAcctInfo>();
		if(listdal.size()>0)
		{
			for(com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo appliAcctInfo:listdal)
			{
				BMrnAppliAcctInfo bMrnAppliAcctInfo = new BMrnAppliAcctInfo();
				try
				{
					BeanUtils.copyProperties(appliAcctInfo, bMrnAppliAcctInfo);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("转换异常");
				}
				list.add(bMrnAppliAcctInfo);
			}
		}
		return list;
	}
	
	/**
	 *
	 * @Description: 保证金转入信息列表查询
	 * @author wenkui.xu
	 * @Created 2012-11-9下午02:39:33
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public Page getBailTransferQuery(OldCommonQueryVO commonQueryVO) throws ScubeBizException
	{
		HashMap<String, Object> omap = new HashMap<String, Object>();
		if(!StringUtil.isEmpty(commonQueryVO.getApplyType_Q())){
			omap.put("applyType", commonQueryVO.getApplyType_Q());//申请类型
		}
		if(!StringUtil.isEmpty(commonQueryVO.getCustcd_Q())){
			omap.put("custcdBuyer", commonQueryVO.getCustcd_Q());//客户号
		}
		if(!StringUtil.isEmpty(commonQueryVO.getCname_Q())){
			omap.put("cname", commonQueryVO.getCname_Q());//客户名称
		}
		if(!StringUtil.isEmpty(commonQueryVO.getMastContno_Q())){
			omap.put("mastContno", commonQueryVO.getMastContno_Q());//主合同/监管协议
		}
		if(!StringUtil.isEmpty(commonQueryVO.getSlaveContno_Q())){
			omap.put("slaveContno", commonQueryVO.getSlaveContno_Q());//抵质押合同号
		}
		if(!StringUtil.isEmpty(commonQueryVO.getBailType_Q())){
			omap.put("bailType", commonQueryVO.getBailType_Q());//现金等价物类型，加以区别保证金和最高额保证金申请类型
		}
		if(!StringUtil.isEmpty(commonQueryVO.getType_Q())){
			omap.put("initType", commonQueryVO.getType_Q());//质押类型，加以区别初始、追加和最高额保证金
		}
		if (!StringUtil.isEmpty(commonQueryVO.getBrcode_Q())) {// 机构号
			omap.put("parentBrcode", ContextHolder.getOrgInfo().getBrNo());
			//根据业务设定，该值为1时：取得所有下属支行列表；为2时：得到所有下属机构列表(包含自己)
			omap.put("affiliationType", ScfBasConstant.BCTL_AFFILIATION_BELONG);
		}
		Page page = new Page();
		page.setPageNo(commonQueryVO.getPageIndex());
		page.setPageSize(commonQueryVO.getPageSize());
		List<RBcpAppliBussInfo> list = extbmrndao.getBailTransferQuery(omap, page);
		page.setRecords(list);
		page.setTotalRecord(extbmrndao.countBailTransferQuery(omap));
		return page;
	}
	
	/**
	 * @Description: 批量保存客户帐户信息临时表
	 * @author mengjiajia
	 * @Created 2012-11-13上午11:18:52
	 * @param list
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void saveAll(List list){
		for(int i = 0 ; i<list.size() ; i++){
			BMrnAppliAcctInfo t = new BMrnAppliAcctInfo();
			t = (BMrnAppliAcctInfo) list.get(i);
			String id = t.getId();
			if(StringUtil.isEmpty(id)){
				id = UUIDGeneratorUtil.generate();
				t.setId(id);
			}
			com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo record = 
					new com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo();
			BeanUtils.copyProperties(t, record);
			bmrnappliacctinfodao.insertSelective(record);
		}
	}

	/**
	 * DESCRIPTION:获取解押中的现金等价物信息
	 *
	 * @author mengjiajia
	 * @date 2012-6-16 getBillCustAccountInfoApprove 方法
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public Page getBillCustAccountInfoApprove(OldCommonQueryVO commonQueryVO) throws ScubeBizException 
	{
		BMrnAppliAcctInfoExample example = new BMrnAppliAcctInfoExample();
		BMrnAppliAcctInfoExample.Criteria cri = example.createCriteria();

		// 子合同号
		if (!StringUtil.isEmpty(commonQueryVO.getMastContno_Q())) {
			cri.andMastContnoEqualTo(commonQueryVO.getMastContno_Q());
		}

		// 客户号
		if (!StringUtil.isEmpty(commonQueryVO.getCustcd_Q())) {
			cri.andCustcdEqualTo(commonQueryVO.getCustcd_Q());
		}
		cri.andAppnoEqualTo(commonQueryVO.getAppno_Q());
		cri.andConfirmStatusEqualTo("04");
		cri.andBailTypeNotEqualTo("03");
		example.setOrderByClause("ID desc");

		Page page = new Page();
		page.setRecords(bmrnappliacctinfodao.selectByExample(example));

		return page;
	}
	
	/**
	 * DESCRIPTION:批量更新
	 * @author mengjiajia
	 * @date 2012-6-16
	 * updateAll 方法
	 * @param list
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void updateAll(List list){
		for(int i = 0 ; i<list.size() ; i++){
			com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo t = 
					new com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo();
			t = (com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo) list.get(i);
			BMrnAppliAcctInfo bMrnAppliAcctInfo = new BMrnAppliAcctInfo();
			BeanUtils.copyProperties(t, bMrnAppliAcctInfo);
			this.update(bMrnAppliAcctInfo);
		}
	}
	
	/**
	 * 根据申请编号查询冻结保证金信息
	 * @param appno
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月27日下午8:18:58
	 */
	@Override
	public Page getAddBailAmountListByAppno(String appno, int pageNo,int pageSize) throws ScubeBizException
	{
		HashMap<String, Object> omap = new HashMap<String, Object>();
		omap.put("appno", appno);
		
		int total = extbmrndao.countAddBailAmountListByAppno(omap);
		Page page = new Page(pageSize, pageNo, total);
		page.setRecords(extbmrndao.getAddBailAmountListByAppno(omap, page));
		return page;
	}

}
