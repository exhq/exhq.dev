let no = document.getElementById("sotrue");
no.innerHTML = `<div id="sotrue" class="flex-c-1">
<div class="flex-c-r">
  <img onclick="bruh()"
    src="https://dp.nea.moe/avatar/712639419785412668.png"
    alt="clientpicture"
    class="pfp"
  />
  <h1 onclick="lmao()" >ECHO</h1>
</div>
<p>shitty programmer | MtF | they/them</p>
</div>`;

let bool;
let beat = new Audio("./music.mp3");
function lmao() {
  bool = !bool;
  if (bool) {
    beat.play();
  } else {
    beat.pause();
  }
}
function getRandomInt(min, max) {
  min = Math.ceil(min);
  max = Math.floor(max);
  return Math.floor(Math.random() * (max - min + 1)) + min;
}
async function load(url) {
  return await (await fetch(url)).json();
}
async function bruh() {
  load(
    "https://literallyafuckingjsonfile.literallyafuckingjsonfile.workers.dev/"
  ).then((data) => {
    const funnyLaughingDiscordMessageToDisplayIEnjoy =
      data[getRandomInt(0, data.length - 1)];

    fetch(
      `https://dp.nea.moe/avatar/${funnyLaughingDiscordMessageToDisplayIEnjoy.from}.json`
    )
      .then((it) => it.json())
      .then((authorData) => {
        const dm = document.getElementById("sotrue");
        dm.innerHTML = `<div id="sotrue" class="flex-c-1">
        <div class="flex-c-r">
          <img onclick="bruh()"
            src="${authorData.avatar}"
            alt="clientpicture"
            class="pfp"
          />
          <h1 onclick="lmao()" >${authorData.username}</h1>
        </div>
        <p>${funnyLaughingDiscordMessageToDisplayIEnjoy.text}</p>
        </div>`;
        twemoji.parse(dm);
      });
  });
}
