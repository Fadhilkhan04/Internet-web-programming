const images = [
  'images/car.jpg',
  'images/car2.jpg',
  'images/car3.jpg'
];

let currentIndex = 0;

function changeImage() {
  const slideshow = document.getElementById('slideshow');
  slideshow.style.animation = 'none'; // Reset animation
  slideshow.src = images[currentIndex];
  currentIndex = (currentIndex + 1) % images.length;
  setTimeout(() => {
      slideshow.style.animation = 'pulse 1.5s ease-in-out forwards'; // Restart animation
  }, 10);
}

// Change image every 3 seconds
setInterval(changeImage, 3000);
