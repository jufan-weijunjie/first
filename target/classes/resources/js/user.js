angular.module("myApp", []).controller("myController", function($scope, $http) {

	var BASE_URL = "http://localhost";

	$scope.view_user = true;
	$scope.add_user = false;
	$scope.update_user = false;

	$scope.save = function() {
		$http({
			method: "POST",
			url: BASE_URL + "/app/user/addUser",
			headers: {
				"Content-Type": "application/x-www-form-urlencoded"
			},
			data: $("#userForm_add").serialize()
		}).then(function successCallback(response) {
			if(response.data.code == 200) {
				alert("新增用户成功！");
				$scope.getUser();
				$scope.ret();
				return;
			}
			alert(response.data.msg);
		}, function errorCallback(response) {
			alert("连接服务失败！");
		});
	}

	$scope.getUser = function() {
		$http({
			method: "GET",
			url: BASE_URL + "/app/user/getUser"
		}).then(function successCallback(response) {
			if(response.data.code == 200) {
				$scope.userList = response.data.data;
				return;
			}
			if(response.data.code == 400)
				alert(response.data.msg);
		}, function errorCallback(response) {
			alert("连接服务失败！");
		});
	}
	$scope.getUser();

	$scope.getUserByCondition = function() {
		$http({
			method: "GET",
			url: BASE_URL + "/app/user/getUserByCondition?username=" + $scope.username + "&name=" + $scope.name
		}).then(function successCallback(response) {
			if(response.data.code == 200) {
				$scope.userList = response.data.data;
				return;
			}
			if(response.data.code == 400)
				alert(response.data.msg);
		}, function errorCallback(response) {
			alert("连接服务失败！");
		});
	}

	$scope.getUserById = function(id) {
		$http({
			method: "GET",
			url: BASE_URL + "/app/user/getUserById?id=" + id
		}).then(function successCallback(response) {
			if(response.data.code == 200) {
				$scope.user = response.data.data;
				if($scope.user.status == 1)
					document.getElementById("status_update")[1].selected = true;
				if($scope.user.status == 0)
					document.getElementById("status_update")[2].selected = true;
			}
			if(response.data.code == 400)
				alert(response.data.msg);
		}, function errorCallback(response) {
			alert("连接服务失败！");
		});
	}

	$scope.clear = function() {
		$scope.username = "";
		$scope.name = "";
	}

	$scope.update = function(id) {
		$scope.view_user = false;
		$scope.add_user = false;
		$scope.update_user = true;
		$scope.getUserById(id);
	}

	$scope.updateSave = function() {
		$http({
			method: "POST",
			url: BASE_URL + "/app/user/updateUser",
			headers: {
				"Content-Type": "application/x-www-form-urlencoded"
			},
			data: $("#userForm_update").serialize()
		}).then(function successCallback(response) {
			if(response.data.code == 200) {
				alert("更新用户成功！");
				$scope.getUser();
				$scope.ret();
				return;
			}
			alert(response.data.msg);
		}, function errorCallback(response) {
			alert("连接服务失败！");
		});
	}

	$scope.delete = function(id) {
		$http({
			method: "GET",
			url: BASE_URL + "/app/user/deleteUser?id=" + id
		}).then(function successCallback(response) {
			if(response.data.code == 200) {
				alert("删除用户成功！");
				$scope.getUser();
			}
			if(response.data.code == 400)
				alert(response.data.msg);
		}, function errorCallback(response) {
			alert("连接服务失败！");
		});
	}

	$scope.addUser = function() {
		$scope.view_user = false;
		$scope.add_user = true;
		$scope.update_user = false;
	}

	$scope.ret = function() {
		$scope.view_user = true;
		$scope.add_user = false;
		$scope.update_user = false;
	}
});