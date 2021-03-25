<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>

<head>
    <meta charset="UTF-8" />
    <title>Class Room Schedule List </title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <%@include file="header_src.jsp"%>


</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->
<body class="padTop53 " >

<!-- MAIN WRAPPER -->
<div id="wrap" >


    <!-- HEADER SECTION -->
    <%@include file="header.jsp"%>
    <!-- END HEADER SECTION -->



    <!-- MENU SECTION -->
    <%@include file="left.jsp"%>

    <!--END MENU SECTION -->



    <!--PAGE CONTENT -->



















    <div id="content">

        <div class="inner" style="min-height: 700px;">
            <div class="row">
                <div class="panel-body">



                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Room Schedule List
                                </div>
                                <div class="panel-body">

                                    <table  id="dataTables-example">
                                        <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Room Name</th>
                                            <th>Course Name</th>
                                            <th>Start Date</th>
                                            <th>End Date</th>
                                            <th>Status</th>
                                            <%if (!currentUser.getUserRole().getName().equals("MEMBER")){ %>

                                            <th>Action</th>
                                            <%} %>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${roomSchedules}" var="temp">
                                            <tr class="odd gradeX">
                                                <td><c:out value="${temp.id}"/></td>
                                                <td><c:out value="${temp.room.name}"/></td>
                                                <td><c:out value="${temp.course.name}"/></td>
                                                <td><c:out value="${temp.startTime}"/></td>
                                                <td><c:out value="${temp.endTime}"/></td>

                                                <td align="left">
                                                    <c:if test="${temp.status =='ACTIVE' }">
                                                        <lable class=" label btn-success">Active</lable>
                                                    </c:if>
                                                    <c:if test="${temp.status =='DEACTIVE' }">
                                                        <lable class=" label btn-danger">Deactive</lable>
                                                    </c:if>
                                                </td>
                                                <%if (!currentUser.getUserRole().getName().equals("MEMBER")){ %>

                                                <td><a
                                                        href="/roomSchedule/getUpdateData?id=<c:out value="${temp.id}"/>"
                                                        class="btn btn-default btn-grad btn-sm"><span><i
                                                        class="icon-edit" style="color:#455862;"></i></span></a>

                                                    <c:if test="${temp.status =='ACTIVE' }">
                                                        <a
                                                                href="" onclick="changeStatus(<c:out value="${temp.id}"/>,'DEACTIVE')"
                                                                class="navg status btn btn-default btn-grad btn-sm"><span><i
                                                                class="icon-trash"
                                                                style="color:#455862;"></i></span></a>
                                                    </c:if>
                                                    <c:if test="${temp.status =='DEACTIVE' }">
                                                        <a
                                                                href="" onclick="changeStatus(<c:out value="${temp.id}"/>,'ACTIVE')"
                                                                class="navg status btn btn-default btn-grad btn-sm"><span><i
                                                                class="icon-ok " style="color:#455862;"></i></span></a>
                                                    </c:if></td>
                                                <%} %>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <%if (!currentUser.getUserRole().getName().equals("MEMBER")){ %>
                                    <div class="panel-heading"><a
                                            href="/roomSchedule/insertPage"><button style="margin-top: -9%;"
                                                                              class="btn-sm btn-primary">Add New</button></a>
                                    </div>
                                        <%} %>
                                </div>

                            </div>
                        </div>








                    </div>
                </div>





            </div>

        </div>
        <!--END PAGE CONTENT -->


    </div>


    <!--END MAIN WRAPPER -->


    <%@include file="footer_src.jsp"%>


    <script>
        $(document).ready(function() {
            // $('#dataTables-example').DataTable();
            $('#dataTables-example').DataTable( {
                "order": [[ 0, "desc" ]]
            } );


        });

        function changeStatus(id,action) {



            var url;
            if(action=='ACTIVE'){
                url = "/roomSchedule/activateRoomSchedule?id="+id;
            }else{

                url = "/roomSchedule/deactivateRoomSchedule?id="+id;
            }

            $.ajax({
                type: "GET",
                url: url,
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
                                window.location = "/roomSchedule/";
                            });
                    } else {
                        swal(
                            "Data not saved!",
                            data.message,
                            "error");
                    }
                }

            });

        }

    </script>

</body>

<!-- END BODY -->
</html>
