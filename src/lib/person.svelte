<script>
    export let name = ""
    export let id = ""
    export let opinion = ""
</script>

<div class="item">
    <div class="image">
      <img src="https://dp.nea.moe/avatar/{id}.png" alt="Your 1">
    </div>
    <div class="text-container">
      <p class="text1">{name}</p>
      <p class="text2">{opinion}</p>
    </div>
  </div>

<style>
img{
    border-radius: 100%;
}
p{
    font-size: large;
}
.item {
  display: grid;
  grid-template-columns: auto 1fr;
  align-items: center;
}

.image {
  margin-right: 10px; /* Optional: Add spacing between the image and text */
}

.text-container {
  display: grid;
  grid-gap: 5px;
  align-content: center;
}

.text1,
.text2 {
  margin: 0; /* Reset default margins */
}
</style>