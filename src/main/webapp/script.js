const URL_TO_API = "http://localhost:8081/api"

const CODE_TO_EMOJI = {
    "pl" : "🇵🇱",
    "ru" : "🇷🇺",
    "de" : "🇩🇪",
    "us" : "🇺🇸"
};

fetch(`${URL_TO_API}/language`)
    .then(response => response.json())
    .then((langArr) => {
        const checkboxes = langArr.map(l =>`
            <label class="pure-radio">
                <input type="radio" name="lang" value="${l.id}">
                ${CODE_TO_EMOJI[l.code]}
            </label>`).join('\n');

        document.getElementById("langs").innerHTML = checkboxes;
    });

const div = document.getElementById('welcome');
const form = document.getElementById('welcomeForm');
document.getElementById('btn').addEventListener('click', (event) => {
    event.preventDefault();
    const formObj = {
        name: form.elements.name.value,
        lang: form.elements.lang.value
    };
    fetch(`${URL_TO_API}?${new URLSearchParams(formObj)}`)
        .then(response => response.text())
        .then((text) => {
            div.innerHTML = `
            <h1>${text}</h1>
        `;
        });
});