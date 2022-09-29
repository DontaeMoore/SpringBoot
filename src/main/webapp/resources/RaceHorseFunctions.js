function ToggleCheck() {
console.log("yo");


if(document.getElementById('remember').checked){
check = true;
}

else {
check = false;
}
console.log("The toggle was flipped, the value is " + check);
window.location = 'updateRHCheck?check='+check;

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
         window.location = 'autoSaveRHName?name='+name.value;
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
         window.location = 'autoSaveRHGender?gender='+gender.value;
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
         window.location = 'autoSaveRHFoal?foal='+foal.value;
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
         console.log("Autosave is on, so we should call the save function for this specific field");

         //pass in new value for link
         window.location = 'autoSaveRHLink?link='+link.value;
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
         window.location = 'autoSaveRHOwner?owner='+owner.value;
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
         window.location = 'autoSaveRHTrainer?trainer='+trainer.value;
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
         window.location = 'autoSaveRHComments?comments='+comments.value;
         }

         }