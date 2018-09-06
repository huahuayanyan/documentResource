package com.huateng.scf.bas.fin.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.fin.dao.IBFinCustDAO;
import com.huateng.scf.bas.fin.dao.model.BFinCnfgCl;
import com.huateng.scf.bas.fin.dao.model.BFinCust;
import com.huateng.scf.bas.fin.dao.model.BFinCustExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>BFinCust数据库访问层通用接口类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月5日下午5:25:34
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月5日下午5:25:34	     新增
 *
 * </pre>
 */
@Repository("IBFinCustDAO")
public class BFinCustDAOImpl extends IbatisDaoAnnotation4Template implements IBFinCustDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BFinCustDAOImpl() {
        super();
    }

    public int countByExample(BFinCustExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_FIN_CUST.countByExample", example);
        return count;
    }

    public int deleteByExample(BFinCustExample example) {
        int rows = getSqlMapClientTemplate().delete("B_FIN_CUST.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String finId) {
        BFinCust _key = new BFinCust();
        _key.setFinId(finId);
        int rows = getSqlMapClientTemplate().delete("B_FIN_CUST.deleteByPrimaryKey", _key);
        return rows;
    }
    
    public void insert(BFinCust record) {
        getSqlMapClientTemplate().insert("B_FIN_CUST.insert", record);
    }

    public void insertSelective(BFinCust record) {
        getSqlMapClientTemplate().insert("B_FIN_CUST.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BFinCust> selectByExample(BFinCustExample example) {
        List<BFinCust> list = getSqlMapClientTemplate().queryForList("B_FIN_CUST.selectByExample", example);
        return list;
    }

    public BFinCust selectByPrimaryKey(String finId) {
        BFinCust _key = new BFinCust();
        _key.setFinId(finId);
        BFinCust record = (BFinCust) getSqlMapClientTemplate().queryForObject("B_FIN_CUST.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BFinCust record, BFinCustExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_FIN_CUST.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BFinCust record, BFinCustExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_FIN_CUST.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BFinCust record) {
        int rows = getSqlMapClientTemplate().update("B_FIN_CUST.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BFinCust record) {
        int rows = getSqlMapClientTemplate().update("B_FIN_CUST.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BFinCust> selectByPage(BFinCustExample example, Page page) {
        List<BFinCust> list = this.searchListPageMyObject("B_FIN_CUST.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BFinCustExample {
        private Object record;

        public UpdateByExampleParms(Object record, BFinCustExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    
	@SuppressWarnings("unchecked")
	public List<BFinCnfgCl> selectByMldCl(String mdlCl) {
        List<BFinCnfgCl> list = getSqlMapClientTemplate().queryForList("B_FIN_CUST.selectByMldCl", mdlCl);
        return list;
    }
}