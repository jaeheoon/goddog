const http = require('http');
const express = require('express');
const path = require('path');
const socketio = require('socket.io');
const moment = require('moment');

const app = express();
// join(); 운영체제별 경로구분자 자동 완성
app.use(express.static(path.join(__dirname, 'public')));

const server = http.createServer(app);
const io = socketio(server);

const PORT = 5000;
// 클라이언트 연결
io.on('connection', (socket) => {
    const request = socket.request;
    const clientIp = request.socket.remoteAddress;
    let name = null;
    
    console.log(`새로운 클라이언트[${clientIp}] 접속`);

    // 입장 메시지 수신
    socket.on("join", (nickName) => {
        console.log(nickName);
        name = nickName;
        console.log(`${name}님 공개 대화방 입장`);
        io.emit("join", name);
    });

    // 채팅 메시지 수신
    socket.on("chatting", (message) => {
        console.log(message);
        const { name, msg } = message;
        io.emit("chatting", {
            name,
            msg,
            time: moment(new Date()).format('h:ss A')
        });
    });

    // 클라이언트 연결 해제
    socket.on("disconnect", () => {
        console.log(`클라이언트[${clientIp}] 접속 종료`);
        io.emit("disjoin", name);
        clearInterval(socket.interval);
    });

    socket.on("error", console.error);
    
});

server.listen(PORT, () => {
    console.log(`WebServer is running (${PORT})`);
});



