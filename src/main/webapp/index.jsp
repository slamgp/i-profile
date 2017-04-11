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

            </div>>

            <div class = "nameContainer" id = "nameContainer">

            </div>>
        </div>
        <script src="resources/js/jquery-2.2.4.js"></script>
        <script src="resources/js/index.js"></script>
    </body>
</html>