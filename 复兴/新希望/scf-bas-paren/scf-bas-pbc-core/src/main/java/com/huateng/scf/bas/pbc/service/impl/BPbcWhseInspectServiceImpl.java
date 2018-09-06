package com.huateng.scf.bas.pbc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.dao.IBCrrDuebillAppDAO;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLnConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.dao.model.BCrrLnCon;
import com.huateng.scf.bas.pbc.dao.IBPbcWhseInspectDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcHkDetail;
import com.huateng.scf.bas.pbc.service.IBPbcWhseInspectService;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p></p>
 *
 * @author 	LIPH
 * @date 2016年12月29日上午9:46:42
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * LIPH		   2016年12月29日上午9:46:42              新增
 *
 * </pre>
 */
@ScubeService
@Service("BPbcWhseInspectServiceImpl")
public class BPbcWhseInspectServiceImpl implements IBPbcWhseInspectService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BPbcWhseInspectDAO")
	IBPbcWhseInspectDAO ibPbcWhseInspectDAO;
	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO ibCrrGntyConDAO;
	@Resource(name = "IBCrrDuebillAppDAO")
	IBCrrDuebillAppDAO ibCrrDuebillAppDAO;
	@Resource(name = "IBCrrLnConDAO")
	IBCrrLnConDAO ibCrrLnConDAO;
	
	@Override
	public Page findHk(int pageNo, int pageSize, String appno) {
		BCrrDuebillApp bCrrDuebillApp = ibCrrDuebillAppDAO.selectByPrimaryKey(appno);
		BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(bCrrDuebillApp.getAppId());
		String vidno = bCrrLnCon.getVidNo();
		BCrrGntyCon bCrrGntyCon = ibCrrGntyConDAO.selectByPrimaryKey(vidno);
		String zycontno = bCrrGntyCon.getConId();//质押合同号
		Map map = new HashMap();
		map.put("conid", zycontno);
		int total = ibPbcWhseInspectDAO.findHkCount(map);
		List<BPbcHkDetail> list = ibPbcWhseInspectDAO.findHkInfo(map);
		Page p = new Page(pageSize,pageNo,total);
		p.setRecords(list);
		return p;
	}
}
