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

async function login() {
    const username = document.getElementById('loginUsername').value;
    const password = document.getElementById('loginPassword').value;

    const response = await fetch('http://localhost:8080/login', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({username, password})
    });

    const msg = document.getElementById('loginMessage');
    if (response.ok) {
        const token = await response.text();
        localStorage.setItem('token', token);
        localStorage.setItem('username',  username)
        msg.innerText = 'Успішний вхід!';

        updateNavAfterLogin();

        await getPhones();
    } else {
        msg.innerText = await response.text();
    }
}

function updateNavAfterLogin() {
    const nav = document.getElementById('main-nav');

    document.getElementById('loginBtn')?.remove();
    document.getElementById('registerBtn')?.remove();

    nav.innerHTML = '';

    const showPhonesBtn = document.createElement('button');
    showPhonesBtn.id = 'showPhones';
    showPhonesBtn.innerText = 'Показати телефони';
    showPhonesBtn.addEventListener('click', getPhones);

    const profileBtn = document.createElement('button');
    profileBtn.id = 'profileBtn';
    profileBtn.innerText = 'Особистий кабінет';
    profileBtn.addEventListener('click', (e) => {
        e.preventDefault();
        profileBtn.addEventListener('click', async (e) => {
            e.preventDefault();
            await loadUserProfile();
        });
    });

    const logoutBtn = document.createElement('button');
    logoutBtn.id = 'logoutBtn';
    logoutBtn.innerText = 'Вийти';
    logoutBtn.addEventListener('click', () => {
        localStorage.removeItem('token');
        localStorage.removeItem('username');
        location.reload();
    });

    nav.appendChild(showPhonesBtn);
    nav.appendChild(profileBtn);
    nav.appendChild(logoutBtn);
}

function createAuthButtons() {
    const nav = document.getElementById('main-nav');
    nav.innerHTML = '';

    const loginBtn = document.createElement('button');
    loginBtn.id = 'loginBtn';
    loginBtn.innerText = 'Увійти';
    loginBtn.addEventListener('click', createPageLogin);

    const registerBtn = document.createElement('button');
    registerBtn.id = 'registerBtn';
    registerBtn.innerText = 'Зареєструватись';
    registerBtn.addEventListener('click', createPageRegister);

    nav.appendChild(registerBtn);
    nav.appendChild(loginBtn);

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
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({username, password, phone, email, birthDate, sex})
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

const token = localStorage.getItem('token');
if (token) {
    fetch('http://localhost:8080/phones/all', {
        headers: {
            'Authorization': 'Bearer ' + token
        }
    })
        .then(response => {
            if (response.ok) {
                updateNavAfterLogin();
                return getPhones();
            } else {
                localStorage.removeItem('token');
                createAuthButtons();
                createPageLogin();
            }
        })
        .catch(() => {
            localStorage.removeItem('token');
            createAuthButtons();
            createPageLogin();
        });
} else {
    createAuthButtons();
    createPageLogin();
}

