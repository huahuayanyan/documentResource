package com.huateng.scf.bas.sys.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.dao.model.BSysLnVal;
import com.huateng.scf.bas.sys.dao.model.BSysLnValExample;

import java.util.List;
/**
 * 
 * <p>BSysLnVal数据库访问层通用实现类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年12月12日上午10:31:06
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月12日上午10:31:06	     新增
 *
 * </pre>
 */
public interface IBSysLnValDAO {
    int countByExample(BSysLnValExample example);

    int deleteByExample(BSysLnValExample example);

    int deleteByPrimaryKey(String id);

    void insert(BSysLnVal record);

    void insertSelective(BSysLnVal record);

    List<BSysLnVal> selectByExample(BSysLnValExample example);

    BSysLnVal selectByPrimaryKey(String id);

    int updateByExampleSelective(BSysLnVal record, BSysLnValExample example);

    int updateByExample(BSysLnVal record, BSysLnValExample example);

    int updateByPrimaryKeySelective(BSysLnVal record);

    int updateByPrimaryKey(BSysLnVal record);

    List<BSysLnVal> selectByPage(BSysLnValExample example, Page page);

	BSysLnVal selectByRateid(String rateid);
}