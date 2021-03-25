<%--
<%@ page import="com.school.school.entity.User" %>
<% User currentUser = (User) (session.getAttribute("user"));%>

<div id="left" >
    <div class="media user-media well-small">
        <a class="user-link" href="#">
            <img style="height: 100px" class="media-object img-thumbnail user-img" alt="User Picture" src="../../resources/static/assets/img/user-avatar.jpg" />
        </a>
        <br />
        <div class="media-body">
            <h5 class="media-heading">
                 <span id="user"><%
                    if (currentUser == null) {
                        response.sendRedirect("https://www.google.com/");

                     } else {%>
                     <%= currentUser.getFirstName()%>
			<% } %></span></h5>
            <h5 class="media-heading"> </h5>
            <ul class="list-unstyled user-info">

                <li>
                    <a class="btn btn-success btn-xs btn-circle" style="width: 10px;height: 12px;"></a> Online

                </li>

            </ul>
        </div>
        <br />
    </div>

    <ul id="menu" class="collapse">
        <li class="panel active">
            <a href="/dashboard" >
                <i class="icon-table"></i> Dashboard
            </a>
        </li>
        <% if (currentUser.getUserRole().getName().equals("ADMIN")) {%>

        <li class="panel ">
            <a href="#" data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-nav">
                <i class="icon-tasks"> </i> Admin

                        <span class="pull-right">
                          <i class="icon-angle-left"></i>
                        </span>
                        &nbsp; <span class="label label-default">10</span>&nbsp;
            </a>
            <ul class="collapse" id="component-nav">
                <li><a href="/class/"><i class="icon-angle-right"></i> Add Class Room </a></li>
                <li><a href="/subject/"><i class="icon-angle-right"></i> Subject List</a></li>
                <li><a href="/userRole/"><i class="icon-angle-right"></i> UserRole List </a></li>
                <li><a href="/course/"><i class="icon-angle-right"></i> Course List </a></li>
                <li><a href="/courseSubject/"><i class="icon-angle-right"></i> Course Subject List </a></li>
                <li><a href="/regUser/insertPage"><i class="icon-angle-right"></i> User Register </a></li>
                <li><a href="/userCourse/"><i class="icon-angle-right"></i> Course Assign </a></li>
                <li><a href="/roomSchedule/"><i class="icon-angle-right"></i> Schedule Class Room </a></li>
            </ul>
        </li>


        <%      } else if (currentUser.getUserRole().getName().equals("SUPERVISOR")){ %>



        <li class="panel">
            <a href="#" data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#pagesr-nav">
                <i class="icon-table"></i> Supervisor

                <span class="pull-right">
                            <i class="icon-angle-left"></i>
                        </span>
                &nbsp; <span class="label label-info">6</span>&nbsp;
            </a>
            <ul class="collapse" id="pagesr-nav">
                <li><a href="/class/"><i class="icon-angle-right"></i> Add Class Room </a></li>
                <li><a href="/subject/"><i class="icon-angle-right"></i> Subject List</a></li>
                 <li><a href="/course/"><i class="icon-angle-right"></i> Course List </a></li>
                <li><a href="/courseSubject/"><i class="icon-angle-right"></i> Course Subject List </a></li>
                <li><a href="/regUser/insertPage"><i class="icon-angle-right"></i> User Register </a></li>
                <li><a href="/userCourse/"><i class="icon-angle-right"></i> Course Assign </a></li>
                <li><a href="/roomSchedule/"><i class="icon-angle-right"></i> Schedule Class Room </a></li>
            </ul>
        </li>
<%} else if (currentUser.getUserRole().getName().equals("MEMBER")){ %>
        <li class="panel">
            <a href="#" data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#pagesr-nav">
                <i class="icon-table"></i> Member

                <span class="pull-right">
                            <i class="icon-angle-left"></i>
                        </span>
                &nbsp; <span class="label label-info">6</span>&nbsp;
            </a>
            <ul class="collapse" id="pagesr-nav">
                <li><a href="/userCourse/loadMemberForm"><i class="icon-angle-right"></i> Get Class Schedule </a></li>
                <li><a href="/roomSchedule/"><i class="icon-angle-right"></i> View Course Schedules </a></li>

            </ul>
        </li>


        <%} else { %>



        <%} %>
    </ul>

</div>--%>


<div id="left" >
    <div class="media user-media well-small">
        <a class="user-link" href="#">
            <img class="media-object img-thumbnail user-img" alt="User Picture" src="../../resources/static/assets/img/user.gif" />
        </a>
        <br />
        <div class="media-body">
            <h5 class="media-heading"> Joe Romlin</h5>
            <ul class="list-unstyled user-info">

                <li>
                    <a class="btn btn-success btn-xs btn-circle" style="width: 10px;height: 12px;"></a> Online

                </li>

            </ul>
        </div>
        <br />
    </div>

    <ul id="menu" class="collapse">


        <li class="panel active">
            <a href="index.html" >
                <i class="icon-table"></i> Dashbord


            </a>
        </li>



        <li class="panel ">
            <a href="#" data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-nav">
                <i class="icon-tasks"> </i> Quick menu

                <span class="pull-right">
                          <i class="icon-angle-left"></i>
                        </span>
                &nbsp; <span class="label label-default">10</span>&nbsp;
            </a>
            <ul class="collapse" id="component-nav">

                <li class=""><a href="/member/"><i class="icon-angle-right"></i> Add Member</a></li>
                <li class=""><a href="/exercise/"><i class="icon-angle-right"></i> Add Exercise </a></li>
                <li class=""><a href="/payment/"><i class="icon-angle-right"></i> Add Payment </a></li>
                <li class=""><a href="/schedule/"><i class="icon-angle-right"></i> Add Schedule </a></li>
                <li class=""><a href="/memberSchedule/"><i class="icon-angle-right"></i> Add Member Schedule </a></li>
                <li class=""><a href="/product/"><i class="icon-angle-right"></i> Add Product </a></li>
                <li class=""><a href="/subscription/"><i class="icon-angle-right"></i> Add Subscription </a></li>
                <li class=""><a href="/userRole/"><i class="icon-angle-right"></i> Add User Role </a></li>
                <li class=""><a href="/stock/"><i class="icon-angle-right"></i> Add Stock </a></li>
                <li class=""><a href="typography.html"><i class="icon-angle-right"></i> Typography </a></li>
            </ul>
        </li>







    </ul>

</div>




