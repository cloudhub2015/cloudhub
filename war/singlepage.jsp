<!-- REVISION HISTORY
* Single Page App
* 0.0.1 - July 07, 2015 1:45AM     - Janna Tapitha S. Pedrano  - Add task page and search task page.
* 0.0.2 - August 04, 2015 2:15PM   - Vine Deiparine            - Added jquery codes with corresponding js.
* 0.0.3 - August 04, 2015 2:15PM   - David Ramirez             - Integrate slim3 codes.
* 0.0.4 - September 01,2015 1:02AM - David Ramirez			   - Display pending and finish tasks using AngularJS
* 0.0.5 - September 08, 2015	   - Janna Tapitha Pedrano	   - Created the file for SPA | Provided links for each tab in side bar navigation
* 0.0.6 - September 08, 2015	   - Jacquelyn Amaya		   - Display first name of the user
* 0.0.7 - September 13, 2015	   - Jacquelyn Amaya		   - Import jquery-2.1.1.min.js | Removed active class for Masterlist tab
* 0.0.8 - September 15, 2015	   - Janna Tapitha S. Pedrano  - Added active linking using AngularJS 
-->

<%@page pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>


<!DOCTYPE html>
<html lang="en" ng-app="TaskManagementApp">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>Welcome to CloudHub!</title>

  <!-- CSS  -->
  <link rel="stylesheet" href="../css/base.css" type="text/css" media="screen,projection"/>
  <link href="../css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="../css/materialize_content.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="../material-icons/material-icons.css" rel="stylesheet" type="text/css">
  <link href="../jquery/jquery-ui-1.11.4/jquery-ui.structure.css" rel="stylesheet" type="text/css"/>
  <link href="../jquery/jquery-ui-1.11.4/jquery-ui.theme.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<header ng-controller="TasksController">
<ul id="nav-mobile" class="side-nav fixed" style="left: 0px;">
    <li class="logo">
      <img src="../images/avatar.png" class="responsive-img">
      <input type="hidden" id="username"/>
      <p><h4 class="header_name">Hey, {{firstName}}!</h4></p>
    </li>
    <li ng-class="{active: activeTab == 1}" class="bold"><a href="#/tasks" class="waves-effect waves-teal">Masterlist</a></li>
    <li ng-class="{active: activeTab == 2}" class="bold"><a href="#/tasks/completed" class="waves-effect waves-teal">Completed Tasks</a></li>
    <li ng-class="{active: activeTab == 3}" class="bold"><a href="#/tasks/today" class="waves-effect waves-teal">Pending Tasks</a></li>
    <li ng-class="{active: activeTab == 4}" class="bold"><a href="#/user/settings" class="waves-effect waves-teal">Settings</a></li>
    <li class="bold"><a href="/" class="waves-effect waves-teal">Log Out </a></li>
</ul>
</header>

<main ng-view></main> 

</body>
  <!--  Scripts-->
  
  <script src="/jquery/jquery-1.8.2.js"></script>
  <script src="/jquery/jquery-ui-1.11.4/jquery-ui.js"></script>
  <script src="/jquery/jquery.ui.effect.js"></script> 
  <script src="/js/materialize.js"></script>
  <script src="/js/init.js"></script>
  <script src="/js/angular.js"></script>
  <script src="/js/angular-route.js"></script>
  <script src="/js/user.js"></script>
  <script src="/js/app.js"></script>
  
  
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
</html>
