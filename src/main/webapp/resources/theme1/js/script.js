// при старте окна на добавление записи - убираем postID и другие данные из полей
$(".addClick").click(function () {

    $("input[name = 'id1']").val("");
    $("input[name = 'name1']").val("");
    $("textarea[name = 'text1']").val("");

});


// Функция удаления
function deletePost(elm) {

    var postId = $(elm).parent().children(".uid").val();

    var targetParentDivIndex = $(elm).parent().parent().index("div.panel-default");

    $.ajax({
        url: '/post/' + postId,
        type: 'DELETE',
        success: function (result) {
            $("div.container").find("div.panel-default").eq(targetParentDivIndex).remove();
        }
    });
по
}

// кнопкаУдалить лиснер
$(".crossClick").click(function () {

    deletePost($(this));

});


// подготовка формы к редактированию
function updatePost(elm) {

    var userName = $(elm).parent().children(".uname").text();
    var userText = $(elm).parent().parent().children(".utext").text();
    var userId = $(elm).parent().children(".uid").val();

    var targetParentDivIndex = $(elm).parent().parent().index("div.panel-default");


    $("input[name = 'name1']").val(userName);
    $("textarea[name = 'text1']").val(userText);
    $("input[name = 'id1']").val(userId);

    $("input[name = 'tpdi']").val(targetParentDivIndex);

}


// кнопкаАпдейт лиснер
$(".pencilClick").click(function () {

    updatePost($(this));
});


function validateFields() {
    formNameEntry = document.getElementById("recipient-name");
    formTextEntry = document.getElementById("message-text");
    var nameValid = false;
    var textValid = false;

    if (formNameEntry.value == "") {
        formNameEntry.style.border = "thin solid #FF0000";
        formNameEntry.setAttribute("title", "Please enter your not empty name.");
        nameValid = true;
    }
    else {
        formNameEntry.style.border = "none";
        formNameEntry.removeAttribute("title");
        nameValid = false;
    }

    if (formTextEntry.value == "") {
        formTextEntry.style.border = "thin solid #FF0000";
        formTextEntry.setAttribute("title", "Please enter your not empty name.");
        textValid = true;
    }
    else {
        formTextEntry.style.border = "none";
        formTextEntry.removeAttribute("title");
        textValid = false;
    }
    return !nameValid && !textValid;
}


// Отправка формы
$(".btnSubmit").click(function () {
    if (!validateFields()) {
        return;
    }

    var hiddenId = $("input[name = 'id1']").val();

    var userName = $("input[name = 'name1']").val();
    var userText = $("textarea[name = 'text1']").val();

// если айдишника нет, то ДОБАВИТЬ Пост
    if (!hiddenId) {

        $.ajax({
            url: '/post/',
            data: {
                name1: userName,
                text1: userText
            },
            method: 'POST',

            success: function (postId) {

                if (typeof(postId) === "string") {

                    // $("body > .container > nav").before("<p>111</p>"); // ok
                    $("body > .container").prepend(
                        "<div class='panel panel-default'>\
                            <div class='panel-heading'>\
                                <span>Name : </span><span class='uname'>" + userName + "</span>\
                                ,\
                                <span>Date : </span> 07.07.2017"
                        + ""/* pencilClickUpdate */ +
                        +""/* crossClickDelete */ +
                        "\
                              <input type='hidden' class='uid' value='" + postId + "' >\
            \
                        <hr style='clear: right; border: 0; margin: 0;'>\
            \
                        </div>\
            \
                        <div class='panel-body utext'>" + userText + "</c:out></div>\
            \
                    </div>\
            ");

// создаём кнопку апдейт Поста (для свежесозданного элемента)
                    var pencilClickUpdate = $("" +
                        "<button type='button' " +
                        "class='btn btn-default btn-md pencilClick' " +
                        "style='float: right;' " +
                        "data-toggle='modal' " +
                        "data-target='.bs-example-modal-sm' " +
                        ">" +
                        "<span class='glyphicon glyphicon-pencil' aria-hidden='true'></span>" +
                        "</button> ");

// апендим кнопку в дом созданного постБлока
                    $("body > .container > .panel:nth-child(1) > .panel-heading > input[type='hidden']").before(pencilClickUpdate);
// подписываемся после аппенда
                    pencilClickUpdate.on('click',
                        function () {
                            updatePost($(this));
                        }
                    );
//

// создаём кнопку удаления элемента для свежесозданного объекта
                    var crossClickDelete = $("" +
                        "<button type='button' " +
                        "class='btn btn-default btn-md crossClick' " +
                        "style='float: right;'>" +
                        "<span class='glyphicon glyphicon-remove' aria-hidden='true'></span>" +
                        "</button> ");

// апендимся
                    $("body > .container > .panel:nth-child(1) > .panel-heading > .pencilClick").before(crossClickDelete);

// подписываемся после аппенда
                    crossClickDelete.on('click',
                        function () {
                            deletePost($(this));
                        }
                    );

                } else {

                    alert("Ошибка при добавлении поста");
                }

            }
        }); // ajax end

// а если айди есть, то ИЗМЕНИТЬ Пост
    } else if (hiddenId) {

        var targetParentDivIndex = $("input[name = 'tpdi']").val();

        $.ajax({
            url: '/post/' + hiddenId,   // postId
            data: {
                name1: userName,
                text1: userText
            },
            method: 'POST',
            success: function (result) {
                // добавляем ИМЯ ПОЛЬЗОВАТЕЛЯ в дом
                $("div.container")
                    .find("div.panel-default")
                    .eq(targetParentDivIndex)
                    .children(".panel-heading")
                    .children("span.uname").text(userName);

                // добавляем ТЕКС Поста в дом
                $("div.container")
                    .find("div.panel-default")
                    .eq(targetParentDivIndex)
                    .children(".panel-body").text(userText);
            }
        });

    }

});

