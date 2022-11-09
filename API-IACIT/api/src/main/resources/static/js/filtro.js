
  document.getElementById("jsRegiao").onchange = function() {filtroRegiao()};
  
  //COMBO BOX - REGIÃO
  function filtroRegiao(){
    var jsFiltroRegiao = document.getElementById("jsRegiao").value;
    if(jsFiltroRegiao == ''){
      $('#jsrecebeRegiao').load('/filtro/ajax');
      $('#jv_classe').load('/filtro/ajax');
    }else{
      $('#jsrecebeRegiao').load('/filtro/ajax');
      $('#jv_classe').load('/filtro/ajax');
      $('#jsrecebeRegiao').load('/ajax/filtro/' + jsFiltroRegiao);
      document.getElementById("jsRecebeRegiao").value = jsFiltroRegiao;
    }
  }

  //COMBO BOX - ESTADO
  function FiltroRegiaoEstado(){
      var jsfiltroEstado = document.getElementById("jsfiltroEstadoRegiao");
      var jsEstado = jsfiltroEstado.options[jsfiltroEstado.selectedIndex].text;
      document.getElementById("jsRecebeEstado").value = jsEstado;
      if(jsEstado == 'Escolha o Estado...'){
        $('#jv_classe').load('/filtro/ajax');
      }else{
        $('#jv_classe').load('/filtro/ajax/' + jsEstado);
    }
  }

  //COMBO BOX - ESTAÇÃO
  function filtroEstacao() {  
    var jsAjaxFiltro = document.getElementById("jsAjaxFiltro");
    var opcaoTexto = jsAjaxFiltro.options[jsAjaxFiltro.selectedIndex].text;
    //alert(opcaoTexto);
    document.getElementById("jsRecebeEstacao").value = opcaoTexto;
  }
 
  //RECEBENDO DATA CAPTAÇÃO MINIMA
  document.getElementById("jsEnviaDataMin").onchange = function() {filtroDataMin()};
  function filtroDataMin() {
        var jsEnviaDataMin = document.getElementById("jsEnviaDataMin").value;
        var jsData = jsEnviaDataMin.substring(0, 10);
        var jsHora = jsEnviaDataMin.substring(11);
        var jsHora = jsHora.substring(0,2);
        var jsHora = jsHora + ':00:00';
        document.getElementById("jsRecebeDataMin").value = jsData + ' ' + jsHora;
        validaData();
  }

    //RECEBENDO DATA CAPTAÇÃO MAXIMA
    document.getElementById("jsEnviaDataMax").onchange = function() {filtroDataMax()};
    function filtroDataMax() {
          var jsEnviaDataMax = document.getElementById("jsEnviaDataMax").value;
          var jsData = jsEnviaDataMax.substring(0, 10);
          var jsHora = jsEnviaDataMax.substring(11);
          var jsHora = jsHora.substring(0,2);
          var jsHora = jsHora + ':00:00';
          document.getElementById("jsRecebeDataMax").value = jsData + ' ' + jsHora;
          validaData();
    }
  
  //VALIDADOR DE DATAS
  function validaData(){
    var jsEnviaDataMax = document.getElementById("jsEnviaDataMax").value;
    var jsEnviaDataMin = document.getElementById("jsEnviaDataMin").value;

    if(jsEnviaDataMin > jsEnviaDataMax && jsEnviaDataMax != ''){
      alert("Erro! data Maxima menor que data Minima");
      document.getElementById("jsEnviaDataMin").value = '';
      document.getElementById("jsEnviaDataMax").value = '';
    }
  }
////////////////////////////////////////////////////////////////////////////////////////////////////////  
//////////////////////////////////////////////////////////////////////////////////////////////////////// 
//////////////////////////////////////////////////////////////////////////////////////////////////////// 

 //MENU LATERAL / DETALHES
  function jsMenuAjax(dado){
    //alert(dado);
    var jsOutraPagRegiao = document.getElementById("jsOutraPagRegiao").value;
     jsOutraPagRegiao = jsOutraPagRegiao.replaceAll(" ", "*");

    var jsOutraPagEstacao = document.getElementById("jsOutraPagEstacao").value;
     jsOutraPagEstacao = jsOutraPagEstacao.replaceAll(" ", "*");
  
    var jsOutraPagEstado = document.getElementById("jsOutraPagEstado").value;
     jsOutraPagEstado = jsOutraPagEstado.replaceAll(" ", "*");

    var jsOutraPagDataMin = document.getElementById("jsOutraPagDataMin").value;
     jsOutraPagDataMin = jsOutraPagDataMin.replaceAll(" ", "*");

    var jsOutraPagDataMax = document.getElementById("jsOutraPagDataMax").value;
     jsOutraPagDataMax = jsOutraPagDataMax.replaceAll(" ", "*");
  
    //console.log(jsOutraPagRegiao);
    //console.log(jsOutraPagEstacao);
    //console.log(jsOutraPagEstado);
    //console.log(jsOutraPagDataMin);
    //console.log(jsOutraPagDataMax);
    //console.log('/' + dado + '/' + jsOutraPagRegiao + '/' + jsOutraPagEstacao + '/' + jsOutraPagEstado + '/' + jsOutraPagDataMin + '/' + jsOutraPagDataMax);
    
    $('#js_body').load('/' + dado + '/' + jsOutraPagRegiao + '/' + jsOutraPagEstacao + '/' + jsOutraPagEstado + '/' + jsOutraPagDataMin + '/' + jsOutraPagDataMax);
     
    setTimeout(function(){jsFiltroDashboard();},500);
    // SE
    // SAO PAULO - INTERLAGOS
    // SP
    // 2022-06-27 10:00:00
    // 2022-06-28 10:00:00


  }

  //ABRE A MODAL FILTRO
  function jsAbrirModalFiltro(){
      $("#ModalFiltro").modal({
      show: true
    });
  }

  //ABRE A MODAL FILTRO
  function jsAbrirModalInfo(){
      $("#ModalInfo").modal({
      show: true
    });
  }

  function jsTelaUsuario(){
    $('#js_body').load('/telausuario');
  }

////////////////////////////////////////////////////////////////////////////////////////////////////////  
//////////////////////////////////////////////////////////////////////////////////////////////////////// 
//////////////////////////////////////////////////////////////////////////////////////////////////////// 

//TRATANDO DATA TOPO DA PAGINA
function jsFiltroDashboard() {
  //alert('jsFiltroDashboard');
  dtMin();
  dtMax();
  jsRegiaoPag();
  validaPag();
  // jsDetalheAjax("Temperatura");
}

//TRATANDO DATA MAXIMA - TOPO DA PAGINA
function dtMax() {

    var jsFiltroData = document.getElementById("jsRecebeDataMax").value;
    
    if(jsFiltroData == ''){
      //alert(jsFiltroData);
    }else{
      var jsAno = jsFiltroData.substring(0, 10);
      var jsAno = jsAno.split('-').reverse().join('/');
      var jsHora = jsFiltroData.substring(11);
      var jsHora = jsHora.substring(0,2);
      var jsHora = jsHora + ':00:00';
      var jsConsolidado = jsAno + ' ' + jsHora;
      document.getElementById("dtMax").innerHTML = jsConsolidado;
    }
 }

//TRATANDO DATA MINIMA - TOPO DA PAGINA
function dtMin() {

  var jsFiltroData = document.getElementById("jsRecebeDataMin").value;
  
  if(jsFiltroData == ''){
    //alert(jsFiltroData);
  }else{
    var jsAno = jsFiltroData.substring(0, 10);
    var jsAno = jsAno.split('-').reverse().join('/');
    var jsHora = jsFiltroData.substring(11);
    var jsHora = jsHora.substring(0,2);
    var jsHora = jsHora + ':00:00';
    var jsConsolidado = jsAno + ' ' + jsHora;
    document.getElementById("dtMin").innerHTML = jsConsolidado;
  }
}

//TRATANDO REGIÃO
function jsRegiaoPag() {

  var jsRecebeRegiao = document.getElementById("jsRecebeRegiao").value;

  if(jsRecebeRegiao == 'CO'){
    document.getElementById("regiao").innerHTML = "Centro-Oeste";
  }
  if(jsRecebeRegiao == 'N'){
    document.getElementById("regiao").innerHTML = "Norte";
  }
  if(jsRecebeRegiao == 'NE'){
    document.getElementById("regiao").innerHTML = "Nordeste";
  }
  if(jsRecebeRegiao == 'SE'){
    document.getElementById("regiao").innerHTML = "Sudeste";
  }
  if(jsRecebeRegiao == 'S'){
    document.getElementById("regiao").innerHTML = "Sul";
  }
}

function validaPag() {
 
  var valida = document.getElementById("jsOutraPag").value;

  if(valida == "/filtroTemp"){
    jsMenuAjax('Temperatura');
  }

  if(valida == "/filtroUmi"){
    jsMenuAjax('Umidade');
  }

  if(valida == "/filtroVen"){
    jsMenuAjax('Ventos');
  }

  if(valida == "/filtroRad"){
    jsMenuAjax('Radiacao');
  }
  
  if(valida == "/filtroPreci"){
    jsMenuAjax('Precipitacao');
  }

  if(valida == "/filtroPressao"){
    jsMenuAjax('PressaoAtmosferica');
  }

}