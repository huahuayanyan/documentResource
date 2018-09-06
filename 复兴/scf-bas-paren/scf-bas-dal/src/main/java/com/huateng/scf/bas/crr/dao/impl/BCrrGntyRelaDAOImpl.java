package com.huateng.scf.bas.crr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crr.dao.IBCrrGntyRelaDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyRela;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyRelaExample;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyRelaKey;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>BCrrGntyRelaKey数据库访问层通用接口类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月24日下午3:42:37
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月24日下午3:42:37	     新增
 *
 * </pre>
 */
@Repository("IBCrrGntyRelaDAO")
public class BCrrGntyRelaDAOImpl extends IbatisDaoAnnotation4Template implements IBCrrGntyRelaDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCrrGntyRelaDAOImpl() {
        super();
    }

    public int countByExample(BCrrGntyRelaExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CRR_GNTY_RELA.countByExample", example);
        return count;
    }

    public int deleteByExample(BCrrGntyRelaExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CRR_GNTY_RELA.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(BCrrGntyRelaKey _key) {
        int rows = getSqlMapClientTemplate().delete("B_CRR_GNTY_RELA.deleteByPrimaryKey", _key);
        return rows;
    }
    
    public void insert(BCrrGntyRela record) {
        getSqlMapClientTemplate().insert("B_CRR_GNTY_RELA.insert", record);
    }

    public void insertSelective(BCrrGntyRela record) {
        getSqlMapClientTemplate().insert("B_CRR_GNTY_RELA.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCrrGntyRela> selectByExample(BCrrGntyRelaExample example) {
        List<BCrrGntyRela> list = getSqlMapClientTemplate().queryForList("B_CRR_GNTY_RELA.selectByExample", example);
        return list;
    }

    public BCrrGntyRela selectByPrimaryKey(BCrrGntyRelaKey _key) {
        BCrrGntyRela record = (BCrrGntyRela) getSqlMapClientTemplate().queryForObject("B_CRR_GNTY_RELA.selectByPrimaryKey", _key);
        return record;
    }
    
    public int updateByExampleSelective(BCrrGntyRela record, BCrrGntyRelaExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_GNTY_RELA.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCrrGntyRela record, BCrrGntyRelaExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_GNTY_RELA.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCrrGntyRela record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_GNTY_RELA.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCrrGntyRela record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_GNTY_RELA.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCrrGntyRela> selectByPage(BCrrGntyRelaExample example, Page page) {
        List<BCrrGntyRela> list = this.searchListPageMyObject("B_CRR_GNTY_RELA.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCrrGntyRelaExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCrrGntyRelaExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    
    @Override
    public BCrrGntyRela selectByRltNo(String rltNo) {
    	BCrrGntyRela _key = new BCrrGntyRela();
    	_key.setRltNo(rltNo);
        BCrrGntyRela record = (BCrrGntyRela) getSqlMapClientTemplate().queryForObject("B_CRR_GNTY_RELA.selectByRltNo", _key);
        return record;
    }
    
    @Override
    public int deleteByRltNo(String rltNo) {
    	BCrrGntyRela _key = new BCrrGntyRela();
    	_key.setRltNo(rltNo);
        int rows = getSqlMapClientTemplate().delete("B_CRR_GNTY_RELA.deleteByRltNo", _key);
        return rows;
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<BCrrGntyRela> selectBySerialno(String serialno) {
    	BCrrGntyRela _key = new BCrrGntyRela();
    	_key.setSerialno(serialno);
    	List<BCrrGntyRela> record = getSqlMapClientTemplate().queryForList("B_CRR_GNTY_RELA.selectBySerialno", _key);
        return record;
    }
    
    @Override
    public int deleteBySerialno(String serialno) {
    	BCrrGntyRela _key = new BCrrGntyRela();
    	_key.setSerialno(serialno);
        int rows = getSqlMapClientTemplate().delete("B_CRR_GNTY_RELA.deleteBySerialno", _key);
        return rows;
    }
}