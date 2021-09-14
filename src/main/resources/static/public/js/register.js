let register = document.getElementById('btnSubmit');
let form = document.getElementById('form');

// Prevents the page from refreshing after click event
form.addEventListener('submit', (e) => {
    e.preventDefault();
})

// Add a click event that calls registerUser function
register.addEventListener('click',function(e){
    registerUser();
});


async function registerUser(){

    // Prepare the object to be send later as json
    let data = {}
    data.name = document.getElementById('name').value;
    data.email = document.getElementById('email').value;
    data.password = document.getElementById('pass1').value;

    let pass = document.getElementById('pass2').value == data.password && data.password != "";

    // Confirms that the password match and then, make the request. If not, returns and inform the user
    if(pass == false){
        document.getElementById('error1').textContent = 'Invalid password';
        document.getElementById('error2').textContent = 'Invalid password';
        return;
    }

    // Make the request and sends the data through  POST
    const request = await fetch('auth/register', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });

    alert("Succesfull");
    window.location.href = 'login.html';

}