var helloApp = angular.module("helloApp", []);
helloApp.controller("CompanyCtrl", function($scope) {
$scope.companies = ['hexa','tcs','cts','wipro','satyam','hcl'];
});
