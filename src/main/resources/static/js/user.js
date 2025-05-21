async function loadUserProfile() {
    const username = localStorage.getItem('username');
    const token = localStorage.getItem('token');
    const app = document.getElementById('app');
    app.innerHTML = '';

    if (!username || !token) {
        app.innerHTML = '<p>Користувач не авторизований.</p>';
        return;
    }

    try {
        const response = await fetch(`http://localhost:8080/user/${username}`, {
            headers: {'Authorization': 'Bearer ' + token}
        });

        if (response.ok) {
            const user = await response.json();

            app.innerHTML = `
                <section class="user-profile">
                    <h2>Особистий кабінет</h2>
                    <p><strong>Ім'я:</strong> ${user.username || '-'}</p>
                    <p><strong>Номер мобільного:</strong> ${user.phone || '-'}</p>
                    <p><strong>Email:</strong> ${user.email}</p>
                    <p><strong>Дата народження:</strong> ${user.birthDate || '-'}</p>
                    <p><strong>Стать:</strong> ${convertSexToText(user.sex) || '-'}</p>
                </section>
            `;
        } else {
            app.innerHTML = `<p>Не вдалося завантажити профіль (${response.status}).</p>`;
        }
    } catch (error) {
        app.innerHTML = `<p>Помилка при завантаженні профілю: ${error.message}</p>`;
    }
}

function convertSexToText(sex) {
    switch (sex) {
        case "MALE":
            return "Чоловіча"
        case "FEMALE":
            return "Жіноча"
        case "OTHER":
            return "Інша"
    }
}
