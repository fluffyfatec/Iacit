function filtroEstado(){
    var opcestado = document.getElementById('selectestado').value;
    console.log(opcestado);
}

function filtroEstacao(){
    var opcestacao = document.getElementById('selectestacao').value;
    console.log(opcestacao);
}
function filtroData(){
    var opcdata = document.getElementById('selectdata').value;
    console.log(opcdata);
}

function filtrar(){
    filtroEstado();
    filtroEstacao();
    filtroData();

}
