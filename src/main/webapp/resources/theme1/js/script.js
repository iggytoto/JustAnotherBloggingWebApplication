/**
 * Created by satyam on 12.07.2017.
 */
// при старте окна на добавление записи - убираем postID и другие данные из полей
$(".addClick").click(function () {

    $("input[name = 'id1']").val("");
    $("input[name = 'name1']").val("");
    $("textarea[name = 'text1']").val("");

});


// Отправляет запрос на удаление
$(".crossClick").click(function () {

    var postId = $(this).parent().children(".uid").val();

    var targetParentDivIndex = $(this).parent().parent().index("div.panel-default");

    $.ajax({
        url: '/post/' + postId,
        type: 'DELETE',
        success: function (result) {

            $("div.container").find("div.panel-default").eq(targetParentDivIndex).remove();
        }
    });

});

// подготовка формы к редактированию
$(".pencilClick").click(function () {

    var userName = $(this).parent().children(".uname").text();
    var userText = $(this).parent().parent().children(".utext").text();
    var userId = $(this).parent().children(".uid").val(); // TODO: у свежесозданных постов нет ИД. А с пустышкой будет отправляться на добавление

    var targetParentDivIndex = $(this).parent().parent().index("div.panel-default");


    $("input[name = 'name1']").val(userName);
    $("textarea[name = 'text1']").val(userText);
    $("input[name = 'id1']").val(userId);

    $("input[name = 'tpdi']").val(targetParentDivIndex);

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

// если айдишник есть, то ИЗМЕНИТЬ Пост
    if (hiddenId != "") {

        var targetParentDivIndex = $("input[name = 'tpdi']").val();

        var postId = hiddenId;

        $.ajax({
            url: '/post/' + postId,
            data: {
                name1: userName,
                text1: userText
            },
            method: 'POST', // PUT не проходит :(
            success: function (result) {

                console.log(result);

                if (String(result) == "postChanged") {

                    $("div.container")
                        .find("div.panel-default")
                        .eq(targetParentDivIndex)
                        .children(".panel-heading")
                        .children("span.uname").text(userName);

                    $("div.container")
                        .find("div.panel-default")
                        .eq(targetParentDivIndex)
                        .children(".panel-body").text(userText);

                    // TODO : нужна пустышка для hiddenId , чтобы не происходило добавления в БД !
                    // или добавлять ИД на основе предыдущего ИД + 1

                } else {

                    alert("Ошибка при изменении поста");
                }
            }
        });

// а если нет айди, то ДОБАВИТЬ Пост
    } else if (hiddenId == "") {

        // вычисляем ХидденИД (uid) на основе предыдущей записи
        // hiddenId = $( "div.panel-default:gt(0)" ).index();
        // var hiddenId = $( "div.panel-default:gt(0)" );


        $.ajax({
            url: '/post/',
            data: {
                name1: userName,
                text1: userText
            },
            type: 'POST',
            success: function (result) {

                if (String(result) == "postAdded") {
                    // $("body > .container > nav").before("<p>111</p>"); // ok
                    $("body > .container").prepend(
                        "<div class='panel panel-default'>\
                            <div class='panel-heading'>\
                                <span>Name : </span><span class='uname'>" + userName + "</span>\
                                ,\
                                <span>Date : </span> 07.07.2017\
                           <button type='button'\
                                   class='btn btn-default btn-md crossClick'\
                                   style='float: right;'\
                            >\
                              <span class='glyphicon glyphicon-remove' aria-hidden='true'></span>\
                          </button>\
            \
                        <button type='button'\
                                class='btn btn-default btn-md pencilClick'\
                                style='float: right;'\
                                data-toggle='modal'\
                                data-target='.bs-example-modal-sm'\
                        >\
                        <span class='glyphicon glyphicon-pencil'\
                               aria-hidden='true'></span>\
                        </button>\
            \
                        <input type='hidden' class='uid' value='" + hiddenId + "' >\
            \
                        <hr style='clear: right; border: 0; margin: 0;'>\
            \
                        </div>\
            \
                        <div class='panel-body utext'>" + userText + "</c:out></div>\
            \
                    </div>\
            ");

                } else {

                    alert("Ошибка при добавлении поста");
                }

            }
        });

        /// объектов на 1 меньше ???
        // var hiddenId = $( "div.panel-default" );
        // var hiddenId = $( "div.container > div" ); // wtf??
        // var hiddenId = $( "div" ); // wtf??
        // console.log(hiddenId);

    }

});

