package com.huateng.scf.bas.sys.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.sys.dao.IBSysGlobalInfoDAO;
import com.huateng.scf.bas.sys.dao.model.BSysGlobalInfo;
import com.huateng.scf.bas.sys.dao.model.BSysGlobalInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BSysGlobalInfoDAO")
public class BSysGlobalInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBSysGlobalInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BSysGlobalInfoDAOImpl() {
        super();
    }

    public int countByExample(BSysGlobalInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_SYS_GLOBAL_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BSysGlobalInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_SYS_GLOBAL_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BSysGlobalInfo _key = new BSysGlobalInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_SYS_GLOBAL_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BSysGlobalInfo record) {
        getSqlMapClientTemplate().insert("B_SYS_GLOBAL_INFO.insert", record);
    }

    public void insertSelective(BSysGlobalInfo record) {
        getSqlMapClientTemplate().insert("B_SYS_GLOBAL_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BSysGlobalInfo> selectByExample(BSysGlobalInfoExample example) {
        List<BSysGlobalInfo> list = getSqlMapClientTemplate().queryForList("B_SYS_GLOBAL_INFO.selectByExample", example);
        return list;
    }

    public BSysGlobalInfo selectByPrimaryKey(String id) {
        BSysGlobalInfo _key = new BSysGlobalInfo();
        _key.setId(id);
        BSysGlobalInfo record = (BSysGlobalInfo) getSqlMapClientTemplate().queryForObject("B_SYS_GLOBAL_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BSysGlobalInfo record, BSysGlobalInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_SYS_GLOBAL_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BSysGlobalInfo record, BSysGlobalInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_SYS_GLOBAL_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BSysGlobalInfo record) {
        int rows = getSqlMapClientTemplate().update("B_SYS_GLOBAL_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BSysGlobalInfo record) {
        int rows = getSqlMapClientTemplate().update("B_SYS_GLOBAL_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BSysGlobalInfo> selectByPage(BSysGlobalInfoExample example, Page page) {
        List<BSysGlobalInfo> list = this.searchListPageMyObject("B_SYS_GLOBAL_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BSysGlobalInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BSysGlobalInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}