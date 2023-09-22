console.log("start!");
const socket = io();
console.log(socket);

const nickName = document.querySelector("#nick-name");
const chatList = document.querySelector(".chatting-list");
const chatInput = document.querySelector(".chatting-input");
const sendButton = document.querySelector(".send-button");

sendButton.addEventListener('click', (event) => {
    const param = {
        name: nickName.value,
        msg: chatInput.value
    };

});

// emit()함수를 이용하여 메시지 전송
socket.emit("chatting", "From Client");

socket.on("chatting", (data) => {
    console.log(data);
});