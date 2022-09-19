
//find out what the value of check is and then update it
function ToggleCheck() {

if(document.getElementById('remember').checked){
check = true;
}

else {
check = false;
}
console.log("The toggle was flipped, the value is " + check);
window.location = '/updateCheck?check='+check;


 }

//check value of check, and
 function check(raceID, finishTime) {

 if(document.getElementById('remember').checked){
 check = true;
 }

 else {
 check = false;
 }


 if(check == false){
       console.log("Autosave is not on, so nothing happens");

 }
 else {
 console.log("Autosave is on, so we should call the save function for this specific field");
 //pass in new value for finishLine
 window.location = '/autoSaveFinish?finish='+finishTime.value;
 }

 }


