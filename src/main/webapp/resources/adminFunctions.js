function ToggleCheck() {

if(document.getElementById('remember').checked){
check = true;
}

else {
check = false;
}

$.ajax({
    type : "GET",
    url : "updateAdminCheck?check="+check,
    success: function(data){
     console.log("The toggle was flipped, the value is " + check);
    }
});



 }

 function checkUserName(name) {
 console.log("yo " + name.value);

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
             url : 'autoSaveUsername?username='+name.value,
             success: function(data){
              console.log("The toggle was flipped, the value is " + check);
             }
         });
   }

   }

  function checkPassword(password) {
   console.log("yo " + password.value);

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
               url : 'autoSavePassword?password='+password.value,
               success: function(data){
                console.log("The toggle was flipped, the value is " + check);
               }
           });
     }

     }
  function checkRole(role) {
   console.log("yo " + role.value);

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
               url : 'autoSaveRole_ID?role='+role.value,
               success: function(data){
                console.log("The toggle was flipped, the value is " + check);
               }
           });
     }

     }

 function checkStatus(status) {
  console.log("yo " + status.value);

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
              url : 'autoSaveStatus_ID?status='+status.value,
              success: function(data){
               console.log("The toggle was flipped, the value is " + check);
              }
          });
    }

    }