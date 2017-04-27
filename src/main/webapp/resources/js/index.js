const  MAX_LENGHT_FOR_NAME = 30;
const  CHANGE_OBJECT_NAME = "change_object";
const  CHANGE_FIELD_NAME = "change_field";
const  CHANGE_FIELD_VALUE = "change_value";

function userAuthenticationSucces(data) {
    showUserData(data);
}

function showUserData(data) {
    $("#userNameLable").text(data.login);
    showServiceButton(false, false, true);
    $("#avatarContainer").css("backgroundImage", 'url(' + data.avatar + ')')
    $("#avatarContainer").css("visibility", "visible");
    $("#nameContainer").css("visibility", "visible");
    $("#nameParagraph").text(data.allUserName)
    showUserAppearance(data.appearance);
}

function showUserAppearance(data) {
    $("#appearanceContainer").css("visibility", "visible");
    $(".appearanceTable").css("visibility", "visible");
    createRow("#appearanceTable", "age:", data.age);
    createRow("#appearanceTable","high:", data.high);
    createRow("#appearanceTable","weight:", data.weight);
    createRow("#appearanceTable","main foot:", data.mainFoot);
}

function createRow(tableName, field1, field2) {
    $(tableName).append('<tr></tr>');
    $(tableName + '> tbody > tr:last').append('<td class = "caption">' + field1 + '</td>');
    $(tableName + '> tbody > tr:last').append('<td class = "textEdit">' + field2 + '</td>');
}

function hideUserData() {
    $("#userNameLable").text("");
    $("#avatarContainer").css("visibility", "hidden");
    $("#nameContainer").css("visibility", "hidden");
    hideUserAppearance();
}

function hideUserAppearance() {
    $("#appearanceContainer").css("visibility", "hidden");
    $(".appearanceTable").css("visibility", "visible");
    $("#appearanceContainer").empty();
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
function addEditAction() {
    $("#nameContainer").bind('click', function() {
        name = $("#nameParagraph").text();
        $("#nameParagraph").css("visibility", "hidden");
        $("#nameInput").val(name);
        $("#nameInput").css("visibility", "visible");
        $("#nameInput").focus();
    })
}

function sendDataChageRrequest(object, field, value, callback) {
    alert(value)
    $.ajax({
        url: 'userDataChange',
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify({CHANGE_OBJECT_NAME: object, CHANGE_FIELD_NAME: field, CHANGE_FIELD_VALUE: value}),
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (data, textStatus) {
            callback();
        },
        error: function (e) {
            console.log("ERROR: ", e);
        }
    });
}

var callBackActionOnChangeName = function callBackActionOnChangeName() {
    $("#nameParagraph").text( $(".nameInput").val());
}

function prepareAllElements() {
    $(".nameInput").attr("maxlength", MAX_LENGHT_FOR_NAME);
    $(".nameInput").bind('change', function() {
    $(".nameInput").css("visibility", "hidden");
    $("#nameParagraph").css("visibility", "visible");
    sendDataChageRrequest("user", "allUserName",  $(".nameInput").val(), callBackActionOnChangeName);
    });
    $(".nameInput").bind('focusout', function() {
        $(".nameInput").css("visibility", "hidden");
        $("#nameParagraph").css("visibility", "visible")
    });


}

$(document).ready(function () {
    addSignInClickEvent();
    addRegistartionClickEvent();
    addLogOutAction();
    addRegistrationAction();
    addAutentificationAction();
    sentsCurrentUserRequestPost();
    addEditAction();
    prepareAllElements();
});
