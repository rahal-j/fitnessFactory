<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="UTF-8" />
    <title>BCORE Admin Dashboard Template | Dashboard </title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />
     <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
     <%@include file="header_src.jsp"%>

</head>

<!-- END HEAD -->

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
                    <h1> Admin Dashboard </h1>
                </div>
            </div>
            <hr />
            <!--BLOCK SECTION -->
            <div class="row">
                <div class="col-lg-12">
                    <div style="text-align: center;">

                        <a class="quick-btn" href="#">
                            <i class="icon-check icon-2x"></i>
                            <span> Products</span>
                            <span class="label label-danger">2</span>
                        </a>

                        <a class="quick-btn" href="#">
                            <i class="icon-envelope icon-2x"></i>
                            <span>Messages</span>
                            <span class="label label-success">456</span>
                        </a>
                        <a class="quick-btn" href="#">
                            <i class="icon-signal icon-2x"></i>
                            <span>Profit</span>
                            <span class="label label-warning">+25</span>
                        </a>
                        <a class="quick-btn" href="#">
                            <i class="icon-external-link icon-2x"></i>
                            <span>value</span>
                            <span class="label btn-metis-2">3.14159265</span>
                        </a>
                        <a class="quick-btn" href="#">
                            <i class="icon-lemon icon-2x"></i>
                            <span>tasks</span>
                            <span class="label btn-metis-4">107</span>
                        </a>
                        <a class="quick-btn" href="#">
                            <i class="icon-bolt icon-2x"></i>
                            <span>Tickets</span>
                            <span class="label label-default">20</span>
                        </a>



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
