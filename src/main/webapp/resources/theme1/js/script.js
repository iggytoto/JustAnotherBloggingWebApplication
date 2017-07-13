/**
 * Created by satyam on 12.07.2017.
 */
// при старте окна добавления записи убираем postID
$(".addClick").click(function () {
    $("input[name = 'id1']").val("");
});



// Отправляет запрос на удаление
$(".crossClick").click(function(){

    var postId = $(this).parent().children(".uid").val();

    $.ajax({
        url: '/post/' + postId,
        type: 'DELETE',
        success: function(result) {

            // if (result == 'del ok') {
            //     alert("Post Deleted")
            // } else {
            //     alert("Not Deleted")
            // }
            alert(result);
        }
    });

});


$(".pencilClick").click(function(){

    var userName = $(this).parent().children(".uname").text();
    var userText = $(this).parent().parent().children(".utext").text();
    var userId = $(this).parent().children(".uid").val();

    $("input[name = 'name1']").val(userName);
    $("textarea[name = 'text1']").val(userText);
    $("input[name = 'id1']").val(userId);


    /*
    downloadUserData(user_id);

    $("#updshade").css("display","block");
    $("#formpage").css("display","block");

    $("#updUserId").val(user_id);
*/

});


// formpage submit
$("form").submit(function(e) {

    // var hiddenId = $(this).parent().children(".uid").val();
    var hiddenId = $("input[name = 'id1']").val();

    if ( hiddenId != "" ) {
    // then update

        $.ajax({
            url: '/post/' + postId,
            type: 'PUT',
            success: function(result) {

                // if (result == 'del ok') {
                //     alert("Post Deleted")
                // } else {
                //     alert("Not Deleted")
                // }
                alert(result);
            }
        });

    }

    /*
    else if ( hiddenId == "" ) {
        // then add
        $.ajax({
            url: '/post/' + postId,
            type: 'POST',
            success: function(result) {

                // if (result == 'del ok') {
                //     alert("Post Deleted")
                // } else {
                //     alert("Not Deleted")
                // }
                alert(result);
            }
        });

    }
*/
});

