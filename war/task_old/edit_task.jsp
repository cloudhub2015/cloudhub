<!--
/* Partial UI done. With homepage, view tasks page,
* Add task page and search task page.
* @author Janna Tapitha S. Pedrano
* @version 0.01
* @as of July 7, 2015 1:45AM
*/
-->

<!DOCTYPE html>
<html lang="en" ng-app>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>Welcome to CloudHub!</title>

  <!-- CSS  -->
  <link href="../css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="../css/materialize_content.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="../material-icons/material-icons.css" rel="stylesheet" type="text/css">

</head>

<body>
<header>
<ul id="nav-mobile" class="side-nav fixed" style="left: 0px;">
    <li class="logo">
      <img src="../images/avatar.png" class="responsive-img">
      <p><h4 class="header_name">Hey, Riri!</h4></p>
    </li>

    <li class="active"><a href="/task/masterlist" class="waves-effect waves-teal">Masterlist</a></li>
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
        <h2 class="header"><img src="../images/edit.jpg" width="5%">&nbsp;&nbsp;Edit Task Information</h2>
        <p class="caption">Edit fields to edit task information.
          <div class="row">
            <form class="col s12">
              <div class="row">
                <div class="input-field col s6">
                  <input id="task_name" type="text" class="validate">
                  <label for="task_name">Task Name</label>
                </div>
              </div>

              <div class="row">
                <div class="col s6">
                  <select class="browser-default" id="selectPhase">
                    <option value="" disabled selected>Choose Phase</option>
                    <option value="1">Testing</option>
                    <option value="2">Coding</option>
                    <option value="3">Design</option>
                  </select>
                </div>
              </div>

              <div class="row">
                <div class="input-field col s6">
                  <input id="estimated_time" type="text" class="validate">
                  <label for="estimated_time">Estimated Time Allotment</label>
                </div>
              </div>

              <div class="row">
                <div class="input-field col s6">
                  <input id="start_date" type="date" class="datepicker picker__input">
                <label for="start_date">Start Date</label>
                </div>
              </div>

              <div class="row">
                <div class="input-field col s6">
                  <input id="due_date" type="date" class="datepicker picker__input">
                 <label for="due_date">Due Date</label>
                </div>
              </div>

              <a class="waves-effect waves-light btn"><i class="material-icon left">edit</i>Edit Task</a>
              &nbsp;&nbsp;&nbsp;
              <a href ="masterlist" class="waves-effect waves-light btn"><i class="material-icon left">clear_all</i>Go Back to Masterlist</a>
            </form>
          </div>
        </p>
        <br>
  </div>
</div>
</main>

  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="../jquery/jquery-1.8.2.js"></script>
  <script src="../jquery/jquery.ui.effect.js"></script> 
  <script src="../js/materialize.js"></script>
  <script src="../js/init.js"></script>
  <script src="../js/editTask.js"></script>
  <script src="../js/angular.js"></script>
  
 
   

  </body>
  </html>

