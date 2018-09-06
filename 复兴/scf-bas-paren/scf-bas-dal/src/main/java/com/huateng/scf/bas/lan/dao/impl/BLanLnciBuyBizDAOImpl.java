package com.huateng.scf.bas.lan.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.cnt.dao.model.BCntBuyInfo;
import com.huateng.scf.bas.lan.dao.IBLanLnciBuyBizDAO;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBuyBiz;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBuyBizExample;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BLnaLnciBuyBizDAO")
public class BLanLnciBuyBizDAOImpl extends IbatisDaoAnnotation4Template implements IBLanLnciBuyBizDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BLanLnciBuyBizDAOImpl() {
        super();
    }

    public int countByExample(BLanLnciBuyBizExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_LAN_LNCI_BUY_BIZ.countByExample", example);
        return count;
    }

    public int deleteByExample(BLanLnciBuyBizExample example) {
        int rows = getSqlMapClientTemplate().delete("B_LAN_LNCI_BUY_BIZ.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BLanLnciBuyBiz _key = new BLanLnciBuyBiz();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_LAN_LNCI_BUY_BIZ.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BLanLnciBuyBiz record) {
        getSqlMapClientTemplate().insert("B_LAN_LNCI_BUY_BIZ.insert", record);
    }

    public void insertSelective(BLanLnciBuyBiz record) {
        getSqlMapClientTemplate().insert("B_LAN_LNCI_BUY_BIZ.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BLanLnciBuyBiz> selectByExample(BLanLnciBuyBizExample example) {
        List<BLanLnciBuyBiz> list = getSqlMapClientTemplate().queryForList("B_LAN_LNCI_BUY_BIZ.selectByExample", example);
        return list;
    }
    
    @SuppressWarnings("unchecked")
    public List<BLanLnciBuyBiz> selectByAppnoAndTrade(Map map) {
        List<BLanLnciBuyBiz> list = getSqlMapClientTemplate().queryForList("B_LAN_LNCI_BUY_BIZ.selectByAppnoAndTrade", map);
        return list;
    }

    @SuppressWarnings("unchecked")
    public List<BLanLnciBuyBiz> selectByAppno(String appno) {
        List<BLanLnciBuyBiz> list = getSqlMapClientTemplate().queryForList("B_LAN_LNCI_BUY_BIZ.selectByAppno", appno);
        return list;
    }

    public BLanLnciBuyBiz selectByPrimaryKey(String id) {
        BLanLnciBuyBiz _key = new BLanLnciBuyBiz();
        _key.setId(id);
        BLanLnciBuyBiz record = (BLanLnciBuyBiz) getSqlMapClientTemplate().queryForObject("B_LAN_LNCI_BUY_BIZ.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BLanLnciBuyBiz record, BLanLnciBuyBizExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_LAN_LNCI_BUY_BIZ.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BLanLnciBuyBiz record, BLanLnciBuyBizExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_LAN_LNCI_BUY_BIZ.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BLanLnciBuyBiz record) {
        int rows = getSqlMapClientTemplate().update("B_LAN_LNCI_BUY_BIZ.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BLanLnciBuyBiz record) {
        int rows = getSqlMapClientTemplate().update("B_LAN_LNCI_BUY_BIZ.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BLanLnciBuyBiz> selectByPage(BLanLnciBuyBizExample example, Page page) {
        List<BLanLnciBuyBiz> list = this.searchListPageMyObject("B_LAN_LNCI_BUY_BIZ.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BLanLnciBuyBizExample {
        private Object record;

        public UpdateByExampleParms(Object record, BLanLnciBuyBizExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    //EXT
    /**
     * 根据条件查询放款申请购销合同流水信息
     * @param bLanLnciBuyBiz
     * @return
     */
    public List<BLanLnciBuyBiz> queryByCondition(BLanLnciBuyBiz bLanLnciBuyBiz) {
    	 List<BLanLnciBuyBiz> list = getSqlMapClientTemplate().queryForList("EXT_B_LAN_LNCI_BUY_BIZ.queryByCondition", bLanLnciBuyBiz);
         return list;
    }

}