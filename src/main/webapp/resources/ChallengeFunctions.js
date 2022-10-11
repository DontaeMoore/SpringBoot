function ToggleCheck() {



if(document.getElementById('remember').checked){
check = true;
}

else {
check = false;
}
console.log("The toggle was flipped, the value is " + check);

$.ajax({
    type : "GET",
    url : 'updateChallengeCheck?check='+check,
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
 //pass in new value for name

 $.ajax({
     type : "GET",
     url : 'autoSaveCName?name='+name.value,
     success: function(data){
      console.log("The toggle was flipped, the value is " + check);
     }
 });
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

  $.ajax({
      type : "GET",
      url : 'autoSaveCDesc?desc='+desc.value,
      success: function(data){
       console.log("The toggle was flipped, the value is " + check);
      }
  });
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

    $.ajax({
          type : "GET",
          url : 'autoSaveCFirst?first='+first.value,
          success: function(data){
           console.log("The toggle was flipped, the value is " + check);
          }
      });

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

       $.ajax({
                type : "GET",
                url : 'autoSaveCSecond?second='+second.value,
                success: function(data){
                 console.log("The toggle was flipped, the value is " + check);
                }
            });
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

         $.ajax({
                        type : "GET",
                        url : 'autoSaveCThird?third='+third.value,
                        success: function(data){
                         console.log("The toggle was flipped, the value is " + check);
                        }
                    });
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

            $.ajax({
                                  type : "GET",
                                  url : 'autoSaveCFourth?fourth='+fourth.value,
                                  success: function(data){
                                   console.log("The toggle was flipped, the value is " + check);
                                  }
                              });
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

              $.ajax({
                                              type : "GET",
                                              url : 'autoSaveCStatus?status='+status.value,
                                              success: function(data){
                                               console.log("The toggle was flipped, the value is " + check);
                                              }
                                          });
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