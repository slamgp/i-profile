function divContentRequestGET() {
    $.ajax({
        url: 'registration',
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (data, textStatus) {
            alert("success");
            alert("data " + data);
            $("#mainContext").html(data.name);
        },
        error: function (e) {
            console.log("ERROR: ", e);
            alert("error");
        }
    });
}

$("#btnSignIn").bind('click', function () {
    divContentRequestGET()
});

$(document).ready(function () {

});
