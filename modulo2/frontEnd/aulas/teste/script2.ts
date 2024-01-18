
let buscaDados = new Promise((resolve, reject) => {

    fetch('http://servicodados.ibge.gov.br/api/v3/noticias/?qtd=3')
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error(response.statusText);
            }
        })
        .then(data => resolve(data))
        .catch(error => reject(error));
});

buscaDados.then(data => {
    try{
        const json = JSON.stringify(data);
        const objetoJS = JSON.parse(json);
        console.log(objetoJS);
    }
    catch(error){
        console.log(error);
    }
}).catch(error => console.log(error));

