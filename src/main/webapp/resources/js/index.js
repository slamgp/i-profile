function createRegistartionHtml() {
    var html = "";
    html = '<table class="registrationTable"> <tr>'
        + '<td>login:</td>   <td><input id="login"    type="text" value=""></td></tr>'
        + '<tr><td>email:</td>   <td><input id="email"    type="text" value=""</td></tr>'
        + '<tr><td>password:</td> <td><input id="password" type="password"  value = ""</td></tr>'
        + '<tr><td class = "buttonTd" colspan="2"><button class = "sentButton" id = "btnSentRegistartion" >sent</button></td></tr></table>';
    return html;
}

function createAutentificationHtml() {
    var html = "";
    html = '<table class="registrationTable"> <tr>'
        + '<tr><td>email:</td>   <td><input id="email"    type="text" value=""</td></tr>'
        + '<tr><td>password:</td> <td><input id="password" type="password"  value = ""</td></tr>'
        + '<tr><td class = "buttonTd" colspan="2"><button class = "sentButton" id = "btnSentAutontification" >sent</button></td></tr></table>';
    return html;
}

function userRegistratedSucces(data) {
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

function addRegistartionClickEvent() {
    $("#btnRegistartion").bind('click', function () {
        createRegistrationForm()
        addRegistrationAction();
    });
}

function addSignInClickEvent() {
    $("#btnSign").bind('click', function () {
        createAutentificationForm()
        addAutentificationAction();
    });
}

function showPopUpRegistration(message) {
    $("#popUpContext").empty();
    $("#popUpContext").html('<div class="popupRegistartion">'+
                            '<p class="popupText">' +
                            message +
                            '</div>)');
    $("#popUpContext").css({ opacity: 0});
    $("#popUpContext").fadeTo(1000, 1).delay(1000).fadeTo(1000, 0);
}

function showPopUpAuthentification(message) {
    $("#popUpContext").empty();
    $("#popUpContext").html('<div class="popupAuthentification">'+
        '<p class="popupText">' +
        message +
        '</div>)');
    $("#popUpContext").css({ opacity: 0});
    $("#popUpContext").fadeTo(1000, 1).delay(1000).fadeTo(1000, 0);
}

function showServiceButton(registration, signIn, signOut) {
    serviseHtml = "";
    if(registration) {
        serviseHtml += '<button class="registrationButton" id = "btnRegistartion"  title="Registaration"> </button>';
    }
    if(signIn) {
        serviseHtml += '<button class="signButton" id = "btnSign"  title="Sign In"> </button>';
    }
    if(signOut) {
        serviseHtml += '<button class="signOutButton" id = "btnSignOut"  title="Sign Out"> </button>';
    }
    $('#serviceContext').empty();
    $('#serviceContext').html(serviseHtml);
    if(registration) {
        addRegistartionClickEvent();
    }
    if(signIn) {
        addSignInClickEvent();
    }
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
            if (data.succes) {
                userRegistratedSucces(data);
                showServiceButton(false, false, true);
            } else {
                if (data.noUser != null) {
                    showPopUpAuthentification("This is user doesn't find in system");
                } else {
                    showPopUpAuthentification("This password isn't correct");
                }
            }
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
            if (data.succes) {
                $("#mainContext").empty();
                showServiceButton(false, true, false);
            } else {
                showPopUpRegistration("user with parameters: " + data.fail + " was created1");
            }
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
    addSignInClickEvent();
    addRegistartionClickEvent();
});
