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

function userAuthenticationSucces(data) {
    $("#mainContext").empty();
    $("#serviceContext").empty();
    $("#userNameLable").text(data.login);
    $("#serviceContext").html('<button class="signOutButton" id = "btnSignOut"  title="Sign out"> </button>');
    addLogOutAction();
}

function userAuthenticationFail(data) {
    $("#mainContext").empty();
    $("#serviceContext").empty();
    $("#userNameLable").text("");
    showServiceButton(true, true, false);
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

function addLogOutAction() {
    $("#btnSignOut").bind('click', function () {
        logOutRequestGET();
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
    $("#popUpContext").html('<div class="popupRegistartion">' +
        '<p class="popupText">' +
        message +
        '</div>)');
    $("#popUpContext").css({opacity: 0});
    $("#popUpContext").fadeTo(500, 1).delay(2000).fadeTo(500, 0);
}

function showPopUpAuthentification(message) {
    $("#popUpContext").empty();
    $("#popUpContext").html('<div class="popupAuthentification">' +
        '<p class="popupText">' +
        message +
        '</div>)');
    $("#popUpContext").css({opacity: 0});
    $("#popUpContext").fadeTo(500, 1).delay(2000).fadeTo(500, 0);
}

function showServiceButton(registration, signIn, signOut) {
    serviseHtml = "";
    if (registration) {
        serviseHtml += '<button class="registrationButton" id = "btnRegistartion"  title="Registaration"> </button>';
    }
    if (signIn) {
        serviseHtml += '<button class="signButton" id = "btnSign"  title="Sign In"> </button>';
    }
    if (signOut) {
        serviseHtml += '<button class="signOutButton" id = "btnSignOut"  title="Sign Out"> </button>';
    }
    $('#serviceContext').empty();
    $('#serviceContext').html(serviseHtml);
    if (registration) {
        addRegistartionClickEvent();
    }
    if (signIn) {
        addSignInClickEvent();
    }
    if (signOut) {
        addLogOutAction();
    }
}

function logOutRequestGET() {
    $.ajax({
        url: 'logout',
        type: 'GET',
        success: function (data, textStatus) {
            sentsCurrentUserRequestPost();
        },
        error: function (e) {
            console.log("ERROR: ", e);
        }
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
            if (data.succes) {
                userAuthenticationSucces(data);
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
                showPopUpRegistration("User with parameters: " + data.fail + " was created1");
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

function sentsCurrentUserRequestPost() {
    $.ajax({
        url: 'userRequest',
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (data, textStatus) {
            if (data.succes) {
                userAuthenticationSucces(data);
           } else {
                userAuthenticationFail();
           }
        },
        error: function (e) {
            console.log("ERROR: ", e);
        }
    });
}
$(function () {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function (e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
});
$(document).ready(function () {
    sentsCurrentUserRequestPost();
    addSignInClickEvent();
    addRegistartionClickEvent();
});
