let estacao =  document.getElementById('estacao')
let estado =  document.getElementById('estado')
let data =  document.getElementById('data')

function filtroEstacao(){
    var opcestacao = document.getElementById('selectestacao').value;
    estacao.innerHTML = `${opcestacao}`
}

function filtroEstado(){
    var opcestado = document.getElementById('selectestado').value;
    estado.innerHTML = `${opcestado}` 
}

function filtroData(){
    var opcdata = document.getElementById('selectdata').value;
    data.innerHTML = `${opcdata}`
}

function filtrar(){
    filtroEstacao();
    filtroEstado();
    filtroData();
}