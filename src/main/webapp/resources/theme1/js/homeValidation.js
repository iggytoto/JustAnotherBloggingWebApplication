/**
 * Created by Iggytoto on 13.07.2017.
 */
/* we should have done this other way... like standart spring validation or something, well this is pretty sux*/
var formNameEntry;
var formTextEntry;
var formSubmitButton;

function onSubmit() {
    if(formNameEntry.value() == ""){
        formNameEntry.style.border = "thick solid #FF0000"
        event.preventDefault();
    }
    else{
        formNameEntry.style.border = "0"
    }

    if(formTextEntry.value() == ""){
        formTextEntry.style.border = "thick solid #FF0000"
        event.preventDefault();
    }
    else{
        formNameEntry.style.border = "0"
    }
}

$( document ).ready(function() {
    formNameEntry = $("input-form-name-input");
    formTextEntry = $("input-form-text-input");
    formSubmitButton = $("input-form-submit");

    formSubmitButton.submit(onSubmit);
});
