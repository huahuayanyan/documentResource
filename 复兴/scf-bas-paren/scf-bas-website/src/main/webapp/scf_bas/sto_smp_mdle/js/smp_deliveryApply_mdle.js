/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
(function(){

	window.Write = true;
	window.Issued = true;
	window.Receipt = true;

	//跳转的路由配置
	var routeArry=[
		{
			'state':'list',
			'url':'/deliveryApplylist',
			'default':'true',
			'templateUrl':'../html/deliveryApply/delivery_apply_list.html',
			'controller':'deliveryApplyListController'
		},
		{
			'state':'staticDelivery',
			'url':'/staticDelivery',
			'default':'true',
			'templateUrl':'../html/deliveryApply/delivery_apply.html',
			'controller':'deliveryApplyController'
		},
		{
			'state':'staticDelivery.apply',
			'url':'/staticDelivery.apply',
			'templateUrl':'../html/deliveryApply/delivery_apply_detail.html',
			'controller':'deliveryApplyDetailController'
		},
		{//保证金追加
			'state':'staticDelivery.acctadd',
			'url':'/staticDelivery.acctadd',
			'templateUrl':'../html/deliveryApply/delivery_apply_acctadd.html',
			'controller':'deliveryApplyAcctaddController'
		},
		{//质押合同
			'state':'staticDelivery.slave',
			'url':'/staticDelivery.slave',
			'templateUrl':'../html/deliveryApply/info_slave.html',
			'controller':'infoSlaveController'
		},
		{//质押监管协议
			'state':'staticDelivery.protocol',
			'url':'/staticDelivery.protocol',
			'templateUrl':'../html/deliveryApply/info_protocol.html',
			'controller':'infoProtocolController'
		},
		{
			'state':'staticDelivery.fileupload',
			'url':'/staticDelivery.fileupload',
			'templateUrl':'../html/deliveryApply/info_fileupload.html',
			'controller':'infoFileuploadController'
		}
	];
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('smpDeliveryApply',dependency,routeArry);
}());
