/* ------------------------------------------------------------------------------
 * Javascript for creating task (with AJAX)
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [08/07/2015] 0.01 - Jacquelyn Amaya - Function for clicking the button Create Task
 * [08/17/2015] 0.02 - David Ramirez - retrieveTaskList and createTask working
 * [08/27/2015] 0.03 - Jacquelyn Amaya - Function for clicking the button Delete Task
 * 
 * --------------------------------------------------------------------------- */
$(function() {
	retrieveTaskList();
	$('#btnCreateTask').click(function() {

		jsonData = {
				data: JSON.stringify({
					name: $('#txtName').val(),
					phase: $('#selectPhase').val(),
					estHours: $('#txtEstHours').val(),
					startDate: $('#startDate').val(),
					dueDate: $('#dueDate').val(),
				})
		};
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
				} else {
					var msg = "";
					for (var i = 0; i < data.errorList.length; i++)
						msg += data.errorList[i] + "\n";
				}
			},
			error: function(jqXHR, status, error) {
				
			}
		});
	});
	
	/**
	 * Function to delete a task
	 * finds the table which has an id 'tasks'
	 */
	$(document).on('click', '#tasks .btnDelete', function(){
		
		var idValue = $(this).parent().siblings().filter('.id').val();
		
		jsonData = {
				data: JSON.stringify({
					id: idValue
				})
		};
		
		$.ajax({
			url: 'deleteTask',
			type: 'POST',
			data: jsonData,
			dataType: 'json',
			success: function(data, status, jqXHR){
				if(data.errorList.length == 0) {
					retrieveTaskList('Task deleted successfully!');
				} else {
					var msg = "";
					for (var i = 0; i < data.errorList.length; i++) {
						msg += data.errorList[i] + "\n";
					}
					alert(msg);
				}
			},
			error: function(jqXHR, status, error) {
				
			}
		});
	});
	
	//Update Tweet
	$(document).on('click', '#tasks .btnEdit', function(){
		
		var errorDisplay = $(this).siblings().filter('.updateErrorDisplay');
		var idValue = $(this).siblings().filter('.id').val();
		var contentValue = $(this).siblings().filter('.content').val();
		var createdDateValue = $(this).siblings().filter('.createdDate').val();
		
		jsonData = {
				data: JSON.stringify({
					id: idValue,
					content: contentValue,
					createdDate: createdDateValue,
				})
		};
		
		$.ajax({
			url: 'update',
			type: 'POST',
			data: jsonData,
			dataType: 'json',
			success: function(data, status, jqXHR){
				if(data.errorList.length == 0) {
					retrieveTweetList('Entry updated successfully!');
				} else {
					var msg = "";
					for (var i = 0; i < data.errorList.length; i++)
						msg += data.errorList[i] + "\n";
					errorDisplay.html(msg);
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
		              '<input type="hidden" class="id" name="id" value="' + value.id + '"/>' +
		              '<td  class="taskName">' +
		              '  <label for="status">' + value.taskName + '</label>' +
		              '</td>' +
		              '<td>' + value.phase +
		              '</td>' +
		              '<td><center>' + value.estHours + 'hrs </center></td>' +
		              '<td>' + value.startDate + '</td>' +
		              '<td>' + value.dueDate + '</td>' +
		      		  '<td>' +
		                '<a href="" class="btnDone"><i class="material-icon-action">done</i></a>' +
		      				'&nbsp;&nbsp;&nbsp;' +
		      			'<a href="" class="btnEdit"><i class="material-icon-action">assignment</i></a>' +
		      				'&nbsp;&nbsp;&nbsp;' +
		      			'<a  href="" class="btnDelete"><i class="material-icon-action">delete</i></a>' + 
		      				'&nbsp;&nbsp;&nbsp;' +
		              '</td>' +
		            '</tr>';
					
					//$('#taskList').append(formattedTaskList);
					
				});
				
				
				if (formattedTaskList == "") {
					formattedTaskList = "<div>Add tasks! :)</div>";
				}
				else{
					$('#tasks').find('tbody').append(formattedTaskList);
				}
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