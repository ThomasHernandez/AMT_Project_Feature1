<%-- 
    Document   : registerform
    Created on : 3 oct. 2016, 08:00:32
    Author     : Thomas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>AMT - Ciani Hernandez page</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/grayscale.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

    <!-- Navigation -->
    <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="home">
                    <i class="fa fa-play-circle"></i>  <span class="light">AMT - HOME
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                <ul class="nav navbar-nav">
                    <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
                    <li class="hidden">
                        <a href="home#page-top"></a>
                    </li>
                    <c:if test="${sessionScope.user == null}">
                        <li>
                        <a class="page-scroll" href="login">Login</a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.user == null}">
                        <li>
                        <a class="page-scroll" href="register">Register</a>
                        </li>
                    </c:if>
                    <li>
                        <a class="page-scroll" href="home#about">About</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="home#contact">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Intro Header -->
    <header class="intro">
        <div class="intro-body">
            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2">
                        <h1 class="brand-heading">Registration</h1>
                        <p class="intro-text">Here you can create a new user account</p>
                        <h2>
                            <form name="login" method="POST" action="register" accept-charset="utf-8">
                                <p class="text-left" ><label for="firstName">FirstName</label>
                                    <input type="text" name="firstName" id="inputFirstName" class="form-control" placeholder="firstname" required>
                                <p class="text-left" ><label for="lastName">LastName</label>
                                    <input type="text" name="lastName" id="inputLastName" class="form-control" placeholder="lastname" required>
                                <p class="text-left" ><label for="username">Username</label>
                                    <input type="text" name="userName" id="inputUsername" class="form-control" placeholder="username" required>
                                <p class="text-left" ><label for="password">Password</label>
                                    <input type="password" name="userPassword" id="inputPassword" class="form-control" placeholder="password" required>
                                <p class="text-left" ><label for="password">Confirm Password</label>
                                    <input type="password" name="userPasswordConfirm" id="inputPassword" class="form-control" placeholder="confirm password" required>
                                <p>
                                    <input class="btn btn-lg btn-success btn-block" type="submit" value="register">
                                    <!--<a href="login"><input type="submit" value="register"></a>-->

                            </form>
                        </h2>
                        <c:if test="${requestScope.errorMessage != null}">
                            <div class="alert alert-danger fade in">
                                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                <strong>ERROR: </strong> ${requestScope.errorMessage}
                            </div>
                        </c:if>
                        
                    </div>
                </div>
            </div>
        </div>
    </header>
	
  

    <!-- Footer -->
    <footer>
        <div class="container text-center">
            <p>Copyright &copy; Ciani Antony, Hernandez Thomas - HEIG-VD, 2016</p>
        </div>
    </footer>

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="js/jquery.easing.min.js"></script>

    <!-- Google Maps API Key - Use your own API key to enable the map feature. More information on the Google Maps API can be found at https://developers.google.com/maps/ -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCRngKslUGJTlibkQ3FkfTxj3Xss1UlZDA&sensor=false"></script>

    <!-- Custom Theme JavaScript -->
    <script src="js/grayscale.js"></script>


</body>

</html>

