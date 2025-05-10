const app = document.getElementById('app');

function clearApp() {
    app.innerHTML = '';
}

function createInput(id, placeholder, type = 'text') {
    const input = document.createElement('input');
    input.id = id;
    input.placeholder = placeholder;
    input.type = type;
    return input;
}

function createPageLogin() {
    clearApp();

    const h2 = document.createElement('h2');
    h2.innerText = 'Логін';

    const username = createInput('loginUsername', 'Username');
    const password = createInput('loginPassword', 'Password', 'password');
    const button = document.createElement('button');
    button.innerText = 'Увійти';
    button.onclick = login;

    const msg = document.createElement('p');
    msg.id = 'loginMessage';

    app.append(h2, username, document.createElement('br'),
        password, document.createElement('br'),
        button, msg);
}
function createPageRegister() {
    clearApp();

    const h2 = document.createElement('h2');
    h2.innerText = 'Реєстрація';

    const username = createInput('regUsername', 'Username');
    const password = createInput('regPassword', 'Password', 'password');
    const phone = createInput('regPhone', 'Phone');
    const email = createInput('regEmail', 'Email', 'email');
    const birthDate = createInput('regBirthDate', 'Birth Date (YYYY-MM-DD)', 'date');

    const sexLabel = document.createElement('label');
    sexLabel.innerText = 'Стать: ';
    const sexSelect = document.createElement('select');
    sexSelect.id = 'regSex';
    ['MALE', 'FEMALE', 'OTHER'].forEach(gender => {
        const option = document.createElement('option');
        option.value = gender;
        option.innerText = gender;
        sexSelect.appendChild(option);
    });

    const button = document.createElement('button');
    button.innerText = 'Зареєструватись';
    button.onclick = register;

    const msg = document.createElement('p');
    msg.id = 'registerMessage';

    app.append(h2,
        username, document.createElement('br'),
        password, document.createElement('br'),
        phone, document.createElement('br'),
        email, document.createElement('br'),
        birthDate, document.createElement('br'),
        sexLabel, sexSelect, document.createElement('br'),
        button, msg
    );
}


function createPageUsers(users) {
    clearApp();

    const h2 = document.createElement('h2');
    h2.innerText = 'Список користувачів';

    const ul = document.createElement('ul');
    ul.id = 'usersList';

    if (users && users.length > 0) {
        users.forEach(user => {
            const li = document.createElement('li');
            li.innerText = user.username;
            ul.appendChild(li);
        });
    } else {
        ul.innerHTML = '<li>Не вдалося отримати користувачів.</li>';
    }

    app.append(h2, ul);
}

async function login() {
    const username = document.getElementById('loginUsername').value;
    const password = document.getElementById('loginPassword').value;

    const response = await fetch('http://localhost:8080/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, password })
    });

    const msg = document.getElementById('loginMessage');
    if (response.ok) {
        const token = await response.text();
        localStorage.setItem('token', token);
        msg.innerText = 'Успішний вхід!';
        await getAllUsers();
    } else {
        msg.innerText = await response.text();
    }
}

async function register() {
    const username = document.getElementById('regUsername').value;
    const password = document.getElementById('regPassword').value;
    const phone = document.getElementById('regPhone').value;
    const email = document.getElementById('regEmail').value;
    const birthDate = document.getElementById('regBirthDate').value;
    const sex = document.getElementById('regSex').value;

    const response = await fetch('http://localhost:8080/register', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, password, phone, email, birthDate, sex })
    });
    console.log(username, password, phone, email, birthDate, sex)

    const msg = document.getElementById('registerMessage');
    if (response.ok) {
        msg.innerText = 'Успішна реєстрація!';
        createPageLogin();
    } else {
        msg.innerText = await response.text();
    }
}


async function getAllUsers() {
    const token = localStorage.getItem('token');

    const response = await fetch('http://localhost:8080/all', {
        headers: { 'Authorization': 'Bearer ' + token }
    });

    if (response.ok) {
        const users = await response.json();
        createPageUsers(users);
    } else {
        createPageUsers([]);
    }
}

document.getElementById('loginBtn').addEventListener('click', createPageLogin);
document.getElementById('registerBtn').addEventListener('click', createPageRegister);
document.getElementById('getUsersBtn').addEventListener('click', getAllUsers);

createPageLogin();
