<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
var id;
$(function(){
var myForm = $('form[name=applicantform]').find('input');
	$('button[id=submit]').click(function(e){
	e.preventDefault();
	$.post({
			url:'api/add',
			data:$('form[name=applicantform]').serialize(),
			success:function(res){
			 id = res.applicant.id;
			 document.getElementById("id").value = id;
				$('#result pre code').text(JSON.stringify(res.applicant));
				$('#result').show();
				$('#editButton').show();
				$('#updateButton').show();
				$('#submitButton').hide();
				$(myForm).prop('disabled', true);				
			}
		})
	});
});

$(function(){
$('button[id=update]').click(function(e){
	e.preventDefault();
	$.post({
			url:'api/update',
			data:$('form[name=applicantform]').serialize(),
			success:function(res){
			 $('#result pre code').text(JSON.stringify(res.applicant));
				$('#result').show();
				$('#editButton').show();
				$('#updateButton').show();
				$('#submitButton').hide();
				$(myForm).prop('disabled', true);				
			}
		})
	});
});

function enableFields(){
var inputs = document.getElementsByTagName('input');
  for (var i = inputs.length, n = 0; n < i; n++) {
        inputs[n].disabled = !inputs[n].disabled;
    }
    var x = document.getElementById("edit");
    x.disabled = true;
}

</script>
<title>Bank Application Form</title>
</head>
<body>
	<p>
		<b>Applicant Details</b>
	</p>
	<form name="applicantform" method="post">
	<input type="hidden" name="id" id="id" />
		<table>
			<tr>
				<td><label>Name: </label></td>
				<td><input type="text" name="name" id="name"></input></td>
			</tr>
			<tr>
				<td><label>Age: </label></td>
				<td><input type="text" name="age"></input></td>
			</tr>
			<tr>
				<td><label>Gender: </label></td>
				<td><input type="text" name="gender"></input></td>
			</tr>
			<tr>
				<td><label>Visa Status: </label></td>
				<td><input type="text" name="visaStatus"></input></td>
			</tr>
			<tr>
				<td><label>Country of Residence: </label></td>
				<td><input type="text" name="country"></input></td>
			</tr>
			<tr>
			<td><div id="submitButton"><button id="submit" type="submit">Submit</button></div></td>
			<td><div id="updateButton" style="display: none;"><button id="update" type="submit">Update</button></div></td>
			<td><div id="editButton" style="display: none;"><button id="edit" type="button" onclick=" return enableFields()">Edit</button></div></td>
			
			</tr>
		</table>
		
		
	</form>

	<div id="result" style="display: none;">
		<hr />
		<h4 style="color: green;">JSON Response From Server</h4>
		<pre style="color: green;">
	    <code></code>
	   </pre>


	</div>
</body>
</html>