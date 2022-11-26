window.onload = function () {
  // Parses the document body and
  // inserts <img> tags in place of Unicode Emojis
  twemoji.parse(
    document.body,
    { folder: "svg", ext: ".svg" } // This is to specify to Twemoji to use SVGs and not PNGs
  );
};

function getRandomInt(min, max) {
  min = Math.ceil(min);
  max = Math.floor(max);
  return Math.floor(Math.random() * (max - min + 1)) + min;
}

const titles = [
  "i work out",
  "funny",
  "Kara Kara Kara no Kara",
  "26047",
  "Can I Friend You On Bassbook? Lol",
  "im gay",
  "cognrjatulations !!!",
  "futanari",
  "ubuntu (ew)",
  "phantoms are annoying",
  "/give @a hugs 999999",
  "[Object object]",
  "please add command support vendy",
  "mrekk",
  "women fear me",
  "fish fear me",
  "men turn their eyes away from me",
  "as i walk no beast dares makes a sound",
  "i am alone in this barren earth",
  "uptown funk you up",
  "stackoverflow my beloved",
  "*thrusts into you*",
  "also what are these for?",
  "its morbing time",
  "bungling bungus",
  "rate this base.apk Architecture splits: \nconfig.arm64_v8a.apk \nconfig.armeabi_v7a.apk \nconfig.x86_64.apk \n config.x86.apk \n DPI splits: \n config.hdpi.apk \n config.xxhdpi.apk \n Language splits: \nconfig.de.apk \n config.en.apk",
  "Now explode",
  "“message logger when”",
  "A wild ⛧artificialmusik appeared.",
  "IS THAT A MOTHERUCFKCING JOJOI REFERENCE???//?",
  "Cats are not ducks",
  "just farted",
  "ReeK - Making Zurek While Getting A Flandre Fumo Shoved Up My A-",
  "what the fuck is an lsp log",
  "'ewwo evewypony",
  "also, what the fuck is a mustard",
  "727",
  "WYFSI",
  "that time i reincarnated as a toilet in another world",
  "vim >>>>>> emacs",
  "also try out archlinux.org",
  "how to print [[this, this, and, this, all, together as a single string]]?",
  "😢",
  "None.",
  "deez nuts",
  "trolley",
  "i want to live in piece",
  "fill me with happiness",
  "you're downbad",
  "do not use code nopo",
];

/*const funnysentence = [
  'when i was 13 i sent a pic of my feet covered in peanut butter and sent it to my crush and texted him "hope you dont have a peanut allergy"',
  "that could be us\nfat amoungus baby role play?",
  "🤯",
  "this is why your parents change the subject when people ask about you",
  '<a href="https://en.m.wikipedia.org/wiki/Trollface">https://en.m.wikipedia.org/wiki/Trollface</a>',
  "hololive more like homosexual sex",
];*/

document.title = titles[Math.floor(Math.random() * titles.length)];

//button bs
let audio, bool;
if (new Date().getMonth() === 9) {
  console.log("boo");
  audio = new Audio("boo.mp3");
} else {
  audio = new Audio("for-maeve.mp3");
}
function no() {
  bool = !bool;
  if (bool) {
    audio.play();
  } else {
    audio.pause();
  }
}

var helpme = [
  ["ECHO", "712639419785412668", "i love homosexual people"],
  ["gay porn", "370280028732260363", "hololive more like homosexual sex"],
  [
    "jimbobcooter",
    "565248101615665152",
    "i mean makima sus af, they make a point to say that the devils are coming after denji and there seems to be an odd reason she keeps him so close, the drinking scene really sold me on this as she seemed to know something about him and the others even suggested that other devils have intimate knowledge of the chainsaw devil",
  ],
];

const swapElm = document.getElementById("b");

swapElm.addEventListener("mouseover", () => {
  const prev = swapElm.style.transform;
  if (!prev || prev === "translateX(0px)")
    swapElm.style.transform = "translateX(200%)";
  else swapElm.style.transform = "translateX(0px)";
});

var a = getRandomInt(0, helpme.length - 1);
var b = helpme.length - 1;

const funny = document.getElementById("dm");
funny.innerHTML = `
<discord-message id="funny" style="font-family: discord;" author="${helpme[a][0]}" avatar="https://dp.nea.moe/avatar/${helpme[a][1]}">
${helpme[a][2]}
        </discord-message>
`;
