<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="org.cursofinalgrado.uapa.java.servlet.entidades.Usuario"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <style type="text/css">
                body {
                    background: #222;
                    font: 12px/1.7em arial, sans-serif;
                }

                #wrapper {
                    width: 100%;
                }

                #wrapper {
                    width: 100%;
                }

                #top ul {
                    padding: 0;
                    margin: 0;
                }

                #top ul.left {
                    float: left;
                }

                #top ul.right {
                    float: right;
                }

                #top ul li {
                    font-size: 11px;
                    list-style-type: none;
                    margin: 0 .75em;
                    float: left;
                    position: relative;
                    color:#fff;
                }

                #top ul li:first-child {
                    margin-left: 0;
                }

                #top a {
                    color: rgb(247,181,0);
                    text-decoration: none;
                }

                #top a:hover {
                    text-decoration: underline;
                }
                .content_pad { width: 940px; height: 100%; margin: 0 auto; position: relative; }
	
.content_pad:after {
	content: ".";
	display: block;
	clear: both;
	visibility: hidden;
	line-height: 0;
	height: 0;
}
 
.content_pad {
	display: inline-block;

            </style>
    </head>
    <body>
        <div id="wrapper">
            <%
//allow access only if session exists
String user = (String) session.getAttribute("user");
String userName = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
    if(cookie.getName().equals("user")) userName = cookie.getValue();
    if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
}
}
%>
            
            <% Usuario currentUser =  (Usuario) session.getAttribute("currentSessionUser");%>
            <div id="top">
                <div class="content_pad">
                    <ul class="right">
                        <li>
                            <span class="ui-icon ui-icon-person"></span>
                            Bienvenido
                            <%= currentUser.getNombres() + " " + currentUser.getApellidos() %>
                            
                        </li>
                         
                        <li>
                            <% if (session.getAttribute("currentSessionUser").equals("")){%>
                            <a href="/LoginServlet"> Login</a>
                            <%}
                                else{%>
                            <a href="/LogoutServlet"> 
                                <b>Logout</b></a>
                            <%}
                            %>
                        </li>
                    </ul>
                </div>
                        <h3>Hi <%=userName %>, Login successful. Your Session ID=<%=sessionID %></h3>
<br>
User=<%=user %>
                <!-- .content_pad -->
            </div>
        </div>
    </body>
</html>