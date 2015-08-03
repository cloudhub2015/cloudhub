<!--
/* Partial UI done. With homepage, view tasks page,
* Add task page and search task page.
* @author Janna Tapitha S. Pedrano
* @version 0.01
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

    <li class="active"><a href="../task/">Masterlist</a></li>
    <li class="bold"><a href="../taskstoday/" class="waves-effect waves-teal">Today's Tasks</a></li>
    <li class="bold"><a href="addTask" class="waves-effect waves-teal">Create Task</a></li>
    <li class="bold"><a href="SearchTask" class="waves-effect waves-teal">Search Task</a></li>
    <li class="bold"><a href="../" class="waves-effect waves-teal">Log Out </a></li>
</ul>
</header>

<main>
<div class="container">
  <div class="row">
    <div class="col s12 m9 l10">
      <div id="right" class="section scrollspy">
        <h2 class="header"><img src="../images/view.jpg" width="5%">&nbsp;&nbsp;List of Tasks</h2>
        <p class="caption">Here is a list of tasks you have to accomplish.
				<p><b>Legend:</b> <br/><br/>
						<i class="material-icons-small">done</i>&nbsp;&nbsp;&nbsp;Done
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<i class="material-icons-small">assignment</i>&nbsp;&nbsp;&nbsp;Edit
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<i class="material-icons-small">delete</i>&nbsp;&nbsp;&nbsp;Delete
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <i class="material-icons-small">add</i>&nbsp;&nbsp;&nbsp;Add to Today's Tasks

				</p>
		  <table class="unfinished_tasks">
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
          <tbody>
            <tr>
              <td>
                <input type="checkbox" id="status" />
                <label for="status">Task Management Design</label>
              </td>
              <td>Design</td>
              <td><center>8 Hours</center></td>
              <td>July 2, 2015</td>
              <td>July 3, 2015</td>
      			  <td>
                <a href="#"><i class="material-icons">done</i></a>
      					&nbsp;&nbsp;&nbsp;
      					<a href="edit_task.jsp"><i class="material-icons">assignment</i></a>
      					&nbsp;&nbsp;&nbsp;
      					<a href="#"><i class="material-icons">delete</i></a>
                &nbsp;&nbsp;&nbsp;
                <a href="../taskstoday/"><i class="material-icons">add</i></a>
                 <!-- <span><a href = "#">Done</a></span> |
                  <span><a href = "edit_task.html">Edit</a></span> |
                  <span><a href = "#">Delete</a></span>-->
      			  </td>
            </tr>
            <tr>
              <td>
                <input type="checkbox" id="status2" />
                <label for="status2">Task Management Function 1</label>
              </td>
              <td>Coding</td>
              <td><center>8 Hours</center></td>
              <td>July 2, 2015</td>
              <td>July 3, 2015</td>
			  <td>
          <a href="#"><i class="material-icons">done</i></a>
					&nbsp;&nbsp;&nbsp;
					<a href="edit_task.jsp"><i class="material-icons">assignment</i></a>
					&nbsp;&nbsp;&nbsp;
					<a href="#"><i class="material-icons">delete</i></a>
          &nbsp;&nbsp;&nbsp;
          <a href="../taskstoday/"><i class="material-icons">add</i></a>
           <!--<span><a href = "#">Done</a></span> |
            <span><a href = "edit_task.html">Edit</a></span> |
            <span><a href = "#">Delete</a></span>-->
			  </td>
            </tr>
            <tr>
              <td>
                <input type="checkbox" id="status3" />
                <label for="status3">Task Management Function 2</label>
              </td>
              <td>Testing</td>
              <td><center>8 Hours</center></td>
              <td>July 2, 2015</td>
              <td>July 3, 2015</td>
			  <td><a href="#"><i class="material-icons">done</i></a>
					&nbsp;&nbsp;&nbsp;
					<a href="edit_task.jsp"><i class="material-icons">assignment</i></a>
					&nbsp;&nbsp;&nbsp;
					<a href="#"><i class="material-icons">delete</i></a>
          &nbsp;&nbsp;&nbsp;
          <a href="../taskstoday/"><i class="material-icons">add</i></a>
            <!--<span><a href = "#">Done</a></span> |
            <span><a href = "edit_task.html">Edit</a></span> |
            <span><a href = "#">Delete</a></span>-->

			  </td>
            </tr>
          </tbody>
        </table>
        </p>

        <br>


        <h2 class="header" style="color: green;"><img src="../images/view.jpg" width="5%">&nbsp;&nbsp;Completed Tasks</h2>
        <p class="caption">Here is a list of tasks you have accomplished.

          <table class="finished_tasks">
          <thead>
            <tr>
                <th data-field="status"><center>Task Name</center></th>
                <th data-field="name"><center>Phase</center></th>
                <th data-field="time_allotment"><center>Time Alloted</center></th>
                <th data-field="start_date"><center>Start Date</center></th>
                <th data-field="due_date"><center>Date of Completion</center></th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td><center>Graphic User Interface Layout</center></td>
              <td><center>Design</center></td>
              <td><center>8 Hours</center></td>
              <td><center>July 11, 2015</center></td>
              <td><center>July 21, 2015</center></td>
            </tr>
  </div>
</div>
</main>

  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="../../bin/materialize.js"></script>
  <script src="../js/init.js"></script>

  </body>
</html>
