let currentTime = 1 * 60; 
let timerInterval;

// Correct answers
const correctAnswers = {
    club: "realmadrid",
    chem: "fe",
    planet: "mars",
    capital: "delhi",
    animal: "bison"
};

// Timer
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

// Start timer
window.onload = function() {
    startTimer();

    const quizForm = document.getElementById('mcqquizform');
    quizForm.addEventListener('submit', function(event) {
        event.preventDefault();
        submitQuiz();
    });
};

// When submitted or timer reaches zero
function submitQuiz() {
    clearInterval(timerInterval);

    let score = 0;

    for (const [question, correctAnswer] of Object.entries(correctAnswers)) {
        const userAnswer = document.querySelector(`input[name="${question}"]:checked`);
        if (userAnswer && userAnswer.value === correctAnswer) {
            score++;
        }
    }

    const message = document.getElementById('message');
    message.style.color = 'green';
    message.textContent = `Submitted. Your score is ${score} out of ${Object.keys(correctAnswers).length}.`;
}
