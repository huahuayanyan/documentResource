package com.huateng.scf.bas.crr.test;

import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.huateng.common.api.model.AccountModel;
import com.huateng.common.api.model.ApiBaseResponse;
import com.huateng.common.api.model.RetStatusEnum;
import com.huateng.scf.bas.sys.dao.model.BSysTask;

@Service("MqServiceImpl")
public class MqServiceImpl implements MessageListener {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		logger.info("QueueReceiver is call");
	    TextMessage msg = (TextMessage)message;
	    try {
	    	String scubeMessage=msg.getText();
	    	JSONObject scubeMessageObject = JSON.parseObject(scubeMessage);
	    	logger.info("[textMessage]: "+scubeMessageObject);
	    	if(RetStatusEnum.SUCCESS.toString().equals(scubeMessageObject.get("reStatus").toString())){
			        Map accountModel= JSON.parseObject(scubeMessageObject.get("resule").toString(), Map.class);
			    	logger.info("[resule]: " + accountModel);
	    }
	    


	    }
	    catch (JMSException e2) {
	      e2.printStackTrace();
	    }

		
		
		
	}
}
