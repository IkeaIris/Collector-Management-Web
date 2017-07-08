var app = angular.module('logoutApp', []);
app.controller('logoutController',function($scope,$http){
	$scope.exit = function(){
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
		})
	}
});