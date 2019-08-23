var randomScalingFactor = function() {
    return Math.round(Math.random() * 100);
  };
  var randomColorFactor = function() {
    return Math.round(Math.random() * 255);
  };
  var randomColor = function(opacity) {
    return 'rgba(' + randomColorFactor() + ',' + randomColorFactor() + ',' + randomColorFactor() + ',' + (opacity || '.3') + ')';
  };
  
  var config = {
    type: 'doughnut',
    data: {
      datasets: [{
        data: [
          25,
          75,
        ],
        backgroundColor: [
          "#FF0000",
          "#32CD32",
        ],
        label: 'Expenditures'
      }],
      labels: [
        "Erros: 25%",
        "Acertos: 75%",
      ]
    },
    options: {
      responsive: true,
      legend: {
        position: 'bottom',
      },
      title: {
        display: false,
        text: 'Chart.js Doughnut Chart'
      },
      animation: {
        animateScale: true,
        animateRotate: true
      },
      tooltips: {
        callbacks: {
          label: function(tooltipItem, data) {
              var dataset = data.datasets[tooltipItem.datasetIndex];
            var total = dataset.data.reduce(function(previousValue, currentValue, currentIndex, array) {
              return previousValue + currentValue;
            });
            var currentValue = dataset.data[tooltipItem.index];
            var percentage = Math.floor(((currentValue/total) * 100)+0.5);         
            return percentage + "%";
          }
        }
      }
    }
  };
  
  
  var ctx = document.getElementById("chart-area").getContext("2d");
  window.myDoughnut = new Chart(ctx, config); {
  
  }