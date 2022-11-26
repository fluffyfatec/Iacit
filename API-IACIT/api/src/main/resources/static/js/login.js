var txtusername = document.getElementById("txtusername");
var txtpassword = document.getElementById("txtpassword")

function login(){
    var username = txtusername.value;
    var password = txtpassword.value;
    console.log(username);
    console.log(password);
    
    if(username == "admin" && password == "admin"){
        alert('Sucesso');
        location.href = "index.html";
    }else{
        alert('Usuario ou senha incorretos');
    }
}
