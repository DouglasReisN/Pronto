$(document).ready(function () {
    $('#loginForm').on('submit', function (event) {
        event.preventDefault(); // Impede o envio padrão do formulário

        // Validar o formulário
        if (!validateForm()) {
            return; // Se a validação falhar, não prosseguir
        }

        const email = $('#username').val().trim(); // Altere 'username' para 'email' se necessário
        const password = $('#password').val().trim();

        // Envio dos dados para o backend usando AJAX
        $.ajax({
            url: "/api/login", // Verifique se o endpoint está correto
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                email: email, // Use 'email' aqui
                password: password
            }),
            success: function (response) {
                // Redirecionar para a página principal ou de destino
                window.location.href = `${window.location.origin}/shop.html`;
            },
            error: function (xhr) {
                $('#error-msg').text("Erro ao fazer login: " + (xhr.responseText || "Verifique suas credenciais."));
            }
        });
    });
});

// Validação do formulário de login
function validateForm() {
    const email = document.getElementById("username").value.trim(); // Altere 'username' para 'email' se necessário
    const password = document.getElementById("password").value.trim();
    const errorMsg = document.getElementById("error-msg");

    if (email === "" || password === "") {
        errorMsg.textContent = "Email e senha são obrigatórios!"; // Atualizado para 'Email'
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
