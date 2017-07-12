/**
 * Created by satyam on 12.07.2017.
 */
$("#crossClick").click(function(){

    $.ajax({
        url: '/',
        type: 'DELETE',
        success: function(result) {
            // Do something with the result
            alert(result);
        }
    });

});