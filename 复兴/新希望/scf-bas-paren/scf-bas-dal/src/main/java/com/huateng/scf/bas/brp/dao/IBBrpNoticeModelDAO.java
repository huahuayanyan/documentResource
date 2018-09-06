package com.huateng.scf.bas.brp.dao;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.dao.model.BBrpCostParam;
import com.huateng.scf.bas.brp.dao.model.BBrpCostParamExample;
import com.huateng.scf.bas.brp.dao.model.BBrpNoticeModel;
import com.huateng.scf.bas.brp.dao.model.BBrpNoticeModelExample;

public interface IBBrpNoticeModelDAO {


    List<BBrpNoticeModel> selectByPage(BBrpNoticeModelExample example, Page page);
    List<BBrpNoticeModel> selectByExample(BBrpNoticeModelExample example);
    int updateByPrimaryKey(BBrpNoticeModel record);
    void insert(BBrpNoticeModel record);
    int deleteByPrimaryKey(String id);
    BBrpNoticeModel selectByPrimaryKey(String id);
	BBrpNoticeModel selectByNoticeType(String noticeType);
}