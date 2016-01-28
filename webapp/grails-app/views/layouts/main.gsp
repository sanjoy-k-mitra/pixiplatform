<!doctype html>
<html lang="en" class="no-js">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title><g:layoutTitle default="Grails"/></title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <asset:stylesheet src="application.css"/>
        <asset:javascript src="application.js"/>

        <g:layoutHead/>
    </head>
    <body>
    <header id="grailsLogo" role="banner" class="navbar navbar-static-top navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <div class="navbar-brand">
                    <a href="/">Webnit-Billing</a>
                </div>
            </div>
            <ul class="nav navbar-nav">
                <sec:ifAnyGranted roles="ROLE_USER,ROLE_ADMIN">
                    <li class="${controllerName == 'customer' ? 'active' : ''}"><g:link controller="customer">Customers</g:link> </li>
                    <li class="${controllerName == 'service' ? 'active' : ''}"><g:link controller="serviceProduct">Services</g:link> </li>
                    <li class="${controllerName == 'subscription' ? 'active' : ''}"><g:link controller="subscription">Subscriptions</g:link> </li>

                </sec:ifAnyGranted>
                <sec:ifAllGranted roles="ROLE_ADMIN">
                    <li class="${controllerName == 'user' ? 'active' : ''}"><g:link controller="user">Users</g:link> </li>
                    <li class="${controllerName == 'userRole' ? 'active' : ''}"><g:link controller="userRole">User Roles</g:link> </li>
                </sec:ifAllGranted>
                %{--<ul class="nav navbar-nav navbar-right">--}%
                    %{--<li class="${controllerName == 'account' ? 'active' : ''}"><g:link controller="account">Accounts</g:link> </li>--}%
                    %{--<li class="${controllerName == 'payment' ? 'active' : ''}"><g:link controller="payment">Payments</g:link> </li>--}%

                %{--</ul>--}%
            </ul>
            <sec:ifLoggedIn>
                <form class="navbar-right form-horizontal" method="post" action="/logout">
                    <button class="btn btn-default" type="submit">Logout</button>
                </form>
            </sec:ifLoggedIn>

        </div>
    </header>

    <div class="container-fluid">
        <g:layoutBody/>
        <div class="footer" role="contentinfo"></div>
        <div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>

    </div>

    </body>
</html>
