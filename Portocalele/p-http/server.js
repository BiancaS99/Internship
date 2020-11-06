const express = require('express');
const bodyParser = require('body-parser');
// const http= require('http')
// const url=require('url')

// const server=http.createServer()

// server.on('request',(req,res)=>{
//     let reqUrl = url.parse(req.url)
//     console.warn(reqUrl)
//     res.writeHead(200, { 'Content-Type': 'text/plain' })
// 	res.end('got it')
// })
const server=express();
server.use(bodyParser.json());
server.listen(8080,()=>{
    console.log('Server start');
})