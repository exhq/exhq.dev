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
