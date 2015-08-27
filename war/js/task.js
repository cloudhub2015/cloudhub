/* ------------------------------------------------------------------------------
 * Javascript for creating task (with AJAX)
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [08/07/2015] 0.01 - Jacquelyn Amaya - Function for clicking the button Create Task
 * [08/17/2015] 0.02 - David Ramirez - retrieveTaskList and createTask working
 * [08/18/2015] 0.03 - Jacquelyn Amaya - Function for clicking the buttons Create Task
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
	
	//Delete Tweet
	$(document).on('click', '#tweetList .btnDelete', function(){
		$('#errorDisplay').empty();
		$('.updateErrorDisplay').empty();
		
		//var errorDisplay = '';//TODO: (optional) use jQuery traversals to get the correct updateErrorDisplay div.
		var errorDisplay = $(this).siblings().filter('.updateErrorDisplay');
		
		//var idValue = '';//TODO: use jQuery traversals to get correct id value to be passed in json object.
		var idValue = $(this).siblings().filter('.id').val();

		//var contentValue = '';//TODO: use jQuery traversals to get correct content value to be passed in json object.
		var contentValue = $(this).siblings().filter('.content').val();
		
		//var createdDateValue = '';//TODO: use jQuery traversals to get correct createdDate value to be passed in json object.
		var createdDateValue = $(this).siblings().filter('.createdDate').val();
		
		jsonData = {
				data: JSON.stringify({
					id: idValue,
					content: contentValue,
					createdDate: createdDateValue,
				})
		};
		
		$.ajax({
			url: 'delete',//TODO: Provide proper url to call for deleting a tweet
			type: 'POST',
			data: jsonData,
			dataType: 'json',
			success: function(data, status, jqXHR){
				if(data.errorList.length == 0) {
					retrieveTweetList('Entry deleted successfully!');
				} else {
					var msg = "";
					for (var i = 0; i < data.errorList.length; i++) {
						msg += data.errorList[i] + "\n";
					}
					//TODO: (optional) use the errorDisplay to display the msg string there.
				}
			},
			error: function(jqXHR, status, error) {
				
			}
		});
	});
	
	//Update Tweet
	$(document).on('click', '#tweetList .btnUpdate', function(){
		//TODO: code jQuery code for updating tweet. hint: refer to your code for deleting tweets.
		$('#errorDisplay').empty();
		$('.updateErrorDisplay').empty();
		
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
		              '<td>' +
		              '  <input type="hidden" id="status" />' +
		              '  <label for="status">' + value.taskName + '</label>' +
		              '</td>' +
		              '<td>' + value.phase +
		              '</td>' +
		              '<td><center>' + value.estHours + 'hrs </center></td>' +
		              '<td>' + value.startDate + '</td>' +
		              '<td>' + value.dueDate + '</td>' +
		      		  '<td>' +
		                '<a href="#"><i class="material-icon-action">done</i></a>' +
		      				'&nbsp;&nbsp;&nbsp;' +
		      			'<a href="editTask"><i class="material-icon-action">assignment</i></a>' +
		      				'&nbsp;&nbsp;&nbsp;' +
		      			'<a  href="#"><i class="material-icon-action">delete</i></a>' + 
		      				'&nbsp;&nbsp;&nbsp;' +
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