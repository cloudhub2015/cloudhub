/* ------------------------------------------------------------------------------
 * Javascript for user registration (with AJAX)
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [08/07/2015] 0.01 - Jacquelyn Amaya - Function for clicking the button Sign Up
 * [08/27/2015] 0.01 - Jacquelyn Amaya - Function for clicking the button Log In
 * --------------------------------------------------------------------------- */
$(document).ready(function() {
	$(function() {
		//Add User
		$('#btnSignUp').click(function() {
			var confirmPassword = $('#confirm_password').val();
			var msg = "Sign Up Completed ;)";
			jsonData = {
					data: JSON.stringify({
					firstname: $('#txtFirstName').val(),
					lastname: $('#txtLastName').val(),
					username: $('#txtUsername').val(),
					password: $('#txtPassword').val()
					})
			};
			console.log(jsonData);
			$.ajax({
				url: '/user/register',
				type: 'POST',
				data: jsonData,
				dataType: 'json',
				success: function(data, status, jqXHR){
					if(data.errorList.length == 0 && (confirmPassword == data.password)) {
						alert("User successfully registered!");
						alert(jsonData.data);
					} else {
						var msg = "";
						for (var i = 0; i < data.errorList.length; i++)
							msg += data.errorList[i] + "\n";
						$('#messageDisplay').html(msg);
					}
				},
				error: function(jqXHR, status, error) {
					
				}
			});
		}); // end of adding user
	});
	
	$(function() {
		$('#download-button').click(function() {
			jsonData = {
					data: JSON.stringify({
						username: $('#txtUsername').val(),
						password: $('#txtPassword').val()
					})
			};
			$.ajax({
				url: '/user/verifyUser',
				type: 'POST',
				data: jsonData,
				dataType: 'json',
				success: function(data, status, jqXHR){
					if(data.errorList.length == 0) {
						window.location.href="/task/masterlist";
					} else {
						var msg = "";
						for (var i = 0; i < data.errorList.length; i++)
							msg += data.errorList[i] + "\n";
						$('#txtPassword').val('');
						$('#errorMessage').html(msg);
					}
				},
				error: function(jqXHR, status, error) {
					
				}
			});
		}); // end of logging in
	});
});