package com.huateng.scf.bas.cnt.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.cnt.dao.IBCntMprotPartInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfoExample;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("BCntMprotPartInfoDAO")
public class BCntMprotPartInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBCntMprotPartInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCntMprotPartInfoDAOImpl() {
        super();
    }

    public int countByExample(BCntMprotPartInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CNT_MPROT_PART_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BCntMprotPartInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CNT_MPROT_PART_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BCntMprotPartInfo _key = new BCntMprotPartInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_CNT_MPROT_PART_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCntMprotPartInfo record) {
        getSqlMapClientTemplate().insert("B_CNT_MPROT_PART_INFO.insert", record);
    }

    public void insertSelective(BCntMprotPartInfo record) {
        getSqlMapClientTemplate().insert("B_CNT_MPROT_PART_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCntMprotPartInfo> selectByExample(BCntMprotPartInfoExample example) {
        List<BCntMprotPartInfo> list = getSqlMapClientTemplate().queryForList("B_CNT_MPROT_PART_INFO.selectByExample", example);
        return list;
    }

    public BCntMprotPartInfo selectByPrimaryKey(String id) {
        BCntMprotPartInfo _key = new BCntMprotPartInfo();
        _key.setId(id);
        BCntMprotPartInfo record = (BCntMprotPartInfo) getSqlMapClientTemplate().queryForObject("B_CNT_MPROT_PART_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCntMprotPartInfo record, BCntMprotPartInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CNT_MPROT_PART_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCntMprotPartInfo record, BCntMprotPartInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CNT_MPROT_PART_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCntMprotPartInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CNT_MPROT_PART_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCntMprotPartInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CNT_MPROT_PART_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCntMprotPartInfo> selectByPage(BCntMprotPartInfoExample example, Page page) {
        List<BCntMprotPartInfo> list = this.searchListPageMyObject("B_CNT_MPROT_PART_INFO.selectByExample", example, page);
        return list;
    }
    
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<BCntMprotPartInfo> selectByRole(Map map) {
    	List<BCntMprotPartInfo> list = getSqlMapClientTemplate().queryForList("B_CNT_MPROT_PART_INFO.selectByRole", map);
		return list;
	}

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCntMprotPartInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCntMprotPartInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    //ext
    /**
     * 通过protocolNo获得参与者的信息
     * @param protocolNo
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<BCntMprotPartInfo> findBCntMpartInfoByProtocolNo(String protocolNo) {
        List<BCntMprotPartInfo> list = getSqlMapClientTemplate().queryForList("EXT_B_CNT_MPROT_PART_INFO.findBCntMpartInfoByProtocolNo", protocolNo);
        return list;
    }
    
    
    
}