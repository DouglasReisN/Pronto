function addItem() {
    const itemName = document.getElementById("itemName").value.trim();
    const itemPrice = document.getElementById("itemPrice").value.trim();

    // Validação dos campos
    if (itemName === "" || itemPrice === "" || parseFloat(itemPrice) <= 0) {
        alert("Preencha o nome e o preço do item corretamente.");
        return;
    }

    // Criação do objeto para envio
    const itemData = {
        name: itemName,
        price: parseFloat(itemPrice)
    };

    // Envio dos dados para o backend usando AJAX
    $.ajax({
        url: "/api/items/add", // Certifique-se que esta URL está correta
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify(itemData),
        success: function(data) {
            alert("Item adicionado com sucesso!");
            // Limpar os campos do formulário após a adição
            document.getElementById("itemName").value = "";
            document.getElementById("itemPrice").value = "";
        },
        error: function(xhr) {
            console.error("Erro:", xhr.responseText);
            alert("Erro ao adicionar o item: " + xhr.responseText);
        }
    });
}
