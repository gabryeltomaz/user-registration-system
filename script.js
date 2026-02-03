var formulario = document.querySelector("form");
var Inome = document.querySelector(".nome");
var Iemail = document.querySelector(".email");
var Itel = document.querySelector(".tel");
var Isenha = document.querySelector(".senha");

function cadastrar(){

    fetch("http://localhost:8080/usuarios",
        {
            headers:{
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify({

                nome: Inome.value,
                email: Iemail.value,
                telefone: Itel.value,
                senha: Isenha.value

            })
        }
    )

    .then(function(res){console.log(res)})
    .catch(function(res){console.log(res)})
};

function limpar(){

    Inome.value = "";
    Iemail.value = "";
    Itel.value = "";
    Isenha.value = "";

}

formulario.addEventListener('submit', function(event) {

    event.preventDefault();

    cadastrar();
    limpar();

});