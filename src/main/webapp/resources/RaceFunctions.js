





//find out what the value of check is and then update it
function ToggleCheck() {

if(document.getElementById('remember').checked){
check = true;
}

else {
check = false;
}

$.ajax({
    type : "GET",
    url : "updateCheck?check="+check,
    success: function(data){
     console.log("The toggle was flipped, the value is " + check);
    }
});



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

 //pass in new value for finishLine

 $.ajax({
        type : "GET",
        url : 'autoSaveFinish?finish='+finishTime.value,
        success: function(data){
          console.log("finished");
        }
    });


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

   $.ajax({
       type : "GET",
       url : 'autoSaveDist?dist='+dist.value,
       success: function(data){
         console.log("finished");
       }
   });

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

     $.ajax({
            type : "GET",
            url : 'autoSaveDead?dead='+dead.value,
            success: function(data){
              console.log("finished");
            }
        });

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

       $.ajax({
                  type : "GET",
                  url : 'autoSavetrackID?trackID='+trackID.value,
                  success: function(data){
                    console.log("finished");
                  }
              });

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

         $.ajax({
                     type : "GET",
                     url : 'autoSaveDate?date='+date.value,
                     success: function(data){
                       console.log("finished");
                     }
                 });

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
         $.ajax({
             type : "GET",
             url : 'autoSaveName?name='+name.value,
             success: function(data){
               console.log("finished");
             }
         });

        }

        }

        function sortbyName() {

        $.ajax({
                             type : "GET",
                             url : 'raceNameSort2',
                             success: function(data){
                               console.log(data);

                             }
                         });



        }








