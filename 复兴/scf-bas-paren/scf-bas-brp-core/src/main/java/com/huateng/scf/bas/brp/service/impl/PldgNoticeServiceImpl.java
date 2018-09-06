package com.huateng.scf.bas.brp.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huateng.scf.brp.notice.service.INoticeExportReportService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("PldgNoticeServiceImpl")
public class PldgNoticeServiceImpl implements INoticeExportReportService {

	@Override
	public Map<String, Object> getContentMap(Map<String, String> params) throws ScubeBizException {
		Map<String, Object> showValues = new HashMap<String, Object>();
		showValues.put("NOTICE_NO","201509100001");//Parameter35  	(35)
		showValues.put("thrName","xxxxx");//Parameter36  	(36)
		showValues.put("protocolNo","JG201509100001");
		showValues.put("firName","供应链金融");//Parameter38  	(38)
		return showValues;
	}

	@Override
	public Collection<?> getIterativeData(Map<String, String> params) throws ScubeBizException {
		  Map map=new HashMap();
          map.put("name", "哈哈哈");
          map.put("model", "1");
          Map map1=new HashMap();
          map1.put("name", "呵呵呵");
          map1.put("model", "2");
          List list=new ArrayList();
          list.add(map);
          list.add(map1);
          return list;
	}

	@Override
	public List<Map<String, Object>> getContentMapMultiRecord(Map<String, String> params) throws ScubeBizException {
 
		return null;
	}

}
