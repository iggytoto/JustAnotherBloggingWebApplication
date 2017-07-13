<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <meta charset="UTF-8">
    <title>leBlogger</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>

<body style="padding-top: 280px;">


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
                    class="btn btn-lg btn-primary btn-block addClick"
                    data-toggle="modal"
                    data-target=".bs-example-modal-sm"
            >Submit new Post
            </button>

        </div>

    </div>

</nav>

<div class="container" style="width: 700px;">

    <c:forEach items="${requestScope.posts}" var="pst">
        <%--<p>--%>
        <div class="panel panel-default">

            <div class="panel-heading">
                <span>Name : </span><span class="uname"><c:out value="${pst.name}"></c:out></span>
                ,
                <span>Date : </span> 07.07.2017

                <button type="button"
                        class="btn btn-default btn-md crossClick"
                        style="float: right;"
                        >
                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                </button>

                <button type="button"
                        class="btn btn-default btn-md pencilClick"
                        style="float: right;"
                        data-toggle="modal"
                        data-target=".bs-example-modal-sm"
                >
                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                </button>

                <input type="hidden" class="uid" value="${pst.id}" >

                <hr style="clear: right; border: 0; margin: 0;">

            </div>

            <div class="panel-body utext"><c:out value="${pst.text}"></c:out></div>

        </div>
        <%--</p>--%>
    </c:forEach>

<%--Pagination--%>

    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li>
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li>
                <a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>

<%--/pagination    --%>


</div>

<%--/container--%>

<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">

    <div class="modal-dialog modal-sm" role="document">

        <div class="modal-content">

            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>

                <form>

                    <div class="form-group">
                        <label for="recipient-name" class="control-label">Name:</label>
                        <input type="text" class="form-control" id="recipient-name" name="name1">
                    </div>

                    <div class="form-group">
                        <label for="message-text" class="control-label">Text:</label>
                        <textarea class="form-control" id="message-text" name="text1"></textarea>
                    </div>

                    <input type="hidden" name="id1" value="">
                    <input type="hidden" name="tpdi" value="">

                    <button type="button" class="btn btn-primary btnSubmit" data-dismiss="modal" style="margin-left: 150px;">Send message</button>

                </form>

            </div>

        </div>

    </div>

</div>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<c:url value="/resources/js/script.js" />"></script>
</body>
</html>
