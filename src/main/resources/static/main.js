document.querySelector("#add-Client").addEventListener("click", addClient);
document.querySelector("#add-Product").addEventListener("click", addProduct);
document.querySelector("#add-Bill").addEventListener("click", addBill);
//document.querySelector("#bill-product-list").addEventListener("click", addProductosCarrito);

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
	    //"carrito": *****
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

function getAllClient() {
    let bodyTable = document.getElementsByClassName('bodyTable')[0];
	let bodyTable1 = document.getElementById('myTable');
	bodyTable1.style.display = "table";
	fetch('http://localhost:8080/client')
		.then(response => {
			return response.json()
		}).then(function(response) {
			let elements = response;
			showClients(bodyTable, elements);
		})
		.catch(function(error) {
			console.log(error);
		}

		);
}

function showClients(bodyTable, elements) {
    bodyTable.innerHTML = "";
	elements.forEach(element => {
		let newRow = bodyTable.insertRow(-1);
		let cell1 = newRow.insertCell(0);
		let newText1 = document.createTextNode(element['dni']);
		cell1.appendChild(newText1);
		let cell2 = newRow.insertCell(1);
		let newText2 = document.createTextNode(element['name']);
		cell2.appendChild(newText2);
		let cell3 = newRow.insertCell(2);
		let newText3 = document.createTextNode(element['lastname']);
		cell3.appendChild(newText3);
		let cell4 = newRow.insertCell(3);
		let newText4 = document.createTextNode(element['address']);
		cell4.appendChild(newText4);
		let btn = document.createElement("button");
		btn.innerHTML = "Click Me";
		let cell5.appendChild(btn);
	});
}

function ocultarTablaC(){
	let bodyTable = document.getElementById('myTable');
	bodyTable.style.display = "none";
}
