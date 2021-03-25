<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="UTF-8"/>
    <title>Add new Class Room</title>
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
                <li><a href="dashboard.jsp">Home</a></li>
                <li><a href="ProductCon?action=insert">Add Class Rooms</a></li>
            </ul>
            <div class="row">
                <div class="col-lg-12">
                    <div class="box dark">
                        <header>
                            <div class="icons">
                                <i class="icon-glass"></i>
                            </div>
                            <h5>Enter Class Details</h5>
                        </header>

                        <form id="classRoomForm" class="form-horizontal" align="center"
                              novalidate>


                            </br>
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-5" style="float: right;">Class Room
                                            ID</label>
                                    </div>
                                    <div class="col-md-4">
                                        <input type="text" id="id" name="id"
                                               readonly="readonly" class="form-control"
                                               value="<c:out value="${room.id}" />"/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-5"
                                               style="float: right;">Name</label>
                                    </div>
                                    <div class="col-md-4">
                                        <input type="text" id="name" name="name"
                                               placeholder="Enter Class Name" class="form-control"
                                               value="<c:out value="${room.name}" />"/>
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
                                            <option value="ACTIVE" <c:if test="${room.status == 'ACTIVE'}"> <c:out value= "selected=selected"/></c:if>>ACTIVE</option>
                                            <option value="DEACTIVE" <c:if test="${room.status == 'DEACTIVE'}"> <c:out value= "selected=selected"/></c:if>>DEACTIVE</option>

                                           <%-- <option value="<c:out value='${room.status}'/>"><c:out value='${room.status}'/></option>
                                            <option value="c:out value='${room.status}'/>ACTIVE">ACTIVE</option>
                                            <option value="DEACTIVE">DEACTIVE</option>--%>
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
                                                href="/class/">Cancel</a>
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
        $("#classRoomForm").submit(
            function (e) {
                e.preventDefault();
                   if (!$("#classRoomForm").valid())
                    return false;
                var formData = getFormDataAsDTO("classRoomForm");
                $.ajax({
                    type: "POST",
                    url: "/class/addClassRoom",
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
                                    window.location = "/class/";
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


</body>

<!-- END BODY -->
</html>
