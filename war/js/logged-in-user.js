/* ------------------------------------------------------------------------------
 * Javascript for user details (with AJAX)
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [08/28/2015] 0.01 - Jacquelyn Amaya - Function for getting the details of the user
 * --------------------------------------------------------------------------- */
$(function() {
	var user_name = "";
	jsonData = {
			data: JSON.stringify({
				username: $('#txtUsername').val()
			})
		};
	
	$.ajax({
		url: '/user/login',
		type: 'POST',
		data: jsonData,
		dataType: 'json',
		success: function(data, status, jqXHR){
			//alert(data.errorList);
			if(data.errorList.length == 0) {
				//alert(data.username);
				$('.header_name').val("Hey, " + data.username);
				if (undefined != successMessage && "" != successMessage) {
					alert(successMessage);
				}
			} else {
				alert('Failed to retrieve username!');
			}
		},
		error: function(jqXHR, status, error) {
			
		}
	});
});

/**
 * Method used to retrieve list of tasks.
 * @param successMessage - success message to display
 * 		if the transaction is successful.
 */
function retrieveUser(successMessage) {
	
}