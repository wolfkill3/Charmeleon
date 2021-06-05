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
    <p class="auth-email-board" title="Enter the e-mail">
    <div class="auth-text">Enter the e-mail</div>
    <label>
        <input id="email" class="auth-email" type="text" maxlength="25" size="40" value="">
    </label>
    </p>
    <p class="auth-login-board" title="Enter the login">
    <div class="auth-text">Enter the login</div>
    <label>
        <input id="login" class="auth-login" type="text" maxlength="25" size="40" value="">
    </label>
    </p>
    <input id="play-button" class="play-img" type="image" src="img/play.png">
    <p class="auth-pass-board" title="Enter the password">
    <div class="auth-text-after-picture">Enter the password</div>
    <label>
        <input id="pass" class="auth-pass" type="password" maxlength="25" size="40" value="">
    </label>
    </p>
    <p class="auth-pass-confirm-board" title="Confirm the password">
    <div class="auth-text">Confirm the password</div>
    <label>
        <input id="pass-confirm" class="auth-pass-confirm" type="password" maxlength="25" size="40" value="">
    </label>
    </p>
    <div class="alert">
        <p class="alert-text"></p>
    </div>
</div>
<script type="text/javascript">
	<%@ include file="registration/js/registration.js" %>
</script>
</body>
</html>