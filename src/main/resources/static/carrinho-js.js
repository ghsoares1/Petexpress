// carrinho-js.js
(function(){
  const CART_KEY = 'petexpress_cart';

  function getCart(){ try{ return JSON.parse(localStorage.getItem(CART_KEY)) || []; }catch(e){ return []; } }
  function saveCart(cart){ localStorage.setItem(CART_KEY, JSON.stringify(cart)); }

  function formatPrice(v){ return 'R$ ' + v.toFixed(2).replace('.', ','); }

  function render(){
    const container = document.getElementById('cart-items');
    const totalEl = document.getElementById('total-value');
    if(!container) return;
    const cart = getCart();
    container.innerHTML = '';
    let total = 0;
    if(cart.length === 0){
      container.innerHTML = '<p>Seu carrinho está vazio.</p>';
    } else {
      cart.forEach((item, idx) => {
        const itemEl = document.createElement('div');
        itemEl.className = 'cart-item';
        const img = document.createElement('img'); img.src = item.img || 'img/c1.png'; img.alt = item.name;
        const details = document.createElement('div'); details.className = 'item-details';
        const name = document.createElement('span'); name.className = 'item-name'; name.textContent = item.name;
        const price = document.createElement('span'); price.className = 'item-price'; price.textContent = formatPrice(item.price || 0);
        const controls = document.createElement('div'); controls.className = 'item-controls';
        const minus = document.createElement('button'); minus.textContent = '-'; minus.className='qty-btn';
        const qty = document.createElement('span'); qty.textContent = item.qty || 1; qty.className='item-qty';
        const plus = document.createElement('button'); plus.textContent = '+'; plus.className='qty-btn';
        const remove = document.createElement('button'); remove.textContent = 'Remover'; remove.className='remove-btn';

        minus.addEventListener('click', ()=>{
          if(item.qty && item.qty>1){ item.qty--; saveCart(cart); render(); } else { // remove
            cart.splice(idx,1); saveCart(cart); render(); }
        });
        plus.addEventListener('click', ()=>{ item.qty = (item.qty||1)+1; saveCart(cart); render(); });
        remove.addEventListener('click', ()=>{ cart.splice(idx,1); saveCart(cart); render(); });

        controls.appendChild(minus); controls.appendChild(qty); controls.appendChild(plus); controls.appendChild(remove);
        details.appendChild(name); details.appendChild(price); details.appendChild(controls);
        itemEl.appendChild(img); itemEl.appendChild(details);
        container.appendChild(itemEl);

        total += (item.price || 0) * (item.qty || 1);
      });
    }
    if(totalEl) totalEl.textContent = formatPrice(total);
  }

  document.addEventListener('DOMContentLoaded', ()=>{
    render();
    const checkout = document.getElementById('checkout-btn');
    if(checkout){ checkout.addEventListener('click', ()=>{
      const cart = getCart();
      if(cart.length===0){ alert('Carrinho vazio'); return; }
      // For now just clear cart and show message
      alert('Compra finalizada (simulação). Obrigado!');
      localStorage.removeItem(CART_KEY);
      render();
    }); }
  });

})();
