const formulario = document.querySelector("form");

const iNome = document.querySelector(".nome");
const iEmail= document.querySelector(".email");
const iSenha = document.querySelector(".senha");
const iTel = document.querySelector(".tel");

function cadastrar(){
    fetch("http://127.0.0.1:8080/usuarios",
    {
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
            nome: iNome.value,
            email: iEmail.value,
            senha: iSenha.value,
            telefone: iTel.value})
            
    })
    .then(function(res) {console.log(res)})
    .catch(function (res) {console.log(res)})
}

function limpar(){/*deixando os campos vazios novamente*/
    iNome.value = "";
    iEmail.value = "";
    iSenha.value = "";
    iTel.value = " ";
}

formulario.addEventListener('submit', function(event){
    /*formulário que irá receber os dados*/
    event.preventDefault();/*evento clicar em cadastrar*/

    
    cadastrar();   
    limpar();
})