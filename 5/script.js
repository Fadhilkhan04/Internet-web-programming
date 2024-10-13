function updateDateTime() {
  const now = new Date();

  const currentDateTime = now.toLocaleString();


  $("#datetime").text(currentDateTime);
}

// call the `updateDateTime` function every second
setInterval(updateDateTime, 1000);


  //prepare Your data array with img urls
var dataArray = ["images/car.jpg","images/car2.jpg","images/car3.jpg"];

  //start with id=0 after 5 seconds
var thisId=0;
  
  
window.setInterval(function(){
    $(".image").attr("src",dataArray[thisId]);
    thisId++;
    if (thisId==3) thisId=0; 
},5000);
