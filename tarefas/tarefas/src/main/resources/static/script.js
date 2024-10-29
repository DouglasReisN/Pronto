function validateForm() {
    const username = document.getElementById("username").value.trim();
    const password = document.getElementById("password").value.trim();
    const errorMsg = document.getElementById("error-msg");

    if (username === "" || password === "") {
        errorMsg.textContent = "Nome e senha são obrigatórios!";
        return false;
    }

    if (password.length < 6) {
        errorMsg.textContent = "A senha deve ter pelo menos 6 caracteres!";
        return false;
    }

    // Sucesso na validação, limpar mensagem de erro
    errorMsg.textContent = "";
    return true;
}
