function validateForm() {
  var email = document.getElementById("email").value;
  var senha = document.getElementById("senha").value;

  if (email.trim() === "") {
    alert("Por favor, insira seu e-mail.");
    return false;
  }

  if (senha.trim() === "") {
    alert("Por favor, insira sua senha.");
    return false;
  }

  return true;
}
