angular.module('appMarket', []).controller('angularController', function($scope, $http){
    $scope.page
    $scope.listProducts = function(){
        $http({
            url: 'http://localhost:8180/market/app/products',
            metod: 'GET',
            params: {}
        }).then(function(response){
            $scope.products = response.data;
            });
    };

    $scope.infoOfProduct = function(idProduct){
         $http({
            url: 'http://localhost:8180/market/app/products/' + idProduct,
            metod: 'GET',
            params: {}
            }).then(function(response){
                alert(response.data.id + " - " + response.data.title + " - " + response.data.price);
                });
    };

    $scope.deleteOfProduct = function(idProduct){
             $http({
                url: 'http://localhost:8180/market/app/products/delete/' + idProduct,
                metod: 'GET',
                params: {}
                }).then(function(response){
                    $scope.listProducts();
                    });
        };

    $scope.listProducts();
});