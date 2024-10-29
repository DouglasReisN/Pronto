// Lista temporária para armazenar itens
let items = [];

// Função para adicionar um novo item
function addItem() {
    const itemName = document.getElementById("itemName").value.trim();
    const itemPrice = document.getElementById("itemPrice").value.trim();
    const itemList = document.getElementById("itemList");

    // Validação dos campos
    if (itemName === "" || itemPrice === "" || parseFloat(itemPrice) <= 0) {
        alert("Preencha o nome e o preço do item corretamente.");
        return false;
    }

    // Cria um objeto para o novo item
    const item = {
        name: itemName,
        price: parseFloat(itemPrice).toFixed(2),
    };

    // Adiciona o item à lista
    items.push(item);

    // Limpa os campos do formulário
    document.getElementById("itemName").value = "";
    document.getElementById("itemPrice").value = "";

    // Atualiza a lista exibida
    displayItems();
    return false;
}

// Função para remover um item da lista
function removeItem(index) {
    items.splice(index, 1);
    displayItems();
}

// Função para exibir os itens na página
function displayItems() {
    const itemList = document.getElementById("itemList");
    itemList.innerHTML = ""; // Limpa a lista antes de exibir

    items.forEach((item, index) => {
        const li = document.createElement("li");
        li.innerHTML = `${item.name} - R$ ${item.price} 
                        <button onclick="removeItem(${index})">Remover</button>`;
        itemList.appendChild(li);
    });
}
