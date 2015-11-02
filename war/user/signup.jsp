<!-- REVISION HISTORY-->

<!-- 0.0.1 - July 06, 2015 - Vine Deiparine - Initial Draft -->
<!-- 0.0.2 - September 22, 2015 - Nelson Ruiz Jr. - UI Fix -->
<!-- 0.0.3 - September 27, 2015 - Janna Pedrano - Validation -->

<!------------------------------------------------------------------------------------------------------------------------------>

<!-- mod start 0.0.1 -->
<!DOCTYPE html>
<html lang="en" ng-app="RegistrationApp">
<head>

  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>Sign Up - CloudHub</title>

  <!-- CSS  -->
  <link href="../css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="../css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="../material-icons/material-icons.css" rel="stylesheet" type="text/css">
</head>

<body>
  <!-- Menu -->
  <nav class="purple lighten-1" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="/" class="brand-logo">Home</a>
      <ul class="right hide-on-med-and-down">
        <li><a href="/">Login</a></li>
      </ul>
    </div>
  </nav>

  <!-- Main Content -->
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <div class="row center">
        <img src="../images/logo/logo2.jpg" style="width:20%;">
        <h5 class="header col s12 light">Create your CloudHub account.</h5>
      </div>
    </div>
  </div>
  <div class="container">
    <div class="divider"></div>
  </div>
  <!--Registration Form-->
  <div class="container" ng-controller="SignUpController">
    <div class="my-row center">
       
      <div class="my-col my-s12 my-offset-s4">
      	<div class="my-row">
      		<div id="messageDisplay" class="input-field my-col my-s4">
      		</div>
      	</div>
      	<form class="col s12 offset-s4" name ="signup" novalidate ng-submit="sendPost()">
           <div class="my-row">
              <div class="input-field my-col my-s4">
                 <i class="material-icon prefix">perm_identity </i>
                 <label class="active" for="name">Name</label>
                 <input name="firstName" id="txtFirstName" type="text" class="validate"  ng-model="firstName" ng-minlength=3  ng-maxlength=50 placeholder="First Name" required>        
            	 <div class="error-container" ng-show="(signup.firstName.$dirty && signup.firstName.$invalid && signup.submitted) || 
            										  (signup.firstName.$pristine && signup.firstName.$invalid && signup.submitted)">
                	<small class="error" ng-show="signup.firstName.$error.required" style="color: red;">First Name is required.</small>
                  	<small class="error" ng-show="signup.firstName.$error.minlength" style="color: red;">First Name is required to be at least 3 characters.</small>
                  	<small class="error" ng-show="signup.firstName.$error.maxlength" style="color: red;">First Name cannot be longer than 50 characters.</small>
            	 </div>
                 
                 <input id="txtLastName" name="lastName" type="text" class="validate" ng-model="lastName" ng-minlength=3 ng-maxlength=50 placeholder="Last Name" required>
          		 <div class="error-container" ng-show="(signup.lastName.$dirty && signup.lastName.$invalid && signup.submitted) || 
            										  (signup.lastName.$pristine && signup.lastName.$invalid && signup.submitted)">
                	<small class="error" ng-show="signup.lastName.$error.required" style="color: red;">Last Name is required.</small>
                  	<small class="error" ng-show="signup.lastName.$error.minlength" style="color: red;">Last Name is required to be at least 3 characters.</small>
                  	<small class="error" ng-show="signup.lastName.$error.maxlength" style="color: red;">Last Name cannot be longer than 50 characters.</small>
            	 </div>
          	</div>
           </div>
           <div class="my-row">
              <div class="input-field my-col my-s4">
                 <i class="material-icon prefix">account_circle </i>
                 <label class="active" for="username">Username</label>
                 <input id="txtUsername" name="username" type="text" class="validate" ng-model="username" ng-minlenght=3 ng-maxlength=50 placeholder="Username" required>
          		 <div class="error-container" ng-show="(signup.username.$dirty && signup.username.$invalid && signup.submitted) || 
            										  (signup.username.$pristine && signup.username.$invalid && signup.submitted)">
                	<small class="error" ng-show="signup.username.$error.required" style="color: red;">Username is required.</small>
                  	<small class="error" ng-show="signup.username.$error.minlength" style="color: red;">Username is required to be at least 3 characters.</small>
                  	<small class="error" ng-show="signup.username.$error.maxlength" style="color: red;">Username cannot be longer than 50 characters.</small>
            	 </div>
              </div>
           </div>
           <div class="my-row">
               <div class="input-field my-col my-s4">
                 <i class="material-icon prefix">lock</i>
                 <label class="active" for="password">Password</label>
            	 <input id="txtPassword" type="password" class="validate" name="password" ng-model="password" ng-minlength=6 maxlength=50 placeholder="Password" required>
	             <div class="error-container" ng-show="(signup.password.$dirty && signup.password.$invalid && signup.submitted) || 
	            									  (signup.password.$pristine && signup.password.$invalid && signup.submitted)">
	                	<small class="error" ng-show="signup.password.$error.required" style="color: red;">Password is required.</small>
	                  	<small class="error" ng-show="signup.password.$error.minlength" style="color: red;">Password is required to be at least 6 characters.</small>
	                  	<small class="error" ng-show="signup.password.$error.maxlength" style="color: red;">Password cannot be longer than 50 characters.</small>
	           	 </div>
			     
                 <input id="confirm_password" type="password" class="validate" name="confirmPassword" placeholder="Confirm Password" ng-model="confirmPassword" required pw-check="password">
          		 <div class="error-container" ng-show="(signup.confirmPassword.$dirty && signup.confirmPassword.$invalid && signup.submitted) || 
	            									  (signup.confirmPassword.$pristine && signup.confirmPassword.$invalid && signup.submitted)">
	                	<small class="error" ng-show="signup.confirmPassword.$error.required" style="color: red;">Confirmation is required.</small>
	                  	<small class="error" ng-show="signup.confirmPassword.$error.noMatch" style="color: red;">Password does not match with previous entry.</small>
	           	 </div>
              </div>
           </div>
           <div class="my-row">
              <div class="input-field my-col my-s4">       
              <!--  <a id="btnSignUp" class="btn-large waves-effect waves-light purple">Sign Up</a>-->
              <button class="btn waves-effect waves-light" type="submit" value="Signup" id="btnSignup" ng-click="sendPost()">SIGNUP</button>
              </div>
           </div>
       </form> 
      </div>
    </div>
  </div>

  <!-- Footer -->
  <footer class="page-footer pink lighten-2">
    <div class="footer-copyright">
      <div class="container"><center>Copyright CloudHub 2015 All Rights Reserved</center></div>
    </div>
  </footer>

  </body>
  
  <!--  Scripts -->
   
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="../jquery/jquery-1.8.2.js"></script>
  <script src="../jquery/jquery.ui.effect.js"></script> 
  <script src="../js/materialize.js"></script>
  <script src="../js/angular.js"></script>
  <script src="../js/init.js"></script>
  <script src="../js/register.js"></script>

</html>
<!-- mod end 0.0.1 -->

