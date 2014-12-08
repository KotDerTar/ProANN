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
    $result = mysql_query("DELETE FROM Server WHERE Id_Server = $Id_Server")&&mysql_query("DELETE FROM Users WHERE Id_Server = $Id_Server");
    
    // check if row deleted or not
    if (mysql_affected_rows() > 0) {
        // successfully updated
        $response["success"] = 1;
        $response["message"] = "Data successfully deleted";

        // echoing JSON response
        echo json_encode($response);
    } else {
        // no product found
        $response["success"] = 0;
        $response["message"] = "Data not found";

        // echo no users JSON
        echo json_encode($response);
    }
} else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";

    // echoing JSON response
    echo json_encode($response);
}
?>