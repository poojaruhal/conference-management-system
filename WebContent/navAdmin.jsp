<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript">
	function show(target) {
		if (target == 'submitpaperform') {
			document.getElementById('submitpaperform').style.display = "block";
			document.getElementById('trackpaperform').style.display = "none";
			document.getElementById('withdrawpaperform').style.display = "none";
		} else if (target == 'trackpaperform') {
			document.getElementById('submitpaperform').style.display = "none";
			document.getElementById('trackpaperform').style.display = "block";
			document.getElementById('withdrawpaperform').style.display = "none";
		} else if (target == 'withdrawpaperform') {
			document.getElementById('submitpaperform').style.display = "none";
			document.getElementById('trackpaperform').style.display = "none";
			document.getElementById('withdrawpaperform').style.display = "block";
		}
	}
</script>
<meta charset="UTF-8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>BITSCon</title>
<script src="http://code.jquery.com/jquery-latest.min.js"
        type="text/javascript"></script>
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

<script type="text/javascript">
    function toggle_visibility(id) {
	document.getElementById('selectpapersform').style.display = "none";
	document.getElementById('modifyreviewersform').style.display = "none";
	document.getElementById('modifysubjectsform').style.display = "none";
	document.getElementById('modifykeydatesform').style.display = "none";
	document.getElementById('modifyspeakersform').style.display = "none";
	document.getElementById('createconferenceform').style.display = "none";
	document.getElementById('addreviewerform').style.display = "none";
	document.getElementById('deletereviewerform').style.display = "none";
       var e = document.getElementById(id);
       alert(e);
       if(e.style.display == 'none')
          e.style.display = 'block';
       
    }

</script>
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
        <li><a href="#">Subjects</a></li>
                              
      </ul>
    </li>
                  
                 
                 <li ><a href="#foods">Programme</a>
                  <ul class="dropdown-menu">
        <li><a href="#">WorkShop</a></li>
        </ul>
                 </li>
                 
                 
                 <% 
                 if(userName == null){
					%>
                        <li class ="dropdown"><a class ="dropdown-toggle" href ="#" data-toggle="dropdown">Login
                        <span class="caret"></span></a>
                        
                        <%
                 }
                        %>
                       
                        <div class="dropdown-menu" style="padding: 10px; background: #ddd">
                        <ul class ="nav nav-tabs">
<li class ="active">
      <form action="LoginServlet" role="form">
        <div class="form-group">
          <label for="user">User</label>
          <input type="text" class="form-control" id="user" placeholder="User" />
          <label for="password">Password</label>
          <input type="password" class="form-control" id="password" placeholder="Password" />
        </div>
        <button type="submit" class="btn btn-default">Sign in</button>
      </form>
      </li>
      
      
      
      
      </ul>
      
    </div>
     </li>
     
     
     <li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#menu">Admin <span class="caret"></span></a>
      <ul class="dropdown-menu">
         <li>
                                                    <a href="paper.jsp">PAPERS</a>
                                                </li>
                                                <li>
                                                    <a href="modifyeditor.jsp">MODIFY EDITORS</a>
                                                </li>
                                                <li>
                                                    <a href="registerconference.jsp">REGISTER CONFERENCE</a>
                                                </li>
                                                <li>
                                                    <a href="checkplagiarism.jsp">CHECK PLAGIARISM</a>
                                                </li>
        
        
       
        
        
        
         
          
           
           
						
						
      </ul>
      
     
    </li>
    
    
     
     
     <!--  Register Dropdown Start-->
     
          <!--  Register Dropdown  End-->              
                        <%
							if (userName != null) {
						%>
						<li><a href="logout.jsp">LOGOUT</a></li>
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
<div id="menu">

					
</div>
<!-- #Cirlce Ends -->


<!-- works -->
<div id="foods"  class=" clearfix grid"> 
  
     
</div>
<!-- works -->


<div id="partners" class="container spacer ">
<form method="post" action="PaperServlet"
					enctype="multipart/form-data" id="submitpaperform"
					style="display: none" class ="form-horizontal">
					<input type="hidden" value="submit" name="action">
					
					<div class="form-group">
    <label for="role" class="col-sm-2 control-label">Subject Area</label>
    <div class="col-sm-6">
     <select name="subjectarea" class ="form-control" id ="role">
									<option value="computer">Computer Science</option>
									<option value="civil">Civil Engineering</option>
									<option value="electrical">Electrical Engineering</option>
									<option value="electronics">Electronics Engineering</option>
									<option value="instrumentation">Instrumentation
										Engineering</option>
									<option value="mechnaical">Mechanical Engineering</option>
									<option value="chemical">Chemical Engineering</option>
							</select>
    </div>
  </div>
			
			
			<div class="form-group">
    <label for="firstname" class="col-sm-2 control-label">Paper Title</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name ="title" id="firstname" placeholder="firstname" required>
    </div>
  </div>
  
  <div class="form-group">
    <label for="firstname" class="col-sm-2 control-label">Author</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name ="authorname" id="firstname" placeholder="author" required>
    </div>
  </div>
  
  <div class="form-group">
    <label for="firstname" class="col-sm-2 control-label">CoAuthor</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name = "coauthor" id="firstname" placeholder="coauthor" required>
    </div>
  </div>	
  
  
  
   <div class="form-group">
    <label for="firstname" class="col-sm-2 control-label">description</label>
    <div class="col-sm-6">
      <textarea class="form-control" name ="decription" rows="5" id="comment"></textarea>
    </div>
  </div>	
  
  
   <div class="form-group">
    <label for="firstname" class="col-sm-2 control-label">Paper File</label>
    <div class="col-sm-6">
      <input type="file" class="form-control" name = "paperfile" id="firstname" placeholder="paperfile" required>
    </div>
  </div>
  
   <div class="form-group">
   
    <div class="col-sm-6">
      <input type="submit" class="btn btn-default" name = "upload paper" id="firstname" value ="Upload Paper">
    </div>
  </div>		
  
  </form>
  
  <form method="post" action="PaperServlet" id="trackpaperform" class ="form-horizontal"
					style="display: none">
					<input type="hidden" value="track" name="action">  <div class="form-group">
    
    <div class="col-sm-6">
      <input type="submit" class="form-control" name = "coauthor" value ="Track Paper">
    </div>
  </div>	
				</form>
				<form method="post" action="PaperServlet" id="withdrawpaperform" class ="form-horizontal"
					style="display: none">
					<input type="hidden" value="withdraw" name="action"> <div class="form-group">
    
    <div class="col-sm-6">
      <input type="submit" class="form-control" name = "coauthor" value ="Withdraw Paper">
    </div>
  </div>	
				</form>
				
				
					
  </div>


<!-- team -->
team

 
</div>
<!-- team -->

</div>









<!-- About Starts -->

<!-- About Ends -->








<div id="contact" class="spacer">
<!--Contact Starts-->
<div class="container contactform center">




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