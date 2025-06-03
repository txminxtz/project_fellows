/**
 * Validação de formulários
 */

function animal_validate (){
	let nome = frmAnimal.animal_nome.value
	let especie = frmAnimal.animal_especie.value
	let raca = frmAnimal.animal_raca.value
	let sexo = frmAnimal.animal_sexo.value
	if (nome===""){
		alert('Preencha o Campo Nome')
		frmAnimal.nome.focus()
		return false
	}
	if (raca===""){
		alert('Preencha o Campo Raça')
		frmAnimal.raca.focus()
		return false
	}
	if (especie===""){
		alert('Preencha o Campo Especie')
		frmAnimal.especie.focus()
		return false
	}
	if (sexo===""){
		alert('Preencha o Campo Sexo')
		frmAnimal.sexo.focus()
		return false
	}
	document.forms["frmAnimal"].submit()
}