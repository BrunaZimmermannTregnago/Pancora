const hamburger = document.querySelector(".hamburger");
const navMenu = document.querySelector(".nav-menu");

hamburger.addEventListener("click", mobileMenu);

function mobileMenu() {
    hamburger.classList.toggle("active");
    navMenu.classList.toggle("active");
}

const navLink = document.querySelectorAll(".nav-link");

navLink.forEach(n => n.addEventListener("click", closeMenu));

function closeMenu() {
    hamburger.classList.remove("active");
    navMenu.classList.remove("active");
}

function cadastrarEmpresa(){
    var razaoSocial = $("#razaoSocial").val();
    var nomeFantasia = $("#nomeFantasia").val();
    var ramo = $("#ramo").val();
    var cnpj = $("#cnpj").val();
    var cidade = $("#cidade").val();
//    var estado = $("#estado").val();
    var rua = $("#rua").val();
    var numero = $("#numero").val();
    var email = $("#email").val();
    var telefone = $("#telefone").val();
    var cep = $("#cep").val();
    var bairro = $("#cidade").val();

    $.ajax({
               method : "POST",
               url : "/cadastro-empresa",
               data : JSON.stringify({cnpj : cnpj,
                                      razãoSocial : razãoSocial,
                                      nomeFantasia : nomeFantasia,
                                      telefone : telefone,
                                      email : email,
                                      ramoAtividade : ramo,
                                      ruaEndereco : rua,
                                      numeroEndereco : numero,
                                      cep : cep,
                                      bairroId : bairro,
                                      cidadeId : cidade}),
               contentType : "application/json; charset=utf-8",
               success : function(response){
                   $("#nomeFantasia").val(response.id);
                   alert("Cadastro realizado com sucesso!");
               }
               }).fail(function (xhr, status, errorThrown){
                   alert("Erro ao cadastrar." + xhr.responseText);
               });
           }


     $("#login-button").click(function(event){
             event.preventDefault();

         $('form').fadeOut(500);
         $('.wrapper').addClass('form-success');
    });