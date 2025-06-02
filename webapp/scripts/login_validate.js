/**
 * Validação de formulários
 */

function login_validate (){

	let usuario_email = frmLogin.usuario_email.value
	let usuario_senha = frmLogin.usuario_senha.value

	if (usuario_email===""){
		alert('Preencha o Campo E-mail.')
		frmLogin.usuario_email.focus()
		return false
	}
	if (usuario_senha===""){
		alert('Preencha o Campo Senha.')
		frmLogin.usuario_senha.focus()
		return false
	}
	document.forms["frmLogin"].submit()
}