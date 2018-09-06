package com.huateng.scf.bas.cnt.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.cnt.dao.IBCntDebtExtInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtExtInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtExtInfoExample;
import com.huateng.scf.bas.cnt.dao.model.DebtContVO;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("BCntDebtExtInfoDAO")
public class BCntDebtExtInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBCntDebtExtInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCntDebtExtInfoDAOImpl() {
        super();
    }

    public int countByExample(BCntDebtExtInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CNT_DEBT_EXT_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BCntDebtExtInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CNT_DEBT_EXT_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BCntDebtExtInfo _key = new BCntDebtExtInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_CNT_DEBT_EXT_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCntDebtExtInfo record) {
        getSqlMapClientTemplate().insert("B_CNT_DEBT_EXT_INFO.insert", record);
    }

    public void insertSelective(BCntDebtExtInfo record) {
        getSqlMapClientTemplate().insert("B_CNT_DEBT_EXT_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCntDebtExtInfo> selectByExample(BCntDebtExtInfoExample example) {
        List<BCntDebtExtInfo> list = getSqlMapClientTemplate().queryForList("B_CNT_DEBT_EXT_INFO.selectByExample", example);
        return list;
    }

    public BCntDebtExtInfo selectByPrimaryKey(String id) {
        BCntDebtExtInfo _key = new BCntDebtExtInfo();
        _key.setId(id);
        BCntDebtExtInfo record = (BCntDebtExtInfo) getSqlMapClientTemplate().queryForObject("B_CNT_DEBT_EXT_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCntDebtExtInfo record, BCntDebtExtInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CNT_DEBT_EXT_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCntDebtExtInfo record, BCntDebtExtInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CNT_DEBT_EXT_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCntDebtExtInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CNT_DEBT_EXT_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCntDebtExtInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CNT_DEBT_EXT_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCntDebtExtInfo> selectByPage(BCntDebtExtInfoExample example, Page page) {
        List<BCntDebtExtInfo> list = this.searchListPageMyObject("B_CNT_DEBT_EXT_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCntDebtExtInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCntDebtExtInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    //ext
    /**
     * 根据合同编号获得交易对手信息
     * @param bCntDebtExtInfo
     * @return
     */
    public List<DebtContVO> findDebtExtInfoByContno(Map<String, String> map,Page page) {
        List<DebtContVO> list = this.searchListPageMyObject("EXT_B_CNT_DEBT_EXT_INFO.findDebtExtInfoByContno", map,page);
        return list;
    }

	@Override
	public void deleteDebtExtInfoByContno(Map<String, String> map) {
		 getSqlMapClientTemplate().delete("EXT_B_CNT_DEBT_EXT_INFO.deleteDebtExtInfoByContno", map);
		
	}
	
	  /**
     * 查询业务合同扩展表
     * @param bCntDebtExtInfo
     * @return
     */
	@Override
    public List<BCntDebtExtInfo> selectIfspDebtExtInfoByContno(Map<String, String> map) {
        List<BCntDebtExtInfo> list = getSqlMapClientTemplate().queryForList("EXT_B_CNT_DEBT_EXT_INFO.findDebtExtInfoByContno", map);
        return list;
    }
}