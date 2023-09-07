const form = document.getElementById("registration-form");
const loginInput = document.getElementById('loginInput');
const fioInput = document.getElementById('fioInput');
const passwordInput = document.getElementById('passwordInput');

form.addEventListener('submit', async (event) => {
    event.preventDefault();


    const username = loginInput.value;
    const fio = fioInput.value;
    const password = passwordInput.value;
    window.location.href = '/authorization';
    try {
        const response = await fetch('/user', {
            method: 'POST',
            body: JSON.stringify(username, fio, password),
            headers: {'Content-Type': 'application/json'}
        });
        if (response.ok) {
            window.location.href = '/authorization';
        } else {
            const error = await response.json();
            const errorMassage = error.massage || 'Произошла ошибка';
            showErrorMessage(errorMassage);
        }
    } catch (error) {
        showErrorMessage("Произошла ошибка");
    }
});

function showErrorMessage(massage) {
    const errorElement = document.createElement('span');
    errorElement.classList.add('error-massage');
    errorElement.textContent = massage;
    form.appendChild(errorElement);
}