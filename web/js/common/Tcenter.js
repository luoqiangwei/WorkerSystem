var numreg=/^\d+$/;

var phoneNumberCheck = function () {
    var phoneNumberInput = document.getElementById("perro");
    var phoneNumber = document.getElementById("cPhoneNumber");

    if(numreg.test(phoneNumber.value) == false){
        phoneNumber.value = phoneNumber.value.substring(0, phoneNumber.value.length - 1);
        phoneNumberInput.innerText = "只能输入数字。";
    }else{
        phoneNumberInput.innerText = "";
    }

    if(phoneNumber.value.length > 11){
        phoneNumber.value = phoneNumber.value.substring(0, phoneNumber.value.length - 1);
        phoneNumberInput.innerText = "只能输入11位数字。";
    }
};

var SidCheck = function () {
    var sid = document.getElementById("csid");
    var sidInput = document.getElementById("serro");

    if(numreg.test(sid.value) == false){
        sid.value = sid.value.substring(0, sid.value.length - 1);
        sidInput.innerText = "只能输入数字。";
    }

    if(phoneNumber.value.length > 4) {
        sid.value = sid.value.substring(0, sid.value.length - 1);
        sidInput.innerText = "只能输入4位职工号。";
    }
};

var qqCheck = function () {
    var qq = document.getElementById("cqq");
    var qqInput = document.getElementById("qqerro");
    if(numreg.test(qq.value) == false){
        qq.value = qq.value.substring(0, qq.value.length - 1);
        qqInput.innerText  = "只能输入数字。";
    }
};

var clearAll = function () {
    var phoneNumber = document.getElementById("cPhoneNumber");
    var sidInput = document.getElementById("serro");
    var qqInput = document.getElementById("qqerro");
    phoneNumber.innerText = "";
    sidInput.innerText = "";
    qqInput.innerText = "";
};

var changeToPass= function () {
    var baseInfo = document.getElementsByClassName("base")[0];
    var passwd = document.getElementsByClassName("passwd")[0];
    var change = document.getElementById("changeMode");
    change.innerText = "更改基本信息";
    change.onclick = changeToBase;
    baseInfo.style.display = "none";
    passwd.style.display = "block";
}

var changeToBase = function () {
    var baseInfo = document.getElementsByClassName("base")[0];
    var passwd = document.getElementsByClassName("passwd")[0];
    var change = document.getElementById("changeMode");
    change.innerText = "更改密码";
    change.onclick = changeToPass;
    passwd.style.display = "none";
    baseInfo.style.display = "block";
}