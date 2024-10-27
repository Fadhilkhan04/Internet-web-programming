let currentTime = 1 * 60; 
let timerInterval;

//correct answers
const correctAnswers = {
    club: "realmadrid",
    chem: "fe",
    planet: "mars",
    capital: "delhi",
    animal: "bison"
};

// timer
function startTimer() {
    timerInterval = setInterval(function() {
        let minutes = Math.floor(currentTime / 60);
        let seconds = currentTime % 60;
        document.getElementById('time').textContent = `${minutes}:${seconds < 10 ? '0' : ''}${seconds}`;
        
        if (currentTime <= 0) {
            clearInterval(timerInterval);
            submitQuiz(); 
        }
        currentTime--;
    }, 1000);
}


//start timer
window.onload = function() {
    startTimer();
};


//when the form is submitted
$(document).ready(function(){
  $('#mcqquizform').on('submit', function(event) {
    event.preventDefault();
    submitQuiz();
  });
}); 


//when submitted or timer gone to zero
function submitQuiz() {
    clearInterval(timerInterval);
    
    let score = 0;

    for (const [question, correctAnswer] of Object.entries(correctAnswers)) {
        const userAnswer = $(`input[name="${question}"]:checked`).val();
        
        if (userAnswer === correctAnswer) {
            score++;
        }
    }
    
    $('#message').css('color', 'green').text(`Submitted. Your score is ${score} out of ${Object.keys(correctAnswers).length}.`);
}
