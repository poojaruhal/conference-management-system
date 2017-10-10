<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>BITScon</title>
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
                <link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />
                <style>
.myErrors {
	color: red;
}
</style>
                <!--  
<script
 src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js"
 type="text/javascript"></script><script
 src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
 type="text/javascript"></script><script
 src="http://ajax.microsoft.com/ajax/jquery.validate/1.7/jquery.validate.js"
 type="text/javascript"></script><script src="/resources/scripts/mysamplecode.js" type="text/javascript"></script><script src="/resources/scripts/date.js" type="text/javascript"></script><script type="text/javascript">
$(document).ready(function() {

 
 
 // modify default settings for validation
 jQuery.validator.setDefaults({
  // where to display the error relative to the element
  errorPlacement: function(error, element) {
      error.appendTo(element.parent().find('div.myErrors'));
     }
 });
 
 
 
 
 $("#frm").validate({
   rules: {
    
    // mandatory entry
    role: "required",
    
    firstname : "required",
    
    lastname : "required",
    
    phonenumber : "required",
    
    
    // mandatory entry and valid email address
    emailaddress: {
        required: true,
        email: true
      },
      
      qualification : "required",
      
      city : "required",
      
      country : "required",
      
      pincode : "required",
      
      username : "required",
      
      password : "required",
      
      confirmpassword : "required",

   
  },
  
  //custom error messages
        messages: {
         firstname:{
          required: "First name cannot be null."
          },
         lastname:{
             required: "Last name cannot be null."
             }, 
        },
        
        // on page submit 
        submitHandler: function(){
          alert('Form validation was a success, please proceed!');
        }

 });
 
 
});
</script>

-->
            </head>
            <body>
                <div class="loader"></div><%@ include file="nav.jsp"%>
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
                    <form method="post" name="frm" id="frm" action="RegisterServlet">
                        <table align="center">
                            <tr>
                                <td>
                                    <label>Register as</label>
                                </td>
                                <td>
                                    <select name="role" id="role">
                                    	<option value="editor">Editor</option>
                                        <option value="reviewer">Reviewer</option>
                                        <option value="author">Author</option>
                                        <option value="attendee">Attendee</option>
                                    </select>
                                </td>
                                <td>
                                    <div class="myErrors"></div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p></p>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>First Name</label>
                                </td>
                                <td>
                                    <input type="text" name="firstname" id="firstname">
                                    </td>
                                    <tr>
                                        <div class="myErrors"></div>
                                    </tr>
                                </tr>
                                <tr>
                                    <td>
                                        <p></p>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Last Name</label>
                                    </td>
                                    <td>
                                        <input type="text" name="lastname" id="lastname">
                                        </td>
                                        <tr>
                                            <div class="myErrors"></div>
                                        </tr>
                                    </tr>
                                    <tr>
                                        <td>
                                            <p></p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>Phone Number</label>
                                        </td>
                                        <td>
                                            <input type="text" name="phonenumber">
                                            </td>
                                            <div class="myErrors"></div>
                                        </tr>
                                        <tr>
                                            <td>
                                                <p></p>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <label>Email Address</label>
                                            </td>
                                            <td>
                                                <input type="text" name="emailaddress">
                                                </td>
                                                <div class="myErrors"></div>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <p></p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label>Qualification</label>
                                                </td>
                                                <td>
                                                    <select name="qualification">
                                                        <option value="master">Masters</option>
                                                        <option value="bachelor">Bachelors</option>
                                                        <option value="diploma">Diploma</option>
                                                        <option value="metric">Metric</option>
                                                    </select>
                                                </td>
                                                <div class="myErrors"></div>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <p></p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label>City</label>
                                                </td>
                                                <td>
                                                    <input type="text" name="city">
                                                    </td>
                                                    <div class="myErrors"></div>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <p></p>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <label>Country</label>
                                                    </td>
                                                    <td>
                                                        <input type="text" name="country">
                                                        </td>
                                                        <div class="myErrors"></div>
                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            <p></p>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            <label>Pincode</label>
                                                        </td>
                                                        <td>
                                                            <input type="text" name="pincode">
                                                            </td>
                                                            <div class="myErrors"></div>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <p></p>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <label>Username</label>
                                                            </td>
                                                            <td>
                                                                <input type="text" name="username">
                                                                </td>
                                                                <div class="myErrors"></div>
                                                            </tr>
                                                            <tr>
                                                                <td>
                                                                    <p></p>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>
                                                                    <label>Password</label>
                                                                </td>
                                                                <td>
                                                                    <input type="password" name="password">
                                                                    </td>
                                                                    <div class="myErrors"></div>
                                                                </tr>
                                                                <tr>
                                                                    <td>
                                                                        <p></p>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>
                                                                        <label>Confirm password</label>
                                                                    </td>
                                                                    <td>
                                                                        <input type="password" name="confirmpassword">
                                                                        </td>
                                                                        <div class="myErrors"></div>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>
                                                                            <p></p>
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td colspan="2">
                                                                            <input type="submit" value="Register" />
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>
                                                                            <p></p>
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>
                                                                            <p></p>
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>
                                                                            <p></p>
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </form>
                                                        </div><%@ include file="footer.jsp"%>
                                                    </body>
                                                </html>