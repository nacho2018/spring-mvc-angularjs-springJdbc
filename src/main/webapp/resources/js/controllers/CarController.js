'use strict';

/**
 * CarController
 * @constructor
 */
var CarController = function($scope, $http) {
	
	
	$scope.deleteMsg = 'List of cars erased!';
	
	
    $scope.fetchCarsList = function() {
    	$scope.existsError = false;
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
    	$scope.existsError = false;
        $http.post('cars/addCar/' + newCar).success(function() {
            $scope.fetchCarsList();
        });
        $scope.carName = '';
    };

    $scope.removeCar = function(car) {
    	$scope.existsError = false;
    	console.log("carId: ", car.id);
        $http.get('cars/removeCar/' + car.id).success(function() {
        	$scope.rowDeleted = true;
            $scope.fetchCarsList();
        }).error(function(){
        	console.log("Error: ", error);
        	$scope.existsError = true;
        });
    };

    $scope.removeAllCars = function() {
    	$scope.existsError = false;
        $http.delete('cars/removeAllCars').success(function() {
            //$scope.fetchCarsList();
        	$scope.cars = [];
        	
        });

    };

    $scope.fetchCarsList();
    
    $scope.closeDelete = function(){
    	
    	if ($scope.rowDeleted){
    		$('#dRowDeleted').css('display', 'none');
    		$scope.rowDeleted = false;
    	}
    };
};