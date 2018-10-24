'use strict';

/**
 * CarController
 * @constructor
 */
var CarController = function($scope, $http) {
	
	
	$scope.deleteMsg = 'List of cars erased!';
	
    $scope.fetchCarsList = function() {
        $http.get('cars/carlist.json').success(function(carList){
        	if ($scope.cars != {}){
        		$scope.cars = {};
        	}
        	$scope.cars = carList;
        	$scope.existsError = false;
        }).error(function(error){
        	console.log("Error: ", error);
        	$scope.existsError = true;
        });
    	
    		
    	
    	
    };

    $scope.addNewCar = function(newCar) {
        $http.post('cars/addCar/' + newCar).success(function() {
            $scope.fetchCarsList();
        });
        $scope.carName = '';
    };

    $scope.removeCar = function(car) {
        $http.delete('cars/removeCar/' + car).success(function() {
            $scope.fetchCarsList();
        });
    };

    $scope.removeAllCars = function() {
        $http.delete('cars/removeAllCars').success(function() {
            //$scope.fetchCarsList();
        	$scope.cars = [];
        	
        });

    };

    $scope.fetchCarsList();
};