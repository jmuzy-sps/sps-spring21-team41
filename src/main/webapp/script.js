// This will be the JavaScript file in which I will create the list elements, post them onto page, etc.

/**
 * calls needed funcitons to setup index.html
 * 
 * @return None.
 */
function initIndex() {
    getMapKey();
    retrieveEvents();
}

function retrieveEvents () {
  fetch('/retrieve-events').then(response => response.json()).then((events) => {
    const eventsList = document.getElementById('event-list');
    events.forEach((event) => {
        eventsList.appendChild(createEventElement(event));
    })
  });
}

function createEventElement(event) {
    const eventElement = document.createElement('div');
    eventElement.className = "card mb-3";

    const cardBody = document.createElement('div');
    cardBody.className = "card-body";

    // Add type of event
    const eventType = document.createElement('h5');
    eventType.innerText = event.type;

    // Add address information
    const address = document.createElement('div');
    const street = document.createElement('p');
    street.innerText = event.address.address;
    const state = document.createElement('p');
    state.innerText = event.address.state;
    const zipCode = document.createElement('p');
    zipCode.innerText = event.address.zipCode;
    address.appendChild(street);
    address.appendChild(state);
    address.appendChild(zipCode);

    // Add event details
    const details = document.createElement('p');
    details.innerText = event.details;

    // Create date element
    const date = document.createElement('p');
    date.innerText = event.time;

    // Create price element
    const price = document.createElement('p');
    price.innerText = event.price;

    // Append everything to card body
    cardBody.appendChild(eventType);
    cardBody.appendChild(address);
    cardBody.appendChild(details);
    cardBody.appendChild(date);
    cardBody.appendChild(price);
    
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
    map = new google.maps.Map(
        document.getElementById("map"),
        {
            center: {lat: 43.8124565, lng: -91.8264293}, 
            zoom: 5,
            mapTypeId: 'terrain'
        }
    );
}

/**
 * Adds a marker with the address as a label for each event dispayed fetched.
 * 
 * @param {String} Address - Event's address (ex. 123 Alameda st.)
 * 
 * @return None.
 *  */
function CreateMarker(Address) {

}