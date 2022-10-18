//MENU LATERAL / DETALHES
function jsDetalheAjax(dado){
    //alert(dado);
    jsDetalheLimpar();
    //$('#js_detalhe').load('/ajax/detalhe/' + dado);

    document.getElementById("temperaturaMin").style.backgroundColor = "#0c4289";
    //document.getElementById("temperaturaMin").style.borderRadius = "3px";
    document.getElementById("temperaturaMax").style.backgroundColor = "#0c4289";
    //document.getElementById("temperaturaMax").style.borderRadius = "3px";
    document.getElementById("temperaturaAr").style.backgroundColor = "#0c4289";
    //document.getElementById("temperaturaAr").style.borderRadius = "3px";
    document.getElementById("temperaturaOrvalhoMin").style.backgroundColor = "#0c4289";
    //document.getElementById("temperaturaOrvalhoMin").style.borderRadius = "3px";
    document.getElementById("temperaturaOrvalhoMax").style.backgroundColor = "#0c4289";
    //document.getElementById("temperaturaOrvalhoMax").style.borderRadius = "3px";
    document.getElementById("temperaturaPontoOrvalho").style.backgroundColor = "#0c4289";
    //document.getElementById("temperaturaPontoOrvalho").style.borderRadius = "3px";

    document.getElementById("umidadeRelativaMin").style.backgroundColor = "#3e87e5";
    //document.getElementById("umidadeRelativaMin").style.borderRadius = "3px";
    document.getElementById("umidadeRelativaMax").style.backgroundColor = "#3e87e5";
    //document.getElementById("umidadeRelativaMax").style.borderRadius = "3px";
    document.getElementById("umidadeRelativaAr").style.backgroundColor = "#3e87e5";
    //document.getElementById("umidadeRelativaAr").style.borderRadius = "3px";

    document.getElementById("ventoVelocidade").style.backgroundColor = "#3e87e5";
    //document.getElementById("ventoVelocidade").style.borderRadius = "3px";
    document.getElementById("ventoRajadaMax").style.backgroundColor = "#3e87e5";
    //document.getElementById("ventoRajadaMax").style.borderRadius = "3px";

    document.getElementById("pressaoAtmMin").style.backgroundColor = "#0c4289";
    //document.getElementById("pressaoAtmMin").style.borderRadius = "3px";
    document.getElementById("pressaoAtmMax").style.backgroundColor = "#0c4289";
    //document.getElementById("pressaoAtmMax").style.borderRadius = "3px";
    document.getElementById("pressaoAtmEstacao").style.backgroundColor = "#0c4289";
    //document.getElementById("pressaoAtmEstacao").style.borderRadius = "3px";

    document.getElementById("radiacaoGlobal").style.backgroundColor = "#236ecf";
    //document.getElementById("radiacaoGlobal").style.borderRadius = "3px";

    document.getElementById("precipitacaototal").style.backgroundColor = "#3e87e5";
    //document.getElementById("precipitacaototal").style.borderRadius = "3px";

    if(dado == 'Temperatura'){
        document.getElementById("jsTemperaturaLinha").style.display = "inline";
        document.getElementById("jsTemperaturaBar").style.display = "none";
        document.getElementById("btn").value = dado;

        document.getElementById("temperaturaMin").style.backgroundColor = "#6c757d";
        document.getElementById("temperaturaMin").style.borderRadius = "3px";
        document.getElementById("temperaturaMax").style.backgroundColor = "#6c757d";
        document.getElementById("temperaturaMax").style.borderRadius = "3px";
        document.getElementById("temperaturaAr").style.backgroundColor = "#6c757d";
        document.getElementById("temperaturaAr").style.borderRadius = "3px";
        document.getElementById("temperaturaOrvalhoMin").style.backgroundColor = "#6c757d";
        document.getElementById("temperaturaOrvalhoMin").style.borderRadius = "3px";
        document.getElementById("temperaturaOrvalhoMax").style.backgroundColor = "#6c757d";
        document.getElementById("temperaturaOrvalhoMax").style.borderRadius = "3px";
        document.getElementById("temperaturaPontoOrvalho").style.backgroundColor = "#6c757d";
        document.getElementById("temperaturaPontoOrvalho").style.borderRadius = "3px";
    }

    if(dado == 'Umidade'){
        document.getElementById("jsUmidadeLinha").style.display = "inline";
        document.getElementById("jsUmidadeBar").style.display = "none";
        document.getElementById("btn").value = dado;

        document.getElementById("umidadeRelativaMin").style.backgroundColor = "#6c757d";
        document.getElementById("umidadeRelativaMin").style.borderRadius = "3px";
        document.getElementById("umidadeRelativaMax").style.backgroundColor = "#6c757d";
        document.getElementById("umidadeRelativaMax").style.borderRadius = "3px";
        document.getElementById("umidadeRelativaAr").style.backgroundColor = "#6c757d";
        document.getElementById("umidadeRelativaAr").style.borderRadius = "3px";
    }

    if(dado == 'Ventos'){
        document.getElementById("jsVentoLinha").style.display = "inline";
        document.getElementById("jsVentoBar").style.display = "none";
        document.getElementById("btn").value = dado;

        document.getElementById("ventoVelocidade").style.backgroundColor = "#6c757d";
        document.getElementById("ventoVelocidade").style.borderRadius = "3px";
        document.getElementById("ventoRajadaMax").style.backgroundColor = "#6c757d";
        document.getElementById("ventoRajadaMax").style.borderRadius = "3px";
    }

    if(dado == 'PressaoAtmosferica'){
        document.getElementById("jsPressaoLinha").style.display = "inline";
        document.getElementById("jsPressaoBar").style.display = "none";
        document.getElementById("btn").value = dado;

        document.getElementById("pressaoAtmMin").style.backgroundColor = "#6c757d";
        document.getElementById("pressaoAtmMin").style.borderRadius = "3px";
        document.getElementById("pressaoAtmMax").style.backgroundColor = "#6c757d";
        document.getElementById("pressaoAtmMax").style.borderRadius = "3px";
        document.getElementById("pressaoAtmEstacao").style.backgroundColor = "#6c757d";
        document.getElementById("pressaoAtmEstacao").style.borderRadius = "3px";
    }

    if(dado == 'Radiacao'){
        document.getElementById("jsRadicaoLinha").style.display = "inline";
        document.getElementById("jsRadicaoBar").style.display = "none";
        document.getElementById("btn").value = dado;

        document.getElementById("radiacaoGlobal").style.backgroundColor = "#6c757d";
        document.getElementById("radiacaoGlobal").style.borderRadius = "3px";
    }

    if(dado == 'Precipitacao'){
        document.getElementById("jsPrecipitacaoLinha").style.display = "inline";
        document.getElementById("jsPrecipitacaoBar").style.display = "none";
        document.getElementById("btn").value = dado;

        document.getElementById("precipitacaototal").style.backgroundColor = "#6c757d";
        document.getElementById("precipitacaototal").style.borderRadius = "3px";
    }

    document.getElementById("jsBotoes").style.display = "inline";

    //#0D4A99
    // temperaturaMin
    // temperaturaMax
    // temperaturaAr
    // temperaturaOrvalhoMin
    // temperaturaOrvalhoMax
    // temperaturaPontoOrvalho

    // #277AE6
    // umidadeRelativaMin
    // umidadeRelativaMax
    // umidadeRelativaAr

    // #4596FF
    // ventoVelocidade
    // ventoRajadaMax

    // #0D4A99
    // pressaoAtmMin
    // pressaoAtmMax
    // pressaoAtmEstacao

    // #277AE6
    // radiacaoGlobal

    // #4596FF
    // precipitacaototal



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