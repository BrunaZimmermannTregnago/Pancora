function buscarUsuarios(){
    var url = "http://localhost:8000/listar-usuario";

    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", url, false);

    xhttp.send();//A execução do script pára aqui até a requisição retornar do servidor

    var dados = xhttp.responseText;
    var html = "";
    JSON.parse(dados).forEach( function (registro){
        html += '<tr><td class="space-list">'
        +registro.username
        +'</td><td class="space-list">'
        +registro.email
        +"</td></tr>"

        document.getElementById('registros').innerHTML = html;
    })
}