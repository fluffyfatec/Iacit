var txtusername = document.getElementById("txtusername");
var txtpassword = document.getElementById("txtpassword");

function login(){

    var username = txtusername.value;
    var password = txtpassword.value;

    if(username == "admin" && password == "admin"){
        alert('Sucesso');
        location.href = "/home";
    }else{
        alert('Usuario ou senha incorretos');
    }


}
