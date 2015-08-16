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
        <h2 class="header"><img src="../images/edit.jpg" width="5%">&nbsp;&nbsp;Update Task</h2>
        <p class="caption">Update today's tasks.</p>

        <table class="unfinished_tasks">
          <tbody>
            <tr>
              <td><b>Task Name</b></td>
              <td>Graphic User Inteface Design</td>
            </tr>

            <tr>
              <td><b>Phase</b></td>
              <td>Design</td>
            </tr>

            <tr>
              <td><b>Estimated Time</b></td>
              <td>
                <div class="row">
                <div class="input-field col s6">
                <input id="task_name" type="text" class="validate">     
                </div>
              </div>
            </td>
            </tr>

            <tr>
              <td><b>Status of Task</b></td>
              <td>
                <div class="row">
                    <div class="col s6">
                      <select class="browser-default">
                        <option value="" disabled selected>Select Status</option>
                        <option value="1">Pending</option>
                        <option value="2">Done</option>
                      </select>
                    </div>
                  </div>
                </td>
              </tr>
          </tbody>
        </table>

        <a class="waves-effect waves-light btn"><i class="material-icons left">edit</i>Update Task</a>
        &nbsp;&nbsp;&nbsp;
        <a href ="../taskstoday/" class="waves-effect waves-light btn"><i class="material-icons left">clear_all</i>Go Back to Today's Tasks</a>
		  
      
        <br>
  </div>
</div>
</main>

  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="../js/materialize.js"></script>
  <script src="../js/init.js"></script>
  
  </body>
</html>
