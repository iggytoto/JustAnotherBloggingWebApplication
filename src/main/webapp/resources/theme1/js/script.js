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

    var index = $(this).parent().parent().index("div.panel-default");
    // var found = $("div.container").find("div.panel-default:nth-child(2)").html(); // ok
    // var found = $("div.container").find("div.panel-default:nth-child(2)").remove(); // ok !

    // var found = $("div.container").find("div.panel-default:nth-child(1)").index(); // 2 = 1 , 1 = 0 // ok

    // index++;

    // console.log(index);
    $.ajax({
        url: '/post/' + postId,
        type: 'DELETE',
        success: function (result) {

            $("div.container").find("div.panel-default").eq(index).remove();
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


// Отправка формы
$(".btnSubmit").click(function (e) {

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

                if (String(result) == "postAdded") {
/////////////////////
                    // $("body > .container > nav").before("<p>111</p>"); // ok !
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
            "); // ok also
/////////////////////// hidden field ?
                } else {

                    alert("Ошибка при добавлении поста");
                }

            }
        });

    }

});

