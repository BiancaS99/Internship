const Sequelize = require('sequelize')

const bd = new Sequelize('Portocalele','admin','porto*',{
    dialect:'mysql'
})

bd.authenticate()
	.then(() => console.log('we are connected'))
	.catch((error) => console.log(error))
