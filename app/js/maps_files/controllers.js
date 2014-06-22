var whsMapper = angular.module('whsMapper', ['ngResource']);

var alerter = function() {
	window.alert("Alert!");
}

whsMapper.controller('MapCtrl', ['$scope', '$resource',  

	function ($scope, $resource) {
		$scope.testData = 'Budapest';

		var dataService = $resource('/whs/all')
		$scope.sites = dataService.query();				 

		$scope.latitude;
		$scope.longitude;

		$scope.addMarker = function(siteLatitude, siteLongitude) {
			var myLatlng = new google.maps.LatLng(siteLatitude, siteLongitude);
  			var marker = new google.maps.Marker({
        	
        	position: myLatlng,
        	map: map,
        	title:"Hello World!"});

		};

		// $scope.addMarkerManually = function() {
		// 	var myLatlng = new google.maps.LatLng($scope.latitude, $scope.longitude);
  // 			var marker = new google.maps.Marker({
        	
  //       	position: myLatlng,
  //       	map: map,
  //       	title:"Hello World!"});
		// };
			
		}

	]);