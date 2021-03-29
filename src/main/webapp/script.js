	function addHyphen (element) {
    	let ele = document.getElementById(element.id);
        ele = ele.value.split('-').join('');    // Remove dash (-) if mistakenly entered.
        let finalVal = ele.match(/.{1,3}/g).join('-');
        document.getElementById("date").value = finalVal;
    }