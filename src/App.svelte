<script>
import Main from "./lib/mmain.svelte";
import ProgressBar from "./lib/progressBar.svelte"
import { writable } from 'svelte/store';

const history = writable([]);
let buffer = ""
let lmao = false

function handleinput(input){
    history.update(arr => [...arr, ">" + input]);
    if (input == "exit"){
        lmao = false
    } else {
        history.update(arr => [...arr, "unknown command"]);
    }
}

document.addEventListener("keydown", function meow(event) {
  if (event.key === 't') {
    lmao = true
    document.removeEventListener("keydown", meow);
    document.addEventListener("keydown", function meow(event) {
    if (event.key == "Backspace") {
        buffer = buffer.slice(0, -1);
    } else if (event.key == " ") {
        event.preventDefault()
        buffer += " "
    } else if (event.key == "Shift") return  
    else if (event.key == "Enter") {
        handleinput(buffer)
        buffer = ""
    }  
    else {
        buffer += event.key;
    }
});
  }
});



</script>
{#if lmao}
  <div class="terminal">
    {#each $history as string}
      {string}
      <br>
    {/each}
    >{buffer}|
  </div>
{/if}

<main>
<Main/>



<h1 class="skills">my skills</h1>
<ProgressBar value = {10} name = "gaming" />
<ProgressBar value = {1000000} name = "shitposting" />
<ProgressBar value = {1} name = "being useful" />
<ProgressBar value = {69} name = "i ran out of stuff but press t for a surprise" />
</main>

<style>
    .terminal{
        background-color: #0000003f;
        position: fixed;
        width: 30%;
        height: 40%;
        word-wrap: break-word;
    }
</style>

