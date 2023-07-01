<script>
import Person from "./person.svelte";
</script>


<h1>just look at these amazing reviews!</h1>

<div class="grid-container">
    <Person source="https://dp.nea.moe/avatar/287555395151593473.png" yeah="INSANE" name="mantikafasi"></Person>
  </div>
  

<style>
.grid-container {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  grid-gap: 10px;
}



</style>