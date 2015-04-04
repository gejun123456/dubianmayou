/**
 * Created by Administrator on 4/4/2015.
 */
var loginA = angular.module('login', []);
loginA.controller('loginController', function ($scope) {
    $scope.login = function () {
        console.log("nimei");
        console.log($scope.userName);
        console.log($scope.password);
    }
});
