function validaEmail() {
	var regexEmail = /^([0-9a-zA-Z]+([_.-]?[0-9a-zA-Z]+)*@[0-9a-zA-Z]+[0-9,a-z,A-Z,.,-]*(.){1}[a-zA-Z]{2,4})+$/;

	var email = form_cadastro_usuario.email.value;

	if (regexEmail.test(email) == false) {
		alert("Email inválido!");

	}

}


function validaSenha() {

	var senha1 = form_cadastro_usuario.senha.value;
	var senha2 = form_cadastro_usuario.senha2.value;

	if (senha1 != senha2) {
		alert("Senha não Confere!");
	}

}

function listaAnimal() {
	alert("Cadatro de animal efetuado com sucesso!!");
	window.location = "admin/lista-animal.xhtml";
}

