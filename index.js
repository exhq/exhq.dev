function shuffleArray(array) {
  for (let i = array.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [array[i], array[j]] = [array[j], array[i]];
  }
  return array;
}



const moveImage = () => {
  var img = document.getElementById("poofed");
  var imgWidth = img.offsetWidth;
  var imgHeight = img.offsetHeight;
  var containerWidth = window.innerWidth - imgWidth - 400;
  var containerHeight = window.innerHeight - imgHeight - 400;
  var randomX = Math.floor(Math.random() * containerWidth);
  var randomY = Math.floor(Math.random() * containerHeight);

  if (randomX < 0) {
    randomX = 0;
  } else if (randomX > containerWidth) {
    randomX = containerWidth;
  }

  if (randomY < 0) {
    randomY = 0;
  } else if (randomY > containerHeight) {
    randomY = containerHeight;
  }

  img.style.left = randomX + "px";
  img.style.top = randomY + "px";
}

let keysPressed = [];

document.addEventListener("keydown", (event) => {
  const keyPressed = event.key;
  keysPressed.push(keyPressed);

  const typedWord = keysPressed.join("");
  if (typedWord.includes("funny")) {
    console.log("Match found: " + typedWord);
    alert("hahahahaha funny laugh hahahahh");
    keysPressed = [];
  } else if (typedWord.includes("osu")) {
    window.location.href = "https://www.youtube.com/watch?v=AaAF51Gwbxo&t=65s";
  }
});

document.addEventListener("contextmenu", (event) => {
  event.preventDefault();
  alert("no rightclick for you bitchass")
});



function nomoreecho() {
  const bleh = ['E','C','H','O']
  let echo = document.getElementById("name")

  echo.innerText = shuffleArray(bleh).join("") 
  
}


function happynote(){
  alert(`all shitposting aside, i owe a huge thanks to the vencord community. 
they're the reason this website exists (they bullied my old domain)`)
}