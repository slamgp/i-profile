function createRegistartionHtml() {
    var html = "";
    html += '<input id="login"    type="text" value="">';
    html += '<input id="email"    type="text" value="">';
    html += '<input id="password" type="password"  value = ""/>';
    html += '<button id = "btnSentRegistartion" >sent</button>'
    return html;
}

function addRegistrationAction() {
    $("#btnSentRegistartion").bind('click', function () {
        divContentRequestPOST($('#login').val(), $('#email').val(), $('#password').val())
    });

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
             addRegistrationAction();
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

$("#btnRegistartion").bind('click', function () {
    createRegistrationForm()
    addRegistrationAction();
});

$(document).ready(function () {

});
