'use strict';

/**
 * RailwayStationController
 * @constructor
 */
var RailwayStationController = function($scope, $http) {
    $scope.rs = {};
    $scope.editMode = false;
    
    

    $scope.fetchRailwayStationsList = function() {
        $http.get('railwaystations/railwaystationlist.json').success(function(rsList){
            
            if ($scope.railwaystations != {}){
        		$scope.railwaystations = {};
        	}
        	$scope.railwaystations = rsList;
        	$scope.existsError = false;

        }).error(function(error){
        	console.log("Error: ", error);
        	$scope.existsError = true;
        });
    };

    $scope.addNewRailwayStation = function(rs) {

        $scope.resetError();

        $http.post('railwaystations/add', rs).success(function() {
            $scope.fetchRailwayStationsList();
            $scope.rs.name = '';
            $scope.rs.train.name = '';
            $scope.rs.train.speed = '';
            $scope.rs.train.diesel = false;
        }).error(function() {
            $scope.setError('Could not add a new station');
        });
    };

    $scope.updateRailwayStation = function(rs) {
        $scope.resetError();

        $http.put('railwaystations/update', rs).success(function() {
            $scope.fetchRailwayStationsList();
            $scope.rs.name = '';
            $scope.rs.train.name = '';
            $scope.rs.train.speed = '';
            $scope.rs.train.diesel = false;
            $scope.editMode = false;
        }).error(function() {
            $scope.setError('Could not update the train');
        });
    };

    $scope.editRailwayStation = function(rs) {
        $scope.resetError();
        $scope.rs = rs;
        $scope.editMode = true;
    };

    $scope.removeRailwayStation = function(id) {
        $scope.resetError();

        $http.delete('railwaystations/remove/' + id).success(function() {
            $scope.fetchRailwayStationsList();
        }).error(function() {
            $scope.setError('Could not remove train');
        });
        
        $scope.rs = '';
    };

    $scope.removeAllRailwayStations = function() {
        $scope.resetError();

        $http.delete('railwaystations/removeAll').success(function() {
            $scope.fetchRailwayStationsList();
        }).error(function() {
            $scope.setError('Could not remove all RailwayStations');
        });

    };

    $scope.resetRailwayStationForm = function() {
        $scope.resetError();
        $scope.rs = {};
        $scope.editMode = false;
    };

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.fetchRailwayStationsList();

    $scope.predicate = 'id';
};