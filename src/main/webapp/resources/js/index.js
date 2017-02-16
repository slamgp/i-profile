function createRegistartionHtml() {
    var html = "";
    html += '<input id="login"    type="text" value="">';
    html += '<input id="email"    type="text" value="">';
    html += '<input id="password" type="password"  value = ""/>';
    html += '<button id = "btnRegistration">sent</button>'
    return html;
}

function divContentRequestPOST(login, email, password) {
    $.ajax({
        url: 'userregistration',
        type: 'POST',
        data: JSON.stringify({"login": login, "email": email, "password": password}),
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (data, textStatus) {
            if(data.succes) {
                $("#mainContext").empty();
                $("#mainContext").html(createRegistartionHtml() + "<p> count users = " + data.count);
            } else {
                $("#mainContext").empty();
                $("#mainContext").html(createRegistartionHtml() + "<p> this user was created leter");
            }
            $("#btnRegistration").bind('click', function () {
                divContentRequestPOST($('#login').val(), $('#email').val(), $('#password').val())
            });
        },
        error: function (e) {
            console.log("ERROR: ", e);
        }
    });
}

function createRegistrationForm() {
    $("#mainContext").empty();
    $("#mainContext").html(createRegistartionHtml());

}

$("#btnSignIn").bind('click', function () {
    createRegistrationForm()
    $("#btnRegistration").bind('click', function () {
        divContentRequestPOST($('#login').val(), $('#email').val(), $('#password').val())
    });
});

$(document).ready(function () {

});
