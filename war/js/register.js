/* ------------------------------------------------------------------------------
 * Javascript for user registration (AngularJS)
 * @author Janna Pedrano
 * @version 0.01
 * --------------------------------------------------------------------------- */
var app = angular.module('RegistrationApp', []);
app.controller('SignUpController', ['$scope', '$http', function($scope, $http) {
	console.log ("J-dar is stupid");
	$scope.submitted = false;
	$scope.firstName="";
    $scope.lastName ="";
    $scope.username ="";
    $scope.password="";
    $scope.confirmPassword ="";
    $scope.sendPost = function() {
    	if($scope.signup.$valid)
    	{
	        var data = {
	                firstName: $scope.firstName,
	                lastName: $scope.lastName,
	                username: $scope.username,
	                password: $scope.password,
	                confirmPassword: $scope.confirmPassword
	        };
	        $http.post("/user/register", data)
	        .success(function(data, status, headers, config) {
	            console.log(data);
	        	if(data.errorList.length == 0) {
					alert("User has been successfully added");
					$scope.firstName ="";
				    $scope.lastName="";
				    $scope.username ="";
				    $scope.password ="";
				    $scope.confirmPassword ="";
	        		
				} else {
					var msg = "";
					for (var i = 0; i < data.errorList.length; i++)
						msg += data.errorList[i] + "\n";
					alert(msg);
				}
	        })
	        .error(function(data, status, headers, config) {
	        	alert("User already exists!");
	        });
    	} else {
    		$scope.signup.submitted = true;
    	}    	
    };
    
    $scope.clearFields = function(){
    	$scope.firstName ="";
        $scope.lastName ="";
        $scope.username ="";
        $scope.password ="";
        $scope.confirmPassword ="";
    };
}]);