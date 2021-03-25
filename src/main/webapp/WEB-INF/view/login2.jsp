<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="UTF-8"/>
    <title>BCORE Admin Dashboard Template | Dashboard </title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <%@include file="header_src.jsp" %>


    <%-- <link rel="stylesheet" href="assets/plugins/bootstrap/css/bootstrap.css" />
     <link rel="stylesheet" href="assets/css/login.css" />
     <link rel="stylesheet" href="assets/plugins/magic/magic.css" />--%>


    <link href="../../resources/static/css/loginOut.css" rel="stylesheet"/>



</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->
<body class="padTop53 ">

<%--
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
<!------ Include the above in your HEAD tag ---------->

<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Tabs Titles -->

        <!-- Icon -->
        <div class="fadeIn first">
        </div>

        <!-- Login Form -->
        <form method="post" name="loginForm">
            <input type="text" id="login" class="fadeIn second" name="login" placeholder="login">
            <input type="password" id="password" class="fadeIn third" name="login" placeholder="password">
            <input type="submit" class="fadeIn fourth" value="Log In">
        </form>

        <!-- Remind Passowrd -->
        <div id="formFooter">
            <a class="underlineHover" href="#">Forgot Password?</a>
        </div>

    </div>
</div>


<%@include file="footer_src.jsp" %>


</body>

<script type="text/javascript">


    $(document).ready(function () {
        /*  $(function() {
              formValidation();
          });*/
        $("#loginForm").submit(
            function (e) {
                e.preventDefault();
                // if (!$("#courseSubjectForm").valid())
                //     return false;
                var formData = {
                    username: $('#login').val(),
                    password: $('#password').val()
                };
                $.ajax({
                    type: "POST",
                    url: "/dologin",
                    dataType: 'json',
                    contentType: 'application/json',
                    data: JSON.stringify(formData),
                    success: function (data) {

                    }

                });

            });
    });
</script>

<!-- END BODY -->
</html>
