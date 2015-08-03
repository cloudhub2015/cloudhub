var deleteTask = function(formID) {
			document[formID].action = "delete";
			document[formID].submit();
}