const form = document.getElementById('authorization-form');
const loginInput = document.getElementById('loginInput');
const passwordInput = document.getElementById('passwordInput');

form.addEventListener('submit', async (event) =>{
    const login = loginInput.value;
    const password = passwordInput.value;
//TODO Исправить, не работает
    try {
        const response = await fetch('/resum/'+login, {
            method: 'GET',
            body: JSON.stringify({login,password}),
            headers:{'Content-Type' : 'application/json'}
        });
        if (response.ok) {
            window.location.href = '/resum/'+login;
        }else {
            const error = await response.json();
            const errorMassage = error.massage || 'Произошла ошибка';
            showErrorMessage(errorMassage);
        }
    }catch (error){
        showErrorMessage("Произошла ошибка");
    }
});

function showErrorMessage(massage){
    const errorElement = document.createElement('span');
    errorElement.classList.add('error-massage');
    errorElement.textContent = massage;
    form.appendChild(errorElement);
}