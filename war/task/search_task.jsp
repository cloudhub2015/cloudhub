<!--
/* Partial UI done. With homepage, view tasks page,
* Add task page and search task page.
* @author Janna Tapitha S. Pedrano
* @version 0.01
* @as of July 7, 2015 1:45AM
*/
-->

<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

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
  
    <li class="bold"><a href="../task/masterlist" class="waves-effect waves-teal">Masterlist</a></li>
    <li class="bold"><a href="../taskstoday/" class="waves-effect waves-teal">Today's Tasks</a></li>
    <li class="bold"><a href="addTask" class="waves-effect waves-teal">Create Task</a></li>
    <li class="active"><a href="searchTask" class="waves-effect waves-teal">Search Task</a></li>
    <li class="bold"><a href="../" class="waves-effect waves-teal">Log Out </a></li>
</ul>
</header>

<main>
<div class="container">
  <div class="row">
    <div class="col s12 m9 l10">
      <div id="right" class="section scrollspy">
        <h2 class="header"><img src="../images/search.jpg" width="5%">&nbsp;&nbsp;Search Task</h2>
        <p class="caption">Search by Task name or select filter.
          
          <div class="row">
            <div class="input-field col s6">
              
              <input name="search_bar_name" id="search_bar" type="text" class="validate" value="lol">
              <label class="active" for="search_bar">Search Task Name</label>
              <!--<label for="search_bar"><i class="material-icons left">search</i>Search Task Name</label>-->
            </div>
      
        
      
            <div class="input-field col s6">
              <div class="col s6">
              <select name="sel" id="sel_id "class="browser-default">
                 <option value="" disabled selected>Choose Filter</option>
                 <option value="1">Phase</option>
                 <option value="2">Start Date</option>
                 <option value="3">Due Date</option>
              </select>
              </div>
            </div>
          </div>
               
          <table>
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
          <c:forEach var="e" items="${taskList}">
            <tr>
              <c:choose>
              <c:when test="${f:h(e.name) == 'JSP'}">
              <td><!-- name -->
                <input type="checkbox" id="status" />
                <label for="status">${f:h(e.name)}</label>
              </td>
              <td><!-- phase -->
              	<c:choose>
			    <c:when test="${e.phase == 1}">Testing</c:when>
			    <c:when test="${e.phase == 2}">Coding</c:when>
			    <c:when test="${e.phase == 3}">Design</c:when>
				</c:choose>
			 </td><!-- hours -->
              <td><center>${f:h(e.estHours)} Hours</center></td>
              <td>${f:h(e.startDate)}</td><!-- start date -->
              <td>${f:h(e.dueDate)}</td><!-- due date -->
      			  <td>
                <a href="#"><i class="material-icons">done</i></a>
      					&nbsp;&nbsp;&nbsp;
      					<a href="edit_task.jsp"><i class="material-icons">assignment</i></a>
      					&nbsp;&nbsp;&nbsp;
      				<a  href="deleteTweet('form_${f:h(e.id)}')"><i class="material-icons">delete</i></a> 
      				<!--	<button class="material-icons" onClick="deleteTweet('form_${f:h(e.id)}')">Delete</button> -->
                &nbsp;&nbsp;&nbsp;
                <a href="../taskstoday/"><i class="material-icons">add</i></a>
                 <!-- <span><a href = "#">Done</a></span> |
                  <span><a href = "edit_task.html">Edit</a></span> |
                  <span><a href = "#">Delete</a></span>-->
      			  </td>
              </c:when>
              </c:choose>
            </tr>
            </c:forEach>
            
            <!-- sample -->
            
            <tr>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
          </tbody>
        </table>
        </p>
        <p>Select task to edit, delete or mark as done.</p>
        <button  id="hehe" class="waves-effect waves-light btn"><i class="material-icons left">done</i>Done</button>
        &nbsp;&nbsp;&nbsp;
        <a class="waves-effect waves-light btn"><i class="material-icons left">assignment</i>Edit</a>
        &nbsp;&nbsp;&nbsp;
        <a class="waves-effect waves-light btn"><i class="material-icons left">delete</i>Delete</a>
        </p>
        <br>
  </div>
</div>
</main>

  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="../js/materialize.js"></script>
  <script src="../js/init.js"></script>
  
  
  <script src="../jquery/jquery-1.8.2.js"></script>
  <script src="../jquery/jquery.ui.effect.js"></script> 
  <script>
  $(function() {	  
	  $('button#hehe').click(function(event) {
	  	alert($("#search_bar").val()+" yeah!");
	  }); 
  });
  </script>
  
  </body>
  </html>

