
  //MENU LATERAL / DETALHES
  function jsMenuAjax(dado){
    //alert(dado);
    $('#js_body').load('/' + dado);
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

  //EXECUTA O AJAX FILTRO
  function filtroAjax() {
    var jsEstasdo = document.getElementById("jsEnviaEstado").value;
    
    if(jsEstasdo == ''){
      $('#jv_classe').load('/filtro/ajax');
    }else{
      $('#jv_classe').load('/filtro/ajax/' + jsEstasdo);
      
    }
  }

  //RECEBENDO - ESTADO
   document.getElementById("jsEnviaEstado").onchange = function() {filtroEstado(); filtroAjax()};
   function filtroEstado() {
       var jsFiltroEstado = document.getElementById("jsEnviaEstado").value;
       document.getElementById("jsRecebeEstado").value = jsFiltroEstado;
   }


  //RECEBENDO ESTACAO
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
    }


  //TRATANDO DATA TOPO DA PAGINA
  function jsFiltroDashboard() {

      var jsFiltroData = document.getElementById("jsRecebeData").value;
      
      if(jsFiltroData == ''){
        //alert(jsFiltroData);
      }else{
        var jsAno = jsFiltroData.substring(0, 10);
        var jsAno = jsAno.split('-').reverse().join('/');
        var jsHora = jsFiltroData.substring(11);
        var jsHora = jsHora.substring(0,2);
        var jsHora = jsHora + ':00:00';
        var jsConsolidado = jsAno + ' ' + jsHora;
        document.getElementById("ano").innerHTML = jsConsolidado;
      }
   }
