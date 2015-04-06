var signup = angular.module('signup', []);
signup.controller('signupController', function ($scope, $http, $location) {
    $scope.signup = function () {
        $http.post('/signup', {"user_Id": $scope.userName, "password": $scope.password})
            .success(function (data, status, headers, config) {
                if (data.type == "success") {
                    console.log("hi");
                    console.log(window.location.href);
                    window.location.href="/";
                } else {
                    console.log("not right");
                    $scope.noexist = true;
                }
            });
    }
});