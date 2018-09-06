package com.huateng.scf.bas.sys.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.sys.dao.IBSysLnCdDAO;
import com.huateng.scf.bas.sys.dao.model.BSysLnCd;
import com.huateng.scf.bas.sys.dao.model.BSysLnCdExample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>BSysLnCd数据库访问层通用接口类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年12月12日上午10:31:46
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月12日上午10:31:46	     新增
 *
 * </pre>
 */
@Repository("IBSysLnCdDAO")
public class BSysLnCdDAOImpl extends IbatisDaoAnnotation4Template implements IBSysLnCdDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BSysLnCdDAOImpl() {
        super();
    }

    public int countByExample(BSysLnCdExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_SYS_LN_CD.countByExample", example);
        return count;
    }

    public int deleteByExample(BSysLnCdExample example) {
        int rows = getSqlMapClientTemplate().delete("B_SYS_LN_CD.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BSysLnCd _key = new BSysLnCd();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_SYS_LN_CD.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BSysLnCd record) {
        getSqlMapClientTemplate().insert("B_SYS_LN_CD.insert", record);
    }

    public void insertSelective(BSysLnCd record) {
        getSqlMapClientTemplate().insert("B_SYS_LN_CD.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BSysLnCd> selectByExample(BSysLnCdExample example) {
        List<BSysLnCd> list = getSqlMapClientTemplate().queryForList("B_SYS_LN_CD.selectByExample", example);
        return list;
    }
    
    public BSysLnCd selectByPrimaryKey(String id) {
        BSysLnCd _key = new BSysLnCd();
        _key.setId(id);
        BSysLnCd record = (BSysLnCd) getSqlMapClientTemplate().queryForObject("B_SYS_LN_CD.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BSysLnCd record, BSysLnCdExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_SYS_LN_CD.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BSysLnCd record, BSysLnCdExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_SYS_LN_CD.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BSysLnCd record) {
        int rows = getSqlMapClientTemplate().update("B_SYS_LN_CD.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BSysLnCd record) {
        int rows = getSqlMapClientTemplate().update("B_SYS_LN_CD.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BSysLnCd> selectByPage(BSysLnCdExample example, Page page) {
        List<BSysLnCd> list = this.searchListPageMyObject("B_SYS_LN_CD.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BSysLnCdExample {
        private Object record;

        public UpdateByExampleParms(Object record, BSysLnCdExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    

    @Override
    public BSysLnCd selectByRatename(String ratename) {
    	BSysLnCd _key = new BSysLnCd();
        _key.setRatename(ratename);
        BSysLnCd record = (BSysLnCd) getSqlMapClientTemplate().queryForObject("B_SYS_LN_CD.selectByRatename", _key);
        return record;
    }
    
    @Override
    public BSysLnCd selectByRatecode(String ratecode) {
    	BSysLnCd _key = new BSysLnCd();
        _key.setRatecode(ratecode);
        BSysLnCd record = (BSysLnCd) getSqlMapClientTemplate().queryForObject("B_SYS_LN_CD.selectByRatecode", _key);
        return record;
    }

    @SuppressWarnings("unchecked")
    @Override
	public List<BSysLnCd> selectByLnCd(BSysLnCd bSysLnCd) {
    	List<BSysLnCd> record =  getSqlMapClientTemplate().queryForList("B_SYS_LN_CD.selectByLnCd", bSysLnCd);
        return record;
	}
    
    @Override
    @SuppressWarnings("unchecked")
    public List<BSysLnCd> selectByExtExample(Map<String, String> omap, Page page) {
        List<BSysLnCd> list = this.searchListPageMyObject("B_SYS_LN_CD.selectByExtExample", omap, page);
        return list;
    }
    
    @Override
    public int countByExtExample(HashMap<String, String> omap) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_SYS_LN_CD.countByExtExample", omap);
        return count;
    }
}