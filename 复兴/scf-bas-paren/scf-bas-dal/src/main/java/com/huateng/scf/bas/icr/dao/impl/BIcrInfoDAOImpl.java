package com.huateng.scf.bas.icr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.icr.dao.IBIcrInfoDAO;
import com.huateng.scf.bas.icr.dao.model.BIcrInfo;
import com.huateng.scf.bas.icr.dao.model.BIcrInfoExample;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("BIcrInfoDAO")
public class BIcrInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBIcrInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BIcrInfoDAOImpl() {
        super();
    }

    public int countByExample(BIcrInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_ICR_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BIcrInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_ICR_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String creditNo) {
        BIcrInfo _key = new BIcrInfo();
        _key.setCreditNo(creditNo);
        int rows = getSqlMapClientTemplate().delete("B_ICR_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BIcrInfo record) {
        getSqlMapClientTemplate().insert("B_ICR_INFO.insert", record);
    }

    public void insertSelective(BIcrInfo record) {
        getSqlMapClientTemplate().insert("B_ICR_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BIcrInfo> selectByExample(BIcrInfoExample example) {
        List<BIcrInfo> list = getSqlMapClientTemplate().queryForList("B_ICR_INFO.selectByExample", example);
        return list;
    }
    
    @SuppressWarnings("unchecked")
    public List<BIcrInfo> selectByParam(BIcrInfo bIcrInfo) {
        List<BIcrInfo> list = getSqlMapClientTemplate().queryForList("B_ICR_INFO.selectByParam", bIcrInfo);
        return list;
    }

    public BIcrInfo selectByPrimaryKey(String creditNo) {
        BIcrInfo _key = new BIcrInfo();
        _key.setCreditNo(creditNo);
        BIcrInfo record = (BIcrInfo) getSqlMapClientTemplate().queryForObject("B_ICR_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BIcrInfo record, BIcrInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_ICR_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BIcrInfo record, BIcrInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_ICR_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BIcrInfo record) {
        int rows = getSqlMapClientTemplate().update("B_ICR_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BIcrInfo record) {
        int rows = getSqlMapClientTemplate().update("B_ICR_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BIcrInfo> selectByPage(BIcrInfoExample example, Page page) {
        List<BIcrInfo> list = this.searchListPageMyObject("B_ICR_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BIcrInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BIcrInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    
    //ext

	/**
	 * 额度信息列表
	 */
	@SuppressWarnings("unchecked")
	public List<BIcrInfo> selectListByPage(BIcrInfo bIcrInfo, Page page) {
		List<BIcrInfo> list =this.searchListPageMyObject("EXT_B_ICR_INFO.selectBIcrInfoList", bIcrInfo,page);
		return list;
	}
	/**
	 * 根据编号查询已领用生效额度列表
	 */
    @SuppressWarnings("unchecked")
    public List<BIcrInfo> selectDrawInfoListByCreditNo(BIcrInfo bIcrInfo,Page page) {
		
		List<BIcrInfo> list =this.searchListPageMyObject("EXT_B_ICR_INFO.selectDrawInfoListByCreditNo", bIcrInfo,page);
        return list;
    }
	/**
	 * 已领用生效额度列表
	 */
    @SuppressWarnings("unchecked")
    public List<BIcrInfo> selectDrawInfoList(BIcrInfo bIcrInfo,Page page) {
		
		List<BIcrInfo> list =this.searchListPageMyObject("EXT_B_ICR_INFO.selectDrawInfoList", bIcrInfo,page);
        return list;
    }
	/**
	 * 分项额度信息列表查询
	 */
    @SuppressWarnings("unchecked")
    public List<BIcrInfo> selectSubInfoList(BIcrInfo bIcrInfo,Page page) {
		
		List<BIcrInfo> list =this.searchListPageMyObject("EXT_B_ICR_INFO.selectSubInfoList", bIcrInfo,page);
        return list;
    }
    //根据额度编号查询额度信息及上级额度信息
    public BIcrInfo selectInfoOrUpByCreditNo(BIcrInfo bIcrInfo) {
    	bIcrInfo =(BIcrInfo) this.getSqlMapClientTemplate().queryForObject("EXT_B_ICR_INFO.selectInfoOrUpBycreditNo", bIcrInfo);
    	return bIcrInfo;
	}

	@Override
	//根据额度编号更新额度状态及分项额度状态
	public int updateInfoOrUpBycreditNo(BIcrInfo  bIcrInfo) {
        int rows = getSqlMapClientTemplate().update("EXT_B_ICR_INFO.updateInfoOrUpBycreditNo", bIcrInfo);
		return rows;
	}
 /**
  * 可以领用间接额度查询
  */
	@SuppressWarnings("unchecked")
    public List<BIcrInfo> findBIcrInfoDrawByPage(BIcrInfo bIcrInfo,Page page) {
		List<BIcrInfo> list =this.searchListPageMyObject("EXT_B_ICR_INFO.findBIcrInfoDrawByPage", bIcrInfo,page);
        return list;
    }
   //根据额度编号查询额度信息
    public BIcrInfo selectInfoMainByCreditNo(BIcrInfo bIcrInfo) {
    	bIcrInfo =(BIcrInfo) this.getSqlMapClientTemplate().queryForObject("EXT_B_ICR_INFO.selectInfoMainBycreditNo", bIcrInfo);
    	return bIcrInfo;
	}
    /*****************间接额度回收Recover begin************************/
	@SuppressWarnings("unchecked")
    public List<BIcrInfo> findBIcrInfoRecoverByPage(BIcrInfo bIcrInfo,Page page) {
		List<BIcrInfo> list =this.searchListPageMyObject("EXT_B_ICR_INFO.findBIcrInfoRecoverByPage", bIcrInfo,page);
        return list;
    }
    /*****************间接额度回收Recover begin************************/
	/******************间接额度使用流水查询**************************/
    /**
     * 间接额度使用流水查询
     */
	@Override
	public List<BIcrInfo> findBIcrInfoFlowQryByPage(BIcrInfo bIcrInfo, Page page) {
		List<BIcrInfo> list = this.searchListPageMyObject("EXT_B_ICR_INFO.selectBIcrInfoFlowList", bIcrInfo, page);
		return list;
	}

	/**
	 * 额度检查接口
	 * 
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<BIcrInfo> checkCredit(Map map) {
		List<BIcrInfo> list = getSqlMapClientTemplate().queryForList("EXT_B_ICR_INFO.checkCredit", map);
		return list;
	}
}