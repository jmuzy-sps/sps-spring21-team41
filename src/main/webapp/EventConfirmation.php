<html>
<head>
<title>Event Confirmation/title>
</head>
<h1>Confirmation Page of Customer Info</h1>

<p>Your Event was created! 

<p>Below is a summary of the information you provided.<br><br>  
<?php
echo 'First Name: ' . $_POST ["type"] . '<br>';
echo 'Last Name: ' . $_POST ["date"] . '<br>';
echo 'Email Address: ' . $_POST ["address"] . '<br>';
echo 'Email Address: ' . $_POST ["state"] . '<br>';
echo 'Email Address: ' . $_POST ["zip"] . '<br>';
echo 'Email Address: ' . $_POST ["price"] . '<br>';
echo 'Telephone Number: ' . $_POST ["description"];
?>
