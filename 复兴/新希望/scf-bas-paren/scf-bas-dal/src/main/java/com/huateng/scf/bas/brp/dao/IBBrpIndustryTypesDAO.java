package com.huateng.scf.bas.brp.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.dao.model.BBrpIndustryTypes;
import com.huateng.scf.bas.brp.dao.model.BBrpIndustryTypesExample;
import java.util.List;

public interface IBBrpIndustryTypesDAO {
    int countByExample(BBrpIndustryTypesExample example);

    int deleteByExample(BBrpIndustryTypesExample example);

    int deleteByPrimaryKey(String industryCode);

    void insert(BBrpIndustryTypes record);

    void insertSelective(BBrpIndustryTypes record);

    List<BBrpIndustryTypes> selectByExample(BBrpIndustryTypesExample example);

    BBrpIndustryTypes selectByPrimaryKey(String industryCode);

    int updateByExampleSelective(BBrpIndustryTypes record, BBrpIndustryTypesExample example);

    int updateByExample(BBrpIndustryTypes record, BBrpIndustryTypesExample example);

    int updateByPrimaryKeySelective(BBrpIndustryTypes record);

    int updateByPrimaryKey(BBrpIndustryTypes record);

    List<BBrpIndustryTypes> selectByPage(BBrpIndustryTypesExample example, Page page);
}