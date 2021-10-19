var map;
var layer;

$(function(){
	var setlat = 127.5;
	var setlon = 36.4;
	map = new ol.Map({
		target : 'map',	//html 요소 ID
		layers : [	//지도 기본 타일 설정
					new ol.layer.Tile({
						type : 'base',	//지도 종류
						source : new ol.source.XYZ({url: 'http://xdworld.vworld.kr:8080/2d/Base/201802/{z}/{x}/{y}.png'})	//VWorld
					})
		],
		view : new ol.View({
				center : ol.proj.fromLonLat([setlat, setlon]),
				zoom : 8
		}),
	});
	
	//클릭하면 위도 경도 값 저장
	map.on("click", function(event) { 
		//좌표값 가져오기
		var coordinate = event.coordinate;
		//좌표 > 경위도 변환
		var transform = ol.proj.transform(coordinate, 'EPSG:3857', 'EPSG:4326')
		//소수점 자리수 정하기
		var lon = transform[1].toFixed(6);
		var lat = transform[0].toFixed(6);
		
		console.log("경도 : " + lon);
		console.log("위도 : " + lat);
		
		addMarker(lon, lat);
	});
	
})

function addMarker(lon, lat){
	//기존 마커 삭제
	map.removeLayer(layer);
	
	//마커 feature 설정
	var feature = new ol.Feature({
		geometry : new ol.geom.Point(ol.proj.fromLonLat([lat, lon]))
	});
	
	//마커 style 설정
	var style = new ol.style.Style({
		image : new ol.style.Icon({
			anchor : [0.5, 20],
			anchorXUnits: 'fraction',
            anchorYUnits: 'pixels',
            src: 'http://map.vworld.kr/images/ol3/marker_blue.png'
		}),
	});
	
	//마커 레이어에 들어갈 소스 생성
    var source = new ol.source.Vector({
		features: [feature]
    });
	
	layer = new ol.layer.Vector({
		source : source,
		style : style,
		name : 'MARKER'
	});

    // 지도에 마커 추가
    map.addLayer(layer);

}

