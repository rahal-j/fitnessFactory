<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="UTF-8"/>
    <title>Fitness Factory | Attendance </title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <%@include file="header_src.jsp" %>

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
                <li><a href="/attendance/insertPage">Add Attendance</a></li>
            </ul>
            <div class="row">


                <div class="col-lg-12">
                    <div class="box dark">
                        <header>
                            <div class="icons">
                                <i class="icon-glass"></i>
                            </div>
                            <h5>Mark Attendance</h5>
                        </header>






                        <form id="attendanceForm" class="form-horizontal" align="center"
                              novalidate>


                            </br>

                            <div class="row">
                                <div class="form-group">
                                    <label class="control-label col-md-4">Attendance Marking Type</label>

                                    <div class="col-md-8">
                                        <div class="checkbox">
                                            <label> <input class="uniform cus_type" type="radio"
                                                           name="cus_type" value="rg" /> Barcode
                                            </label> &nbsp;<label> <input class="uniform cus_type"
                                                                          type="radio" name="cus_type" value="un_rg"
                                                                          checked="checked" /> NIC
                                        </label>
                                        </div>


                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-5"
                                               style="float: right;">Search Member</label>
                                    </div>
                                    <div class="col-md-4">
                                        <input type="text" id="searchNic" name="searchNic"
                                               placeholder="Enter Member's NIC" class="form-control"
                                               value="<c:out value="${attendance.name}" />"/>
                                    </div>
                                    <div class="col-md-4">
                                        <div>
                                            <input id="btn_search"
                                                   value="Search" class="btn btn-success btn-md " type="button">


                                        </div>

                                    </div>

                                </div>
                            </div>




                            <div class="row">
                                <div class="form-actions no-margin-bottom"
                                     style="text-align: center;">
                                    <div class="col-sm-3"></div>
                                    <div class="col-sm-6">
                                        <div>
                                             <input id="btn_reset" value="Reset"
                                                   class="btn btn-warning btn-md " type="reset"/> <a
                                                class="btn btn-danger btn-md"
                                                href="/attendance/">Cancel</a>
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

<%--
<script type="text/javascript">
    $(document).ready(function () {
        $(function() {
            formValidation();
        });
        $("#attendanceForm").submit(
            function (e) {
                e.preventDefault();
                if (!$("#attendanceForm").valid())
                    return false;
                var formData = getFormDataAsDTO("attendanceForm");
                $.ajax({
                    type: "POST",
                    url: "/attendance/save",
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
                                    window.location = "/attendance/";
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
--%>

<script>
    $('#btn_search').click(function() {

        var searchId = $("#searchNic").val();


        var url1;
        url1 = "/attendance/memberAttendance?nic="+searchId;

        $.ajax({
            type: "GET",
            url: url1,
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
                        })

                } else {
                    swal(
                        "Data not Found!",
                        data.message,
                        "error");
                }
            }

        });

    });

</script>

</body>

<!-- END BODY -->
</html>
