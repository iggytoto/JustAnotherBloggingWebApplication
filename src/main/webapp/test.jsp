<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--
  Created by IntelliJ IDEA.
  User: Iggytoto
  Date: 11.07.2017
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>leBlogger</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>

<body style="padding-top: 280px;" >


<nav class="navbar navbar-default navbar-fixed-top">

    <div class="container" style="width: 700px;">

        <div class="jumbotron" style="margin-bottom: 0px;">

            <h1 style="text-align: center;">
                le Blogger
                <span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>
            </h1>

        </div>

    <div>

        <button type="button"
                class="btn btn-lg btn-primary btn-block"
                data-toggle="modal"
                data-target=".bs-example-modal-sm"
        >Submit new Post</button>

    </div>

    </div>

</nav>

    <div class="container" style="width: 700px;">

        <c:forEach items="${requestScope.posts}" var="pst">
        <p>
            <div class="panel panel-default">

                <div class="panel-heading">
                        <span>Name : </span> <c:out value="${pst.name}"></c:out>
                        ,
                        <span>Date : </span> 07.07.2017
                </div>

                <div class="panel-body">

                    <c:out value="${pst.text}"></c:out>

                </div>

            </div>
        </p>
        </c:forEach>

    </div>

<%--/container--%>

<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">

    <div class="modal-dialog modal-sm" role="document">

        <div class="modal-content">

            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>

                <form:form action="/blog" method="post" modelAttribute="post">

                    <div class="form-group">
                        <form:label for="recipient-name" class="control-label" path="name">Name:</form:label>
                        <form:input type="text" class="form-control" id="recipient-name" path="name" />
                    </div>

                    <div class="form-group">
                        <form:label for="message-text" class="control-label" path="text">Text:</form:label>
                        <form:textarea class="form-control" id="message-text" path="text"></form:textarea>
                    </div>

                    <button type="submit" class="btn btn-primary" style="margin-left: 150px;">Send message</button>

                </form:form>

            </div>

        </div>

    </div>

</div>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
