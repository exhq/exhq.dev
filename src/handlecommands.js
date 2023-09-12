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

class File {
    constructor(name, content = '') {
      this.name = name;
      this.content = content;
    }
  }
  
  class Directory {

    getPath() {
        if (this.parent === null) {
          return '/';
        }
        return this.parent.getPath() + '/' + this.name;
      }

    listFilesAndDirectories() {
        return [...this.children.keys()];
      }
    
    constructor(name, parent = null) {
      this.name = name;
      this.children = new Map();
      this.parent = parent;
    }
  
    addFile(name, content = '') {
      const file = new File(name, content);
      this.children.set(name, file);
    }
  
    addDirectory(name) {
      const directory = new Directory(name, this);
      this.children.set(name, directory);
    }
  
    deleteChild(name) {
      this.children.delete(name);
    }
  
    getChild(name) {
      return this.children.get(name);
    }
  
    listChildren() {
      return [...this.children.keys()];
    }
  
    getParent() {
      return this.parent;
    }
  }
  
  class FileSystem {
    
    constructor() {
      this.root = new Directory('/');
      this.currentDirectory = this.root;
    }
    
    pwd() {
        return this.currentDirectory.getPath();
      }
    
    
    createFile(path, content) {
      const parts = path.split('/');
      const filename = parts.pop();
      const parentPath = parts.join('/');
      const parentDir = this.traverseToPath(parentPath);
      if (parentDir) {
        parentDir.addFile(filename, content);
      }
    }
  
    createDirectory(path) {
      const parts = path.split('/');
      const dirname = parts.pop();
      const parentPath = parts.join('/');
      const parentDir = this.traverseToPath(parentPath);
      if (parentDir) {
        parentDir.addDirectory(dirname);
      }
    }
  
    traverseToPath(path) {
      const parts = path.split('/');
      let currentDir = this.currentDirectory;
  
      for (const part of parts) {
        if (part === '') {
          currentDir = this.root; 
        } else if (part === '..') {
          currentDir = currentDir.getParent() || currentDir;
        } else {
          const child = currentDir.getChild(part);
          if (child instanceof Directory) {
            currentDir = child;
          } else {
            return null;
          }
        }
      }
  
      return currentDir;
    }
  
    changeDirectory(path) {
      const targetDir = this.traverseToPath(path);
      if (targetDir) {
        this.currentDirectory = targetDir;
      }
    }
  
     listFilesAndDirectories() {
    return this.currentDirectory.listFilesAndDirectories();
  }
  
    readFile(path) {
      const parts = path.split('/');
      const filename = parts.pop();
      const parentPath = parts.join('/');
      const parentDir = this.traverseToPath(parentPath);
      if (parentDir) {
        const file = parentDir.getChild(filename);
        if (file instanceof File) {
          return file.content;
        }
      }
      return null;
    }
  }
  
  const fs = new FileSystem();
  fs.createFile('/documents/file.txt', 'Hello, World!');
  fs.createDirectory('/documents/folder');
  fs.changeDirectory('/documents');
  fs.createFile('file2.txt', 'Another file content');

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

registerCommand("cd", (args)=>{
    return fs.changeDirectory(fs.currentDirectory)
})

registerCommand("add", (args) => {
    return (+args[0]) + (+args[1])
});

registerCommand("among", () =>{
    return "SUS!!!!!!! AMONGG ussss!!1 idk"
})

registerCommand("ls", () =>{
    return fs.currentDirectory.listChildren().toString().replace(",", "<br>")
})

registerCommand("pwd", ()=> {
    return fs.pwd()
})

registerCommand("mkdir", (args)=> {
    fs.currentDirectory.addDirectory(args[0])
})

registerCommand("touch", (args)=>{
    fs.currentDirectory.addFile(args[0])
    return `file ${args[0]} created`
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
