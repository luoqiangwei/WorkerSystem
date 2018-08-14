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

var showFullModify = function (sid, name, email, phone, qq, sex, isEff) {
    var show = document.getElementsByClassName("show")[0];
    var modify = document.getElementsByClassName("modify")[0];
    var sidInput = document.getElementById("sid");
    sidInput.value = sid;
    var nameInput = document.getElementById("name");
    nameInput.value = name;
    var emailInput = document.getElementById("email");
    emailInput.value = email;
    var phoneInput = document.getElementById("phone");
    phoneInput.value = phone;
    var qqInput = document.getElementById("qq");
    qqInput.value = qq;
    var sexT = document.getElementById("sexT");
    var sexF = document.getElementById("sexF");
    if(sex == "true"){
        sexT.selected = true;
    }else{
        sexF.selected = true;
    }
    var isET = document.getElementById("isET");
    var isEF = document.getElementById("isEF");
    if(isEff == "true"){
        isET.selected = true;
    }else{
        isEF.selected = true;
    }
    show.style.display = "none";
    modify.style.display = "block";
}