<script>
    export let name = ""
    export let id = ""
    export let opinion = ""
    export let website = ""
  function redir(){
    window.location.href = website;
  }

</script>

<div class="item">
  <div class="image">
    <a class="actualimage"href="{website}"><img src="https://dp.nea.moe/avatar/{id}.png" alt="Your 1"></a>
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
    word-wrap: break-word;
}
.item {
  display: grid;
  grid-template-columns: auto 1fr;
  align-items: center;
}

.image {
  margin-right: 10px; 
  transition: 0.2s;
}

.actualimage:hover{
  filter: brightness(50%);
}

.actualimage::after {
  content: "view website";
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -150%);
  text-align: center;
  background-color: #00000044;
  color: rgb(0, 255, 179);
}
  .image:hover::after {
    opacity: 1;
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