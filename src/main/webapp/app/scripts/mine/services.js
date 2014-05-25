angular
.module('mine')
.service('sessionService', function($http) {
    this.logout = function() {
        return $http.delete('rest/session');
    };
    
    this.inquire = function(whenInvalid) {
        $http.get('rest/session');
    };
    
    this.login = function(opt) {
        var data = {
            password: opt.password
        };
        
        $http
            .post('rest/session', data)
            .success(function(data, status, headers, config) {
                opt.valid();
            })
            .error(function(data, status, headers, config) {
                if (status === 401) {
                    opt.invalid();
                }
            });
    };
})
.service('sampleService', function($http) {
    this.request = function() {
        return $http.get('rest/sample');
    };
});
