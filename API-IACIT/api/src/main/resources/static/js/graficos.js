let tipo = ''

function btnlinha(){
    tipo = 'line'
    gerarGrafico()
}

function btnhist(){
    tipo = 'bar'
    gerarGrafico()
}


function gerarGrafico(){

    if (tipo == 'line'){ //LINHA///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        const ctx = document.getElementById('grafico').getContext('2d');
        const myChart = new Chart(ctx, {
            type: tipo,
            data: {
                labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
                datasets: [{
                    label: '# of Votes',
                    data: [12, 19, 3, 5, 2, 3],
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });

    } else { //HISTOGRAMA///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        const ctx = document.getElementById('grafico').getContext('2d');
        const myChart = new Chart(ctx, {
          type: 'bar',
          data: {
            labels: [0, 1, 2, 3, 4, 5],
            datasets: [{
              label: 'Number of Arrivals',
              data: [12, 19, 3, 5, 2, 3],
              backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            }]
          },
          options: {
            scales: {
              xAxes: [{
                display: false,
                barPercentage: 1.3,
                ticks: {
                  max: 3,
                }
              }, {
                display: true,
                ticks: {
                  autoSkip: false,
                  max: 4,
                }
              }],
              yAxes: [{
                ticks: {
                  beginAtZero: true
                }
              }]
            }
          }
        });
    }

}
