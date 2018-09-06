package com.huateng.scf.rec.qry.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.TlrInfoVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.authority.service.OrgService;
import com.huateng.authority.service.UserService;
import com.huateng.scf.bas.cnt.dao.IBCntDebtInfoDAO;
import com.huateng.scf.bas.cnt.model.DebtContVO;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.qry.service.IConMngQryService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
@ScubeService
@Service("ConMngQryServiceImpl")
public class ConMngQryServiceImpl implements IConMngQryService {
private final Logger log = LoggerFactory.getLogger(getClass());
	
	ScubeUserService scubeUserService;

    @Resource(name = "orgService")
	OrgService orgService;
	@Resource(name = "userService")
	UserService userService;
	@Resource(name = "BCntDebtInfoDAO")
	IBCntDebtInfoDAO iBCntDebtInfoDAO;
	 
	 
	
	@Override
	public DebtContVO queryDebtConByNo(String debtContno) {
		log.info("应收账款融资综合查询-基本信息查询");
		if(StringUtil.isEmpty(debtContno)){
			throw new ScubeBizException("参数不存在",RBcpErrorConstant.ERROR_CODE_PARAM_NOT_EXIST);
		}
        DebtContVO resultVO = new DebtContVO();
		Map<String, String> paraMap = new HashMap<String,String>();
		paraMap.put("debtContno", debtContno);
		com.huateng.scf.bas.cnt.dao.model.DebtContVO conVO = iBCntDebtInfoDAO.queryBCntDebtInfoByContno(paraMap);
		BeanUtils.copyProperties(conVO, resultVO);
		
		UserInfo userInfo = new UserInfo();
		userInfo.setTlrNo(conVO.getMgrno());
		List<TlrInfoVO> userList = userService.selectByExample(userInfo);
		if (userList != null && userList.size() == 1) {
			resultVO.setMgrno(userList.get(0).getTlrName());
		}else{
			resultVO.setMgrno("");
		}
		
		BctlVO bctlVO = new BctlVO();
		bctlVO.setBrNo(conVO.getBrcode());
		List<BctlVO> bctlVOList = orgService.selectByExample(bctlVO);
		if (bctlVOList != null && bctlVOList.size() == 1) {
			resultVO.setBrcode(bctlVOList.get(0).getBrName());
		}else{
			resultVO.setBrcode("");
		}
		 
		return resultVO;
	}

	 
 
}
