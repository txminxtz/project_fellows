/**
 * Abrir Mapa
 */
function abrirMapa() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(position) {
            var latitude = position.coords.latitude;
            var longitude = position.coords.longitude;
            var url = "https://www.google.com/maps?q=" + latitude + "," + longitude;
            window.open(url, "_blank");
        }, function(error) {
            alert("Não foi possível obter sua localização.");
        });
    } else {
        alert("Geolocalização não é suportada por este navegador.");
    }
}
