package com.huateng.scf.bas.lan.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.lan.dao.IBLanLnciBuyInfoDAO;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBuyInfo;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBuyInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BLanLnciBuyInfoDAO")
public class BLanLnciBuyInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBLanLnciBuyInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BLanLnciBuyInfoDAOImpl() {
        super();
    }

    public int countByExample(BLanLnciBuyInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_LAN_LNCI_BUY_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BLanLnciBuyInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_LAN_LNCI_BUY_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BLanLnciBuyInfo _key = new BLanLnciBuyInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_LAN_LNCI_BUY_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BLanLnciBuyInfo record) {
        getSqlMapClientTemplate().insert("B_LAN_LNCI_BUY_INFO.insert", record);
    }

    public void insertSelective(BLanLnciBuyInfo record) {
        getSqlMapClientTemplate().insert("B_LAN_LNCI_BUY_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BLanLnciBuyInfo> selectByExample(BLanLnciBuyInfoExample example) {
        List<BLanLnciBuyInfo> list = getSqlMapClientTemplate().queryForList("B_LAN_LNCI_BUY_INFO.selectByExample", example);
        return list;
    }

    public BLanLnciBuyInfo selectByPrimaryKey(String id) {
        BLanLnciBuyInfo _key = new BLanLnciBuyInfo();
        _key.setId(id);
        BLanLnciBuyInfo record = (BLanLnciBuyInfo) getSqlMapClientTemplate().queryForObject("B_LAN_LNCI_BUY_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BLanLnciBuyInfo record, BLanLnciBuyInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_LAN_LNCI_BUY_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BLanLnciBuyInfo record, BLanLnciBuyInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_LAN_LNCI_BUY_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BLanLnciBuyInfo record) {
        int rows = getSqlMapClientTemplate().update("B_LAN_LNCI_BUY_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BLanLnciBuyInfo record) {
        int rows = getSqlMapClientTemplate().update("B_LAN_LNCI_BUY_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BLanLnciBuyInfo> selectByPage(BLanLnciBuyInfoExample example, Page page) {
        List<BLanLnciBuyInfo> list = this.searchListPageMyObject("B_LAN_LNCI_BUY_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BLanLnciBuyInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BLanLnciBuyInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}