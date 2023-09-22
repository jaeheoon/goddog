const socket = io.connect("http://localhost:5000", {
    path : '/socket.io'
});

// console.log(socket);

const nickName = document.querySelector("#nick-name");
const joinButton = document.querySelector(".join-button");
const chatList = document.querySelector(".chatting-list");
const chatInput = document.querySelector(".chatting-input");
const sendButton = document.querySelector(".send-button");
const displayContainer = document.querySelector(".display-container");
window.addEventListener('load', () => { 
    nickName.focus();
    chatInput.disabled = true;
    sendButton.disabled = true;
});

// Event Listener Add
joinButton.addEventListener('click', joinSend);
nickName.addEventListener('keypress', (event) => {
    if (event.keyCode === 13) {
        joinSend();
    }
});

sendButton.addEventListener('click', messageSend);
chatInput.addEventListener('keypress', (event) => {
    if (event.keyCode === 13) {
        messageSend();
    }
});

// Join Message Send
function joinSend() {
    socket.emit("join", nickName.value);
    chatInput.disabled = false;
    chatInput.focus();
    sendButton.disabled = false;
}

// Chat Message Send
function messageSend() {
    const message = {
        name: nickName.value,
        msg: chatInput.value
    };
    chatInput.value = "";
    socket.emit("chatting", message);
}

socket.on("join", (name) => {
    const message = new NoticeMessageModel(`${name}님이 입장하셨습니다.`);
    message.messageRender();
    displayContainer.scrollTo(0, displayContainer.scrollHeight);
    nickName.disabled = true;
    joinButton.disabled = true;
});

socket.on("disjoin", (name) => {
    if(name) {
        const message = new NoticeMessageModel(`${name}님이 퇴장하셨습니다.`);
        message.messageRender();
        displayContainer.scrollTo(0, displayContainer.scrollHeight);
    }
});

socket.on("chatting", (message) => {
    console.log(message);
    const { name, msg, time } = message;
    const messageModel = new ChatMessageModel(name, msg, time);
    messageModel.messageRender();
    displayContainer.scrollTo(0, displayContainer.scrollHeight);
});

function NoticeMessageModel(msg) {
    this.msg = msg;
    this.messageRender = () => {
        const li = document.createElement("li");
        li.classList.add("notice");
        const spanElement = `<span class="message">${this.msg}</span>`;
        li.innerHTML = spanElement;
        chatList.appendChild(li);
    }
}

function ChatMessageModel(name, msg, time) {
    this.name = name;
    this.msg = msg;
    this.time = time;

    this.messageRender = () => {
        const li = document.createElement("li");
        let icon = null;

        if (nickName.value === this.name){
            li.classList.add("sent");
            icon = "./img/sender.png";
        } else {
            li.classList.add("received");
            icon = "./img/receiver.png";
        }
        const spanElement = `<span class="profile">
                        <span class="user">${this.name}</span>
                        <img class="image" src="${icon}">
                    </span>
                    <span class="message">${this.msg}</span>
                    <span class="time">${this.time}</span>`;
        li.innerHTML = spanElement;
        chatList.appendChild(li);
    }
}