var apiResultados = new Promise(function (resolve, reject) {
    fetch('http://servicodados.ibge.gov.br/api/v3/noticias/?qtd=3')
        .then(function (response) {
        if (response.ok) {
            return response.json();
        }
        else {
            throw new Error(response.statusText);
        }
    })
        .then(function (data) { return resolve(data); })
        .catch(function (error) { return reject(error); });
});

apiResultados.then(function (data) {
    try {
        var json = JSON.stringify(data);
        var objetoJS = JSON.parse(json);
        const resultadosDOM = document.querySelector('#resultados');
        objetoJS.items.map((item, id)=>{
            var novoLink = document.createElement('a');
            resultadosDOM.children[id*2].innerHTML = item.titulo;
            resultadosDOM.children[id*2+1].innerHTML = item.introducao;
            novoLink.href = item.link;
            novoLink.textContent = "Saiba mais...";
            resultadosDOM.children[id*2+1].appendChild(novoLink);
        })
    }
    catch (error) {
        console.log(error);
    }
}).catch(function (error) { return console.log(error); });

var apiMeteorologia = new Promise(function (resolve, reject) {
    fetch('https://api.openweathermap.org/data/2.5/weather?lat=-14.795999193380537&lon=-39.17346823068079&lang=pt_br&appid=6b0044ed510c0cabb54f601d3daa70de')
        .then(function (response) {
        if (response.ok) {
            return response.json();
        }
        else {
            throw new Error(response.statusText);
        }
    })
        .then(function (data) { return resolve(data); })
        .catch(function (error) { return reject(error); });
});

apiMeteorologia.then(function (data) {
    try {
        var json = JSON.stringify(data);
        var objetoJS = JSON.parse(json);
        const servicosDOM = document.querySelector('#servicos');
        var listasDOM = [...servicosDOM.firstElementChild.children.item(1).children];
        var dadosTempo = [(objetoJS.main.temp-273.15).toFixed(1) + "°C", "Umidade do ar: " + objetoJS.main.humidity + "%", objetoJS.weather[0].description.toString()];
        var url = "http://openweathermap.org/img/w/" + objetoJS.weather[0].icon + ".png";
        var icon = document.createElement("img");
        icon.src = url;
        servicosDOM.firstElementChild.firstElementChild.textContent = "Previsão do Tempo no Campus";
        listasDOM.map((item, id)=>{
            item.textContent = dadosTempo[id];
        })
        servicosDOM.firstElementChild.children.item(1).appendChild(icon);
    }
    catch (error) {
        console.log(error);
    }
}).catch(function (error) { return console.log(error); });

var apiNoticias = new Promise(function (resolve, reject) {
    fetch('https://api.worldnewsapi.com/search-news?api-key=a1866c1a071e4ef49aef93db0f2beab5&language=pt&entities=LOC:Brasil&source-countries=br&number=3&earliest-publish-date=2023-10-01')
        .then(function (response) {
        if (response.ok) {
            return response.json();
        }
        else {
            throw new Error(response.statusText);
        }
    })
        .then(function (data) { return resolve(data); })
        .catch(function (error) { return reject(error); });
});

apiNoticias.then(function (data) {
    try {
        var json = JSON.stringify(data);
        var objetoJS = JSON.parse(json);
        const noticiasDOM = document.querySelector('#noticias');
        objetoJS.news.map((item, id)=>{
            // noticiasDOM.children[id*2].innerHTML = item.title;
            noticiasDOM.children[id*2+1].innerHTML = item.title;
            noticiasDOM.children[id*2+1].href = item.url;
        })
        console.log(objetoJS);
    }
    catch (error) {
        console.log(error);
    }
}).catch(function (error) { return console.log(error); });


