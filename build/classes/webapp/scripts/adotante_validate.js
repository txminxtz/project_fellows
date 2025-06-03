/**
 * Validação de formulários
 */

function adotante_validate (){
	let nome = frmAdotante.adotante_nome.value
	let telefone = frmAdotante.adotante_telefone.value
	let senha = frmAdotante.adotante_senha.value
	if (nome===""){
		alert('Preencha o Campo Nome')
		frmAdotante.nome.focus()
		return false
	}
	if (telefone===""){
		alert('Preencha o Campo Telefone')
		frmAdotante.telefo.focus()
		return false
	}
	if (senha===""){
		alert('Preencha o Campo Senha')
		frmTutor.senha.focus()
		return false
	}
	document.forms["frmAdotante"].submit()
}