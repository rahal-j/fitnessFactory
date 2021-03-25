<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="UTF-8"/>
    <title>Add new Room Schedule</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <%@include file="header_src.jsp" %>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.standalone.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.css"
          rel="stylesheet"/>

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->
<body class="padTop53 ">

<!-- MAIN WRAPPER -->
<div id="wrap">


    <!-- HEADER SECTION -->
    <%@include file="header.jsp" %>
    <!-- END HEADER SECTION -->


    <!-- MENU SECTION -->
    <%@include file="left.jsp" %>

    <!--END MENU SECTION -->


    <!--PAGE CONTENT -->
    <div id="content">

        <div class="inner" style="min-height: 700px;">
            <ul class="breadcrumb" style="margin-top:2%;">
                <li><a href="/home">Home</a></li>
                <li><a href="/roomSchedule/insertPage">Book Class Room</a></li>
            </ul>
            <div class="row">


                <div class="col-lg-12">
                    <div class="box dark">
                        <header>
                            <div class="icons">
                                <i class="icon-glass"></i>
                            </div>
                            <h5>Enter Class Room Details</h5>
                        </header>

                        <form id="roomScheduleForm" class="form-horizontal" align="center"
                              novalidate>


                            </br>
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-5" style="float: right;"> Room Schedule
                                            ID</label>
                                    </div>
                                    <div class="col-md-4">
                                        <input type="text" id="id" name="id"
                                               readonly="readonly" class="form-control"
                                               value="<c:out value="${roomSchedule.id}" />"/>
                                    </div>
                                </div>
                            </div>


                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-5"
                                               style="float: right;"> Class Room</label>
                                    </div>
                                    <div class="col-md-4">

                                        <select name="room"
                                                class="form-control chzn-select" id=room>

                                            <option value="<c:out value="${room.id}" />">${room.name}</option>
                                            <c:forEach items="${rooms}" var="temp">
                                                <option value="<c:out value= "${temp.id}" />">${temp.name}</option>
                                            </c:forEach>
                                        </select>

                                    </div>
                                </div>
                            </div>


                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-5"
                                               style="float: right;">Course Name</label>
                                    </div>
                                    <div class="col-md-4">

                                        <select name="course"
                                                class="form-control chzn-select" id="course">

                                            <option value="<c:out value="${course.id}" />">${course.name}</option>
                                            <c:forEach items="${courses}" var="temp">
                                                <option value="<c:out value= "${temp.id}" />">${temp.name}</option>
                                            </c:forEach>
                                        </select>

                                    </div>
                                </div>
                            </div>


                            <%--         <div class="row">

                                         <div class="form-group">
                                             <div class="col-md-4">
                                                 <label class="control-label col-md-5"
                                                        style="float: right;">Course Start Date</label></div>
                                             <div class="col-md-4">
                                                 <div id="sandbox-container">
                                                     <div class="input-group date">
                                                         <input type="text" placeholder="YYYY-MM-DD" name="dob"
                                                                id="dob" class="all form-control"
                                                                value=""><span
                                                             class="input-group-addon"><li
                                                             class="glyphicon glyphicon-th"></li></span>
                                                     </div>
                                                 </div>
                                             </div>
                                         </div>
                                     </div>--%>

                            <div class="row">
                                <div class="form-group">

                                    <div class="col-md-4">
                                        <label class="control-label col-md-5"
                                               style="float: right;">Course Start Date</label></div>
                                    <div class="col-md-4">


                                             <div class='input-group date' id='startTime'>
                                                <input type='text' name="startTime" class="form-control" value="<c:out value="${roomSchedule.startTime}" />">
                                                <span class="input-group-addon">
                        <span class="glyphicon glyphicon-time"></span>
                    </span>
                                            </div>


                                    </div>
                                </div>
                            </div>


                            <div class="row">
                                <div class="form-group">

                                    <div class="col-md-4">
                                        <label class="control-label col-md-5"
                                               style="float: right;">Course End Date</label></div>




                                    <div class="col-md-4">


                                             <div class='input-group date' id='endTime'>
                                                <input type='text' name="endTime" class="form-control" value="<c:out value="${roomSchedule.endTime}" />">
                                                <span class="input-group-addon">
                        <span class="glyphicon glyphicon-time"></span>
                    </span>
                                            </div>


                                    </div>



<%--
                                    <div class="col-md-4">


                                        <div class="form-group">
                                            <div class='input-group date' id='endDate'>
                                                <input type='text' class="form-control" name="endDate"
                                                       value="<c:out value="${course.endDate}" />">
                                                <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar"></span>
                                                        </span>
                                            </div>
                                        </div>

                                    </div>--%>
                                </div>
                            </div>


                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-5 style="
                                               style="float: right;">Status</label>
                                    </div>
                                    <div class="col-md-4">
                                        <select name="status" id="status" class="form-control">
                                            <option value="">Select Status</option>
                                            <option value='ACTIVE' <c:if test="${roomSchedule.status == 'ACTIVE'}"> <c:out
                                                    value="selected=selected"/></c:if>>ACTIVE
                                            </option>
                                            <option value='DEACTIVE' <c:if test="${roomSchedule.status == 'DEACTIVE'}"> <c:out
                                                    value="selected=selected"/></c:if>>DEACTIVE
                                            </option>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-actions no-margin-bottom"
                                     style="text-align: center;">
                                    <div class="col-sm-3"></div>
                                    <div class="col-sm-6">
                                        <div>
                                            <input id="btn_save"
                                                   value="Save" class="btn btn-success btn-md " type="submit">
                                            <input id="btn_reset" value="Reset"
                                                   class="btn btn-warning btn-md " type="reset"/> <a
                                                class="btn btn-danger btn-md"
                                                href="/roomSchedule/">Cancel</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>


            </div>


        </div>

    </div>
    <!--END PAGE CONTENT -->


</div>

<!--END MAIN WRAPPER -->

<!-- FOOTER -->
<%@include file="footer.jsp" %>
<!--END FOOTER -->


<%@include file="footer_src.jsp" %>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>


<%--Page Level Scripts--%>
<%--Page Level Scripts End--%>


<script type="text/javascript">
    $(document).ready(function () {

        $(function () {
            formValidation();
        });

        $("#roomScheduleForm").submit(
            function (e) {

                e.preventDefault();
                 if (!$("#roomScheduleForm").valid())
                    return false;
                 var formData = getFormDataAsDTO("roomScheduleForm");
                $.ajax({
                    type: "POST",
                    url: "/roomSchedule/addRoomSchedule",
                    dataType: 'json',
                    contentType: 'application/json',
                    data: formData,
                    success: function (data) {
                        if (data.code == 'SUCCESS') {
                            swal(
                                {
                                    title: "Success Function!",
                                    text: data.message,
                                    type: "success",
                                    showCancelButton: false,
                                    confirmButtonColor: "#DD6B55",
                                    confirmButtonText: "OK!",
                                    closeOnConfirm: false
                                },
                                function () {
                                    window.location = "/roomSchedule/";
                                });
                        } else {
                            swal(
                                "Data not saved!",
                                data.message,
                                "error");
                        }
                    }

                });

            });
    });


    function getFormDataAsDTO(formId) {
        var formElement = $('form#' + formId);
        var formData = new Object();
        var formDataArray = formElement.serializeArray();
        $.each(formDataArray, function (i, obj) {
            formData[obj.name] = obj.value;
        });
        return JSON.stringify(formData);
    }


</script>

<script type="text/javascript">
    $(function () {
        $('.date').datetimepicker({
            format: 'YYYY-MM-DD HH:mm'

        });
    });
</script>

</body>

<!-- END BODY -->
</html>
