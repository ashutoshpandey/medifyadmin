<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
    
    <link type="text/css" rel="stylesheet" href="<c:url value="/static/lib/font-awesome/css/font-awesome.css"/>"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/static/lib/bootstrap/css/bootstrap.css"/>"/>

	<script type="text/javascript" src="<c:url value="/static/lib/jquery-1.11.1.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/static/lib/bootstrap/js/bootstrap.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/static/lib/jQuery-Knob/js/jquery.knob.js"/>"></script>

    <script type="text/javascript">
        $(function() {
            $(".knob").knob();
        });
    </script>

    <script type="text/javascript">
        $(function() {
            var uls = $('.sidebar-nav > ul > *').clone();
            uls.addClass('visible-xs');
            $('#main-menu').append(uls.clone());
        });
    </script>


    <link type="text/css" rel="stylesheet" href="<c:url value="/static/stylesheets/theme.css"/>"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/static/stylesheets/premium.css"/>"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/static/stylesheets/common.css"/>"/>

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .navbar-default .navbar-brand, .navbar-default .navbar-brand:hover { 
            color: #fff;
        }
    </style>
