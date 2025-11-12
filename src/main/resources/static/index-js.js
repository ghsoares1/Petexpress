let slideIndex = 0;
const carrossel = document.getElementById("carrossel");

function moverSlide(direcao) {
  const totalSlides = carrossel.children.length;
  slideIndex = (slideIndex + direcao + totalSlides) % totalSlides;
  carrossel.style.transform = `translateX(-${slideIndex * 100}%)`;
}

setInterval(() => moverSlide(1), 5000);


// Lista de produtos com nome, preço, imagem e tipo
const produtos = [
  // GATOS
  { nome: "Whiskas Adulto Carne", preco: "R$ 29,90", imagem: "img/c1.png", tipo: "gato" },
  { nome: "Golden Gatos Castrados", preco: "R$ 64,90", imagem: "img/c2.jpg", tipo: "gato" },
  { nome: "Premier Gatos Filhotes Frango", preco: "R$ 89,90", imagem: "img/c3.png", tipo: "gato" },
  { nome: "GranPlus Gatos Adultos Carne & Arroz", preco: "R$ 72,50", imagem: "img/c4.jpg", tipo: "gato" },
  { nome: "Cat Chow Naturalis Frango", preco: "R$ 55,90", imagem: "img/c5.jpg", tipo: "gato" },
  { nome: "Special Cat Prime Salmão", preco: "R$ 59,90", imagem: "img/c6.jpg", tipo: "gato" },
  // CÃES
  { nome: "Premier Pet Formula Adultos Porte Grande", preco: "R$ 179,90", imagem: "img/1.jpg", tipo: "cao" },
  { nome: "Golden Mega Adultos Raças Grandes", preco: "R$ 161,99", imagem: "img/2.jpg", tipo: "cao" },
  { nome: "Golden Mega Filhotes Porte Grande", preco: "R$ 161,91", imagem: "img/3.jpg", tipo: "cao" },
  { nome: "Premier Pet Formula Adultos Porte Pequeno", preco: "R$ 67,90", imagem: "img/4.png", tipo: "cao" },
  { nome: "Golden Mini Bits Adultos Pequeno Porte", preco: "R$ 65,99", imagem: "img/5.jpg", tipo: "cao" },
  { nome: "Golden Filhotes Pequeno Porte", preco: "R$ 72,90", imagem: "img/6.jpg", tipo: "cao" }
];

const inputBusca = document.getElementById('busca');
const sugestoes = document.getElementById('sugestoes-busca');
const formBusca = document.getElementById('form-busca');

// Função para mostrar sugestões
inputBusca.addEventListener('input', function() {
  const termo = this.value.trim().toLowerCase();
  sugestoes.innerHTML = '';
  if (termo.length === 0) {
    sugestoes.style.display = 'none';
    return;
  }
  const resultados = produtos.filter(prod =>
    prod.nome.toLowerCase().includes(termo)
  );
  if (resultados.length === 0) {
    sugestoes.style.display = 'none';
    return;
  }
  resultados.forEach(prod => {
    const li = document.createElement('li');
    li.innerHTML = `
      <img src="${prod.imagem}" alt="${prod.nome}">
      <div class="info">
        <span class="nome">${prod.nome}</span>
        <span class="preco">${prod.preco}</span>
      </div>
    `;
    li.addEventListener('click', () => {
      if (prod.tipo === 'gato') {
        window.location.href = 'gatos.html';
      } else {
        window.location.href = 'caes.html';
      }
    });
    sugestoes.appendChild(li);
  });
  sugestoes.style.display = 'block';
});

// Esconde sugestões ao clicar fora
document.addEventListener('click', function(e) {
  if (!e.target.closest('#box-busca') && !e.target.closest('#sugestoes-busca')) {
    sugestoes.style.display = 'none';
  }
});

// Impede submit padrão e busca pelo primeiro resultado se houver
formBusca.addEventListener('submit', function(e) {
  e.preventDefault();
  const termo = inputBusca.value.trim().toLowerCase();
  if (!termo) return;
  const resultado = produtos.find(prod => prod.nome.toLowerCase().includes(termo));
  if (resultado) {
    if (resultado.tipo === 'gato') {
      window.location.href = 'gatos.html';
    } else {
      window.location.href = 'caes.html';
    }
  }
});

