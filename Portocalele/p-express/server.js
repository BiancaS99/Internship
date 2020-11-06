const express =require('express')

const port_app=express()
port_app.get('/',(req,res)=>res.send('ok'))

port_app.listen(8080)