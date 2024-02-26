<script>
  export let id = "";
  export let opinion = "";

  let lmao;

  async function fetchJsonFromApi(apiUrl) {
    try {
      const response = await fetch(apiUrl);
      if (!response.ok) {
        throw new Error(`API call failed with status ${response.status}`);
      }
      const jsonData = await response.json();
      return jsonData;
    } catch (error) {
      console.error("Error fetching data:", error);
      throw error;
    }
  }

  (async () => {
    try {
      lmao = await fetchJsonFromApi("https://adu.shiggy.fun/v1/" + id + ".json");
    } catch (error) {
      console.error("Error:", error);
    }
  })();
</script>

<div class="item">
  <div class="image">
    <img src="https://dp.nea.moe/avatar/{id}.png" alt="Your 1" />
  </div>
  <div class="text-container">
    <p class="text1">{(lmao && lmao.username) || ''}</p>
    <p class="text2">{opinion}</p>
</div>
</div>

<style>
  img {
    border-radius: 100%;
  }
  p {
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

  .actualimage:hover {
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
    opacity: 0;
  }
  .actualimage:hover::after {
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
