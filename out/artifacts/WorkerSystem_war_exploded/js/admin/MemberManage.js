var showFind = function () {
    var find1 = document.getElementsByClassName("find")[0];
    var find2 = document.getElementsByClassName("find")[1];
    var unfind = document.getElementsByClassName("unfind")[0];
    find1.style.display = "block";
    find2.style.display = "block";
    unfind.style.display = "none";
}

var showFullAdd = function () {
    var show = document.getElementsByClassName("show")[0];
    var add = document.getElementsByClassName("add")[0];
    show.style.display = "none";
    add.style.display = "block";
}