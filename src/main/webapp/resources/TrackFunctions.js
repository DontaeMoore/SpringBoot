function ToggleCheck() {



if(document.getElementById('remember').checked){
check = true;
}

else {
check = false;
}
console.log("The toggle was flipped, the value is " + check);
window.location = 'updateTrackCheck?check='+check;



 }

 function checkName(name) {

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
  window.location = 'autoSaveTName?name='+name.value;
  }

  }

  function checkCity(city) {

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
    //pass in new value for city
    window.location = 'autoSaveTCity?city='+city.value;
    }

    }

function checkState(state) {

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
    //pass in new value for state
    window.location = 'autoSaveTState?state='+state.value;
    }

    }

function checkZip(zip) {

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
    //pass in new value for zip
    window.location = 'autoSaveTZip?zip='+zip.value;
    }

    }
function checkOwner(owner) {

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
    //pass in new value for owner
    window.location = 'autoSaveTOwner?owner='+owner.value;
    }

    }