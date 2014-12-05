<?php

/*
 * Following code will delete a data from table
 */

// array for JSON response
$response = array();

// check for required fields
if (!isset($_POST['Id_Server'])&&!isset($_POST['Data'])) {
    $Id_Server= $_POST['Id_Server'];
    $Data= $_POST['Data'];

$Id_Server=12;
$Data=1234;
    // include db connect class
    require_once __DIR__ . '/db_connect.php';

    // connecting to db
    $db = new DB_CONNECT();

    // mysql update row with matched pid
    $result = mysql_query("SELECT `Id_Server`, `Data` FROM `Server` WHERE Id_Server = $Id_Server");

    
     // check if row inserted or not
    if ($result) {
        // successfully updated
        $response["success"] = 1;
        $response["message"] = "Data successfully updated.";
        
        // echoing JSON response
        echo json_encode($response);
    } else {
        
    }
} else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";

    // echoing JSON response
    echo json_encode($response);
}
?>