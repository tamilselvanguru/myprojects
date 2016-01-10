var StudentApp = angular.module("StudentApp", []);
StudentApp.controller("StudentCtrl", function($scope, $http) {
	$http({
		url : 'http://localhost:8080/StudentPortalDemo/getStudentList',
		method : 'GET',
	}).success(function(response) {
		$scope.students = response;
		if ($scope.students != undefined) {
			$scope.student = $scope.students[0];
		}
	}).error(function(data, status, headers, config) {
	});
	$scope.IsMyLabelVisible = true;
	$scope.IsVisible = false;
	$scope.isReadonly = false;
	
	$scope.selectedStudent = function(value) {
		$scope.IsVisible = false;
		$scope.isReadonly = false;
		$scope.IsMyLabelVisible = true;
		$scope.student = value;
	};
	$scope.show = function() {
		$scope.IsMyLabelVisible = false;
		$scope.IsVisible = true;
	};
	$scope.add = function() {
		$scope.IsMyLabelVisible = false;
		$scope.IsVisible = true;
		$scope.student = null;

	};
	$scope.save = function(student) {
		alert(JSON.stringify(student));
		$scope.isReadonly = true;
		$http({
			url : 'http://localhost:8080/StudentPortalDemo/updateStudent',
			method : 'POST',
			headers : {
				'Content-Type' : 'application/json'
			},
			// data :JSON.stringify(student)
			data : student
		}).success(function(data) {
			alert(data.response);
		});
	};
});
