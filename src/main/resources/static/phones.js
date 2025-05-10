function createPagePhones(phones) {
    clearApp();

    const h2 = document.createElement('h2');
    h2.innerText = 'Список телефонів';

    const container = document.createElement('div');
    container.style.display = 'grid';
    container.style.gridTemplateColumns = 'repeat(auto-fit, minmax(250px, 1fr))';
    container.style.gap = '1rem';

    phones.forEach(phone => {
        const card = document.createElement('div');
        card.style.border = '1px solid #ccc';
        card.style.borderRadius = '8px';
        card.style.padding = '1rem';
        card.style.boxShadow = '0 0 8px rgba(0,0,0,0.1)';

        card.innerHTML = `
            <h3>${phone.modelName}</h3>
            <p><strong>Памʼять:</strong> ${phone.memoryCapacity} GB</p>
            <p><strong>Частота екрану:</strong> ${phone.screenHertz} Hz</p>
            <p><strong>Розмір екрану:</strong> ${phone.screenSize}"</p>
            <p><strong>Використаний:</strong> ${phone.isUsed ? 'Так' : 'Ні'}</p>
            <p><strong>Батарея:</strong> ${phone.batteryCapacity}%</p>
            <p><strong>Стан:</strong> ${phone.techCondition}</p>
            <p><strong>Ціна:</strong> ${phone.price} USD</p>
            <p><strong>Кількість:</strong> ${phone.quantity}</p>
        `;

        container.appendChild(card);
    });

    app.append(h2, container);
}

async function getPhones() {
    const token = localStorage.getItem('token');
    const response = await fetch('http://localhost:8080/phones/all', {
        headers: {'Authorization': 'Bearer ' + token}
    });

    if (response.ok) {
        const phones = await response.json();
        createPagePhones(phones);
    } else {
        console.error('Помилка при отриманні телефонів');
    }
}

document.getElementById('showPhones').addEventListener('click', getPhones);