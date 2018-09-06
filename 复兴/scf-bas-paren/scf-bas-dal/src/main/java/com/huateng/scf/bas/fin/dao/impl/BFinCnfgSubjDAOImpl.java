package com.huateng.scf.bas.fin.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.fin.dao.IBFinCnfgSubjDAO;
import com.huateng.scf.bas.fin.dao.model.BFinCnfgSubj;
import com.huateng.scf.bas.fin.dao.model.BFinCnfgSubjExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>BFinCnfgSubj数据库访问层通用接口类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月5日下午5:25:06
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月5日下午5:25:06	     新增
 *
 * </pre>
 */
@Repository("IBFinCnfgSubjDAO")
public class BFinCnfgSubjDAOImpl extends IbatisDaoAnnotation4Template implements IBFinCnfgSubjDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BFinCnfgSubjDAOImpl() {
        super();
    }

    @Override
    public int countByExample(BFinCnfgSubjExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_FIN_CNFG_SUBJ.countByExample", example);
        return count;
    }

    @Override
    public int deleteByExample(BFinCnfgSubjExample example) {
        int rows = getSqlMapClientTemplate().delete("B_FIN_CNFG_SUBJ.deleteByExample", example);
        return rows;
    }

    @Override
    public int deleteByPrimaryKey(String subjId) {
        BFinCnfgSubj _key = new BFinCnfgSubj();
        _key.setSubjId(subjId);
        int rows = getSqlMapClientTemplate().delete("B_FIN_CNFG_SUBJ.deleteByPrimaryKey", _key);
        return rows;
    }

    @Override
    public String insert(BFinCnfgSubj record) {
    	Object newKey = getSqlMapClientTemplate().insert("B_FIN_CNFG_SUBJ.insert", record);
    	return (String) newKey;
    }

    @Override
    public String insertSelective(BFinCnfgSubj record) {
    	Object newKey = getSqlMapClientTemplate().insert("B_FIN_CNFG_SUBJ.insertSelective", record);
    	return (String) newKey;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<BFinCnfgSubj> selectByExample(BFinCnfgSubjExample example) {
        List<BFinCnfgSubj> list = getSqlMapClientTemplate().queryForList("B_FIN_CNFG_SUBJ.selectByExample", example);
        return list;
    }

    @Override
    public BFinCnfgSubj selectByPrimaryKey(String subjId) {
        BFinCnfgSubj _key = new BFinCnfgSubj();
        _key.setSubjId(subjId);
        BFinCnfgSubj record = (BFinCnfgSubj) getSqlMapClientTemplate().queryForObject("B_FIN_CNFG_SUBJ.selectByPrimaryKey", _key);
        return record;
    }

    @Override
    public BFinCnfgSubj selectBySubjNm(String subjNm) {
        BFinCnfgSubj _subjNm = new BFinCnfgSubj();
        _subjNm.setSubjNm(subjNm);
        BFinCnfgSubj record = (BFinCnfgSubj) getSqlMapClientTemplate().queryForObject("B_FIN_CNFG_SUBJ.selectBySubjNm", _subjNm);
        return record;
	}

    @Override
    public int updateByExampleSelective(BFinCnfgSubj record, BFinCnfgSubjExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_FIN_CNFG_SUBJ.updateByExampleSelective", parms);
        return rows;
    }

    @Override
    public int updateByExample(BFinCnfgSubj record, BFinCnfgSubjExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_FIN_CNFG_SUBJ.updateByExample", parms);
        return rows;
    }

    @Override
    public int updateByPrimaryKeySelective(BFinCnfgSubj record) {
        int rows = getSqlMapClientTemplate().update("B_FIN_CNFG_SUBJ.updateByPrimaryKeySelective", record);
        return rows;
    }

    @Override
    public int updateByPrimaryKey(BFinCnfgSubj record) {
        int rows = getSqlMapClientTemplate().update("B_FIN_CNFG_SUBJ.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<BFinCnfgSubj> selectByPage(BFinCnfgSubjExample example, Page page) {
        List<BFinCnfgSubj> list = this.searchListPageMyObject("B_FIN_CNFG_SUBJ.selectByExample", example, page);
        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
	public List<BFinCnfgSubj> selectBySubj(BFinCnfgSubj bFinCnfgSubj) {
    	List<BFinCnfgSubj> record =  getSqlMapClientTemplate().queryForList("B_FIN_CNFG_SUBJ.selectBySubj", bFinCnfgSubj);
        return record;
	}

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BFinCnfgSubjExample {
        private Object record;

        public UpdateByExampleParms(Object record, BFinCnfgSubjExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

}