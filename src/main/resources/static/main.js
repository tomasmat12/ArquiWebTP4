document.querySelector("#add-Client").addEventListener("click", addClient);





function addClient() {
	let numDoc = document.querySelector("#dni").value;
	let name = document.querySelector("#name").value;
	let lastname = document.querySelector("#lastname").value;
	let address = document.querySelector("#address").value;

	if((numDoc === "" || name === "")||(lastname === "" || address === "")){
			alert("Todos los campos son requeridos");
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
			getCities();
		})
		.catch(function(error) {
			console.log(error);
		})
	}
