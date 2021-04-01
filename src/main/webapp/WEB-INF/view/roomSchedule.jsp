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

                        <form action="BasicSheduleCon" id="workoutChartForm" method="POST"
                              enctype="multipart/form-data">


                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <div class="col-md-3">
                                            <label>Workout ID </label> <input class="form-control"
                                                                              name="workout_id" value="${workoutID}" readonly="readonly" />
                                        </div>
                                        <div class="col-md-3">
                                            <label> Instructor Name</label> <input class="form-control"
                                                                                   name="ins_name" value=${currentSessionUser.first_name }
                                                                                           readonly="readonly" />
                                        </div>
                                    </div>
                                </div>

                            </div>
                            </br>
                            <div class="row "style="">
                                <div class="col-sm-12">
                                    <div class="col-md-3">
                                        <div class="form-group" style="margin-left: -1%;">
                                            <label for="chartName">Workchart Name</label></div>

                                        <div class="form-group" style="margin-top:-1%;" >
                                            <input id="text2" placeholder="please enter a workchart name" class="form-control" type="text" name="chartName">
                                        </div></div>

                                </div>
                            </div>
                            <hr />
                            <div class="col-md-1"></div>
                            <div class="row">
                                <div class="col-md-4 text-center">
                                    <strong>Exercise ID</strong>
                                </div>

                                <div class="col-md-2 text-center">
                                    <strong>Sets per rep</strong>
                                </div>

                                <div class="col-md-2 text-center">
                                    <strong>No of Reps</strong>
                                </div>
                                <div class="col-md-2 text-center">
                                    <strong></strong>
                                </div>
                            </div>
                            <div class="col-md-1"></div>
                            <div class="inv_body">
                                <div class="row inv_row " id="exer">
                                    <div class="col-md-4 text-center" style="margin-left: 1%;">
                                        <select id="exercise0" name="exerciseID"
                                                class="form-control chzn-select inv_item keep">

                                        </select>
                                    </div>
                                    <div class="col-md-2 text-center form-group">
                                        <input id="set_per_rep0" style="text-align: right;"
                                               class="form-control inv_price" name="set_per_rep" type="text" />
                                    </div>

                                    <div class="col-md-2 text-center form-group">
                                        <input class="form-control" name="no_of_rep" id="no_of_rep0"
                                               type="text" style="text-align: right;" />
                                    </div>
                                    <div class="col-md-1 text-center">
                                        <button id="kmk" class="btn btn-danger  item_remove"
                                                type="button">
                                            <i class="icon-minus-sign"></i>
                                        </button>
                                    </div>
                                </div>



                            </div>

                            <br />
                            <div class="row">
                                <div class="col-md-6"></div>

                                <div class="col-md-3 pull-right">
                                    <button id="add-item" class="btn btn-info" type="button">
                                        <i class="icon-plus-sign"></i>
                                    </button>
                                </div>
                            </div>
                            <br />


                            <div class="row">
                                <div class="form-actions no-margin-bottom"
                                     style="text-align: center;">
                                    <div class="col-sm-3"></div>
                                    <div class="col-sm-6">
                                        <div style="margin-left: -20%;">
                                            <%
                                                String role = currentUser.getRole();

                                                if (role.equals("administrator") || role.equals("instructor")) {
                                            %>
                                            <button type="submit" class="btn-sm btn-success">Save</button>
                                            <%
                                                }
                                            %>
                                            <input id="btn_reset" value="Reset"
                                                   class="btn btn-warning btn-sm " type="reset" /> <a
                                                class="btn btn-primary btn-sm" href="ProductCon?action=list">Cancel</a>
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
