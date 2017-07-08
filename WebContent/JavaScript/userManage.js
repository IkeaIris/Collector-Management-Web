$(document).ready(function() {
	$("#sidebar").load("sidebar.html", function() {});
});
var app = angular.module('userApp', []);
app.controller('userController', function($scope, $http,$timeout) {
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

	$scope.stringoperation=function(num){ 
	    return operationtype[num-1];
	}

	var getData=function(params,callback){
		$http({
			method:"GET",
			url:mhsysUrl + "userInfoManage/getUserInfoList",
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
			url:mhsysUrl + "userInfoManage/getUserInfoList",
			params
		}).success(function (response) {
			$scope.userInfoList = response.userInfoList;
			$scope.p_current=page;
			for(var i=0;i<response.userInfoList.length;i++)
			{
				if($scope.userInfoList[i].status=="0"){
					
				}
				else{
				}
			}
			reloadPno();
			callback();
	});
	}

	$scope.updateRole=function(role){
		
	}
	$scope.preedit=function(id, name,dept, role) {
		$scope.id = id;
		$scope.name = name;
		$scope.dept = dept;
		$scope.role = role;
	}
	
	$scope.edit = function(){
		$http({
			method:"GET",
			url:mhsysUrl + "userManage/updateUser",
			params:{
				User_ID:$scope.id,
				User_Role:$scope.newRole
			}
		}).success(function (response) {
				if(response.status != 0){
					alert("修改成功");
					$scope.refresh();
				}
				else alert("失败")
			});
	}
	
	$scope.Delete = function(user_ID){
		$http({
			method:"GET",
			url:mhsysUrl + "userInfoManage/deleteUserInfo",
			params:{
				User_ID:user_ID
			}
		}).success(function(response){
			alert("删除成功")
			$scope.refresh();
		});
	}
	
	getData("",function(){});
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


	$scope.search=function(){
		var params = new Object();
		
		if($scope.User_ID != null)
			params.User_ID = $scope.User_ID;
		
		if($scope.User_Name != null)
			params.User_Name = $scope.User_Name;
			
		if($scope.User_Dept != null)
			params.User_Dept = $scope.User_Dept;		
		
		if($scope.Role_Name != null){}
			params.Role_Name = $scope.Role_Name;
		
		getData(params, function(){});
		_get($scope.p_current,$scope.p_pernum, params,function(){});
	}
	
	$scope.refresh=function(){
		getData("", function(){});
		_get($scope.p_current,$scope.p_pernum,"", function(){});
	}
	
	$scope.setTable_NameSearch=function(str){
		$scope.Table_Name=str;
	}

	$scope.exit = function(){
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