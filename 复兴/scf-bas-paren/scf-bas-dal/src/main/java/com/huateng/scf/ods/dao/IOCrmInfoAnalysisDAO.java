package com.huateng.scf.ods.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.ods.dao.model.OCrmInfoAnalysis;
import com.huateng.scf.ods.dao.model.OCrmInfoAnalysisExample;
import java.util.List;

public interface IOCrmInfoAnalysisDAO {
    int countByExample(OCrmInfoAnalysisExample example);

    int deleteByExample(OCrmInfoAnalysisExample example);

    int deleteByPrimaryKey(String id);

    void insert(OCrmInfoAnalysis record);

    void insertSelective(OCrmInfoAnalysis record);

    List<OCrmInfoAnalysis> selectByExample(OCrmInfoAnalysisExample example);

    OCrmInfoAnalysis selectByPrimaryKey(String id);

    int updateByExampleSelective(OCrmInfoAnalysis record, OCrmInfoAnalysisExample example);

    int updateByExample(OCrmInfoAnalysis record, OCrmInfoAnalysisExample example);

    int updateByPrimaryKeySelective(OCrmInfoAnalysis record);

    int updateByPrimaryKey(OCrmInfoAnalysis record);

    List<OCrmInfoAnalysis> selectByPage(OCrmInfoAnalysisExample example, Page page);
}