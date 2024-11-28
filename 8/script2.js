const now = document.getElementById('mcqquizform');
now.addEventListener('submit',function(event){
  event.preventDefault();
  submitQuiz();
})

const correctAnswers = {
  club: "realmadrid",
  chem: "fe",
  planet: "mars",
  capital: "delhi",
  animal: "bison"
};

function submitQuiz(){
  let score = 0;
  const club = document.querySelector("input[name='club']:checked").value;
  const chem = document.querySelector("input[name='chem']:checked").value;
  const planet = document.querySelector("input[name='planet']:checked").value;
  const capital = document.querySelector("input[name='capital']:checked").value;
  const animal = document.querySelector("input[name='animal']:checked").value;

  if(club==='realmadrid') {
    score++;
  } 
  if(chem==='fe') {
    score++;
  }
  if(planet==='mars') {
    score++;
  }
  if(capital==='delhi') {
    score++;
  }
  if(animal==='bison'){
    score++;
  } 

  const message = document.getElementById('message');
  message.innerHTML = `you scored ${score} out of 5`;
  message.setAttribute('style','color:green');
}