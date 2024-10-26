$(document).ready(function() {
  $('#jobApplicationForm').on('submit', function(event) {
      event.preventDefault();
      
      // Clear any previous messages
      $('#message').text('');

      // Get form values
      const name = $('#name').val().trim();
      const email = $('#email').val().trim();
      const phone = $('#phone').val().trim();
      const resume = $('#resume').val();

      // Validate fields
      if (name === "") {
          $('#message').text("Please enter your full name.");
          return;
      }
      if (!validateEmail(email)) {
          $('#message').text("Please enter a valid email address.");
          return;
      }
      if (!validatePhone(phone)) {
          $('#message').text("Please enter a valid phone number.");
          return;
      }
      if (resume === "") {
          $('#message').text("Please upload your resume.");
          return;
      }

      // Form submission successful
      $('#message').css('color', 'green').text("Application submitted successfully!");
  });

  // Email validation
  function validateEmail(email) {
      const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
      return emailPattern.test(email);
  }

  // Phone number validation
  function validatePhone(phone) {
      const phonePattern = /^[0-9]{10}$/;
      return phonePattern.test(phone);
  }
});
