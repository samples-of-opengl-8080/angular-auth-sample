angular
.module('mine')
.controller('LoginController', function($scope, sessionService, $location) {
    
    $scope.login = function() {
        sessionService.login({
            password: $scope.password,
            valid: function() {
                $location.path('/sample');
            },
            invalid: function() {
                $scope.message = 'パスワードが不正です。';
            }
        });
    };
})
.controller('SampleController', function($scope, sampleService) {
    
    $scope.request = function() {
        sampleService
            .request()
            .then(function(response) {
                $scope.datetime = response.data;
            });
    };
});
