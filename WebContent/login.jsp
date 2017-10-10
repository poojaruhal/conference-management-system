<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
            <!--GOOGLE FONT -->
            <link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css'>
                <!--BOOTSTRAP MAIN STYLES -->
                <link href="assets/css/bootstrap.css" rel="stylesheet" />
                <!--FONTAWESOME MAIN STYLE -->
                <link href="assets/css/font-awesome.min.css" rel="stylesheet" />
                <!--CUSTOM STYLE -->
                <link href="assets/css/style.css" rel="stylesheet" />
                <link href="assets/css/header.css" rel="stylesheet" />
            </head>
            <body>
                <div class="loader"></div>
                <!-- NAV SECTION --><%@ include file="nav.jsp"%>
                <!--END NAV SECTION -->
                <!-- HEADER SECTION -->
                <div id="header-section">
                    <div class="container">
                        <div class="row text-center">
                            <div class="col-md-10 col-md-offset-1 col-sm-12">
                                <h1>
                                    <strong>BITScon</strong>
                                </h1>
                                <br />
                                <br />
                                <br />
                                <h2></h2>
                                <br />
                                <h3>
						EXPLORE
                                    <a href="#about-section">
                                        <i
							class="fa fa-flask down-icon"></i>
                                    </a> INNOVATE
					
                                </h3>
                                <br />
                                <br />
                            </div>
                        </div>
                    </div>
                </div>
                <!--END HEADER SECTION -->
                <!-- BASIC INFO SECTION -->
                <div class="row main-top-margin text-center">
                    <div class="col-md-8 col-md-offset-2 ">
                        <h1>Welcome to BITScon</h1>
                        <h4>Welcome to BITScon 2016, to be held in Pilani, Rajasthan on
				June 27th - June 30th, 2016. The annual BITS conference is a premier
				international forum for researchers, developers and users to present
				and discuss the cutting edge ideas on topics related to various
				subjects. We invite you to submit your original contributions.</h4>
                    </div>
                </div>
                <div class="row main-low-margin text-center">
                    <div class="row main-low-margin text-center">
                        <div class="col-md-4 col-sm-6">
                            <div class="text-center">
                                <i class="fa fa-comments fa-5x color-green"></i>
                                <h4>
                                    <a href="about.jsp">ABOUT</a>
                                </h4>
                                <p></p>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-6">
                            <div class="text-center">
                                <i class="fa fa-bolt fa-5x color-red"></i>
                                <h4>
                                    <a href="register.jsp">REGISTER</a>
                                </h4>
                                <p></p>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-6">
                            <div class="text-center">
                                <i class="fa fa-desktop fa-5x color-light-blue"></i>
                                <h4>Login</h4><%
					    		if ((session.getAttribute("username") == "GUEST")) {
					    		%>
                                <p>Invalid Username or Pawword.</p><%
					    		}
								%>
                                <form method="post" action="LoginServlet">
                                    <table align="center">
                                        <tr>
                                            <td>
                                                <label>USERNAME </label>
                                            </td>
                                            <td>
                                                <input type="text" name="username">
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <p></p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label>PASSWORD </label>
                                                </td>
                                                <td>
                                                    <input type="password" name="password">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <p></p>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td colspan="2">
                                                        <input type="submit" value="Submit">
                                                        </td>
                                                    </tr>
                                                </table>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <div class="row main-low-margin text-center">
                                    <div class="col-md-12 col-sm-12  text-justify"></div>
                                </div>
                                <div class="row main-low-margin text-center">
                                    <div class="col-md-8 col-sm-8   text-justify">
                                        <h3>ABOUT CONFERENCE</h3>
                                        <p>This conference provides platform for students , teachers ,
					Researchers to present their knowledge</p>
                                    </div>
                                    <div class="col-md-3  ">
                                        <img class="img-circle" src="assets/img/team/team1.png" alt="">
                                            <h4>
                                                <strong>Jhon Deo Alex</strong>
                                            </h4>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Curabitur nec nisl odio.</p>
                                            <p>
                                                <a href="#">
                                                    <i
						class="fa fa-facebook-square fa-2x color-facebook"></i>
                                                </a>
                                                <a
						href="#">
                                                    <i class="fa fa-twitter-square fa-2x color-twitter"></i>
                                                </a>
                                                <a href="#">
                                                    <i
						class="fa fa-google-plus-square fa-2x color-google-plus"></i>
                                                </a>
                                                <a
						href="#">
                                                    <i class="fa fa-linkedin-square fa-2x color-linkedin"></i>
                                                </a>
                                                <a href="#">
                                                    <i
						class="fa fa-pinterest-square fa-2x color-pinterest"></i>
                                                </a>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--END BASIC INFO SECTION -->
                            <!--FOOTER SECTION -->
                            <div id="footer"><%@ include file="footer.jsp"%>
                                <!--END FOOTER SECTION -->
                                <!-- JAVASCRIPT FILES PLACED AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
                                <!-- CORE JQUERY LIBRARY -->
                                <script src="assets/js/jquery.js"></script>
                                <!-- CORE BOOTSTRAP LIBRARY -->
                                <script src="assets/js/bootstrap.min.js"></script>
                                <!-- CUSTOM SCRIPT-->
                                <script src="assets/js/custom.js"></script>
                            </body>
                        </html>