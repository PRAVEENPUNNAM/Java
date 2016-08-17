<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("button").click(function(){
	$.ajax({
        url: "http://localhost:4040/poc_task/Demo",
		 async: true,
        cache: false,
        type:"POST",
       
              error: function(msg) { alert(msg); },
             
              success: function(result){
                  $("#d").html(result);
              }

    }); });});
</script>
</head>
<body>

<button>Send an HTTP POST request to a page and get the result back</button>
<div id="d"></div>
</body>
</html>