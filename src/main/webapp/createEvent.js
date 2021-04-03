function formatInput(){
    date = document.querySelector("form#new-event input[name='date']");
    price = document.querySelector("form#new-event span input[name='price']")
    decimalIndex = price.value.indexOf('.');

    date.type = 'text';
    date.value = Date.parse(date.value);

    if(decimalIndex == -1){
        price.value += ".00";
    }
    else if(price.value.length > decimalIndex + 3){
        price.value = price.value.slice(0, price.value.indexOf('.') + 2)
    }
}
