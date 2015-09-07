<!-- REVISION HISTORY
*
* 
* 0.0.1 - July 07, 2015 1:45AM     - Janna Tapitha S. Pedrano  - Add task page and search task page.
* 0.0.2 - August 04, 2015 2:15PM   - Vine Deiparine            - Added jquery codes with corresponding js.
* 0.0.3 - August 04, 2015 2:15PM   - David Ramirez             - Integrate slim3 codes.
* 0.0.4 - September 01,2015 1:02AM - David Ramirez			   - Display pending and finish tasks using AngularJS
-->


<!-- mod start 0.0.3 -->
<%@page pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<!-- mod end 0.0.3 -->

<!-- mod start 0.0.1 -->

<!DOCTYPE html>
<html lang="en" ng-app="masterList">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>Welcome to CloudHub!</title>

  

  <!-- mod start 0.0.2 -->
  <!-- CSS  -->
  <link rel="stylesheet" href="../css/base.css" type="text/css" media="screen,projection"/> <!-- mod end 0.0.2 -->
  <link href="../css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="../css/materialize_content.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="../material-icons/material-icons.css" rel="stylesheet" type="text/css">

</head>

<body>
<header  ng-controller="displayTaskCtrl">
<ul id="nav-mobile" class="side-nav fixed" style="left: 0px;">
    <li class="logo">
      <img src="../images/avatar.png" class="responsive-img">
      <input type="hidden" id="username"/>
      <p><h4 class="header_name">Hey, {{ firstName }}!</h4></p>
    </li>

    <li class="active"><a href="/task/masterlist">Masterlist</a></li>
    <li class="bold"><a href="/taskstoday/" class="waves-effect waves-teal">Today's Tasks</a></li>
    <li class="bold"><a href="/task/createTask" class="waves-effect waves-teal">Create Task</a></li>
    <li class="bold"><a href="/user/settings" class="waves-effect waves-teal">Settings</a></li>
    <li class="bold"><a href="/" class="waves-effect waves-teal">Log Out </a></li>
</ul>
</header>

<main>
<div class="container">
  <div class="row">
    <div class="col s12 m9 l10">
      <div id="right" class="section scrollspy">
        <h2 class="header"><img src="../images/view.jpg" width="5%">&nbsp;&nbsp;List of Tasks</h2>
        <!-- mod start 0.0.4 -->
        <div class="row">
            <div class="input-field col s6">     
              <input id="search_bar" type="text" class="validate" data-ng-model="search.name">
              <label for="search_bar"><i class="material-icon-legend left">search</i>Search Task Name</label>
            </div>
            <div class="col s6">
            
             	 <select class="browser-default" ng-model="searchByPhase">
                 	<option value="">Filter by Phase</option>
                    <option value="Testing">Testing</option>
                    <option value="Coding">Coding</option>
                    <option value="Design">Design</option>
                 </select>
            </div>   
        </div>
        <!-- mod start 0.0.4 -->
        <p class="caption">Here is a list of tasks you have to accomplish.
				<p><b>Legend:</b> <br/><br/>
						<i class="material-icon-action">done</i>&nbsp;&nbsp;&nbsp;Done
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<i class="material-icon-action">assignment</i>&nbsp;&nbsp;&nbsp;Edit
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<i class="material-icon-action">delete</i>&nbsp;&nbsp;&nbsp;Delete
            			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       			</p>
      <!-- mod start 0.0.2 -->
      <div class="table_wrapper table_even">
		  <table class="unfinished_tasks" id="tasks"> <!-- mod start 0.0.2 -->
          <thead>
            <tr>
                <th data-field="status"><center>Task Name</center></th>
                <th data-field="name"><center>Phase</center></th>
                <th data-field="time_allotment"><center>Estimated Time Allotment</center></th>
                <th data-field="start_date"><center>Start Date</center></th>
                <th data-field="due_date"><center>Due Date</center></th>
				<th data-field="action"><center>Action</center></th>
            </tr>
          </thead>
          <tbody ng-controller="displayTaskCtrl"> 
			<tr data-ng-repeat="x in tasks| filter:searchByPhase | filter:search | orderBy:'name'"  ng-hide="{{x.finished}}">
				<input type="hidden" class="id" name="id" value="{{ x.id }}"/>
				   <td  class="taskName"><center>{{ x.name }}</center></td>
				   <td class="phase"><center>{{ x.phase }}</center></td>
				   <td class="estHours"><center>{{ x.estHours }}</center></td>
				   <td class="startDate"><center>{{ x.startDate }}</center></td>
				   <td class="dueDate"><center>{{ x.dueDate }}</center></td>
				   <td>
		                <a href="" class="btnDone"><i class="material-icon-action">done</i></a>
		      				&nbsp;&nbsp;&nbsp;
		      			<a href="/task/displayTaskToEdit" class="btnEdit"><i class="material-icon-action">assignment</i></a>
		      				&nbsp;&nbsp;&nbsp;
		      			<a  href="" class="btnDelete"><i class="material-icon-action">delete</i></a>
		      				&nbsp;&nbsp;&nbsp;
		              </td>
  			</tr>
		</tbody>
        </table>
        </div>
      

        <br>


        <h2 class="header" style="color: green;"><img src="../images/view.jpg" width="5%">&nbsp;&nbsp;Completed Tasks</h2>
        <p class="caption">Here is a list of tasks you have accomplished.

          <table class="finished_tasks table_wrapper table_even" id="finished_tasks">
          <thead>
            <tr>
                <th data-field="status"><center>Task Name</center></th>
                <th data-field="name"><center>Phase</center></th>
                <th data-field="time_allotment"><center>Total Spent Time</center></th>
                <th data-field="start_date"><center>Start Date</center></th>
                <th data-field="due_date"><center>Date of Completion</center></th>
            </tr>
          </thead>
          <tbody ng-controller="displayTaskCtrl">
          <tr ng-repeat="task in tasks"  ng-show="{{task.finished}}">
		         <td  class="taskName"> {{task.name}}</td>
		         <td><center> {{task.phase}} </center></td>
		         <td><center> {{task.estHours}} hrs </center></td>
		         <td><center> {{task.startDate}}</center></td>
		         <td><center> {{task.dueDate}}</center></td>
		  </tr>
          </tbody>
          </table>
           
  </div>
</div>
</main>
</body>
  <!--  Scripts-->
  
  <!-- <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script> -->
  <script src="../jquery/jquery-1.8.2.js"></script>
  <script src="../jquery/jquery.ui.effect.js"></script> 
  <script src="../js/materialize.js"></script>
  <script src="../js/init.js"></script>
  <script src="../js/angular.js"></script>
  <script src="../js/task.js"></script>
  <script src="../js/user.js"></script>
  
  <script src="../js/taskAngular.js"></script>
  <!-- mod start 0.0.2 -->
  <!-- jQuery -->
 
  <script>
    $(function() {
      
      $('.table_wrapper').find('tr').on('hover', function() {
        $(this).toggleClass('wrapper_odd', 200);
      });
      
      $('.table_wrapper').find('tr').on('click', function() {
        $(this).toggleClass('wrapper_action', 200);
      });
    });
  </script>
  <!-- mod end 0.0.2 -->
</html>
<!-- mod end 0.0.1 -->
