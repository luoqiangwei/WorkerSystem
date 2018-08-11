var phoneNumberCheck = function () {
    var phoneNumberInput = document.getElementById("perro");
    var phoneNumber = document.getElementById("cPhoneNumber");
    var reg=/^\d+$/;
    if(reg.test(phoneNumber.value) == false){
        phoneNumber.value = phoneNumber.value.substring(0, phoneNumber.value.length - 1);
        phoneNumberInput.innerText = "只能输入数字！";
    }else{
        phoneNumberInput.innerText = "";
    }

    if(phoneNumber.value.length > 11){
        phoneNumber.value = phoneNumber.value.substring(0, phoneNumber.value.length - 1);
        phoneNumberInput.innerText = "只能输入11位数字！";
    }
} 

var clearphone = function () {
    var phoneNumberInput = document.getElementById("perro");
    var phoneNumber = document.getElementById("cPhoneNumber");
    alert("s");
}