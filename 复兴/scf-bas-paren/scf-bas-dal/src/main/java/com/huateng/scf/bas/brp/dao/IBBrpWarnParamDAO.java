package com.huateng.scf.bas.brp.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.dao.model.BBrpWarnParam;
import com.huateng.scf.bas.brp.dao.model.BBrpWarnParamExample;
import com.huateng.scf.bas.brp.dao.model.WarnParamVO;

import java.util.List;
import java.util.Map;

public interface IBBrpWarnParamDAO {
    int countByExample(BBrpWarnParamExample example);

    int deleteByExample(BBrpWarnParamExample example);

    int deleteByPrimaryKey(String warnNo);

    void insert(BBrpWarnParam record);

    void insertSelective(BBrpWarnParam record);

    List<BBrpWarnParam> selectByExample(BBrpWarnParamExample example);

    BBrpWarnParam selectByPrimaryKey(String warnNo);

    int updateByExampleSelective(BBrpWarnParam record, BBrpWarnParamExample example);

    int updateByExample(BBrpWarnParam record, BBrpWarnParamExample example);

    int updateByPrimaryKeySelective(BBrpWarnParam record);

    int updateByPrimaryKey(BBrpWarnParam record);

    List<BBrpWarnParam> selectByPage(BBrpWarnParamExample example, Page page);
    //ext
    /**
     * 获取预警信息
     * @param omap
     * @return
     */
    public List<WarnParamVO> getWarningInfo(Map<String, Object> omap,Page page);
}