/* ------------------------------------------------------------------------------
 * Javascript for creating task (with AJAX)
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [08/07/2015] 0.01 - Jacquelyn Amaya - Function for clicking the button Create Task
 * [08/17/2015] 0.02 - David Ramirez - retrieveTaskList and createTask working
 * 
 * --------------------------------------------------------------------------- */
$(function() {
	retrieveTaskList();
	console.log("Display.js");
	//console.log("TASK NAME: " + $('#txtName').val());
	$('#btnCreateTask').click(function() {
	//	$('#errorDisplay').empty();
	//	$('.updateErrorDisplay').empty();

		jsonData = {
				data: JSON.stringify({
					name: $('#txtName').val(),
					phase: $('#selectPhase').val(),
					estHours: $('#txtEstHours').val(),
					startDate: $('#startDate').val(),
					dueDate: $('#dueDate').val(),
				})
		};
		console.log(jsonData);
		console.log($('#txtEstHours').val());
		$.ajax({
			url: '/task/addTask',
			type: 'POST',
			data: jsonData,
			dataType: 'json',
			success: function(data, status, jqXHR){
				console.log(data);
				if(data.errorList.length == 0) {
					$('#txtName').val('');
					$('#selectPhase').val('');
					$('#txtEstHours').val('');
					$('#startDate').val('');
					$('#dueDate').val('');
				//	retrieveTaskList('Entry saved successfully!');
				} else {
					var msg = "";
					for (var i = 0; i < data.errorList.length; i++)
						msg += data.errorList[i] + "\n";
				//	$('#errorDisplay').html(msg);
				}
			},
			error: function(jqXHR, status, error) {
				
			}
		});
	});
		
});

/**
 * Method used to retrieve list of tweets.
 * @param successMessage - success message to display
 * 		if the transaction is successful.
 */
function retrieveTaskList(successMessage) {
	$("#taskList").empty();
	
	$.ajax({
		url: '/task/display',
		type: 'GET',
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
		      					'<a href="editTask"><i class="material-icons">assignment</i></a>' +
		      					'&nbsp;&nbsp;&nbsp;' +
		      				'<a  href="#"><i class="material-icons">delete</i></a>' + 
		      				'&nbsp;&nbsp;&nbsp;' +
		                '<a href="../taskstoday/"><i class="material-icons">add</i></a>' +
		      			  '</td>' +
		            '</tr>';
					
					$('#taskList').find('tbody').append(formattedTaskList);
					//$('#taskList').append(formattedTaskList);
					
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
		},
		error: function(jqXHR, status, error) {
			
		}
	});
}