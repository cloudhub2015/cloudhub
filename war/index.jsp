<!--
/* Partial UI done. With homepage, view tasks page,
* Add task page and search task page.
* @author Janna Tapitha S. Pedrano
* @version 0.01
* @as of July 7, 2015 1:45AM
* Added register button functionality
* @author David Ramirez
* @version 0.02
* @as of July 12,2015 10:37PM
* Modified view task page: task name no longer greyed out,
* added action column for editing and deleting of task
* @author Janna Tapitha S. Pedrano
* @version 0.03
* @as of July 13,2015 10:37PM
* Login function with error message if invalid username and password
* @author Jacquelyn Amaya
* @version 0.04
* @as of September 7, 2015
* Fixed width issue
* @author Nelson Ruiz Jr.
* @version 0.05
* @as of September 9, 2015
*/
-->

<!DOCTYPE html>
<html lang="en" ng-app>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>CloudHub: Your Task Manager</title>

  <!-- CSS  -->
  <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="../material-icons/material-icons.css" rel="stylesheet" type="text/css">
</head>

<body>
  <!-- Menu -->
  <nav class="purple lighten-1" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="/" class="brand-logo">Home</a>
      <ul class="right hide-on-med-and-down">
        <li><a href="user/">Register</a></li>
      </ul>
    </div>
  </nav>

  <!-- Main Content -->
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
  		<div class="row center">
  		  <img src="images/logo/logo2.png" style="width:50%;">
        <h5 class="header col s12 light">Worldwide's best task management tool both for individuals and groups.</h5>
  		</div>
    </div>
  </div>
  <div class="container">
  <div class="divider"></div>
  </div>
  <!--Form-->
  <div class="container">
    <div class="my-row center">
    	<div class="my-row center">
      		<div class="col s7 materialize-red-text" id="errorMessage">
      		</div>
      	</div>
      <form class="my-col my-s12 my-offset-s4" method="post" action="verifyUser">
        <div class="my-row center">
          <div class="input-field my-col my-s4">
            <i class="material-icon prefix">account_circle </i>
            <input id="txtUsername" type="text" class="validate" placeholder="Username">
            <br>
            <i class="material-icon prefix">lock</i>
            <input id="txtPassword" type="password" class="validate" placeholder="Password">
          </div>
        </div>
        <div class="my-row center">
          <div class="my-col my-s4">
          	<a id="btnLogin" class="btn-large waves-effect waves-light purple">Log In</a>
          </div>
        </div>
      </form>
    </div>
  </div>

  <!-- Footer -->
  <footer class="page-footer pink lighten-2">
    <div class="container">
      <div class="row">
      </div>
    </div>
    <div class="footer-copyright center">
      <div class="container">Copyright 2015</div>
    </div>
  </footer>


  <!--  Scripts-->
  <script src="/jquery/jquery-2.1.1.min.js"></script>
  <script src="/jquery/jquery-1.8.2.js"></script>
  <script src="/jquery/jquery.ui.effect.js"></script> 
  <script src="/js/materialize.js"></script>
  <script src="/js/angular.js"></script>
  <script src="/js/init.js"></script>
  <script src="/js/user.js"></script>
  <script src="/js/app.js"></script>
  </body>
</html>
