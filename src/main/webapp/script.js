// This will be the JavaScript file in which I will create the list elements, post them onto page, etc.

async function getMapKey() {
    const responseFromServer = await fetch('/google-map-key');
    const apiKey = await responseFromServer.text();

    placeMapRequest(apiKey)
}


/** 
 * Dinamically creates and places needed objets (div, script) to host google map
 * 
 * @returns None.
 */
async function placeMapRequest(apiKey){
    let div = document.createElement('div');
    let scrpit = document.createElement('script');

    div.id = 'map'
    scrpit.type = 'text/javascript';
    scrpit.src = 
        'https://maps.googleapis.com/maps/api/js?key=' +
        apiKey +
        '&callback=initMap';

    document.getElementsByTagName('body')[0].appendChild(div);
    docuemnt.getElementsByTagName('head')[0].appendChild(scrpit);
    /**
     * TODO: Once the html has more objetcs use document.querySelector
     *       or docuemnt.querySelectorAll to specify div's position in body
     */
}

/** 
 * Creates a map with maerkes and adds it to the page. 
 * 
 * @returns None.
 */
function initMap() {
    let map = new google.maps.Map(
        document.getElementById("map"),
        {
            center: {lat: 43.8124565, lng: -91.8264293}, 
            zoom: 5,
            mapTypeId: 'terrain'
        }
    );
}