// Wait for PhoneGap to load
document.addEventListener("deviceready", onDeviceReady, false);

// Populate the database 
function populateDB(tx) {



//   tx.executeSql('DROP TABLE IF EXISTS DEMO');
   tx.executeSql('CREATE TABLE IF NOT EXISTS DEMO (id unique, data)');
/*
   tx.executeSql('INSERT INTO DEMO (id, data) VALUES (1, "First row")');
   tx.executeSql('INSERT INTO DEMO (id, data) VALUES (2, "Second row")');
   tx.executeSql('INSERT INTO DEMO (id, data) VALUES (3, "Tercera fila")');
   tx.executeSql('INSERT INTO DEMO (id, data) VALUES (4, "No entiendo")');
   tx.executeSql('INSERT INTO DEMO (id, data) VALUES (5, "Carlos Gallego")');
*/
}


// Query the database
function queryDB(tx) {
	tx.executeSql('SELECT * FROM DEMO', [], querySuccess, errorCB);
}


// Query the success callback
function querySuccess(tx, results) {
	var len = results.rows.length;
	console.log("DEMO table: " + len + " rows found.");
	for (var i=0; i<len; i++)
	  {
		console.log("Row = " + i + " ID = " + results.rows.item(i).id + " Data =  " + results.rows.item(i).data);
	  }

/*
	var  a = ['a','b','c',12,28];
	var len = a.length;
	$('#resultado').append(len + " results found :<br>");
	for (var i=0; i<len; i++){
		$('#resultado').append(a[i]+'<br>');
	}
*/

	$('#resultado').append("Resultado : " + len + " registros :<br>");
	for (var i=0; i<len; i++){
    	$('#resultado').append("Row = " + i + " ID = " + results.rows.item(i).id + " Data =  " + results.rows.item(i).data+'<br>');
   	}

}


// Transaction error callback
function errorCB(err) {
	console.log("Error processing SQL: "+err.code);
}


// Transaction success callback
function successCB() {
	var db = window.openDatabase("Database", "1.0", "PhoneGap Demo", 200000);
	db.transaction(queryDB, errorCB);
}


// PhoneGap is ready
function onDeviceReady() {
	var db = window.openDatabase("Database", "1.0", "PhoneGap Demo", 200000);
	db.transaction(populateDB, errorCB, successCB);
}


function msg()
{
	var db = window.openDatabase("Database", "1.0", "PhoneGap Demo", 200000);
	db.transaction(queryDB2, errorCB);
}


// Query the database
function queryDB2(tx) {
	tx.executeSql('SELECT * FROM DEMO', [], querySuccess2, errorCB);
}


// Query the success callback
function querySuccess2(tx, results) {
	var len = results.rows.length;
    document.getElementById("resultado").innerHTML="";
	$('#resultado').append("Resultado : " + len + " registros :<br>");
	for (var i=0; i<len; i++){
    	$('#resultado').append("Row = " + i + " ID = " + results.rows.item(i).id + " Data =  " + results.rows.item(i).data+'<br>');
   	}
}
