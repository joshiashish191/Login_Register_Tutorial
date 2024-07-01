<?php
	$servername = "localhost";
	$username = "root";
	$password = "";
	$dbname = "mydatabase";
	
	// Create connection
	$conn = new mysqli($servername, $username, $password, $dbname);
    if (!$conn)
        echo "connection error: ". mysqli_connect_error();
?>