<script>
  function getRandomChild(array) {
  const randomIndex = Math.floor(Math.random() * array.length);
  return array[randomIndex];
}
  let chosenname = "ECHO"
  let vite = "e";
  function handleKeyDown() {
    vite += "e";
  }
  const names = [
    "zak",
    "placeholder1",
    "placeholder2",
    "i have no idea what i am",
    "stupid bitchass",
    "useless",
  
  ]
  function anime() {
  chosenname += "│";
  let name = chosenname;
  let iterations = name.length;

  // Define a helper function to update the name and chosenname values
  const updateName = (i) => {
    name = name.slice(0, i) + name.slice(i + 1);
    chosenname = name + "│";
  };

  // Use a loop and setTimeout to update the name and chosenname values
  for (let i = name.length - 1; i >= 0; i--) {
    setTimeout(() => {
      updateName(i);
    }, (name.length - i) * 100); // Delay in milliseconds
  }
  
  // Execute the following code after the setTimeout iterations complete
  setTimeout(() => {
    let buffer = getRandomChild(names);
    chosenname = "│";
    for (let i = 0; i <= buffer.length; i++) {
      setTimeout(() => {
        chosenname = buffer.slice(0, i) + "│";
      }, (i + 1) * 200); // Delay multiplied by the iteration index
    }
    chosenname = chosenname.slice(0, chosenname.length - 1);
    // Remove the │ at the end
    setTimeout(() => {
      chosenname = chosenname.slice(0, chosenname.length - 1);
    }, (buffer.length + 2) * 200); // Delay for buffer.length + 2 seconds
  }, (iterations + 1) * 100); // Delay for an additional second to ensure the iterations are complete
}



</script>

<div class="container">
  <div>
    <div class="logocontainer">
      <img
        src="https://adu.shiggy.fun/v1/712639419785412668/avatar"
        class="logo"
        alt="mah sdfghijsjhdf"
      />
    </div>
  </div>
</div>

<div class="textcontainer">
  <h1 class="name" on:click={anime}>{chosenname}</h1>

    <p>
      <!-- svelte-ignore a11y-click-events-have-key-events -->
      competitive shitpost<span class="thespan" on:click={handleKeyDown}
        >{vite}</span
      >r
    </p>
</div>


<div class="thingies">
  <a href="https://twitter.com/exhqwq" data-text="exhqwq">
    <img
      class="infologos"
      src="https://upload.wikimedia.org/wikipedia/commons/6/6f/Logo_of_Twitter.svg"
      alt=""
    />
  </a>
</div>

<div class="page1" />

<style>
  .name {
    user-select: none;
    cursor: pointer;
  }
  .textcontainer{
    text-align: center;
  }
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

  .thingies {
    text-align: center;
    justify-content: center;
    place-items: center;
  }
  .thingies a:hover::after {
    transform: translateX(-50%) translateY(100%);
    content: attr(data-text);
    position: absolute;
    padding: 5px;
    background-color: #000;
    color: #fff;
    border-radius: 5px;
    white-space: nowrap;
    opacity: 0.8;
  }
  .infologos {
    max-width: 2em;
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
