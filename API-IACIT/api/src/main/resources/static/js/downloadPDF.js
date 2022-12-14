

function jsGraficosPDF(chart1, chart2, tela) {

    const canvas = document.getElementById(chart1);
    const canvas2 = document.getElementById(chart2);

    //criando a imagem a partir do gráfico
    const canvasImage = canvas.toDataURL('image/png', 1);
    const canvasImage2 = canvas2.toDataURL('image/png', 1);

    //variáveis para o texto do PDF
    var estado = document.getElementById('estado');
    var estacao = document.getElementById('estacao');
    var dataMin = document.getElementById('dtMin');
    var dataMax = document.getElementById('dtMax');

    //passando a imagem para o pdf
    let pdf = new jsPDF('landscape');
    pdf.setFontSize(24);
    pdf.setFont('helvetica', 'bold');
    pdf.text(15, 15, ["Estação " + estacao.innerText + ", Estado de " + estado.innerText, " "]);
    pdf.setFont('helvetica', '');
    pdf.text(15, 15, [" ", "Dados de " + dataMin.innerText + " até " + dataMax.innerText]);
    pdf.addImage(canvasImage, 'PNG', 10, 35, 275, 150);
    pdf.addPage();
    pdf.addImage(canvasImage2, 'PNG', 10, 30, 275, 150);
    pdf.save('Gráficos ' + tela + ' (' + estacao.innerText + ').pdf');

}

