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
    data.email = document.getElementById('email').value;
    data.password = document.getElementById('pass').value;

    // Make the request and sends the data through  POST
    const request = await fetch('auth/login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    const response = await request.json();

    if(response == 'OK'){
        window.location.href = 'index.html';
    } else {
        alert('Wrong credentials.')
    }
}