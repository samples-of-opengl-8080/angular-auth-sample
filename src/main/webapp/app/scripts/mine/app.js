angular
.module('mine', ['ngRoute'])
.config(function($httpProvider) {
    $httpProvider.interceptors.push('SessionInterceptor');
})
.config(function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'app/view/login.html',
            controller: 'LoginController',
            needsAuth: false
        })
        .when('/sample', {
            templateUrl: 'app/view/sample.html',
            controller: 'SampleController',
            needsAuth: true
        });
})
.run(function($rootScope, sessionService, $location) {
    // ページが切り換わるごとに、認証が必要なページの場合はサーバーにセッションの問い合わせを行う
    $rootScope.$on('$routeChangeSuccess', function(event, current, next) {
        if (current.needsAuth) {
            sessionService.inquire();
        }
    });
});
