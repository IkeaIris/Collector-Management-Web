$(document).ready(function() {
	$("#sidebar").load("sidebar.html", function() {});
});
var app = angular.module('settingApp', []);
app.controller('settingController', function($scope, $http) {
	
	$scope.updateAccount = function(params){
		$http({
			method:"GET",
			url:mhsysUrl + "userManage/updateUser",
			params
		}).success(function(response){
			if(response.status != 0)
				alert("密码修改成功");
			else
				alert("错误！");
		});
	}
	
	$scope.updateInfo = function(params){
		$http({
			method:"GET",
			url:mhsysUrl + "userInfoManage/updateUserInfo",
			params
		}).success(function(response){
			if(response.status != 0)
				alert("密码修改成功");
			else
				alert("错误！");
		});
	}
	
	
	$scope.submit = function(){
		var params1 = new Object();
		var params2 = new Object();
		
		var pwd;
		var p1 = $scope.pwd1 !=null && $scope.pwd1 != "";
		var p2 = $scope.pwd2 !=null && $scope.pwd2 != "";
		if((p1 && !p2)||(!p1 && p2)||($scope.pwd1 != $scope.pwd2)){
			alert("两次密码输入不一样");
			return;
		}else{
			pwd = $scope.pwd1;
			params1.HashedPwd = pwd;
		}
		
		if($scope.name != null){
			var name = $scope.name;
			params2.User_Name = name;
		}
		
		if($scope.dept != null){
			var dept = $scope.dept;
			params2.User_Dept = dept;
		}
		
		var id;
		if(name != null || dept != null || pwd != null){		
			id=document.cookie.split(";")[0].split("=")[1];
			params1.User_ID = id;
			params2.User_ID = id;
		}
		
		if(id != null){
			if(pwd != null){
				$scope.updateAccount(params1);
				if(name != null || dept != null)
				$http({
					method:"GET",
					url:mhsysUrl + "userInfoManage/updateUserInfo",
					params2
				}).success(function(response){
					alert("信息修改成功");
				});
			}
			else{
				$http({
					method:"GET",
					url:mhsysUrl + "userInfoManage/updateUserInfo",
					params2
				}).success(function(response){
					alert("信息修改成功");
				});
			}
		}
		else alert("提交内容为空！");
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



