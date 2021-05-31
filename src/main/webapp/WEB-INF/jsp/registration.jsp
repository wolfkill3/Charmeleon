<!DOCTYPE html>
<html lang="en">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <meta charset="UTF-8">
    <style type="text/css">
        <%@ include file="registration/css/registration.css" %>
    </style>
    <title>Sign Up</title>
    <meta charset="UTF-8">

</head>
<body>
<div class="sign-up">
    <h1 class="sign-up-properties">
        <a class="sign-up-properties" href="http://localhost:8083/login"> Sign In</a>
    </h1>
</div>

<div class="auth">
    <div class="preview-img">
        <img class="preview-img" src="img/chameleon2.png" alt="404 not found">
    </div>
    <h2 class="auth-properties">Sign Up</h2>
    <p class="auth-login-board">
        <label>
            <input id="login" class="auth-login" type="text" maxlength="25" size="40" value="login">
        </label>
    </p>
    <input id="play-button" class="play-img" type="image" src="img/play.png">
    <p class="auth-pass-board">
        <label>
            <input id="pass" class="auth-pass" type="password" maxlength="25" size="40" value="password">
        </label>
    </p>
    <p class="auth-pass--confirm-board">
        <label>
            <input id="pass-confirm" class="auth-pass" type="password" maxlength="25" size="40" value="password">
        </label>
    </p>
</div>
<script type="text/javascript">
	<%@ include file="registration/js/registration.js" %>
</script>
</body>
</html>