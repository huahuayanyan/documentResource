package com.huateng.scf.bas.sys.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.sys.dao.IBSysLnValDAO;
import com.huateng.scf.bas.sys.dao.model.BSysLnVal;
import com.huateng.scf.bas.sys.dao.model.BSysLnValExample;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>BSysLnVal数据库访问层通用接口类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年12月12日上午10:31:55
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月12日上午10:31:55	     新增
 *
 * </pre>
 */
@Repository("IBSysLnValDAO")
public class BSysLnValDAOImpl extends IbatisDaoAnnotation4Template implements IBSysLnValDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BSysLnValDAOImpl() {
        super();
    }

    public int countByExample(BSysLnValExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_SYS_LN_VAL.countByExample", example);
        return count;
    }

    public int deleteByExample(BSysLnValExample example) {
        int rows = getSqlMapClientTemplate().delete("B_SYS_LN_VAL.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BSysLnVal _key = new BSysLnVal();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_SYS_LN_VAL.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BSysLnVal record) {
        getSqlMapClientTemplate().insert("B_SYS_LN_VAL.insert", record);
    }

    public void insertSelective(BSysLnVal record) {
        getSqlMapClientTemplate().insert("B_SYS_LN_VAL.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BSysLnVal> selectByExample(BSysLnValExample example) {
        List<BSysLnVal> list = getSqlMapClientTemplate().queryForList("B_SYS_LN_VAL.selectByExample", example);
        return list;
    }

    public BSysLnVal selectByPrimaryKey(String id) {
        BSysLnVal _key = new BSysLnVal();
        _key.setId(id);
        BSysLnVal record = (BSysLnVal) getSqlMapClientTemplate().queryForObject("B_SYS_LN_VAL.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BSysLnVal record, BSysLnValExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_SYS_LN_VAL.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BSysLnVal record, BSysLnValExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_SYS_LN_VAL.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BSysLnVal record) {
        int rows = getSqlMapClientTemplate().update("B_SYS_LN_VAL.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BSysLnVal record) {
        int rows = getSqlMapClientTemplate().update("B_SYS_LN_VAL.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BSysLnVal> selectByPage(BSysLnValExample example, Page page) {
        List<BSysLnVal> list = this.searchListPageMyObject("B_SYS_LN_VAL.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BSysLnValExample {
        private Object record;

        public UpdateByExampleParms(Object record, BSysLnValExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    
    @Override
    public BSysLnVal selectByRateid(String rateid) {
        BSysLnVal _key = new BSysLnVal();
        _key.setRateid(rateid);
        BSysLnVal record = (BSysLnVal) getSqlMapClientTemplate().queryForObject("B_SYS_LN_VAL.selectByRateid", _key);
        return record;
    }
}