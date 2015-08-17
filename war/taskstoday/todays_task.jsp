<!--
/* Partial UI done. With homepage, view tasks page,
* Add task page and search task page.
* @author Janna Tapitha S. Pedrano
* @version 0.01
* @version 0.02 Revision - Fixed Bug by David Ramirez
* @as of July 7, 2015 1:45AM
*/
-->

<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>Welcome to CloudHub!</title>

  <!-- CSS  -->
  <link rel="stylesheet" href="../css/base.css" type="text/css" media="screen,projection"/>
  <link href="../css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="../css/materialize_content.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  
</head>

<body>
<header>
<ul id="nav-mobile" class="side-nav fixed" style="left: 0px;">
    <li class="logo">   
      <img src="../images/avatar.png" class="responsive-img">
      <p><h4 class="header_name">Hey, Riri!</h4></p>
    </li>
  
    <li class="bold"><a href="../task/masterlist">Masterlist</a></li>
    <li class="active"><a href="../taskstoday/" class="waves-effect waves-teal">Today's Tasks</a></li>
    <li class="bold"><a href="../task/addTask" class="waves-effect waves-teal">Create Task</a></li>
    <li class="bold"><a href="../task/searchTask" class="waves-effect waves-teal">Search Task</a></li>
    <li class="bold"><a href="../" class="waves-effect waves-teal">Log Out </a></li>
</ul>
</header>
 
<main>
<div class="container">
  <div class="row">
    <div class="col s12 m9 l10">
      <div id="right" class="section scrollspy">
        <h2 class="header"><img src="../images/view.jpg" width="5%">&nbsp;&nbsp;Today's Tasks</h2>
        <p class="caption">Here is a list of tasks you have to accomplish within this day.</p>
		  <!-- mod start 0.0.3 -->
      <table class="table_wrapper table_even unfinished_tasks">
      <!-- mod end 0.0.3 -->
          <thead>
            <p class="caption" style="color: red;"><b>Unfinished Tasks</b></p>
            <tr>
                <th data-field="status"><center>Task Name</center></th>
                <th data-field="name"><center>Phase</center></th>
                <th data-field="time_allotment"><center>Estimated Time Allotment</center></th>
                <th data-field="start_date"><center>Start Date</center></th>
                <th data-field="due_date"><center>Due Date</center></th>
				        <th data-field="action"><center>Action</center></th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>
                <input type="checkbox" id="status1" />
                <label for="status1">Tasm Management Design</label>
              </td>
              <td>Design</td>
              <td><center>8 Hours</center></td>
              <td>July 2, 2015</td>
              <td>July 3, 2015</td>
			         <td><a href="../taskstoday/updateTask">Update Task</a>
					</tbody>
        </table>

         <table class="table_wrapper table_even todays_tasks">
          <thead>
            <p class="caption" style="color: blue;"><b>Today's Tasks</b></p>
            <tr>
                <th data-field="status"><center>Task Name</center></th>
                <th data-field="name"><center>Phase</center></th>
                <th data-field="time_allotment"><center>Estimated Time Allotment</center></th>
                <th data-field="start_date"><center>Start Date</center></th>
                <th data-field="due_date"><center>Due Date</center></th>
                <th data-field="action"><center>Action</center></th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>
                <input type="checkbox" id="status2" />
                <label for="status2">Tasm Management Design</label>
              </td>
              <td>Design</td>
              <td><center>8 Hours</center></td>
              <td>July 2, 2015</td>
              <td>July 3, 2015</td>
               <td><a href="../taskstoday/updateTask">Update Task</a>
          </tbody>
        </table>

        <table class="table_wrapper table_even pending_tasks">
          <thead>
            <p class="caption" style="color: violet;"><b>Pending Tasks</b></p>
            <tr>
                <th data-field="status"><center>Task Name</center></th>
                <th data-field="name"><center>Phase</center></th>
                <th data-field="time_allotment"><center>Estimated Time Allotment</center></th>
                <th data-field="start_date"><center>Start Date</center></th>
                <th data-field="due_date"><center>Due Date</center></th>
                <th data-field="action"><center>Action</center></th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>
                <input type="checkbox" id="status3" />
                <label for="status3">Tasm Management Design</label>
              </td>
              <td>Design</td>
              <td><center>8 Hours</center></td>
              <td>July 2, 2015</td>
              <td>July 3, 2015</td>
               <td><a href="#">Add to current Date</a>
          </tbody>
        </table>
        </p>
        <br>
  </div>
</div>
</main>

  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="../js/materialize.js"></script>
  <script src="../js/init.js"></script>
  
   <!-- mod start 0.0.3 -->
   <script src="../jquery/jquery-1.8.2.js"></script>
  <script src="../jquery/jquery.ui.effect.js"></script> 
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
  <!-- mod end 0.0.3 -->
  </body>
</html>
