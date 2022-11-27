var txtusername = document.getElementById("txtusername");
var txtpassword = document.getElementById("txtpassword");

function login(){

    var username = txtusername.value;
    var password = txtpassword.value;

    location.href = "/validalogin/" + username + "/" + password;

    if(username == "admin" && password == "admin"){
        //alert('Sucesso');
    }else{
        //alert('Usuario ou senha incorretos');
    }
}
