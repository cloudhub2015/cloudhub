/* ------------------------------------------------------------------------------
 * Javascript for creating task
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [08/07/2015] 0.01 - Jacquelyn Amaya - Function for clicking the button Create Task
 * --------------------------------------------------------------------------- */
$(document).ready(function() {
	//retrieveTweetList();
	
	//Add User
	$('#createTask').click(function() {
		$('#messageDisplay').empty();
		jsonData = {
				data: JSON.stringify({
				name: $('#task_name').val(),
				phase: $('#phase').val(),
				estHours: $('#estHours').val(),
				startDate: $('#start_date').val(),
				dueDate: $('#due_date').val()
				})
		};
		
		$.ajax({
			url: 'addTask',
			type: 'POST',
			data: jsonData,
			dataType: 'json',
			success: function(data, status, jqXHR){
				if(data.errorList.length == 0 && (confirmPassword == data.password)) {
					//$('#txtContent').val('');
					$('#messageDisplay').html("Task successfully added!");
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