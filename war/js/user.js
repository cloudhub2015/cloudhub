/* ------------------------------------------------------------------------------
 * Javascript for user registration (with AJAX)
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [08/07/2015] 0.01 - Jacquelyn Amaya - Function for clicking the button Sign Up
 * [08/27/2015] 0.02 - Jacquelyn Amaya - Function for clicking the button Log In
 * --------------------------------------------------------------------------- */
$(document).ready(function() {
	$(function() {
		$('#btnLogin').click(function() {
			jsonData = {
					data: JSON.stringify({
						username: $('#txtUsername').val(),
						password: $('#txtPassword').val()
					})
			};
			$.ajax({
				url: '/user/login',
				type: 'POST',
				data: jsonData,
				dataType: 'json',
				success: function(data, status, jqXHR){
					if(data.errorList.length == 0) {
						window.location.href = "/";
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