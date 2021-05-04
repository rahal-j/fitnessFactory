<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="UTF-8"/>
    <title>Fitness Factory | Stocks </title>
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
                <li><a href="/stocks/insertPage">Add Stocks</a></li>
            </ul>
            <div class="row">


                <div class="col-lg-12">
                    <div class="box dark">
                        <header>
                            <div class="icons">
                                <i class="icon-glass"></i>
                            </div>
                            <h5>Enter Stocks Details</h5>
                        </header>


                        <form id="stocksForm" class="form-horizontal" align="center"
                              novalidate>

                            <div class="row page">
                                <div class="col-lg-12">
                                    <div class="box dark staticParent">

                                        <%--<div class="row">--%>
                                            <%--<div class="col-md-1 text-center">--%>
	<%--<span style="font-size:154px; font-family: Calibri; color:#455862; border-color:#DCFFFF; background-color:#DCFFFF;"><input--%>
            <%--readonly id="series_id" class="form-control hidden"--%>
            <%--name="series_id" value="${series_id}" id="inv_price0"--%>
            <%--type="text"/></span></div>--%>
                                        <%--</div>--%>
                                        <br/>
                                        <div class="row">
                                            <div class="col-md-4 text-center">
                                                <strong>Product</strong>
                                            </div>
                                            <div class="col-md-2 text-center">
                                                <strong>Expire Date</strong>
                                            </div>
                                            <div class="col-md-2 text-center">
                                                <strong>Batch No</strong>
                                            </div>
                                            <div class="col-md-1 text-center" id="">
                                                <strong>Qty</strong>
                                            </div>

                                            <div class="col-md-2 text-center">
                                                <strong></strong>
                                            </div>
                                        </div>
                                        <div class="inv_body">
                                            <div class="row inv_row" id="inv_row0">

                                                <div class="col-md-4 text-center" style="margin-left: 1%;">
                                                    <select name="product" id="inv_item0" class="form-control chzn-select inv_item keep" onchange="getbatch(this)">
                                                        <option value="<c:out value="${product.id}" />">${product.name}</option>
                                                        <%--<option value="${userReg.userRole}">Select User Role</option>--%>
                                                        <c:forEach items="${products}" var="temp">
                                                            <option value="<c:out value= "${temp.id}" />">${temp.name}</option>
                                                        </c:forEach>

                                                    </select>
                                                </div>
                                                <div class="col-md-2 text-center">
                                                    <div id="sandbox-container">
                                                        <div class="input-group date">
                                                            <input type="text"
                                                                   name="expireDate"
                                                                   id="expireDate0"
                                                                   class="form-control"><span
                                                                class="input-group-addon"><li
                                                                class="glyphicon glyphicon-th"></li></span>
                                                        </div>

                                                    </div>
                                                </div>
                                                <div class="col-md-2 text-center">
                                                    <input id="batch_no0" class="form-control"
                                                           name="batchNo" type="text"
                                                           value="<c:out value="${stocks.batchNo}" />"/>
                                                </div>
                                                <div class="col-md-1 form-group text-center " style="margin-left: 0%;">
                                                    <input class="form-control child" name="quantity" id="quantity0"
                                                           type="text"
                                                           value="<c:out value="${stocks.quantity}" />"/>
                                                </div>

                                                <div class="col-md-1 text-center" style="margin-left: 1.2%;">
                                               <%--     <button id="kmk" class="btn btn-danger  item_remove"
                                                            type="button">
                                                        <i class="icon-minus-sign"></i>
                                                    </button>--%>
                                                </div>

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
                                                            href="/stocks/">Cancel</a>
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

            var inv_row = $('<div class="row inv_row" id="inv_row'+index+'">'
                +'<div class="col-md-4 text-center" style="margin-left: 1%;">'
                + '<select id="inv_item'+index+'" name="product"'
                +	'class="form-control chzn-select inv_item keep"onchange="getbatch(this)">'
                +'</select>'
                +'</div>'
                +'<div class="col-md-2 text-center">'
                +	'<div id="sandbox-container">'
                +	'<div class="input-group date">'
                +		'<input type="text" placeholder="YYYY-MM-DD" name="expireDate"'
                +			'id="expireDate'+index+'" class="all form-control my_date"><span class="input-group-addon"><li class= "glyphicon glyphicon-th"></li></span>'
                +'	</div>'
                +	'<label for="expireDate" class="error"></label>'
                +'</div>'
                +'</div>'
                +'<div class="col-md-2 text-center">'
                +'<input readonly id="batch_no'+index+'" class="form-control"'
                +'name="batchNo" type="text" />'
                +'</div>'
                +'<div class="col-md-1 text-center ">'
                +'<input class="form-control child" name="quantity" id="quantity'+index+'"'
                +'type="text" />'
                +'</div>'
                +'<div class="col-md-1 text-center">'
                +'<button id="kmk" class="btn btn-danger  item_remove"'
                +'type="button">'
                +'<i class="icon-minus-sign"></i>'
                +'</button>'
                +'</div>'

                +'</div>');
            $(".inv_body").append(inv_row);





            $.ajax({
                type : "GET",
                url : "/stocks/productList",
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
        var quantities=[];
        var expiredates=[];
        var batchNos=[];
        var datesCreated=[];
        var i;
        for (i = 0; i <= count; i++) {
            products[i] = $("#inv_item"+i).val();
            quantities[i]= $("#quantity"+i).val();
            batchNos [i]=$("#batch_no"+i).val();
            datesCreated [i]=$("#dateCreated"+i).val();
            if($("#expireDate"+i).val() == undefined || $("#expireDate"+i).val() == ""){
                expiredates[i] = "" ;
            }else{
                expiredates[i]=$("#expireDate"+i).val();
            }

        }
        formData['products']= products;
        formData['quantities']= quantities;
        formData['expiredates']= expiredates;
        formData['batchNos']= batchNos;
        formData['datesCreated']= batchNos;
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


</script>>


<script type="text/javascript">
    $(document).ready(function () {
        $(function () {
            formValidation();
        });
        $("#stocksForm").submit(
            function (e) {
                e.preventDefault();
                if (!$("#stocksForm").valid())
                    return false;
                var formData = getFormDataAsDTO("stocksForm");
                $.ajax({
                    type: "POST",
                    url: "/stocks/save",
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
                                    window.location = "/stocks/";
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
</body>

<!-- END BODY -->
</html>
