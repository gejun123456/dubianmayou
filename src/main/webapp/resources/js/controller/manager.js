//var b = a;
//console.log(b);
var mai = angular.module('managerUser', ['ui.grid', 'ui.grid.edit']);
mai.controller('managerController', ['$scope', function ($scope) {
    console.log("hi");
    $scope.name = "nimei";
    console.log(bb);
    $scope.myData = bb;
    $scope.gridOptions = {
        enableSorting: true,
        columnDefs: [
            {name: 'firstName', field: 'first-name'},
            {name: '1stFriend', field: 'friends[0]'},
            {name: 'city', field: 'address.city'},
            {name: 'getZip', field: 'getZip()', enableCellEdit: false}
        ],
        data: [{
            "first-name": "Cox",
            "friends": ["friend0"],
            "address": {street: "301 Dove Ave", city: "Laurel", zip: "39565"},
            "getZip": function () {
                return this.address.zip;
            }
        }
        ]
    };

}]);