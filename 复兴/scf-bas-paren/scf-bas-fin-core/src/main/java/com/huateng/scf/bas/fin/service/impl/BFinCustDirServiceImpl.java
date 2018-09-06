package com.huateng.scf.bas.fin.service.impl;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.fin.dao.IBFinCustDirDAO;
import com.huateng.scf.bas.fin.model.BFinCustDir;
import com.huateng.scf.bas.fin.service.IBFinCustDirService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * 
 * <p>BFinCustDir接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月12日上午10:02:48
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月12日上午10:02:48	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BFinCustDirServiceImpl")
public class BFinCustDirServiceImpl implements IBFinCustDirService {
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IBFinCustDirDAO")
	IBFinCustDirDAO bfincustdirdao;
	
	@Override
	@Transactional
	public void add(BFinCustDir bFinCustDir) {
		String findId = bfincustdirdao.selectByFinDt(bFinCustDir.getFinDt());
		bFinCustDir.setFinId(findId);
		UserInfo user = ContextHolder.getUserInfo(); 
	    String userId= user.getTlrNo();
		BctlVO BctlVO = ContextHolder.getOrgInfo();
	    String brcode = BctlVO.getBrNo();
		bFinCustDir.setTlrNo(userId);
		bFinCustDir.setBrCd(brcode);
		bFinCustDir.setInputDt(ScfDateUtil.formatDate(new Date()));
		bFinCustDir.setLstUpdTlr(userId);
		bFinCustDir.setLstUpdBrCd(brcode);
		bFinCustDir.setLstUpdDt(ScfDateUtil.formatDate(new Date()));
		String[] mdlIds = bFinCustDir.getMdlId().split(",");
		String[] finNms = bFinCustDir.getFinNm().split(",");
		for(int i=0;i<mdlIds.length;i++)
		{
			String findirid = UUIDGeneratorUtil.generate();
			String mdlId = mdlIds[i];
			String finNm = finNms[i];
			// VO转PO 展现层对象转换DAO层对象
			com.huateng.scf.bas.fin.dao.model.BFinCustDir bFinCustDirdal = 
					new com.huateng.scf.bas.fin.dao.model.BFinCustDir();
			try
			{
				BeanUtils.copyProperties(bFinCustDir, bFinCustDirdal);
			}
			catch(BeansException e)
			{
				throw new ScubeBizException("转换异常");
			}
			bFinCustDirdal.setFinDirId(findirid);
			bFinCustDirdal.setMdlId(mdlId);
			bFinCustDirdal.setFinNm(finNm);
			try
			{
				bfincustdirdao.insert(bFinCustDirdal);
			}
			catch(BeansException e)
			{
				throw new ScubeBizException("插入异常");
			}
		}
	}
	@Override
	public String findBFinCustDirByMdlId(String mdlIds)
	{
		log.info(mdlIds);
		String flag = "";
		String[] mdlIdArr = mdlIds.split(",");
		for(String mdlId:mdlIdArr)
		{
			List<com.huateng.scf.bas.fin.dao.model.BFinCustDir> list = bfincustdirdao.selectByMdlId("%"+mdlId+"%");
			if(list.size()>0)
			{
				flag = "false";
				return flag;
			}
			else
			{
				flag = "true";
			}
		}
		return flag;
	}
	
	@Override
	public BFinCustDir findBFinCustDirByFinDirId(String finDirId)
	{
		BFinCustDir bFinCustDir = new BFinCustDir();
		com.huateng.scf.bas.fin.dao.model.BFinCustDir bFinCustDirdal = bfincustdirdao.selectByPrimaryKey(finDirId);
		try
		{
			BeanUtils.copyProperties(bFinCustDirdal, bFinCustDir);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		return bFinCustDir;
	}
}
