/* ------------------------------------------------------------------------------
 * Javascript for creating task (with AJAX)
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [08/07/2015] 0.01 - Jacquelyn Amaya - Function for clicking the button Create Task
 * --------------------------------------------------------------------------- */
$(function() {
	retrieveTaskList();
	console.log("Display.js");
	//Add User
		
});

/**
 * Method used to retrieve list of tweets.
 * @param successMessage - success message to display
 * 		if the transaction is successful.
 */
function retrieveTaskList(successMessage) {
	$("#taskList").empty();
	
	$.ajax({
		url: 'display',
		type: 'GET',
		data: null,
		datatype: 'json',
		success: function(data, status, jqXHR){
			console.log(data);
			if(data.errorList.length == 0) {
				var formattedTaskList = "";
				$.each(data.taskList, function(index, value) {
					formattedTaskList += '<tr>' +
		              '<td>' +
		              '  <input type="checkbox" id="status" />' +
		              '  <label for="status">' + value.taskName + '</label>' +
		              '</td>' +
		              '<td>' + value.phase +
		              '</td>' +
		              '<td><center>' + value.estHours + 'hrs </center></td>' +
		              '<td>' + value.startDate + '</td>' +
		              '<td>' + value.dueDate + '</td>' +
		      		  '<td>' +
		                '<a href="#"><i class="material-icons">done</i></a>' +
		      					'&nbsp;&nbsp;&nbsp;' +
		      					'<a href="edit_task.jsp"><i class="material-icons">assignment</i></a>' +
		      					'&nbsp;&nbsp;&nbsp;' +
		      				'<a  href="#"><i class="material-icons">delete</i></a>' + 
		      				'&nbsp;&nbsp;&nbsp;' +
		                '<a href="../taskstoday/"><i class="material-icons">add</i></a>' +
		      			  '</td>' +
		            '</tr>';
					
					//$('#taskList').find('tbody').append(formattedTaskList);
					$('#taskList').append(formattedTaskList);
					
				});
				
				if (formattedTaskList == "") {
					formattedTaskList = "<div>Add tasks! :)</div>";
				}
				$("#taskList").html(formattedTaskList);
				if (undefined != successMessage && "" != successMessage) {
					alert(successMessage);
				}
			} else {
				alert('Failed to retrieve tasks!');
			}
			console.log(data);
		},
		error: function(jqXHR, status, error) {
			
		}
	});
}