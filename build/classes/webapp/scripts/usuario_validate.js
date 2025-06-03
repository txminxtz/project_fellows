/**
 * Validação de formulários
 */

function usuario_validate (){

	let usuario_nome = frmUsuario.usuario_nome.value
	let usuario_idade = frmUsuario.usuario_idade.value
	let usuario_sexo = frmUsuario.usuario_sexo.value
	let usuario_email = frmUsuario.usuario_email.value
	let usuario_senha = frmUsuario.usuario_senha.value

	if (usuario_nome===""){
		alert('Preencha o Campo Nome.')
		frmUsuario.usuario_nome.focus()
		return false
	}
	if (usuario_idade===""){
		alert('Preencha o Campo Idade.')
		frmUsuario.usuario_idade.focus()
		return false
	}
	if (usuario_sexo===""){
		alert('Preencha o Campo Sexo.')
		frmUsuario.usuario_sexo.focus()
		return false
	}
	if (usuario_email===""){
		alert('Preencha o Campo E-mail.')
		frmUsuario.usuario_email.focus()
		return false
	}
	if (usuario_senha===""){
		alert('Preencha o Campo Senha.')
		frmUsuario.usuario_senha.focus()
		return false
	}
	document.forms["frmUsuario"].submit()
}