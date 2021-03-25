<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="UTF-8"/>
    <title>Fitness Factory | Users </title>
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
                <li><a href="/user/insertPage">Add User</a></li>
            </ul>
            <div class="row">


                <div class="col-lg-12">
                    <div class="box dark">
                        <header>
                            <div class="icons">
                                <i class="icon-glass"></i>
                            </div>
                            <h5>Enter User Details</h5>
                        </header>






                        <form id="memberForm" class="form-horizontal" align="center"
                              novalidate>


                            </br>

                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-5" style="float: right;"> User ID</label>
                                    </div>
                                    <div class="col-md-4">
                                        <input type="text" id="subscriptionId" name="id"
                                               readonly="readonly" class="form-control"
                                               value="<c:out value="${user.id}" />"/>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-5 style="
                                               style="float: right;">Title</label>
                                    </div>
                                    <div class="col-md-4">
                                        <select name="title" id="title" class="form-control">
                                            <option value="">Select Title</option>
                                            <option value="0" <c:if test="${user.title == '0'}"> <c:out value= "selected=selected"/></c:if>>Mr</option>
                                            <option value="1" <c:if test="${user.title == '1'}"> <c:out value= "selected=selected"/></c:if>>Mrs</option>
                                            <option value="3" <c:if test="${user.title == '3'}"> <c:out value= "selected=selected"/></c:if>>Dr</option>
                                            <option value="2" <c:if test="${user.title == '2'}"> <c:out value= "selected=selected"/></c:if>>Miss</option>
                                            <option value="4" <c:if test="${user.title == '4'}"> <c:out value= "selected=selected"/></c:if>>Prof</option>
                                        </select>
                                    </div>
                                </div>
                            </div>


                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-5"
                                               style="float: right;">First Name</label>
                                    </div>
                                    <div class="col-md-4">
                                        <input type="text" id="firstName" name="firstName"
                                               placeholder="Enter First Name" class="form-control"
                                               value="<c:out value="${user.firstName}" />"/>
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
                                        <input type="text" id="lastName" name="lastName"
                                               placeholder="Enter Last Name" class="form-control"
                                               value="<c:out value="${user.lastName}" />"/>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-5 style="
                                               style="float: right;">Gender</label>
                                    </div>
                                    <div class="col-md-4">
                                        <select name="gender" id="gender" class="form-control">
                                            <option value="">Select Gender</option>
                                            <option value="0" <c:if test="${user.gender == '0'}"> <c:out value= "selected=selected"/></c:if>>FEMALE</option>
                                            <option value="1" <c:if test="${user.gender == '1'}"> <c:out value= "selected=selected"/></c:if>>MALE</option>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-5"
                                               style="float: right;">Address</label>
                                    </div>
                                    <div class="col-md-4">
                                        <input type="text" id="address" name="address"
                                               placeholder="Enter Address" class="form-control"
                                               value="<c:out value="${user.address}" />"/>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-5"
                                               style="float: right;">Email</label>
                                    </div>
                                    <div class="col-md-4">
                                        <input type="email" id="email" name="email"
                                               placeholder="Enter Email" class="form-control"
                                               value="<c:out value="${user.email}" />"/>
                                    </div>
                                </div>
                            </div>



                            <div class="row">
                                <div class="form-group">

                                    <div class="col-md-4">
                                        <label class="control-label col-md-5"
                                               style="float: right;">Date of Birth</label>
                                    </div>
                                    <div class="col-md-4">
                                        <div id="sandbox-container">
                                            <div class="input-group date">
                                                <input type="text" id="dob" name="dob" class="form-control"
                                                       value="<c:out value="${user.dob}" />"><span
                                                    class="input-group-addon"><i
                                                    class="glyphicon glyphicon-th"></i></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>





                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-5 style="
                                               style="float: right;">User Role</label>
                                    </div>
                                    <div class="col-md-4">
                                        <select name="userRole" id="userRole" class="form-control">
                                            <option value="<c:out value="${userRole.id}" />">${userRole.name}</option>
                                            <%--<option value="${userReg.userRole}">Select User Role</option>--%>
                                            <c:forEach items="${userRoles}" var="temp">
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
                                               style="float: right;">Contact Number</label>
                                    </div>
                                    <div class="col-md-4">
                                        <input type="text" id="contactNo" name="contactNo"
                                               placeholder="Enter Contact Number" class="form-control"
                                               value="<c:out value="${user.contactNo}" />"/>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-5"
                                               style="float: right;">NIC</label>
                                    </div>
                                    <div class="col-md-4">
                                        <input type="text" id="nic" name="nic"
                                               placeholder="Enter NIC" class="form-control"
                                               value="<c:out value="${user.nic}" />"/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-5"
                                               style="float: right;">User Name</label>
                                    </div>
                                    <div class="col-md-4">
                                        <input type="text" id="userName" name="userName"
                                               placeholder="Enter User Name" class="form-control"
                                               value="<c:out value="${user.userName}" />"/>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-5"
                                               style="float: right;">Password</label>
                                    </div>
                                    <div class="col-md-4">
                                        <input type="text" id="password" name="password"
                                               placeholder="Enter password" class="form-control"
                                               value="<c:out value="${user.password}" />"/>
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
                                                   value="Save" class="btn btn-success btn-md " type="submit" >
                                            <input id="btn_reset" value="Reset"
                                                   class="btn btn-warning btn-md " type="reset"/> <a
                                                class="btn btn-danger btn-md"
                                                href="/user/">Cancel</a>
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

<script type="text/javascript">
    $(document).ready(function () {
        $(function() {
            formValidation();
        });
        $("#memberForm").submit(
            function (e) {
                e.preventDefault();
                if (!$("#memberForm").valid())
                    return false;
                var formData = getFormDataAsDTO("memberForm");
                $.ajax({
                    type: "POST",
                    url: "/member/save",
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
                                    window.location = "/member/";
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
<script>
    $('.date').datepicker({
        endDate: '-16y',
        startView: 1,
        clearBtn: true,
        calendarWeeks: true,
        autoclose: true,
        format: 'yyyy-mm-dd',
        todayHighlight: true
    });


</script>
</body>

<!-- END BODY -->
</html>
