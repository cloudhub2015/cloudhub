/* ------------------------------------------------------------------------------
 * Javascript for user registration (with AJAX)
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [08/07/2015] 0.01 - Jacquelyn Amaya - Function for clicking the button Sign Up
 * --------------------------------------------------------------------------- */
$(document).ready(function() {
	//retrieveTweetList();
	
	//Add User
	$('#btnSignUp').click(function() {
		$('#messageDisplay').empty();
		//$('.updateErrorDisplay').empty();
		var confirmPassword = $('#confirm_password').val();

		jsonData = {
				data: JSON.stringify({
				firstname: $('#first_name').val(),
				lastname: $('#last_name').val(),
				username: $('#username').val(),
				password: $('#password').val()
				})
		};
		
		$.ajax({
			url: 'register',
			type: 'POST',
			data: jsonData,
			dataType: 'json',
			success: function(data, status, jqXHR){
				if(data.errorList.length == 0 && (confirmPassword == data.password)) {
					//$('#txtContent').val('');
					$('#messageDisplay').html("User successfully saved!");
					//alert("User successfully saved!");
					//retrieveTweetList('Entry saved successfully!');
				} else {
					var msg = "";
										for (var i = 0; i < data.errorList.length; i++)
	msg += data.errorList[i] + "\n";
					$('#messageDisplay').html(msg);
					//alert(msg);
				}
			},
			error: function(jqXHR, status, error) {
				
			}
		});
	}); // end of adding user
});