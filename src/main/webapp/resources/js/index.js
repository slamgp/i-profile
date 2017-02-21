function createRegistartionHtml() {
    var html = "";
    html = '<table class="registrationTable"> <tr>'
        +'<td>login:</td>   <td><input id="login"    type="text" value=""></td></tr>'
        +'<tr><td>email:</td>   <td><input id="email"    type="text" value=""</td></tr>'
        +'<tr><td>password:</td> <td><input id="password" type="password"  value = ""</td></tr>'
        +'<tr><td class = "buttonTd" colspan="2"><button class = "sentButton" id = "btnSentRegistartion" >sent</button></td></tr></table>';
    return html;
}

function createAutentificationHtml() {
    var html = "";
    html = '<table class="registrationTable"> <tr>'
        +'<tr><td>email:</td>   <td><input id="email"    type="text" value=""</td></tr>'
        +'<tr><td>password:</td> <td><input id="password" type="password"  value = ""</td></tr>'
        +'<tr><td class = "buttonTd" colspan="2"><button class = "sentButton" id = "btnSentAutontification" >sent</button></td></tr></table>';
    return html;
}

function userWasRegistrated(data){
    $("#mainContext").html('<p> hello ' + data.login);
    $("#serviceContext").empty();
    $("#serviceContext").html('<button class="signOutButton" id = "btnSignOut"  title="Sign out"> </button>');
}

function addRegistrationAction() {
    $("#btnSentRegistartion").bind('click', function () {
        registrationRequestPOST($('#login').val(), $('#email').val(), $('#password').val())
    });

}

function addAutentificationAction() {
    $("#btnSentAutontification").bind('click', function () {
        autentificationRequestPOST($('#email').val(), $('#password').val())
    });

}

function autentificationRequestPOST(email, password) {
    $.ajax({
        url: 'authentication',
        type: 'POST',
        data: JSON.stringify({"email": email, "password": password}),
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (data, textStatus) {
            if(data.succes) {
                $("#mainContext").empty();
                $("#btnSign").hide();
                userWasRegistrated();
            } else {
                $("#mainContext").empty();
                if (data.noUser != null) {
                    $("#mainContext").html("<p> This is user doesn't find in system");
                } else {
                    $("#mainContext").html("<p> This password isn't correct");
                }
            }
            addRegistrationAction();
        },
        error: function (e) {
            console.log("ERROR: ", e);
        }
    });
}


function registrationRequestPOST(login, email, password) {
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
                $("#btnRegistartion").hide();
            } else {
                $("#mainContext").empty();
                if (data.email != null) {
                    msgStr = "<p> user with mail: " + data.email + " was created letter!";
                    if(data.login != null) {
                        msgStr += "<p> user with login: " + data.login + " was created letter!";
                    }
                    $("#mainContext").html(createRegistartionHtml() + msgStr);
                } else {
                    if(data.login != null) {
                        $("#mainContext").html(createRegistartionHtml() + "<p> user with login: " + data.login + " was created letter!");
                    }
                }
            }
             addRegistrationAction();
        },
        error: function (e) {
            console.log("ERROR: ", e);
        }
    });
}

function createAutentificationForm() {
    $("#mainContext").empty();
    $("#mainContext").html(createAutentificationHtml());

}

function createRegistrationForm() {
    $("#mainContext").empty();
    $("#mainContext").html(createRegistartionHtml());

}

$("#btnRegistartion").bind('click', function () {
    createRegistrationForm()
    addRegistrationAction();
});

$("#btnSign").bind('click', function () {
    createAutentificationForm()
    addAutentificationAction();
});

function sentsCurrentUserRequestGet() {
    $.ajax({
        url: 'userRequest',
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (data, textStatus) {
            addRegistrationAction();
        },
        error: function (e) {
            console.log("ERROR: ", e);
        }
    });
}

$(document).ready(function () {
    sentsCurrentUserRequestGet();
});
