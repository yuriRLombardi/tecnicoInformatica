const handlePhone = (event) => {
  let input = event.target
  input.value = phoneMask(input.value)
}

const phoneMask = (value) => {
  if (!value) return ""
  // Remove todos os caracteres não numéricos
  value = value.replace(/\D/g,'')
  
  // Aplica a máscara no value
  value = value.replace(/(\d{2})(\d)/,"($1) $2")
  value = value.replace(/(\d)(\d{4})$/,"$1-$2")
  return value
}

const handleCNPJ = (event) => {
  let input = event.target
  input.value = cnpjMask(input.value)
}

const cnpjMask = (value) => {
	if(!value) return ""
	// Remove todos os caracteres não numéricos
	value = value.replace(/\D/g, '');

	// Aplica a máscara no value
	value = value.replace(/(\d{2})(\d)/, '$1.$2'); // 00.
	value = value.replace(/(\d{2})\.(\d{3})(\d)/, '$1.$2.$3'); // 00.000.
	value = value.replace(/(\d{2})\.(\d{3})\.(\d{3})(\d)/, '$1.$2.$3/$4'); // 00.000.000/
	value = value.replace(/(\d{2})\.(\d{3})\.(\d{3})\/(\d{4})(\d)/, '$1.$2.$3/$4-$5'); // 00.000.000/0000-
	return value
}
