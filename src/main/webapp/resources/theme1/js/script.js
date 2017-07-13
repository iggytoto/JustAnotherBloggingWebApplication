/**
 * Created by satyam on 12.07.2017.
 */
$(".crossClick").click(function(){

    $.ajax({
        url: '/post/4',
        type: 'DELETE',
        success: function(result) {
            // Do something with the result
            if (result == 'del ok') {
                alert("Post Deleted")
            } else {
                alert("Not Deleted")
            }
        }
    });

});


$(".pencilClick").click(function(){

/*~*/
    // var user_id = $(this).parent().parent().attr('id');
    // var user_id = $("uid").val();
    var user_id = $(this).parent().children(".uid").val();


    alert(user_id);

    // var user_name = $(".panel-heading > span:first-child > span").html;

    /*
    downloadUserData(user_id);

    $("#updshade").css("display","block");
    $("#formpage").css("display","block");

    $("#updUserId").val(user_id);
*/

});

/*
 $("#formpage").submit(function(e) {

if (hidden field is not NULL and (int) id > 0) {
// then update
 $.post("/updateUser", {
 command : "update_user_by_id",
 user_id : user_id
 }).done(function(data) {

 alert(data);
 $("#updshade").click();
 }
 )

} else if ( hidden field IS null || empty ) {

    // then add

}

 });
 */
