//MENU LATERAL / DETALHES
function jsDetalheAjax(dado){
    //alert(dado);
    jsDetalheLimpar();
    //$('#js_detalhe').load('/ajax/detalhe/' + dado);

    if(dado == 'Temperatura'){
        document.getElementById("jsTemperaturaLinha").style.display = "inline";
        document.getElementById("jsTemperaturaBar").style.display = "none";
        document.getElementById("btn").value = dado;
    }

    if(dado == 'Umidade'){
        document.getElementById("jsUmidadeLinha").style.display = "inline";
        document.getElementById("jsUmidadeBar").style.display = "none";
        document.getElementById("btn").value = dado;
    }

    if(dado == 'Ventos'){
        document.getElementById("jsVentoLinha").style.display = "inline";
        document.getElementById("jsVentoBar").style.display = "none";
        document.getElementById("btn").value = dado;
    }

    if(dado == 'PressaoAtmosferica'){
        document.getElementById("jsPressaoLinha").style.display = "inline";
        document.getElementById("jsPressaoBar").style.display = "none";
        document.getElementById("btn").value = dado;
    }

    if(dado == 'Radiacao'){
        document.getElementById("jsRadicaoLinha").style.display = "inline";
        document.getElementById("jsRadicaoBar").style.display = "none";
        document.getElementById("btn").value = dado;
    }

    if(dado == 'Precipitacao'){
        document.getElementById("jsPrecipitacaoLinha").style.display = "inline";
        document.getElementById("jsPrecipitacaoBar").style.display = "none";
        document.getElementById("btn").value = dado;
    }

    document.getElementById("jsBotoes").style.display = "inline";

    // jsTemperaturaLinha
    // jsTemperaturaBar
    // jsUmidadeLinha
    // jsUmidadeBar
    // jsVentoLinha
    // jsVentoBar
    // jsPressaoLinha
    // jsPressaoBar
    // jsRadicaoLinha
    // jsRadicaoBar
    // jsPrecipitacaoLinha
    // jsPrecipitacaoBar

  }

  function btnfnc(linha, bar){
    var btnValor =  document.getElementById("btn").value;
    //alert(btnValor);
    if(btnValor == 'Temperatura'){
        document.getElementById("jsTemperaturaLinha").style.display = linha;
        document.getElementById("jsTemperaturaBar").style.display = bar;
    }

    if(btnValor == 'Umidade'){
        document.getElementById("jsUmidadeLinha").style.display = linha;
        document.getElementById("jsUmidadeBar").style.display = bar;
    }

    if(btnValor == 'Ventos'){
        document.getElementById("jsVentoLinha").style.display = linha;
        document.getElementById("jsVentoBar").style.display = bar; 
    }

    if(btnValor == 'PressaoAtmosferica'){
        document.getElementById("jsPressaoLinha").style.display = linha;
        document.getElementById("jsPressaoBar").style.display = bar;
    }

    if(btnValor == 'Radiacao'){
        document.getElementById("jsRadicaoLinha").style.display = linha;
        document.getElementById("jsRadicaoBar").style.display = bar;
    }

    if(btnValor == 'Precipitacao'){
        document.getElementById("jsPrecipitacaoLinha").style.display = linha;
        document.getElementById("jsPrecipitacaoBar").style.display = bar;
    }
  }


 


  function jsDetalheLimpar(){
    document.getElementById("jsTemperaturaLinha").style.display = "none";
    document.getElementById("jsTemperaturaBar").style.display = "none";
    document.getElementById("jsUmidadeLinha").style.display = "none";
    document.getElementById("jsUmidadeBar").style.display = "none";
    document.getElementById("jsVentoLinha").style.display = "none";
    document.getElementById("jsVentoBar").style.display = "none";
    document.getElementById("jsPressaoLinha").style.display = "none";
    document.getElementById("jsPressaoBar").style.display = "none";
    document.getElementById("jsRadicaoLinha").style.display = "none";
    document.getElementById("jsRadicaoBar").style.display = "none";
    document.getElementById("jsPrecipitacaoLinha").style.display = "none";
    document.getElementById("jsPrecipitacaoBar").style.display = "none";
  }