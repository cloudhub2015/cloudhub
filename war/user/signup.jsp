<!-- REVISION HISTORY-->

<!-- 0.0.1 - July 06, 2015   - Vine Deiparine     - Initial Draft -->
<!-- 0.0.2 - August 09, 2015 - Nelson Jr. F. Ruiz - Added jQuery codes: empty textfield warning -->

<!------------------------------------------------------------------------------------------------------------------------------>

<!-- mod start 0.0.1 -->
<!DOCTYPE html>
<html lang="en">
<head>

  <!-- header icons -->
  <link rel="apple-touch-icon" sizes="57x57" href="mobile_icons/images/apple-icon-57x57.png">
  <link rel="apple-touch-icon" sizes="60x60" href="mobile_icons/images/apple-icon-60x60.png">
  <link rel="apple-touch-icon" sizes="72x72" href="mobile_icons/images/apple-icon-72x72.png">
  <link rel="apple-touch-icon" sizes="76x76" href="mobile_icons/images/apple-icon-76x76.png">
  <link rel="apple-touch-icon" sizes="114x114" href="mobile_icons/images/apple-icon-114x114.png">
  <link rel="apple-touch-icon" sizes="120x120" href="mobile_icons/images/apple-icon-120x120.png">
  <link rel="apple-touch-icon" sizes="144x144" href="mobile_icons/images/apple-icon-144x144.png">
  <link rel="apple-touch-icon" sizes="152x152" href="mobile_icons/images/apple-icon-152x152.png">
  <link rel="apple-touch-icon" sizes="180x180" href="mobile_icons/images/apple-icon-180x180.png">
  <link rel="icon" type="image/png" sizes="192x192"  href="android-icon-192x192.png">
  <link rel="icon" type="image/png" sizes="32x32" href="mobile_icons/images/favicon-32x32.png">
  <link rel="icon" type="image/png" sizes="96x96" href="mobile_icons/images/favicon-96x96.png">
  <link rel="icon" type="image/png" sizes="16x16" href="mobile_icons/images/favicon-16x16.png">
  <link rel="manifest" href="mobile_icons/manifest.json">
  <meta name="msapplication-TileColor" content="#ffffff">
  <meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
  <meta name="theme-color" content="#ffffff">
  <!-- end of header icons -->

  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>Sign Up - CloudHub</title>

  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="../css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="../css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>

<body>
  <!-- Menu -->
  <nav class="purple lighten-1" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="/" class="brand-logo">Home</a>
      <ul class="right hide-on-med-and-down">
        <li><a href="/">Login</a></li>
      </ul>
      <!--<ul id="nav-mobile" class="side-nav">
        <li><a href="#">Register</a></li>
      </ul>
      <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>-->
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
  <div class="container">
    <div class="row center">
      <form class="col s12 offset-s4" method="post" action="register">
        <div class="row">
          <div class="input-field col s4">
            <i class="material-icons prefix">perm_identity </i>
              <label for="first_name">Name</label>
            <input id="icon_prefix" placeholder="First Name" name="firstName" id="first_name" type="text" class="validate">
            <input placeholder="Last Name" id="last_name" name="lastName" type="text" class="validate">
          </div>
        </div>
        <div class="row">
          <div class="input-field col s4">
            <i class="material-icons prefix">account_circle </i>
            <input id="icon_prefix" placeholder="Username" id="user_name" name="username" type="text" class="validate">
            <label for="user_name">Username</label>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s4">
            <i class="material-icons prefix">info</i>
            <input id="password" type="password" class="validate" placeholder="Password" name="password">
              <label for="password">Password</label>
            <input id="confirm_password" type="password" class="validate" placeholder="Confirm Password">
          </div>
        </div>
        <div class="row">
          <div class="input-field col s4">
            <i class="material-icons prefix">phone</i>
            <input id="tel" type="tel" name="telephone" class="validate">
            <label for="tel">Telephone</label>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s4">
            <i class="material-icons prefix">email</i>
            <input id="email" type="email" name="email" class="validate" placeholder="Email">
            <label for="email">Email</label>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s4">
          <!--  <a href="#" id="download-button" class="btn-large waves-effect waves-light purple">Sign Up</a> -->
          <button class="waves-effect waves-light btn" type="submit" href="/"  value="Register User" name="registerUser"><i class="material-icons left">note_add</i>Sign Up</button>
          </div>
        </div>
      </form>
    </div>
  </div>

  <!-- Footer -->
  <footer class="page-footer pink lighten-2">
    <div class="footer-copyright">
      <div class="container"><center>Copyright CloudHub 2015 All Rights Reserved</center></div>
    </div>
  </footer>


  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="../js/materialize.js"></script>
  <script src="../js/init.js"></script>
  <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script type="text/javascript" src="js/materialize.min.js"></script>
  <!-- 0.0.2 start mod -->
  <script src="../jquery/jquery-1.8.2.js"></script>
  <script src="../jquery/jquery.ui.effect.js"></script> 
  <script>
  $(function() {	  
	  $('button.btn').click(function(event) {
		  event.preventDefault();
		  if ('Register User' == $(this).val()) {
		    for (var i = 0; i < $('.validate').length; i++) {
		      if ("" == $('.validate').eq(i).val()) {
		        $('.validate').eq(i).addClass('invalid');
		      } else {
		        $('.validate').eq(i).removeClass('invalid');
		      }
		    }
		  }
	  });
  });
  </script>
  <!-- 0.0.2 end mod -->
</body>

</html>
<!-- mod end 0.0.1 -->

