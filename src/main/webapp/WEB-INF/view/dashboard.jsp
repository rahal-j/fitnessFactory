<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="UTF-8" />
    <title>School Management Dashboard | Dashboard </title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <%@include file="header_src.jsp"%>

</head>

<!-- END HEAD -->
<!-- LOGO SECTION -->
<header class="navbar-header">

    <a href="index.html" class="navbar-brand">
        <img src="//assets/img/logo.png" alt="" /></a>
</header>
<!-- BEGIN BODY -->
<body class="padTop53 " >

<!-- MAIN WRAPPER -->
<div id="wrap" >
    <!-- HEADER SECTION -->
    <%@include file="header.jsp"%>
    <!-- END HEADER SECTION -->

    <!-- MENU SECTION -->
    <%@include file="left.jsp"%>
    <!--END MENU SECTION -->

    <!--PAGE CONTENT -->
    <div id="content">
        <div class="inner" style="min-height: 700px;">
            <div class="row">
                <div class="col-lg-12">
                    <h1 style="color: #8a7d7d"> Gym Management </h1>
                </div>
            </div>
            <hr />
            <!--BLOCK SECTION -->
            <div class="row">
                <div class="col-lg-12">
                    <div style="text-align: center;">

                        <a class="quick-btn" href="/member/insertPage">
                            <i class="icon-edit-sign icon-4x"></i>
                            <span style="font-size: medium">Member Register</span>
                        </a>
                        <a class="quick-btn" href="/payment/insertPage">
                            <i class="icon-th icon-4x"></i>
                            <span style="font-size: medium">Payment</span>
                        </a>
                        <a class="quick-btn" href="/subscription/insertPage">
                            <i class="icon-list-alt icon-4x"></i>
                            <span style="font-size: medium">Subscription</span>
                        </a>
                        <br/>
                        <a class="quick-btn" href="/schedule/insertPage">
                            <i class="icon-folder-open-alt icon-4x"></i>
                            <span style="font-size: medium">Schedule</span>
                        </a>
                        <a class="quick-btn" href="/stocks/insertPage">
                            <i class="icon-align-justify icon-4x"></i>
                            <span style="font-size: medium">Stocks</span>
                        </a>
                        <a class="quick-btn" href="/userRole/insertPage">
                            <i class="icon-calendar-empty icon-4x"></i>
                            <span style="font-size: medium">User Role</span>
                        </a>

         <%--               <%      } else if (currentUser.getUserRole().getName().equals("SUPERVISOR")){ %>

                        <a class="quick-btn" href="/regUser/insertPage">
                            <i class="icon-edit-sign icon-4x"></i>
                            <span style="font-size: medium">User Register</span>
                        </a>
                        <a class="quick-btn" href="/class/insertPage">
                            <i class="icon-th icon-4x"></i>
                            <span style="font-size: medium">Class</span>
                        </a>
                        <a class="quick-btn" href="/course/insertPage">
                            <i class="icon-list-alt icon-4x"></i>
                            <span style="font-size: medium">Course</span>
                        </a>
                        <br/>
                        <a class="quick-btn" href="/userCourse/insertPage">
                            <i class="icon-folder-open-alt icon-4x"></i>
                            <span style="font-size: medium">Course Assign</span>
                        </a>
                        <a class="quick-btn" href="/subject/insertPage">
                            <i class="icon-align-justify icon-4x"></i>
                            <span style="font-size: medium">Subject</span>
                        </a>
                        <a class="quick-btn" href="/roomSchedule/insertPage">
                            <i class="icon-calendar-empty icon-4x"></i>
                            <span style="font-size: medium">Schedule Class</span>
                        </a>

                        <%      } else if (currentUser.getUserRole().getName().equals("MEMBER")){ %>

                        <a class="quick-btn" href="/userCourse/loadMemberForm">
                            <i class="icon-th icon-4x"></i>
                            <span style="font-size: medium">Class</span>
                        </a>

                        <%      } %>
--%>
                    </div>
                </div>
            </div>
            <!--END BLOCK SECTION -->
            <hr />
        </div>
    </div>
    <!--END PAGE CONTENT -->
</div>
<!--END MAIN WRAPPER -->
<!-- FOOTER -->
<%@include file="footer.jsp"%>
<!--END FOOTER -->
<%@include file="footer_src.jsp"%>
</body>
<!-- END BODY -->
</html>
