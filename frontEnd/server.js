let express = require('express')

let app = express()

app.use(express.static(__dirname+'/dist/eschool'))

app.get('/*', (req, resp)=>{
    resp.sendFile(__dirname+'/dist/eschool/index.html')

});

app.listen(process.env.ANGULAR_PORT || 80);
