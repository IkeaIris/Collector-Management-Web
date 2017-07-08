
$(document).ready(function() {
	$("#sidebar").load("sidebar.html", function() {});
});
var app = angular.module('clctTrashApp', []);
app.controller('clctTrash', function($scope, $http,$timeout) {
	//配置
	$scope.count=0;
	$scope.p_pernum=10;
	//变量
	$scope.p_current=1;
	$scope.p_all_page=0;
	$scope.pages=[];
	$scope.clear_m=function(){
		$("#m_clear").empty();
	}
	var getData=function(params,callback){
		var suffix="?Clct_ID=";
		$http.get(mhsysUrl+"clctManage/getCollectorTrashByID"+suffix+params).success(function (response){
			$scope.count=response.collectorTrashList.length;
			if(response.collectorTrashList.length==0) {
				alert("暂无数据！");
			}
			$scope.p_all_page=Math.ceil($scope.count/$scope.p_pernum);
			$scope.collectorList = response.collectorList;
			reloadPno();
			callback();
		});
	}

	var _get=function(page,size,callback){
		$http.get(mhsysUrl+"clctManage/getCollectorTrashList").success(function (response) {
			$scope.count=response.collectorTrashList.length;
			$scope.collectorTrashList = response.collectorTrashList;
			if(response.collectorTrashList.length==0) {
				alert("暂无数据！");
			}
			reloadPno();
			callback();
	});
	}
	//getData(str1,function(){});
	_get($scope.p_current,$scope.p_pernum,function(){
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
	$scope.refresh=function(){
		//alert(1);
		$timeout(function () {
			//getData(str1,function(){});
			_get($scope.p_current,$scope.p_pernum,function(){ });
			}, 1000);
	}
	
	$scope.search=function(){
		var clctidpara=$("#searchpara").val();
		getData(clctidpara,function(){});
	}
	$scope.deleteUndone=function(res){
		var str="?Clct_NO="+res;
		$http.get(mhsysUrl+"clctManage/deleteCollectorUndone"+str).success(function(response){
			$http.get(mhsysUrl+"clctDataSolver/dropDataTableByClctNo"+str).success(function () {
				if (response.status==1) {
					alert("删除成功");
				}
				else {
					alert("出现错误");
				}
			})
		})
		$scope.refresh();
	}
	$scope.reuse=function(res){
		var str="?Clct_NO="+res;
		$http.get(mhsysUrl+"clctManage/reuseCollector"+str).success(function(response){
			if (response.status==1) {
				alert("恢复成功");
			}
			else {
				alert("出现错误");
			}
		})
		//自动刷新
		$scope.refresh();
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



