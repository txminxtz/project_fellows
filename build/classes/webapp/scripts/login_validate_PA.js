/**
 * Validação de formulários
 */

function login_validate (){
	let email = frmLogin.email.value
	let senha = frmLogin.senha.value
	if (email===""){
		alert('Preencha o Campo E-mail')
		frmLogin.email.focus()
		return false
	}
	if (senha===""){
		alert('Preencha o Campo Senha')
		frmLogin.senha.focus()
		return false
	}
	document.forms["frmLogin"].submit()
}