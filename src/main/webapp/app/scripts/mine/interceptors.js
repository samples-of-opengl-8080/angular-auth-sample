angular
.module('mine')
.factory('SessionInterceptor', function($q, $location) {
    return {
        responseError: function(response) {
            // サーバーからのレスポンスが 401 ならトップページに強制遷移する
            if (response.status === 401) {
                $location.path('/');
            }
            
            return $q.reject(response);
        }
    };
});
