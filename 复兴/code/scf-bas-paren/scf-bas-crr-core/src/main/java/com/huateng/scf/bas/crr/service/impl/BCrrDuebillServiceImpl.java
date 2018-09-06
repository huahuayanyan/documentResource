package com.huateng.scf.bas.crr.service.impl;

import java.util.ArrayList;
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
import com.huateng.authority.entity.UserInfo;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crr.dao.IBCrrDuebillAppDAO;
import com.huateng.scf.bas.crr.dao.IBCrrDuebillDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp;
import com.huateng.scf.bas.crr.dao.model.BCrrDuebillExample;
import com.huateng.scf.bas.crr.dao.model.BCrrDuebillExample.Criteria;
import com.huateng.scf.bas.crr.model.BCrrDuebill;
import com.huateng.scf.bas.crr.model.BCrrLnCon;
import com.huateng.scf.bas.crr.service.IBCrrDuebillService;
import com.huateng.scf.bas.crr.service.IBCrrLnConService;
import com.huateng.scf.bas.crr.util.BCrrModelCommonUtil;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.mrn.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.mrn.service.IBMrnAppliAcctInfoService;
import com.huateng.scf.bas.sys.dao.model.RSysAcctBctl;
import com.huateng.scf.bas.sys.model.BSysAcctBctl;
import com.huateng.scf.bas.sys.service.IBSysAcctBctlService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>
 * BCrrDuebill接口实现类
 * </p>
 *
 * @author mengjiajia
 * @date 2016年11月14日下午8:26:07
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午8:26:07	     新增
 *
 *            </pre>
 */
@ScubeService
@Service("BCrrDuebillServiceImpl")
public class BCrrDuebillServiceImpl implements IBCrrDuebillService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IBCrrDuebillDAO")
	IBCrrDuebillDAO bcrrduebilldao;

	@Resource(name = "IBCrrDuebillAppDAO")
	IBCrrDuebillAppDAO bcrrduebillappdao;

	@Resource(name = "BSysSerialNoServiceImpl")
	IBSysSerialNoService ibSysSerialNoService;

	@Resource(name = "BMrnAppliAcctInfoServiceImpl")
	IBMrnAppliAcctInfoService bmrnappliacctinfoservice;

	@Resource(name = "BCrrLnConServiceImpl")
	IBCrrLnConService bcrrlnconservice;

	@Resource(name = "BLanLnciBaseDAO")
	IBLanLnciBaseDAO blanlncibasedao;

	@Resource(name = "BSysAcctBctlServiceImpl")
	IBSysAcctBctlService bsysacctbctlservice;

	@Override
	@Transactional
	public void add(BCrrDuebill bCrrDuebill) {
		log.info("台帐信息生成");
		String cino = "";
		// 借据号
		List<BLanLnciBase> lanbaselist = blanlncibasedao.selectByAppno(bCrrDuebill.getRelaId());
		if (lanbaselist.size() > 0) {
			cino = lanbaselist.get(0).getDebetId();
		}
		bCrrDuebill.setCino(cino);
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.crr.dao.model.BCrrDuebill bCrrDuebilldal = new com.huateng.scf.bas.crr.dao.model.BCrrDuebill();
		try {
			BeanUtils.copyProperties(bCrrDuebill, bCrrDuebilldal);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		try {
			bcrrduebilldao.insertSelective(bCrrDuebilldal);
		} catch (BeansException e) {
			throw new ScubeBizException("插入异常");
		}
		// 台帐主键加入保证金
		BCrrLnCon bCrrLnCon = bcrrlnconservice.findBCrrLnConByAppId(bCrrDuebill.getConNo());
		if (bCrrLnCon != null) {
			// TODO
			String appno = bCrrLnCon.getRelaId();
			List<BMrnAppliAcctInfo> bmrnapplist = bmrnappliacctinfoservice.findBMrnAppliAcctInfoByAppno(appno);
			if (bmrnapplist.size() > 0) {
				for (BMrnAppliAcctInfo bmrnapp : bmrnapplist) {
					bmrnapp.setDebetNo(cino);
					// bmrnapp.setBillId(extId);
					bmrnappliacctinfoservice.update(bmrnapp);
				}
			}
		}

	}

	@Override
	@Transactional
	public int update(BCrrDuebill bCrrDuebill) {
		log.info("台帐信息更新");
		BCrrModelCommonUtil.setUpdateField(bCrrDuebill);
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.crr.dao.model.BCrrDuebill bCrrDuebilldal = new com.huateng.scf.bas.crr.dao.model.BCrrDuebill();
		try {
			BeanUtils.copyProperties(bCrrDuebill, bCrrDuebilldal);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		int i;
		try {
			i = bcrrduebilldao.updateByPrimaryKeySelective(bCrrDuebilldal);
		} catch (BeansException e) {
			throw new ScubeBizException("更新异常");
		}
		return i;
	}

	@Override
	@Transactional
	public int batchDelete(List<BCrrDuebill> list) {
		log.info("台帐信息删除");
		int i = 0;
		if (list.size() > 0) {
			for (BCrrDuebill bCrrDuebill : list) {
				// VO转PO 展现层对象转换DAO层对象
				com.huateng.scf.bas.crr.dao.model.BCrrDuebill bCrrDuebilldal = new com.huateng.scf.bas.crr.dao.model.BCrrDuebill();
				try {
					BeanUtils.copyProperties(bCrrDuebill, bCrrDuebilldal);
				} catch (BeansException e) {
					throw new ScubeBizException("转换异常");
				}
				String relaId = bCrrDuebilldal.getRelaId();
				String cino = bCrrDuebilldal.getCino();
				BCrrDuebillApp bCrrDuebillApp = new BCrrDuebillApp();
				bCrrDuebillApp.setId(relaId);
				bCrrDuebillApp.setAppStat("00");
				UserInfo user = ContextHolder.getUserInfo();
				String userid = user.getTlrNo();
				bCrrDuebillApp.setLstUpdTlr(userid);
				bCrrDuebillApp.setLstUpdDt(ScfDateUtil.formatDate(new Date()));
				bcrrduebillappdao.updateByPrimaryKeySelective(bCrrDuebillApp);
				try {
					i = bcrrduebilldao.deleteByPrimaryKey(cino);
				} catch (BeansException e) {
					throw new ScubeBizException("删除异常");
				}
			}
		}
		return i;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page findBCrrDuebillByPage(int pageNo, int pageSize, BCrrDuebill bCrrDuebill) {

		BCrrDuebillExample example = new BCrrDuebillExample();
		Criteria cri = example.createCriteria();

		if (bCrrDuebill != null) {
			// 台帐流水号
			if (bCrrDuebill.getCino() != null && bCrrDuebill.getCino().length() > 0) {
				cri.andCinoLike("%" + bCrrDuebill.getCino() + "%");
			}
			// 客户名称
			if (bCrrDuebill.getCustNm() != null && bCrrDuebill.getCustNm().length() > 0) {
				cri.andCustNmLike("%" + bCrrDuebill.getCustNm() + "%");
			}
			// 放款日期
			if (bCrrDuebill.getIsDt() != null && bCrrDuebill.getIsDt().length() > 0) {
				cri.andIsDtGreaterThanOrEqualTo(bCrrDuebill.getIsDt());
			}
			// 到期日期
			if (bCrrDuebill.getTeDt() != null && bCrrDuebill.getTeDt().length() > 0) {
				cri.andTeDtLessThanOrEqualTo(bCrrDuebill.getTeDt());
			}
			// cri.andTlrNoEqualTo(ContextHolder.getUserInfo().getTlrNo());
		}
		example.setOrderByClause("INP_DT DESC");

		int total = bcrrduebilldao.countByExample(example);
		Page p = new Page(pageSize, pageNo, total);

		log.info("totalPage=" + p.getTotalPage());
		log.info("totalPage=" + p.getTotalPage());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("current=" + p.getCurrent());
		log.info("current=" + p.getCurrent());

		List<com.huateng.scf.bas.crr.dao.model.BCrrDuebill> listdal = bcrrduebilldao.selectByPage(example, p);
		List<com.huateng.scf.bas.crr.dao.model.BCrrDuebill> list = new ArrayList<com.huateng.scf.bas.crr.dao.model.BCrrDuebill>();
		if (listdal.size() > 0) {
			for (com.huateng.scf.bas.crr.dao.model.BCrrDuebill duebill : listdal) {
				String actBrCd = duebill.getActBrCd();
				String actBrNm = "";
				if (StringUtil.isStrNotEmpty(actBrCd)) {
					BSysAcctBctl bSysAcctBctl = new BSysAcctBctl();
					bSysAcctBctl.setBrcode(actBrCd);
					Page sysacct = bsysacctbctlservice.findBSysAcctBctlByPage(pageNo, pageSize, bSysAcctBctl);
					List<RSysAcctBctl> sysacctlist = sysacct.getRecords();
					if (sysacctlist.size() > 0) {
						actBrNm = sysacctlist.get(0).getBrname();
					}
				}
				duebill.setActBrNm(actBrNm);
				list.add(duebill);
			}
		}

		p.setRecords(list);
		log.info("p.toString()=" + p.toString());
		return p;
	}

}
