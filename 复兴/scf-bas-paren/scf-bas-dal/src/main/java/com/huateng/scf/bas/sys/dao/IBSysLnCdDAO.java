package com.huateng.scf.bas.sys.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.dao.model.BSysLnCd;
import com.huateng.scf.bas.sys.dao.model.BSysLnCdExample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 
 * <p>BSysLnCd数据库访问层通用实现类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年12月12日上午10:30:56
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月12日上午10:30:56	     新增
 *
 * </pre>
 */
public interface IBSysLnCdDAO {
    int countByExample(BSysLnCdExample example);

    int deleteByExample(BSysLnCdExample example);

    int deleteByPrimaryKey(String id);

    void insert(BSysLnCd record);

    void insertSelective(BSysLnCd record);

    List<BSysLnCd> selectByExample(BSysLnCdExample example);

    BSysLnCd selectByPrimaryKey(String id);

    int updateByExampleSelective(BSysLnCd record, BSysLnCdExample example);

    int updateByExample(BSysLnCd record, BSysLnCdExample example);

    int updateByPrimaryKeySelective(BSysLnCd record);

    int updateByPrimaryKey(BSysLnCd record);

    List<BSysLnCd> selectByPage(BSysLnCdExample example, Page page);

	BSysLnCd selectByRatename(String ratename);

	BSysLnCd selectByRatecode(String ratecode);

	List<BSysLnCd> selectByLnCd(BSysLnCd bSysLnCd);

	List<BSysLnCd> selectByExtExample(Map<String, String> omap, Page page);

	int countByExtExample(HashMap<String, String> omap);
}