package com.huateng.scf.nrec.bcp.service.impl.intercept;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.scf.bas.sys.dao.model.ChkResult;
import com.huateng.scf.bas.sys.model.BSysUploadFileVO;
import com.huateng.scf.bas.sys.service.IBSysUploadFileService;
import com.huateng.scf.bas.sys.service.SysChkCallService;
import com.huateng.scf.nbas.prd.dao.domodel.BPrdFileInfoDO;
import com.huateng.scf.nrec.bcp.service.IBCntBcpAppliBaseInfoService;

@Service("ChkFAppliFileCallServiceImpl")
public class ChkFAppliFileCallServiceImpl extends SysChkCallService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "BCntBcpAppliBaseInfoServiceImpl")
	IBCntBcpAppliBaseInfoService bcntbcpapplibaseinfoservice;

	@Resource(name = "BSysUploadFileServiceImpl")
	IBSysUploadFileService bsysuploadfileservice;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void doWork(Map chkMap, ChkResult chkResult) {
		log.info("ChkFAppliFileCallServiceImpl--"+chkMap.toString());
		String supplyChainPdId = chkMap.get("supplyChainPdId").toString();
		List<BPrdFileInfoDO> typelist = bcntbcpapplibaseinfoservice.findBPrdFileInfoByProductId(supplyChainPdId);
		String appno = chkMap.get("appno").toString();
		List<BSysUploadFileVO> list = bsysuploadfileservice.findBSysUploadFileByAppno(appno);
		//如果typelist为空则不得上传数据
		if(typelist!=null&&typelist.size()>0&&(list==null||list.size()==0))
		{
			chkResult.setRem("附件信息未上传！");
			chkResult.setStat(this.ERROR);
			return;
		}
		if(typelist!=null&&typelist.size()>0&&list!=null&&list.size()>0)
		{
			List<String> types = new ArrayList<String>();
			for(BPrdFileInfoDO infoDO:typelist)
			{
				types.add(infoDO.getContCode());
			}
			List<String> files = new ArrayList<String>();
			for(BSysUploadFileVO bSysUploadFileVO:list)
			{
				String code = bSysUploadFileVO.getExt1();
				if(!files.contains(code))
				{
					files.add(code);
				}
			}
			if(files.containsAll(types))
			{
				chkResult.setStat(this.SUCCESS);
				return;
			}
			else
			{
				chkResult.setRem("上传的附件信息不完整！");
				chkResult.setStat(this.ERROR);
				return;
			}
		}
		chkResult.setStat(this.SUCCESS);
	}

}
