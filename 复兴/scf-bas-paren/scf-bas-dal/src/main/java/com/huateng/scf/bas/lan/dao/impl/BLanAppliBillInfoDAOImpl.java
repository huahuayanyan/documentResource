package com.huateng.scf.bas.lan.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.lan.dao.IBLanAppliBillInfoDAO;
import com.huateng.scf.bas.lan.dao.model.BLanAppliBillInfo;
import com.huateng.scf.bas.lan.dao.model.BLanAppliBillInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BLanAppliBillInfoDAO")
public class BLanAppliBillInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBLanAppliBillInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BLanAppliBillInfoDAOImpl() {
        super();
    }

    public int countByExample(BLanAppliBillInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_LAN_APPLI_BILL_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BLanAppliBillInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_LAN_APPLI_BILL_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BLanAppliBillInfo _key = new BLanAppliBillInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_LAN_APPLI_BILL_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BLanAppliBillInfo record) {
        getSqlMapClientTemplate().insert("B_LAN_APPLI_BILL_INFO.insert", record);
    }

    public void insertSelective(BLanAppliBillInfo record) {
        getSqlMapClientTemplate().insert("B_LAN_APPLI_BILL_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BLanAppliBillInfo> selectByExample(BLanAppliBillInfoExample example) {
        List<BLanAppliBillInfo> list = getSqlMapClientTemplate().queryForList("B_LAN_APPLI_BILL_INFO.selectByExample", example);
        return list;
    }
    
    @SuppressWarnings("unchecked")
    public List<BLanAppliBillInfo> selectByAppno(String appno) {
        List<BLanAppliBillInfo> list = getSqlMapClientTemplate().queryForList("B_LAN_APPLI_BILL_INFO.selectByAppno", appno);
        return list;
    }

    public BLanAppliBillInfo selectByPrimaryKey(String id) {
        BLanAppliBillInfo _key = new BLanAppliBillInfo();
        _key.setId(id);
        BLanAppliBillInfo record = (BLanAppliBillInfo) getSqlMapClientTemplate().queryForObject("B_LAN_APPLI_BILL_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public BLanAppliBillInfo selectByBillId(String billid) {
        BLanAppliBillInfo record = (BLanAppliBillInfo) getSqlMapClientTemplate().queryForObject("B_LAN_APPLI_BILL_INFO.selectByBillId", billid);
        return record;
    }
    
    public int updateByExampleSelective(BLanAppliBillInfo record, BLanAppliBillInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_LAN_APPLI_BILL_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BLanAppliBillInfo record, BLanAppliBillInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_LAN_APPLI_BILL_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BLanAppliBillInfo record) {
        int rows = getSqlMapClientTemplate().update("B_LAN_APPLI_BILL_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BLanAppliBillInfo record) {
        int rows = getSqlMapClientTemplate().update("B_LAN_APPLI_BILL_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BLanAppliBillInfo> selectByPage(BLanAppliBillInfoExample example, Page page) {
        List<BLanAppliBillInfo> list = this.searchListPageMyObject("B_LAN_APPLI_BILL_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BLanAppliBillInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BLanAppliBillInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}