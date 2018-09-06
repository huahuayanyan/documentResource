package com.huateng.scf.bas.sys.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.dao.model.BSysApplyDtl;
import com.huateng.scf.bas.sys.dao.model.BSysApplyDtlExample;

public interface IBSysApplyDtlDAO {
    int countByExample(BSysApplyDtlExample example);

    int deleteByExample(BSysApplyDtlExample example);

    int deleteByPrimaryKey(String id);

    public String insert(BSysApplyDtl record);

    public String  insertSelective(BSysApplyDtl record);

    List<BSysApplyDtl> selectByExample(BSysApplyDtlExample example);

    BSysApplyDtl selectByPrimaryKey(String id);

    int updateByExampleSelective(BSysApplyDtl record, BSysApplyDtlExample example);

    int updateByExample(BSysApplyDtl record, BSysApplyDtlExample example);

    int updateByPrimaryKeySelective(BSysApplyDtl record);

    int updateByPrimaryKey(BSysApplyDtl record);

    List<BSysApplyDtl> selectByPage(BSysApplyDtlExample example, Page page);
    /**
     * 查询审批意见列表
     * @param page
     * 		Page对象
     * @param map
     * 		Map对象
     * @param isBypPage
     * 		boolean-[true-分页查询,false-不分页]
     * @return
     */
    public Page queryBsysApplyDtlList(Page page,Map map,boolean isBypPage);
}