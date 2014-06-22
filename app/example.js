var http = require('http'); //

function start() {

				http.createServer(
					function (req, res) {
						res.writeHead(200, {'Content-type': 'application/json'});
						res.write("Hello world");
						res.end();
					})
					.listen(1337, '127.0.0.1');

				console.log('Server running at 127.0.0.1');
			}

exports.start;