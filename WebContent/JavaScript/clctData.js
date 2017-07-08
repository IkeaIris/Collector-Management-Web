$(document).ready(function() {
	$("#sidebar").load("sidebar.html", function() {});
});
var app = angular.module('clctDataApp', []);
app.controller('clctData', function($scope, $http,$timeout) {
	$scope.count=0;
	$scope.p_pernum=10;
	$scope.p_current=1;
	$scope.p_all_page=0;
	$scope.pages=[];
	$scope.clear_m=function(){
		$("#m_clear").empty();
	}
	var getData=function(params,callback){
		var url=window.location.href;
		var param=url.indexOf("=");
		url=url.substring(param+1);
		$http({
			method:"POST",
			url:mhsysUrl+"clctData/getClctDataList",
			params:{
				TName:"Clct_"+url+"_Data"
			}
		}).success(function (response){
			$scope.count=response.clctDataList.length;
			if(response.clctDataList.length==0) {
				alert("暂无数据！");
			}
			$scope.p_all_page=Math.ceil($scope.count/$scope.p_pernum);
			$scope.clctDataList = response.clctDataList;
			reloadPno();
			callback();
		});
	}

	var _get=function(page,size,callback){
//		获得当前页面URL
		var url=window.location.href;
//		以=号分割URL
		var param=url.indexOf("=");
//		得到GET参数
		url=url.substring(param+1);
		$http({
			method:"POST",
			url:mhsysUrl+"clctData/getClctDataList",
			params:{
				TName:"Clct_"+url+"_Data"
			}
		}).success(function (response) {
			$scope.count=response.clctDataList.length;
			if(response.clctDataList.length==0) {
				alert("暂无数据！");
			}
			$scope.clctDataList = response.clctDataList;
			for(var i=0;i<response.clctDataList.length;i++) {}
			reloadPno();
			callback();
		});
	}
	_get($scope.p_current,$scope.p_pernum,function(){}) 
	$scope.p_index = function(){  
		$scope.load_page(1);  
	}   
	$scope.p_last = function(){  
		$scope.load_page($scope.p_all_page);  
	}  
	$scope.load_page = function(page){  
		_get(page,$scope.p_pernum,function(){ });  
	};    
	var reloadPno = function(){  
		$scope.pages=calculateIndexes($scope.p_current,$scope.p_all_page,8);  
	};  
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
	$scope.refresh=function(){
		$timeout(function () {
			_get($scope.p_current,$scope.p_pernum,function(){ });
	}, 1000);
	}
	
	$scope.search=function(){
		
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
		});	}
})