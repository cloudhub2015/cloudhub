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
<html lang="en" ng-app>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>Welcome to CloudHub!</title>

  <!-- CSS  -->
  <link rel="stylesheet" href="../css/base.css" type="text/css" media="screen,projection"/>
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
  
    <li class="bold"><a href="../task/masterlist">Masterlist</a></li>
    <li class="active"><a href="../taskstoday/" class="waves-effect waves-teal">Today's Tasks</a></li>
    <li class="bold"><a href="../task/addTask" class="waves-effect waves-teal">Create Task</a></li>
    <li class="bold"><a href="../task/settings" class="waves-effect waves-teal">Settings</a></li>
    <li class="bold"><a href="../" class="waves-effect waves-teal">Log Out </a></li>
</ul>
</header>
 
<main>
<div class="container">
  <div class="row">
    <div class="col s12 m9 l10">
      <div id="right" class="section scrollspy">
        <h2 class="header"><img src="../images/view.jpg" width="5%">&nbsp;&nbsp;Today's Tasks</h2>
        <div class="row">
        	<div class="input-field col s6">
              <input id="search_bar" type="text" class="validate">
              <label for="search_bar"><i class="material-icon-legend left">search</i>Search Task Name</label>
            </div>
        </div>
        <p class="caption">Here is a list of tasks you have to accomplish within this day.</p>
		<!-- mod start 0.0.3 -->
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
        <br>
       
  </div>
</div>

</div>
<div class="row">
	<a class="btn-floating btn-large waves-effect waves-light red right modal-trigger" href="#modal1"><i class="material-icon">add</i></a>
 	 <!-- Modal Structure -->
	  <div id="modal1" class="modal">
	    <div class="modal-content">
	      <h4>Masterlist of Tasks</h4>
	      <p>Select tasks to be added for today:</p>
	      
	    </div>
	    <div class="modal-footer">
	      <!--  <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Add to Today's Task</a> -->
	       <button class="btn waves-effect waves-light" type="submit" ><i class="material-icon left">note_add</i>Add</button>
	    </div>
	  </div>
</div>
</div>
</main>

  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="../jquery/jquery-1.8.2.js"></script>
  <script src="../jquery/jquery.ui.effect.js"></script> 
  <script src="../js/materialize.js"></script>
  <script src="../js/init.js"></script>
  <script src="../js/angular.js"></script>
  
 
  
   <!-- mod start 0.0.3 -->
  
  <script>
    $(function() {
      
      $('.table_wrapper').find('tr').on('hover', function() {
        $(this).toggleClass('wrapper_odd', 200);
      });
      
      $('.table_wrapper').find('tr').on('click', function() {
        $(this).toggleClass('wrapper_action', 200);
      });
    });
    
    $(document).ready(function(){
        // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
        $('.modal-trigger').leanModal();
      });
  </script>
  <!-- mod end 0.0.3 -->
  </body>
</html>
