let login = document.getElementById('btnSubmit');
let form = document.getElementById('form');

// Prevents the page from refreshing after click event
form.addEventListener('submit', (e) => {
    e.preventDefault();
})

// Add a click event that calls registerUser function
login.addEventListener('click',function(e){
    signIn();
});


async function signIn(){

    // Prepare the object to be send later as json
    let data = {}
    data.username = document.getElementById('email').value;
    data.password = document.getElementById('pass').value;

    // Make the request and sends the data through  POST
    const request = await fetch('http://localhost:8080/auth/login', {
        method: 'POST',
        headers: {
            'Accept': '*/*',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    const response = await request;

    console.log(response);

    if(response.ok){
        window.location.href = 'index.html';
    } else {
        alert('Wrong credentials.')
    }
}