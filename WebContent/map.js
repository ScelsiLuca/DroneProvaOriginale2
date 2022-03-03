var finestra;
var map;


function initMap() {

    map = new google.maps.Map(
        document.getElementById("map"), {zoom: 12, center:{lat: 45.46452297530038, lng: 9.189282626813764}}
    );
   
    finestra = new google.maps.InfoWindow();
    addMarkers();
    
    map.addListener('click', function() {
        if (finestra) finestra.close();
    });
    
} ;


function addMarkers() {
  var centrale = addMarker({
    coords: {lat: 45.487433512217876, lng:9.205436084655465},
    content: 'Stazione Centrale'
  });
  var duomo = addMarker({
    coords: { lat: 45.46452297530038, lng: 9.189282626813764 },
    content: 'Duomo'
  });
  var sanSiro = addMarker({
    coords: { lat: 45.47694428187834, lng: 9.118550334792761 },
    content: 'San Siro'
  });

  var portaGenova = addMarker({
    coords: { lat: 45.45314460557561, lng:9.169503827056161 },
    content: 'Porta Genova'
  });
  
}

function addMarker(props) {
    var marker = new google.maps.Marker({
      position: props.coords,
      map: map
    });
  
    if (props.content) {
      marker.addListener('click', function() {
        finestra.setContent(props.content);
        finestra.open(map, marker);
      });
    }
    return marker 
 }
 
 /*
 >> PER IMPLEMENTARE IL CLICK CON I MARKER 
 onclick="evidenzia(<%=s.getNome()%>)"
 
 function evidenzia(s) {
	switch (s) {
		case "Duomo" 
	}
} 

*/


        