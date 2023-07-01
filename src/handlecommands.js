const commands = {};

function registerCommand(commandName, handler) {
    commands[commandName] = handler;
}

export default function handleCommands(input) {
    const args = input.trim().split(/ +/)
    const command = args.shift()?.toLowerCase()

    try {
        return commands[command](args);
    } catch (e) {
        return e
    }
}

registerCommand("add", (args) => {
    return (+args[0]) + (+args[1])
});


registerCommand("logo", (args) => {
    const newSource = args[0];

    const logoElement = document.querySelector(".logo");

    if (logoElement instanceof HTMLImageElement) {
        logoElement.src = newSource;
        return "Logo source changed successfully";
    } else {
        return "Logo element not found";
    }
})