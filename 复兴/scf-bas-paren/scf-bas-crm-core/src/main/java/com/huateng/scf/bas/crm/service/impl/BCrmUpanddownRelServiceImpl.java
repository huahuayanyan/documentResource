/**
 * 
 */
package com.huateng.scf.bas.crm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.TlrInfoVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.service.OrgService;
import com.huateng.authority.service.UserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.constant.BCrmUpanddownConstants;
import com.huateng.scf.bas.crm.dao.IBCrmUpanddownRelDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmUpanddownRelExample;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.model.BCrmUpanddownRel;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.crm.service.IBCrmUpanddownRelService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年11月14日下午7:42:10
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年11月17日下午7:42:10	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("IBCrmUpanddownRelServiceImpl")
public class BCrmUpanddownRelServiceImpl implements IBCrmUpanddownRelService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "bCrmBaseInfoService")
	IBCrmBaseInfoService iBCrmBaseInfoService;
	@Resource(name = "orgService")
	OrgService orgService;
	@Resource(name = "userService")
	UserService userService;
	@Resource(name = "IBCrmUpanddownRelDAO")
	IBCrmUpanddownRelDAO iBCrmUpanddownRelDAO;
	// 缓存@Autowired private CacheService cacheService;
	// @Autowired BDDataUtil bDDataUtil;

	// 上下游关联关系新增
	@Override
	@Transactional
	public String add(BCrmUpanddownRel bCrmUpanddownRel) {
		// Tlrcd,LastUpdTlrcd,CrtTime,LastUpdTime,LastUpdBrcode.设置公共字段
		ScfCommonUtil.setCommonField(bCrmUpanddownRel);
		com.huateng.scf.bas.crm.dao.model.BCrmUpanddownRel bCrmUpanddownRel2 = new com.huateng.scf.bas.crm.dao.model.BCrmUpanddownRel();
		BeanUtils.copyProperties(bCrmUpanddownRel, bCrmUpanddownRel2);
		BctlVO bctlVO = ContextHolder.getOrgInfo();// 获取机构信息
		String brcode = bctlVO.getBrNo();
		bCrmUpanddownRel2.setBrcode(brcode);// 设置经办机构信息
		bCrmUpanddownRel2.setId(UUIDGeneratorUtil.generate());
		bCrmUpanddownRel2.setState(BCrmUpanddownConstants.UPANDDOWN_STATE_VALID);// 设置状态默认为正常
		try {
			iBCrmUpanddownRelDAO.insert(bCrmUpanddownRel2);
			return null;
		} catch (Exception e) {
			log.error("上下游关联关系新增失败！");
			throw new ScubeBizException("上下游关联关系新增失败！", e);
		}
	}

	// 上下游关联关系删除(根据ID，因为这里不存在既是上游，又是下游的情况，所以是可以根据客户号删除的。)
	@Override
	@Transactional
	public int delete(String key) {
		try {
			return iBCrmUpanddownRelDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			log.error("上下游关联关系删除失败！");
			throw new ScubeBizException("上下游关联关系删除失败！", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.crm.service.IBCrmUpanddownRelService#deleteByCustcd(
	 * java.lang.String)
	 */
	@Override
	@Transactional
	public int deleteByCustcd(String custcd) {
		BCrmUpanddownRelExample bCrmUpanddownRelExample = new BCrmUpanddownRelExample();
		bCrmUpanddownRelExample.createCriteria().andCustcdEqualTo(custcd);
		try {
			return iBCrmUpanddownRelDAO.deleteByExample(bCrmUpanddownRelExample);
		} catch (Exception e) {
			log.error("上下游关联关系删除失败！");
			throw new ScubeBizException("上下游关联关系删除失败！", e);
		}
	}

	// 上下游关联关系修改(修改是根据ID,虽然现在不考虑一个客户既是上游客户，又是下游客户的情况。)
	@Override
	@Transactional
	public int update(BCrmUpanddownRel bCrmUpanddownRel) {
		BCrmUpanddownRelExample bbie = new BCrmUpanddownRelExample();
		com.huateng.scf.bas.crm.dao.model.BCrmUpanddownRelExample.Criteria cri = bbie.createCriteria();
		com.huateng.scf.bas.crm.dao.model.BCrmUpanddownRel bCrmUpanddownRel2 = new com.huateng.scf.bas.crm.dao.model.BCrmUpanddownRel();
		BeanUtils.copyProperties(bCrmUpanddownRel, bCrmUpanddownRel2);
		if (bCrmUpanddownRel.getId() != null && bCrmUpanddownRel.getId().length() > 0) {
			cri.andIdEqualTo(bCrmUpanddownRel.getId());
			UserInfo user = ContextHolder.getUserInfo();
			String userId = user.getTlrNo();
			bCrmUpanddownRel2.setLastUpdTlrcd(userId); // 最后更新人
			bCrmUpanddownRel2.setLastUpdTime(new Date());// 最后更新时间
			BctlVO bctlVO = ContextHolder.getOrgInfo();// 获取机构信息
			String brcode = bctlVO.getBrNo();
			bCrmUpanddownRel2.setLastUpdBrcode(brcode);// 设置最后更新机构
			try {
				return iBCrmUpanddownRelDAO.updateByExampleSelective(bCrmUpanddownRel2, bbie);
			} catch (Exception e) {
				log.error("上下游关联关系修改失败！");
				throw new ScubeBizException("上下游关联关系修改失败！", e);
			}
		} else {// 没有ID无法修改
			throw new ScubeBizException("所传数据无ID，上下游关联关系修改失败！");
		}
	}

	// 查询上下游关联关系，返回单个对象。（无条件查询，返回空值。）
	// 这里要注意，当页面修改操作的时候，会将页面数据到数据库进行查询，此时，里面不能有ID，否则无法实现去重。
	// 因为当页面传过来ID，数据库里面是不可能存在相同的ID的数据的。
	@Override
	public BCrmUpanddownRel findBCrmUpanddownRelByKey(BCrmUpanddownRel bCrmUpanddownRel) {
		BCrmUpanddownRelExample bbie = new BCrmUpanddownRelExample();
		com.huateng.scf.bas.crm.dao.model.BCrmUpanddownRelExample.Criteria cri = bbie.createCriteria();
		if (bCrmUpanddownRel != null && !"".equals(bCrmUpanddownRel)) {
			// 根据ID查询
			if (bCrmUpanddownRel.getId() != null && !"".equals(bCrmUpanddownRel.getId())) {
				cri.andIdEqualTo(bCrmUpanddownRel.getId());
			}
			// 核心厂商客户号
			if (bCrmUpanddownRel.getCoreCustcd() != null && !"".equals(bCrmUpanddownRel.getCoreCustcd())) {
				cri.andCoreCustcdEqualTo(bCrmUpanddownRel.getCoreCustcd());
			}
			// 客户号
			if (bCrmUpanddownRel.getCustcd() != null && !"".equals(bCrmUpanddownRel.getCustcd())) {
				cri.andCustcdEqualTo(bCrmUpanddownRel.getCustcd());
			}
			// 添加状态state
			if (bCrmUpanddownRel.getState() != null && !"".equals(bCrmUpanddownRel.getState())) {
				cri.andStateEqualTo(bCrmUpanddownRel.getState());
			}
			// 添加组织机构代码orgCode
			if (bCrmUpanddownRel.getOrgCode() != null && !"".equals(bCrmUpanddownRel.getOrgCode())) {
				cri.andOrgCodeEqualTo(bCrmUpanddownRel.getOrgCode());
			}
			// 添加与核心厂商关系coreRelationFlg
			if (bCrmUpanddownRel.getCoreRelationFlg() != null && !"".equals(bCrmUpanddownRel.getCoreRelationFlg())) {
				cri.andCoreRelationFlgEqualTo(bCrmUpanddownRel.getCoreRelationFlg());
			}

			BCrmUpanddownRel bCrmUpanddownRel2 = new BCrmUpanddownRel();
			List<com.huateng.scf.bas.crm.dao.model.BCrmUpanddownRel> bCrmUpanddownRels = iBCrmUpanddownRelDAO.selectByExample(bbie);
			if (bCrmUpanddownRels != null && bCrmUpanddownRels.size() > 0) {
				try {
					com.huateng.scf.bas.crm.dao.model.BCrmUpanddownRel bCrmUpanddownRel1 = bCrmUpanddownRels.get(0);
					BeanUtils.copyProperties(bCrmUpanddownRel1, bCrmUpanddownRel2);
					// 客户名称转译
					try {
						BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
						bCrmBaseInfo.setCustcd(bCrmUpanddownRel2.getCustcd());
						BCrmBaseInfo baseInfo2 = iBCrmBaseInfoService.findBCrmBaseInfoByKey(bCrmBaseInfo);
						if (baseInfo2 != null && !"".equals(baseInfo2)) {
							bCrmUpanddownRel2.setCname(baseInfo2.getCname());
						} else {
							throw new ScubeBizException("该客户号无对应客户名称！");
						}
					} catch (Exception e) {
						throw new ScubeBizException("上下游关系条件分页查询，客户号转译失败！");
					}

					// 核心客户厂商名称转译
					try {
						BCrmBaseInfo bCrmBaseInfo2 = new BCrmBaseInfo();
						bCrmBaseInfo2.setCustcd(bCrmUpanddownRel2.getCoreCustcd());
						BCrmBaseInfo baseInfo3 = iBCrmBaseInfoService.findBCrmBaseInfoByKey(bCrmBaseInfo2);
						if (baseInfo3 != null && !"".equals(baseInfo3)) {
							bCrmUpanddownRel2.setCoreCustName(baseInfo3.getCname());
						} else {
							throw new ScubeBizException("该核心客户号无对应客户名称！");
						}
					} catch (Exception e) {
						throw new ScubeBizException("上下游关系条件分页查询，核心客户号转译失败！");
					}

					// 翻译，创建人tlrcd，最后更新操作员lastUpdTlrcd，经办机构brcode，最后更新经办机构lastUpdBrcode
					try {
						UserInfo userInfo1 = new UserInfo();
						userInfo1.setTlrNo(bCrmUpanddownRel2.getTlrcd());// 搜索创建人对应的名称。
						List<TlrInfoVO> userList = userService.selectByExample(userInfo1);
						if (userList != null && userList.size() == 1) {
							bCrmUpanddownRel2.setTlrName(userList.get(0).getTlrName());// 将查询结果赋值于页面创建人代码。
						} else {
							throw new ScubeBizException("不存在此创建操作员！");
						}
					} catch (Exception e) {
						throw new ScubeBizException("上下游关系条件分页查询，经办人转译失败！");
					}

					// 最后更新操作员lastUpdTlrName
					try {
						UserInfo userInfo2 = new UserInfo();
						userInfo2.setTlrNo(bCrmUpanddownRel2.getLastUpdTlrcd());// 搜索最后更新操作员对应的名称。
						List<TlrInfoVO> userList2 = userService.selectByExample(userInfo2);
						if (userList2 != null && userList2.size() == 1) {
							bCrmUpanddownRel2.setLastUpdTlrName(userList2.get(0).getTlrName());// 将查询结果赋值于页面创建人代码。
						} else {
							throw new ScubeBizException("不存在此最后更新操作员！");
						}
					} catch (Exception e) {
						throw new ScubeBizException("上下游关系条件分页查询，最后更新操作员转译失败！");
					}

					// 经办机构brName
					try {
						BctlVO bctlVO = new BctlVO();
						bctlVO.setBrNo(bCrmUpanddownRel2.getBrcode());
						List<BctlVO> bctlVOList = orgService.selectByExample(bctlVO);
						if (bctlVOList != null && bctlVOList.size() == 1) {
							bCrmUpanddownRel2.setBrName(bctlVOList.get(0).getBrName());
						} else {
							throw new ScubeBizException("经办机构代码无法取到经办机构名称！");
						}
					} catch (Exception e) {
						throw new ScubeBizException("上下游关系条件分页查询，经办机构转译失败！");
					}

					// 最后更新经办机构lastUpdBrName
					try {
						BctlVO bctlVO2 = new BctlVO();
						bctlVO2.setBrNo(bCrmUpanddownRel2.getLastUpdBrcode());
						List<BctlVO> bctlVOList2 = orgService.selectByExample(bctlVO2);
						if (bctlVOList2 != null && bctlVOList2.size() == 1) {
							bCrmUpanddownRel2.setLastUpdBrName(bctlVOList2.get(0).getBrName());
						} else {
							throw new ScubeBizException("最后更新经办机构代码无法取到经办机构名称！");
						}
					} catch (Exception e) {
						throw new ScubeBizException("上下游关系条件分页查询，最后更新经办机构转译失败！");
					}
					return bCrmUpanddownRel2;
				} catch (Exception e) {
					throw new ScubeBizException("查询上下游关联关系失败！");
				}
			} else {
				// 没有查询到对象
				return null;
			}
		} else {
			// 无条件查询，返回空值。
			return null;
		}
	}

	// 查询上下游关联关系，返回对象集合。(暂时用不到)
	@Override
	public List<BCrmUpanddownRel> findBCrmUpanddownRelByBCrm(BCrmUpanddownRel bCrmUpanddownRel) {
		BCrmUpanddownRelExample example = new BCrmUpanddownRelExample();
		com.huateng.scf.bas.crm.dao.model.BCrmUpanddownRelExample.Criteria cri = example.createCriteria();
		if (bCrmUpanddownRel != null) {
			// 根据ID查询
			if (bCrmUpanddownRel.getId() != null && !"".equals(bCrmUpanddownRel.getId())) {
				cri.andIdEqualTo(bCrmUpanddownRel.getId());
			}
			// 核心厂商客户号
			if (bCrmUpanddownRel.getCoreCustcd() != null && !"".equals(bCrmUpanddownRel.getCoreCustcd())) {
				cri.andCoreCustcdEqualTo(bCrmUpanddownRel.getCoreCustcd());
			}
			// 客户号
			if (bCrmUpanddownRel.getCustcd() != null && !"".equals(bCrmUpanddownRel.getCustcd())) {
				cri.andCustcdEqualTo(bCrmUpanddownRel.getCustcd());
			}
			// 添加状态state
			if (bCrmUpanddownRel.getState() != null && !"".equals(bCrmUpanddownRel.getState())) {
				cri.andStateEqualTo(bCrmUpanddownRel.getState());
			}
			// 添加组织机构代码orgCode
			if (bCrmUpanddownRel.getOrgCode() != null && !"".equals(bCrmUpanddownRel.getOrgCode())) {
				cri.andOrgCodeEqualTo(bCrmUpanddownRel.getOrgCode());
			}
			// 添加与核心厂商关系coreRelationFlg
			if (bCrmUpanddownRel.getCoreRelationFlg() != null && !"".equals(bCrmUpanddownRel.getCoreRelationFlg())) {
				cri.andCoreRelationFlgEqualTo(bCrmUpanddownRel.getCoreRelationFlg());
			}

		}
		try {
			List<com.huateng.scf.bas.crm.dao.model.BCrmUpanddownRel> iBCrmUpanddownRelList = iBCrmUpanddownRelDAO.selectByExample(example);
			List<BCrmUpanddownRel> bCrmUpanddownRellist = new ArrayList<BCrmUpanddownRel>();
			for (com.huateng.scf.bas.crm.dao.model.BCrmUpanddownRel bCrmUpanddownRel1 : iBCrmUpanddownRelList) {
				BCrmUpanddownRel bCrmUpanddownRel2 = new BCrmUpanddownRel();
				BeanUtils.copyProperties(bCrmUpanddownRel1, bCrmUpanddownRel2);
				// 客户名称转译
				try {
					BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
					bCrmBaseInfo.setCustcd(bCrmUpanddownRel2.getCustcd());
					BCrmBaseInfo baseInfo2 = iBCrmBaseInfoService.findBCrmBaseInfoByKey(bCrmBaseInfo);
					if (baseInfo2 != null && !"".equals(baseInfo2)) {
						bCrmUpanddownRel2.setCname(baseInfo2.getCname());
					} else {
						throw new ScubeBizException("该客户号无对应客户名称！");
					}
				} catch (Exception e) {
					throw new ScubeBizException("上下游关系条件分页查询，客户号转译失败！");
				}

				// 核心客户厂商名称转译
				try {
					BCrmBaseInfo bCrmBaseInfo2 = new BCrmBaseInfo();
					bCrmBaseInfo2.setCustcd(bCrmUpanddownRel2.getCoreCustcd());
					BCrmBaseInfo baseInfo3 = iBCrmBaseInfoService.findBCrmBaseInfoByKey(bCrmBaseInfo2);
					if (baseInfo3 != null && !"".equals(baseInfo3)) {
						bCrmUpanddownRel2.setCoreCustName(baseInfo3.getCname());
					} else {
						throw new ScubeBizException("该核心客户号无对应客户名称！");
					}
				} catch (Exception e) {
					throw new ScubeBizException("上下游关系条件分页查询，核心客户号转译失败！");
				}

				// 翻译，创建人tlrcd，最后更新操作员lastUpdTlrcd，经办机构brcode，最后更新经办机构lastUpdBrcode
				try {
					UserInfo userInfo1 = new UserInfo();
					userInfo1.setTlrNo(bCrmUpanddownRel2.getTlrcd());// 搜索创建人对应的名称。
					List<TlrInfoVO> userList = userService.selectByExample(userInfo1);
					if (userList != null && userList.size() == 1) {
						bCrmUpanddownRel2.setTlrName(userList.get(0).getTlrName());// 将查询结果赋值于页面创建人代码。
					} else {
						throw new ScubeBizException("不存在此创建操作员！");
					}
				} catch (Exception e) {
					throw new ScubeBizException("上下游关系条件分页查询，经办人转译失败！");
				}

				// 最后更新操作员lastUpdTlrName
				try {
					UserInfo userInfo2 = new UserInfo();
					userInfo2.setTlrNo(bCrmUpanddownRel2.getLastUpdTlrcd());// 搜索最后更新操作员对应的名称。
					List<TlrInfoVO> userList2 = userService.selectByExample(userInfo2);
					if (userList2 != null && userList2.size() == 1) {
						bCrmUpanddownRel2.setLastUpdTlrName(userList2.get(0).getTlrName());// 将查询结果赋值于页面创建人代码。
					} else {
						throw new ScubeBizException("不存在此最后更新操作员！");
					}
				} catch (Exception e) {
					throw new ScubeBizException("上下游关系条件分页查询，最后更新操作员转译失败！");
				}

				// 经办机构brName
				try {
					BctlVO bctlVO = new BctlVO();
					bctlVO.setBrNo(bCrmUpanddownRel2.getBrcode());
					List<BctlVO> bctlVOList = orgService.selectByExample(bctlVO);
					if (bctlVOList != null && bctlVOList.size() == 1) {
						bCrmUpanddownRel2.setBrName(bctlVOList.get(0).getBrName());
					} else {
						throw new ScubeBizException("经办机构代码无法取到经办机构名称！");
					}
				} catch (Exception e) {
					throw new ScubeBizException("上下游关系条件分页查询，经办机构转译失败！");
				}

				// 最后更新经办机构lastUpdBrName
				try {
					BctlVO bctlVO2 = new BctlVO();
					bctlVO2.setBrNo(bCrmUpanddownRel2.getLastUpdBrcode());
					List<BctlVO> bctlVOList2 = orgService.selectByExample(bctlVO2);
					if (bctlVOList2 != null && bctlVOList2.size() == 1) {
						bCrmUpanddownRel2.setLastUpdBrName(bctlVOList2.get(0).getBrName());
					} else {
						throw new ScubeBizException("最后更新经办机构代码无法取到经办机构名称！");
					}
				} catch (Exception e) {
					throw new ScubeBizException("上下游关系条件分页查询，最后更新经办机构转译失败！");
				}
				bCrmUpanddownRellist.add(bCrmUpanddownRel2);
			}
			return bCrmUpanddownRellist;
		} catch (Exception e) {
			throw new ScubeBizException("查询上下游关联关系集合失败！");
		}
	}

	// 查询上下游关联关系，返回分页对象。（不按照ID来查询）
	@Override
	public Page findBCrmUpanddownRelByPage(int pageNo, int pageSize, BCrmUpanddownRel bCrmUpanddownRel) {
		Page p = new Page(pageSize, pageNo, 0);
		BCrmUpanddownRelExample example = new BCrmUpanddownRelExample();
		com.huateng.scf.bas.crm.dao.model.BCrmUpanddownRelExample.Criteria cri = example.createCriteria();
		if (bCrmUpanddownRel != null) {
			// 根据ID查询
			if (bCrmUpanddownRel.getId() != null && !"".equals(bCrmUpanddownRel.getId())) {
				cri.andIdEqualTo(bCrmUpanddownRel.getId());
			}
			// 核心厂商客户号
			if (bCrmUpanddownRel.getCoreCustcd() != null && !"".equals(bCrmUpanddownRel.getCoreCustcd())) {
				cri.andCoreCustcdLike("%" + bCrmUpanddownRel.getCoreCustcd() + "%");
			}
			// 客户号
			if (bCrmUpanddownRel.getCustcd() != null && !"".equals(bCrmUpanddownRel.getCustcd())) {
				cri.andCustcdEqualTo(bCrmUpanddownRel.getCustcd());
			}
			// 添加状态state
			if (bCrmUpanddownRel.getState() != null && !"".equals(bCrmUpanddownRel.getState())) {
				cri.andStateEqualTo(bCrmUpanddownRel.getState());
			}
			// 添加组织机构代码orgCode
			if (bCrmUpanddownRel.getOrgCode() != null && !"".equals(bCrmUpanddownRel.getOrgCode())) {
				cri.andOrgCodeEqualTo(bCrmUpanddownRel.getOrgCode());
			}
			// 添加与核心厂商关系coreRelationFlg
			if (bCrmUpanddownRel.getCoreRelationFlg() != null && !"".equals(bCrmUpanddownRel.getCoreRelationFlg())) {
				cri.andCoreRelationFlgEqualTo(bCrmUpanddownRel.getCoreRelationFlg());
			}
		}
		String errorMseeage = "";
		try {

			List<com.huateng.scf.bas.crm.dao.model.BCrmUpanddownRel> listUpAndDown = iBCrmUpanddownRelDAO.selectByPage(example, p);
			List<BCrmUpanddownRel> bCrmUpanddownRellist = new ArrayList<BCrmUpanddownRel>();
			if (listUpAndDown != null && listUpAndDown.size() > 0) {
				for (com.huateng.scf.bas.crm.dao.model.BCrmUpanddownRel bCrmUpanddownRel1 : listUpAndDown) {
					BCrmUpanddownRel bCrmUpanddownRel2 = new BCrmUpanddownRel();
					BeanUtils.copyProperties(bCrmUpanddownRel1, bCrmUpanddownRel2);
					// 客户名称转译
					try {
						BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
						bCrmBaseInfo.setCustcd(bCrmUpanddownRel2.getCustcd());
						BCrmBaseInfo baseInfo2 = iBCrmBaseInfoService.findBCrmBaseInfoByKey(bCrmBaseInfo);
						if (baseInfo2 != null && !"".equals(baseInfo2)) {
							bCrmUpanddownRel2.setCname(baseInfo2.getCname());
						} else {
							throw new ScubeBizException("该客户号无对应客户名称！");
						}
					} catch (Exception e) {
						if (bCrmUpanddownRel2.getCustcd() == null) {
							errorMseeage = "id为" + bCrmUpanddownRel2.getId() + "上下游关系信息客户号为空！";
						} else {
							errorMseeage = "客户号" + bCrmUpanddownRel2.getCustcd() + "对应客户信息查询失败！";
						}
						throw new ScubeBizException("上下游关系条件分页查询，客户号转译失败！");
					}

					// 核心客户厂商名称转译
					try {
						BCrmBaseInfo bCrmBaseInfo2 = new BCrmBaseInfo();
						bCrmBaseInfo2.setCustcd(bCrmUpanddownRel2.getCoreCustcd());
						BCrmBaseInfo baseInfo3 = iBCrmBaseInfoService.findBCrmBaseInfoByKey(bCrmBaseInfo2);
						if (baseInfo3 != null && !"".equals(baseInfo3)) {
							bCrmUpanddownRel2.setCoreCustName(baseInfo3.getCname());
						} else {
							throw new ScubeBizException("该核心客户号无对应客户名称！");
						}
					} catch (Exception e) {
						if (bCrmUpanddownRel2.getCoreCustcd() == null) {
							errorMseeage = "id为" + bCrmUpanddownRel2.getId() + "上下游关系信息核心客户号为空！";
						} else {
							errorMseeage = "核心客户号" + bCrmUpanddownRel2.getCoreCustcd() + "对应核心客户信息查询失败！";
						}
						throw new ScubeBizException("上下游关系条件分页查询，核心客户号转译失败！");
					}

					// 翻译，创建人tlrcd，最后更新操作员lastUpdTlrcd，经办机构brcode，最后更新经办机构lastUpdBrcode
					try {
						UserInfo userInfo1 = new UserInfo();
						userInfo1.setTlrNo(bCrmUpanddownRel2.getTlrcd());// 搜索创建人对应的名称。
						List<TlrInfoVO> userList = userService.selectByExample(userInfo1);
						if (userList != null && userList.size() == 1) {
							bCrmUpanddownRel2.setTlrName(userList.get(0).getTlrName());// 将查询结果赋值于页面创建人代码。
						} else {
							throw new ScubeBizException("不存在此创建操作员！");
						}
					} catch (Exception e) {
						if (bCrmUpanddownRel2.getTlrcd() == null) {
							errorMseeage = "id为" + bCrmUpanddownRel2.getId() + "上下游关系信息经办人信息为空！";
						} else {
							errorMseeage = "经办人" + bCrmUpanddownRel2.getTlrcd() + "对应信息查询失败！";
						}
						throw new ScubeBizException("上下游关系条件分页查询，经办人转译失败！");
					}

					// 最后更新操作员lastUpdTlrName
					try {
						UserInfo userInfo2 = new UserInfo();
						userInfo2.setTlrNo(bCrmUpanddownRel2.getLastUpdTlrcd());// 搜索最后更新操作员对应的名称。
						List<TlrInfoVO> userList2 = userService.selectByExample(userInfo2);
						if (userList2 != null && userList2.size() == 1) {
							bCrmUpanddownRel2.setLastUpdTlrName(userList2.get(0).getTlrName());// 将查询结果赋值于页面创建人代码。
						} else {
							throw new ScubeBizException("不存在此最后更新操作员！");
						}
					} catch (Exception e) {
						if (bCrmUpanddownRel2.getLastUpdTlrcd() == null) {
							errorMseeage = "id为" + bCrmUpanddownRel2.getId() + "上下游关系信息最后更新操作员信息为空！";
						} else {
							errorMseeage = "最后更新操作员" + bCrmUpanddownRel2.getLastUpdTlrcd() + "对应信息查询失败！";
						}
						throw new ScubeBizException("上下游关系条件分页查询，最后更新操作员转译失败！");
					}

					// 经办机构brName
					try {
						BctlVO bctlVO = new BctlVO();
						bctlVO.setBrNo(bCrmUpanddownRel2.getBrcode());
						List<BctlVO> bctlVOList = orgService.selectByExample(bctlVO);
						if (bctlVOList != null && bctlVOList.size() == 1) {
							bCrmUpanddownRel2.setBrName(bctlVOList.get(0).getBrName());
						} else {
							throw new ScubeBizException("经办机构代码无法取到经办机构名称！");
						}
					} catch (Exception e) {
						if (bCrmUpanddownRel2.getBrcode() == null) {
							errorMseeage = "id为" + bCrmUpanddownRel2.getId() + "上下游关系信息经办机构信息为空！";
						} else {
							errorMseeage = "经办机构号为" + bCrmUpanddownRel2.getBrcode() + "对应信息查询失败！";
						}
						throw new ScubeBizException("上下游关系条件分页查询，经办机构转译失败！");
					}

					// 最后更新经办机构lastUpdBrName
					try {
						BctlVO bctlVO2 = new BctlVO();
						bctlVO2.setBrNo(bCrmUpanddownRel2.getLastUpdBrcode());
						List<BctlVO> bctlVOList2 = orgService.selectByExample(bctlVO2);
						if (bctlVOList2 != null && bctlVOList2.size() == 1) {
							bCrmUpanddownRel2.setLastUpdBrName(bctlVOList2.get(0).getBrName());
						} else {
							throw new ScubeBizException("最后更新经办机构代码无法取到经办机构名称！");
						}
					} catch (Exception e) {
						if (bCrmUpanddownRel2.getLastUpdBrcode() == null) {
							errorMseeage = "id为" + bCrmUpanddownRel2.getId() + "上下游关系信息最后更新经办机构信息为空！";
						} else {
							errorMseeage = "经办机构号为" + bCrmUpanddownRel2.getLastUpdBrcode() + "对应信息查询失败！";
						}
						throw new ScubeBizException("上下游关系条件分页查询，最后更新经办机构转译失败！");
					}
					bCrmUpanddownRellist.add(bCrmUpanddownRel2);
				}
				p.setRecords(bCrmUpanddownRellist);
				return p;
			} else {// 查不到数据，就直接返回空值。
				p.setRecords(listUpAndDown);
				return p;
			}
		} catch (Exception e) {
			if (!errorMseeage.equals("")) {
				throw new ScubeBizException("页面数据有误，" + errorMseeage);
			} else {
				throw new ScubeBizException("分页条件查询上下游关联关系对象失败！");
			}
		}

	}

}
