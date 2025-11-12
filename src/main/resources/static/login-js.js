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

    // Atualmente não existe endpoint de autenticação público no backend.
    // Redirecionamos para a página inicial localmente após validação.
    window.location.href = 'index.html';
  });
});
