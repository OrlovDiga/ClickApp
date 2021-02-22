let url = 'http://localhost:8080/click';
let pathIncrement = '/increment';

function getClick() {
    httpTemplate('GET', url);
}

function increment() {
    httpTemplate('POST', url + pathIncrement);
}

function httpTemplate(request, url) {
    var http = new XMLHttpRequest();
    http.open(request, url, true);

    http.onreadystatechange = function() {//Call a function when the state changes.
        if(http.status === 200) {
            document.getElementById("kek").innerHTML = http.responseText;
        } else {
            alert('Click app not available');
        }
    }
    http.send(null);
}
window.onload = runScheduler;

function runScheduler() {
    setInterval(getClick, 1000);
}