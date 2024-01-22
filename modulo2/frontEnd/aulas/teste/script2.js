var apiJogos = new Promise(function (resolve, reject) {
    fetch("https://nfl-ncaa-highlights-api.p.rapidapi.com/teams").then(function (response) {
        if (response.ok) {
            return response.json();
        } else {
            throw new Error(response.statusText);
        }
    }).then(function (data) {
        return resolve(data);
    }).catch(function (error) {
        return reject(error);
    });
});

apiJogos.then(function (data) {
    try {
        var json = JSON.stringify(data);
        var objetoJS = JSON.parse(json);
        const noticiasDOM = document.querySelector("#noticias");
        objetoJS.news.map((item, id) => {
            // noticiasDOM.children[id*2].innerHTML = item.title;
            noticiasDOM.children[id * 2 + 1].innerHTML = item.title;
            noticiasDOM.children[id * 2 + 1].href = item.url;
        });
    } catch (error) {
        console.log(error);
    }
}).catch(function (error) {
    return console.log(error);
});
