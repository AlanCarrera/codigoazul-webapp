var users = {};

function bluecode(team) {
    for (var i = 0; i < team.length; i++) {
        var next = team[i];
        var user = users[next.device];
        if (user) {
            user.emit('bluecode', {
                name: next.name,
                zone: next.zone,
                role: next.role
            });
        }
    }
}

var app = require('express')();

app.use(require('body-parser')());

app.post('/bluecode', function (req, res) {
    bluecode(req.body);
    res.end();
});

var server = require('http').createServer(app);
var io = require('socket.io').listen(server);

io.sockets.on('connection', function (socket) {
    console.log('Se ha conectado un cliente');

    socket.on('setup', function(mac) {
        socket.set('mac', mac, function() {
            users[mac] = socket;
        });       
    });

    socket.on('bluecode', function(team) {
        bluecode(team);
    });

    socket.on('disconnect', function() {
        socket.get('mac', function(err, mac) {
            if (mac) {
                delete users[mac];
            }
        });
    });
});

server.listen(8080);

console.log('El servidor ha iniciado en el puerto 8080');