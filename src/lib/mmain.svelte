<script>
    function handleKeyDown() {
    console.log("hi");
  }
</script>

<img src="https://dp.nea.moe/avatar/712639419785412668.png" class="logo" alt="Svelte Logo" />
<h1>ECHO</h1>

<p>
yes, this is the default <span on:click={handleKeyDown}>vite</span> template <br> yes, im working on it.
</p>


<style>
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

@keyframes rotate {
  from {
    transform: rotate(0deg);
  }
  to {
    transform: rotate(360deg);
  }
}
</style>