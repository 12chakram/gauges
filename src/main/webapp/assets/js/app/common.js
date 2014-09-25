/**
 * 
 */


		
function getOpenIDItem(name) {
	if (name == 'yahoo') {
		$("#openid_identifier").val("https://me.yahoo.com/");
		$("#openIDform").submit();
	}
	if (name == 'google') {
		$("#openid_identifier").val("https://www.google.com/accounts/o8/id");
		$("#openIDform").submit();
	}
}
		
