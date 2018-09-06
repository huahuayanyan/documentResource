/**
 * @author 	mengjiajia
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * Create at:   2016/12/26
 */
var gntyconController = function($scope,$common,dataDeliver,$state,$eventCommunicationChannel) {
    $scope.source = window.source;
    $scope.gntycon = $scope.source.gntycon;
    /**
     * ���������Ʋ�ѯ���ؿ�ʼ
     */
    $scope.gutcontent = {
        type:"table",//չʾ����table  tree
        url:"bCrrLnAppService/queryCustSource",
        param:{},
        split:",",//�ָ���
        extentColumn:"custNm",
        column:["custNm","custId"]//չʾ����
    };
    $scope.gutextend = function(ds){
        $scope.gntycon.gutNm = ds.custNm;
        $scope.gntycon.gutId = ds.custId;
        $scope.gntycon.gcrtId = ds.idno;
        $scope.gntycon.gcrtTyp = ds.idtype;
        $scope.number = ds;
    };
    $scope.$watch("gntycon.gutNm",function(){
        if($scope.gntycon.gutNm!=null) $scope.gutcontent.param ={custId:$scope.gntycon.gutNm,custNm:$scope.gntycon.gutNm};
    });
    /**
     * ���������Ʋ�ѯ���ؽ���
     */
    /**
     * ҵ��Ʒ��ɸѡ��ʼ
     */
    $scope.productNameContent = {
        type:"table",//չʾ����table  tree
        url:"bSysCommonService/selectBusinessType",
        param:{ factType:"0" },    //Ӧ���˿�����
        split:",",//�ָ���
        extentColumn:"productName",
        column:["productName","productId"]//չʾ����
    };
    $scope.productNamedooextent = function(ds){
        $scope.gntycon.vidPrdNm=ds.productName;
        $scope.gntycon.vidPrdId=ds.productId; //ҵ��Ʒ��
    };
    $scope.$watch("gntycon.vidPrdId",function(newVal,oldVal){
        //ht-input-extent  ��Ҫ�ü����ķ�ʽ��������Ĳ���
        $scope.productNameContent.param ={
            tFactType:"0"  //Ӧ���˿�����
        };
    });
    /**
     * ҵ��Ʒ��ɸѡ����
     */
    /**
     * ��ܺ�ͬɸѡ��ʼ
     */
    $scope.prtclNoContent = {
        type:"table",//չʾ����table  tree
        url:"bCrrGntyConService/queryMonitorProtocolListByPageForGntyCon",
        param:{},    //Ӧ���˿�����
        split:",",//�ָ���
        extentColumn:"protocolNo",
        column:["protocolNo","thrName"]//չʾ����
    };
    $scope.prtclNodooextent = function(ds){
        $scope.gntycon.prtclNo=ds.protocolNo;//��ܺ�ͬ��
        $scope.gntycon.prtclBrNm=ds.thrName; //��ܹ�˾����
    };
    $scope.$watch("gntycon.prtclNo",function(newVal,oldVal){
        //ht-input-extent  ��Ҫ�ü����ķ�ʽ��������Ĳ���
        $scope.prtclNoContent.param ={
            productId:$scope.gntycon.vidPrdId,
            protocolCode:$scope.gntycon.prtclNo
        };
    });
    /**
     * ��ܺ�ͬɸѡ����
     */
    //���--------����-------------------------
};
