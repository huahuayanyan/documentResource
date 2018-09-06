package com.huateng.scf.bas.crr.dao.ext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;

@Repository("ExtBCrrDAO")
public class ExtBCrrDAOImpl extends IbatisDaoAnnotation4Template implements ExtBCrrDAO {
	@Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;
    
	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		// TODO Auto-generated method stub
        return this.template;

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HashMap<String, String>> queryCustSource(Map<String, String> omap, Page page) {
		List<HashMap<String, String>> list = this.searchListPageMyObject("EXT_B_CRR.queryCustList", omap, page);
		return  list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HashMap<String, String>> queryCrnoSource(Map<String, String> omap, Page page) {
		List<HashMap<String, String>> list = this.searchListPageMyObject("EXT_B_CRR.queryCrnoSource", omap, page);
		return  list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HashMap<String, String>> queryLnConSource(Map<String, String> omap, Page page) {
		List<HashMap<String, String>> list = this.searchListPageMyObject("EXT_B_CRR.queryLnConSource", omap, page);
		return  list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HashMap<String, String>> queryPrdMdSource(Map<String, String> omap, Page page) {
		List<HashMap<String, String>> list = this.searchListPageMyObject("EXT_B_CRR.queryPrdMdSource", omap, page);
		return  list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HashMap<String, String>> queryLnSource(Map<String, String> omap, Page page) {
		List<HashMap<String, String>> list = this.searchListPageMyObject("EXT_B_CRR.queryLnSource", omap, page);
		return  list;
	}
	
	@Override
    public BCrrDuebillApp selectByAppId(String appId) {
        BCrrDuebillApp _key = new BCrrDuebillApp();
        _key.setAppId(appId);
        BCrrDuebillApp record = (BCrrDuebillApp) getSqlMapClientTemplate().queryForObject("EXT_B_CRR.selectByAppId", _key);
        return record;
    }
	
	@Override
    public int countAppByExample(HashMap<String, String> omap) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EXT_B_CRR.countAppByExample", omap);
        return count;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<BCrrGntyCon> selectAppByPage(HashMap<String, String> omap, Page page) {
        List<BCrrGntyCon> list = this.searchListPageMyObject("EXT_B_CRR.selectAppByExample", omap, page);
        return list;
    }
    
    @Override
    public int countConByExample(HashMap<String, String> omap) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EXT_B_CRR.countConByExample", omap);
        return count;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<BCrrGntyCon> selectConByPage(HashMap<String, String> omap, Page page) {
        List<BCrrGntyCon> list = this.searchListPageMyObject("EXT_B_CRR.selectConByExample", omap, page);
        return list;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<BCrrGntyCon> getMastContByPara(HashMap<String, Object> omap, Page page) {
        List<BCrrGntyCon> list = this.searchListPageMyObject("EXT_B_CRR.getMastContByPara", omap, page);
        return list;
    }
    
    @Override
    public int countMastContByPara(HashMap<String, Object> omap) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EXT_B_CRR.countMastContByPara", omap);
        return count;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<BCrrGntyCon> getContSlaveBaseInfo(HashMap<String, Object> omap, Page page) {
        List<BCrrGntyCon> list = this.searchListPageMyObject("EXT_B_CRR.getContSlaveBaseInfo", omap, page);
        return list;
    }
    
    @Override
    public int countContSlaveBaseInfo(HashMap<String, Object> omap) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EXT_B_CRR.countContSlaveBaseInfo", omap);
        return count;
    }

	@Override
	public int countBCrrGntyConForCHL(HashMap<String, Object> omap) {
		Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EXT_B_CRR.countBCrrGntyConForCHL", omap);
        return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BCrrGntyCon> findBCrrGntyConForCHL(HashMap<String, Object> omap, Page page) {
		List<BCrrGntyCon> list = this.searchListPageMyObject("EXT_B_CRR.findBCrrGntyConForCHL", omap, page);
        return list;
	}
	
	@Override
	public int countSlaveContnoByPageForCHL(HashMap<String, Object> omap) {
		Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EXT_B_CRR.countSlaveContnoByPageForCHL", omap);
        return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BCrrGntyCon> findSlaveContnoByPageForCHL(HashMap<String, Object> omap, Page page) {
		List<BCrrGntyCon> list = this.searchListPageMyObject("EXT_B_CRR.findSlaveContnoByPageForCHL", omap, page);
        return list;
	}

	@Override
	public int countSlaveContList(HashMap<String, Object> omap) {
		Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EXT_B_CRR.countSlaveContList", omap);
        return count;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getSlaveContList(HashMap<String, Object> omap, Page page) {
		List list = this.searchListPageMyObject("EXT_B_CRR.getSlaveContList", omap, page);
        return list;
	}
}
