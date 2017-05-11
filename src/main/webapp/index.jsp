<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="resources/css/main.css">
    <meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <!-- ... -->
</head>
<body>
<div class="layout">
    <div class = popUpContext id = "popUpContext">
        <div class="popUp">
            <p class="popupText" id="popupText">
        </div>)
    </div>
    <div class = maincontent id = "mainContext">
        <table  class="registrationTable" id="registrationTable" >
            <tr>
                <td>login:</td>   <td><input id="reg_login"    type="text" value=""></td>
            </tr>
            <tr>
                <td>email:</td>   <td><input id="reg_email"    type="text" value=""></td>
            </tr>
            <tr>
                <td>password:</td> <td><input id="reg_password" type="password"  value = ""></td>
            </tr>
            <tr>
                <td class = "buttonTd" colspan="2"><button class = "sentButton" id = "btnSentRegistartion" >sent</button></td>
            </tr>
        </table>

        <table class="registrationTable" id="authenticationTable">
            <tr>
                <td>email:</td>   <td><input id="outh_email"    type="text" value=""></td>
            </tr>
            <tr>
                <td>password:</td> <td><input id="outh_password" type="password"  value = ""></td>
            </tr>
            <tr>
                <td class = "buttonTd" colspan="2"><button class = "sentButton" id = "btnSentAutontification" >sent</button></td>
            </tr>
        </table>
    </div>
    <div class = "service" id = "serviceContext">
        <button class="registrationButton" id = "btnRegistartion"  title="Registaration"> </button>
        <button class="signButton" id = "btnSign"  title="Sign In"> </button>
        <button class="signOutButton" id = "btnSignOut"  title="Sign Out"> </button>
    </div>
    <div class = "userDetail" id = "userDetailContext">
        <label class = "userNameLabel" id = "userNameLable"></label>
    </div>

    <div class = "avatarContainer" id = "avatarContainer">

    </div>

    <div class = "nameContainer" id = "nameContainer">
        <input class = "nameInput" id = "nameInput">
        <p class = "nameParagraph" id = "nameParagraph">
    </div>

    <div class = "appearanceContainer" id = "appearanceContainer">
        <table class="appearanceTable" id="appearanceTable"></table>
    </div>

    <div class = "loadImageContext" id = "loadImageContext">
        <img class = "avatarImage"   id = "avatarImage">
        <label class = "loadImageLabel" text="save">choose image
            <input class = "loadImage" id = "loadImage" type="file" value="load avatar" accept="image/jpeg, image/png">
        </label>
        <input class = "saveImage" id = "saveImage" type="button" value="save">
    </div>
</div>
<script src="resources/js/jquery-2.2.4.js"></script>
<script src="resources/js/index.js"></script>
</body>
</html>