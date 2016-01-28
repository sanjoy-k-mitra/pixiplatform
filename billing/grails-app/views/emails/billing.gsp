<%--
  Created by IntelliJ IDEA.
  User: sanjoy
  Date: 1/11/16
  Time: 6:27 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>${product.name} Bill</title>
</head>

Dear ${customer.name},

This email is to inform you that your billing cycle has been expired for ${product.name}. In order to keep your subscription active please pay via your preferred method

<g:render template="/emails/memo" model="[product: product]"/>


Thank you for using our product.

sincerely,
Sanjoy

<body>

</body>
</html>