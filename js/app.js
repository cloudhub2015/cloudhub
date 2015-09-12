var app = angular.module('TaskManagementApp', ['ngRoute']);

app.config(['$routeProvider', function ($routeProvider) {
	$routeProvider
		.when('/tasks', {
			'templateUrl': '/task/masterlist.html',
			'controller': 'TasksController'
		})
		.when('/tasks/today', {
			'templateUrl': '/taskstoday/todays_task.html',
			'controller': 'TodaysTaskController'
		})
		.when('/tasks/today/:id', {
			'templateUrl': '/taskstoday/update_task.html',
			'controller': 'UpdateTaskController'
		})
		.when('/tasks/add', {
			'templateUrl': '/task/create_task.html',
			'controller': 'CreateTaskController'
		})
		.when('/tasks/:id', {
			'templateUrl': '/task/edit_task.html',
			'controller': 'EditTaskController'
		})
		.when('/user/settings', {
			'templateUrl': '/user/settings.html',
			'controller': 'SettingsController'
		})
		.otherwise({
			'redirectTo': '/'
		});
}]);

app.controller('TasksController', ['$scope', '$http', function($scope, $http) {
	$http.get("/task/display")
    .success(function(response) {
    	$scope.tasks = response.taskList;
    	$scope.firstName = response.firstName;
    });
	
	$scope.deleteTask = function(id) {
		var data = {
                id: id
            };
        $http.post("/task/deleteTask", data)
        .success(function(data, status) {
            console.log(data);
        	if(data.errorList.length == 0) {
				alert("Task has been successfully added");
			/*	$('#txtName').val('');
				$('#selectPhase').val('');
				$('#txtEstHours').val('');
				$('#startDate').val('');
				$('#dueDate').val('');*/
        		
			} else {
				var msg = "";
				for (var i = 0; i < data.errorList.length; i++)
					msg += data.errorList[i] + "\n";
				alert("Invalid");
			}
        });
    };
}]);
app.controller('TodaysTaskController', ['$scope', '$http', function($scope, $http) {
	$scope.check = function(date){
		//if true, then do not display invalid date entries
		return (new Date(date) < new Date());
	}
    $http.get("/taskstoday/displayTodaysTasks")
    .success(function(response) {
    	$scope.tasks = response.taskList;
    	$scope.firstName = response.firstName;
    });
}]);
app.controller('UpdateTaskController', ['$scope', function($scope) {
	alert('inside UpdateTaskController');
}]);
app.controller('CreateTaskController', ['$scope', '$http', function($scope, $http) {
	$scope.taskName ="";
    $scope.taskPhase ="";
    $scope.taskEstHours ="";
    $scope.taskStartDate ="";
    $scope.taskDueDate ="";
    $scope.sendPost = function() {
        var data = {
                name: $scope.taskName,
                phase: $scope.taskPhase,
                estHours: $scope.taskEstHours,
                startDate: $scope.taskStartDate,
                dueDate: $scope.taskDueDate
            };
        $http.post("/task/addTask", data)
        .success(function(data, status, headers, config) {
            console.log(data);
        	if(data.errorList.length == 0) {
				alert("Task has been successfully added");
				$scope.taskName ="";
			    $scope.taskPhase ="";
			    $scope.taskEstHours ="";
			    $scope.taskStartDate ="";
			    $scope.taskDueDate ="";
        		
			} else {
				var msg = "";
				for (var i = 0; i < data.errorList.length; i++)
					msg += data.errorList[i] + "\n";
				alert(msg);
			}
        })
        .error(function(data, status, headers, config) {
        	
        });
    };
}]);
app.controller('EditTaskController', ['$scope', '$http', function($scope, $http) {
	$scope.errorDisplay = "";
	console.log(id+""+document.getElementById(content).value+""+createdDate);
	var jsonData = {
			id: id,
			content: document.getElementById(content).value,
			createdDate: createdDate
	};
	//TODO: Code ajax call for updating tweet, use the tweetClick function as guide.
	var tweetPromise = $http.post("update", jsonData);
	tweetPromise.success(function(data, status, headers, config) {
		if(data.errorList.length == 0) {
			alert('Entry updated successfully!');
			$scope.loadTweet();
		} else {
			var msg = "";
			for (var i = 0; i < data.errorList.length; i++)
				msg += data.errorList[i] + "\n";
			$scope.errorDisplay = msg;
		}
	});
	tweetPromise.error(function(data, status, headers, config) {
		alert("error");
	});
}]);
app.controller('SettingsController', ['$scope', '$http', function($scope, $http) {
	$http.get("/user/loggedInUser")
    .success(function(response) {
    	$scope.firstName = response.firstName;
    	$scope.lastName = response.lastName;
    	$scope.username = response.username;
    });
}]);
