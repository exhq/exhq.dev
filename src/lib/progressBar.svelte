<script>
    export let name = "";
    export let value = 0; // The current value of the progress bar
    export let max = 100; // The maximum value of the progress bar
  </script>
  
  <style>
    .progress-bar {
      width: 90%;
      background-color: transparent;
      height: 20px;
      overflow: hidden;
    }
  
    .progress-bar-fill {
      height: 100%;
      background-color: dodgerblue;
      transition: width 0.3s ease;
    }
  </style>
  <h2>{name}</h2>

  <div class="progress-bar">
    <div class="progress-bar-fill" style="width: {value / max * 100}%"></div>
  </div>
  