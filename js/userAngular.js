var app = angular.module('user', []);
app.controller('displayUserInfoCtrl', function($scope, $http) {
    $http.get("/user/loggedInUser")
    .success(function(response) {
    	$scope.firstName = response.firstName;
    	console.log(response.firstName);
    	$scope.lastName = response.lastName;
    	$scope.username = response.username;
    });
});