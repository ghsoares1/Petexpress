document.addEventListener('DOMContentLoaded', () => {
  const form = document.getElementById('login-form');
  if (!form) return;

  form.addEventListener('submit', function(event) {
    event.preventDefault();

    const email = document.getElementById('email').value || '';
    const senha = document.getElementById('senha').value || '';

    if (email.trim() === '') {
      alert('Por favor, insira seu e-mail.');
      return;
    }

    if (senha.trim() === '') {
      alert('Por favor, insira sua senha.');
      return;
    }
    // Mostrar mensagem de boas-vindas com o nome e depois redirecionar ao índice.
    function showWelcomeAndRedirect(name) {
      const nameText = name || 'usuário';
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

    // Use parte do email antes do @ como nome de exibição
    const displayName = (email.split('@')[0] || 'usuário').replace(/\.|_|\d+/g, ' ');
    showWelcomeAndRedirect(displayName);
  });
});
