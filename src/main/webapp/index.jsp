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
            <div class = maincontent id = "popUpContext">
            </div>
            <div class = maincontent id = "mainContext">
            </div>
            <div class = "service" id = "serviceContext">
                <button class="registrationButton" id = "btnRegistartion"  title="Registaration"> </button>
                <button class="signButton" id = "btnSign"  title="Sign In"> </button>
            </div>
        </div>
        <script src="resources/js/jquery-2.2.4.js"></script>
        <script src="resources/js/index.js"></script>
    </body>
</html>