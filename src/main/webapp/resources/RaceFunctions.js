
//find out what the value of check is and then update it
function ToggleCheck() {

if(document.getElementById('remember').checked){
check = true;
}

else {
check = false;
}
console.log("The toggle was flipped, the value is " + check);
window.location = 'updateCheck?check='+check;


 }

//check value of check, and
 function checkFinish(raceID, finishTime) {

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
 window.location = 'autoSaveFinish?finish='+finishTime.value;
 }

 }

 function checkDistance(raceID, dist) {

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
  //pass in new value for dist
  window.location = 'autoSaveDist?dist='+dist.value;
  }

  }

  function checkDeadline(raceID, dead) {

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
    //pass in new value for dead)
    window.location = 'autoSaveDead?dead='+dead.value;
    }

    }

  function checkTrackID(raceID, trackID) {

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
      //pass in new value for trackID)
      window.location = 'autoSavetrackID?trackID='+trackID.value;
      }

      }

  function checkDate(raceID, date) {

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
        //pass in new value for date)
        window.location = 'autoSaveDate?date='+date.value;
        }

        }

        function checkName(raceID, name) {

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
        console.log(name.value);
        //pass in new value for name)
        window.location = 'autoSaveName?name='+name.value;
        }

        }



