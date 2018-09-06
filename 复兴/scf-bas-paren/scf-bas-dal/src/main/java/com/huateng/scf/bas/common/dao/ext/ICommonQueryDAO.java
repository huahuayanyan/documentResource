package com.huateng.scf.bas.common.dao.ext;

import com.huateng.base.common.beans.Page;
import java.util.List;
import java.util.Map;

public interface ICommonQueryDAO {

	/**
	 * 公共查询接口
	 * @param sqlId
	 * @param param
	 * @param page
	 * @return
	 */
	List<Map<String,Object>> selectByPage(String sqlId, Map<String,Object> param, Page page);
}