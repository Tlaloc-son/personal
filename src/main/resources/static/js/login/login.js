$( document ).ready(function() {
	$("#divErrors").hide();
	var error = false;
	try {
		error = $.parseJSON($("#hidError").val());
	} catch (e) {
		console.log(e);
	}
	if (error) {
		$("#divErrors").show();
	}
});