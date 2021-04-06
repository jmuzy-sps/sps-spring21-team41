// This will be the JavaScript file in which I will create the list elements, post them onto page, etc.

/**
 * calls needed funcitons to setup index.html
 * 
 * @return None.
 */
function initIndex() {
    retrieveEvents();
    getMapKey();
}

function retrieveEvents () {
  fetch('/retrieve-events').then(response => response.json()).then((events) => {
    const eventsList = document.getElementById('event-list');
    events.forEach((event) => {
      commentElementList.appendChild(createCommentElement(event));
    })
  });
}

function createCommentElement(event) {
    const eventElement = document.createElement('div');
    eventElement.className = "card mb-3";

    const cardBody = document.createElement('div');
    cardBody.className = "card-body";

    // TODO: This will eventually fill the card with real event 
    //       information
    const sampleText = document.createElement('h5');
    sampleText.innerText = "Testing Event"

    cardBody.appendChild(sampleText);
    eventElement.appendChild(cardBody);

    return eventElement;
}

/** 
 * Fetches google maps api key.
 * 
 * @returns None.
 */
async function getMapKey() {
    const responseFromServer = await fetch('/google-map-key');
    const apiKey = await responseFromServer.text();

    placeMapRequest(apiKey);
}


/** 
 * Dynamically creates and places needed objets (div, script) to host google map
 * 
 * @returns None.
 */
async function placeMapRequest(apiKey){
    let div = document.createElement('div');
    let script = document.createElement('script');

    div.id = 'map';
    script.type = 'text/javascript';
    script.src = 
        'https://maps.googleapis.com/maps/api/js?key=' +
        apiKey +
        '&callback=initMap';

    document.getElementsByTagName('body')[0].appendChild(div);
    document.getElementsByTagName('head')[0].appendChild(script);
    /**
     * TODO: Once the html has more objetcs use document.querySelector
     *       or docuemnt.querySelectorAll to specify div's position in body
     */
}

/** 
 * Creates a map with markes and adds it to the page. 
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