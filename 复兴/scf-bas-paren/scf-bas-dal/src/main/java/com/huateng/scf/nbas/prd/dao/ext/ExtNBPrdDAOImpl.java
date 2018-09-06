package com.huateng.scf.nbas.prd.dao.ext;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.nbas.prd.dao.domodel.BPrdCostInfoDO;
import com.huateng.scf.nbas.prd.dao.domodel.BPrdFileInfoDO;
import com.huateng.scf.nbas.prd.dao.model.BPrdPrintInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("ExtNBPrdDAO")
public class ExtNBPrdDAOImpl extends IbatisDaoAnnotation4Template implements ExtNBPrdDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public ExtNBPrdDAOImpl() {
        super();
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

	@Override
	public int countBPrdFileInfoByPage(HashMap<String, Object> omap) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("EXT_NBAS_PRD.countBPrdFileInfoByPage", omap);
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BPrdFileInfoDO> findBPrdFileInfoByPage(HashMap<String, Object> omap, Page page, boolean flag) {
		List<BPrdFileInfoDO> list = new ArrayList<BPrdFileInfoDO>();
		if(flag)
		{
			list = this.searchListPageMyObject("EXT_NBAS_PRD.findBPrdFileInfoByPage", omap, page);
		}
		else
		{
			list = getSqlMapClientTemplate().queryForList("EXT_NBAS_PRD.findBPrdFileInfoByPage", omap);
		}
		return list;
	}

	@Override
	public int countBPrdPrintInfoByPage(HashMap<String, Object> omap) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("EXT_NBAS_PRD.countBPrdPrintInfoByPage", omap);
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BPrdPrintInfo> findBPrdPrintInfoByPage(HashMap<String, Object> omap, Page page) {
		List<BPrdPrintInfo> list = this.searchListPageMyObject("EXT_NBAS_PRD.findBPrdPrintInfoByPage", omap, page);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BPrdCostInfoDO> queryProductCost(HashMap<String, Object> omap) {
		List<BPrdCostInfoDO> list = getSqlMapClientTemplate().queryForList("EXT_NBAS_PRD.queryProductCost", omap);
		return list;
	}
}