package com.huateng.scf.bas.sys.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.sys.dao.IBSysUploadFileDAO;
import com.huateng.scf.bas.sys.dao.model.BSysUploadFile;
import com.huateng.scf.bas.sys.dao.model.BSysUploadFileExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("IBSysUploadFileDAO")
public class BSysUploadFileDAOImpl extends IbatisDaoAnnotation4Template implements IBSysUploadFileDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BSysUploadFileDAOImpl() {
        super();
    }

    public int countByExample(BSysUploadFileExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_SYS_UPLOAD_FILE.countByExample", example);
        return count;
    }

    public int deleteByExample(BSysUploadFileExample example) {
        int rows = getSqlMapClientTemplate().delete("B_SYS_UPLOAD_FILE.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BSysUploadFile _key = new BSysUploadFile();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_SYS_UPLOAD_FILE.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BSysUploadFile record) {
        getSqlMapClientTemplate().insert("B_SYS_UPLOAD_FILE.insert", record);
    }

    public void insertSelective(BSysUploadFile record) {
        getSqlMapClientTemplate().insert("B_SYS_UPLOAD_FILE.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BSysUploadFile> selectByExampleWithBLOBs(BSysUploadFileExample example) {
        List<BSysUploadFile> list = getSqlMapClientTemplate().queryForList("B_SYS_UPLOAD_FILE.selectByExampleWithBLOBs", example);
        return list;
    }

    @SuppressWarnings("unchecked")
    public List<BSysUploadFile> selectByExampleWithoutBLOBs(BSysUploadFileExample example) {
        List<BSysUploadFile> list = getSqlMapClientTemplate().queryForList("B_SYS_UPLOAD_FILE.selectByExample", example);
        return list;
    }

    public BSysUploadFile selectByPrimaryKey(String id) {
        BSysUploadFile _key = new BSysUploadFile();
        _key.setId(id);
        BSysUploadFile record = (BSysUploadFile) getSqlMapClientTemplate().queryForObject("B_SYS_UPLOAD_FILE.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BSysUploadFile record, BSysUploadFileExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_SYS_UPLOAD_FILE.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExampleWithBLOBs(BSysUploadFile record, BSysUploadFileExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_SYS_UPLOAD_FILE.updateByExampleWithBLOBs", parms);
        return rows;
    }

    public int updateByExampleWithoutBLOBs(BSysUploadFile record, BSysUploadFileExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_SYS_UPLOAD_FILE.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BSysUploadFile record) {
        int rows = getSqlMapClientTemplate().update("B_SYS_UPLOAD_FILE.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKeyWithBLOBs(BSysUploadFile record) {
        int rows = getSqlMapClientTemplate().update("B_SYS_UPLOAD_FILE.updateByPrimaryKeyWithBLOBs", record);
        return rows;
    }

    public int updateByPrimaryKeyWithoutBLOBs(BSysUploadFile record) {
        int rows = getSqlMapClientTemplate().update("B_SYS_UPLOAD_FILE.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BSysUploadFile> selectByPage(BSysUploadFileExample example, Page page) {
        List<BSysUploadFile> list = this.searchListPageMyObject("B_SYS_UPLOAD_FILE.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BSysUploadFileExample {
        private Object record;

        public UpdateByExampleParms(Object record, BSysUploadFileExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}