document.querySelector("#add-Client").addEventListener("click", addClient);
document.querySelector("#add-Product").addEventListener("click", addProduct);
document.querySelector("#add-Bill").addEventListener("click", addBill);
document.querySelector("#bill-product-list").addEventListener("click", addProductosCarrito);

window.addEventListener('DOMContentLoaded', (event) => {
    console.log('DOM fully loaded and parsed');
	getProducts();
});



function addProduct() {
	let name = document.querySelector("#nameP").value;
	let price = document.querySelector("#price").value;
	let stock = document.querySelector("#stock").value;

	if( name === ""|| price === "" || stock === ""){
			return alert("Todos los campos son requeridos");
	}
	
	let data = {
		"name": name,
		"price": price,
		"stock": stock
	}

	fetch('http://localhost:8080/product', {
		method: 'POST',
		headers: { 'Content-Type': 'application/json' },
		body: JSON.stringify(data)
	})
		.then(response => {
			getProducts(); //revisar 
		})
		.catch(function(error) {
			console.log(error);
		})
	}



function addClient() {
	let numDoc = document.querySelector("#dni").value;
	let name = document.querySelector("#nameC").value;
	let lastname = document.querySelector("#lastname").value;
	let address = document.querySelector("#address").value;

	if((numDoc === "" || name === "")||(lastname === "" || address === "")){
			return alert("Todos los campos son requeridos");
			
	}
	
	let data = {
		"dni": numDoc,
		"name": name,
		"lastname": lastname,
		"address": address
	}

	fetch('http://localhost:8080/client', {
		method: 'POST',
		headers: { 'Content-Type': 'application/json' },
		body: JSON.stringify(data)
	})
		.then(response => {
			getCities(); //revisar 
		})
		.catch(function(error) {
			console.log(error);
		})
	}

function addBill() {
	let numDoc = document.querySelector("#dni").value;
	let date = document.querySelector("#date").value;
	let total = document.querySelector("#total").value;
	let carrito = document.querySelector("#carrito");

	if((numDoc === "" || date === "")){
			return alert("Todos los campos son requeridos");
			
	}
	
	let data = {
		"dni": numDoc,
		"date": date,
		"total": total,
		"carrito": *****
	}

	fetch('http://localhost:8080/bill', {
		method: 'POST',
		headers: { 'Content-Type': 'application/json' },
		body: JSON.stringify(data)
	})
		.then(response => {
			getCities(); //revisar 
		})
		.catch(function(error) {
			console.log(error);
		})
	}


function getProducts() {
	fetch('http://localhost:8080/product')
		.then(response => {
			return response.json()
		}).then(function(products) {
			let selectProduct = document.getElementById('bill-product-list');
			for (const index in products) {
				selectProduct.options[selectProduct.options.length] = new Option(products[index].name, products[index].id);
			}
		})
		.catch(function(error) {
			console.log(error);
		}

		);
}