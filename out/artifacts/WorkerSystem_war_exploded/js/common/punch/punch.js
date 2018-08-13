var getLocation = function () {
    if(navigator.geolocation){
        var getOptions = {
            enableHighAccuracy:true,
            timeout: 2000
        };
        navigator.geolocation.getCurrentPosition(getSuccess, getError, getOptions);
    }else {
        var sub = document.getElementById("sub");
        sub.removeAttribute("disabled");
    }
};

var getWebLocation = function () {
    if(navigator.geolocation){
        var getOptions = {
            enableHighAccuracy:false,
            timeout: 1000
        };
        navigator.geolocation.getCurrentPosition(getSuccess, getWebError, getOptions);
    }
};

var getSuccess = function (position) {
    var sub = document.getElementById("sub");
    var location = document.getElementsByName("location")[0];
    location.value = position.coords.latitude + "," + position.coords.longitude + "," + position.coords.altitude;
    sub.removeAttribute("disabled");
};

var getError = function(error){
    var sub = document.getElementById("sub");
    switch(error.code) {
        case error.TIMEOUT:
            sub.removeAttribute("disabled");
            console.log('定位超时');
            break;
        case error.PERMISSION_DENIED:
            sub.removeAttribute("disabled");
            console.log('用户拒绝提供地理位置');
            break;
        case error.POSITION_UNAVAILABLE:
            getWebLocation();
            break;
        default:
            sub.removeAttribute("disabled");
            break;
    }
};

var getWebError = function(error){
    var sub = document.getElementById("sub");
    switch(error.code) {
        case error.TIMEOUT:
            sub.removeAttribute("disabled");
            console.log('定位超时');
            break;
        case error.PERMISSION_DENIED:
            sub.removeAttribute("disabled");
            console.log('用户拒绝提供地理位置');
            break;
        case error.POSITION_UNAVAILABLE:
            sub.removeAttribute("disabled");
            console.log('地理位置不可用');
            break;
        default:
            sub.removeAttribute("disabled");
            break;
    }
};