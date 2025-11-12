// cadastro-js.js

document.addEventListener('DOMContentLoaded', () => {
  const form = document.getElementById('form-cadastro');
  if (!form) return;

  form.addEventListener('submit', async function(event) {
    event.preventDefault();

    const senha = document.getElementById('senha').value;
    const confirmar = document.getElementById('confirmar').value;

    if (senha !== confirmar) {
      alert('As senhas não coincidem!');
      return; // evita o envio do formulário
    }

    const payload = {
      nome: document.getElementById('nome').value,
      sobrenome: document.getElementById('sobrenome').value,
      email: document.getElementById('email').value,
      cpf: document.getElementById('cpf').value,
      rg: document.getElementById('rg').value,
      senha: senha,
      endereco: document.getElementById('endereco').value,
      complemento: document.getElementById('complemento').value,
      bairro: document.getElementById('bairro').value,
      cep: document.getElementById('cep').value
    };

    try {
      const resp = await fetch('/usuarios', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(payload)
      });

      if (resp.ok) {
        alert('Cadastro realizado com sucesso! Faça login.');
        window.location.href = 'login.html';
      } else {
        const txt = await resp.text();
        alert('Erro ao cadastrar: ' + resp.status + '\n' + txt);
      }
    } catch (err) {
      console.error('Erro ao conectar ao servidor:', err);
      alert('Não foi possível conectar ao servidor. Tente novamente mais tarde.');
    }
  });
});
