<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="UTF-8"/>
    <title>Add Course Subjects </title>
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
                <li><a href="/userCourse/insertPage">Add Course to User</a></li>
            </ul>
            <div class="row">
                <input value="${action}" id="action" type="hidden">

                <div class="col-lg-12">
                    <div class="box dark">
                        <header>
                            <div class="icons">
                                <i class="icon-glass"></i>
                            </div>
                            <h5>Add Course to User</h5>
                        </header>

                        <form id="userCourseForm" class="form-horizontal" align="center"
                              novalidate>


                            </br>

                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-5"
                                               style="float: right;">Nic</label>
                                    </div>
                                    <div class="col-md-4">
                                        <input type="text" id="nic" name="nic"
                                               placeholder="Enter Nic" class="form-control"
                                               value="<c:out value="${userCourse.nic}" />"/>
                                    </div>
                                    <div class="col-md-4">
                                        <input id="btn_find"
                                               value="find" class="btn btn-success btn-md " type="button">
                                    </div>
                                </div>
                            </div>

                            <input type="text" id="id" name="id"
                                    class="form-control hidden"
                                   value="<c:out value="${userCourse.id}" />"/>

                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-5"
                                               style="float: right;">First Name</label>
                                    </div>
                                    <div class="col-md-4">
                                        <input type="text" id="firstName" name="firstName" readonly
                                               placeholder=" First Name" class="form-control"
                                               value="<c:out value="${userCourse.firstName}" />"/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-5"
                                               style="float: right;">Last Name</label>
                                    </div>
                                    <div class="col-md-4">
                                        <input type="text" id="lastName" name="lastName" readonly
                                               placeholder=" Last Name" class="form-control"
                                               value="<c:out value="${userCourse.lastName}" />"/>
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

                                            <option value="<c:out value="${userCourse.courseId}" />">${userCourse.courseName}</option>
                                            <c:forEach items="${courses}" var="temp">
                                                <option value="<c:out value= "${temp.id}" />">${temp.name}</option>
                                            </c:forEach>
                                        </select>

                                    </div>
                                </div>
                            </div>


                            <br />

                            <br />

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
                                                href="/userCourse/">Cancel</a>
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



<script type="text/javascript">
    $(document).ready(function () {
         $(function() {
              formValidation();
          });
        $("#userCourseForm").submit(
            function (e) {
                e.preventDefault();
                  if (!$("#userCourseForm").valid())
                    return false;
                var formData = getFormDataAsDTO("userCourseForm");
                $.ajax({
                    type: "POST",
                    url: "/userCourse/addUserCourse",
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
                                    window.location = "/userCourse/";
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



    $('#btn_find').click(function(){

        var nic = $("#nic").val();

  /*      $.ajax
        ({
        url: "/regUser/getUserDataFromNic" + nic,
               data: {"nic": nic},
             type: 'POST',
            success: function (data) {
                if (data.code == 'FAIL') {
                    swal(
                        "No User Available for NIC !",
                        data.message,
                        "error");
                } else {
                    $("#nic").val(data.data.nic);
                    $("#firstName").val(data.data.firstName);
                    $("#lastName").val(data.data.lastName);
                }
            }
        });*/



        $.ajax({
            url: "/regUser/getUserDataFromNic?nic=" + nic,
            type: "GET",
            dataType: "json",
            data: null,
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                if (data.code == 'FAIL') {
                    swal(
                        "No User Available for NIC !",
                        data.message,
                        "error");
                } else {
                     $("#nic").val(data.data.nic);
                    $("#id").val(data.data.id);
                    $("#firstName").val(data.data.firstName);
                    $("#lastName").val(data.data.lastName);
                }
            }
        });

    });
</script>

</body>

<!-- END BODY -->
</html>
