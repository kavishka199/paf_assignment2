$(document).ready(function()
{
	if ($("#alertSuccess").text().trim() == "")
	 {
	 $("#alertSuccess").hide();
	 }
	 $("#alertError").hide();
});



 // SAVE ============================================
   
$(document).on("click", "#btnSave", function(event)
	{
		
		// Clear alerts---------------------
		
		 $("#alertSuccess").text("");
		 $("#alertSuccess").hide();
		 $("#alertError").text("");
		 $("#alertError").hide();
		 
		// Form validation-------------------
	
		var status = validateItemForm();
		if (status != true)
		
		  {
			 $("#alertError").text(status);
			 $("#alertError").show();
			 return;
		   }
	
		
	var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT";
	
	$.ajax( 
			{ 
				 url : "interruptionsAPI", 
				 type : type, 
				 data : $("#formItem").serialize(), 
				 dataType : "text", 
				 complete : function(response, status) 
			 { 
				 onItemSaveComplete(response.responseText, status); 
			 } 
		});
		
	});
	
	
	
	//itemssavecomplefunction
	

	function onItemSaveComplete(response, status) 
	{ 
	  if (status == "success") 
	   { 
				 var resultSet = JSON.parse(response); 
				 
				 if (resultSet.status.trim() == "success") 
				 
				 { 
					 $("#alertSuccess").text("Successfully saved."); 
					 $("#alertSuccess").show(); 
					 $("#divItemsGrid").html(resultSet.data); 
					 
				 } else if (resultSet.status.trim() == "error") 
				 
				 { 
					 $("#alertError").text(resultSet.data); 
					 $("#alertError").show();
					  
				 } 
		 
		 } else if (status == "error") 
		 
		 { 
			 $("#alertError").text("Error while saving."); 
			 $("#alertError").show(); 
			 
		 } else
		 
		 { 
			 $("#alertError").text("Unknown error while saving.."); 
			 $("#alertError").show(); 
			 
		 } 
		
	
		 $("#hidItemIDSave").val(""); 
		 $("#formItem")[0].reset(); 
	}
	

	
	
// update
	
	$(document).on("click", ".btnUpdate", function(event) 
	{ 
		 $("#hidItemIDSave").val($(this).closest("tr").find('td:eq(0)').text()); 
		 
		 $("#ID").val($(this).closest("tr").find('td:eq(0)').text());
		 $("#Name").val($(this).closest("tr").find('td:eq(1)').text()); 
		 $("#Date").val($(this).closest("tr").find('td:eq(2)').text()); 
		 $("#Add").val($(this).closest("tr").find('td:eq(3)').text()); 
		  
	});
	
	
	
//delete
	
$(document).on("click", ".btnRemove", function(event) 
	{ 
		 $.ajax( 
			 { 
					 url : "interruptionsAPI", 
					 type : "DELETE", 
					 data : "id=" + $(this).data("id"),
					 dataType : "text", 
					 complete : function(response, status) 
				 { 
			     onItemDeleteComplete(response.responseText, status); 
			     } 
		 }); 
	});
	


//deletecompletion

function onItemDeleteComplete(response, status) 
{ 
	  if (status == "success") 
	 { 
		 var resultSet = JSON.parse(response); 
		 
			 if (resultSet.status.trim() == "success") 
				 { 
					 $("#alertSuccess").text("Successfully deleted."); 
					 $("#alertSuccess").show(); 
					 
					 $("#divItemsGrid").html(resultSet.data); 
			 } else if (resultSet.status.trim() == "error") 
				 
			 { 
				 $("#alertError").text(resultSet.data); 
				 $("#alertError").show(); 
			 } 
			 
	} else if (status == "error") 
			 
	{ 
	     $("#alertError").text("Error while deleting."); 
		 $("#alertError").show(); 
	} else
			 
	 { 
	     $("#alertError").text("Unknown error while deleting.."); 
		 $("#alertError").show(); 
	 } 
		
		
	}	
		
	// CLIENT-MODEL================================================================
	
	function validateItemForm()
	{
	
	// CODE
	
	if ($("#ID").val().trim() == "")
	 {
		 return "Insert ID.";
	 }
	// NAME
	
	if ($("#Name").val().trim() == "")
	 {
	 	return "Insert  Name.";
	 }
	 
	 
	if ($("#Date").val().trim() == "")
	 {
	 	return "Insert  Date.";
	 }
	 
	if ($("#Add").val().trim() == "")
	 {
	 	return "Insert  Add.";
	 }
	
	
	return true;
	


}	

