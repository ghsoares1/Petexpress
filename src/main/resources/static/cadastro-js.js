// script-cadastro.js

document.addEventListener('DOMContentLoaded', () => {
  const form = document.getElementById('form-cadastro');

  form.addEventListener('submit', function(event) {
    const senha = document.getElementById('senha').value;
    const confirmar = document.getElementById('confirmar').value;

    if (senha !== confirmar) {
      alert('As senhas não coincidem!');
      event.preventDefault(); // evita o envio do formulário
    }
  });
});
