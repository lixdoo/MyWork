(function($){
	var Login = function() {
		
		function handleKeydown(e){
			if(e.keyCode==13){
			      if(this.id=="form-username"){
			    	  $("#form-password").focus();
			    }
			      else if(this.id=="form-password"){ 
			    	  $(".btn").click();
			    }
			}
	    }
		
		function btnClick(){
			if($("#form-username").val() == ""){
				$("#form-username").addClass('input-error');
	 			$("#form-username").focus();
	 			return false;
	 		}
	 	    else if($("#form-password").val()==""){
	 	    	$("#form-password").addClass('input-error');
	 		    $("#form-password").focus();
	 			return false;		
	 		}else{
	 			userLogin();
	 		}
		}
		
		function userLogin(){
			   $.post("../loginServlet/vailteLogin",{username:$("#form-username").val(),password:$("#form-password").val()},
				  function(jsonData){
					   if(jsonData=='fail'){
						 $("#form-username").focus();
						 return false;
					  }
					  else if(jsonData=='success'){window.location.href="www.baidu.com";}
			   });
		}	
		
	    this.init=function(){
//	    	$("#form-username").addClass('input-error');
//	    	$("#form-password").addClass('input-error');
		    $("#form-username").focus();
		    $.backstretch("assets/img/backgrounds/1.jpg");
			$(".form-bottom div input").on("keydown",handleKeydown);
			$(".btn").on("click",btnClick);
	   };
	};
	
	$(document).ready(function(){
		var loginer = new Login();  
		loginer.init();
	});

})(jQuery) ;







