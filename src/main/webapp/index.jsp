<%
    response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
    String newLocn = "./interface/login.html";
    response.setHeader("Location",newLocn);
%>