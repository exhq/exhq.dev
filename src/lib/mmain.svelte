<script>
  let vite = "e";
  function handleKeyDown() {
    vite += "e";
  }
</script>

<div class="container">
  <div>
    <div class="logocontainer">
      <img
        src="https://dp.nea.moe/avatar/712639419785412668.png"
        class="logo"
        alt="mah sdfghijsjhdf"
      />
    </div>

    <h1>ECHO</h1>

    <p>
      <!-- svelte-ignore a11y-click-events-have-key-events -->
      competitive shitpost<span class="thespan" on:click={handleKeyDown}
        >{vite}</span
      >r
    </p>
  </div>
</div>
 
<div class="thingies">
  <a href="https://twitter.com/exhqwq"><img class="infologos" src="https://upload.wikimedia.org/wikipedia/commons/6/6f/Logo_of_Twitter.svg" alt=""></a>
  <a href="https://github.com/exhq"><img class="infologos" src="https://cdn.discordapp.com/attachments/1026504914131759104/1125801730043547778/tMUQol8.svg" alt=""></a>
</div>

<div class="page1">

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

  .thingies{
    text-align: center;
    justify-content: center;
    place-items: center;
  }

  .infologos{
    max-width: 2%;
  }

  .page1 {
    height: 100vh; /* Make each page take up the full viewport height */
    width: auto; /* Take up full width */
    top: 0;
    left: 0;
  }
  .thespan {
    user-select: none;
  }
  .logocontainer {
    text-align: center;
    border-radius: 100%;
    overflow: hidden;
    height: 10em;
    width: 10em;
  }
  .logo {
    height: 10em;
    width: 10em;
    will-change: filter;
    transition: filter 300ms;
    display: inline-block;
    border-radius: 100%;
  }
  .logo:hover {
    animation: rotate 0.2s infinite linear;
    border-radius: 100%;
    overflow: hidden;
  }

  .container {
    text-align: center;
    display: flex;
    justify-content: center;
    place-items: center;
    margin-top: 10%;
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
