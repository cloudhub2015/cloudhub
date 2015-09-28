/**
 * AngularJS for Task Management App
 * @author Jacquelyn Amaya
 * @version 0.01
 * [09/08/2015] 0.01 - Janna Tapitha Pedrano - Initial codes | Routes for each link
 * [09/08/2015] 0.02 - David Ramirez 		 - Display today's tasks and tasks in masterlist page | CreateTaskController
 * [09/08/2015] 0.03 - Jacquelyn Amaya 		 - SettingsController: display user's information
 * [09/13/2015] 0.04 - Jacquelyn Amaya 		 - TasksController: addTaskToday(), finishTask(), editTask()
 * [09/13/2015] 0.05 - Jacquelyn Amaya 		 - TodaysTaskController: updateTask(), deleteTaskToday()
 * [09/13/2015] 0.06 - Jacquelyn Amaya 		 - UpdateTaskController: display details of the selected task, update today's task
 * [09/13/2015] 0.07 - Jacquelyn Amaya 		 - EditTaskController: display details of the selected task, edit task in Masterlist
 * [09/13/2015] 0.08 - Jacquelyn Amaya 		 - SettingsController: display and update user's information, cancel function
 * [09/15/2015] 0.09 - Janna Tapitha Pedrano - Defined active tab rootscope. 
 * [09/15/2015] 0.10 - Vine Deiparine		 - Added Validations
 * [09/15/2015] 0.11 - Jacquelyn Amaya		 - Added Validations for updating spent time
 * [09/22/2015] 0.12 - Jacquelyn Amaya		 - Alert error messages
 * [09/25/2015] 0.13 - Jacquelyn Amaya		 - Reload masterlist after adding task to pending tasks | Return to masterlist after creating task
 */
var app = angular.module('TaskManagementApp', ['ngRoute']);

app.config(['$routeProvider', function ($routeProvider) {
	$routeProvider
		.when('/tasks', {
			'templateUrl': '/task/masterlist.html',
			'controller': 'TasksController'
		})
		.when('/tasks/completed', {
			'templateUrl': '/task/completed_tasks.html',
			'controller': 'CompletedTasksController'
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
			'redirectTo': '/tasks'
		});
}]);


app.controller('TasksController', ['$rootScope', '$scope', '$http', function($rootScope, $scope, $http) {
	$rootScope.activeTab = 1;
	$http.get("/task/display")
    .success(function(data) {
    	$scope.tasks = data.taskList;
    	$scope.firstName = data.firstName;
    	if(data.errorList.length == 0) {
    		$scope.tasks = data.taskList;
        	$scope.firstName = data.firstName;
    	} else {
    		var msg = "";
			for (var i = 0; i < data.errorList.length; i++)
				msg += data.errorList[i] + "\n";
			alert(msg);
			console.log(msg);
    	}
    });
	
	$scope.addTaskToday = function(id) {
		var data = {
                id: id
            };
        $http.post("/taskstoday/addTaskToday", data)
        .success(function(data, status) {
        	if(data.errorList.length == 0) {
				alert("Task has been successfully added to Pending Tasks");
			} else {
				var msg = "";
				for (var i = 0; i < data.errorList.length; i++)
					msg += data.errorList[i] + "\n";
				alert(msg);
			}
        }).error(function(data, status, headers, config) {
        	
        });
    };
	
	
    $scope.editTask = function(task) {
    	window.location = window.location.href.split('#')[0] + '#/tasks/' + task.id;
    }; 
	
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
				alert(msg);
			}
        })
        .error(function(data, status, headers, config) {
        	
        });
    };
}]);
app.controller('CompletedTasksController', ['$rootScope', '$scope', '$http', function($rootScope, $scope, $http) {
	$rootScope.activeTab = 2;
	$http.get("/task/display")
    .success(function(data, status) {
    	if(data.errorList.length == 0) {
    		$scope.tasks = response.taskList;
        	$scope.firstName = response.firstName;
    	} else {
    		var msg = "";
			for (var i = 0; i < data.errorList.length; i++)
				msg += data.errorList[i] + "\n";
			alert(msg);
			console.log(msg);
    	}
    	
    });
}]);
app.controller('TodaysTaskController', ['$rootScope', '$scope', '$http', function($rootScope, $scope, $http) {
	$rootScope.activeTab = 3;
	$scope.check = function(date){
		//if true, then do not display invalid date entries
		return (new Date(date) < new Date());
	}
	
    $http.get("/taskstoday/displayTodaysTasks")
    .success(function(response) {
    	$scope.tasks = response.taskList;
    });
    
    
    $scope.finishTask = function(id) {
		var data = {
                id: id
            };
		
        $http.post("/task/completeTask", data)
        .success(function(data, status) {
        	if(data.errorList.length == 0) {
				alert("Task has been successfully completed");
				location.reload(true);
			} else {
				var msg = "";
				for (var i = 0; i < data.errorList.length; i++)
					msg += data.errorList[i] + "\n";
				alert(msg);
			}
        }).error(function(data, status, headers, config) {
        	
        });
    };
    
    $scope.updateTask = function(task) {
    	window.location = window.location.href.split('#')[0] + '#/tasks/today/' + task.id;
    }
    
    $scope.deleteTaskToday = function(id){
    	var data = {
    		id: id
        };
        $http.post("/taskstoday/deleteTaskToday", data)
        .success(function(data, status) {
        	console.log(data.id);
        	if(data.errorList.length == 0) {
				alert("Task has been successfully removed from Pending Tasks");
				location.reload(true);
			} else {
				var msg = "";
				for (var i = 0; i < data.errorList.length; i++)
					msg += data.errorList[i] + "\n";
				alert(msg);
			}
        })
        .error(function(data, status, headers, config) {
        	
        });    	
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
        $scope.taskSpentHours = 0;
    });
    
    $scope.updateTaskToday = function(){
    	var data = {
            id: taskId,
            spentHours : $scope.taskSpentHours
        };
    	$http.post("/taskstoday/editTask", data)
    	.success(function (data, status, headers, config) {
            
            if(data.errorList.length == 0) {
            	window.location = window.location.href.split('#')[0] + '#/tasks/today';
			} else {
				var msg = "";
				for (var i = 0; i < data.errorList.length; i++)
					msg += data.errorList[i] + "\n";
				$scope.errorMessage = msg;
			}
        });
    }
        
    $scope.backToTodaysTasks = function(){
    	window.location = window.location.href.split('#')[0] + '#/tasks/today';
    	console.log("Back to Todays tasks");
    }
}]);
app.controller('CreateTaskController', ['$scope', '$http', function($scope, $http) {
	$scope.submitted = false;
	$scope.taskName ="";
    $scope.taskPhase ="";
    $scope.taskEstHours ="";
    $scope.sendPost = function() {
    	if($scope.createTask.$valid)
    	{
	        var data = {
	                name: $scope.taskName,
	                phase: $scope.taskPhase,
	                estHours: $scope.taskEstHours
	            };
	        $http.post("/task/addTask", data)
	        .success(function(data, status, headers, config) {
	            console.log(data);
	        	if(data.errorList.length == 0) {
					alert("Task has been successfully added");
					$scope.taskName ="";
				    $scope.taskPhase ="";
				    $scope.taskEstHours ="";
				    window.location = window.location.href.split('#')[0] + '#/tasks';
				} else {
					var msg = "";
					for (var i = 0; i < data.errorList.length; i++)
						msg += data.errorList[i] + "\n";
					alert(msg);
				}
	        })
	        .error(function(data, status, headers, config) {
	        	alert("Task already exists!");
	        });
    	} else {
    		$scope.createTask.submitted = true;
    	}    	
    };
    
    $scope.clearFields = function(){
    	$scope.taskName ="";
        $scope.taskPhase ="";
        $scope.taskEstHours ="";
        $scope.taskStartDate ="";
        $scope.taskDueDate ="";
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
    	
    	var data = {
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
    };

}]);
app.controller('SettingsController', ['$rootScope', '$scope', '$http', function($rootScope, $scope, $http) {
	$rootScope.activeTab = 4;
	$http.get("/user/loggedInUser")
    .success(function(response) {
    	if(response.errorList.length == 0) {
    		$scope.firstName = response.firstName;
        	$scope.lastName = response.lastName;
        	$scope.username = response.username;
    	} else {
    		var msg = "";
			for (var i = 0; i < data.errorList.length; i++)
				msg += data.errorList[i] + "\n";
			alert(msg);
    	}    	
    });
	
	$scope.updateSettings = function(){
		console.log("update USER");
    	var data = {
            username: $scope.username,
            firstName : $scope.firstName,
            lastName : $scope.lastName,
            password : $scope.password
        };
    	$http.post("/user/loggedInUser", data)
    	.success(function (data, status, headers, config) {
            alert("User information has been succesfully updated");
            location.reload(true);
        });
    };
}]);
