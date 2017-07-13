/**
 * Created by satyam on 12.07.2017.
 */
// при старте окна на добавление записи - убираем postID и другие данные из полей
$(".addClick").click(function () {

    $("input[name = 'id1']").val("");
    $("input[name = 'name1']").val("");
    $("input[name = 'text1']").val("");

});


// Отправляет запрос на удаление
$(".crossClick").click(function () {

    var postId = $(this).parent().children(".uid").val();

    $.ajax({
        url: '/post/' + postId,
        type: 'DELETE',
        success: function (result) {

            alert(result);
        }
    });

});

// подготовка формы к редактированию
$(".pencilClick").click(function () {

    var userName = $(this).parent().children(".uname").text();
    var userText = $(this).parent().parent().children(".utext").text();
    var userId = $(this).parent().children(".uid").val();

    $("input[name = 'name1']").val(userName);
    $("textarea[name = 'text1']").val(userText);
    $("input[name = 'id1']").val(userId);

});

// formpage submit
// $("form").submit(function(e) {

function validateFields() {
    formNameEntry = document.getElementById("recipient-name");
    formTextEntry = document.getElementById("message-text");
    var nameValid = false;
    var textValid = false;

    if (formNameEntry.value == "") {
        formNameEntry.style.border = "thin solid #FF0000"
        formNameEntry.setAttribute("title", "Please enter your not empty name.");
        nameValid = true;
    }
    else{
        formNameEntry.style.border = "none"
        formNameEntry.removeAttribute("title");
        nameValid = false;
    }

    if (formTextEntry.value == "") {
        formTextEntry.style.border = "thin solid #FF0000"
        formTextEntry.setAttribute("title", "Please enter your not empty name.")
        textValid = true;
    }
    else {
        formTextEntry.style.border = "none"
        formTextEntry.removeAttribute("title");
        textValid = false;
    }
    return !nameValid && !textValid;
}


// Отправка формы

$(".btnSubmit").click(function (e) {
    if (!validateFields()) {
        return;
    }

    var hiddenId = $("input[name = 'id1']").val();

    var userName = $("input[name = 'name1']").val();
    var userText = $("textarea[name = 'text1']").val();

// если айдишник есть, то изменить Пост
    if (hiddenId != "") {

        var postId = hiddenId;

        $.ajax({
            url: '/post/' + postId,
            data: {
                name1: userName,
                text1: userText
            },
            method: 'POST', // PUT не проходит :(
            success: function (result) {
                alert(result);
            }
        });
// а если нет айди, то добавить Пост
    } else if (hiddenId == "") {

        $.ajax({
            url: '/post/',
            data: {
                name1: userName,
                text1: userText
            },
            type: 'POST',
            success: function (result) {
                alert(result);
                /*
                 if (result == '1') {

                 alert("Запись добавлена");

                 } else {

                 alert("Ошибка при добавлении записи");

                 }
                 */

            }
        });
    }

});

