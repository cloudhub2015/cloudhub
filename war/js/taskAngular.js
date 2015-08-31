var app = angular.module('masterList', []);
app.controller('displayTaskCtrl', function($scope, $http) {
    $http.get("/task/display")
    .success(function(response) {$scope.tasks = response.taskList; console.log(response.taskList);});
});

var todaysTask = angular.module('todaysTask', []);
todaysTask.controller('displayTodaysTaskCtrl', function($scope, $http) {
    $http.get("/taskstoday/displayTodaysTasks")
    .success(function(response) {$scope.tasks = response.taskList; console.log(response.taskList);});
});

