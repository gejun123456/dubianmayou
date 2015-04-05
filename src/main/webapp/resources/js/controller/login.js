/**
 * Created by Administrator on 4/4/2015.
 */
var loginA = angular.module('login', []);
loginA.controller('loginController', function ($scope, $http, $location) {
    $scope.login = function () {
        console.log("nimei");
        console.log($scope.userName);
        console.log($scope.password);
        $http.post('/login', {"user_Id": $scope.userName, "password": $scope.password})
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
