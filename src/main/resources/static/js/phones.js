function createPagePhones(phones) {
    clearApp();

    const container = document.createElement('div');
    container.classList.add('item-container');

    phones.forEach(phone => {
        const card = document.createElement('div');
        card.classList.add('card');

        card.innerHTML = `
            <div class="tech-condition ${convertConditionToClass(phone.techCondition)}">
                <p>${convertConditionToText(phone.techCondition)}</p>
            </div>
            <p class="model-name">${phone.modelName}</p>
            <div class="info">
                <p class="memory">Памʼять: <span>${phone.memoryCapacity} GB</span></p>
                <p class="hertz">Частота екрану: <span>${phone.screenHertz} Hz</span></p>
                <p class="screen-size">Розмір екрану: <span>${phone.screenSize}"</span></p>
                <p class="is-used">Вживаний: <span>${phone.isUsed ? 'Так' : 'Ні'}</span></p>
                <p class="battery">Батарея: <span>${phone.batteryCapacity}%</span></p>
            </div>
            <div class="price"><p>$${phone.price.toFixed(2)}</p></div>
        `;

        container.appendChild(card);
    });

    app.append(container);
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

function convertConditionToText(condition) {
    switch (condition) {
        case 'NEW':
            return 'New';
        case 'LIKE_NEW':
            return 'Як новий';
        case 'VERY_GOOD':
            return 'Чудовий стан';
        case 'GOOD':
            return 'Хороший стан';
        case 'ACCEPTABLE':
            return 'Прийнятний стан';
        case 'POOR':
            return 'Поганий стан';
        case 'FOR_PARTS':
            return 'На запчастини';
        default:
            return 'Unknown Condition';
    }
}

function convertConditionToClass(condition) {
    switch (condition) {
        case 'NEW':
            return 'new';
        case 'LIKE_NEW':
            return 'like-new';
        case 'VERY_GOOD':
            return 'very-good';
        case 'GOOD':
            return 'good';
        case 'ACCEPTABLE':
            return 'acceptable';
        case 'POOR':
            return 'poor';
        case 'FOR_PARTS':
            return 'for-parts';
        default:
            return 'unknown';
    }
}

let showPhonesBtn = document.getElementById('showPhones');
if (showPhonesBtn) {
    showPhonesBtn.addEventListener('click', getPhones)
}