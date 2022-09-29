function ToggleCheck() {



if(document.getElementById('remember').checked){
check = true;
}

else {
check = false;
}
console.log("The toggle was flipped, the value is " + check);
window.location = 'updateChallengeCheck?check='+check;



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
 //pass in new value for name
 window.location = 'autoSaveCName?name='+name.value;
 }

 }

 function checkDesc(desc) {

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
  //pass in new value for name
  window.location = 'autoSaveCDesc?desc='+desc.value;
  }

  }
  function checkFirst(first) {

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
    //pass in new value for name
    window.location = 'autoSaveCFirst?first='+first.value;
    }

    }
    function checkSecond(second) {

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
      //pass in new value for name
      window.location = 'autoSaveCSecond?second='+second.value;
      }

      }
      function checkThird(third) {

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
        //pass in new value for name
        window.location = 'autoSaveCThird?third='+third.value;
        }

        }
        function checkFourth(fourth) {

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
          //pass in new value for name
          window.location = 'autoSaveCFourth?fourth='+fourth.value;
          }

          }
          function checkStatus(status) {

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
            //pass in new value for name
            window.location = 'autoSaveCStatus?status='+status.value;
            }

            }
            function checkDate(date) {

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
              //pass in new value for name
              window.location = 'autoSaveCDate?date='+date.value;
              }

              }