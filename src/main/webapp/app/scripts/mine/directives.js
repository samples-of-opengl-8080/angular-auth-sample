angular
.module('mine')
.directive('logout', function(sessionService, $location) {
    return {
        link: function($scope, $element) {
            $element.on('click', function() {
                sessionService
                    .logout()
                    .then(function() {
                        $location.path('/');
                    });
                return false;
            });
        }
    };
});
