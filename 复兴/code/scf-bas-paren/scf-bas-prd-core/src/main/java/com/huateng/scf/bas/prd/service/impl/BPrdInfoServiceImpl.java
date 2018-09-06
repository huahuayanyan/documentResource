/**
 * 
 */
package com.huateng.scf.bas.prd.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IProductService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdInfoExample;
import com.huateng.scf.bas.prd.dao.model.BPrdInfoExample.Criteria;
import com.huateng.scf.bas.prd.model.BPrdInfo;
import com.huateng.scf.bas.prd.service.IBPrdBaseInfoService;
import com.huateng.scf.bas.prd.service.IBPrdBizSurBindService;
import com.huateng.scf.bas.prd.service.IBPrdCopLibBindService;
import com.huateng.scf.bas.prd.service.IBPrdCostBindService;
import com.huateng.scf.bas.prd.service.IBPrdCreditBindService;
import com.huateng.scf.bas.prd.service.IBPrdCreditPlyService;
import com.huateng.scf.bas.prd.service.IBPrdIndustryTypeService;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.prd.service.IBPrdReceMatlBindService;
import com.huateng.scf.bas.prd.service.IBPrdWarnBindService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * 供应链产品实现类
 * </p>
 * 
 * @author huangshuidan
 * @date 2016年11月22日上午10:19:08
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * 
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月22日上午10:19:08             新增
 * 
 *            </pre>
 */
@ScubeService
@Service("BPrdInfoServiceImpl")
public class BPrdInfoServiceImpl implements IBPrdInfoService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "BPrdInfoDAO")
	private IBPrdInfoDAO bPrdInfoDAO;

	// 产品基础信息服务
	@Resource(name = "BPrdBaseInfoServiceImpl")
	private IBPrdBaseInfoService bPrdBaseInfoService;

	// 产品业务调查关联服务
	@Resource(name = "BPrdBizSurBindServiceImpl")
	private IBPrdBizSurBindService bPrdBizSurBindService;

	// 产品组件关联信息服务
	@Resource(name = "BPrdCopLibBindServiceImpl")
	private IBPrdCopLibBindService bprdCopLibBindService;

	// 产品费用绑定服务
	@Resource(name = "BPrdCostBindServiceImpl")
	private IBPrdCostBindService bPrdCostBindService;

	// 产品额度绑定服务
	@Resource(name = "BPrdCreditBindServiceImpl")
	private IBPrdCreditBindService bPrdCreditBindService;

	// 授信政策服务
	@Resource(name = "BPrdCreditPlyServiceImpl")
	private IBPrdCreditPlyService bPrdCreditPlyService;

	// 产品行业类别关联服务
	@Resource(name = "BPrdIndustryTypeServiceImpl")
	private IBPrdIndustryTypeService bPrdIndustryTypeService;

	// 应收材料关联服务
	@Resource(name = "BPrdReceMatlBindServiceImpl")
	private IBPrdReceMatlBindService bPrdReceMatlBindService;

	// 产品风险预警关联服务
	@Resource(name = "BPrdWarnBindServiceImpl")
	private IBPrdWarnBindService bPrdWarnBindService;

	@Resource(name = "ProductServiceImpl")
	IProductService productservice;

	// 产品信息新增
	@Override
	@Transactional
	public String add(BPrdInfo bPrdInfo) throws ScubeBizException {
		if (bPrdInfo != null) {
			if (bPrdInfo.getProductId() != null && bPrdInfo.getProductId().length() > 0) {
				// 新增之前需要查看产品号是否已经存在
				com.huateng.scf.bas.prd.dao.model.BPrdInfo bPrdInfo1 = bPrdInfoDAO.selectByPrimaryKey(bPrdInfo.getProductId());
				if (bPrdInfo1 != null) {// 若库中已存在记录,调用修改方法
					this.update(bPrdInfo);
				} else {
					com.huateng.scf.bas.prd.dao.model.BPrdInfo bPrdInfo2 = new com.huateng.scf.bas.prd.dao.model.BPrdInfo();
					try {
						BeanUtils.copyProperties(bPrdInfo, bPrdInfo2);
					} catch (BeansException e) {
						throw new ScubeBizException("转换异常");
					}
					bPrdInfoDAO.insert(bPrdInfo2);
				}
				return null;
			} else {
				throw new ScubeBizException("新增产品信息所传数据无效！");
			}
		} else {
			throw new ScubeBizException("新增产品信息所传数据无效！");
		}
	}

	// 产品信息删除
	@Override
	@Transactional
	public int delete(String productId) throws ScubeBizException {
		if (productId != null && productId.length() > 0) {
			try {
				// bPrdBaseInfoService.delete(productId);
				// 删除所有的关联信息
				this.deletRelAll(productId);
				try {
					return bPrdInfoDAO.deleteByPrimaryKey(productId);
				} catch (Exception e) {
					log.error("产品信息删除失败！");
					throw new ScubeBizException("产品信息删除失败！", e);
				}
			} catch (Exception e) {
				log.error("产品基本信息删除失败！");
				throw new ScubeBizException("产品基本信息删除失败！", e);
			}
		} else {
			throw new ScubeBizException("产品信息删除失败,所传产品号无效！");
		}
	}

	/**
	 * 删除所有产品关联表中的信息
	 * 
	 * @param productId
	 */
	@Transactional
	private void deletRelAll(String productId) {
		bPrdBaseInfoService.delete(productId);
		bPrdBizSurBindService.deleteByProductId(productId);
		bprdCopLibBindService.deleteByProductId(productId);
		bPrdCostBindService.deleteByProductId(productId);
		bPrdCreditBindService.deleteByProductId(productId);
		bPrdCreditPlyService.deleteByProductId(productId);
		bPrdIndustryTypeService.deleteByProductId(productId);
		bPrdReceMatlBindService.deleteByProductId(productId);
		bPrdWarnBindService.deleteByProductId(productId);
	}

	// 产品信息修改（只根据产品ID，修改的时候不需要查重，因为产品号不可修改。）
	@Override
	@Transactional
	public int update(BPrdInfo bPrdInfo) throws ScubeBizException {
		if (bPrdInfo != null && !"".equals(bPrdInfo)) {
			if (bPrdInfo.getProductId() != null && bPrdInfo.getProductId().length() > 0) {
				com.huateng.scf.bas.prd.dao.model.BPrdInfo bPrdInfo2 = new com.huateng.scf.bas.prd.dao.model.BPrdInfo();
				try {
					BeanUtils.copyProperties(bPrdInfo, bPrdInfo2);
				} catch (BeansException e) {
					throw new ScubeBizException("转换异常");
				}
				return bPrdInfoDAO.updateByPrimaryKeySelective(bPrdInfo2);
			} else {
				throw new ScubeBizException("修改产品信息失败，所传数据无产品号！");
			}
		} else {
			throw new ScubeBizException("修改产品信息所传数据无效！");
		}
	}

	// 查找具体产品信息（根据产品ID，查不到返回空。）
	@Override
	public BPrdInfo findBPrdInfoByKey(BPrdInfo bPrdInfo) throws ScubeBizException {
		BPrdInfoExample bbie = new BPrdInfoExample();
		com.huateng.scf.bas.prd.dao.model.BPrdInfoExample.Criteria cri = bbie.createCriteria();
		if (bPrdInfo != null && !"".equals(bPrdInfo)) {
			// 根据产品ID查询
			if (bPrdInfo.getProductId() != null && bPrdInfo.getProductId().length() > 0) {
				cri.andProductIdEqualTo(bPrdInfo.getProductId());
			}
			// 根据产品名称查询
			if (bPrdInfo.getProductName() != null && bPrdInfo.getProductName().length() > 0) {
				cri.andProductNameLike("%" + bPrdInfo.getProductName() + "%");
			}
			// 根据产品类型查询
			if (bPrdInfo.getProductType() != null && bPrdInfo.getProductType().length() > 0) {
				cri.andProductTypeEqualTo(bPrdInfo.getProductType());
			}
			// 根据产品父ID查询
			if (bPrdInfo.getParentId() != null && bPrdInfo.getParentId().length() > 0) {
				cri.andParentIdEqualTo(bPrdInfo.getParentId());
			}
			try {
				BPrdInfo bPrdInfo2 = new BPrdInfo();
				List<com.huateng.scf.bas.prd.dao.model.BPrdInfo> bPrdInfos = bPrdInfoDAO.selectByExample(bbie);
				if (bPrdInfos != null && bPrdInfos.size() > 0) {
					com.huateng.scf.bas.prd.dao.model.BPrdInfo bPrdInfo1 = bPrdInfos.get(0);
					try {
						BeanUtils.copyProperties(bPrdInfo1, bPrdInfo2);
					} catch (BeansException e) {
						throw new ScubeBizException("转换异常");
					}
					return bPrdInfo2;
				} else {
					// 没有查询到对象
					return null;
				}
			} catch (Exception e) {
				throw new ScubeBizException("条件查询产品信息失败！");
			}
		} else {
			// 无条件查询，返回空值。
			return null;
		}
	}

	@Override
	public BPrdInfo findBPrdInfoObjectByKey(String key) throws ScubeBizException {
		//
		BPrdInfo bPrdInfo = new BPrdInfo();
		try {
			com.huateng.scf.bas.prd.dao.model.BPrdInfo bPrdInfoDal = bPrdInfoDAO.selectByPrimaryKey(key);
			BeanUtils.copyProperties(bPrdInfoDal, bPrdInfo);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e.getMessage());
			throw new ScubeBizException("转换异常");
		}
		return bPrdInfo;
	}

	// 条件查询产品信息集合（根据产品ID，产品名称和产品种类，无条件查询，这里返回所有，可能会使用于下拉菜单。）
	@Override
	public List<BPrdInfo> findBPrdInfoByBPrd(BPrdInfo bPrdInfo) throws ScubeBizException {
		BPrdInfoExample example = new BPrdInfoExample();
		com.huateng.scf.bas.prd.dao.model.BPrdInfoExample.Criteria cri = example.createCriteria();
		if (bPrdInfo != null && !"".equals(bPrdInfo)) {
			// 根据产品ID查询
			if (bPrdInfo.getProductId() != null && bPrdInfo.getProductId().length() > 0) {
				cri.andProductIdEqualTo(bPrdInfo.getProductId());
			}
			// 根据产品名称查询
			if (bPrdInfo.getProductName() != null && bPrdInfo.getProductName().length() > 0) {
				cri.andProductNameLike("%" + bPrdInfo.getProductName() + "%");
			}
			// 根据产品类型查询
			if (bPrdInfo.getProductType() != null && bPrdInfo.getProductType().length() > 0) {
				cri.andProductTypeEqualTo(bPrdInfo.getProductType());
			}
			// 根据产品父ID查询
			if (bPrdInfo.getParentId() != null && bPrdInfo.getParentId().length() > 0) {
				cri.andParentIdEqualTo(bPrdInfo.getParentId());
			}
		}
		try {
			List<com.huateng.scf.bas.prd.dao.model.BPrdInfo> bPrdInfoList = bPrdInfoDAO.selectByExample(example);
			List<BPrdInfo> bPrdInfoList2 = new ArrayList<BPrdInfo>();
			for (com.huateng.scf.bas.prd.dao.model.BPrdInfo bPrdInfo1 : bPrdInfoList) {
				BPrdInfo bPrdInfo2 = new BPrdInfo();
				try {
					BeanUtils.copyProperties(bPrdInfo1, bPrdInfo2);
				} catch (BeansException e) {
					throw new ScubeBizException("转换异常");
				}
				bPrdInfoList2.add(bPrdInfo2);
			}
			return bPrdInfoList2;
		} catch (Exception e) {
			throw new ScubeBizException("条件查询产品信息集合失败！");
		}
	}

	// 分页查询产品信息（用于下拉菜单，根据产品ID,产品类型和产品名称查询。如果没有对应对象，则返回所有对象。）
	// 这里设置ext1为大类的名称，用于页面的显示。
	@Override
	public Page selectBPrdInfoBySelect(int pageNo, int pageSize, BPrdInfo bPrdInfo) throws ScubeBizException {
		Page p = new Page(pageSize, pageNo, 0);
		BPrdInfoExample example = new BPrdInfoExample();
		com.huateng.scf.bas.prd.dao.model.BPrdInfoExample.Criteria cri = example.createCriteria();
		if (bPrdInfo != null && !"".equals(bPrdInfo)) {
			// 根据产品ID查询
			if (bPrdInfo.getProductId() != null && bPrdInfo.getProductId().length() > 0) {
				cri.andProductIdEqualTo(bPrdInfo.getProductId());
			}
			// 根据产品名称查询
			if (bPrdInfo.getProductName() != null && bPrdInfo.getProductName().length() > 0) {
				cri.andProductNameLike("%" + bPrdInfo.getProductName() + "%");
			}
			// 根据产品类型查询
			if (bPrdInfo.getProductType() != null && bPrdInfo.getProductType().length() > 0) {
				cri.andProductTypeEqualTo(bPrdInfo.getProductType());
			}

		}
		try {// 产品大类名称转换(设置EXT1字段为前台产品大类的名称，而不是一个ID)
			List<com.huateng.scf.bas.prd.dao.model.BPrdInfo> bPrdInfoList = bPrdInfoDAO.selectByPage(example, p);
			List<BPrdInfo> bPrdInfoList2 = new ArrayList<BPrdInfo>();
			for (com.huateng.scf.bas.prd.dao.model.BPrdInfo bPrdInfo1 : bPrdInfoList) {
				if (bPrdInfo1.getParentId() != null && bPrdInfo1.getParentId().length() > 0) {
					BPrdInfoExample example2 = new BPrdInfoExample();
					(example2.createCriteria()).andParentIdEqualTo(bPrdInfo1.getParentId());
					List<com.huateng.scf.bas.prd.dao.model.BPrdInfo> bPrdInfo2 = bPrdInfoDAO.selectByExample(example2);
					bPrdInfo1.setExt1(bPrdInfo2.get(0).getProductName());
					BPrdInfo bPrdInfo3 = new BPrdInfo();
					try {
						BeanUtils.copyProperties(bPrdInfo1, bPrdInfo3);
					} catch (BeansException e) {
						throw new ScubeBizException("转换异常");
					}
					bPrdInfoList2.add(bPrdInfo3);
				} else {// 不存在产品父亲id
					throw new ScubeBizException("（下拉菜单）产品信息条件分页查询失败！");
				}
			}
			p.setRecords(bPrdInfoList2);
			return p;
		} catch (Exception e) {
			log.error("（下拉菜单）产品信息条件分页查询失败！");
			throw new ScubeBizException("（下拉菜单）产品信息条件分页查询失败！", e);
		}
	}

	// 分页查询产品信息
	@Override
	public Page findPrdInfoByPage(int pageNo, int pageSize, BPrdInfo bPrdInfo) throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		BPrdInfoExample example = new BPrdInfoExample();
		com.huateng.scf.bas.prd.dao.model.BPrdInfoExample.Criteria cri = example.createCriteria();
		if (bPrdInfo != null && !"".equals(bPrdInfo)) {
			// 根据产品ID查询
			if (bPrdInfo.getProductId() != null && bPrdInfo.getProductId().length() > 0) {
				cri.andProductIdEqualTo(bPrdInfo.getProductId());
			}
			// 根据产品名称查询
			if (bPrdInfo.getProductName() != null && bPrdInfo.getProductName().length() > 0) {
				cri.andProductNameLike("%" + bPrdInfo.getProductName() + "%");
			}
			// 根据产品类型查询
			if (bPrdInfo.getProductType() != null && bPrdInfo.getProductType().length() > 0) {
				cri.andProductTypeEqualTo(bPrdInfo.getProductType());
			}
		}
		try {
			page.setRecords(bPrdInfoDAO.selectByPage(example, page));
			return page;
		} catch (Exception e) {
			log.error("产品信息条件分页查询失败！");
			throw new ScubeBizException("产品信息条件分页查询失败！", e);
		}
	}

	// 这里是页面的查询按钮的业务品种和对应产品号的校验（产品名称不用模糊查询）
	@Override
	public BPrdInfo checkPrdInfoForSelect(BPrdInfo bPrdInfo) throws ScubeBizException {
		BPrdInfoExample bbie = new BPrdInfoExample();
		com.huateng.scf.bas.prd.dao.model.BPrdInfoExample.Criteria cri = bbie.createCriteria();
		if (bPrdInfo != null && !"".equals(bPrdInfo)) {
			// 根据产品ID查询
			if (bPrdInfo.getProductId() != null && bPrdInfo.getProductId().length() > 0) {
				cri.andProductIdEqualTo(bPrdInfo.getProductId());
			}
			// 根据产品名称查询
			if (bPrdInfo.getProductName() != null && bPrdInfo.getProductName().length() > 0) {
				cri.andProductNameEqualTo(bPrdInfo.getProductName());
			}
			try {
				BPrdInfo bPrdInfo2 = new BPrdInfo();
				List<com.huateng.scf.bas.prd.dao.model.BPrdInfo> bPrdInfos = bPrdInfoDAO.selectByExample(bbie);
				if (bPrdInfos != null && bPrdInfos.size() > 0) {
					com.huateng.scf.bas.prd.dao.model.BPrdInfo bPrdInfo1 = bPrdInfos.get(0);
					try {
						BeanUtils.copyProperties(bPrdInfo1, bPrdInfo2);
					} catch (BeansException e) {
						throw new ScubeBizException("转换异常");
					}
					return bPrdInfo2;
				} else {
					// 没有查询到对象
					return null;
				}
			} catch (Exception e) {
				throw new ScubeBizException("条件查询产品信息失败！");
			}
		} else {
			// 无条件查询，返回空值。
			return null;
		}
	}

	/**
	 * @Description: 通过parentId查找产品记录，返回List
	 * @author mengjiajia
	 * @Created 2012-9-25上午10:56:43
	 * @param parentId
	 * @return
	 * @throws ScubeBizException
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List getProductInfoByParentID(String parentId) throws ScubeBizException {
		BPrdInfoExample example = new BPrdInfoExample();
		BPrdInfoExample.Criteria cri = example.createCriteria();
		cri.andParentIdEqualTo(parentId);
		List list = bPrdInfoDAO.selectByExample(example);
		return list;
	}

	/**
	 *
	 * @Description:
	 * @author jianfeng.huang
	 * @Created 2013-7-18下午7:17:58
	 * @param Flag
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public String getProductIdByFlag(String flag) throws ScubeBizException {
		String supplyChainPdId = "";

		if (ScfBasConstant.PRODUCT_TYPE_CHATTLE_DYNAMIC.equals(flag)) {// 动态
			supplyChainPdId = productservice.getProductDynamic();
		} else if (ScfBasConstant.PRODUCT_TYPE_FOURWARE.equals(flag)) {// 先票后货
			supplyChainPdId = ScfBasConstant.PRODUCT_TYPE_XPHH;
		} else if (ScfBasConstant.PRODUCT_TYPE_CARPLEDGE.equals(flag)) {// 汽车货押
			supplyChainPdId = productservice.getProductInfoByMidParentID(ScfBasConstant.PRODUCT_TYPE_CAR_PLEDGE);
		} else if (ScfBasConstant.PRODUCT_TYPE_CHATTLE_STATIC.equals(flag)) {// 静态
			supplyChainPdId = productservice.getProductStatic();
		} else if (ScfBasConstant.PRODUCT_TYPE_STANDARD_BILL.equals(flag)) {// 标准仓单
			supplyChainPdId = productservice.getBillByMidProductId(ScfBasConstant.BILL_TYPE_STANDARD);
		} else if (ScfBasConstant.PRODUCT_TYPE_NORMAL_BILL.equals(flag)) {// 普通非标准仓单
			supplyChainPdId = productservice.getBillByMidProductId(ScfBasConstant.BILL_TYPE_NORMAL);
		} else if (ScfBasConstant.PRODUCT_TYPE_CAR_FIRST.equals(flag)) {// 汽车金融
			supplyChainPdId = productservice.getProductInfoByMidParentID(ScfBasConstant.PRODUCT_TYPE_CAR_FIRST_PAY);
		}
		return supplyChainPdId;
	}

	/**
	 * 通过parentId查找产品记录，返回String
	 * 
	 * @param parentId_Q
	 * @return
	 * @throws ScubeBizException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String getProductByParentId(String parentId) throws ScubeBizException {
		String productInfo = new String();
		List<com.huateng.scf.bas.prd.dao.model.BPrdInfo> productList = getProductInfoByParentID(parentId);
		for (com.huateng.scf.bas.prd.dao.model.BPrdInfo tblProductInfo : productList) {
			if (tblProductInfo != null) {
				productInfo += tblProductInfo.getProductId() + ",";
			}
		}
		if (productInfo.length() > 0) {
			productInfo = productInfo.substring(0, productInfo.length() - 1);
		}

		return productInfo;
	}

	/**
	 * 获取业务产品 中类 信息
	 * 
	 * @param supplyChainPdId
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public String getSubClassProductIds(String supplyChainPdId) throws ScubeBizException {
		String subClassPdIds = "";
		if (StringUtil.isEmpty(supplyChainPdId)) {
			throw new ScubeBizException("供应链产品id为空");
		}
		com.huateng.scf.bas.prd.dao.model.BPrdInfo tblProductInfo = bPrdInfoDAO.selectByPrimaryKey(supplyChainPdId);
		if (tblProductInfo != null) {
			if (tblProductInfo.getProductType().equals(ScfBasConstant.PRODUCT_TYPE_BIGCLASS)) {
				BPrdInfoExample example = new BPrdInfoExample();
				BPrdInfoExample.Criteria cri = example.createCriteria();
				cri.andParentIdEqualTo(tblProductInfo.getParentId());
				List<com.huateng.scf.bas.prd.dao.model.BPrdInfo> list = bPrdInfoDAO.selectByExample(example);
				for (com.huateng.scf.bas.prd.dao.model.BPrdInfo bPrdInfo : list) {
					subClassPdIds += "," + bPrdInfo.getProductId();
				}
				if (subClassPdIds.indexOf(",") != -1) {
					subClassPdIds = subClassPdIds.substring(1);
				}
			} else if (tblProductInfo.getProductType().equals(ScfBasConstant.PRODUCT_TYPE_SUBCLASS)) {
				subClassPdIds = tblProductInfo.getProductId();
			} else if (tblProductInfo.getProductType().equals(ScfBasConstant.PRODUCT_TYPE_LEAFCLASS)) {
				subClassPdIds = tblProductInfo.getParentId();
			}
		} else {
			// ExceptionUtil.throwCommonException("该供应链产品id不存在对应产品");
			return null;
		}
		return subClassPdIds;
	}

	/**
	 * 根据产品ID返回父类ID
	 * 
	 * @param productId
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public String getParentIdById(String productId) throws ScubeBizException {
		String parentId = new String();
		com.huateng.scf.bas.prd.dao.model.BPrdInfo tblProductInfo = bPrdInfoDAO.selectByPrimaryKey(productId);
		if (tblProductInfo != null) {
			parentId = tblProductInfo.getParentId();
		}
		return parentId;
	}

	/**
	 * 根据父类ID,TYPE返回产品ID(没有意义)
	 * 
	 * @param parentId
	 * @param productType
	 * @return
	 * @throws ScubeBizException
	 * @date 2017年4月21日下午1:47:57
	 */
	@Override
	public String getProductIdByParIdType(String parentId, String productType) throws ScubeBizException {

		if (StringUtil.isEmpty(parentId) || StringUtil.isEmpty(productType)) {
			throw new ScubeBizException("参数不能为空! parentId : " + parentId + ", productType : " + productType);
		}
		BPrdInfoExample example = new BPrdInfoExample();
		com.huateng.scf.bas.prd.dao.model.BPrdInfoExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		criteria.andProductTypeEqualTo(productType);
		List<com.huateng.scf.bas.prd.dao.model.BPrdInfo> list = bPrdInfoDAO.selectByExample(example);
		String productId = null;
		if (list != null && list.size() > 0)
			productId = list.get(0).getProductId();
		return productId;
	}

	@Override
	public List<BPrdInfo> findBPrdInfoListForSelect(BPrdInfo bPrdInfo) throws ScubeBizException {
		BPrdInfoExample bPrdInfoExample = new BPrdInfoExample();
		Criteria cri = bPrdInfoExample.createCriteria();
		if (bPrdInfo.getProductName() != null) {
			cri.andProductNameLike("%" + bPrdInfo.getProductName() + "%");
		}
		if (bPrdInfo.getProductId() != null) {
			cri.andProductIdEqualTo(bPrdInfo.getProductId());
		}
		if (bPrdInfo.getParentId() != null) {
			cri.andParentIdEqualTo(bPrdInfo.getParentId());
		} else {
			cri.andParentIdNotEqualTo("0000");
		}
		ArrayList<BPrdInfo> arrayList = new ArrayList<BPrdInfo>();
		List<com.huateng.scf.bas.prd.dao.model.BPrdInfo> bPrdInfoList = bPrdInfoDAO.selectByExample(bPrdInfoExample);
		for (com.huateng.scf.bas.prd.dao.model.BPrdInfo bPrdInfo2 : bPrdInfoList) {
			BPrdInfo bPrdInfo3 = new BPrdInfo();
			BeanUtils.copyProperties(bPrdInfo2, bPrdInfo3);
			arrayList.add(bPrdInfo3);
		}
		return arrayList;
	}

}
