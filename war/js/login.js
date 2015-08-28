/* ------------------------------------------------------------------------------
 * Javascript for user login (with AJAX)
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [08/27/2015] 0.01 - Jacquelyn Amaya - Function for clicking the button Log In
 * --------------------------------------------------------------------------- */
$(document).ready(function() {
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
						window.location.href="/user/logIn";
					} else {
						var msg = "";
						for (var i = 0; i < data.errorList.length; i++)
							msg += data.errorList[i] + "\n";
						$('#errorMessage').html(msg);
					}
				},
				error: function(jqXHR, status, error) {
					
				}
			});
		}); // end of logging in
	});
});