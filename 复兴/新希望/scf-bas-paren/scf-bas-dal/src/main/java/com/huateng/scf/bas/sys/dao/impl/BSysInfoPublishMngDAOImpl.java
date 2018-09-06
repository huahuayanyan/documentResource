package com.huateng.scf.bas.sys.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.sys.dao.IBSysInfoPublishMngDAO;
import com.huateng.scf.bas.sys.dao.model.BSysInfoPublishMng;
import com.huateng.scf.bas.sys.dao.model.BSysInfoPublishMngExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("BSysInfoPublishMngDAO")
public class BSysInfoPublishMngDAOImpl extends IbatisDaoAnnotation4Template implements IBSysInfoPublishMngDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BSysInfoPublishMngDAOImpl() {
        super();
    }

    public int countByExample(BSysInfoPublishMngExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_SYS_INFO_PUBLISH_MNG.countByExample", example);
        return count;
    }

    public int deleteByExample(BSysInfoPublishMngExample example) {
        int rows = getSqlMapClientTemplate().delete("B_SYS_INFO_PUBLISH_MNG.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BSysInfoPublishMng _key = new BSysInfoPublishMng();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_SYS_INFO_PUBLISH_MNG.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BSysInfoPublishMng record) {
        getSqlMapClientTemplate().insert("B_SYS_INFO_PUBLISH_MNG.insert", record);
    }

    public void insertSelective(BSysInfoPublishMng record) {
        getSqlMapClientTemplate().insert("B_SYS_INFO_PUBLISH_MNG.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BSysInfoPublishMng> selectByExample(BSysInfoPublishMngExample example) {
        List<BSysInfoPublishMng> list = getSqlMapClientTemplate().queryForList("B_SYS_INFO_PUBLISH_MNG.selectByExample", example);
        return list;
    }

    public BSysInfoPublishMng selectByPrimaryKey(String id) {
        BSysInfoPublishMng _key = new BSysInfoPublishMng();
        _key.setId(id);
        BSysInfoPublishMng record = (BSysInfoPublishMng) getSqlMapClientTemplate().queryForObject("B_SYS_INFO_PUBLISH_MNG.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BSysInfoPublishMng record, BSysInfoPublishMngExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_SYS_INFO_PUBLISH_MNG.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BSysInfoPublishMng record, BSysInfoPublishMngExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_SYS_INFO_PUBLISH_MNG.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BSysInfoPublishMng record) {
        int rows = getSqlMapClientTemplate().update("B_SYS_INFO_PUBLISH_MNG.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BSysInfoPublishMng record) {
        int rows = getSqlMapClientTemplate().update("B_SYS_INFO_PUBLISH_MNG.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BSysInfoPublishMng> selectByPage(BSysInfoPublishMngExample example, Page page) {
        List<BSysInfoPublishMng> list = this.searchListPageMyObject("B_SYS_INFO_PUBLISH_MNG.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BSysInfoPublishMngExample {
        private Object record;

        public UpdateByExampleParms(Object record, BSysInfoPublishMngExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}