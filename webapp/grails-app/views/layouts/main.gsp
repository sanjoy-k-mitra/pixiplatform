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
                    <a href="/">IHT-Barisal</a>
                </div>
            </div>
            <ul class="nav navbar-nav">
                <ul class="nav navbar-nav navbar-right">
                    <li class="${controllerName == 'account' ? 'active' : ''}"><g:link controller="account">Accounts</g:link> </li>
                    <li class="${controllerName == 'payment' ? 'active' : ''}"><g:link controller="payment">Payments</g:link> </li>

                </ul>
            </ul>
        </div>
    </header>

    <div class="container-fluid">
        <g:layoutBody/>
        <div class="footer" role="contentinfo"></div>
        <div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>

    </div>

    </body>
</html>
