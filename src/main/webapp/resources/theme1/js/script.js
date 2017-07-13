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
                alert(result);
            }
        });
    }

});

