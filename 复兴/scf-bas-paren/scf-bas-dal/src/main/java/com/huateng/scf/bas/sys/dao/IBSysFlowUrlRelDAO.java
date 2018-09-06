package com.huateng.scf.bas.sys.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.dao.model.BSysFlowUrlRel;
import com.huateng.scf.bas.sys.dao.model.BSysFlowUrlRelExample;
import java.util.List;

public interface IBSysFlowUrlRelDAO {
    int countByExample(BSysFlowUrlRelExample example);

    int deleteByExample(BSysFlowUrlRelExample example);

    int deleteByPrimaryKey(String id);

    void insert(BSysFlowUrlRel record);

    void insertSelective(BSysFlowUrlRel record);

    List<BSysFlowUrlRel> selectByExample(BSysFlowUrlRelExample example);

    BSysFlowUrlRel selectByPrimaryKey(String id);

    int updateByExampleSelective(BSysFlowUrlRel record, BSysFlowUrlRelExample example);

    int updateByExample(BSysFlowUrlRel record, BSysFlowUrlRelExample example);

    int updateByPrimaryKeySelective(BSysFlowUrlRel record);

    int updateByPrimaryKey(BSysFlowUrlRel record);

    List<BSysFlowUrlRel> selectByPage(BSysFlowUrlRelExample example, Page page);
    
    /**
     * 根据根据flowId和nodeId查询流程配置关联页面信息 
     * @param bSysFlowUrlRel
     * 		BSysFlowUrlRel对象
     * @return BSysFlowUrlRel
     */
    public BSysFlowUrlRel selectByFlowAndNodeId(BSysFlowUrlRel bSysFlowUrlRel);
}