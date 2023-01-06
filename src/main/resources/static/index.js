


const doIt = async () => {
    const response = await fetch('localhost:9090/public/anime/search?keyw=naruto' );
    console.log(response);
    const animesJson = await response.json(); //extract JSON from the http response
    console.log(animesJson);
    // do something with myJson
    writeProject(animesJson);
}


fetch("localhost:9090/public/anime/search?keyw=naruto")
    .then(function (response) {
        return response.json();
    })
    .then(function (data) {
        appendData(data);
    })
    .catch(function (err) {
        console.log(err);
    });

function appendData(data) {
    var mainContainer = document.getElementById("myData");
    for (var i = 0; i < data.length; i++) {
        var div = document.createElement("div");
        div.innerHTML = 'Name: ' + data[i].firstName + ' ' + data[i].lastName;
        mainContainer.appendChild(div);
    }
}


function writeProject(animesJson) {
    for (anime of animesJson) {
        document.getElementById("animeTitle").innerHTML = anime.animeTitle;
        document.getElementById("status").innerHTML = anime.status;
    }
}