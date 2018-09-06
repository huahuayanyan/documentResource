package com.huateng.scf.bas.sys.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.dao.model.BSysSerialNo;
import com.huateng.scf.bas.sys.dao.model.BSysSerialNoExample;
import java.util.List;

public interface IBSysSerialNoDAO {
    int countByExample(BSysSerialNoExample example);

    int deleteByExample(BSysSerialNoExample example);

    int deleteByPrimaryKey(String serialCode);

    void insert(BSysSerialNo record);

    void insertSelective(BSysSerialNo record);

    List<BSysSerialNo> selectByExample(BSysSerialNoExample example);

    BSysSerialNo selectByPrimaryKey(String serialCode);

    int updateByExampleSelective(BSysSerialNo record, BSysSerialNoExample example);

    int updateByExample(BSysSerialNo record, BSysSerialNoExample example);

    int updateByPrimaryKeySelective(BSysSerialNo record);

    int updateByPrimaryKey(BSysSerialNo record);

    List<BSysSerialNo> selectByPage(BSysSerialNoExample example, Page page);
    /**
     * 根据序号代码查询序号表的当前序号和序号格式组成的字符串
     * @param bSysSerialNo
     * 		String-序号代码
     * @return 当前序号和序号格式组成的字符串，如:16|CRM[yyyyMMdd]{##########}
     */
    public String queryBSysSerialNoBySerialCode(BSysSerialNo bSysSerialNo);
}