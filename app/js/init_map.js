var map;

      function initialize() {
        var mapOptions = {
          // center: new google.maps.LatLng(-34.397, 150.644),
          center: new google.maps.LatLng(0, 0),
          zoom: 2
        };


        map = new google.maps.Map(document.getElementById("map-canvas"),
            mapOptions);
      }

      google.maps.event.addDomListener(window, 'load', initialize);