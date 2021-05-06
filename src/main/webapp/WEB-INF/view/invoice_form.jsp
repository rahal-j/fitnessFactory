<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="UTF-8"/>
    <title>Fitness Factory | Invoice </title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <%@include file="header_src.jsp" %>
    <link rel="stylesheet" href="../../resources/static/assets/css/bootstrap-select.min.css" />
    <link rel="stylesheet" href="../../resources/static/assets/plugins/chosen/chosen.min.css" />
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
                <li><a href="/invoice/insertPage">Add Invoice</a></li>
            </ul>
            <div class="row">


                <div class="col-lg-12">
                    <div class="box dark">
                        <header>
                            <div class="icons">
                                <i class="icon-glass"></i>
                            </div>
                            <h5>Enter Invoice Details</h5>
                        </header>

                        <br>


                        <form id="invoiceForm" class="form-horizontal" align="center"
                              novalidate>
                            <div class="row">
                                <div class="form-group">
                                    <label class="control-label col-md-4">Customer Type</label>

                                    <div class="col-md-8">
                                        <div class="checkbox">
                                            <label> <input class="uniform cus_type" type="radio"
                                                           name="cus_type" value="rg" /> Registered User
                                            </label> &nbsp;<label> <input class="uniform cus_type"
                                                                          type="radio" name="cus_type" value="un_rg"
                                                                          checked="checked" /> Other
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
                                               value="<c:out value="${invoice.name}" />"/>
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
                                        <label class="control-label col-md-5 style="
                                               style="float: right;">Title</label>
                                    </div>
                                    <div class="col-md-4">
                                        <select name="title" id="title" class="form-control">
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
                                        <input type="text" id="firstName" name="firstName"
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
                                        <input type="text" id="lastName" name="lastName"
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
                                        <input type="email" id="email" name="email"
                                               placeholder="Enter Email" class="form-control"
                                               value=""/>
                                    </div>
                                </div>
                            </div>

                            <br/>
                            <div class="row page">
                                <div class="col-lg-12">
                                    <div class="box dark staticParent">

                                        <br/>
                                        <div class="row">
                                            <div class="col-md-3 text-center">
                                                <strong>Product</strong>
                                            </div>
                                            <div class="col-md-2 text-center">
                                                <strong>Unit Price</strong>
                                            </div>
                                            <div class="col-md-2 text-center">
                                                <strong>Available Quantity</strong>
                                            </div>
                                            <div class="col-md-1 text-center">
                                                <strong>Quantity</strong>
                                            </div>
                                            <div class="col-md-2 text-center" id="">
                                                <strong>Sub Total</strong>
                                            </div>

                                            <div class="col-md-2 text-center">
                                                <strong></strong>
                                            </div>
                                        </div>
                                        <div class="inv_body">
                                            <div class="row inv_row" id="inv_row0">

                                                <div class="col-md-3 text-center" style="margin-left: 1%;">
                                                    <select name="product" id="inv_item0" class="form-control chzn-select inv_item keep" onchange="getbatch(this)">
                                                        <option value="<c:out value="${product.id}" />">${product.name}</option>
                                                        <%--<option value="${userReg.userRole}">Select User Role</option>--%>
                                                        <c:forEach items="${products}" var="temp">
                                                            <option value="<c:out value= "${temp.id}" />">${temp.name}</option>
                                                        </c:forEach>

                                                    </select>
                                                </div>
                                                <div class="col-md-2 text-center">
                                                    <input id="unitPrice0" class="form-control"
                                                           name="unitPrice" type="text"
                                                           value="<c:out value="${invoice.unitPrice}" />"/>
                                                </div>
                                                <div class="col-md-2 form-group text-center " style="margin-left: 0%;">
                                                    <input class="form-control child" name="availableQuantity" id="availableQuantity0"
                                                           type="text"
                                                           value="<c:out value="${invoice.availableQuantity}" />"/>
                                                </div>
                                                <div class="col-md-1 form-group text-center " style="margin-left: 0%;">
                                                    <input class="form-control child" name="quantity" id="quantity0"
                                                           type="text"
                                                           value="<c:out value="${invoice.quantity}" />"/>
                                                </div>

                                                <div class="col-md-2 text-center">
                                                    <input id="subTotal0" class="form-control"
                                                           name="batchNo" type="text"
                                                           value="<c:out value="${invoice.subTotal}" />"/>
                                                </div>

                                                <%--<div class="col-md-1 text-center" style="margin-left: 1.2%;">--%>
                                                         <%--<button id="kmk" class="btn btn-danger  item_remove"--%>
                                                                 <%--type="button">--%>
                                                             <%--<i class="icon-minus-sign"></i>--%>
                                                         <%--</button>--%>
                                                <%--</div>--%>

                                            </div>

                                        </div>

                                        <div class="row">
                                            <div class="col-md-6"></div>

                                            <div class="col-md-2 pull-right">
                                                <button id="add-item" class="btn btn-info" type="button">
                                                    <i class="icon-plus-sign"></i>
                                                </button>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="form-actions no-margin-bottom"
                                                 style="text-align: center;">
                                                <div class="col-sm-3"></div>
                                                <div class="col-sm-5">
                                                    <div>
                                                        <input id="btn_save"
                                                               value="Save" class="btn btn-success btn-md " type="submit" >
                                                        <input id="btn_reset" value="Reset"
                                                               class="btn btn-warning btn-md " type="reset"/> <a
                                                            class="btn btn-danger btn-md"
                                                            href="/invoice/">Cancel</a>
                                                    </div>

                                                </div>
                                            </div>
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

<script>
    $('#btn_search').click(function() {

        var searchId = $("#searchNic").val();


        var url1;
        url1 = "/invoice/searchMember?nic="+searchId;

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

<script src="../../resources/static/assets/plugins/chosen/chosen.jquery.min.js"></script>


<script>

    $(function() {
        formValidation();
        noLetter();
    });
    $(function() {
        /*----------- BEGIN chosen CODE -------------------------*/

        $(".chzn-select").chosen();
        $(".chzn-select-deselect").chosen({
            allow_single_deselect : false

        });
        /*----------- END chosen CODE -------------------------*/
    });
</script>
<script>
    $(function() {
        formValidation();
        noLetter();
    });
    $(function() {
        /*----------- BEGIN chosen CODE -------------------------*/

        $(".chzn-select").chosen();
        $(".chzn-select-deselect").chosen({
            allow_single_deselect : false

        });
        /*----------- END chosen CODE -------------------------*/
    });
</script>
<script>
    $(document).ready(function () {


        $(".chzn-select").prop('disabled', false).trigger('chosen:updated');

        var index = 1;
        $('#add-item').click(function(e){
            e.preventDefault();

            var inv_row = $('   <div class="row inv_row" id="inv_row'+index+'">\n' +
                '\n' +
                '                                                <div class="col-md-3 text-center" style="margin-left: 1%;">\n' +
                '                                                    <select name="product" id="inv_item'+index+'" class="form-control chzn-select inv_item keep" onchange="getbatch(this)">\n' +
                '                                                        <option value="<c:out value="${product.id}" />">${product.name}</option>\n' +
                '                                                        <%--<option value="${userReg.userRole}">Select User Role</option>--%>\n' +
                '                                                        <c:forEach items="${products}" var="temp">\n' +
                '                                                            <option value="<c:out value= "${temp.id}" />">${temp.name}</option>\n' +
                '                                                        </c:forEach>\n' +
                '\n' +
                '                                                    </select>\n' +
                '                                                </div>\n' +
                '                                                <div class="col-md-2 text-center">\n' +
                '                                                    <input id="unitPrice'+index+'" class="form-control"\n' +
                '                                                           name="unitPrice" type="text"\n' +
                '                                                           value="<c:out value="${invoice.unitPrice}" />"/>\n' +
                '                                                </div>\n' +
                '                                                <div class="col-md-2 form-group text-center " style="margin-left: 0%;">\n' +
                '                                                    <input class="form-control child" name="availableQuantity" id="availableQuantity'+index+'"\n' +
                '                                                           type="text"\n' +
                '                                                           value="<c:out value="${invoice.availableQuantity}" />"/>\n' +
                '                                                </div>\n' +
                '                                                <div class="col-md-1 form-group text-center " style="margin-left: 0%;">\n' +
                '                                                    <input class="form-control child" name="quantity" id="quantity'+index+'"\n' +
                '                                                           type="text"\n' +
                '                                                           value="<c:out value="${invoice.quantity}" />"/>\n' +
                '                                                </div>\n' +
                '\n' +
                '                                                <div class="col-md-2 text-center">\n' +
                '                                                    <input id="subTotal'+index+'" class="form-control"\n' +
                '                                                           name="subTotal" type="text"\n' +
                '                                                           value="<c:out value="${invoice.subTotal}" />"/>\n' +
                '                                                </div>\n' +
                '\n' +
                '                                                <div class="col-md-1 text-center" style="margin-left: 1.2%;">\n' +
                '                                                         <button id="kmk" class="btn btn-danger  item_remove"\n' +
                '                                                                 type="button">\n' +
                '                                                             <i class="icon-minus-sign"></i>\n' +
                '                                                         </button>\n' +
                '                                                </div>\n' +
                '\n' +
                '                                            </div>');
            $(".inv_body").append(inv_row);





            $.ajax({
                type : "GET",
                url : "/invoice/productList",
                dataType : "json",
                beforeSend : function(xhr) {
                    $("#inv_item"+ index).empty();
                },
                success : function(data) {
                    var div_data = "<option></option>";
                    $(div_data).appendTo("#inv_item"+index);
                    $.each(data.data, function(i, obj) {
                        div_data = "<option value=" + obj.id + ">"
                            + obj.name + "</option>";
                        $(div_data).appendTo("#inv_item"+index);
                    });
                    $("#inv_item"+index).chosen().trigger("chosen:updated");
                    index++;
                }
            });

        });


    });

    $('.inv_body').on('click', '#kmk', function() {
        this.closest(".inv_row").remove();

    });

    function getFormDataAsDTO(formId) {
        var formElement = $('form#' + formId);
        var formData = new Object();
        /*  var formDataArray = formElement.serializeArray();
          $.each(formDataArray, function (i, obj) {
              formData[obj.name] = obj.value;

          })*/


        var count = Number($("[id^='inv_row']").last().attr('id').replace("inv_row", ""));
        var products =[];
        var unitPrices =[];
        var availableQuantities=[];
        var quantities=[];
        var subTotals=[];
        var i;
        for (i = 0; i <= count; i++) {
            products[i] = $("#inv_item"+i).val();
            unitPrices[i]= $("#unitPrice"+i).val();
            availableQuantities [i]=$("#availableQuantity"+i).val();
            quantities [i]=$("#quantity"+i).val();
            subTotals [i]=$("#subTotal"+i).val();


        }
        formData['products']= products;
        formData['unitPrices']= unitPrices;
        formData['availableQuantities']= availableQuantities;
        formData['quantities']= quantities;
        formData['subTotals']=subTotals;
        formData['memberId']= $('#searchNic').val();

        return JSON.stringify(formData);
    }














</script>


<script>

    function getbatch(t){
        var id_ = t.id;

        var id = $("#"+id_).val();
        var index_no = id_.substring(8,10);
        $.ajax({
            type : "GET",
            url : "/invoice/getStockDetails?id="+id,
            dataType : "json",
            success : function(data) {

                $('#batch_no'+index_no).attr('readonly', true);
                $('#batch_no'+index_no).val(data.data.batchNo);
                if(data.data.isExpire == 0){
                    $('#expireDate'+index_no).attr('readonly', true);

                }else{
                    $('#expireDate'+index_no).attr('readonly', false);

                }


            }
        });

    }


</script>>


<script type="text/javascript">
    $(document).ready(function () {
        $(function () {
            formValidation();
        });
        $("#invoiceForm").submit(
            function (e) {
                e.preventDefault();
                if (!$("#invoiceForm").valid())
                    return false;
                var formData = getFormDataAsDTO("invoiceForm");
                $.ajax({
                    type: "POST",
                    url: "/invoice/save",
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
                                    window.location = "/invoice/";
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


    /*   function getFormDataAsDTO(formId) {
           var formElement = $('form#' + formId);
           var formData = new Object();
           var formDataArray = formElement.serializeArray();
           $.each(formDataArray, function (i, obj) {
               formData[obj.name] = obj.value;
           });
           return JSON.stringify(formData);
       }*/
</script>


<script>

    function getbatch(t){
        var id_ = t.id;

        var id = $("#"+id_).val();
        var index_no = id_.substring(8,10);
        $.ajax({
            type : "GET",
            url : "/stocks/getBatchNo?id="+id,
            dataType : "json",
            success : function(data) {

                $('#batch_no'+index_no).attr('readonly', true);
                $('#batch_no'+index_no).val(data.data.batchNo);
                if(data.data.isExpire == 0){
                    $('#expireDate'+index_no).attr('readonly', true);

                }else{
                    $('#expireDate'+index_no).attr('readonly', false);

                }


            }
        });

    }


</script>
</body>

<!-- END BODY -->
</html>
