// This will be the JavaScript file in which I will create the list elements, post them onto page, etc.

var map;
var geocoder;

/**
 * calls needed funcitons to setup index.html
 * 
 * @return None.
 */
function initIndex() {
    getMapKey();
    retrieveEvents();
}

async function retrieveEvents () {
    // Retreives events.
    fetch('/retrieve-events').then(response => response.json()).then((events) => {
        const eventsList = document.getElementById('event-list');
        events.forEach((event) => {
            eventsList.appendChild(createEventElement(event));
                new google.maps.Marker({
                position: {lat: event.address.latitude, lng: event.address.longitude},
                map,
                title: event.description
            });                    
        });
    });
}

function createEventElement(event) {
    const eventElement = document.createElement('div');
    eventElement.className = "card mb-3";

    // Add type of event
    const eventType = document.createElement('h5');
    eventType.className = "card-header";
    eventType.innerText = event.type;

    // Create card body
    const cardBody = document.createElement('div');
    cardBody.className = "card-body";

    // Add address information
    const labelAddress = document.createElement('b');
    labelAddress.innerText = "Location:";
    const streetAddress = document.createElement('p');
    streetAddress.innerText = event.address.address + ', ' + event.address.city;
    street.className = "card-text";
    const state = document.createElement('p');
    state.innerText = event.address.state;
    state.className = "card-text";
    const zipCode = document.createElement('p');
    zipCode.innerText = event.address.zipCode;

    zipCode.className = "card-text";

    // Create date element
    const dateLabel = document.createElement('b');
    dateLabel.innerText = "Date and time:";
    const date = document.createElement('p');
    date.innerText = event.time;
    date.className = "card-text";


    // Create left side of card
    const leftSide = document.createElement('div');
    leftSide.className = "left";
    leftSide.appendChild(labelAddress);
    leftSide.appendChild(street);
    leftSide.appendChild(state);
    leftSide.appendChild(zipCode);
    leftSide.appendChild(dateLabel);
    leftSide.appendChild(date);


    // Add event description
    const descriptionLabel = document.createElement('b');
    descriptionLabel.innerText = "Description:";
    const description = document.createElement('p');
    description.innerText = event.description;
    description.className = "card-text";

    // Create price element
    const priceLabel = document.createElement('b');
    priceLabel.innerText = "Price:";
    const price = document.createElement('p');
    price.innerText = event.price;
    price.className = "card-text";

    // Create right side of card
    const rightSide = document.createElement('div');
    rightSide.className = "right";
    rightSide.appendChild(descriptionLabel);
    rightSide.appendChild(description);
    rightSide.appendChild(priceLabel);
    rightSide.appendChild(price);

    // Append everything to card body
    cardBody.appendChild(left);
    cardBody.appendChild(right);
    
    // Append to eventElement
    eventElement.appendChild(eventType);
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
function placeMapRequest(apiKey){
    let div = document.createElement('div');
    let script = document.createElement('script');

    div.id = 'map';
    script.type = 'text/javascript';
    script.src = 
        'https://maps.googleapis.com/maps/api/js?key=' +
        apiKey +
        '&callback=initMap';

    document.getElementsByTagName('body')[0].insertBefore(
        div,
        document.getElementsByTagName("nav").nextSibling
    );
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
    const mapContainer = document.getElementById("map");

    map = new google.maps.Map(
        document.getElementById("map"),
        {
            center: {lat: 43.8124565, lng: -91.8264293}, 
            zoom: 5,
            mapTypeId: 'terrain'
        }
    );
    
    geocoder = new google.maps.Geocoder();
}
