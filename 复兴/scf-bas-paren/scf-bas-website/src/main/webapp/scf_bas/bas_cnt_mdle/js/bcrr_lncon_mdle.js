/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/11/21
 */
(function(){

	//跳转的路由配置
	var routeArry=[
		{
			'state':'list',
			'url':'/con_list',
			'default':'true',
			'templateUrl':'bcrrlncon/lncon_list.html',
			'controller':'lnconlistController'
		},
		{
			'state':'edit',
			'url':'/lnconedit',
			'default':'true',
			'templateUrl':'bcrrlncon/lncon_edit.html',
			'controller':'lnconeditController'
		}
		//{
		//	'state':'lncon',
		//	'url':'/lncon',
		//	'default':'true',
		//	'templateUrl':'../../bas_crr_mdle/html/lncon/conn.html',
		//	'controller':'lnconController'
		//},
		//{
		//	'state':'lncon.con',
		//	'url':'/lnconcon',
		//	'templateUrl':'../../bas_crr_mdle/html/lncon/con_edit.html',
		//	'controller':'lnconeditController'
		//},
		//{
		//	'state':'lncon.lccon',
		//	'url':'/lnconlccon',
		//	'templateUrl':'../../bas_crr_mdle/html/lncon/con_lcedit.html',
		//	'controller':'lnconeditController'
		//},
		//{
		//	'state':'lncon.yccon',
		//	'url':'/lnconyccon',
		//	'templateUrl':'../../bas_crr_mdle/html/lncon/con_ycedit.html',
		//	'controller':'lnconeditController'
		//},
		//{
		//	'state':'lncon.gnty',
		//	'url':'/congnty',
		//	'templateUrl':'../../bas_crr_mdle/html/gntycon/con_list.html',
		//	'controller':'gntyconlistController'
		//},
		//{
		//	'state':'lncon.lginfo',
		//	'url':'/conlginfo',
		//	'templateUrl':'../../bas_crr_mdle/html/info/lg_edit.html',
		//	'controller':'infolistController'
		//},
		//{
		//	'state':'lncon.eqptinfo',
		//	'url':'/coneqptinfo',
		//	'templateUrl':'../../bas_crr_mdle/html/info/eqpt_edit.html',
		//	'controller':'infolistController'
		//},
		//{
		//	'state':'lncon.lcinfo',
		//	'url':'/conlcinfo',
		//	'templateUrl':'../../bas_crr_mdle/html/info/lc_edit.html',
		//	'controller':'infolistController'
		//},
		//{
		//	'state':'lncon.billinfo',
		//	'url':'/conbillinfo',
		//	'templateUrl':'../../bas_crr_mdle/html/info/bill_list.html',
		//	'controller':'infolistController'
		//},
		//{
		//	'state':'lncon.invinfo',
		//	'url':'/coninvinfo',
		//	'templateUrl':'../../bas_crr_mdle/html/info/inv_list.html',
		//	'controller':'infolistController'
		//},
		//{
		//	'state':'lncon.bail',
		//	'url':'/bail',
		//	'templateUrl':'../../bas_crr_mdle/html/gntycon/bail_edit.html',
		//	'controller':'gntyconeditController'
		//},
		//{
		//	'state':'lncon.bailcash',
		//	'url':'/bailcash',
		//	'templateUrl':'../../bas_crr_mdle/html/gntycon/bailcash_edit.html',
		//	'controller':'gntyconeditController'
		//},
		//{
		//	'state':'lncon.mortgage',
		//	'url':'/mortgage',
		//	'templateUrl':'../../bas_crr_mdle/html/gntycon/mortgage_edit.html',
		//	'controller':'gntyconeditController'
		//},
		//{
		//	'state':'lncon.pledge',
		//	'url':'/pledge',
		//	'templateUrl':'../../bas_crr_mdle/html/gntycon/pledge_edit.html',
		//	'controller':'gntyconeditController'
		//},
		//{
		//	'state':'lncon.morthouse',
		//	'url':'/morthouse',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/mort_house.html',
		//	'controller':'gntyinfoeditController'
		//},
		//{
		//	'state':'lncon.mortland',
		//	'url':'/mortland',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/mort_land.html',
		//	'controller':'gntyinfoeditController'
		//},
		//{
		//	'state':'lncon.mortbuild',
		//	'url':'/mortbuild',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/mort_build.html',
		//	'controller':'gntyinfoeditController'
		//},
		//{
		//	'state':'lncon.morttraffic',
		//	'url':'/morttraffic',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/mort_traffic.html',
		//	'controller':'gntyinfoeditController'
		//},
		//{
		//	'state':'lncon.morteqpt',
		//	'url':'/morteqpt',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/mort_eqpt.html',
		//	'controller':'gntyinfoeditController'
		//},
		//{
		//	'state':'lncon.mortother',
		//	'url':'/mortother',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/mort_other.html',
		//	'controller':'gntyinfoeditController'
		//},
		//{
		//	'state':'lncon.plbakdraft',
		//	'url':'/plbakdraft',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/pledge_bakdraft.html',
		//	'controller':'gntyinfoeditController'
		//},
		//{
		//	'state':'lncon.plbbbond',
		//	'url':'/plbbbond',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/pledge_budbusbond.html',
		//	'controller':'gntyinfoeditController'
		//},
		//{
		//	'state':'lncon.plcarcert.',
		//	'url':'/plcarcert',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/pledge_carcert.html',
		//	'controller':'gntyinfoeditController'
		//},
		//{
		//	'state':'lncon.plcert',
		//	'url':'/plcert',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/pledge_cert.html',
		//	'controller':'gntyinfoeditController'
		//},
		//{
		//	'state':'lncon.pldockwar',
		//	'url':'/pldockwar',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/pledge_dockwar.html',
		//	'controller':'gntyinfoeditController'
		//},
		//{
		//	'state':'lncon.pldraft',
		//	'url':'/pldraft',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/pledge_draft.html',
		//	'controller':'gntyinfoeditController'
		//},
		//{
		//	'state':'lncon.plexport',
		//	'url':'/plexport',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/pledge_export.html',
		//	'controller':'gntyinfoeditController'
		//},
		//{
		//	'state':'lncon.plforexchg',
		//	'url':'/plforexchg',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/pledge_forexchg.html',
		//	'controller':'gntyinfoeditController'
		//},
		//{
		//	'state':'lncon.plfund',
		//	'url':'/plfund',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/pledge_fund.html',
		//	'controller':'gntyinfoeditController'
		//},
		//{
		//	'state':'lncon.plgold',
		//	'url':'/plgold',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/pledge_gold.html',
		//	'controller':'gntyinfoeditController'
		//},
		//{
		//	'state':'lncon.plgovbond',
		//	'url':'/plgovbond',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/pledge_govbond.html',
		//	'controller':'gntyinfoeditController'
		//},
		//{
		//	'state':'lncon.plladbill',
		//	'url':'/',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/pledge_ladbill.html',
		//	'controller':'gntyinfoeditController'
		//},
		//{
		//	'state':'lncon.pllecrbak',
		//	'url':'/pllecrbak',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/pledge_lecrbak.html',
		//	'controller':'gntyinfoeditController'
		//},
		//{
		//	'state':'lncon.pllecred',
		//	'url':'/pllecred',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/pledge_lecred.html',
		//	'controller':'gntyinfoeditController'
		//},
		//{
		//	'state':'lncon.plmisquote',
		//	'url':'/plmisquote',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/pledge_misquote.html',
		//	'controller':'gntyinfoeditController'
		//},
		//{
		//	'state':'lncon.plmovable',
		//	'url':'/plmovable',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/pledge_movable.html',
		//	'controller':'gntyinfoeditController'
		//},
		//{
		//	'state':'lncon.plother',
		//	'url':'/plother',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/pledge_other.html',
		//	'controller':'gntyinfoeditController'
		//},
		//{
		//	'state':'lncon.plqutcriclt',
		//	'url':'/plqutcriclt',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/pledge_quotecricult.html',
		//	'controller':'gntyinfoeditController'
		//},
		//{
		//	'state':'lncon.plqutown',
		//	'url':'/plqutown',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/pledge_quoteown.html',
		//	'controller':'gntyinfoeditController'
		//},
		//{
		//	'state':'lncon.plrecvacct',
		//	'url':'/plrecvacct',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/pledge_recvacct.html',
		//	'controller':'gntyinfoeditController'
		//},
		//{
		//	'state':'lncon.pltraffic',
		//	'url':'/pltraffic',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/pledge_traffic.html',
		//	'controller':'gntyinfoeditController'
		//},
		//{
		//	'state':'lncon.pltransfer',
		//	'url':'/pltransfer',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/pledge_transfer.html',
		//	'controller':'gntyinfoeditController'
		//},
		//{
		//	'state':'lncon.plwarnty',
		//	'url':'/plwarnty',
		//	'templateUrl':'../../bas_crr_mdle/html/gntyinfo/pledge_warnty.html',
		//	'controller':'gntyinfoeditController'
		//}
	]
	//模块的依赖加载配置
	var dependency=[
		//todo
	];
	scubeUI.module('bcrrlncon',dependency,routeArry);
}());
