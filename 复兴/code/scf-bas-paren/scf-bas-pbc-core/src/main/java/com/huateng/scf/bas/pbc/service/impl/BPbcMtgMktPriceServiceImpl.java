package com.huateng.scf.bas.pbc.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.DataItemsDO;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgClassDAO;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgMktPriceDAO;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgMktPriceHisDAO;
import com.huateng.scf.bas.pbc.dao.ext.ExtIBPbcMtgMktPriceDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgClass;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgClassExample;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgMktPrice;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgMktPriceExample;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgMktPriceExample.Criteria;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgMktPriceHis;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgMktPriceHisExample;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgMktPriceVO;
import com.huateng.scf.bas.pbc.model.BPbcMtgMktPriceHisVO;
import com.huateng.scf.bas.pbc.model.MortMaketPriceQryVO;
import com.huateng.scf.bas.pbc.service.IBPbcMtgClassService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgMktPriceService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("BPbcMtgMktPriceServiceImpl")
public class BPbcMtgMktPriceServiceImpl implements IBPbcMtgMktPriceService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "BPbcMtgClassServiceImpl")
	IBPbcMtgClassService bPbcMtgClassService;

	@Resource(name = "IBPbcMtgMktPriceDAO")
	private IBPbcMtgMktPriceDAO bPbcMtgMktPriceDAO;

	@Resource(name = "ExtBPbcMtgMktPrice")
	private ExtIBPbcMtgMktPriceDAO extIBPbcMtgMktPriceDAO;

	@Resource(name = "IBPbcMtgMktPriceHisDAO")
	private IBPbcMtgMktPriceHisDAO bPbcMtgMktPriceHisDAO;

	@Resource(name = "BPbcMtgClassDAO")
	private IBPbcMtgClassDAO bPbcMtgClassDAO;

	@Autowired
	ScubeUserService scubeUserService;

	@Resource(name = "BSysSerialNoServiceImpl")
	IBSysSerialNoService bSysSerialNoService;// 流水号生成服务

	@Override
	public Page getTblMortMarPriPage(int pageNo, int pageSize, MortMaketPriceQryVO commonQueryVO) {
		Page page = new Page(pageSize, pageNo, 0);
		BPbcMtgMktPriceExample example = new BPbcMtgMktPriceExample();
		Criteria criteria = example.createCriteria();
		criteria.andMarketPriceSrcEqualTo(ScfBasConstant.MARKETPRICESRC_HAND);
		List<BPbcMtgMktPrice> list = null;
		int totalRecord = 0;
		if (StringUtils.isNotEmpty(commonQueryVO.getMortgageLevelOne_Q())) {
			criteria.andMortgageLevelOneEqualTo(commonQueryVO.getMortgageLevelOne_Q());
		}

		if (StringUtils.isNotEmpty(commonQueryVO.getMortgageLevelTwo_Q())) {
			criteria.andMortgageLevelTwoEqualTo(commonQueryVO.getMortgageLevelTwo_Q());
		}

		if (StringUtils.isNotEmpty(commonQueryVO.getMortgageLevelThree_Q())) {
			criteria.andMortgageLevelThreeEqualTo(commonQueryVO.getMortgageLevelThree_Q());
		}

		if (StringUtils.isNotEmpty(commonQueryVO.getProductId_Q())) {
			criteria.andProductIdLike("%" + commonQueryVO.getProductId_Q() + "%");
		}

		if (StringUtils.isNotEmpty(commonQueryVO.getProductName_Q())) {
			criteria.andProductNameLike("%" + commonQueryVO.getProductName_Q() + "%");
		}

		example.setOrderByClause("LAST_UPD_TIME DESC");
		list = bPbcMtgMktPriceDAO.selectByPage(example, page);
		totalRecord = bPbcMtgMktPriceDAO.countByExample(example);
		List<BPbcMtgMktPriceVO> responseList = new ArrayList<BPbcMtgMktPriceVO>();
		for (int i = 0; i < list.size(); i++) {
			BPbcMtgMktPriceVO priceVO = new BPbcMtgMktPriceVO();
			BPbcMtgMktPrice price = list.get(i);
			BeanUtils.copyProperties(price, priceVO);
			if (StringUtils.isNotBlank(priceVO.getMortgageLevelOne())) {
				String mortgageLevelOneName = getMortgageName(priceVO.getMortgageLevelOne());
				priceVO.setMortgageLevelOneName(mortgageLevelOneName);
			}
			if (StringUtils.isNotBlank(priceVO.getMortgageLevelTwo())) {
				String mortgageLevelTwoName = getMortgageName(priceVO.getMortgageLevelTwo());
				priceVO.setMortgageLevelTwoName(mortgageLevelTwoName);
			}

			responseList.add(priceVO);
		}
		page.setRecords(responseList);
		page.setTotalRecord(totalRecord);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * 与上面的差别为多了一个可以查询是手工还是excel导入的查询条件
	 * 
	 */
	@Override
	public Page getTblMortMarPriPageForMoreCondition(int pageNo, int pageSize, MortMaketPriceQryVO commonQueryVO) {
		Page page = new Page(pageSize, pageNo, 0);
		BPbcMtgMktPriceExample example = new BPbcMtgMktPriceExample();
		Criteria criteria = example.createCriteria();
		List<BPbcMtgMktPrice> list = null;
		int totalRecord = 0;
		if (StringUtils.isNotEmpty(commonQueryVO.getMortgageLevelOne_Q())) {
			criteria.andMortgageLevelOneEqualTo(commonQueryVO.getMortgageLevelOne_Q());
		}

		if (StringUtils.isNotEmpty(commonQueryVO.getMortgageLevelTwo_Q())) {
			criteria.andMortgageLevelTwoEqualTo(commonQueryVO.getMortgageLevelTwo_Q());
		}

		if (StringUtils.isNotEmpty(commonQueryVO.getMortgageLevelThree_Q())) {
			criteria.andMortgageLevelThreeEqualTo(commonQueryVO.getMortgageLevelThree_Q());
		}

		if (StringUtils.isNotEmpty(commonQueryVO.getProductId_Q())) {
			criteria.andProductIdLike("%" + commonQueryVO.getProductId_Q() + "%");
		}

		if (StringUtils.isNotEmpty(commonQueryVO.getProductName_Q())) {
			criteria.andProductNameLike("%" + commonQueryVO.getProductName_Q() + "%");
		}
		if (StringUtils.isNotEmpty(commonQueryVO.getMarketPriceSrc_Q())) {
			criteria.andMarketPriceSrcEqualTo(commonQueryVO.getMarketPriceSrc_Q());
		}
		example.setOrderByClause("LAST_UPD_TIME DESC");
		list = bPbcMtgMktPriceDAO.selectByPage(example, page);
		totalRecord = bPbcMtgMktPriceDAO.countByExample(example);
		List<BPbcMtgMktPriceVO> responseList = new ArrayList<BPbcMtgMktPriceVO>();
		for (int i = 0; i < list.size(); i++) {
			BPbcMtgMktPriceVO priceVO = new BPbcMtgMktPriceVO();
			BPbcMtgMktPrice price = list.get(i);
			BeanUtils.copyProperties(price, priceVO);
			if (StringUtils.isNotBlank(priceVO.getMortgageLevelOne())) {
				String mortgageLevelOneName = getMortgageName(priceVO.getMortgageLevelOne());
				priceVO.setMortgageLevelOneName(mortgageLevelOneName);
			}
			if (StringUtils.isNotBlank(priceVO.getMortgageLevelTwo())) {
				String mortgageLevelTwoName = getMortgageName(priceVO.getMortgageLevelTwo());
				priceVO.setMortgageLevelTwoName(mortgageLevelTwoName);
			}

			responseList.add(priceVO);
		}
		page.setRecords(responseList);
		page.setTotalRecord(totalRecord);
		return page;
	}

	private String getMortgageName(String mortgageCode) {

		BPbcMtgClassExample example = new BPbcMtgClassExample();
		com.huateng.scf.bas.pbc.dao.model.BPbcMtgClassExample.Criteria criteria = example.createCriteria();
		criteria.andMortgageCodeEqualTo(new BigDecimal(mortgageCode));
		List<BPbcMtgClass> bPbcMtgClasses = bPbcMtgClassDAO.selectByExample(example);
		return bPbcMtgClasses.get(0).getMortgageName();
	}

	@Override
	public Page getMortMarketPriceHandHisInfoPage(int pageNo, int pageSize, MortMaketPriceQryVO commonQueryVO) {
		Page page = new Page(pageSize, pageNo, 0);
		BPbcMtgMktPriceHisExample example = new BPbcMtgMktPriceHisExample();
		com.huateng.scf.bas.pbc.dao.model.BPbcMtgMktPriceHisExample.Criteria criteria = example.createCriteria();
		criteria.andMarketPriceSrcEqualTo(ScfBasConstant.MARKETPRICESRC_HAND);

		if (StringUtils.isNotEmpty(commonQueryVO.getProductId_Q())) {
			criteria.andProductIdEqualTo(commonQueryVO.getProductId_Q());
		}
		example.setOrderByClause("LAST_UPD_TIME desc");
		List<BPbcMtgMktPriceHis> list = bPbcMtgMktPriceHisDAO.selectByPage(example, page);
		int totalRecord = bPbcMtgMktPriceHisDAO.countByExample(example);
		List<BPbcMtgMktPriceHisVO> priceHisVOList = new ArrayList<BPbcMtgMktPriceHisVO>();
		for (int i = 0; i < list.size(); i++) {
			BPbcMtgMktPriceHisVO priceHisVO = new BPbcMtgMktPriceHisVO();
			BPbcMtgMktPriceHis priceHis = list.get(i);
			BeanUtils.copyProperties(priceHis, priceHisVO);
			if (StringUtils.isNotBlank(priceHis.getMortgageLevelOne())) {
				String mortgageLevelOneName = getMortgageName(priceHisVO.getMortgageLevelOne());
				priceHisVO.setMortgageLevelOneName(mortgageLevelOneName);
			}
			if (StringUtils.isNotBlank(priceHis.getMortgageLevelTwo())) {
				String mortgageLevelTwoName = getMortgageName(priceHisVO.getMortgageLevelTwo());
				priceHisVO.setMortgageLevelTwoName(mortgageLevelTwoName);
			}
			priceHisVOList.add(priceHisVO);
		}
		page.setRecords(priceHisVOList);
		page.setTotalRecord(totalRecord);
		return page;
	}

	@Override
	@Transactional
	public String addOrUpdate(com.huateng.scf.bas.pbc.model.BPbcMtgMktPriceVO record) throws ScubeBizException {
		// 1.数据校验
		if (record == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		// 三级押品押品代码和名称一致性校验
		com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfoVO bPbcMtgBaseInfoVO = new com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfoVO();
		bPbcMtgBaseInfoVO.setMortgageLevelOne(record.getMortgageLevelOne());
		bPbcMtgBaseInfoVO.setMortgageLevelOneName(record.getMortgageLevelOneName());
		bPbcMtgBaseInfoVO.setMortgageLevelTwo(record.getMortgageLevelTwo());
		bPbcMtgBaseInfoVO.setMortgageLevelTwoName(record.getMortgageLevelTwoName());
		bPbcMtgBaseInfoVO.setMortgageLevelThree(record.getMortgageLevelThree());
		bPbcMtgBaseInfoVO.setMortgageLevelThreeName(record.getMortgageThreeName());
		bPbcMtgClassService.checkInfoForThreeLevelsSelect(bPbcMtgBaseInfoVO);
		BPbcMtgMktPrice targert = new BPbcMtgMktPrice();
		BeanUtils.copyProperties(record, targert);
		String id = "";
		String dataStr = ScfDateUtil.formatDate(new Date(), "yyyyMMddHHmmss");
		if (StringUtils.isEmpty(record.getId())) {
			// 去重，校验一级二级三级和产品名称不允许全部相同
			BPbcMtgMktPriceExample bPbcMtgMktPriceExample = new BPbcMtgMktPriceExample();
			Criteria cri = bPbcMtgMktPriceExample.createCriteria();
			cri.andMortgageLevelOneEqualTo(targert.getMortgageLevelOne());
			cri.andMortgageLevelTwoEqualTo(targert.getMortgageLevelTwo());
			cri.andMortgageLevelThreeEqualTo(targert.getMortgageLevelThree());
			cri.andProductNameEqualTo(targert.getProductName());
			List<BPbcMtgMktPrice> bPbcMtgMktPriceList = bPbcMtgMktPriceDAO.selectByExample(bPbcMtgMktPriceExample);
			if (bPbcMtgMktPriceList != null && bPbcMtgMktPriceList.size() > 0) {
				throw new ScubeBizException("该押品市场价格已存在！");
			}
			id = "SGSJWH" + dataStr + UUIDGeneratorUtil.generate(record).subSequence(21, 32);
			targert.setId(id);
			targert.setMarketPriceSrc(ScfBasConstant.MARKETPRICESRC_HAND);
			String tlrCd = ContextHolder.getUserInfo().getTlrNo();
			String brcode = ContextHolder.getOrgInfo().getBrNo();
			targert.setTlrcd(tlrCd);
			targert.setBrcode(brcode);
			targert.setAddDate(ScfDateUtil.formatDate(new Date()));
			targert.setCrtTime(new Date());
			String productId = bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_DSBH_NO);
			targert.setLastUpdBrcode(brcode);
			targert.setLastUpdTime(new Date());
			targert.setLastUpdTlrcd(tlrCd);
			targert.setProductId(productId);
			bPbcMtgMktPriceDAO.insert(targert);
			BPbcMtgMktPriceHis hisRecord = new BPbcMtgMktPriceHis();
			BeanUtils.copyProperties(targert, hisRecord);
			String hisId = "SGSJLS" + dataStr + UUIDGeneratorUtil.generate(record).subSequence(21, 32);
			hisRecord.setId(hisId);
			bPbcMtgMktPriceHisDAO.insert(hisRecord);
		} else {
			String lastUpdTlrcd = ContextHolder.getUserInfo().getTlrNo();
			String lastUpdBrcode = ContextHolder.getOrgInfo().getBrNo();
			targert.setLastUpdBrcode(lastUpdBrcode);
			targert.setLastUpdTlrcd(lastUpdTlrcd);
			targert.setLastUpdTime(new Date());
			bPbcMtgMktPriceDAO.updateByPrimaryKeySelective(targert);
			BPbcMtgMktPriceHis hisRecord = new BPbcMtgMktPriceHis();
			BeanUtils.copyProperties(targert, hisRecord);
			String hisId = "SGSJLS" + dataStr + UUIDGeneratorUtil.generate(record).subSequence(21, 32);
			hisRecord.setId(hisId);
			bPbcMtgMktPriceHisDAO.insert(hisRecord);
			id = record.getId();
		}
		return id;
	}

	@Override
	public Page findMortgageLevelByPage(int pageNo, int pageSize, DataItemsDO dataItemsDO) {
		Page page = new Page(pageSize, pageNo, 0);
		BPbcMtgClassExample bPbcMtgClassExample = new BPbcMtgClassExample();
		com.huateng.scf.bas.pbc.dao.model.BPbcMtgClassExample.Criteria criteria = bPbcMtgClassExample.createCriteria();
		if (StringUtils.isNotEmpty(dataItemsDO.getLevels())) {
			criteria.andLevelsEqualTo(dataItemsDO.getLevels());
		}
		if (StringUtils.isNotEmpty(dataItemsDO.getMortgageCode())) {
			criteria.andMortgageCodeEqualTo(new BigDecimal(dataItemsDO.getMortgageCode()));
		}
		if (StringUtils.isNotEmpty(dataItemsDO.getParentCode())) {
			criteria.andParentCodeEqualTo(new BigDecimal(dataItemsDO.getParentCode()));
		}
		bPbcMtgClassExample.setOrderByClause("MORTGAGE_CODE ASC");

		List<BPbcMtgClass> list = bPbcMtgClassDAO.selectByPage(bPbcMtgClassExample, page);

		int count = bPbcMtgClassDAO.countByExample(bPbcMtgClassExample);

		page.setRecords(list);

		page.setTotalRecord(count);

		return page;

	}

	public BPbcMtgMktPrice getMortgageMarketPriceByParam(BPbcMtgMktPrice bPbcMtgMktPrice) {

		BPbcMtgMktPriceExample example = new BPbcMtgMktPriceExample();
		Criteria criteria = example.createCriteria();
		if (StringUtils.isEmpty(bPbcMtgMktPrice.getMortgageLevelOne())) {
			String msg = "押品一级为空！";
			throw new ScubeBizException(msg, RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
		} else {
			criteria.andMortgageLevelOneEqualTo(bPbcMtgMktPrice.getMortgageLevelOne());
		}
		if (StringUtils.isEmpty(bPbcMtgMktPrice.getMortgageLevelTwo())) {
			String msg = "押品二级为空！";
			throw new ScubeBizException(msg, RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
		} else {
			criteria.andMortgageLevelTwoEqualTo(bPbcMtgMktPrice.getMortgageLevelTwo());
		}
		if (StringUtils.isEmpty(bPbcMtgMktPrice.getMortgageLevelThree())) {
			String msg = "押品三级为空！";
			throw new ScubeBizException(msg, RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
		} else {
			criteria.andMortgageLevelThreeEqualTo(bPbcMtgMktPrice.getMortgageLevelThree());
		}

		if (StringUtils.isEmpty(bPbcMtgMktPrice.getProductName())) {
			String msg = "产品名称为空！";
			throw new ScubeBizException(msg, RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
		} else {
			criteria.andProductNameLike("%" + bPbcMtgMktPrice.getProductName() + "%");
		}

		BPbcMtgMktPrice bPbcMtgMktPriceResult = bPbcMtgMktPriceDAO.selectObjectByPrimaryKey(example);

		return bPbcMtgMktPriceResult;
	}

	/*
	 * 市场价格导入页面查询
	 * 
	 * 
	 */
	@Override
	public Page getBaiInfoMarketPri(int pageNo, int pageSize, MortMaketPriceQryVO commonQueryVO) {
		Page page = new Page(pageSize, pageNo, 0);
		if (commonQueryVO == null) {
			return page;
		}
		String productName = commonQueryVO.getProductName_Q();
		String mortgageLevelThreeName = commonQueryVO.getMortgageLevelThreeName_Q();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productName", productName);
		map.put("mortgageLevelThreeName", mortgageLevelThreeName);
		try {
			extIBPbcMtgMktPriceDAO.getBaiInfoMarketPri(page, map);
		} catch (Exception e) {
			log.debug(e.getMessage());
			throw new ScubeBizException("押品市场价格信息分页查询失败！");
		}
		return page;
	}

}
