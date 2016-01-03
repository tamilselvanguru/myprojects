var StudentApp = angular.module("StudentApp", []);
StudentApp.controller("StudentCtrl", function($scope) {
	$scope.IsMyLabelVisible=true;
	$scope.IsVisible = false;
	$scope.students = [ {
		'name' : 'Sangeetha',
		'deparment' : 'MCA',
		'idno' : '11085',
		'phno' : '5124351233',
		'address' : [ {
			'streetAddress' : 'Manal Thottam',
			'city' : 'Sathy',
			'state' : 'TN',
			'zipcode' : '638452'
		} ]
	},

	{
		'name' : 'Tamil',
		'deparment' : 'ECE',
		'idno' : '11067',
		'phno' : '6127351543',
		'address' : [ {
			'streetAddress' : 'KG Thottam',
			'city' : 'Gobi',
			'state' : 'TN',
			'zipcode' : '453678'
		} ]
	}, {
		'name' : 'Pranu',
		'deparment' : 'MBBS',
		'idno' : '11034',
		'phno' : '2121121256',
		'address' : [ {
			'streetAddress' : 'El camino',
			'city' : 'Mountain view',
			'state' : 'US',
			'zipcode' : '78759'
		} ]
	}, {
		'name' : 'Lalith',
		'deparment' : 'MBBS',
		'idno' : '11012',
		'phno' : '1112435333',
		'address' : [ {
			'streetAddress' : 'Kom pallam',
			'city' : 'Sathy',
			'state' : 'TN',
			'zipcode' : '567487'
		} ]

	} ];
	$scope.student =$scope.students[0];
	$scope.selectedStudent = function(value) {
		$scope.IsVisible = false;
		$scope.IsMyLabelVisible=true;
		$scope.student = value;
	};
	$scope.show = function() {
		$scope.IsMyLabelVisible=false;
		$scope.IsVisible = true;
	};
});
