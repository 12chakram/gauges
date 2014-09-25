/**
 * 
 */

     $(document).ready(function() {  
			
			 $(document).on('click', '.toolbar a[data-target]', function(e) {
				e.preventDefault();
				var target = $(this).data('target');
				$('.widget-box.visible').removeClass('visible');//hide others
				$(target).addClass('visible');//show target
			 });
			
										
				$('#login-form').validate({
					errorElement: 'div',
					errorClass: 'help-block',
					focusInvalid: false,
					rules: {
						userName: {
							required: true,
							userName:true
						},
						loginpwd: {
							required: true,
							loginpwd:true
						},
						
					},
			
					messages: {
						userName: {
							required: "Please provide username.",
							userName: "Please provide username."
						},
						loginpwd: {
							required: "Please provide Password.",
							loginpwd: "Please provide Password."
						},
						
					},
			
			
					highlight: function (e) {
						$(e).closest('.form-group').removeClass('has-info').addClass('has-error');
					},
			
					success: function (e) {
						$(e).closest('.form-group').removeClass('has-error');//.addClass('has-info');
						$(e).remove();
					},
			
					errorPlacement: function (error, element) {
						   error.insertAfter(element.parent());
					},
			
					submitHandler: function (form) {
					},
					invalidHandler: function (form) {
					}
				});
				
				$('#retrieve-form').validate({
					errorElement: 'div',
					errorClass: 'help-block',
					focusInvalid: false,
					rules: {
						retrieve_email: {
							required: true,
							email:true
						},
											
					},
			
					messages: {
						retrieve_email: {
							required: "Please provide Email.",
							retrieve_email: "Please provide a valid Email."
						},
											
					},
			
			
					highlight: function (e) {
						$(e).closest('.form-group').removeClass('has-info').addClass('has-error');
					},
			
					success: function (e) {
						$(e).closest('.form-group').removeClass('has-error');//.addClass('has-info');
						$(e).remove();
					},
			
					errorPlacement: function (error, element) {
						   error.insertAfter(element.parent());
					},
			
					submitHandler: function (form) {
					},
					invalidHandler: function (form) {
					}
				});
				
				
				$('#registration-form').validate({
					errorElement: 'div',
					errorClass: 'help-block',
					focusInvalid: false,
					rules: {
						email: {
							required: true,
							email:true
						},
						userName: {
							required: true,
							userName:true
						},
						secpassword: {
							required: true,
							secpassword :true,
							minlength: 5
						},
						cnfpassword: {
							required: true,
							cnfpassword:true,
							minlength: 5,
							equalTo: "#secpassword"
						},
						accept: {
							required: true,
							accept:true
						},
											
					},
			
					messages: {
						email: {
							required: "Please provide Email.",
							email:"Please provide Email."
						},
						userName: {
							required: "Please provide username.",
							userName:"Please provide username."
						},
						secpassword: {
							required: "Please provide password.",
							secpassword:"Please provide password.",
							minlength: "Please specify a secure password."
						},
						cnfpassword: {
							required: "Please reenter password.",
							cnfpassword:"Please reenter password."
						},
						accept: "Please accept our policy"
																	
					},
			
			
					highlight: function (e) {
						$(e).closest('.form-group').removeClass('has-info').addClass('has-error');
					},
			
					success: function (e) {
						$(e).closest('.form-group').removeClass('has-error');//.addClass('has-info');
						$(e).remove();
					},
			
					errorPlacement: function (error, element) {
						   error.insertAfter(element.parent());
					},
			
					submitHandler: function (form) {
					},
					invalidHandler: function (form) {
					}
				});
				
			})
			
		
	