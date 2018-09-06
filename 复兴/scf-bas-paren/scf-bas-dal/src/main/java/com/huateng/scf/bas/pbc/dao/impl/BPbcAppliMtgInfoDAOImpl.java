package com.huateng.scf.bas.pbc.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliMtgInfoDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("BPbcAppliMtgInfoDAO")
public class BPbcAppliMtgInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBPbcAppliMtgInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BPbcAppliMtgInfoDAOImpl() {
        super();
    }

    public int countByExample(BPbcAppliMtgInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_PBC_APPLI_MTG_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BPbcAppliMtgInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_PBC_APPLI_MTG_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BPbcAppliMtgInfo _key = new BPbcAppliMtgInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_PBC_APPLI_MTG_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BPbcAppliMtgInfo record) {
        getSqlMapClientTemplate().insert("B_PBC_APPLI_MTG_INFO.insert", record);
    }

    public void insertSelective(BPbcAppliMtgInfo record) {
        getSqlMapClientTemplate().insert("B_PBC_APPLI_MTG_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BPbcAppliMtgInfo> selectByExample(BPbcAppliMtgInfoExample example) {
        List<BPbcAppliMtgInfo> list = getSqlMapClientTemplate().queryForList("B_PBC_APPLI_MTG_INFO.selectByExample", example);
        return list;
    }

    public BPbcAppliMtgInfo selectByPrimaryKey(String id) {
        BPbcAppliMtgInfo _key = new BPbcAppliMtgInfo();
        _key.setId(id);
        BPbcAppliMtgInfo record = (BPbcAppliMtgInfo) getSqlMapClientTemplate().queryForObject("B_PBC_APPLI_MTG_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BPbcAppliMtgInfo record, BPbcAppliMtgInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PBC_APPLI_MTG_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BPbcAppliMtgInfo record, BPbcAppliMtgInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PBC_APPLI_MTG_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BPbcAppliMtgInfo record) {
        int rows = getSqlMapClientTemplate().update("B_PBC_APPLI_MTG_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BPbcAppliMtgInfo record) {
        int rows = getSqlMapClientTemplate().update("B_PBC_APPLI_MTG_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BPbcAppliMtgInfo> selectByPage(BPbcAppliMtgInfoExample example, Page page) {
        List<BPbcAppliMtgInfo> list = this.searchListPageMyObject("B_PBC_APPLI_MTG_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BPbcAppliMtgInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BPbcAppliMtgInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    //EXT
    /**
     *  根据appno查询押品申请表信息
     * @param appno
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<BPbcAppliMtgInfo> selectByAppno(String appno) {
        List<BPbcAppliMtgInfo> list = getSqlMapClientTemplate().queryForList("EXT_B_PBC_APPLI_MTG_INFO.selectByAppno", appno);
        return list;
    }
    /**
     *  根据appno获取本次申请下的购销合同已提货金额
     * @param appno
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<BPbcAppliMtgInfo> getTradeAppliTotPriceByAppno(String appno) {
        List<BPbcAppliMtgInfo> list = getSqlMapClientTemplate().queryForList("EXT_B_PBC_APPLI_MTG_INFO.getTradeAppliTotPriceByAppno", appno);
        return list;
    }
}