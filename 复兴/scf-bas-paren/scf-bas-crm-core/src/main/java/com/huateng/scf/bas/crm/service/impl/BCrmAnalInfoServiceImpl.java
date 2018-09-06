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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.TlrInfoVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.service.UserService;
import com.huateng.base.common.beans.Page;
import com.huateng.data.util.BDDataUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.dao.IBCrmAnalInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmAnalInfoExample;
import com.huateng.scf.bas.crm.model.BCrmAnalInfo;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.service.IBCrmAnalInfoService;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年11月8日
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao
 *
 *            </pre>
 */
@ScubeService
@Service("IBCrmAnalInfoServiceImpl")
public class BCrmAnalInfoServiceImpl implements IBCrmAnalInfoService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IBCrmAnalInfoDAO")
	IBCrmAnalInfoDAO iBCrmAnalInfoDAO;
	@Resource(name = "userService")
	UserService userService;
	@Resource(name = "bCrmBaseInfoService")
	IBCrmBaseInfoService iBCrmBaseInfoService;

	@Autowired
	BDDataUtil bDDataUtil;

	// 客户分析信息新增
	@Override
	@Transactional
	public String add(BCrmAnalInfo bCrmAnalInfo) {
		com.huateng.scf.bas.crm.dao.model.BCrmAnalInfo bCrmAnalInfo2 = new com.huateng.scf.bas.crm.dao.model.BCrmAnalInfo();
		BeanUtils.copyProperties(bCrmAnalInfo, bCrmAnalInfo2);
		bCrmAnalInfo2.setId(UUIDGeneratorUtil.generate());
		UserInfo user = ContextHolder.getUserInfo();
		bCrmAnalInfo2.setRegister(user.getTlrNo());
		String date1 = ScfDateUtil.formatDate(new Date());
		bCrmAnalInfo2.setAnalDate(date1);// 创建时间
		try {
			iBCrmAnalInfoDAO.insert(bCrmAnalInfo2);
			return null;
		} catch (Exception e) {
			log.error("客户分析信息新增失败！");
			throw new ScubeBizException("客户分析信息新增失败！", e);
		}
	}

	// 客户分析信息单条删除(id)
	@Override
	@Transactional
	public int delete(String id) {
		try {
			return iBCrmAnalInfoDAO.deleteByPrimaryKey(id);
		} catch (Exception e) {
			log.error("客户分析信息删除失败！");
			throw new ScubeBizException("客户分析信息删除失败！", e);
		}
	}

	// 客户分析信息修改
	@Override
	@Transactional
	public int update(BCrmAnalInfo bCrmAnalInfo) {
		com.huateng.scf.bas.crm.dao.model.BCrmAnalInfo bCrmAnalInfo2 = new com.huateng.scf.bas.crm.dao.model.BCrmAnalInfo();
		BeanUtils.copyProperties(bCrmAnalInfo, bCrmAnalInfo2);
		if (bCrmAnalInfo.getId() != null && bCrmAnalInfo.getId().length() > 0) {
			try {
				UserInfo user = ContextHolder.getUserInfo();
				bCrmAnalInfo2.setRegister(user.getTlrNo());// Register
				String date1 = ScfDateUtil.formatDate(new Date());
				bCrmAnalInfo2.setAnalDate(date1);// 分析日期
				return iBCrmAnalInfoDAO.updateByPrimaryKeySelective(bCrmAnalInfo2);
			} catch (Exception e) {
				log.error("客户分析信息修改失败！");
				throw new ScubeBizException("客户分析信息修改失败！", e);
			}
		} else {
			throw new ScubeBizException("客户分析信息修改失败！");
		}
	}

	// 客户分析信息查询，返回分页对象。（根据客户号查询，如果没有对应的，直接返回空值。与之前的分页查询不一样。）
	@Override
	public Page findBCrmAnalInfoByPage(int pageNo, int pageSize, BCrmAnalInfo bCrmAnalInfo) {
		Page p = new Page(pageSize, pageNo, 0);

		BCrmAnalInfoExample example = new BCrmAnalInfoExample();
		String errorMessage = "";
		if (bCrmAnalInfo != null) {
			if (bCrmAnalInfo.getCustcd() != null && bCrmAnalInfo.getCustcd().length() > 0) {
				com.huateng.scf.bas.crm.dao.model.BCrmAnalInfoExample.Criteria criteria = example.createCriteria();
				criteria.andCustcdEqualTo(bCrmAnalInfo.getCustcd());
				try {
					List<com.huateng.scf.bas.crm.dao.model.BCrmAnalInfo> bCrmAnalInfoList = iBCrmAnalInfoDAO.selectByPage(example, p);
					List<BCrmAnalInfo> list2 = new ArrayList<BCrmAnalInfo>();
					for (com.huateng.scf.bas.crm.dao.model.BCrmAnalInfo bCrmAnalInfo1 : bCrmAnalInfoList) {
						BCrmAnalInfo bCrmAnalInfo2 = new BCrmAnalInfo();
						BeanUtils.copyProperties(bCrmAnalInfo1, bCrmAnalInfo2);
						// 客户名称转译
						BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
						bCrmBaseInfo.setCustcd(bCrmAnalInfo2.getCustcd());
						BCrmBaseInfo baseInfo2 = iBCrmBaseInfoService.findBCrmBaseInfoByKey(bCrmBaseInfo);
						if (baseInfo2 != null && !"".equals(baseInfo2)) {
							bCrmAnalInfo2.setCname(baseInfo2.getCname());
						} else {
							errorMessage = "客户信息查询失败！";
							throw new ScubeBizException("该客户号无对应客户！");
						}
						// 翻译，创建人tlrcd，最后更新操作员lastUpdTlrcd，经办机构brcode，最后更新经办机构lastUpdBrcode
						UserInfo userInfo = new UserInfo();
						userInfo.setTlrNo(bCrmAnalInfo2.getRegister());//
						// 搜索创建人对应的名称。
						List<TlrInfoVO> userList = userService.selectByExample(userInfo);
						if (userList != null && userList.size() == 1) {
							bCrmAnalInfo2.setRegisterN(userList.get(0).getTlrName());
							// 将查询结果赋值于页面创建人代码。
						} else {
							errorMessage = "登记人信息查询失败！";
							throw new ScubeBizException("不存在此登记人！");
						}
						list2.add(bCrmAnalInfo2);
					}
					p.setRecords(list2);
					return p;

				} catch (Exception e) {
					if (!errorMessage.equals("")) {
						throw new ScubeBizException(errorMessage, e);
					} else {
						throw new ScubeBizException("分页条件查询客户分析信息失败！", e);
					}

				}
			} else {// 没有客户号，直接返回空值。
				return null;
			}
		} else {// 给了一个空值对象，返回空值。
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.crm.service.IBCrmAnalInfoService#deleteByCustcd(java.
	 * lang.String)
	 */
	@Override
	@Transactional
	public int deleteByCustcd(String custcd) {
		BCrmAnalInfoExample bCrmAnalInfoExample = new BCrmAnalInfoExample();
		bCrmAnalInfoExample.createCriteria().andCustcdEqualTo(custcd);
		try {
			return iBCrmAnalInfoDAO.deleteByExample(bCrmAnalInfoExample);
		} catch (Exception e) {
			log.error("客户分析信息删除失败！");
			throw new ScubeBizException("客户分析信息删除失败！", e);
		}
	}
}
