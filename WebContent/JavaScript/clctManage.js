$(document).ready(function() {
	$("#sidebar").load("sidebar.html", function() {});
});
var app = angular.module('clctApp', []);
var editing_no="null";
app.controller('clctManage', function($scope, $http,$timeout) {
	$scope.count=0;
	$scope.p_pernum=10;
	$scope.p_current=1;
	$scope.p_all_page=0;
	$scope.pages=[];
	$scope.clear_m=function(){
		$("#m_clear").empty();
	}
//	$scope.search=function(){
//		var params=$("#searchpara").val();
//		var suffix="?Clct_ID="+params;
//		$http.get(mhsysUrl+"clctManage/searchCollectorList"+suffix).success(function (response){
//			$scope.count=response.collectorList.length;
//			if(response.collectorList.length==0) {
//				alert("暂无符合条件的数据！");
//			}
//			$scope.collectorList = response.collectorList;
//		});
//		$scope.refresh();
//	}
	var _get=function(page,size,callback){
		$http.get(mhsysUrl+"clctManage/getCollectorList").success(function (response) {
		$scope.count=response.collectorList.length;
		if(response.collectorList.length==0) {
			alert("暂无数据！");
		}
		$scope.collectorList = response.collectorList;
			reloadPno();
			callback();
		});
	}
	
	_get($scope.p_current,$scope.p_pernum,function(){}) 
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
		$timeout(function () {
			_get($scope.p_current,$scope.p_pernum,function(){ });
			}, 1000);
	}
	$scope.add=function() {
		var clctid=$("#add_clct_ID").val();
		var clctstate=$("#add_state_Detail").val();
		var clctdept=$("#add_dept_Name").val();
		var clctmark=$("#add_clct_Mark").val();
		$http({
			method:"POST",
			url:mhsysUrl+"clctManage/insertCollector",
			params:{
				Clct_ID:clctid,
				State_Detail:clctstate,
				Dept_Name:clctdept,
				Clct_Mark:clctmark
			}
		}).success(function (response) {
			$http.get(mhsysUrl+"clctDataSolver/createDataTableByClctId?Clct_ID="+clctid).success(function (response) {
				if (response.status==1) {
					alert("添加成功");
					$("#add_clct_ID").val("");
					$("#add_state_Detail").val("");
					$("#add_dept_Name").val("");
					$("#add_clct_Mark").val("");
				}
				else {
					alert("出现错误");
				}
			})
		});
		$scope.refresh();
	} 
	$scope.preedit=function(no,id,state,dept,mark) {
		editing_no=no;
		$("#edit_clct_ID").val(id);
		$("#edit_state_detail").val(state);
		$("#edit_dept_name").val(dept);
		$("#edit_clct_Mark").val(mark);
	}
	$scope.edit=function() {
		var clctid=$("#edit_clct_ID").val();
		var clctstate=$("#edit_state_detail").val();
		var clctdept=$("#edit_dept_name").val();
		var clctmark=$("#edit_clct_Mark").val();
		if(editing_no=="null") {
			alert("很抱歉，发生了内部错误");
		}
		$http({
			method:"POST",
			url:mhsysUrl+"clctManage/updateCollector",
			params:{
				Clct_ID:clctid,
				State_Detail:clctstate,
				Dept_Name:clctdept,
				Clct_Mark:clctmark,
				Clct_NO:editing_no
			}
		}).success(function (response) {
			if (response.status==1) {
				alert("修改成功");
			}
			else {
				alert("出现错误");
			}
		})
		editing_no="null";
		$scope.refresh();
	}
	$scope.deleteClct=function(idValue){
		var str="?Clct_NO="+idValue;
		$http.get(mhsysUrl+"clctManage/deleteCollector"+str).success(function(response){
			if (response.status==1) {
				alert("删除成功");
			}
			else {
				alert("出现错误");
			}
		});
		$scope.refresh();
	}
	$scope.showData=function(noValue) {
		var param="?Clct_NO="+noValue;
		window.location.href="./clctData.html"+param;
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



