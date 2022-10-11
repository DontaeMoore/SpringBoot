function ToggleCheck() {
console.log("yo");


if(document.getElementById('remember').checked){
check = true;
}

else {
check = false;
}
console.log("The toggle was flipped, the value is " + check);

$.ajax({
          type : "GET",
          url : 'updateRHCheck?check='+check,
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

         //pass in new value for name)

         $.ajax({
                   type : "GET",
                   url : 'autoSaveRHName?name='+name.value,
                   success: function(data){
                    console.log("The toggle was flipped, the value is " + check);
                   }
               });
         }

         }
 function checkGender(gender) {

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

         //pass in new value for name)

         $.ajax({
                            type : "GET",
                            url : 'autoSaveRHGender?gender='+gender.value,
                            success: function(data){
                             console.log("The toggle was flipped, the value is " + check);
                            }
                        });
         }

         }
function checkFoal(foal) {

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

         //pass in new value for foal

         $.ajax({
                                     type : "GET",
                                     url : 'autoSaveRHFoal?foal='+foal.value,
                                     success: function(data){
                                      console.log("The toggle was flipped, the value is " + check);
                                     }
                                 });
         }

         }
function checkLink(link) {

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
         console.log("Autosave is on, so we should call the save function for this specific field" + link.value);

         //pass in new value for link

          $.ajax({
                                              type : "GET",
                                              url : 'autoSaveRHLink?link='+link.value,
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
                                                       url : 'autoSaveRHOwner?owner='+owner.value,
                                                       success: function(data){
                                                        console.log("The toggle was flipped, the value is " + check);
                                                       }
                                                   });
         }

         }
function checkTrainer(trainer) {

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

         //pass in new value for trainer

          $.ajax({
                                                                type : "GET",
                                                                url : 'autoSaveRHTrainer?trainer='+trainer.value,
                                                                success: function(data){
                                                                 console.log("The toggle was flipped, the value is " + check);
                                                                }
                                                            });
         }

         }
function checkComments(comments) {

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

         //pass in new value for comments

           $.ajax({
                                                                         type : "GET",
                                                                         url : 'autoSaveRHComments?comments='+comments.value,
                                                                         success: function(data){
                                                                          console.log("The toggle was flipped, the value is " + check);
                                                                         }
                                                                     });
         }

         }