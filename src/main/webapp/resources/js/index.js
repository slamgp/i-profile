const MAX_LENGHT_FOR_NAME = 30;


function userAuthenticationSucces(data) {
    showUserData(data);
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
    showServiceButton(true, true, false);
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
    $("#nameContainer").bind('click', function () {
        name = $("#nameParagraph").text();
        $("#nameParagraph").css("visibility", "hidden");
        $("#nameInput").val(name);
        $("#nameInput").css("visibility", "visible");
        $("#nameInput").focus();
    });

    $("#avatarContainer").bind('click', function () {
        $("#loadImageContext").css("visibility", "visible");
    });
}

function sendUserChageRrequest(field, value, callback, caption) {
    $.ajax({
        url: 'userDataChange',
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify({"change_field": field, "change_value": value}),
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (data, textStatus) {
            if ((callback != null) && (callback != undefined)) {
                callback(caption, value);
            }
        },
        error: function (e) {
            console.log("ERROR: ", e);
        }
    });
}

var callBackActionOnChange = function callBackActionOnChange(caption, value) {
    caption.text(value);
}

function prepareAllElements() {
    $(".nameInput").attr("maxlength", MAX_LENGHT_FOR_NAME);
    $(".nameInput").bind('change', function () {
        $(".nameInput").css("visibility", "hidden");
        $("#nameParagraph").css("visibility", "visible");
        sendUserChageRrequest("allUserName", $(".nameInput").val(), callBackActionOnChange, $("#nameParagraph"));
    });
    $(".nameInput").bind('focusout', function () {
        $(".nameInput").css("visibility", "hidden");
        $("#nameParagraph").css("visibility", "visible")
    });

    $(".loadImage").bind('change', function (event) {
        $("#saveImage").css("visibility", "visible");
        var avatarFile = event.target.files[0];
        var reader = new FileReader();

        reader.onloadend = function () {
            $("#avatarImage").attr('src', reader.result);
        }

        if (avatarFile) {
            reader.readAsDataURL(avatarFile);
        } else {
            $("#avatarImage").attr('src', "");
        }
    });

    $(".saveImage").bind('click', function (event) {
        var formData = new FormData();
        formData.append("image", $("#avatarImage").attr('src'));
        var file = $("#avatarImage").attr('src');
        var  bytesOfFile =  file.replace('data:image/jpeg;base64,', "");
        bytesOfFile = bytesOfFile.replace('data:image/png;base64,', '')
        bytesOfFile = bytesOfFile.replace(' ', '+')
        sendUserChageRrequest("avatar", bytesOfFile);
    });
}

function addEditAppearanceAction() {
    $(".textEdit").bind('click', function () {
        oldValue = $(this).find("#caption").text();
        $(this).find("#caption").css("visibility", "hidden");
        $(this).find("#value").css("visibility", "visible");
        $(this).find("#value").val(oldValue);
        $(this).find("#value").focus();
    });

    $(".dataInput").bind('change', function () {
        $(this).parent().find("#caption").css("visibility", "visible");
        $(this).parent().find("#value").css("visibility", "hidden");
        sendUserChageRrequest($(this).parent().attr("id"), $(this).val(), callBackActionOnChange, $(this).parent().find("#caption"));
    });
    $(".dataInput").bind('focusout', function () {
        $(this).parent().find("#caption").css("visibility", "visible");
        $(this).parent().find("#value").css("visibility", "hidden");
    });
}

function showUserAppearance(data) {
    $("#appearanceContainer").css("visibility", "visible");
    $(".appearanceTable").css("visibility", "visible");
    createRow("#appearanceTable", "age:", data.age, "age", "number");
    createRow("#appearanceTable", "high:", data.high, "high", "number");
    createRow("#appearanceTable", "weight:", data.weight, "weight", "number");
    createRow("#appearanceTable", "main foot:", data.mainFoot, "mainFoot", "text");
    addEditAppearanceAction();
}

function createRow(tableName, field1, field2, textEditId, type) {
    $(tableName).append('<tr></tr>');
    $(tableName + '> tbody > tr:last').append('<td class = "caption">' + field1 + '</td>');
    $(tableName + '> tbody > tr:last').append('<td class = "textEdit" id = ' + textEditId + '> <p class= "dataInputParagraph" id = "caption">' + field2 + '</p> <input id = "value" class = "dataInput"' + 'type = ' + type + '></input></td>');
}

function showCarier(carier) {
    // if (carier != null && carier != undefined) {
    //  for (i = 0; i < carier.length; i++) {
    //   alert(carier[i].name);
    // }
    //  }
}

function showUserData(data) {
    $("#userNameLable").text(data.login);
    showServiceButton(false, false, true);
    $("#avatarContainer").css("backgroundImage", 'url(' + data.avatar + ')')
    $("#avatarContainer").css("visibility", "visible");
    $("#nameContainer").css("visibility", "visible");
    $("#nameParagraph").text(data.allUserName)
    showUserAppearance(data.appearance);
    showCarier(data.carier);
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
