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
		.when('/tasks/today/:taskId', {
			'templateUrl': '/taskstoday/update_task.html',
			'controller': 'UpdateTaskController'
		})
		.when('/tasks/add', {
			'templateUrl': '/task/create_task.html',
			'controller': 'CreateTaskController'
		})
		.when('/tasks/:taskId', {
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
				alert("Task has been successfully removed");
				location.reload(true);
			} else {
				var msg = "";
				for (var i = 0; i < data.errorList.length; i++)
					msg += data.errorList[i] + "\n";
				alert("Invalid");
			}
        }).error(function(data, status, headers, config) {
        	
        });
    };
    
    $scope.editTask = function(task) {
    	window.location = window.location.href.split('#')[0] + '#/tasks/' + task.id;
    }

    
    $scope.finishTask = function(id) {
		var data = {
                id: id
            };
		console.log("FINISH TASK " +data.id);
        $http.post("/task/completeTask", data)
        .success(function(data, status) {
        	if(data.errorList.length == 0) {
				alert("Task has been successfully completed");
				location.reload(true);
			} else {
				var msg = "";
				for (var i = 0; i < data.errorList.length; i++)
					msg += data.errorList[i] + "\n";
				alert("Invalid");
			}
        }).error(function(data, status, headers, config) {
        	
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
    
    $scope.updateTask = function(task) {
    	window.location = window.location.href.split('#')[0] + '#/tasks/today/' + task.id;
    }
}]);
app.controller('UpdateTaskController', ['$scope', '$http', '$routeParams', function($scope, $http, $routeParams) {
	var taskId = $routeParams.taskId;

    $http({
        url : '/taskstoday/editTask', 
        method : 'GET',
        params : {id : taskId}
    }).success(function (response) {
        var task = response;
        $scope.taskName = task.name;
        $scope.taskPhase = task.phase;
    });
    /*
    $scope.updateTask = function(){
    	var data =
        {
            id: taskId,
            name : $scope.taskName,
            phase : $scope.taskPhase,
            estHours : $scope.taskEstHours,
            startDate : $scope.taskStartDate,
            dueDate : $scope.taskDueDate
        };
    	$http.post("/task/editTask", data)
    	.success(function (data, status, headers, config) {
            window.location = window.location.href.split('#')[0] + '#/tasks';
        });
    }*/
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
app.controller('EditTaskController', ['$scope', '$http', '$routeParams', function($scope, $http, $routeParams) {
	var taskId = $routeParams.taskId;

    $http({
        url : '/task/editTask', 
        method : 'GET',
        params : {id : taskId}
    }).success(function (response) {
        var task = response;
        $scope.taskName = task.name;
        $scope.taskPhase = task.phase;
        $scope.taskEstHours = task.estHours;
        $scope.taskStartDate = task.startDate;
        $scope.taskDueDate = task.dueDate;
    });
    
    $scope.updateTask = function(){
    	var data =
        {
            id: taskId,
            name : $scope.taskName,
            phase : $scope.taskPhase,
            estHours : $scope.taskEstHours,
            startDate : $scope.taskStartDate,
            dueDate : $scope.taskDueDate
        };
    	$http.post("/task/editTask", data)
    	.success(function (data, status, headers, config) {
            window.location = window.location.href.split('#')[0] + '#/tasks';
        });
    }

}]);
app.controller('SettingsController', ['$scope', '$http', function($scope, $http) {
	$http.get("/user/loggedInUser")
    .success(function(response) {
    	$scope.firstName = response.firstName;
    	$scope.lastName = response.lastName;
    	$scope.username = response.username;
    });
}]);
