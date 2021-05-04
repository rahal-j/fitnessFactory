<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="UTF-8"/>
    <title>Fitness Factory | Payment </title>
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
                <li><a href="/payment">Payment</a></li>
                <li><a href="/payment/insertPage">Add Payment</a></li>
            </ul>
            <div class="row">


                <div class="col-lg-12">
                    <div class="box dark">
                        <header>
                            <div class="icons">
                                <i class="icon-glass"></i>
                            </div>
                            <h5>Enter Payment Details</h5>
                        </header>

                        <form id="paymentForm" class="form-horizontal" align="center"
                              novalidate>


                            </br>
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-5"
                                               style="float: right;">Search Member</label>
                                    </div>
                                    <div class="col-md-4">
                                        <input type="text" id="searchNic" name="searchNic"
                                               placeholder="Enter Member's NIC" class="form-control"
                                               value="<c:out value="${payment.name}" />"/>
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
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-5" style="float: right;"> Payment ID</label>
                                    </div>
                                    <div class="col-md-4">
                                        <input type="text" id="id" name="id"
                                               readonly="readonly" class="form-control"
                                               value="<c:out value="${payment.id}" />"/>
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
                                        <select name="title" id="title" class="form-control"  readonly="readonly">
                                            <option value="">Select Title</option>
                                            <option value="0" >Mr</option>
                                            <option value="1" >Mrs</option>
                                            <option value="2" >Miss</option>
                                            <option value="3" >Dr</option>
                                            <option value="4" >Prof</option>
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
                                        <input type="text" id="firstName" name="firstName"  readonly="readonly"
                                               placeholder="Enter First Name" class="form-control"
                                               value=""/>
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
                                        <input type="text" id="lastName" name="lastName"  readonly="readonly"
                                               placeholder="Enter Last Name" class="form-control"
                                               value=""/>
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
                                        <input type="email" id="email" name="email"  readonly="readonly"
                                               placeholder="Enter Email" class="form-control"
                                               value=""/>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group">

                                    <div class="col-md-4">
                                        <label class="control-label col-md-5"
                                               style="float: right;">Membership Expire date</label>
                                    </div>
                                    <div class="col-md-4">
                                        <div id="sandbox-container">
                                            <div class="input-group date">
                                                <input type="text" id="expireDate" name="expireDate" class="form-control"
                                                       value="<c:out value="${payment.expireDate}" />"><span
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
                                               style="float: right;">Subscription</label>
                                    </div>
                                    <div class="col-md-4">
                                        <select name="subscription" id="subscription" class="form-control">
                                            <option value="<c:out value="${subscription.id}" />">${subscription.name}</option>
                                            <%--<option value="${userReg.userRole}">Select User Role</option>--%>
                                            <c:forEach items="${subscriptions}" var="temp">
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
                                               style="float: right;">New Subscription date</label>
                                    </div>
                                    <div class="col-md-4">
                                        <div id="sandbox-container">
                                            <div class="input-group date">
                                                <input type="text" id="subscriptionDate" name="subscriptionDate" class="form-control"
                                                       value="<c:out value="${payment.subscriptionDate}" />"><span
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
                                        <label class="control-label col-md-5"
                                               style="float: right;">Amount</label>
                                    </div>
                                    <div class="col-md-4">
                                        <input type="text" id="amount" name="amount"
                                               placeholder="Amount paid in Rupees" class="form-control"
                                               value="<c:out value="${payment.amount}" />"/>
                                    </div>
                                </div>
                            </div>


                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-5"
                                               style="float: right;">Created user name</label>
                                    </div>
                                    <div class="col-md-4">
                                        <input type="text" id="createdUserName" name="createdUserName"
                                               placeholder="Created User Name" class="form-control"
                                               value="<c:out value="${payment.createdUserName}" />"/>
                                    </div>
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
                                            <option value="ACTIVE" <c:if test="${payment.status == 'ACTIVE'}"> <c:out
                                                    value="selected=selected"/></c:if>>ACTIVE
                                            </option>
                                            <option value="DEACTIVE" <c:if test="${payment.status == 'DEACTIVE'}">
                                                <c:out value="selected=selected"/></c:if>>DEACTIVE
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
                                                href="/payment/">Cancel</a>
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
        $("#paymentForm").submit(
            function (e) {
                e.preventDefault();
                if (!$("#paymentForm").valid())
                    return false;
                var formData = getFormDataAsDTO("paymentForm");
                $.ajax({
                    type: "POST",
                    url: "/payment/save",
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
                                    window.location = "/payment/";
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

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.standalone.css">

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.js">
</script>

<script>

    $('#sandbox-container .input-group.date').datepicker({

        format: 'dd/mm/yyyy',
        startView: 1,
        clearBtn: true,
        calendarWeeks: true,
        autoclose: true,
        todayHighlight: true
    });

</script>
<script>
    $('#btn_search').click(function() {









        var searchId = $("#searchNic").val();


        var url1;
        url1 = "/payment/searchMember?nic="+searchId;

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
                        }),
                        $("#firstName").val(data.data.firstName);
                        $("#lastName").val(data.data.lastName);
                        $("#email").val(data.data.email);
                        $("#title").val(data.data.title);


/*
                        function () {
                            window.location = "/subscription/";
                        });
*/
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
