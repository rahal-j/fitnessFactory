<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="UTF-8"/>
    <title>Fitness Factory | Schedule </title>
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
                <li><a href="/schedule/insertPage">Add Schedule</a></li>
            </ul>
            <div class="row">


                <div class="col-lg-12">
                    <div class="box dark">
                        <header>
                            <div class="icons">
                                <i class="icon-glass"></i>
                            </div>
                            <h5>Enter Schedule Details</h5>
                        </header>



                        <form id="scheduleForm" class="form-horizontal" align="center"
                              novalidate>

                            <div class="row page">
                                <div class="col-lg-12">
                                    <div class="box dark staticParent">

                                        <div class="row">
                                            <div class="form-group">
                                                <div class="col-md-4">
                                                    <label class="control-label col-md-5"
                                                           style="float: right;">Search Member</label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input type="text" id="searchNic" name="searchNic"
                                                           placeholder="Enter Member's NIC" class="form-control"
                                                           value="<c:out value="${schedule.name}" />"/>
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
                                                    <select name="title" id="title" class="form-control" readonly="readonly">
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
                                                    <input type="text" id="firstName" name="firstName " readonly="readonly"
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
                                                    <input type="text" id="lastName" name="lastName" readonly="readonly"
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
                                                    <input type="email" id="email" name="email" readonly="readonly"
                                                           placeholder="Enter Email" class="form-control"
                                                           value=""/>
                                                </div>
                                            </div>
                                        </div>


                                        <div class="row">
                                            <div class="form-group">
                                                <div class="col-md-4">
                                                    <label class="control-label col-md-5"
                                                           style="float: right;">Schedule Name</label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input type="text" id="scheduleName" name="scheduleName"
                                                           placeholder="Enter Schedule Name" class="form-control"
                                                           value=""/>
                                                </div>
                                            </div>
                                        </div>

                                        <br />
                                        <div class="row">

                                             <div class="col-md-5 text-center">
                                                <strong>Exercise</strong>
                                            </div>
                                            <div class="col-md-2 text-center">
                                                <strong>Sets</strong>
                                            </div>
                                            <div class="col-md-2 text-center" >
                                                <strong>Reps</strong>
                                            </div>


                                        </div>
                                        <div class="inv_body">


                                            <div class="row inv_row" id="inv_row0">



                                                <div class="col-md-5 text-center" style="margin-left: 1%;">
                                                    <select name="exercise" id="exercise0" class="form-control chzn-select exercise keep">
                                                        <option value="<c:out value="${exercise.id}" />">${exercise.name}</option>
                                                        <c:forEach items="${exercises}" var="temp">
                                                            <option value="<c:out value= "${temp.id}" />">${temp.name}</option>
                                                        </c:forEach>

                                                    </select>
                                                </div>

                                                <div class="col-md-2 text-center">
                                                    <input id="sets0" class="form-control"
                                                           name="sets" type="text"
                                                           value="<c:out value="${schedule.sets}" />"/>
                                                </div>
                                                <div class="col-md-2 form-group text-center "style="margin-left: 0%;">
                                                    <input class="form-control child" name="reps" id="reps0"
                                                           type="text"
                                                           value="<c:out value="${schedule.reps}" />"/>
                                                </div>

                                                <%--<div class="col-md-1 text-center" style="margin-left: 1.2%;">
                                                    <button id="remove" class="btn btn-danger  item_remove"
                                                            type="button">
                                                        <i class="icon-minus-sign"></i>
                                                    </button>
                                                </div>--%>

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
                                        <div class="modal-footer">

                                            <input id="btn_save"
                                                   value="Save" class="btn btn-success btn-md " type="submit">
                                            <input id="btn_reset" value="Reset"
                                                   class="btn btn-warning btn-md " type="reset"/> <a
                                                class="btn btn-danger btn-md"
                                                href="/schedule/">Cancel</a>

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
    $(document).ready(function () {


        $(".chzn-select").prop('disabled', false).trigger('chosen:updated');

        var index = 1;
        $('#add-item').click(function(e){
            e.preventDefault();

            var inv_row = $('  <div class="row inv_row" id="inv_row'+index+'">\n' +
                '\n' +
                '\n' +
                '\n' +
                '                                                <div class="col-md-5 text-center" style="margin-left: 1%;">\n' +
                '                                                    <select name="exercise" id="exercise'+index+'" class="form-control chzn-select exercise keep">\n' +
                '                                                        <option value="<c:out value="${exercise.id}" />">${exercise.name}</option>\n' +
                '                                                        <c:forEach items="${exercises}" var="temp">\n' +
                '                                                            <option value="<c:out value= "${temp.id}" />">${temp.name}</option>\n' +
                '                                                        </c:forEach>\n' +
                '\n' +
                '                                                    </select>\n' +
                '                                                </div>\n' +
                '\n' +
                '                                                <div class="col-md-2 text-center">\n' +
                '                                                    <input id="sets'+index+'" class="form-control"\n' +
                '                                                           name="sets" type="text"\n' +
                '                                                           value="<c:out value="${schedule.sets}" />"/>\n' +
                '                                                </div>\n' +
                '                                                <div class="col-md-2 form-group text-center "style="margin-left: 0%;">\n' +
                '                                                    <input class="form-control child" name="reps" id="reps'+index+'"\n' +
                '                                                           type="text"\n' +
                '                                                           value="<c:out value="${schedule.reps}" />"/>\n' +
                '                                                </div>\n' +
                '\n' +
                '                                                <div class="col-md-1 text-center" style="margin-left: 1.2%;">\n' +
                '                                                    <button id="remove" class="btn btn-danger  item_remove"\n' +
                '                                                            type="button">\n' +
                '                                                        <i class="icon-minus-sign"></i>\n' +
                '                                                    </button>\n' +
                '                                                </div>\n' +
                '\n' +
                '                                            </div>');
            $(".inv_body").append(inv_row);





            $.ajax({
                type : "GET",
                url : "/schedule/exerciseList",
                dataType : "json",
                beforeSend : function(xhr) {
                    $("#exercise"+ index).empty();
                },
                success : function(data) {
                    var div_data = "<option></option>";
                    $(div_data).appendTo("#exercise"+index);
                    $.each(data.data, function(i, obj) {
                        div_data = "<option value=" + obj.id + ">"
                            + obj.name + "</option>";
                        $(div_data).appendTo("#exercise"+index);
                    });
                    $("#exercise"+index).chosen().trigger("chosen:updated");
                    index++;
                }
            });

        });


    });

    $('.inv_body').on('click', '#remove', function() {
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
        var exercises =[];
        var setsList =[];
        var repsList =[];
        var i;
        for (i = 0; i <= count; i++) {
            exercises[i] = $("#exercise"+i).val();
            setsList[i]= $("#sets"+i).val();
            repsList [i]=$("#reps"+i).val();


        }
        formData['exercises']= exercises;
        formData['setsList']= setsList;
        formData['repsList']= repsList;
        formData['scheduleId']= $('#scheduleId').val();
        formData['memberId']= $('#searchNic').val();
        formData['scheduleName']= $('#scheduleName').val();
        return JSON.stringify(formData);
    }














</script>

<script type="text/javascript">
    $(document).ready(function () {
        $(function() {
            formValidation();
        });
        $("#scheduleForm").submit(
            function (e) {
                e.preventDefault();
                if (!$("#scheduleForm").valid())
                    return false;
                var formData = getFormDataAsDTO("scheduleForm");

                $.ajax({
                    type: "POST",
                    url: "/schedule/save",
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
                                    window.location = "/schedule/";
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



</script>
<script>
    $('#btn_search').click(function() {









        var searchId = $("#searchNic").val();


        var url1;
        url1 = "/schedule/searchMember?nic="+searchId;

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
