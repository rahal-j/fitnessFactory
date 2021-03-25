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

    <link rel="stylesheet"
          href="../../resources/static/assets/plugins/fullcalendar-1.6.2/fullcalendar/fullcalendar.css"/>
    <link rel="stylesheet" href="../../resources/static/assets/css/calendar.css"/>

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
    <div class="body">
        <div class="row">
            <div class="col-lg-3">
              </div>
            <div style="padding-top: 60px" id="calendar" class="col-lg-9"></div>
        </div>
    </div>
    <!--END PAGE CONTENT -->
</div>
<!--END MAIN WRAPPER -->
<!-- FOOTER -->
<%@include file="footer.jsp"%>
<!--END FOOTER -->
<%@include file="footer_src.jsp"%>
<script src="../../resources/static/assets/plugins/fullcalendar-1.6.2/fullcalendar/fullcalendar.min.js"></script>
<script src="../../resources/static/assets/js/calendarInit.js"></script>


<script type="text/javascript">


    $(document).ready(function () {


        $.ajax({
            url: "/userCourse/getMemberCourses",
            type: "GET",
            dataType: "json",
            data: null,
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                 $('#calendar').fullCalendar({
                    events: data.data
                });
            }
        });

    });
</script>
</body>
<!-- END BODY -->
</html>
