//File to add all needed js code for the createEvent.html

/**
 * Formats form input:
 *      Converts date to epoch value.
 *      Imposes a 2 fix decimal value for the price.
 * 
 * @return none.
 */
function formatInput(){
    /**
     * @type {Object inputHTMLElement} date
     * @type {Object inputHTMLElement} price
     * @type {int} decimalIndex - Index at which the first dot('.') char appears
     *                            in the price's value.
     */
    date = document.querySelector("form#new-event input[name='date']");
    price = document.querySelector("form#new-event span input[name='price']")
    decimalIndex = price.value.indexOf('.');

    date.type = 'text'; //datatime-local type rejects the epoch value.
    date.value = Date.parse(date.value); //Converts to epoch.

    if(decimalIndex == -1){
        price.value += ".00";
    }
    else if(price.value.length > decimalIndex + 3){
        price.value = price.value.slice(0, price.value.indexOf('.') + 3)
    }
}
