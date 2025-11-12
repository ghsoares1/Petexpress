function addToCart() {
  const alertBox = document.getElementById("alert");
  alertBox.classList.remove("hidden");
  alertBox.classList.add("show");

  setTimeout(() => {
    alertBox.classList.remove("show");
    alertBox.classList.add("hidden");
  }, 2500);
}
