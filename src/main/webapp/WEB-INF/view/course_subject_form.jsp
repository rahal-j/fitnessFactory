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
                <li><a href="dashboard.jsp">Home</a></li>
                <li><a href="ProductCon?action=insert">Add Class Rooms</a></li>
            </ul>
            <div class="row">
            <input value="${action}" id="action" type="hidden">

                <div class="col-lg-12">
                    <div class="box dark">
                        <header>
                            <div class="icons">
                                <i class="icon-glass"></i>
                            </div>
                            <h5>Add Subjects to Course</h5>
                        </header>

                        <form id="courseSubjectForm" class="form-horizontal" align="center"
                              novalidate>


                            </br>

                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-5"
                                               style="float: right;">Course Name</label>
                                    </div>
                                    <div class="col-md-4">

                                        <select name="course"
                                                class="form-control chzn-select" id="course">

                                            <option value="<c:out value="${course.id}" />">${course.name}</option>
                                            <c:forEach items="${courses}" var="temp">
                                                <option value="<c:out value= "${temp.id}" />">${temp.name}</option>
                                            </c:forEach>
                                        </select>

                                    </div>
                                </div>
                            </div>


                            <div class="inv_body">
                                <div class="row">

                                    <div class=" inv_row form-group" id="exer">
                                        <div class="col-md-4">
                                            <label class="control-label col-md-5"
                                                   style="float: right;">Add Subjects</label>
                                        </div>
                                        <div class="col-md-4">
                                        <select name="subject"
                                                class="form-control chzn-select" id="subject_0">

                                            <option value="<c:out value="${subject.id}" />">${subject.name}</option>
                                             <c:forEach items="${subjects}" var="temp">
                                                <option value="<c:out value= "${temp.id}" />">${temp.name}</option>
                                            </c:forEach>
                                        </select>
                                        </div>


                                   <%--    <div class="col-md-1 text-center">
                                            <button id="kmk" class="btn btn-danger  item_remove"
                                                    type="button">
                                                <i class="icon-minus-sign"></i>
                                            </button>
                                        </div>--%>
                                    </div>
                                </div>
                                <%--
                                                                        <div class="col-md-4 text-center">
                                                                            <select id="subject0" name="subject"
                                                                                    class="form-control inv_item keep">

                                                                            </select>
                                                                        </div>--%>

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
                                        <div>
                                            <input id="btn_save"
                                                   value="Save" class="btn btn-success btn-md " type="submit">
                                            <input id="btn_reset" value="Reset"
                                                   class="btn btn-warning btn-md " type="reset"/> <a
                                                class="btn btn-danger btn-md"
                                                href="/course/">Cancel</a>
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
    $(document).ready(function () {

        var index = 1;
        $("#add-item").click(
            function (e) {
                e.preventDefault();

                var inv_row = $('       <div class="row">\n' +
                    '\n' +
                    '                                    <div class=" inv_row form-group" id="sub_row'+index+'">\n' +
                    '                                        <div class="col-md-4">\n' +
                    '                                        </div>\n' +
                    '                                        <div class="col-md-4">\n' +
                    '                                        <select name="subject"\n' +
                    '                                                class="form-control chzn-select" id="subject_'+index+'">\n' +
                    '\n' +
                    '                                            <option value="<c:out value="${subject.id}" />">${subject.name}</option>\n' +
                    '                                             <c:forEach items="${subjects}" var="temp">\n' +
                    '                                                <option value="<c:out value= "${temp.id}" />">${temp.name}</option>\n' +
                    '                                            </c:forEach>\n' +
                    '                                        </select>\n' +
                    '                                        </div>\n' +
                    '\n' +
                    '\n' +
                    '                                       <div class="col-md-1 text-center">\n' +
                    '                                            <button id="kmk" class="btn btn-danger  item_remove"\n' +
                    '                                                    type="button">\n' +
                    '                                                <i class="icon-minus-sign"></i>\n' +
                    '                                            </button>\n' +
                    '                                        </div>\n' +
                    '                                    </div>\n' +
                    '                                </div>');


               /* var inv_row = $(' <div class=" inv_row form-group" id="sub_row' +index+'"  >\n' +
                    '                                    <div class="col-md-4">\n' +
                    '                                        <label class="control-label col-md-5"\n' +
                    '                                               ></label>\n' +
                    '                                    </div>\n' +
                    '\n' +
                    '                                     <div class="col-md-4 text-center" >\n' +
                    '                                        <select id="subject'+index+'" name="subject"\n' +
                    '                                                class="form-control inv_item keep">\n' +
                    '\n' +
                    '                                        </select>\n' +
                    '                                    </div>\n' +
                    '\n' +
                    '                                    <div class="col-md-1 text-center">\n' +
                    '                                        <button id="kmk" class="btn btn-danger  item_remove"\n' +
                    '                                                type="button">\n' +
                    '                                            <i class="icon-minus-sign"></i>\n' +
                    '                                        </button>\n' +
                    '                                    </div>\n' +
                    '                                </div>');*/
                $(".inv_body").append(inv_row)
                    .show('slow');
                ++index;

            });


        $('.inv_body').on('click', '#kmk', function () {
            this.closest(".inv_row").remove();

        });

    });
</script>

<script type="text/javascript">
    $(document).ready(function () {
      if($("#action").val() == "update"){

            var courseId = $("#course").val();


          $.ajax({
              url: "/courseSubject/getSubjectsOfCourse?courseId=" + courseId,
              type: "GET",
              dataType: "json",
              data: null,
              contentType: "application/json; charset=utf-8",
              success: function (data) {
                  alert(data);
               /*   if (data.code == 'FAIL') {
                      swal(
                          "No User Available for NIC !",
                          data.message,
                          "error");
                  } else {
                     alert(data.data);
                  }*/
              }
          });




        /*  $.ajax({
              type : 'GET',
              url : "/courseSubject/getRelevantSubjects?id="+courseId,
              success : function(data) {
                alert(data.data)
               /!*   $.each(data.record,function(i,obj) {
                      var row = '<div class="row inv_row" id="exer">'
                          + '<div class="col-md-1"></div><div class="col-md-4 text-center" style="margin-left: 1%;">'
                          + '<select id="exercise0" name="exercise"  class="form-control chzn-select inv_item keep">'
                          + '<option value="'+obj.exercise_id+'">'
                          + obj.workout_name
                          + '</option>'
                          + '</select>'
                          + '</div>'

                          + '<div class="col-md-2 text-center">'
                          + '<input id="set_per_rep0" style="text-align: right;"'
                          +		'class="form-control inv_price" name="set_per_rep" value="'+obj.sets_per_rep+'" type="text" />'
                          + '</div>'
                          + '<div class="col-md-2 text-center">'
                          + '<input class="form-control" name="no_of_rep" value="'+obj.no_of_reps+'" id="no_of_rep0"'
                          +		'type="text" style="text-align: right;" />'
                          + '</div>'
                          + '<div class="col-md-1 text-center">'
                          + '<button id="kmk" class="btn btn-danger  item_remove"'
                          +		'type="button">'
                          + '<i class="icon-minus-sign"></i>'
                          + '</button>'
                          + '</div>'
                          + '</div>';

                      $('.inv_body').append(row);
                      $(".keep").chosen().trigger("chosen:updated");
                  });*!/

              }

          });*/
      }
    });
</script>


<script type="text/javascript">
    $(document).ready(function () {
      /*  $(function() {
            formValidation();
        });*/
        $("#courseSubjectForm").submit(
            function (e) {
                e.preventDefault();
                // if (!$("#courseSubjectForm").valid())
                //     return false;
                var formData = getFormDataAsDTO("courseSubjectForm");
                 $.ajax({
                    type: "POST",
                    url: "/courseSubject/addCourseSubject",
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
                                    window.location = "/courseSubject/";
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

        var count = Number($("[id^='subject_']").last().attr('id').replace("subject_", ""));
        var subjects =[];
        var i;
        for (i = 0; i <= count; i++) {
            subjects[i] = $("#subject_"+i).val();
        }
      formData['subjects']= subjects;
        return JSON.stringify(formData);
     }
</script>

</body>

<!-- END BODY -->
</html>
