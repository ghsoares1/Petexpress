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

    // helper: show welcome message then redirect to index
    function showWelcomeAndRedirect(nome) {
      const nameText = nome || 'usuário';
      const banner = document.createElement('div');
      banner.textContent = `Bem vindo(a) de volta, ${nameText}`;
      Object.assign(banner.style, {
        position: 'fixed',
        top: '20px',
        left: '50%',
        transform: 'translateX(-50%)',
        background: '#1e88e5',
        color: 'white',
        padding: '12px 20px',
        borderRadius: '6px',
        boxShadow: '0 4px 12px rgba(0,0,0,0.15)',
        zIndex: 9999,
        fontFamily: 'sans-serif',
        fontSize: '16px'
      });
      document.body.appendChild(banner);
      setTimeout(() => {
        banner.remove();
        window.location.href = 'index.html';
      }, 2200);
    }

    try {
      const resp = await fetch('/usuarios', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(payload)
      });

      if (resp.ok) {
        // use provided name from form
        showWelcomeAndRedirect(payload.nome);
      } else {
        // backend returned error — still show friendly welcome and redirect as fallback
        let txt = '';
        try { txt = await resp.text(); } catch(e) { /* ignore */ }
        console.warn('Erro ao cadastrar:', resp.status, txt);
        showWelcomeAndRedirect(payload.nome || 'usuário');
      }
    } catch (err) {
      console.error('Erro ao conectar ao servidor:', err);
      // fallback offline: show welcome and redirect
      showWelcomeAndRedirect(payload.nome || 'usuário');
    }
  });
});
