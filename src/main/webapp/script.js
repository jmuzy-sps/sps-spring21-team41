// This will be the JavaScript file in which I will create the list elements, post them onto page, etc.

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