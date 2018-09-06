/**
 * 
 */
package com.huateng.scf.bas.brp.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.dao.IBBrpCostParamDAO;
import com.huateng.scf.bas.brp.dao.model.BBrpCostParamExample;
import com.huateng.scf.bas.brp.dao.model.BBrpCostParamExample.Criteria;
import com.huateng.scf.bas.brp.model.BBrpCostParam;
import com.huateng.scf.bas.brp.service.IBBrpCostParamService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * 费用参数信息服务实现类
 * </p>
 * 
 * @author lihao
 * @date 2016年12月3日上午11:38:57
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * 
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年12月3日上午11:38:57	      新增
 * 
 *            </pre>
 */
@ScubeService
@Service("BBrpCostParamServiceImpl")
public class BBrpCostParamServiceImpl implements IBBrpCostParamService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BBrpCostParamDAO")
	IBBrpCostParamDAO iBBrpCostParamDAO;

	@Override
	@Transactional
	public String add(BBrpCostParam bBrpCostParam) {
		// 验证是否库中有重复数据
		if (bBrpCostParam != null) {
			if (bBrpCostParam.getCostCode() != null && !bBrpCostParam.getCostCode().isEmpty()) {
				BBrpCostParamExample example = new BBrpCostParamExample();
				Criteria criteria = example.createCriteria();
				criteria.andCostCodeEqualTo(bBrpCostParam.getCostCode());
				List<com.huateng.scf.bas.brp.dao.model.BBrpCostParam> list = iBBrpCostParamDAO.selectByExample(example);
				if (list != null && list.size() > 0) {
					throw new ScubeBizException("费用参数信息已存在，不可新增");
				}
			}
			// 对复选框字段进行处理
			checkBoxFormat(bBrpCostParam);
		}

		com.huateng.scf.bas.brp.dao.model.BBrpCostParam bBrpCostParam2 = new com.huateng.scf.bas.brp.dao.model.BBrpCostParam();
		try {
			BeanUtils.copyProperties(bBrpCostParam, bBrpCostParam2);
		} catch (Exception e) {
			throw new ScubeBizException("转换异常！");
		}
		bBrpCostParam2.setId(UUIDGeneratorUtil.generate());// 设置主键
		try {
			iBBrpCostParamDAO.insert(bBrpCostParam2);
			return null;
		} catch (Exception e) {
			log.error("费用参数信息新增失败！");
			throw new ScubeBizException("费用参数信息新增失败！", e);
		}

	}

	/**
	 * 对 bBrpCostParam中的复选框字段进行处理
	 * 
	 * @param bBrpCostParam
	 */
	private void checkBoxFormat(BBrpCostParam bBrpCostParam) {
		// 扣取方式 第1位-外扣，第2位-内收
		if (bBrpCostParam.getChargeType() != null && !bBrpCostParam.getChargeType().isEmpty()) {
			String chargeType = null;
			String value = StringUtil.formatCheckBoxValue(bBrpCostParam.getChargeType());
			if (value.length() == 3) {
				chargeType = "11";
			} else if ("1".equals(value)) {
				chargeType = "10";
			} else if ("2".equals(value)) {
				chargeType = "01";
			}
			bBrpCostParam.setChargeType(chargeType);
		}
		// 计算方式 第1位-固定、第2位-按比率
		if (bBrpCostParam.getCostCalcType() != null && !bBrpCostParam.getCostCalcType().isEmpty()) {
			String costCalcType = null;
			String value = StringUtil.formatCheckBoxValue(bBrpCostParam.getCostCalcType());
			if (value.length() == 3) {
				costCalcType = "11";
			} else if ("1".equals(value)) {
				costCalcType = "10";
			} else if ("2".equals(value)) {
				costCalcType = "01";
			}

			bBrpCostParam.setCostCalcType(costCalcType);
		}
		// 收取种类：1-整体、2-单张
		if (bBrpCostParam.getCostClass() != null && !bBrpCostParam.getCostClass().isEmpty()) {
			String costClass = null;
			String value = StringUtil.formatCheckBoxValue(bBrpCostParam.getCostClass());
			if (value.length() == 3) {
				costClass = "11";
			} else if ("1".equals(value)) {
				costClass = "10";
			} else if ("2".equals(value)) {
				costClass = "01";
			}
			bBrpCostParam.setCostClass(costClass);
		}
		// 收取方式 第1位-先收；第2位-后收；第3位-免收
		if (bBrpCostParam.getCostType() != null && !bBrpCostParam.getCostType().isEmpty()) {
			String costType = null;
			String[] costTypeArray = StringUtil.formatCheckBoxValue(bBrpCostParam.getCostType()).split(",");
			Arrays.sort(costTypeArray);
			String value = StringUtil.strArrayToStr(costTypeArray);
			switch (Integer.valueOf(value)) {
			case 1:
				costType = "100";
				break;
			case 2:
				costType = "010";
				break;
			case 3:
				costType = "001";
				break;
			case 12:
				costType = "110";
				break;
			case 13:
				costType = "101";
				break;
			case 23:
				costType = "011";
				break;
			case 123:
				costType = "111";
				break;
			}
			bBrpCostParam.setCostType(costType);
		}
	}

	@Override
	@Transactional
	public int delete(String id) {
		try {
			return iBBrpCostParamDAO.deleteByPrimaryKey(id);
		} catch (Exception e) {
			log.error("费用参数信息删除失败！");
			throw new ScubeBizException("费用参数信息删除失败！", e);
		}
	}

	@Override
	@Transactional
	public int update(BBrpCostParam bBrpCostParam) {
		if (bBrpCostParam != null) {
			// 对复选框字段进行处理
			checkBoxFormat(bBrpCostParam);
		}

		// 修改
		com.huateng.scf.bas.brp.dao.model.BBrpCostParam bBrpCostParam2 = new com.huateng.scf.bas.brp.dao.model.BBrpCostParam();
		try {
			BeanUtils.copyProperties(bBrpCostParam, bBrpCostParam2);
		} catch (Exception e) {
			throw new ScubeBizException("转换异常！");
		}
		try {
			return iBBrpCostParamDAO.updateByPrimaryKeySelective(bBrpCostParam2);
		} catch (Exception e) {
			log.error("费用参数信息信息修改失败！");
			throw new ScubeBizException("费用参数信息信息修改失败！", e);
		}

	}

	// 查找具体费用信息（根据费用代码 costCode，或者id）
	@Override
	public BBrpCostParam findBBrpCostParamByKey(BBrpCostParam bBrpCostParam) {
		BBrpCostParamExample example = new BBrpCostParamExample();
		Criteria cri = example.createCriteria();
		if (bBrpCostParam != null && !"".equals(bBrpCostParam)) {
			if (bBrpCostParam.getId() != null && bBrpCostParam.getId().length() > 0) {
				cri.andIdEqualTo(bBrpCostParam.getId());
			}
			if (bBrpCostParam.getCostCode() != null && bBrpCostParam.getCostCode().length() > 0) {
				cri.andCostCodeEqualTo(bBrpCostParam.getCostCode());
			}
			List<com.huateng.scf.bas.brp.dao.model.BBrpCostParam> bBrpCostParamList = iBBrpCostParamDAO
					.selectByExample(example);
			if (bBrpCostParamList != null && bBrpCostParamList.size() > 0) {
				com.huateng.scf.bas.brp.dao.model.BBrpCostParam bBrpCostParam1 = bBrpCostParamList.get(0);
				BBrpCostParam bBrpCostParam2 = new BBrpCostParam();
				try {
					BeanUtils.copyProperties(bBrpCostParam1, bBrpCostParam2);
				} catch (BeansException e) {
					throw new ScubeBizException("转换异常");
				}
				return bBrpCostParam2;
			} else {// 查不出数据就返回null
				return null;
			}
		} else {
			throw new ScubeBizException("费用信息查询，所传数据无效！");
		}
	}

	// 费用信息分页条件查询（根据费用代码，费用名称）
	@Override
	public Page findBBrpCostParamByPage(int pageNo, int pageSize, BBrpCostParam bBrpCostParam) {
		Page p = new Page(pageSize, pageNo, 0);
		BBrpCostParamExample example = new BBrpCostParamExample();
		Criteria cri = example.createCriteria();
		if (bBrpCostParam != null) {
			// 对复选框字段进行处理
			checkBoxFormat(bBrpCostParam);
			// 根据费用代码
			if (bBrpCostParam.getCostCode() != null && !"".equals(bBrpCostParam.getCostCode())) {
				cri.andCostCodeEqualTo(bBrpCostParam.getCostCode());
			}
			// 费用名称
			if (bBrpCostParam.getCostName() != null && !"".equals(bBrpCostParam.getCostName())) {
				cri.andCostNameLike("%" + bBrpCostParam.getCostName() + "%");
			}
			// 允许收取种类
			if (bBrpCostParam.getCostClass() != null && !"".equals(bBrpCostParam.getCostClass())) {
				cri.andCostClassEqualTo(bBrpCostParam.getCostClass());
			}
			// 收取方式
			if (bBrpCostParam.getCostType() != null && !"".equals(bBrpCostParam.getCostType())) {
				cri.andCostTypeEqualTo(bBrpCostParam.getCostType());
			}
			// 计算方式
			if (bBrpCostParam.getCostCalcType() != null && !"".equals(bBrpCostParam.getCostCalcType())) {
				cri.andCostCalcTypeEqualTo(bBrpCostParam.getCostCalcType());
			}
			// 扣取方式
			if (bBrpCostParam.getChargeType() != null && !"".equals(bBrpCostParam.getChargeType())) {
				cri.andChargeTypeEqualTo(bBrpCostParam.getChargeType());
			}
		}
		try {
			p.setRecords(iBBrpCostParamDAO.selectByPage(example, p));
			return p;
		} catch (Exception e) {
			log.error("费用信息分页条件查询失败！");
			throw new ScubeBizException("费用信息分页条件查询失败！", e);
		}
	}

}
