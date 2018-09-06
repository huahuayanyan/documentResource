package com.huateng.scf.bas.nte.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.nte.dao.model.NoticeQryVO;

public interface IBNetNoticeQryVODAO {
    //改为分页
	List<NoticeQryVO> queryNoticeQryVO(Map<String,Object> param,Page page);

}
