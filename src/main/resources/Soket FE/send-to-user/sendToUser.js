var username;
var stompClient;


function connect() {
    username = document.getElementById("name").value;
    if (username) {
        var socket = new SockJS('http://localhost:8080/ws');
        stompClient = Stomp.over(socket);
        stompClient.connect({"username" : username}, onConnected, onError);
    }
}

function onConnected() {
    // Subscribe to the Public Topic
    stompClient.subscribe('/users/topic/received', onMessageReceived);

}

function sendMessage() {
    let sendToElement = document.getElementById('message')
    var sendTo = sendToElement.value
    if (sendTo && stompClient) {
        stompClient.send("/app/chat-user", {}, sendTo);
        sendToElement.value = '';
    }
}

function onMessageReceived(payload) {
    console.log("received");
    console.log(payload);
    var message = payload.body;
    console.log(message)
}

function onError(error) {
    console.log("error");
}
