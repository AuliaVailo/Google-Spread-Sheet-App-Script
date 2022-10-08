function doPost(request){
  // Open Google Sheet using ID
  var ss = SpreadsheetApp.openById("ISI DENGAN ID SPREADSHEET");
  // Select First Sheet
  var sheet = ss.getSheets()[0];

  var result = {"status": "SUKSES"};
  try{
  
    // Get all Parameters
    var payload = JSON.parse(request.postData.contents);
    var nama = payload.nama;
    var umur = payload.umur;
    
    // Append data on Google Sheet
    sheet.appendRow([nama, umur]);
    result = {"status": "SUCCESS", "nama": nama, "umur": umur};
  }catch(exc){
    // If error occurs, throw exception
    result = {"status": "GAGAL", "message": exc};
  }

  // Return result
  return ContentService
  .createTextOutput(JSON.stringify(result))
  .setMimeType(ContentService.MimeType.JSON);
}
