var StudentApp = angular.module("StudentApp",  ['ngGrid']);
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
	 $scope.showModal = false;
	    $scope.myData = [{Subjects: "Tamil", Marks: 50},
	                     {Subjects: "English", Marks: 43},
	                     {Subjects: "Science", Marks: 27},
	                     {Subjects: "Maths", Marks: 29},
	                     {Subjects: "Social Science", Marks: 34}];
	    $scope.gridOptions = { data: 'myData' };
	    
	    
	
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
		$scope.isReadonly = false;
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
	$scope.deleteSelectedStudent = function(student) {
		alert(JSON.stringify(student.studentID));
		$http({
			url : 'http://localhost:8080/StudentPortalDemo/deleteStudent',
			method : 'DELETE',
			headers : {
				'Content-Type' : 'application/json'
			},
			// data :JSON.stringify(student.studentID)
			data : student.studentID
		}).success(function(data) {
			alert(data.response);
		});
	};	    $scope.toggleModal = function(){
	        $scope.showModal = !$scope.showModal;
	    };
	  });

StudentApp.directive('modal', function () {
	    return {
	      template: '<div class="modal fade">' + 
	          '<div class="modal-dialog">' + 
	            '<div class="modal-content">' + 
	              '<div class="modal-header">' + 
	                '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>' + 
	                '<h4 class="modal-title">{{ title }}</h4>' + 
	              '</div>' + 
	              '<div class="modal-body" ng-transclude></div>' + 
	            '</div>' + 
	          '</div>' + 
	        '</div>',
	      restrict: 'E',
	      transclude: true,
	      replace:true,
	      scope:true,
	      link: function postLink(scope, element, attrs) {
	        scope.title = attrs.title;

	        scope.$watch(attrs.visible, function(value){
	          if(value == true)
	            $(element).modal('show');
	          else
	            $(element).modal('hide');
	        });

	        $(element).on('shown.bs.modal', function(){
	          scope.$apply(function(){
	            scope.$parent[attrs.visible] = true;
	          });
	        });

	        $(element).on('hidden.bs.modal', function(){
	          scope.$apply(function(){
	            scope.$parent[attrs.visible] = false;
	          });
	        });
	      }
	    };
});
