package com.huateng.scf.bas.dcr.dao.ext;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;

public interface ExtBDcrLinTypDAO {
    List   queryCrNmSource(Map omap);
    List   queryCustList(Map omap, Page page);
}