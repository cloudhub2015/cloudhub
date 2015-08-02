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
  <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="css/materialize_content.css" type="text/css" rel="stylesheet" media="screen,projection"/>

</head>

<body>
<header>
<ul id="nav-mobile" class="side-nav fixed" style="left: 0px;">
    <li class="logo">
      <img src="images/avatar.png" class="responsive-img">
      <p><h4 class="header_name">Hey, Riri!</h4></p>
    </li>

    <li class="bold"><a href="home.jsp" class="waves-effect waves-teal">Masterlist</a></li>
    <li class="bold"><a href="todays_tasks.jsp" class="waves-effect waves-teal">Today's Tasks</a></li>
    <li class="active"><a href="add_task.jsp" class="waves-effect waves-teal">Create Task</a></li>
    <li class="bold"><a href="search_task.jsp" class="waves-effect waves-teal">Search Task</a></li>
    <li class="bold"><a href="index.jsp" class="waves-effect waves-teal">Log Out </a></li>
</ul>
</header>

<main>
<div class="container">
  <div class="row">
    <div class="col s12 m9 l10">
      <div id="right" class="section scrollspy">
        <h2 class="header"><img src="images/add.jpg" width="5%">&nbsp;&nbsp;Create Task</h2>
        <p class="caption">Complete all needed information to add task.
          <div class="row">
            <form class="col s12" method="post" action="task">
              <div class="row">
                <div class="input-field col s6">
                  <input id="task_name" name="task_name" type="text" class="validate">
                  <label for="task_name">Task Name</label>
                </div>
              </div>

              <div class="row">
                <div class="col s6">
                  <select class="browser-default" name="phase">
                    <option value="" disabled selected name="phase">Choose Phase</option>
                    <option value="1" name="phase">Testing</option>
                    <option value="2" name="phase">Coding</option>
                    <option value="3" name="phase">Design</option>
                  </select>
                </div>
              </div>

              <div class="row">
                <div class="input-field col s6">
                  <input id="estimated_time" name="estimated_time" type="text" class="validate">
                  <label for="estimated_time">Estimated Time Allotment</label>
                </div>
              </div>

              <div class="row">
                <div class="input-field col s6">
                  <input id="start_date" name="start_date" type="date" class="datepicker picker__input">
                <label for="start_date"></label>
                </div>
              </div>

              <div class="row">
                <div class="input-field col s6">
                  <input id="due_date" name="due_date" type="date" class="datepicker picker__input">
                 <label for="due_date"></label>
                </div>
              </div>
			  <a class="waves-effect waves-light btn" id="create_task"><img src ="images/icons/ic_assignment_black_24dp_1x.png">Create Task</a>
              &nbsp;&nbsp;&nbsp;
              <a class="waves-effect waves-light btn" id="clear_fields"><img src="images/icons/ic_delete_black_24dp_1x.png">Clear Fields</a>
              <!--  <a class="waves-effect waves-light btn"><i class="material-icons left">note_add</i>Create Task</a>
              &nbsp;&nbsp;&nbsp;
              <a class="waves-effect waves-light btn"><i class="material-icons left">clear_all</i>Clear Fields</a> -->
            </form>
          </div>
        </p>
        <br>
  </div>
</div>
</main>

  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="../../bin/materialize.js"></script>
  <script src="js/init.js"></script>

  </body>
  </html>

