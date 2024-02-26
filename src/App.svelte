<script async>
  import Main from "./lib/mmain.svelte";
  import ProgressBar from "./lib/progressBar.svelte";
  import { writable } from "svelte/store";
  import handlecommands from "./handlecommands";
  import Person from "./lib/person.svelte";
    import { onMount } from "svelte";
  const history = writable([]);
  let buffer = "";
  export let lmao = false;
  let ps1 = ">"




  function handleinput(input) {
   history.update((arr) => {
     return [...arr, ps1 + input, handlecommands(input)]
   });
   requestAnimationFrame(() => {
     let x = document.getElementsByClassName("terminal")[0]
     x.scrollTo({top: x.scrollHeight})
   })
  }
  addEventListener("resize", (event) => {
   let x = document.getElementsByClassName("terminal")[0]
   //x.scrollTo({top: x.scrollHeight})
  });

  
 document.addEventListener("keydown", function meow(event) {
   if (event.key === "t") {
     for (const el of document.querySelectorAll("input")) { // might be a performance issue moment but shrug -Erik
       if (document.activeElement == el) return;
     };
     lmao = true;
     document.removeEventListener("keydown", meow);
     document.addEventListener("keydown", function meow(event) {
       if (event.key == "Backspace") {
         buffer = buffer.slice(0, -1);
       } else if (event.key == " ") {
         event.preventDefault();
         buffer += " ";
       } else if (["Control", "Shift"].indexOf(event.key) !== -1) return;
       else if (event.key == "Enter") {
         handleinput(buffer);
         buffer = "";
       } else {
         buffer += event.key;
       }
     });
   }
 });

  // @ts-ignore
  function handleKeyPress(event) {
  if (event.code === "Enter") {
    let text = document.getElementById("idkwhattocallthis");
    // @ts-ignore
    sendToDiscordWebhook(text);
  }
}





async function getLatestItems(apiUrl) {
  try {
    const response = await fetch(apiUrl);
    if (!response.ok) {
      throw new Error(`API call failed with status ${response.status}`);
    }
    const data = await response.json();
    // Check if data is an array
    if (!Array.isArray(data)) {
      throw new Error('API response is not an array');
    }
    // Slice the last 5 items
    const lastFive = data.slice(-5);
    // Print or use the lastFive array as needed
    return lastFive;
  } catch (error) {
    console.error('Error fetching data:', error);
  }
}

let kys = writable([]);

// Assuming getLatestItems returns a promise that resolves to an array
async function fetchKys() {
    try {
        const data = await getLatestItems("https://review.exhq.dev/getreviews");
        kys.set(data); // Update the value of kys
    } catch (error) {
        console.error("Error:", error);
    }
}

// Call fetchKys when the component is mounted
onMount(fetchKys);


</script>



{#if lmao}
  <div class="terminal">
    {#each $history as string}
      {@html string}
      <br />
    {/each}
    >{buffer}|
  </div>
{/if}

<main>


  <Main />
  
  <h1 class="skills">my skills</h1>
  <ProgressBar value={10} name="gaming" />
  <ProgressBar value={1000000} name="shitposting" />
  <ProgressBar value={1} name="being useful" />
  <ProgressBar
    value={69}
    name="i ran out of stuff but press t for a surprise"
  />
  
</main>
<br />
<br />
<br />
<br />

<h1>just look at these amazing reviews!</h1>
<div class="grid-container">
{#each $kys as item}
    <!-- Render each item -->
    <Person
    id={item.discordID}
    opinion={item.reviewText}
  />
{/each}
</div>
<!-- svelte-ignore a11y-invalid-attribute -->
<a href="https://discord.com/oauth2/authorize?client_id=1208380910525743134&response_type=token&redirect_uri=https%3A%2F%2Freview.exhq.dev%2F&scope=identify">send your shitty ass reviews here, fuck you kas</a>

<style>
  .grid-container {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
    grid-gap: 20px;
  }
  .terminal::-webkit-scrollbar {
  display: none;
  }
  .terminal {
    background-color: #0000003f;
    position: fixed;
    width: 30%;
    height: 40%;
    word-wrap: break-word;
    overflow-y: auto;
    -ms-overflow-style: none;  /* IE and Edge */
     scrollbar-width: none;  /* Firefox */
  }
</style>
