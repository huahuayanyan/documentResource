package com.test;

/**
 * 
 * 数据库操作测试类
 *
 * @author 	shuaixianxian
 * @date 	2016年9月23日
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=================
 * Modifier			date			Content
 * shuaixianxian			2016年9月23日			新增
 *
 * </pre>
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:test_spring-dao.xml"})
//@Transactional
//@TransactionConfiguration(defaultRollback=true)
//public class MainTest{
//	
//	private Logger logger = LoggerFactory.getLogger(getClass());
//	@Autowired
//	ExtOrgUserDAO dao;
//    
//	@Before
//	public void init() throws Exception{
//		TraceNoUtils.newTraceNo();
//	}
//	
//	@Test
//	public void test(){
//		logger.info("==========={},{},{},{}" , new Object[]{"123",231,"asdfas","234e532fdsf"});
//		OrgUser record = new OrgUser();
//		record.setUserName("11111111");
//		String id = dao.insert(record);
//		
//		OrgUser user = dao.selectByPrimaryKey(id);
//		Assert.assertTrue(user != null);
//		Assert.assertTrue(user.getUserName().equalsIgnoreCase("11111111"));
//	}                                   
//} 