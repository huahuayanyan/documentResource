package com.huateng.scf.bas.crm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.huateng.base.common.beans.Page;
import com.huateng.data.dto.BdDataDictDto;
import com.huateng.data.dto.DataItem;
import com.huateng.data.service.BdDataDictService;
import com.huateng.scf.bas.brp.dao.IBBrpIndustryTypesDAO;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.IBCrmEntInfoDAO;
import com.huateng.scf.bas.crm.dao.IBCrmTagCloudRelDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmEntInfo;
import com.huateng.scf.bas.crm.dao.model.BCrmTagCloudRelExample;
import com.huateng.scf.bas.crm.dao.model.BCrmTagCloudRelExample.Criteria;
import com.huateng.scf.bas.crm.model.BCrmTagCloudRel;
import com.huateng.scf.bas.crm.service.IBCrmTagCloudRelService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * @author doujun
 * @date 2017/7/5 14:13
 * @version 1.0
 *
 */

@ScubeService
@Transactional
@Service("BCrmTagCloudRelServiceImpl")
public class BCrmTagCloudRelServiceImpl implements IBCrmTagCloudRelService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "bdDataDictService")
	BdDataDictService bdDataDictService;
	@Resource(name = "IBCrmTagCloudRelDAO")
	private IBCrmTagCloudRelDAO iBCrmTagCloudRelDAO;
	@Resource(name = "IBCrmBaseInfoDAO")
	private IBCrmBaseInfoDAO iBCrmBaseInfoDAO;
	@Resource(name = "IBCrmEntInfoDAO")
	IBCrmEntInfoDAO iBCrmEntInfoDAO;
	@Resource(name = "BBrpIndustryTypesDAO")
	IBBrpIndustryTypesDAO iBBrpIndustryTypesDAO;

	@Override
	public Page findBCrmTagCloudInfoByPage(int pageNo, int pageSize, BCrmTagCloudRel bCrmTagCloudRel) {
		Page page = new Page(pageSize, pageNo, 0);
		try {
			List<BCrmTagCloudRel> list = new ArrayList<BCrmTagCloudRel>();
			if (bCrmTagCloudRel != null) {
				BCrmTagCloudRelExample example = new BCrmTagCloudRelExample();
				Criteria creteria = example.createCriteria();
				if (StringUtils.isNotEmpty(bCrmTagCloudRel.getCustcd())) {
					creteria.andCustcdEqualTo(bCrmTagCloudRel.getCustcd());
				}
				if (StringUtils.isNotEmpty(bCrmTagCloudRel.getId())) {
					creteria.andIdEqualTo(bCrmTagCloudRel.getId());
				}
				if(StringUtils.isNotEmpty(bCrmTagCloudRel.getTagCode())){
					creteria.andTagCodeEqualTo(bCrmTagCloudRel.getTagCode());
				}
				if (StringUtils.isNotEmpty(bCrmTagCloudRel.getDataVal())) {
					creteria.andTagCodeEqualTo(bCrmTagCloudRel.getDataVal());
				}
				// 分页查询
				example.setOrderByClause(" LAST_UPD_TIME desc");
				List<com.huateng.scf.bas.crm.dao.model.BCrmTagCloudRel> listdal = iBCrmTagCloudRelDAO
						.selectByPage(example, page);
				for (com.huateng.scf.bas.crm.dao.model.BCrmTagCloudRel bCrmTagCloudReldal : listdal) {
					BCrmTagCloudRel crmTagCloudRel = new BCrmTagCloudRel();
					bCrmTagCloudReldal.setCustTagType(bCrmTagCloudReldal.getTagCode());
					BeanUtils.copyProperties(bCrmTagCloudReldal, crmTagCloudRel);
					list.add(crmTagCloudRel);
				}
			}
			page.setRecords(list);
		} catch (Exception e) {
			log.error("条件分页查询客户信息失败！");
			throw new ScubeBizException("条件分页查询客户信息失败！", e);
		}
		return page;
	}

	@Override
	public void add(BCrmTagCloudRel bCrmTagCloudRel) {
		try {
			if (bCrmTagCloudRel == null) {
				throw new ScubeBizException("新增客户标签失败,前台所传数据无效！");
			}

			BCrmTagCloudRel bcrm = findByCustcdAndTagCode(bCrmTagCloudRel.getCustcd(), bCrmTagCloudRel.getTagCode());
			if (bcrm != null) {
				// 如果存在，则更新
				BeanUtils.copyProperties(bCrmTagCloudRel, bcrm, new String[] { "id" });
				update(bcrm);
			} else {
				// 不存在，则插入
				bCrmTagCloudRel.setId(UUIDGeneratorUtil.generate());
				UserInfo user = ContextHolder.getUserInfo();
				BctlVO BctlVO = ContextHolder.getOrgInfo();
				String brcode = BctlVO.getBrNo();
				bCrmTagCloudRel.setCustcd(bCrmTagCloudRel.getCustcd());
				bCrmTagCloudRel.setTlrcd(user.getTlrNo());
				bCrmTagCloudRel.setCrtTime(new Date());
				bCrmTagCloudRel.setBrcode(brcode);
				com.huateng.scf.bas.crm.dao.model.BCrmTagCloudRel bCrmTagCloudReldal = new com.huateng.scf.bas.crm.dao.model.BCrmTagCloudRel();
				BeanUtils.copyProperties(bCrmTagCloudRel, bCrmTagCloudReldal);
				iBCrmTagCloudRelDAO.insert(bCrmTagCloudReldal);
			}
		} catch (Exception e) {
			log.error("新增客户标签失败！");
			throw new ScubeBizException("新增客户标签失败！", e);
		}
	}

	@Override
	public void update(BCrmTagCloudRel bCrmTagCloudRel) {
		try {
			if (bCrmTagCloudRel == null) {
				throw new ScubeBizException("修改客户标签失败,前台所传数据无效！");
			}
			UserInfo user = ContextHolder.getUserInfo();
			BctlVO BctlVO = ContextHolder.getOrgInfo();
			String brcode = BctlVO.getBrNo();
			bCrmTagCloudRel.setLastUpdTlrcd(user.getTlrNo());
			bCrmTagCloudRel.setLastUpdTime(new Date());
			bCrmTagCloudRel.setLastUpdBrcode(brcode);
			com.huateng.scf.bas.crm.dao.model.BCrmTagCloudRel bCrmTagCloudReldal = new com.huateng.scf.bas.crm.dao.model.BCrmTagCloudRel();
			BeanUtils.copyProperties(bCrmTagCloudRel, bCrmTagCloudReldal);
			iBCrmTagCloudRelDAO.updateByPrimaryKeySelective(bCrmTagCloudReldal);
		} catch (Exception e) {
			log.error("修改客户标签失败！");
			throw new ScubeBizException("修改客户标签失败！", e);
		}
	}

	@Override
	public void delete(String id) {
		try {
			if (StringUtils.isEmpty(id)) {
				throw new ScubeBizException("删除客户标签失败,前台所传数据无效！");
			}
			iBCrmTagCloudRelDAO.deleteByPrimaryKey(id);
		} catch (Exception e) {
			log.error("删除客户标签失败！");
			throw new ScubeBizException("删除客户标签失败！", e);
		}
	}

	@Override
	public void refresh(com.huateng.scf.bas.crm.model.BCrmBaseInfo bCrmBaseInfo) {
		try {
			if (bCrmBaseInfo == null) {
				throw new ScubeBizException("载入失败,前台所传数据无效！");
			}

			BCrmEntInfo bCrmEntIn = iBCrmEntInfoDAO.selectByPrimaryKey(bCrmBaseInfo.getCustcd());
			BCrmTagCloudRel bCrmTagCloudRel = new BCrmTagCloudRel();
			bCrmTagCloudRel.setCustcd(bCrmEntIn.getCustcd());

			// 所属行业
			bCrmTagCloudRel.setTagCode(ScfBasConstant.CLOUD_TAG_INDUSTRY_TYPE);
			if (StringUtils.isNotEmpty(bCrmEntIn.getIndustryType())) {
				bCrmTagCloudRel.setTagValue(
						iBBrpIndustryTypesDAO.selectByPrimaryKey(bCrmEntIn.getIndustryType()).getIndustryName());
			}
			add(bCrmTagCloudRel);

			// 信用评级
			bCrmTagCloudRel.setTagCode(ScfBasConstant.CLOUD_TAG_CREDIT_LEVEL);
			bCrmTagCloudRel.setTagValue(bCrmEntIn.getCreditLevel());
			add(bCrmTagCloudRel);

			// 企业规模
			bCrmTagCloudRel.setTagCode(ScfBasConstant.CLOUD_TAG_ENTERPRISE_SCOPE);
			bCrmTagCloudRel.setTagValue(getDictName("enterpriseScope", bCrmEntIn.getEnterpriseScope()));
			add(bCrmTagCloudRel);

			// 企业类型
			bCrmTagCloudRel.setTagCode(ScfBasConstant.CLOUD_TAG_ENTERPRISE_TYPE);
			if ("1".equals(bCrmBaseInfo.getCoreFlag())) {
				bCrmTagCloudRel.setTagValue("核心厂商");
			} else if ("1".equals(bCrmBaseInfo.getMoniFlag())) {
				bCrmTagCloudRel.setTagValue("监管公司");
			} else if ("1".equals(bCrmBaseInfo.getCreditFlag())) {
				bCrmTagCloudRel.setTagValue("授信客户");
			} else {
				bCrmTagCloudRel.setTagValue("");
			}
			add(bCrmTagCloudRel);

			// 信用评分
			bCrmTagCloudRel.setTagCode(ScfBasConstant.CLOUD_TAG_CREDIT_SCR);
			bCrmTagCloudRel.setTagValue(
					bCrmEntIn.getCreditScr() == null ? "" : String.valueOf(bCrmEntIn.getCreditScr().floatValue()));
			add(bCrmTagCloudRel);

			// 年营业额
			bCrmTagCloudRel.setTagCode(ScfBasConstant.CLOUD_TAG_TURNOVER);
			bCrmTagCloudRel.setTagValue(
					bCrmEntIn.getTurnover() == null ? "" : String.valueOf(bCrmEntIn.getTurnover().floatValue()));
			add(bCrmTagCloudRel);

		} catch (Exception e) {
			log.error("载入客户标签失败！");
			throw new ScubeBizException("载入客户标签失败！", e);
		}
	}

	private String getDictName(String dictCode, String dictValue) {
		BdDataDictDto bdDataDictDto = bdDataDictService.getDataByDictCode(dictCode);
		if (bdDataDictDto == null) {
			return "";
		}
		List<DataItem> list = bdDataDictDto.getDataItems();
		for (DataItem item : list) {
			if (item.getDataVal().equals(dictValue)) {
				return item.getDataTrsVal();
			}
		}
		return "";
	}

	@Override
	public BCrmTagCloudRel findByCustcdAndTagCode(String custcd, String tagCode) {
		try {
			BCrmTagCloudRelExample example = new BCrmTagCloudRelExample();
			Criteria creteria = example.createCriteria();
			if (StringUtils.isEmpty(custcd) || StringUtils.isEmpty(tagCode)) {
				throw new ScubeBizException("参数错误！");
			}
			if (StringUtils.isNotEmpty(custcd)) {
				creteria.andCustcdEqualTo(custcd);
			}
			if (StringUtils.isNotEmpty(tagCode)) {
				creteria.andTagCodeEqualTo(tagCode);
			}
			List<com.huateng.scf.bas.crm.dao.model.BCrmTagCloudRel> list = iBCrmTagCloudRelDAO.selectByExample(example);
			if (list == null || list.size() == 0) {
				return null;
			}
			com.huateng.scf.bas.crm.dao.model.BCrmTagCloudRel bCrmTagCloudReldal = list.get(0);
			BCrmTagCloudRel bCrmTagCloudRel = new BCrmTagCloudRel();
			BeanUtils.copyProperties(bCrmTagCloudReldal, bCrmTagCloudRel);
			return bCrmTagCloudRel;
		} catch (Exception e) {
			log.error("查询客户客户标签信息失败！");
			throw new ScubeBizException("查询客户客户标签信息失败！", e);
		}
	}
}
