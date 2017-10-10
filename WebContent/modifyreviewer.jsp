<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>BITScon</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <link href="assets/css/bootstrap.css" rel="stylesheet" />
            <!--FONTAWESOME MAIN STYLE -->
            <link href="assets/css/font-awesome.min.css" rel="stylesheet" />
            <!--CUSTOM STYLE -->
            <link href="assets/css/style.css" rel="stylesheet" />
            <link href="assets/css/header.css" rel="stylesheet" />
        </head>
        <body>
            <div class="col-md-8 col-md-offset-1 ">
                <h2>Add Reviewer</h2>
                <form method="POST" action="AddReviewerServlet">
                    <table>
                        <tr>
                            <td>
                                <span>First Name</span>
                            </td>
                            <td>
                                <input type="text" id="Firstname" name="Firstname" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p></p>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <span>Last name</span>
                            </td>
                            <td>
                                <input type="text" id="Lastname" name="Lastname" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p></p>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <span>Username</span>
                            </td>
                            <td>
                                <input type="text" id="UserID" name="UserID" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p></p>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <span>Email</span>
                            </td>
                            <td>
                                <input type="text" id="email" name="email" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p></p>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <span>Password</span>
                            </td>
                            <td>
                                <input type="password" id="password" name="Password" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p></p>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <span>Phone Number</span>
                            </td>
                            <td>
                                <input type="text" id="Phone_Number" name="Phone_Number" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p></p>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <span>Qualification</span>
                            </td>
                            <td>
                                <input type="text" id="qualification" name="qualification" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p></p>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <span>Expert Area</span>
                            </td>
                            <td>
                                <input type="text" id="expertarea" name="expertarea" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p></p>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <span>Role</span>
                            </td>
                            <td>
                                <input type="text" id="reviewerrole" name="role" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p></p>
                            </td>
                        </tr>
                    </table>
                    <input type="submit" value="Add Reviewer" />
                </form>
            </div>
        </body>
    </html>