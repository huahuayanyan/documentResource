package com.huateng.scf.bas.sys.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.cache.CacheService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.sys.constant.BSysErrorConstant;
import com.huateng.scf.bas.sys.dao.BSysChkDirDAO;
import com.huateng.scf.bas.sys.dao.model.BSysChkDir;
import com.huateng.scf.bas.sys.dao.model.BSysChkDirExample;
import com.huateng.scf.bas.sys.dao.model.BSysChkDirExample.Criteria;
import com.huateng.scf.bas.sys.service.IBSysChkDirService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * @author HTRAD0055 拦截目录实现类
 */
@ScubeService
@Service("BSysChkDirServiceImpl")
public class BSysChkDirServiceImpl implements IBSysChkDirService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "BSysChkDirDAO")
	BSysChkDirDAO bSysChkDirDAO;

	@Autowired
	private CacheService cacheService;

	@Override
	@Transactional
	public String add(BSysChkDir record) {
		// 1.校验前台数据
		if (record == null || record.equals("")) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_SYS_20005), BSysErrorConstant.SCF_BAS_SYS_20005);
		}
		if (record.getMdlId() == null || "".equals(record.getMdlId())) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_SYS_20005), BSysErrorConstant.SCF_BAS_SYS_20005);
		}
		// 2.数据查重
		BSysChkDir findBSysChkDirByKey = findBSysChkDirByKey(record.getMdlId());
		if (findBSysChkDirByKey != null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_SYS_20006), BSysErrorConstant.SCF_BAS_SYS_20006);
		}
		// 3.数据新增
		try {
			bSysChkDirDAO.insert(record);
		} catch (Exception e) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_SYS_20007), BSysErrorConstant.SCF_BAS_SYS_20007);
		}
		return "1";
	}

	@Transactional
	@Override
	public int update(BSysChkDir record) {
		// 1.校验前台数据
		if (record == null || record.equals("")) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_SYS_20005), BSysErrorConstant.SCF_BAS_SYS_20005);
		}
		if (record.getMdlId() == null || "".equals(record.getMdlId())) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_SYS_20005), BSysErrorConstant.SCF_BAS_SYS_20005);
		}

		// 2.数据修改
		try {
			return bSysChkDirDAO.updateByPrimaryKey(record);
		} catch (Exception e) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_SYS_20008), BSysErrorConstant.SCF_BAS_SYS_20008);
		}

	}

	@Transactional
	@Override
	public int delete(String key) {
		if (key == null || "".equals(key)) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_SYS_20005), BSysErrorConstant.SCF_BAS_SYS_20005);
		}
		try {
			return bSysChkDirDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_SYS_20009), BSysErrorConstant.SCF_BAS_SYS_20009);
		}

	}

	@Override
	public Page findBSysChkDirByPage(int pageNo, int pageSize, BSysChkDir record) {
		int total = bSysChkDirDAO.countByExample(new BSysChkDirExample());
		Page p = new Page(pageSize, pageNo, total);

		BSysChkDirExample example = new BSysChkDirExample();
		Criteria cri = example.createCriteria();
		if (record != null) {
			if (record.getMdlId() != null && record.getMdlId().length() > 0) {
				cri.andMdlIdEqualTo(record.getMdlId());
			}
			if (record.getMdlNm() != null && record.getMdlNm().length() > 0) {
				cri.andMdlNmLike("%" + record.getMdlNm() + "%");
			}
			if (record.getStat() != null && record.getStat().length() > 0) {
				cri.andStatLike("%" + record.getStat() + "%");
			}
		}
		log.info("totalPage=" + p.getTotalPage());
		log.info("totalPage=" + p.getTotalPage());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("current=" + p.getCurrent());
		log.info("current=" + p.getCurrent());
		try {
			p.setRecords(bSysChkDirDAO.selectByPage(example, p));
		} catch (Exception e) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_SYS_20007), BSysErrorConstant.SCF_BAS_SYS_20007);
		}
		log.info("p.toString()=" + p.toString());
		return p;
	}

	@Override
	public BSysChkDir findBSysChkDirByKey(String key) {
		try {
			return bSysChkDirDAO.selectByPrimaryKey(key);
		} catch (Exception e) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_SYS_20007), BSysErrorConstant.SCF_BAS_SYS_20007);
		}
	}

	@Override
	public BSysChkDir findSysChkDirChkItIds() {
		return null;
	}

}
