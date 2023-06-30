<script>
    let vite = "e"
  function handleKeyDown(){
    vite += "e"
  }
</script>


<div class="container">
  <div class="page1">
    <img src="https://dp.nea.moe/avatar/712639419785412668.png" class="logo" alt="Svelte Logo" />
<h1>ECHO</h1>

<p>
competitive shitpost<span class="thespan" on:click={handleKeyDown}>{vite}</span>r
</p>
  </div>
</div>





<style>
:root {
  font-family: Inter, system-ui, Avenir, Helvetica, Arial, sans-serif;
  line-height: 1.5;
  font-weight: 400;

  color-scheme: light dark;
  color: rgba(255, 255, 255, 0.87);
  background-color: #242424;

  font-synthesis: none;
  text-rendering: optimizeLegibility;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  -webkit-text-size-adjust: 100%;
}


h1 {
  font-size: 3.2em;
  line-height: 1.1;
}


@media (prefers-color-scheme: light) {
  :root {
    color: #213547;
    background-color: #ffffff;
  }
  a:hover {
    color: #747bff;
  }
  button {
    background-color: #f9f9f9;
  }
}

.page1 {
  height: 100vh; /* Make each page take up the full viewport height */
  width:auto; /* Take up full width */
  top: 0;
  left: 0;
}
  .thespan { 
    user-select: none;
  }
  .logo {
    height: 10em;
    padding: 1.5em;
    will-change: filter;
    transition: filter 300ms;
    border-radius: 100%;
  }
  .logo:hover {
  animation: rotate 0.2s infinite linear;
}


.container {
  text-align: center;
    display: grid;
    place-items: center;
    height: 100vh; /* adjust to your desired height */
  }

  .centered-div {
    text-align: center;
  }

@keyframes rotate {
  from {
    transform: rotate(0deg);
  }
  to {
    transform: rotate(360deg);
  }
}
</style>