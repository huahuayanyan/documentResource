package com.huateng.scf.bas.sys.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.dao.model.BSysUploadFile;
import com.huateng.scf.bas.sys.dao.model.BSysUploadFileExample;
import java.util.List;

public interface IBSysUploadFileDAO {
    int countByExample(BSysUploadFileExample example);

    int deleteByExample(BSysUploadFileExample example);

    int deleteByPrimaryKey(String id);

    void insert(BSysUploadFile record);

    void insertSelective(BSysUploadFile record);

    List<BSysUploadFile> selectByExampleWithBLOBs(BSysUploadFileExample example);

    List<BSysUploadFile> selectByExampleWithoutBLOBs(BSysUploadFileExample example);

    BSysUploadFile selectByPrimaryKey(String id);

    int updateByExampleSelective(BSysUploadFile record, BSysUploadFileExample example);

    int updateByExampleWithBLOBs(BSysUploadFile record, BSysUploadFileExample example);

    int updateByExampleWithoutBLOBs(BSysUploadFile record, BSysUploadFileExample example);

    int updateByPrimaryKeySelective(BSysUploadFile record);

    int updateByPrimaryKeyWithBLOBs(BSysUploadFile record);

    int updateByPrimaryKeyWithoutBLOBs(BSysUploadFile record);

    List<BSysUploadFile> selectByPage(BSysUploadFileExample example, Page page);
}