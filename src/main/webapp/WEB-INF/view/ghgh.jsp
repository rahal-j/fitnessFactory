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
            <ul class="breadcrumb" style="margin-top:1%;">
                <li><a href="dashboard.jsp">Dashboard</a></li>
                <li><a href="InvoiceCon?action=insert">Sell Products</a></li>
            </ul>

            <form id="invoiceForm" class="form-horizontal" align="center"
                  method="post" action="InvoiceCon" novalidate>
                <div class="row" style="margin-top:-1%;">
                    <div class="col-lg-12">
                        <div class="box dark">
                            <header>
                                <div class="icons">
                                    Sell Products
                                </div>

                            </header>



                            </br>
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
                                        <label style="float: right;"> User ID </label>
                                    </div>
                                    <div class="col-md-4">
                                        <select name="user_id" class="form-control chzn-select"
                                                id="user_id">
                                            <option></option>
                                        </select>
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
                                        <input type="text" id="b_name" name="b_name"
                                               placeholder="Buyers Name" class="form-control" value="" />
                                    </div>


                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label  class="control-label col-md-5"
                                               style="float: right;">E-mail</label>
                                    </div>
                                    <div class="col-md-4">
                                        <input type="text" id="email" name="email"
                                               placeholder="Enter contact e-mail" class="form-control" />

                                    </div>
                                </div>
                            </div>


                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-12">
                        <div class="box dark staticParent">
                            <header>
                                <div class="icons">

                                </div>
                                <div class="col-md-2 text-center">
                                    <input readonly id="invoice_id" class="form-control"
                                           name="invoice_id" value="${invoice_id}" id="inv_price0"
                                           type="hidden" />
                                </div>
                            </header>

                            <br/>
                            <div class="row">
                                <div class="col-md-4 text-center">
                                    <strong>Item</strong>
                                </div>
                                <div class="col-md-1 text-center">
                                    <strong>Std. Price</strong>
                                </div>
                                <div class="col-md-1 text-center">
                                    <strong>Unit</strong>
                                </div>
                                <div class="col-md-1 text-center" >
                                    <strong>Qty</strong>
                                </div>
                                <div class="col-md-1 text-center" >
                                    <strong>Stock</strong>
                                </div>
                                <div class="col-md-2 text-center">
                                    <strong>Sub total</strong>
                                </div>
                                <div class="col-md-2 text-center">
                                    <strong></strong>
                                </div>
                            </div>
                            <div class="inv_body">
                                <div class="row inv_row" id="inv_row0">
                                    <div class="col-md-4 text-center" style="margin-left:1%;">
                                        <select name="product" id="inv_item0" class="form-control chzn-select inv_item keep">
                                            <option value="<c:out value="${product.id}" />">${product.name}</option>
                                            <%--<option value="${userReg.userRole}">Select User Role</option>--%>
                                            <c:forEach items="${products}" var="temp">
                                                <option value="<c:out value= "${temp.id}" />">${temp.name}</option>
                                            </c:forEach>

                                        </select>
                                    </div>
                                    <div class="col-md-1 text-center" id="price">
                                        <input readonly id="inv_price0"
                                               class="form-control inv_price" name="inv_price" style="text-align: right"
                                               id="inv_price0" type="text" />
                                    </div>
                                    <div class="col-md-1 text-center" id="unit">
                                        <input readonly id="inv_unit0" class="form-control inv_unit"
                                               name="inv_unit" type="text" />
                                    </div>
                                    <div class="col-md-1 text-center" id="quantity">
                                        <input class="form-control child purchase" name="inv_qty"
                                               id="inv_qty0" type="text" />
                                    </div>
                                    <div class="col-md-1 text-center" id="stockOnHand">
                                        <input readonly="readonly" class="form-control stock" name="stock"
                                               id="stock0" type="text" />
                                    </div>
                                    <div class="col-md-2 text-center" id="subTotal">
                                        <input class="form-control" name="inv_sub_total"
                                               id="inv_sub_total0" readonly="readonly" type="text"
                                               style="text-align: right;" />
                                    </div>
                                    <div class="col-md-1 text-center">
                                        <button id="kmk" class="btn btn-danger  item_remove"
                                                type="button"><i class="icon-minus-sign"></i></button>
                                    </div>
                                </div>



                            </div>

                            <br/>
                            <div class="row">
                                <div class="col-md-6"></div>

                                <div class="col-md-2 pull-right">
                                    <button id="add-item" class="btn btn-info" type="button">
                                        <i class="icon-plus-sign"></i>
                                    </button>
                                </div>
                            </div><br/>


                        </div>
                    </div>
                </div>

                <!-- 	DIscount & Submitting form -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="box dark">


                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-8">
                                        <label for="text1" class="control-label col-md-5"
                                               style="float: right;">Total <em style="color: red;">(Rs.)</em></label>

                                    </div>
                                    <div class="col-md-2 text-center">
                                        <input readonly placeholder="Total" type="text" id="total"
                                               name="total" style="text-align: right;" class="form-control">
                                    </div>
                                </div>
                            </div>

                            <div class="row ">
                                <div class="form-group">
                                    <div class="col-md-8">
                                        <label for="text1" class=" col-md-0"
                                               style="float: right;">Discount<span>%</span></label>
                                    </div>
                                    <div class="col-md-1">
                                        <div class="input-group pull-right discount">
                                            <input class="form-control child" type="number" id="disc"
                                                   name="disc" value="0" />
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-8">
                                        <label for="text1" class="control-label col-md-5"
                                               style="float: right;">Vat%</label>
                                    </div>
                                    <div class="col-md-1 vatc">
                                        <div class="input-group pull-right vat">
                                            <input type="text" id="vat" name="vat" readonly="readonly"
                                                   class="form-control" value="${vat_val}" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-8">
                                        <label for="text1" class="control-label col-md-5"
                                               style="float: right;">Invoiced Total <em style="color: red;">(Rs.)</em></label>

                                    </div>
                                    <div class="col-md-2 text-center">
                                        <input readonly placeholder="Invoiced Total" type="text"
                                               name="invoiced_tot" id="invoiced_total"
                                               style="text-align: right;" class="form-control">
                                    </div>
                                </div>
                            </div>


                            <br />
                            <div class="row">
                                <div class="form-actions no-margin-bottom"
                                     style="text-align: center;">
                                    <div class="col-sm-6"></div>
                                    <div class="col-sm-6">
                                        <!-- <div>
                                            <input style="left: 80%; width: 10%;" id="btn_save"
                                                value="Save" class="btn btn-primary " type="submit">
                                            <input id="btn_reset" value="Reset" style="width: 10%;"
                                                class="btn btn-warning " type="reset" /> <a
                                                class="btn btn-success " style="width: 10%;"
                                                href="ProductCon?action=list">Cancel</a>
                                        </div> -->


                                    </div>
                                </div>
                            </div>
                            <div class="row" style="text-align: center;">


                                <div class="col-md-6"></div>
                                <div class="col-md-6">
                                    <button class="btn btn-primary prcd" data-toggle="modal"
                                            data-target="#formModal">Proceed to Payments</button>
                                </div>

                                <!-- 	Payment modal  -->
                                <div class="col-md-12">
                                    <div class="modal fade" id="formModal" tabindex="-1"
                                         role="dialog" aria-labelledby="myModalLabel"
                                         aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">

                                                <div id="tabs" style="border: 0px solid #ffffff;">
                                                    <div class="modal-header">
                                                        <ul style = "background: #d9edf7">
                                                            <li><a href="#cash">Cash</a></li>
                                                            <li><a href="#credit">Credit Card</a></li>
                                                            <li class="three"><a href="#subs">Add to Subscription</a></li>
                                                        </ul>
                                                    </div>
                                                    <div class="modal-body">
                                                        <!-- 	// starts here  -->

                                                        <!-- 	<h1>
                                                                id of selected tab: <span id="idDisplay">cash</span>
                                                            </h1> -->


                                                        <div id="cash">

                                                            <div class="row">
                                                                <div class="col-md-6">
                                                                    <label style="margin-left:-2%;">Full Amount(Rs.):</label>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <input readonly placeholder="Total" type="text"
                                                                           id="pay_total" style="text-align: right;"
                                                                           class="form-control">
                                                                </div>
                                                            </div>

                                                        </div>
                                                        <div id="credit">
                                                            <div class="row">
                                                                <div class="col-md-4">
                                                                    <div class="checkbox">
                                                                        <label> <input class="uniform" type="radio"
                                                                                       value="amex" name="card" checked="checked" /> <img
                                                                                src="${pageContext.request.contextPath}/logo/amex.gif" />
                                                                        </label>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-4">
                                                                    <div class="checkbox">
                                                                        <label> <input class="uniform" type="radio"
                                                                                       value="visa" name="card" /> <img
                                                                                src="${pageContext.request.contextPath}/logo/visa.gif" />
                                                                        </label>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-4">
                                                                    <div class="checkbox">
                                                                        <label> <input class="uniform" type="radio"
                                                                                       value="master" name="card" /> <img
                                                                                src="${pageContext.request.contextPath}/logo/master.gif" />
                                                                        </label>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            </br></br>
                                                            <div class="row">
                                                                <div class=" col-md-5" style="margin-top:2%;">
                                                                    <span class="label label-success" style="padding: 6px;">First 4 Digits last 4 digits of the Card</span>
                                                                </div>
                                                                <div class="col-md-3" style="margin-left:7%;">
                                                                    <input class="form-control autotab f4"
                                                                           style="margin-left:5%;" type="text" maxlength="4" value ="0000" placeholder="Card No"
                                                                           name="f4"  tabindex="11" />
                                                                </div>
                                                                <div class="col-md-3" style="margin-left:0%;">
                                                                    <input class="form-control autotab l4"
                                                                           style="" type="text" maxlength="4"placeholder="Card No" value="1111"
                                                                           name="l4"  tabindex="12" />
                                                                </div>


                                                            </div>
                                                            </br>
                                                            <div class="row">
                                                                <div class="form-group">
                                                                    <div class="col-lg-5 col-md-5 col-sm-5" style="margin-top:1%;" >
                                                                        <label>Choose a Bank:</label>
                                                                    </div>
                                                                    <div class="col-md-5" style="margin-left: 8%;">
                                                                        <select style="width: 60%;"
                                                                                data-placeholder="Your Favorite Type of Bear"
                                                                                class="form-control select-picker bank_drop"
                                                                                data-live-search="true" tabindex="-1"
                                                                                name="bank_name">
                                                                            <option selected="selected">Commercial Bank</option>
                                                                            <option>Sampath Bank</option>
                                                                            <option>HSBC Bank</option>
                                                                            <option>Nations Trust Bank</option>
                                                                            <option>HNB Bank</option>

                                                                        </select>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row" style="margin-top:4%;">
                                                                <div class="col-md-5" style="padding-bottom: 10px;">
                                                                    <label>Full Amount(Rs.):</label>
                                                                </div>
                                                                <div class="col-md-5" style="padding-bottom: 10px; margin-left: 8%;">
                                                                    <input class="form-control" value="" id="total_credit_payment" name="total_credit_payment" style="text-align: right;" type="text" readonly />
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div id="subs">
                                                            <div class="row">
                                                                <div class="col-md-5" style="margin-top:1%;" >
                                                                    <label>Supplement Credit:</label>
                                                                </div>
                                                                <div class="col-md-4" style="margin-left: 9%;">
                                                                    <input readonly placeholder="Total fee" type="text"
                                                                           id="fee_total" style="text-align: right;"
                                                                           name="fee_total" class="form-control">
                                                                </div>
                                                            </div>
                                                        </div>



                                                        <!-- 	// ends here  -->
                                                        <!-- <div class="body"></div> -->
                                                    </div>
                                                </div>

                                                <div class="modal-footer">
                                                    <input type="hidden" id="payment_type" value="cash"
                                                           name="payment_type" />

                                                    <button type="button" class="btn btn-default"
                                                            data-dismiss="modal">Close</button>
                                                    <button class="btn btn-primary " type="submit">Check Out</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- End payment modal -->
                            </div>
                        </div>
                    </div>
                </div>
            </form>
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
        $("#subscriptionForm").submit(
            function (e) {
                e.preventDefault();
                if (!$("#subscriptionForm").valid())
                    return false;
                var formData = getFormDataAsDTO("subscriptionForm");
                $.ajax({
                    type: "POST",
                    url: "/subscription/save",
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
                                    window.location = "/subscription/";
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
    $.ajax({
        type : "GET",
        url : "InvoiceCon?action=products",
        dataType : "json",
        beforeSend : function(xhr) {
            $("#inv_item0").empty();
        },
        success : function(data) {
            var div_data = "<option></option>";
            $(div_data).appendTo("#inv_item0");
            $.each(data.record, function(i, obj) {
                div_data = "<option value=" + obj.productID + ">"
                    + obj.description + "</option>";
                $(div_data).appendTo("#inv_item0");
            });
            $("#inv_item0").chosen().trigger("chosen:updated");
        }
    });
    $(document).ready(function() {
        $(".chzn-select").prop('disabled', false).trigger('chosen:updated');
        var index = 1;
        $("#add-item").click(function(e) {

            e.preventDefault();


            var inv_row = $('<div id="inv_row'+index+'"  class="row inv_row" style="margin-top:8px">'
                + '<div class="col-md-4 text-center" style="margin-left:1%;">'
                + '<select id="inv_item'+index+'" name="inv_item"  class=" keep form-control chzn-select inv_item">'
                + '<option></option>'
                + '</select>'
                + '</div>'
                + '<div class="col-md-1 text-center">'
                + '<input readonly class="form-control t_row" name="inv_price" id="inv_price'+index+'" type="text" />'
                + '</div>'
                + '<div class="col-md-1 text-center">'
                + '<input readonly class="form-control" name="inv_unit" id ="inv_unit'+index+'" type="text" />'
                + '</div>'
                + '<div class="col-md-1 text-center">'
                + '<input class="form-control child purchase" name="inv_qty" id = "inv_qty'+index+'" type="text" />'
                + '</div>'
                + '<div class="col-md-1 text-center">'
                + '<input readonly="readonly" class="form-control stock" name="stock" id = "stock'+index+'" type="text" />'
                + '</div>'
                + '<div class="col-md-2 text-center">'
                + '<input class="form-control" readonly="readonly" name="inv_sub_total" id="inv_sub_total'+index+'" type="text" style="text-align: right;" />'
                + '</div>'
                + '<div class="col-md-1 text-center">'
                + '<button  class="btn btn-danger item_remove" id = "kmk" type="button"><i class="icon-minus-sign"></i></button>'
                + '</div>' + '</div>');


            var inv_qty=$("[id^='inv_qty']").last().val();
            var line_id = $("[id^='inv_qty']").last().attr('id');
            var cur_id = line_id.replace("inv_qty", "");
            //alert(cur_id);
            if(inv_qty == ""){
                $('#inv_qty'+cur_id).popover({
                    //  title: 'Warning!',
                    content: 'Value can not be empty',
                    placement: 'bottom',
                    color: '#df6262'
                }).popover('show');
            }else{
                $('#inv_qty'+cur_id).popover('destroy');
                $(".inv_body").append(inv_row).show('slow');

                $.ajax({
                    type : "GET",
                    url : "InvoiceCon?action=products",
                    dataType : "json",
                    beforeSend : function(
                        xhr) {
                        $("#inv_item"+ index).empty();
                    },
                    success : function(data) {
                        var div_data = "<option></option>";
                        $(div_data).appendTo("#inv_item"+ index);
                        $.each(data.record,function(i,obj) {
                            div_data = "<option value=" + obj.productID + ">"
                                + obj.description
                                + "</option>";
                            $(div_data).appendTo("#inv_item"+ index);
                            var end=$(".inv_item").last().attr("id").replace("inv_item","");

                            for(i=0; i<end;i++){
                                var option=$("#inv_item"+i).val();
                                if(option==obj.productID){
                                    $("#inv_item"+index+" option[value='"+option+"']").remove();
                                }
                            }


                        });

                        $("#inv_item"+ index).chosen().trigger("chosen:updated");
                        index++;
                    }

                });
            }


        });//END (add-item)

        $('.inv_body').on('click', '#kmk', function() {
            this.closest(".inv_row").remove();
            totalCal();

        });
        // to hide sub non registered members
        $('.prcd').on('click',function(){
            var cus_type;
            var res = $('input[name=cus_type]:checked').val();

            if(res == "un_rg"){
                $('li.three').hide();
                $('#user_id').val("1");

            } else if(res != "un_rg")
                $('li.three').show();


        });
        /* 	$("#price").hide();
            $("#unit").hide();
            $("#quantity").hide();
            $("#subTotal").hide();
*/

        $("body").on('change',".inv_item",function() {
            var id = this.id;
            /*
                $("#price").show("slow");
                $("#unit").show("slow");
                $("#quantity").show("slow");
                $("#subTotal").show("slow"); */

            var product_id = this.value;

            var current_id = id.replace(
                "inv_item", "");

            $.ajax({
                method : 'GET',
                url : 'ProductCon?action=products&product_id='+ product_id,
                success : function(data,status) {
                    console
                        .log(data.record);
                    var product = data.record;

                    $("#inv_price"+ current_id).val((product.sellingPrice).toFixed(2));
                    $("#inv_unit"+ current_id).val(product.measuringUnit);
                    $("#stock"+ current_id).val(product.stock);

                }
            });

        });


        /*
        // check with the available quantity
        $("body").on('keyup',".stock",function() {
               var inv_qty=$("[id^='stock']").last().val();
               var line_id = $("[id^='stock']").last().attr('id');
               var cur_id = line_id.replace("stock", "");
               alert(cur_id);

        }); */
        //SUubTotal & available stock validation  calcuation

        $("body").on("keyup","[id^='inv_qty']",function() {
            elementID = this.id.replace("inv_qty","");

            /* alert($("#inv_qty"+elementID).val()); */
            var stock = +$('#stock'+elementID).val();
            var qty = +$("#inv_qty" + elementID).val();
            if(qty > stock){
                sweetAlert("", "Your available stock is "+stock, "error");
            }
            price = +($("#inv_price" + elementID).val());
            subtotal = qty * price;
            $("#inv_sub_total" + elementID).val(
                subtotal.toFixed(2));
            totalCal();

        });
        //		Calcuate Grand total
        function totalCal() {
            var count = Number($("[id^='inv_sub_total']").last().attr('id').replace("inv_sub_total", ""));

            var total = 0;
            for (i = 0; i <= count; i++) {
                var inv_sub_total = $("#inv_sub_total" + i).val();

                if (inv_sub_total !== undefined) {
                    var sub_total = Number(inv_sub_total);
                    total = total + sub_total;

                }
            }

            $('#total').val(total.toFixed(2));
            calVat();

        }

        // Clculate Vat%
        function calVat() {
            var vat = parseInt($('#vat').val());
            total = $('#total').val();
            vat_final = total * (1 + vat / 100);
            $('#invoiced_total').val(vat_final.toFixed(2));
        }
        // Calculate Discount

        function discountCal() {

            var total = $('#invoiced_total').val();

            var disc_rate1 = parseInt($("#disc").val());
            // $('#disc').val(disc_rate)
            if(isNaN(disc_rate1)){
                disc_rate = 0;
            }else {
                disc_rate = disc_rate1;
            }
            discounted_val = total * (1 - disc_rate / 100);

            $('#invoiced_total').val(
                discounted_val.toFixed(2));

        }
        $('.discount').on('keyup change', '#disc',function() {
            totalCal();
            discountCal();
        });

        $('.prcd').on('click', function() {
            total = $('#invoiced_total').val();
            $('#pay_total').val(total);
            $('#fee_total').val(total);


        });



        /* 		Select the payment mode tab */

        function getSelectedTabId() {
            return $("#tabs .ui-tabs-panel:visible").attr("id");
        }

        $(function() {

            $("#tabs").tabs();

            //update the display of the selected id
            $("#tabs").click(function(e) {
                $("#idDisplay").text(getSelectedTabId());
                var test = getSelectedTabId();
                //$('#payment_type').val("cash");
                $('#payment_type').val(test);
            });

            //initalize the selected id display
            //	$("#tabs").click();

        });
        /* 	end 	Select the payment mode tab */


    });
</script>

</body>

<!-- END BODY -->
</html>
