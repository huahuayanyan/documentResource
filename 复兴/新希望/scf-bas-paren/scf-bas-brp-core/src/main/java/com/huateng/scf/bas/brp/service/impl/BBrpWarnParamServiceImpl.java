/**
 * 
 */
package com.huateng.scf.bas.brp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.entity.RoleInfoVO;
import com.huateng.authority.service.RoleService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.dao.IBBrpWarnParamDAO;
import com.huateng.scf.bas.brp.dao.model.BBrpWarnParamExample;
import com.huateng.scf.bas.brp.model.BBrpWarnParam;
import com.huateng.scf.bas.brp.service.IBBrpWarnParamService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年12月4日下午3:20:57
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年12月4日下午3:20:57	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("BBrpWarnParamServiceImpl")
public class BBrpWarnParamServiceImpl implements IBBrpWarnParamService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BBrpWarnParamDAO")
	IBBrpWarnParamDAO iBBrpWarnParamDAO;

	@Autowired
	private RoleService roleService;
	
	// 查询具体预警信息（warnNo）
	@Override
	public BBrpWarnParam findBBrpWarnParamByKey(BBrpWarnParam bBrpWarnParam) {
		BBrpWarnParamExample example = new BBrpWarnParamExample();
		com.huateng.scf.bas.brp.dao.model.BBrpWarnParamExample.Criteria cri = example.createCriteria();
		if (bBrpWarnParam != null && !"".equals(bBrpWarnParam)) {
			if (bBrpWarnParam.getWarnNo() != null && bBrpWarnParam.getWarnNo().length() > 0) {
				cri.andWarnNoEqualTo(bBrpWarnParam.getWarnNo());
				List<com.huateng.scf.bas.brp.dao.model.BBrpWarnParam> bBrpWarnParamList = iBBrpWarnParamDAO
						.selectByExample(example);
				if (bBrpWarnParamList != null && bBrpWarnParamList.size() > 0) {
					com.huateng.scf.bas.brp.dao.model.BBrpWarnParam bBrpWarnParam1 = bBrpWarnParamList.get(0);
					BBrpWarnParam bBrpWarnParam2 = new BBrpWarnParam();
					try {
						BeanUtils.copyProperties(bBrpWarnParam1, bBrpWarnParam2);
						//翻译目标岗位targetRoleid 
						//修改空指针异常BUG modify by huangshuidan 2017-07-20
						if(null!=bBrpWarnParam1.getTargetRoleid() && StringUtil.isStrNotEmpty(bBrpWarnParam1.getTargetRoleid().toString())){
							RoleInfoVO roleInfoVO = new RoleInfoVO();
							String targetRoleid = bBrpWarnParam1.getTargetRoleid().toString();
							roleInfoVO.setId(targetRoleid);
							List<RoleInfoVO> listrole = roleService.selectByExample(roleInfoVO);
							if(listrole!=null&&listrole.size()>0){
								for(RoleInfoVO vo:listrole){
									if(vo.getId().equals(targetRoleid)){
										String roleName = vo.getRoleName();
										bBrpWarnParam2.setRoleName(roleName);
									}
								}
								
							}
						}
						
					} catch (BeansException e) {
						throw new ScubeBizException("转换异常");
					}
					return bBrpWarnParam2;
				} else {// 查不到直接返回null；
					return null;
				}
			} else {
				throw new ScubeBizException("预警信息查询，所传数据无效！");
			}
		} else {
			throw new ScubeBizException("预警信息查询，所传数据无效！");
		}
	}

	// 预警信息分页查询（根据预警编号，预警名称，预警类型，预警目标类型。）warnNo，warnName，warnType，targetType
	@Override
	public Page findBBrpWarnParamByPage(int pageNo, int pageSize, BBrpWarnParam bBrpWarnParam) {
		Page p = new Page(pageSize, pageNo, 0);
		BBrpWarnParamExample example = new BBrpWarnParamExample();
		com.huateng.scf.bas.brp.dao.model.BBrpWarnParamExample.Criteria cri = example.createCriteria();
		if (bBrpWarnParam != null) {
			// 预警编号,warnNo
			if (bBrpWarnParam.getWarnNo() != null && !"".equals(bBrpWarnParam.getWarnNo())) {
				cri.andWarnNoEqualTo(bBrpWarnParam.getWarnNo());
			}
			// 预警名称,warnName
			if (bBrpWarnParam.getWarnName() != null && !"".equals(bBrpWarnParam.getWarnName())) {
				cri.andWarnNameLike("%" + bBrpWarnParam.getWarnName() + "%");
			}
			// 预警类型,warnType
			if (bBrpWarnParam.getWarnType() != null && !"".equals(bBrpWarnParam.getWarnType())) {
				cri.andWarnTypeEqualTo(bBrpWarnParam.getWarnType());
			}
			// 预警目标类型,targetType
			if (bBrpWarnParam.getTargetType() != null && !"".equals(bBrpWarnParam.getTargetType())) {
				cri.andTargetTypeEqualTo(bBrpWarnParam.getTargetType());
			}
		}
		try {
			p.setRecords(iBBrpWarnParamDAO.selectByPage(example, p));
			return p;
		} catch (Exception e) {
			log.error("预警信息分页查询失败！");
			throw new ScubeBizException("预警信息分页查询失败！", e);
		}
	}
	
	@Transactional
	@Override
	public void addBBrpWarnParam(BBrpWarnParam bBrpWarnParam) throws ScubeBizException {
		com.huateng.scf.bas.brp.dao.model.BBrpWarnParam bBrpWarnParamdal = new com.huateng.scf.bas.brp.dao.model.BBrpWarnParam();
		try {
			BeanUtils.copyProperties(bBrpWarnParam, bBrpWarnParamdal);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("预警参数信息转换异常！");
			throw new ScubeBizException("预警参数信息转换异常！");
		}
		// TODO
		try {
			iBBrpWarnParamDAO.insertSelective(bBrpWarnParamdal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("预警参数信息插入异常！");
			throw new ScubeBizException("预警参数信息插入异常！");
		}
	}

	@Transactional
	@Override
	public int updateBBrpWarnParam(BBrpWarnParam bBrpWarnParam) throws ScubeBizException {
		// TODO Auto-generated method stub
		com.huateng.scf.bas.brp.dao.model.BBrpWarnParam bBrpWarnParamdal = new com.huateng.scf.bas.brp.dao.model.BBrpWarnParam();
		try {
			BeanUtils.copyProperties(bBrpWarnParam, bBrpWarnParamdal);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("预警参数信息转换异常！");
			throw new ScubeBizException("预警参数信息转换异常！");
		}
		int i = 0;
		try {
			i = iBBrpWarnParamDAO.updateByPrimaryKeySelective(bBrpWarnParamdal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("预警参数信息更新异常！");
			throw new ScubeBizException("预警参数信息更新异常！");
		}
		return i;
	}

	@Transactional
	@Override
	public int deleteBBrpWarnParam(String key) throws ScubeBizException {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = iBBrpWarnParamDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("预警参数信息删除异常！");
			throw new ScubeBizException("预警参数信息删除异常！");
		}
		return i;
	}

}
