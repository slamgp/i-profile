function userAuthenticationSucces(data) {
    showUserData(data);
}

function showUserData(data) {
    $("#userNameLable").text(data.login);
    showServiceButton(false, false, true);
    $("#avatarContainer").css("backgroundImage", 'url(' + data.avatar + ')')
    $("#avatarContainer").css("visibility", "visible");
    $("#nameContainer").css("visibility", "visible");
    $("#nameContainer").text(data.allUserName)
}


function hideUserData() {
    $("#userNameLable").text("");
    $("#avatarContainer").css("visibility", "hidden");
    $("#nameContainer").css("visibility", "hidden");
}

function userAuthenticationFail(data) {
    $("#userNameLable").text("");
    showServiceButton(true, true, false);
}

function addRegistrationAction() {
    $("#btnSentRegistartion").bind('click', function () {
        registrationRequestPOST($('#reg_login').val(), $('#reg_email').val(), $('#reg_password').val())
    });

}

function addAutentificationAction() {
    $("#btnSentAutontification").bind('click', function () {
        autentificationRequestPOST($('#outh_email').val(), $('#outh_password').val())
    });
}

function addLogOutAction() {
    $("#btnSignOut").bind('click', function () {
        logOutRequestGET();
    });
}


function addRegistartionClickEvent() {
    $("#btnRegistartion").bind('click', function () {
        $("#authenticationTable").css("visibility", "hidden")
        $("#registrationTable").css("visibility", "visible")
    });
}

function addSignInClickEvent() {
    $("#btnSign").bind('click', function () {
        $("#registrationTable").css("visibility", "hidden")
        $("#authenticationTable").css("visibility", "visible")
    });
}


function showPopUpMessage(message) {
    $("#popupText").text(message)
    $("#popUpContext").css({opacity: 0});
    $("#popUpContext").fadeTo(500, 1).delay(2000).fadeTo(500, 0);
}


function showServiceButton(registration, signIn, signOut) {
    if (registration) {
        $("#btnRegistartion").css("visibility", "visible")
    } else {
        $("#btnRegistartion").css("visibility", "hidden")
    }
    if (signIn) {
        $("#btnSign").css("visibility", "visible")
    } else {
        $("#btnSign").css("visibility", "hidden")
    }
    if (signOut) {
        $("#btnSignOut").css("visibility", "visible")
    } else {
        $("#btnSignOut").css("visibility", "hidden")
    }
}

function logout() {
    showServiceButton(true,true,false);
    hideUserData();
}

function logOutRequestGET() {
    $.ajax({
        url: 'logout',
        type: 'GET',
        success: function (data) {
            logout();
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
                $("#authenticationTable").css("visibility", "hidden");
                userAuthenticationSucces(data);
                showServiceButton(false, false, true);
            } else {
                if (data.noUser != null) {
                    showPopUpMessage("This is user doesn't find in system");
                } else {
                    showPopUpMessage("This password isn't correct");
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
                $("#registrationTable").css("visibility", "hidden");
                showServiceButton(false, true, false);
            } else {
                showPopUpMessage("User with parameters: " + data.fail + " was created1");
            }
        },
        error: function (e) {
            console.log("ERROR: ", e);
        }
    });
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
/*$(function () {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function (e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
});*/
$(document).ready(function () {
    addSignInClickEvent();
    addRegistartionClickEvent();
    addLogOutAction();
    addRegistrationAction();
    addAutentificationAction();
    sentsCurrentUserRequestPost();
});
