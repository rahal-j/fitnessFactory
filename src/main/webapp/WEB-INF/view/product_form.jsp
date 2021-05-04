<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="UTF-8"/>
    <title>Fitness Factory | Products </title>
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
                <li><a href="/product/insertPage">Add Product</a></li>
            </ul>
            <div class="row">


                <div class="col-lg-12">
                    <div class="box dark">
                        <header>
                            <div class="icons">
                                <i class="icon-glass"></i>
                            </div>
                            <h5>Enter Product Details</h5>
                        </header>






                        <form id="productForm" class="form-horizontal" align="center"
                              novalidate>


                            </br>
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-5" style="float: right;"> Product ID</label>
                                    </div>
                                    <div class="col-md-4">
                                        <input type="text" id="id" name="id"
                                               readonly="readonly" class="form-control"
                                               value="<c:out value="${product.id}" />"/>
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
                                               placeholder="Enter Product Name" class="form-control"
                                               value="<c:out value="${product.name}" />"/>
                                    </div>
                                </div>
                            </div>


                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-5 style="
                                               style="float: right;">Is Expire</label>
                                    </div>
                                    <div class="col-md-4">
                                        <select name="isExpire" id="isExpire" class="form-control">
                                            <option value="">Is Expire</option>
                                            <option value="1" <c:if test="${product.isExpire == '1'}"> <c:out value= "selected=selected"/></c:if>>Yes</option>
                                            <option value="0" <c:if test="${product.isExpire == '0'}"> <c:out value= "selected=selected"/></c:if>>No</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-5"
                                               style="float: right;">Buying Price</label>
                                    </div>
                                    <div class="col-md-4">
                                        <input type="text" id="buyingPrice" name="buyingPrice"
                                               placeholder="Enter Buying Price" class="form-control"
                                               value="<c:out value="${product.buyingPrice}" />"/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-5"
                                               style="float: right;">Selling Price</label>
                                    </div>
                                    <div class="col-md-4">
                                        <input type="text" id="sellingPrice" name="sellingPrice"
                                               placeholder="Enter selling Price" class="form-control"
                                               value="<c:out value="${product.sellingPrice}" />"/>
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
                                        <select name="status" id="subscriptionStatus" class="form-control">
                                            <option value="">Select Status</option>
                                            <option value="ACTIVE" <c:if test="${product.status == 'ACTIVE'}"> <c:out
                                                    value="selected=selected"/></c:if>>ACTIVE
                                            </option>
                                            <option value="DEACTIVE" <c:if test="${product.status == 'DEACTIVE'}">
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
                                                href="/product/">Cancel</a>
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
        $("#productForm").submit(
            function (e) {
                e.preventDefault();
                if (!$("#productForm").valid())
                    return false;
                var formData = getFormDataAsDTO("productForm");
                $.ajax({
                    type: "POST",
                    url: "/product/save",
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
                                    window.location = "/product/";
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
