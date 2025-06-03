/**
 * Validação de formulários
 */

function tutor_validate (){
	let nome = frmTutor.tutor_nome.value
	let telefone = frmTutor.tutor_telefone.value
	let senha = frmTutor.tutor_senha.value
	if (nome===""){
		alert('Preencha o Campo Nome')
		frmTutor.nome.focus()
		return false
	}
	if (telefone===""){
		alert('Preencha o Campo Telefone')
		frmTutor.telefo.focus()
		return false
	}
	if (senha===""){
		alert('Preencha o Campo Senha')
		frmTutor.senha.focus()
		return false
	}
	document.forms["frmTutor"].submit()
}