$(document).ready(function(){
$('.phone_us').mask('(000) 000-0000');

$('.alphaonly').bind('keyup blur',function(){ 
    var node = $(this);
    node.val(node.val().replace(/[^a-zA-ZşŞıİçÇöÖüÜĞğ]/g,'') ); }
);
function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}
});