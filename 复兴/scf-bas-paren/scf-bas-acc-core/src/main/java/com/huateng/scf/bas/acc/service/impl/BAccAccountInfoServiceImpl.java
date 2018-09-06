/**
 * 
 */
package com.huateng.scf.bas.acc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import com.huateng.scf.bas.acc.dao.IBAccAccountInfoDAO;
import com.huateng.scf.bas.acc.dao.model.BAccAccountInfoExample;
import com.huateng.scf.bas.acc.model.BAccAccountInfo;
import com.huateng.scf.bas.acc.service.IBAccAccountInfoService;
import com.huateng.scf.bas.common.model.CustAccountQryVO;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年11月22日下午1:39:20
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年11月22日下午1:39:20	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("IBAccAccountInfoServiceImpl")
public class BAccAccountInfoServiceImpl implements IBAccAccountInfoService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "BAccAccountInfoDAO")
	IBAccAccountInfoDAO iBAccAccountInfoDAO;
	@Resource(name = "userService")
	UserService userService;
	@Resource(name = "orgService")
	OrgService orgService;
	@Resource(name = "bCrmBaseInfoService")
	IBCrmBaseInfoService iBCrmBaseInfoService;

	// 账户信息新增
	@Override
	@Transactional
	public String add(BAccAccountInfo bAccAccountInfo) {
		// 设置公共字段,创建人tlrcd,crtTime创建时间,lastUpdTlrcd最后更新操作员,lastUpdTime最后更新时间，lastUpdBrcode最后更新机构
		ScfCommonUtil.setCommonField(bAccAccountInfo);
		com.huateng.scf.bas.acc.dao.model.BAccAccountInfo bAccAccountInfo2 = new com.huateng.scf.bas.acc.dao.model.BAccAccountInfo();
		BeanUtils.copyProperties(bAccAccountInfo, bAccAccountInfo2);
		bAccAccountInfo2.setStatus("1");// 设置状态为有效
		bAccAccountInfo2.setBrcode(ContextHolder.getOrgInfo().getBrNo());// 设置经办机构信息
		bAccAccountInfo2.setMgrno(bAccAccountInfo2.getTlrcd());// 管户员
		bAccAccountInfo2.setId(UUIDGeneratorUtil.generate());
		try {
			iBAccAccountInfoDAO.insert(bAccAccountInfo2);
			return null;
		} catch (Exception e) {
			log.error("账户信息新增失败！");
			throw new ScubeBizException("账户信息新增失败！", e);
		}
	}

	// 账户信息新增
	@Override
	@Transactional
	public String addBAccAccountInfo(BAccAccountInfo bAccAccountInfo) {
		if (bAccAccountInfo.getCname() == null || "".equals(bAccAccountInfo.getCname())) {
			throw new ScubeBizException("前台所传数据无效!");
		}
		// 前台客户名称检验（是否是客户手输的，不是通过下拉菜单选择的。）
		BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
		bCrmBaseInfo.setCname(bAccAccountInfo.getCname());
		bCrmBaseInfo.setCustcd(bAccAccountInfo.getCustcd());
		int checkCustomerForSelect = iBCrmBaseInfoService.checkCustomerForSelect(bCrmBaseInfo);
		if (checkCustomerForSelect != 1) {
			throw new ScubeBizException("客户名称与客户号不对应，请通过对应的查询按钮选择客户!");
		}
		ScfCommonUtil.setCommonField(bAccAccountInfo);
		com.huateng.scf.bas.acc.dao.model.BAccAccountInfo bAccAccountInfo2 = new com.huateng.scf.bas.acc.dao.model.BAccAccountInfo();
		BeanUtils.copyProperties(bAccAccountInfo, bAccAccountInfo2);
		bAccAccountInfo2.setStatus("1");// 设置状态为有效
		bAccAccountInfo2.setBrcode(ContextHolder.getOrgInfo().getBrNo());// 设置经办机构信息
		bAccAccountInfo2.setMgrno(bAccAccountInfo2.getTlrcd());// 管户员
		bAccAccountInfo2.setId(UUIDGeneratorUtil.generate());
		try {
			iBAccAccountInfoDAO.insert(bAccAccountInfo2);
			return null;
		} catch (Exception e) {
			log.error("账户信息新增失败！");
			throw new ScubeBizException("账户信息新增失败！", e);
		}
	}

	// 账户信息删除（根据Id）
	@Override
	@Transactional
	public int batchDelete(List idList) {
		Iterator<Map<String, Object>> it = idList.iterator();
		List<String> idList2 = new ArrayList<String>();
		while (it.hasNext()) {
			Map<String, Object> row = it.next();
			String id = row.get("id") == null ? "0" : row.get("id").toString();
			idList2.add(id);
		}
		try {
			return iBAccAccountInfoDAO.batchDelete(idList2);
		} catch (Exception e) {
			log.error("账户信息删除失败！");
			throw new ScubeBizException("账户信息删除失败！", e);
		}

	}

	// 删除账户信息（根据客户号）
	@Override
	@Transactional
	public int batchDeleteBAccAccountInfoByCustcd(BAccAccountInfo bAccAccountInfo) {
		// 1.校验数据
		if (bAccAccountInfo == null || "".equals(bAccAccountInfo)) {
			throw new ScubeBizException("账户信息删除,前台所传数据无效!");
		}
		// 2.查询有没有对应数据
		BAccAccountInfoExample bAccAccountInfoExample = new BAccAccountInfoExample();
		if (bAccAccountInfo.getCustcd() != null && !"".equals(bAccAccountInfo.getCustcd())) {
			bAccAccountInfoExample.createCriteria().andCustcdEqualTo(bAccAccountInfo.getCustcd());
		} else {
			throw new ScubeBizException("账户信息删除,前台所传数据无效!");
		}
		try {
			List<com.huateng.scf.bas.acc.dao.model.BAccAccountInfo> bAccAccountInfoList = iBAccAccountInfoDAO.selectByExample(bAccAccountInfoExample);
			// 3.如果有，才删除，没有返回0.
			if (bAccAccountInfoList != null && bAccAccountInfoList.size() > 0) {
				try {
					return iBAccAccountInfoDAO.deleteByExample(bAccAccountInfoExample);
				} catch (Exception e) {
					throw new ScubeBizException("账户信息删除失败！");
				}
			} else {
				return 0;
			}
		} catch (Exception e) {
			throw new ScubeBizException("账户信息删除,查询对应账户信息失败!");
		}

	}

	// 账户信息修改(这里是应该使用ID修改,因为账号并不是唯一标识。)
	@Override
	@Transactional
	public int update(BAccAccountInfo bAccAccountInfo) {
		if (bAccAccountInfo.getCname() == null || "".equals(bAccAccountInfo.getCname())) {
			throw new ScubeBizException("前台所传数据无效!");
		}
		// 前台客户名称检验（是否是客户手输的，不是通过下拉菜单选择的。）
		BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
		bCrmBaseInfo.setCname(bAccAccountInfo.getCname());
		bCrmBaseInfo.setCustcd(bAccAccountInfo.getCustcd());
		int checkCustomerForSelect = iBCrmBaseInfoService.checkCustomerForSelect(bCrmBaseInfo);
		if (checkCustomerForSelect != 1) {
			throw new ScubeBizException("客户名称与客户号不对应，请通过对应的查询按钮选择客户!");
		}
		com.huateng.scf.bas.acc.dao.model.BAccAccountInfo bAccAccountInfo2 = new com.huateng.scf.bas.acc.dao.model.BAccAccountInfo();
		BeanUtils.copyProperties(bAccAccountInfo, bAccAccountInfo2);
		BAccAccountInfoExample bbie = new BAccAccountInfoExample();
		com.huateng.scf.bas.acc.dao.model.BAccAccountInfoExample.Criteria cri = bbie.createCriteria();
		if (bAccAccountInfo != null && !"".equals(bAccAccountInfo)) {
			if (bAccAccountInfo.getId() != null && bAccAccountInfo.getId().length() > 0) {
				cri.andIdEqualTo(bAccAccountInfo.getId());
				// lastUpdTlrcd最后更新操作员,lastUpdTime最后更新时间，lastUpdBrcode最后更新机构
				UserInfo user = ContextHolder.getUserInfo();
				String userId = user.getTlrNo();
				bAccAccountInfo2.setLastUpdTlrcd(userId); // 最后更新人
				bAccAccountInfo2.setLastUpdTime(new Date());// 最后更新时间
				BctlVO bctlVO = ContextHolder.getOrgInfo();// 获取机构信息
				String brcode = bctlVO.getBrNo();
				bAccAccountInfo2.setLastUpdBrcode(brcode);// 设置最后更新机构
				try {
					return iBAccAccountInfoDAO.updateByExampleSelective(bAccAccountInfo2, bbie);
				} catch (Exception e) {
					log.error("账户信息修改修改失败！");
					throw new ScubeBizException("账户信息修改修改失败！", e);
				}
			} else {// 传过来的值里面没有客户号。
				throw new ScubeBizException("所传账户信息不含ID！");
			}
		} else {
			throw new ScubeBizException("所传账户信息为空！");
		}

	}

	// 查询账户信息（根据账号，账户类型，客户号,账户名称，没有条件就返回为空。）
	@Override
	public BAccAccountInfo findBAccAccountInfoByKey(BAccAccountInfo bAccAccountInfo) {
		BAccAccountInfoExample bbie = new BAccAccountInfoExample();
		com.huateng.scf.bas.acc.dao.model.BAccAccountInfoExample.Criteria cri = bbie.createCriteria();
		if (bAccAccountInfo != null && !"".equals(bAccAccountInfo)) {
			// 客户号
			if (bAccAccountInfo.getCustcd() != null && !"".equals(bAccAccountInfo.getCustcd())) {
				cri.andCustcdEqualTo(bAccAccountInfo.getCustcd());
			}
			// 帐号
			if (bAccAccountInfo.getAccountNo() != null && !"".equals(bAccAccountInfo.getAccountNo())) {
				cri.andAccountNoLike("%" + bAccAccountInfo.getAccountNo() + "%");
			}
			// 账户类型
			if (bAccAccountInfo.getAccountType() != null && !"".equals(bAccAccountInfo.getAccountType())) {
				cri.andAccountTypeEqualTo(bAccAccountInfo.getAccountType());
			}
			// 账户名称
			if (bAccAccountInfo.getAccountName() != null && !"".equals(bAccAccountInfo.getAccountName())) {
				cri.andAccountNameLike("%" + bAccAccountInfo.getAccountName() + "%");
			}
			try {
				BAccAccountInfo bAccAccountInfo2 = new BAccAccountInfo();
				List<com.huateng.scf.bas.acc.dao.model.BAccAccountInfo> bAccAccountInfos = iBAccAccountInfoDAO.selectByExample(bbie);
				if (bAccAccountInfos != null && bAccAccountInfos.size() > 0) {
					com.huateng.scf.bas.acc.dao.model.BAccAccountInfo bAccAccountInfo1 = bAccAccountInfos.get(0);
					BeanUtils.copyProperties(bAccAccountInfo1, bAccAccountInfo2);
					return bAccAccountInfo2;
				} else {
					// 没有查询到对象
					return null;
				}
			} catch (Exception e) {
				throw new ScubeBizException("查询账户信息失败！");
			}
		} else {
			// 无条件查询，返回空值。
			return null;
		}
	}

	// 查询账户信息集合（传过来的条件查不到 ，返回空值。）
	@Override
	public List<BAccAccountInfo> findBAccAccountInfoByBAcc(BAccAccountInfo bAccAccountInfo) {
		BAccAccountInfoExample bbie = new BAccAccountInfoExample();
		com.huateng.scf.bas.acc.dao.model.BAccAccountInfoExample.Criteria cri = bbie.createCriteria();
		if (bAccAccountInfo != null && !"".equals(bAccAccountInfo)) {
			// 客户号
			if (bAccAccountInfo.getCustcd() != null && !"".equals(bAccAccountInfo.getCustcd())) {
				cri.andCustcdEqualTo(bAccAccountInfo.getCustcd());
			}
			// 帐号
			if (bAccAccountInfo.getAccountNo() != null && !"".equals(bAccAccountInfo.getAccountNo())) {
				cri.andAccountNoLike("%" + bAccAccountInfo.getAccountNo() + "%");
			}
			// 账户类型
			if (bAccAccountInfo.getAccountType() != null && !"".equals(bAccAccountInfo.getAccountType())) {
				cri.andAccountTypeEqualTo(bAccAccountInfo.getAccountType());
			}
			// 账户名称
			if (bAccAccountInfo.getAccountName() != null && !"".equals(bAccAccountInfo.getAccountName())) {
				cri.andAccountNameLike("%" + bAccAccountInfo.getAccountName() + "%");
			}
			try {
				List<com.huateng.scf.bas.acc.dao.model.BAccAccountInfo> accountList = iBAccAccountInfoDAO.selectByExample(bbie);
				List<BAccAccountInfo> bAccAccountInfoList = new ArrayList<BAccAccountInfo>();
				if (accountList != null && accountList.size() > 0) {
					for (com.huateng.scf.bas.acc.dao.model.BAccAccountInfo bAccAccountInfo1 : accountList) {
						BAccAccountInfo bAccAccountInfo2 = new BAccAccountInfo();
						BeanUtils.copyProperties(bAccAccountInfo1, bAccAccountInfo2);
						bAccAccountInfoList.add(bAccAccountInfo2);
					}
				} else {// 查不到数据，返回为空值。
					return null;
				}
				return bAccAccountInfoList;
			} catch (Exception e) {
				throw new ScubeBizException("条件查询账户信息集合失败！");
			}

		} else {// 传过来的数据为空，返回空值
			return null;
		}

	}

	// 分页条件查询账户信息(这里转译经办机构名称，经办人（客户经理实际上也就是创建人）和客户名称。)
	@Override
	public Page findBAccAccountInfoByPage(int pageNo, int pageSize, BAccAccountInfo bAccAccountInfo) {
		Page p = new Page(pageSize, pageNo, 0);
		BAccAccountInfoExample example = new BAccAccountInfoExample();
		com.huateng.scf.bas.acc.dao.model.BAccAccountInfoExample.Criteria cri = example.createCriteria();
		if (bAccAccountInfo != null && !"".equals(bAccAccountInfo)) {
			// 客户号
			if (bAccAccountInfo.getCustcd() != null && !"".equals(bAccAccountInfo.getCustcd())) {
				cri.andCustcdEqualTo(bAccAccountInfo.getCustcd());
			}
			// 帐号
			if (bAccAccountInfo.getAccountNo() != null && !"".equals(bAccAccountInfo.getAccountNo())) {
				cri.andAccountNoLike("%" + bAccAccountInfo.getAccountNo() + "%");
			}
			// 账户类型
			if (bAccAccountInfo.getAccountType() != null && !"".equals(bAccAccountInfo.getAccountType())) {
				cri.andAccountTypeEqualTo(bAccAccountInfo.getAccountType());
			}
			// 账户名称
			if (bAccAccountInfo.getAccountName() != null && !"".equals(bAccAccountInfo.getAccountName())) {
				cri.andAccountNameLike("%" + bAccAccountInfo.getAccountName() + "%");
			}
		}
		String errorMessage = "";
		try {
			List<BAccAccountInfo> bAccAccountInfoList = new ArrayList<BAccAccountInfo>();
			example.setOrderByClause(" LAST_UPD_TIME desc");
			List<com.huateng.scf.bas.acc.dao.model.BAccAccountInfo> records = iBAccAccountInfoDAO.selectByPage(example, p);
			for (com.huateng.scf.bas.acc.dao.model.BAccAccountInfo bAccAccountInfo1 : records) {
				BAccAccountInfo bAccAccountInfo2 = new BAccAccountInfo();
				BeanUtils.copyProperties(bAccAccountInfo1, bAccAccountInfo2);
				// 最后更新经办机构转译
				BctlVO bctlVO = new BctlVO();
				if (bAccAccountInfo2.getLastUpdBrcode() != null) {
					bctlVO.setBrNo(bAccAccountInfo2.getLastUpdBrcode());
					try {
						List<BctlVO> bctlVOList = orgService.selectByExample(bctlVO);
						if (bctlVOList != null && bctlVOList.size() == 1) {
							bAccAccountInfo2.setBrName(bctlVOList.get(0).getBrName());
						} else {
							errorMessage = "账号为" + bAccAccountInfo2.getAccountNo() + "账户信息经办机构信息查询失败！";
							throw new ScubeBizException("经办机构代码无法取到经办机构名称！");
						}
					} catch (Exception e) {
						errorMessage = "账号为" + bAccAccountInfo2.getAccountNo() + "账户信息经办机构信息查询失败！";
						throw new ScubeBizException("账户信息分页查询，转译经办机构信息失败！");
					}
				}

				BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
				if (bAccAccountInfo2.getCustcd() != null) {
					try {
						bCrmBaseInfo.setCustcd(bAccAccountInfo2.getCustcd());
						BCrmBaseInfo baseInfo2 = iBCrmBaseInfoService.findBCrmBaseInfoByKey(bCrmBaseInfo);
						if (baseInfo2 != null && !"".equals(baseInfo2)) {
							bAccAccountInfo2.setCname(baseInfo2.getCname());
						} else {
							errorMessage = "账号为" + bAccAccountInfo2.getAccountNo() + "账户信息客户信息查询失败！";
							throw new ScubeBizException("该客户号无对应客户名称！");
						}
					} catch (Exception e) {
						errorMessage = "账号为" + bAccAccountInfo2.getAccountNo() + "账户信息客户信息查询失败！";
						throw new ScubeBizException("该客户号无对应客户名称！");
					}
				}

				// 管户员（mgrno）客户经理转译,这里使用最后更新操作员
				UserInfo userInfo = new UserInfo();
				if (bAccAccountInfo2.getLastUpdTlrcd() != null) {
					userInfo.setTlrNo(bAccAccountInfo2.getLastUpdTlrcd());// 搜索创建人对应的名称。
					try {
						List<TlrInfoVO> userList = userService.selectByExample(userInfo);
						if (userList != null && userList.size() == 1) {
							bAccAccountInfo2.setMgrName(userList.get(0).getTlrName());// 将查询结果赋值于页面创建人代码。
						} else {
							errorMessage = "账号为" + bAccAccountInfo2.getAccountNo() + "账户信息客户经理信息查询失败！";
							throw new ScubeBizException("不存在此操作员！");
						}
					} catch (Exception e) {
						errorMessage = "账号为" + bAccAccountInfo2.getAccountNo() + "账户信息客户经理信息查询失败！";
						throw new ScubeBizException("不存在此操作员！");
					}
				}
				bAccAccountInfoList.add(bAccAccountInfo2);
			}
			p.setRecords(bAccAccountInfoList);
			return p;
		} catch (Exception e) {
			throw new ScubeBizException("页面数据有误，" + errorMessage, e);
		}
	}

	// 查询经办机构信息（页面下拉菜单）
	@Override
	public Page selectOrgByPage(int pageNo, int pageSize, BctlVO bctlVO) {
		try {
			return orgService.select(pageNo, pageSize, bctlVO);
		} catch (Exception e) {
			log.error("页面查询经办机构信息失败！");
			throw new ScubeBizException("页面查询经办机构信息失败！", e);
		}
	}

	/**
	 * @Description: 账号列表查询
	 * @author mengjiajia
	 * @Created 2013-8-2上午9:55:38
	 * @param custAccountQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public Page getCustAccountListByParam(CustAccountQryVO custAccountQryVO) throws ScubeBizException {
		BAccAccountInfoExample example = new BAccAccountInfoExample();
		BAccAccountInfoExample.Criteria cri = example.createCriteria();
		
		if (!StringUtil.isEmpty(custAccountQryVO.getCustcd())) { // 客户号
			cri.andCustcdEqualTo(custAccountQryVO.getCustcd());
		}

		if (!StringUtil.isEmpty(custAccountQryVO.getAccountType_Q())) { // 账户类型
			cri.andAccountTypeEqualTo(custAccountQryVO.getAccountType_Q());
		}

		if (!StringUtil.isEmpty(custAccountQryVO.getAccountNo_Q())) { // 帐号
			cri.andAccountNoEqualTo(custAccountQryVO.getAccountNo_Q());
		}

		if (!StringUtil.isEmpty(custAccountQryVO.getAccountName_Q())) { // 帐号名称
			cri.andAccountNameLike(custAccountQryVO.getAccountName_Q());
		}

		if (!StringUtil.isEmpty(custAccountQryVO.getId_Q())) {// 客户帐号信息id
			cri.andIdEqualTo(custAccountQryVO.getId_Q());
		}
		
		int total = iBAccAccountInfoDAO.countByExample(example);
		Page page = new Page(custAccountQryVO.getPageSize(), custAccountQryVO.getPageIndex(), 0);
		
		page.setRecords(iBAccAccountInfoDAO.selectByPage(example, page));
		page.setTotalRecord(total);
		return page;
	}
}
