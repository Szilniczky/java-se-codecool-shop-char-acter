/**
 * Created by szilniczky on 2017.05.16..
 */

$(function() {
    $('#add-btn').click(function () {
        var productId = $(this).attr("id");
        addToCart(productId);
    });


    var addToCart = function (productId) {
        $.ajax({
            url: "/Id",
            type: "POST",
            dataType: "json",
            data: {
                success: "ok",
                prodId:productId
            },
            error: function (data) {
                console.log("error");
            }
        });
    };
});



