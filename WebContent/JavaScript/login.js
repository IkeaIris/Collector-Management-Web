var app=angular.module('loginApp',[]);
app.controller('loginController',function($scope,$http){

	$scope.setCookie = function(cookie){
		document.cookie = "User_Id=" + escape(cookie.uid);
		document.cookie =  "role=" + escape(cookie.role);
		return;
	}

	$scope.insertLog = function(uid, time){
		$http({
			method:"GET",
			url: mhsysUrl+"userOperationLog/insertUserLog",
			params:{
				User_ID:uid,
				Operation_Timestamp:time,
				Operation_Type:'4'
			}
		}).success(function(res){
			window.location.href = "index.html";
		})
	}
	
	$scope.login=function(){
		if($scope.User_Id==null || $scope.Password==null){
			alert("username or password can not be empty !");
		}
		else if($scope.User_Id != null){
			var uid = $scope.User_Id;
			var upwd = $scope.Password;
			$http({
				method:"POST",
				url: mhsysUrl+"userManage/getUserList",
				params:{
					User_Id:uid,
					HashedPwd:upwd
				}
			}).success(function(res){
				if(res.userList.length==0)alert("用户名或密码错误！");
				else if(res.userList.length!=0){
					alert("登录成功");
					var time = new Date();
					 // 程序计时的月从0开始取值后+1
					var m = time.getMonth() + 1;
					var t = time.getFullYear() + "-" + m + "-"
						+ time.getDate() + " " + time.getHours() + ":"
						+ time.getMinutes() + ":" + time.getSeconds();
					var cookie = new Object();
					cookie.uid = $scope.User_Id;
					cookie.role = res.userList[0].user_Role.toString();
					$scope.setCookie(cookie); 
					$scope.insertLog(uid, t);
				}
			})
		}
	}
});

function checkCookie(){
	userId=getCookie("User_Id");/*
	time = new Date(getCookie("exTime"));
	nowTime = new Date();
	if(time > nowTime)return;*/
	if (userId!=null && userId!="")
	  	{
			alert('Welcome again '+userId+' !')
			window.location.href = "index.html";
		}
	else return;
}
