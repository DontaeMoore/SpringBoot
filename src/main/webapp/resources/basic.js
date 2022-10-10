function updatedToggleCheck() {

if(document.getElementById('remember').checked){
check = true;
}

else {
check = false;
}

//use this ajax method instead so we don't have to refresh the page
$.ajax({
    type : "GET",
    url : "updateCheck?check="+check,
    success: function(data){
     console.log("The toggle was flipped, the value is " + check);
    }
});

}

function buttonCheck() {

 $('#btn').click(function() {
                alert("Hello");
});

}

//<script>
//             $(document).ready(function() {
//
//
//             });
//</script>