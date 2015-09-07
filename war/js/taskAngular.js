var app = angular.module('masterList', []);
app.controller('displayTaskCtrl', function($scope, $http) {
    $http.get("/task/display")
    .success(function(response) {
    	$scope.tasks = response.taskList;
    	$scope.firstName = response.firstName;
    });
});

var todaysTask = angular.module('todaysTask', []);
todaysTask.controller('displayTodaysTaskCtrl', function($scope, $http) {
	$scope.check = function(date){
		//if true, then do not display invalid date entries
		return (new Date(date)<new Date());
	}
    $http.get("/taskstoday/displayTodaysTasks")
    .success(function(response) {
    	$scope.tasks = response.taskList; 
    	console.log(response.taskList);
    	$scope.firstName = response.firstName;
    });
});

var addTask = angular.module('createTask', [],function($httpProvider) {
	  // Use x-www-form-urlencoded Content-Type
	  $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';

	  /**
	   * The workhorse; converts an object to x-www-form-urlencoded serialization.
	   * @param {Object} obj
	   * @return {String}
	   */ 
	  var param = function(obj) {
	    var query = '', name, value, fullSubName, subName, subValue, innerObj, i;

	    for(name in obj) {
	      value = obj[name];

	      if(value instanceof Array) {
	        for(i=0; i<value.length; ++i) {
	          subValue = value[i];
	          fullSubName = name + '[' + i + ']';
	          innerObj = {};
	          innerObj[fullSubName] = subValue;
	          query += param(innerObj) + '&';
	        }
	      }
	      else if(value instanceof Object) {
	        for(subName in value) {
	          subValue = value[subName];
	          fullSubName = name + '[' + subName + ']';
	          innerObj = {};
	          innerObj[fullSubName] = subValue;
	          query += param(innerObj) + '&';
	        }
	      }
	      else if(value !== undefined && value !== null)
	        query += encodeURIComponent(name) + '=' + encodeURIComponent(value) + '&';
	    }

	    return query.length ? query.substr(0, query.length - 1) : query;
	  };

	  // Override $http service's default transformRequest
	  $httpProvider.defaults.transformRequest = [function(data) {
	    return angular.isObject(data) && String(data) !== '[object File]' ? param(data) : data;
	  }];
	});
addTask.controller('addTaskCtrl', function($scope, $http) {
    console.log("ANGULAR ADDDDDDDDDD!!!!!");
    $scope.taskName ="";
    $scope.taskPhase ="";
    $scope.taskEstHours ="";
    $scope.taskStartDate ="";
    $scope.taskDueDate ="";
    $scope.sendPost = function() {
    	console.log("DATA PART");
        var data = $.param({
            json: JSON.stringify({
                name: $scope.taskName,
                phase: $scope.taskPhase,
                estHours: $scope.taskEstHours,
                startDate: $scope.taskStartDate,
                dueDate: $scope.taskDueDate,
            })
        });
        $http.post("/task/addTask", data).success(function(data, status) {
            console.log(data);
        	if(data.errorList.length == 0) {
				//alert("Task has been successfully added");
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
        })
    }                
});
