// --- Adicione estas duas linhas no início do seu arquivo produto-js.js ---

const form = document.getElementById('form-cadastro');
const mensagemAviso = document.getElementById('mensagem-aviso');

// --- Resto do seu código JavaScript abaixo ---

form.addEventListener('submit', (e) => {
  e.preventDefault();

  // Validação dos campos obrigatórios
  const nome = form['nome'].value.trim();
  const tipoProduto = form['tipo-produto'].value;
  const tipoAnimal = form['tipo-animal'].value;
  const preco = form['preco'].value.trim();
  const codigoBarras = form['codigo-barras'].value.trim();

  if (!nome || !tipoProduto || !tipoAnimal || !preco
    || !codigoBarras)
    {
    alert('Por favor, preencha todos os campos obrigatórios.');
    return;
  }

  if (isNaN(preco) || Number(preco) < 0) {
    alert('Informe um valor válido para o preço.');
    return;
  }

  const produto = {
  nome,
  tipoProduto,
  tipoAnimal,
  // Melhor enviar preco como número para o DB se a coluna for REAL/NUMERIC
  preco: Number(preco), // Remova .toFixed(2) aqui, faça na exibição se necessário
  codigoBarras,
  descricao: form['descricao'].value.trim(),
  imagem: form['imagem'].value.trim()
};

  // Modo offline/local: não chamar backend. Simular sucesso localmente para frontend funcionar.
  console.log('Simulando cadastro local do produto:', produto);
  mensagemAviso.textContent = "Produto cadastrado com sucesso (modo local). A página está funcionando sem backend.";
  mensagemAviso.classList.add('show');
  form.reset();
  setTimeout(() => mensagemAviso.classList.remove('show'), 4000);
});