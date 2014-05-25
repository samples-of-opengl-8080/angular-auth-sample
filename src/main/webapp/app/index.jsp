<!DOCTYPE html>
<html ng-app="mine">
  <head>
    <meta charset="UTF-8" />
  </head>
  <body>
    
    <div ng-view></div>
    
    <script type="text/javascript" src="<c:url value="/app/scripts/vendor/angularjs/angular.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/app/scripts/vendor/angularjs/angular-route.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/app/scripts/mine/app.js" />"></script>
    <script type="text/javascript" src="<c:url value="/app/scripts/mine/interceptors.js" />"></script>
    <script type="text/javascript" src="<c:url value="/app/scripts/mine/services.js" />"></script>
    <script type="text/javascript" src="<c:url value="/app/scripts/mine/controllers.js" />"></script>
    <script type="text/javascript" src="<c:url value="/app/scripts/mine/directives.js" />"></script>
  </body>
</html>
