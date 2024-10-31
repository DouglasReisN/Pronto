$(document).ready(function () {
    $('#loginForm').on('submit', function (event) {
        event.preventDefault(); // Impede o envio padrão do formulário

        // Validar o formulário
        if (!validateForm()) {
            return; // Se a validação falhar, não prosseguir
        }

        const username = $('#username').val().trim();
        const password = $('#password').val().trim();

        // Envio dos dados para o backend usando AJAX
        $.ajax({
            url: "/api/login", // O endpoint para autenticação (ajuste conforme necessário)
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                username: username,
                password: password
            }),
            success: function (response) {
                // Redirecionar para a página da loja ou onde necessário
                window.location.href = "/shop"; 
            },
            error: function (xhr) {
                $('#error-msg').text("Erro ao fazer login: " + xhr.responseText);
            }
        });
    });
});

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
