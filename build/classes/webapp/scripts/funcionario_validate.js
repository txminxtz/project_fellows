/**
 * Validação de formulários
 */

function funcionario_validate (){
	let nome = frmFuncionario.funcionario_nome.value
	let email = frmFuncionario.funcionario_email.value
	let senha = frmFuncionario.funcionario_senha.value
	if (nome===""){
		alert('Preencha o Campo Nome')
		frmFuncionario.nome.focus()
		return false
	}
	if (email===""){
		alert('Preencha o Campo Email')
		frmFuncionario.telefone.focus()
		return false
	}
	if (senha===""){
		alert('Preencha o Campo Senha')
		frmTutor.senha.focus()
		return false
	}
	document.forms["frmFuncionario"].submit()
}