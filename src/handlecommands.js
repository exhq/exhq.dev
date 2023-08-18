const commands = {};

let gaycolors = [
    "#16171a",
    "#7f0622",
    "#ff8426",
    "#ffd100",
    "#ff2674",
    "#234975",
    "#bfff3c",
    "#007899"
]

function registerCommand(commandName, handler) {
    commands[commandName] = handler;
}

export default function handleCommands(input) {
    const args = input.trim().split(/ +/)
    const command = args.shift()?.toLowerCase()

    try {
        return commands[command](args);
    } catch (e) {
        if (e instanceof TypeError) {
            return "unknown command"
        } else {
            return "some horrible shit happened, contact echo"
        }

    }
}

registerCommand("add", (args) => {
    return (+args[0]) + (+args[1])
});

registerCommand("among", () =>{
    return "SUS!!!!!!! AMONGG ussss!!1 idk"
})

registerCommand("gay", () => {
    let all = document.querySelectorAll("*");

    for (let i = 0, max = all.length; i < max; i++) {
        let element = all[i];
        if (element instanceof HTMLElement) {
            element.style.color = gaycolors[Math.floor(Math.random()*gaycolors.length)];
        }
    }
    document.documentElement.style.background = "linear-gradient(45deg, red, orange, yellow, green, blue, indigo, violet)";
    return '"let there be gay" -  Gayesis 1:3'

    
});

registerCommand("help", ()=>{
    return "figure it out bitchass" 
})

registerCommand("gatito", ()=>{
    return '<img class="pfp" src="https://cdn.discordapp.com/attachments/1091601298803150887/1133670992376516638/20230713_200851.jpg" alt="">'
})

registerCommand("music", ()=>{
    var audio = new Audio("./fumo.mp3")
    audio.play();
    return "i will shove a flandre fumo up your ass"
})
