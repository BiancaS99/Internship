const Sequelize = require('sequelize')

const bd = new Sequelize('Portocalele','admin','porto*',{
    dialect:'mysql'
})

const Player=bd.define('player',{
    username:Sequelize.STRING,
    pass: Sequelize.STRING,
    email: Sequelize.STRING
})

const Game=bd.define('game',{
    number:Sequelize.INTEGER
})
bd.sync({force:true})
    .then(()=>console.log('created'))
    .catch((error)=> console.log(error))