function validateRegisterForm() {
    const name = document.getElementById("name").value.trim();
    const phone = document.getElementById("phone").value.trim();
    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("password").value.trim();
    const errorMsg = document.getElementById("error-msg");

    // Limpar mensagem de erro ao validar novamente
    errorMsg.textContent = "";

    if (name === "" || phone === "" || email === "" || password === "") {
        errorMsg.textContent = "Todos os campos são obrigatórios!";
        return false;
    }

    // Validação do telefone (Formato básico: (XX) XXXXX-XXXX)
    const phonePattern = /^\(\d{2}\) \d{5}-\d{4}$/;
    if (!phonePattern.test(phone)) {
        errorMsg.textContent = "Formato de telefone inválido! Use (XX) XXXXX-XXXX.";
        return false;
    }

    // Validação do e-mail
    const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (!emailPattern.test(email)) {
        errorMsg.textContent = "E-mail inválido!";
        return false;
    }

    // Validação da senha (mínimo de 6 caracteres)
    if (password.length < 6) {
        errorMsg.textContent = "A senha deve ter pelo menos 6 caracteres!";
        return false;
    }

    // Sucesso na validação, limpar mensagem de erro
    errorMsg.textContent = "";
    return true;
}
