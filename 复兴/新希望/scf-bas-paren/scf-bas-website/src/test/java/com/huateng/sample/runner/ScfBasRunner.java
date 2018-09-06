/**
 * 
 */
package com.huateng.sample.runner;

import java.io.File;

import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.mortbay.jetty.plus.webapp.EnvConfiguration;
import org.mortbay.jetty.webapp.Configuration;
import org.mortbay.jetty.webapp.WebAppContext;
import org.mortbay.thread.QueuedThreadPool;

/**
 * <p>无端调用方式，启动发布服务接口的类</p>
 *
 * @author 	huangshuidan
 * @date 	2016年11月19日上午11:09:20
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * huangshuidan		2016年11月19日上午11:09:20	                                 新增
 *
 * </pre>
 */
public class ScfBasRunner {
	private static Server server = new Server();
	/**
	 * 主函数，执行此方法发布服务
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		QueuedThreadPool boundedThreadPool = new QueuedThreadPool();
		boundedThreadPool.setMaxThreads(5);
		server.setThreadPool(boundedThreadPool);

		Connector connector = new SelectChannelConnector();
		connector.setPort(18088);
		server.addConnector(connector);

		WebAppContext context = new WebAppContext("src/main/webapp", "/scfbas");
		context.setDefaultsDescriptor("src/test/resources/webdefault.xml");
		
		EnvConfiguration envConfiguration = new EnvConfiguration();
        envConfiguration.setJettyEnvXml(new File("src/test/resources/jetty/jetty-env.xml").toURI().toURL());
		Configuration[] configurations = new Configuration[]{
		        new org.mortbay.jetty.webapp.WebInfConfiguration(),
		        envConfiguration,
		        new org.mortbay.jetty.plus.webapp.Configuration(),
		        new org.mortbay.jetty.webapp.JettyWebXmlConfiguration(),
		        new org.mortbay.jetty.webapp.TagLibConfiguration()
		};
		context.setConfigurations(configurations);
		
		server.setHandler(context);

		server.setStopAtShutdown(true);
		server.setSendServerVersion(true);

		server.start();
		System.out.println("============================the server is started===========================");
		server.join();
	}
}
