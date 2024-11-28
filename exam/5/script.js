

const now = document.getElementById('Application');
now.addEventListener('submit', function(event) {
    event.preventDefault();

    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const password =document.getElementById('password').value;
    const address =document.getElementById('address').value;
    const club = document.querySelector("input[name='club']:checked").value;
    const cars = document.getElementById('cars').value;
    const resume = document.getElementById('resume').value;
    const final = document.querySelector("input[name='final']:checked").value;
    document.write(name);
    document.write ("<br>");
    document.write(email);
    document.write ("<br>");
    document.write(password);
    document.write ("<br>");
    document.write(address);
    document.write ("<br>");
    document.write(club);
    document.write ("<br>");
    document.write(cars);
    document.write ("<br>");
    document.write(final);
    document.write ("<br>");
    document.write(resume);
    document.getElementById('message').innerHTML = "successful";
});