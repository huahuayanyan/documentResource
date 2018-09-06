package com.huateng.scf.bas.lan.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.lan.dao.IBLanBillBaseInfoDAO;
import com.huateng.scf.bas.lan.dao.model.BLanBillBaseInfo;
import com.huateng.scf.bas.lan.dao.model.BLanBillBaseInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("BLanBillBaseInfoDAO")
public class BLanBillBaseInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBLanBillBaseInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BLanBillBaseInfoDAOImpl() {
        super();
    }

    public int countByExample(BLanBillBaseInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_LAN_BILL_BASE_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BLanBillBaseInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_LAN_BILL_BASE_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BLanBillBaseInfo _key = new BLanBillBaseInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_LAN_BILL_BASE_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BLanBillBaseInfo record) {
        getSqlMapClientTemplate().insert("B_LAN_BILL_BASE_INFO.insert", record);
    }

    public void insertSelective(BLanBillBaseInfo record) {
        getSqlMapClientTemplate().insert("B_LAN_BILL_BASE_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BLanBillBaseInfo> selectByExample(BLanBillBaseInfoExample example) {
        List<BLanBillBaseInfo> list = getSqlMapClientTemplate().queryForList("B_LAN_BILL_BASE_INFO.selectByExample", example);
        return list;
    }
    
    @SuppressWarnings("unchecked")
    public List<BLanBillBaseInfo> selectByAppno(String appno) {
        List<BLanBillBaseInfo> list = getSqlMapClientTemplate().queryForList("B_LAN_BILL_BASE_INFO.selectByAppno", appno);
        return list;
    }

    public BLanBillBaseInfo selectByPrimaryKey(String id) {
        BLanBillBaseInfo _key = new BLanBillBaseInfo();
        _key.setId(id);
        BLanBillBaseInfo record = (BLanBillBaseInfo) getSqlMapClientTemplate().queryForObject("B_LAN_BILL_BASE_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BLanBillBaseInfo record, BLanBillBaseInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_LAN_BILL_BASE_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BLanBillBaseInfo record, BLanBillBaseInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_LAN_BILL_BASE_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BLanBillBaseInfo record) {
        int rows = getSqlMapClientTemplate().update("B_LAN_BILL_BASE_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BLanBillBaseInfo record) {
        int rows = getSqlMapClientTemplate().update("B_LAN_BILL_BASE_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BLanBillBaseInfo> selectByPage(BLanBillBaseInfoExample example, Page page) {
        List<BLanBillBaseInfo> list = this.searchListPageMyObject("B_LAN_BILL_BASE_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BLanBillBaseInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BLanBillBaseInfoExample example) {
            super(example);
            this.record = record;
        }
        
        public Object getRecord() {
            return record;
        }
    }
 
    //EXT
    /**
     * 根据借据号查询票据信息
     */
	@Override
	public List<BLanBillBaseInfo> findBLanBillInfoByDebetNo(String debetNo) {
		  List<BLanBillBaseInfo> list = getSqlMapClientTemplate().queryForList("EXT_B_LAN_BILL_BASE_INFO.findBLanBillInfoByDebetNo", debetNo);
		  return list;
	}
}