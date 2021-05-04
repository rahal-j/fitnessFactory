<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>

<head>
    <meta charset="UTF-8" />
    <title>Stocks List </title>
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
                                    Stocks List
                                </div>
                                <div class="panel-body">

                                    <table  id="dataTables-example">
                                        <thead>
                                        <tr>
                                            <th>Product</th>
                                            <th>Batch No</th>
                                            <th>Expire Date</th>
                                            <th>Quantity</th>
                                            <th>Date Created</th>

                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${stocks}" var="temp">
                                            <tr class="odd gradeX">
                                                <td><c:out value="${temp.product}"/></td>
                                                <td><c:out value="${temp.batchNo}"/></td>
                                                <td><c:out value="${temp.expireDate}"/></td>
                                                <td><c:out value="${temp.quantity}"/></td>
                                                <td><c:out value="${temp.dateCreated}"/></td>



                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <div class="panel-heading"><a
                                            href="/stocks/insertPage"><button style="margin-top: -9%;"
                                                                                    class="btn-sm btn-primary">Add New</button></a>
                                    </div>

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


    </script>

</body>

<!-- END BODY -->
</html>
