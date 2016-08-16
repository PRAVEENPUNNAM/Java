<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<select name="country" class="countries" id="country">
<option value="">Select Country</option>
</select>
<select name="state" class="states" id="state">
<option value="">Select State</option>
</select>


<script>
$(document).ready(function(){
        $.ajax({
            url: '/DynamicDrop/Test?action=country',
            dataType: 'json',
            type: 'GET',
            success: function(data) {
            	
                $('#state').empty(); // clear the current elements in select box
                for (var index in data) {
                	
                	var countryName   =		 data[index].country;
					var id 			  = 	 data[index].country_id;
					$('#country').append($('<option>', {
					    value: id,
					    text: countryName,
					    id:id
					}));
   			     }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(errorThrown);
            }
        });
});
</script>

<script>
$("#country").change(function() {
	var val=document.getElementById("country").value;
	 $.ajax({
         url: '/DynamicDrop/Test?action=state&value='+val,
         dataType: 'json',
         type: 'GET',
         success: function(data) {
         	
             $('#state').empty(); // clear the current elements in select box
             for (var index in data) {
             	
             	var stateName=data[index].State;
					var id=data[index].state_id;
					$('#state').append($('<option>', {
					    value: id,
					    text: stateName,
					    id:id
					}));
			     console.log(stateName +'   '+id);}
         },
         error: function(jqXHR, textStatus, errorThrown) {
             alert(errorThrown);
         }
     });
	
	
	
});


</script>


</body>
</html>