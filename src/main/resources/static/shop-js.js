// shop-js.js
// Shared product list behavior: add selected product to cart (localStorage)

(function(){
  const CART_KEY = 'petexpress_cart';

  function getCart(){
    try{ return JSON.parse(localStorage.getItem(CART_KEY)) || []; }catch(e){ return []; }
  }
  function saveCart(cart){ localStorage.setItem(CART_KEY, JSON.stringify(cart)); }

  function parsePrice(text){
    if(!text) return 0;
    return Number(text.replace(/[^0-9,,\.]/g,'').replace(',', '.')) || 0;
  }

  function showAlert(){
    const alertBox = document.getElementById('alert');
    if(!alertBox) return;
    alertBox.classList.remove('hidden');
    alertBox.classList.add('show');
    setTimeout(()=>{ alertBox.classList.remove('show'); alertBox.classList.add('hidden'); }, 2000);
  }

  function addItem(product){
    const cart = getCart();
    const existing = cart.find(i=>i.name === product.name);
    if(existing){ existing.qty = (existing.qty||1) + (product.qty||1); }
    else { cart.push(Object.assign({qty:1}, product)); }
    saveCart(cart);
    showAlert();
  }

  // attach to product-card buttons on product listing pages
  function wireProductButtons(){
    const cards = document.querySelectorAll('.product-card');
    cards.forEach(card => {
      const btn = card.querySelector('button');
      if(!btn) return;
      // remove inline onclick if present
      btn.removeAttribute('onclick');
      btn.addEventListener('click', ()=>{
        const nameEl = card.querySelector('h2') || card.querySelector('.item-name');
        const priceEl = card.querySelector('.price');
        const imgEl = card.querySelector('img');
        const name = nameEl ? nameEl.textContent.trim() : 'Produto';
        const price = priceEl ? parsePrice(priceEl.textContent) : 0;
        const img = imgEl ? imgEl.getAttribute('src') : '';
        addItem({name, price, img});
      });
    });
  }

  // expose for console/testing
  window._petexpress = window._petexpress || {};
  window._petexpress.addItem = addItem;
  window._petexpress.getCart = getCart;

  document.addEventListener('DOMContentLoaded', ()=>{
    wireProductButtons();
  });

})();
