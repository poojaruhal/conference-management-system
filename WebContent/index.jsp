<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>BITSCon</title>

<!-- Google fonts -->
<link href='http://fonts.googleapis.com/css?family=Roboto:400,300,700' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Josefin+Sans:600' rel='stylesheet' type='text/css'>

<!-- font awesome -->
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

<!-- bootstrap -->
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css" />

<!-- animate.css -->
<link rel="stylesheet" href="assets/animate/animate.css" />
<link rel="stylesheet" href="assets/animate/set.css" />

<!-- gallery -->
<link rel="stylesheet" href="assets/gallery/blueimp-gallery.min.css">

<!-- favicon -->
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">


<link rel="stylesheet" href="assets/style.css">
<link href="assets/css/header.css" rel="stylesheet" />
<link rel="stylesheet" href="assets/bootstrap/css/custom.css" />
<style type="text/css">
.dropdown:hover .dropdown-menu
{
display : block;
}
</style>
</head>

<body>
<div class="topbar animated fadeInLeftBig"></div>

<!-- Header Starts -->
<div class="navbar-wrapper">
      <div class="container">

        <div class="navbar navbar-inverse navbar-fixed-top" role="navigation" id="top-nav">
          <div class="container">
            <div class="navbar-header">
              <!-- Logo Starts -->
              <% String userName = (String) session.getAttribute("username"); 
					if(userName == null){
					%>
                        <a class="navbar-brand" href="#">Welcome Guest</a><% 
					}
					else{
					%>
                        <a class="navbar-brand" href="#">Welcome, <%= userName %>
                        </a><% } %>
              <!-- #Logo Ends -->


             

            </div>


            <!-- Nav Starts -->
            <div class="navbar-collapse  collapse">
              <ul class="nav navbar-nav navbar-right scroll">
                 <li class="active"><a href="#home">Home</a></li>
                
                  <li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#menu">Conference <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="#">Events</a></li>
        <li><a href="#">Sponsers</a></li>
                              
      </ul>
    </li>
                 <li ><a href="#foods">Programme</a></li>
                 <li ><a href="#partners">Sponsers</a></li>
                 <li ><a href="#contact">Contact</a></li>
                 
                 
                 <% 
                 if(userName == null){
					%>
                        <li class ="dropdown"><a class ="dropdown-toggle" href ="#" data-toggle="dropdown">Login
                        <span class="caret"></span></a>
                       
                        <div class="dropdown-menu" style="padding: 10px; background: #ddd">
                        <ul class ="nav nav-tabs">
<li class ="active">
      <form action="LoginServlet" role="form" method ="get">
        <div class="form-group">
          <label for="username">User</label>
          <input type="text" class="form-control" id="username" placeholder="User" name ="username" />
          <label for="password">Password</label>
          <input type="password" class="form-control" id="password" name ="password" placeholder="Password" />
        </div>
        <button type="submit" class="btn btn-default">Sign in</button>
      </form>
      </li>
      
      
      
      
      </ul>
      
    </div>
     </li>
     
     
     <!--  Register Dropdown Start-->
      <li ><a href="#registration">Register</a></li>
          <!--  Register Dropdown  End-->              
                        <% 
					}
                 %>
                 
                
        
              </ul>
            </div>
            <!-- #Nav Ends -->

          </div>
        </div>

      </div>
    </div>
<!-- #Header Starts -->




<div id="home">
<!-- Slider Starts -->
<div class="banner">
          <img src="images/clockTowerCut.jpg" alt="banner" class="img-responsive">
          <div class="caption">
            <div class="caption-wrapper">
              <div class="caption-info">              
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
             <a href="#menu" class="explore animated bounceInDown"><i class="fa fa-angle-down  fa-3x"></i></a>
              </div>
            </div>
          </div>
</div>
<!-- #Slider Ends -->
</div>









<!-- Cirlce Starts -->
<div id="menu"  class="container spacer about">

<div class="page-header" id ="registration">
  <h1>Registration</h1>
</div>
      <form class="form-horizontal" action="RegisterServlet" method="post" data-toggle="validator" role="form">
  
  <div class="form-group">
    <label for="role" class="col-sm-2 control-label">Register As</label>
    <div class="col-sm-10">
      <select class="form-control" id ="role">
  <option>Author</option>
  <option>Attendee</option>
 
</select>
    </div>
  </div>
  
  <div class="form-group">
    <label for="firstname" class="col-sm-2 control-label">First Name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="firstname" placeholder="firstname" required>
    </div>
  </div>
  
  <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">Last Name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="lastname" placeholder="Last Name">
    </div>
  </div>
  
  
  <div class="form-group">
    <label for="phonenumber" class="col-sm-2 control-label">Phone Number</label>
    <div class="col-sm-10">
      <input type="number" class="form-control" id="phonenumber" placeholder="Phone Number">
    </div>
  </div>
  
  <div class="form-group">
   <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
    <div class="col-sm-10">
      <input type="email" class="form-control" id="inputEmail3" placeholder="Email" data-error="Bruh, that email address is invalid" required>
      <div class="help-block with-errors"></div>
    </div>
  </div>
  
  
   <div class="form-group">
    <label for="qualification" class="col-sm-2 control-label">Qualification</label>
    <div class="col-sm-10">
      <select class="form-control" id ="qualification">
  <option>Masters</option>
  <option>PHD</option>
 
</select>
    </div>
  </div>
  
   
  
  
  
  <div class="form-group">
      <label for="address" class="col-sm-2 control-label">Address</label>
      <div class="col-xs-10">
        <div class="form-inline">
          <div class="form-group">
            <input type="text" class="form-control" placeholder="Country" />
          </div>
          <div class="form-group">
            <input type="text" class="form-control" placeholder="City" />
          </div>
          <div class="form-group">
            <input type="text" class="form-control" placeholder="pincode" />
          </div>
        </div>
      </div>
    </div>
  
  
   <div class="form-group">
    <label for="username" class="col-sm-2 control-label">Username</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="username" placeholder="Username">
    </div>
  </div>
  
  
  
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
    <div class="col-sm-10">
      <input type="password" data-minlength="6"  class="form-control" id="inputPassword3" placeholder="Password" required>
    <div class="help-block">Minimum of 6 characters</div>
    </div>
  </div>
  
  <div class="form-group">
    <label for="confirmpassword" class="col-sm-2 control-label">Confirm Password</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="confirmpassword" data-match="#inputPassword3" data-match-error="Whoops, these don't match" placeholder="Confirm Password">
    <div class="help-block with-errors"></div>
    </div>
  </div>
  
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox"> Remember me
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Sign in</button>
    </div>
  </div>
</form>
</div>
<!-- #Cirlce Ends -->


<!-- works -->
<div id="foods"  class=" clearfix grid"> 
    <figure class="effect-oscar  wowload fadeInUp">
        <img src="images/portfolio/1.jpg" alt="img01"/>
        <figcaption>
            <h2>Cappuchino</h2>
            <p>Lily likes to play with crayons and pencils<br>
            <a href="images/portfolio/1.jpg" title="1" data-gallery>View more</a></p>            
        </figcaption>
    </figure>
     <figure class="effect-oscar  wowload fadeInUp">
        <img src="images/portfolio/2.jpg" alt="img01"/>
        <figcaption>
            <h2>Latte</h2>
            <p>Lily likes to play with crayons and pencils<br>
            <a href="images/portfolio/2.jpg" title="1" data-gallery>View more</a></p>            
        </figcaption>
    </figure>
     <figure class="effect-oscar  wowload fadeInUp">
        <img src="images/portfolio/3.jpg" alt="img01"/>
        <figcaption>
            <h2>Ambience</h2>
            <p>Lily likes to play with crayons and pencils<br>
            <a href="images/portfolio/3.jpg" title="1" data-gallery>View more</a></p>            
        </figcaption>
    </figure>
     <figure class="effect-oscar  wowload fadeInUp">
        <img src="images/portfolio/4.jpg" alt="img01"/>
        <figcaption>
            <h2>Fruits</h2>
            <p>Lily likes to play with crayons and pencils<br>
            <a href="images/portfolio/4.jpg" title="1" data-gallery>View more</a></p>            
        </figcaption>
    </figure>
     
     <figure class="effect-oscar  wowload fadeInUp">
        <img src="images/portfolio/5.jpg" alt="img01"/>
        <figcaption>
            <h2>Breakfast</h2>
            <p>Lily likes to play with crayons and pencils<br>
            <a href="images/portfolio/5.jpg" title="1" data-gallery>View more</a></p>            
        </figcaption>
    </figure>
    <figure class="effect-oscar  wowload fadeInUp">
        <img src="images/portfolio/6.jpg" alt="img01"/>
        <figcaption>
            <h2>Kitchen</h2>
            <p>Lily likes to play with crayons and pencils<br>
            <a href="images/portfolio/6.jpg" title="1" data-gallery>View more</a></p>            
        </figcaption>
    </figure>
     
    
    

     
</div>
<!-- works -->


<div id="partners" class="container spacer ">
	<h2 class="text-center  wowload fadeInUp">Some of our happy customers</h2>
  <div class="clearfix">    
    <div class="col-sm-6 col-sm-offset-3">


    <div id="carousel-testimonials" class="carousel slide testimonails  wowload fadeInRight" data-ride="carousel">
    <div class="carousel-inner">  
      <div class="item active animated bounceInRight row">
      <div class="animated slideInLeft col-xs-2"><img alt="portfolio" src="images/team/1.jpg" width="100" class="img-circle img-responsive"></div>
      <div  class="col-xs-10">
      <p> I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. </p>      
      <span>Angel Smith - <b>eshop Canada</b></span>
      </div>
      </div>
      <div class="item  animated bounceInRight row">
      <div class="animated slideInLeft col-xs-2"><img alt="portfolio" src="images/team/2.jpg" width="100" class="img-circle img-responsive"></div>
      <div  class="col-xs-10">
      <p>No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful.</p>
      <span>John Partic - <b>Crazy Pixel</b></span>
      </div>
      </div>
      <div class="item  animated bounceInRight row">
      <div class="animated slideInLeft  col-xs-2"><img alt="portfolio" src="images/team/3.jpg" width="100" class="img-circle img-responsive"></div>
      <div  class="col-xs-10">
      <p>On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue.</p>
      <span>Harris David - <b>Jet London</b></span>
      </div>
      </div>
  </div>

   <!-- Indicators -->
   	<ol class="carousel-indicators">
    <li data-target="#carousel-testimonials" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-testimonials" data-slide-to="1"></li>
    <li data-target="#carousel-testimonials" data-slide-to="2"></li>
  	</ol>
  	<!-- Indicators -->
  </div>



    </div>
  </div>


<!-- team -->
<h3 class="text-center  wowload fadeInUp">Our Chefs</h3>
<p class="text-center  wowload fadeInLeft">Our chefs that is making everything possible</p>
<div class="row grid team  wowload fadeInUpBig">	
	<div class=" col-sm-3 col-xs-6">
	<figure class="effect-chico">
        <img src="images/team/8.jpg" alt="img01" class="img-responsive" />
        <figcaption>
            <p><b>Barbara Husto</b><br>Senior Chef</p>            
        </figcaption>
    </figure>
    </div>

    <div class=" col-sm-3 col-xs-6">
	<figure class="effect-chico">
        <img src="images/team/10.jpg" alt="img01"/>
        <figcaption>            
            <p><b>Barbara Husto</b><br>Chef</p>            
        </figcaption>
    </figure>
    </div>

    <div class=" col-sm-3 col-xs-6">
	<figure class="effect-chico">
        <img src="images/team/12.jpg" alt="img01"/>
        <figcaption>
            <p><b>Barbara Husto</b><br>Asst Chef</p>          
        </figcaption>
    </figure>
    </div>

    <div class=" col-sm-3 col-xs-6">
	<figure class="effect-chico">
        <img src="images/team/17.jpg" alt="img01"/>
        <figcaption>
            <p><b>Barbara Husto</b><br>Asst Chef</p>
        </figcaption>
    </figure>
    </div>

 
</div>
<!-- team -->

</div>









<!-- About Starts -->
<div class="highlight-info">
<div class="overlay spacer">
<div class="container">
<div class="row text-center  wowload fadeInDownBig">
	<div class="col-sm-3 col-xs-6">
	<i class="fa fa-smile-o  fa-5x"></i><h4>24152 Clients</h4>
	</div>
	<div class="col-sm-3 col-xs-6">
	<i class="fa fa-thumbs-up  fa-5x"></i><h4>25 Variety</h4>
	</div>
	<div class="col-sm-3 col-xs-6">
	<i class="fa fa-history  fa-5x"></i><h4>15 yrs old</h4>
	</div>
	<div class="col-sm-3 col-xs-6">
	<i class="fa fa-map-marker fa-5x"></i><h4>2 Locations</h4>
	</div>
</div>
</div>
</div>
</div>
<!-- About Ends -->








<div id="contact" class="spacer">
<!--Contact Starts-->
<div class="container contactform center">
<h2 class="text-center  wowload fadeInUp">Reservation</h2>
  <div class="row wowload fadeInLeftBig">      
      <div class="col-sm-6 col-sm-offset-3 col-xs-12">      
        <input type="text" placeholder="Name">
        <input type="text" placeholder="Company">
        <textarea rows="5" placeholder="Message"></textarea>
        <button class="btn btn-primary"><i class="fa fa-paper-plane"></i> Send</button>
      </div>
  </div>



</div>

</div>
<div id="map"></div>
<!--Contact Ends-->



<!-- Footer Starts -->
<div class="footer text-center spacer">
<p class="wowload flipInX"><a href="#"><i class="fa fa-facebook fa-2x"></i></a> <a href="#"><i class="fa fa-instagram fa-2x"></i></a> <a href="#"><i class="fa fa-twitter fa-2x"></i></a> <a href="#"><i class="fa fa-flickr fa-2x"></i></a> </p>
Copyright 2014 Cyrus Creative Studio. All rights reserved.
</div>
<!-- # Footer Ends -->
<a href="#home" class="gototop "><i class="fa fa-angle-up  fa-3x"></i></a>





<!-- The Bootstrap Image Gallery lightbox, should be a child element of the document body -->
<div id="blueimp-gallery" class="blueimp-gallery blueimp-gallery-controls">
    <!-- The container for the modal slides -->
    <div class="slides"></div>
    <!-- Controls for the borderless lightbox -->
    <h3 class="title">Title</h3>
    <a class="prev">‹</a>
    <a class="next">›</a>
    <a class="close">×</a>
    <!-- The modal dialog, which will be used to wrap the lightbox content -->    
</div>



<!-- jquery -->
<script src="assets/jquery.js"></script>

<!-- wow script -->
<script src="assets/wow/wow.min.js"></script>


<!-- boostrap -->
<script src="assets/bootstrap/js/bootstrap.js" type="text/javascript" ></script>

<!-- jquery mobile -->
<script src="assets/mobile/touchSwipe.min.js"></script>
<script src="assets/respond/respond.js"></script>

<!-- gallery -->
<script src="assets/gallery/jquery.blueimp-gallery.min.js"></script>

<script src='https://maps.googleapis.com/maps/api/js?key=&sensor=false&extension=.js'></script> 


<!-- custom script -->
<script src="assets/script.js"></script>

</body>
</html>