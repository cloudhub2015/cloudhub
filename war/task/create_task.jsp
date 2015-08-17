<!--
/* Partial UI done. With homepage, view tasks page,
* Add task page and search task page.
* @author Janna Tapitha S. Pedrano
* @version 0.01
* @as of July 7, 2015 1:45AM
*/
  0.0.1 - [08/09/15] - Nelson F. Ruiz Jr. - Empty Text Field Warning and Clear Text Fields
-->

<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>Welcome to CloudHub!</title>

  <!-- CSS  -->
  <!-- 0.0.1 start mod -->
  <link rel="stylesheet" href="../css/base.css" type="text/css" media="screen,projection"/>
  <!-- 0.0.1 end mod -->
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

    <li class="bold"><a href="../task/masterlist" class="waves-effect waves-teal">Masterlist</a></li>
    <li class="bold"><a href="../taskstoday/" class="waves-effect waves-teal">Today's Tasks</a></li>
    <li class="active"><a href="addTask" class="waves-effect waves-teal">Create Task</a></li>
    <li class="bold"><a href="searchTask" class="waves-effect waves-teal">Search Task</a></li>
    <li class="bold"><a href="../" class="waves-effect waves-teal">Log Out </a></li>
</ul>
</header>

<main>
<div class="container">
  <div class="row">
    <div class="col s12 m9 l10">
      <div id="right" class="section scrollspy">
        <h2 class="header"><img src="../images/add.jpg" width="5%">&nbsp;&nbsp;Create Task</h2>
        <p class="caption">Complete all needed information to add task.
          <div class="row">
            <form class="col s12">
              <div class="row">
              <!-- 0.0.1 mod start -->
                <div class="input-field col s6">
                <!-- 0.0.1 end start -->
                  <input name="name" type="text" class="validate" id="txtName">
                  <label class="active" for="task_name">Task Name</label>
                </div>
              </div>

              <div class="row">
                <div class="col s6">
                  <select class="browser-default" name="phase" id="selectPhase">
                    <option value="" disabled selected>Choose Phase</option>
                    <option value="1" name="testing">Testing</option>
                    <option value="2" name="coding">Coding</option>
                    <option value="3" name="design">Design</option>
                  </select>
                </div>
              </div>

              <div class="row">
                <div class="input-field col s6">
                  <input name="estHours" type="text" id="txtEstHours" class="validate" placeHolder="number of hours">
                  <label class="active" for="txtEstHours" >Estimated Time Allotment</label>
                </div>
              </div>

              <div class="row">
                <div class="input-field col s6">
                  <input id="startDate" name="startDate" type="date" class="datepicker picker__input" placeholder="Start Date">
                <label for="startDate"></label>
                </div>
              </div>

              <div class="row">
                <div class="input-field col s6">
                  <input id="dueDate" name="dueDate" id="dueDate" type="date" class="datepicker picker__input" placeholder="Due Date">
                 <label for="dueDate"></label>
                </div>
              </div>

               <!-- <a class="waves-effect waves-light btn"><i class="material-icons left">note_add</i>Create Task</a> -->
             <button class="btn waves-effect waves-light" type="submit"  value="create_task" name="btnCreateTask" id="btnCreateTask"><i class="material-icons left">note_add</i>Create Task</button>
              &nbsp;&nbsp;&nbsp;
              <button class="waves-effect waves-light btn" name="clearField" value="Cancel"><i class="material-icons left" id="btnClearAllInfo">clear_all</i>Clear Fields</button>
            </form>
          </div>
        </p>
        <br>
  </div>
</div>
</main>

  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="../js/materialize.js"></script>
  <script src="../js/init.js"></script>

  <!-- 0.0.1 start mod -->
  <script src="../jquery/jquery-1.8.2.js"></script>
  <script src="../jquery/jquery.ui.effect.js"></script> 
  <script src="../js/task.js"></script>
  <script>
  $(function() {	  
	  $('button.btn').click(function(event) {
		  event.preventDefault();
		  if ('create_task' == $(this).val()) {
		    for (var i = 0; i < $('.validate').length; i++) {
		      if ("" == $('.validate').eq(i).val()) {
		        $('.validate').eq(i).addClass('invalid');
		      } else {
		        $('.validate').eq(i).removeClass('invalid');
		      }
		    }
		    //for phases
		    for (var i = 0; i < $('.browser-default').length; i++) {
		      if ("" == $('.browser-default').eq(i).val()) {
		        $('.browser-default').eq(i).addClass('text_error');
		      } else {
		        $('.browser-default').eq(i).removeClass('text_error');
		      }
		    }
		  	//for start and due dates
		    for (var i = 0; i < $('.datepicker').length; i++) {
		      if ("" == $('.datepicker').eq(i).val()) {
		        $('.datepicker').eq(i).addClass('invalid');
		      } else {
		        $('.datepicker').eq(i).removeClass('invalid');
		      }
		    }
		    // Submit if there are no errors
            if ($('.invalid').length == 0) { 
                $('form').submit();
            }
		  } else if ('Cancel' == $(this).val()) {
				$('.validate').val('').removeClass('invalid');
				$('.browser-default').val('').removeClass('text_error');
				$('.datepicker').val('').removeClass('invalid');
			}		  
	});
  });
  </script>
  <!-- 0.0.1 end mod -->
  </body>
  </html>

