<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="UTF-8" />
    <title>Fitness Factory | Dashboard </title>
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
            <% if (currentUser.getUserRole().getName().equals("admin")) {%>


            <div class="row">
                <div class="col-lg-12">
                    <div style="text-align: center;">

                        <a class="quick-btn" href="/member/insertPage">
                            <i class="icon-edit-sign icon-4x"></i>
                            <span style="font-size: medium">Member Register</span>
                        </a>
                        <a class="quick-btn" href="/payment/insertPage">
                            <i class="icon-euro icon-4x"></i>
                            <span style="font-size: medium">Payment</span>
                        </a>

                        <a class="quick-btn" href="/attendance/insertPage">
                            <i class="icon-calendar-empty icon-4x"></i>
                            <span style="font-size: medium">Attendance Marking</span>
                        </a>
                        <a class="quick-btn" href="/exercise/insertPage">
                            <i class="icon-th icon-4x"></i>
                            <span style="font-size: medium">Exercise</span>
                        </a>
                        <a class="quick-btn" href="/schedule/insertPage">
                            <i class="icon-folder-open-alt icon-4x"></i>
                            <span style="font-size: medium">Schedule</span>
                        </a>
                        <a class="quick-btn" href="/product/insertPage">
                            <i class="icon-list-alt icon-4x"></i>
                            <span style="font-size: medium">Product</span>
                        </a>

                        <a class="quick-btn" href="/stocks/insertPage">
                            <i class="icon-align-justify icon-4x"></i>
                            <span style="font-size: medium">Stocks</span>
                        </a>

                        <a class="quick-btn" href="/invoice/insertPage">
                            <i class="icon-rupee icon-4x"></i>
                            <span style="font-size: medium">Invoice</span>
                        </a>
                        <br/>

                        <%      } else if (currentUser.getUserRole().getName().equals("instructor")){ %>



                        <a class="quick-btn" href="/exercise/insertPage">
                            <i class="icon-th icon-4x"></i>
                            <span style="font-size: medium">Exercise</span>
                        </a>

                        <a class="quick-btn" href="/schedule/insertPage">
                            <i class="icon-folder-open-alt icon-4x"></i>
                            <span style="font-size: medium">Schedule</span>
                        </a>




                        <%      } else if (currentUser.getUserRole().getName().equals("Card Marker")){ %>

                        <a class="quick-btn" href="/attendance/insertPage">
                            <i class="icon-calendar-empty icon-4x"></i>
                            <span style="font-size: medium">Attendance Marking</span>
                        </a>


                        <a class="quick-btn" href="/member/insertPage">
                            <i class="icon-edit-sign icon-4x"></i>
                            <span style="font-size: medium">Member Register</span>
                        </a>

                        <a class="quick-btn" href="/payment/insertPage">
                            <i class="icon-euro icon-4x"></i>
                            <span style="font-size: medium">Payment</span>
                        </a>





                        <%      } %>

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
