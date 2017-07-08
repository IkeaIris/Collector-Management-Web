$(document).ready(function() {
	$("#sidebar").load("sidebar.html", function() {});
});
var app = angular.module('logApp', []);
app.controller('userOperationLog', function($scope, $http,$timeout) {
	//配置
	$scope.count=0;
	$scope.p_pernum=10;
	//变量
	$scope.p_current=1;
	$scope.p_all_page=0;
	$scope.pages=[];
	var str1='';
	var str2='';
	var str3='';
	var str4='';
	var string1='';
	var string2='';
	var operationtype=new Array("新增","删除","修改","登陆","注销");
	$scope.tablename= new Array();
	$scope.userID= new Array();
	
	$scope.clear_m=function(){
		$("#m_clear").empty();
	}

	$scope.stringoperation=function(num){ 
	    return operationtype[num-1];
	}

	$scope.stringip=function(num){ 
	    var str;
	    var tt = new Array();
	    tt[0] = (num >>> 24) >>> 0;
	    tt[1] = ((num << 8) >>> 24) >>> 0;
	    tt[2] = (num << 16) >>> 24;
	    tt[3] = (num << 24) >>> 24;
	    str = String(tt[0]) + "." + String(tt[1]) + "." + String(tt[2]) + "." + String(tt[3]);
	    return str;
	}

	var getData=function(params,callback){
		$http({
			method:"GET",
			url:mhsysUrl + "userOperationLog/getUserLogList",
			params
		}).success(function(response){
			reloadPno();
			callback();
		});
	}

	var _get=function(page,size,params,callback){
		params.pageIndex=page;
		params.pageSize=size;
		$http({
			method:"GET",
			url:mhsysUrl + "userOperationLog/getUserLogList",
			params
		}).success(function (response) {
			$scope.UserLogList = response.UserLogList;
			$scope.p_current=page;
			for(var i=0;i<response.UserLogList.length;i++)
			{
				if($scope.UserLogList[i].status=="0"){
				}
				else{
				}
			}
			reloadPno();
			callback();
	});
	}


	getData(str1,function(){});
	_get($scope.p_current,$scope.p_pernum,"",function(){
		//alert("我是第一次加载");
	}) 
	//首页  
	$scope.p_index = function(){  
		$scope.load_page(1);  
	}  
	//尾页  
	$scope.p_last = function(){  
		$scope.load_page($scope.p_all_page);  
	}  
	//加载某一页  
	$scope.load_page = function(page){  
		_get(page,$scope.p_pernum,function(){ });  
	};  
	//初始化页码  
	var reloadPno = function(){  
		$scope.pages=calculateIndexes($scope.p_current,$scope.p_all_page,8);  
	};  
	
	//分页算法  
	var calculateIndexes = function (current, length, displayLength) {  
		var indexes = [];  
		var start = Math.round(current - displayLength / 2);  
		var end = Math.round(current + displayLength / 2);  
		if (start <= 1) {  
			start = 1;  
			end = start + displayLength - 1;  
			if (end > length - 1) {  
				end = length;
				start=end-displayLength+1;  
			}  
		}  
		if (end > length - 1) {  
			end = length;  
			start = end - displayLength + 1;  
			if (start <= 1) {  
				start = 1;  
			}  
		}  
		for (var i = start; i <= end; i++) {  
			indexes.push(i);  
		}  
		return indexes;  
	};


	$scope.search=function(){
		var params = new Object();
		
		if($scope.User_ID != null)
			params.User_ID = $scope.User_ID;
		
		var ts = $("#Time_Start").val() == null || $("#Time_Start").val() == "";
		var te = $("#Time_End").val() == null || $("#Time_End").val() == "";
		
		if((ts && ! te)||(!ts && te)){
					alert("时间不匹配");
					return;
				 }
				else if(!te && !ts){
					params.Time_Start = $("#Time_Start").val();
					params.Time_End = $("#Time_End").val();
				}
		
		if($scope.Table_Name != null)params.Table_Name = $scope.Table_Name;		
		
		if($scope.Operation_Type != null)
			params.Operation_Type = $scope.Operation_Type;
		alert("asdf");
		getData(params, function(){});
		_get($scope.p_current,$scope.p_pernum,params,function(){});
	}

	$scope.clear=function(){
		$scope.User_ID=null;
		$scope.Time_Start=null;
		$scope.Time_End=null;
		$scope.Table_Name=null;
		$scope.Operation_Type=null;
	}
	$scope.refresh=function(){
		$scope.clear();
		string1='';
		string2='';
		getData(string1, function(){});
		_get($scope.p_current,$scope.p_pernum,function(){});
	}
	
	$scope.setTable_NameSearch=function(str){
		$scope.Table_Name=str;
	}

	$scope.exit=function(){
		var uid = document.cookie.split(";")[0].split("=")[1]; 
		var time = new Date();
		var m = time.getMonth() + 1;
		var t = time.getFullYear() + "-" + m + "-"
			+ time.getDate() + " " + time.getHours() + ":"
			+ time.getMinutes() + ":" + time.getSeconds();
		$http({
			method:"GET",
			url: mhsysUrl+"userOperationLog/insertUserLog",
			params:{
				User_ID:uid,
				Operation_Timestamp:t,
				Operation_Type:'5'
			}
		}).success(function(res){
			alert("注销成功");
			var cookie = new Object();
			cookie.uid = "";
			cookie.role = "";
			document.cookie = "User_Id=" + escape(cookie.uid);
			document.cookie =  "role=" + escape(cookie.role);
			window.location.href = "login.html";
		});
	}
})