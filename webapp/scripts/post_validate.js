/**
 * Validação de formulários
 */

function post_validate (){

	let post_texto = frmPost.post_texto.value

	if (post_texto===""){
		alert('Preencha o Campo Texto.')
		frmPost.post_nome.focus()
		return false
	}
	document.forms["frmPost"].submit()
}