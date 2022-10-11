function ToggleCheck() {



if(document.getElementById('remember').checked){
check = true;
}

else {
check = false;
}


$.ajax({
          type : "GET",
          url : 'updateTrackCheck?check='+check,
          success: function(data){
           console.log("The toggle was flipped, the value is " + check);
          }
      });



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

  $.ajax({
            type : "GET",
            url : 'autoSaveTName?name='+name.value,
            success: function(data){
             console.log("The toggle was flipped, the value is " + check);
            }
        });
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

    $.ajax({
                type : "GET",
                url : 'autoSaveTCity?city='+city.value,
                success: function(data){
                 console.log("The toggle was flipped, the value is " + check);
                }
            });
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

     $.ajax({
                    type : "GET",
                    url : 'autoSaveTState?state='+state.value,
                    success: function(data){
                     console.log("The toggle was flipped, the value is " + check);
                    }
                });
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

     $.ajax({
                        type : "GET",
                        url : 'autoSaveTZip?zip='+zip.value,
                        success: function(data){
                         console.log("The toggle was flipped, the value is " + check);
                        }
                    });
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

    $.ajax({
                            type : "GET",
                            url : 'autoSaveTOwner?owner='+owner.value,
                            success: function(data){
                             console.log("The toggle was flipped, the value is " + check);
                            }
                        });
    }

    }