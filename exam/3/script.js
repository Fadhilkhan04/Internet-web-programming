function changeTime(){
  const now = new Date();
  const datetime = now.toLocaleString();
  document.getElementById('datetime').innerHTML=datetime;
}
setInterval(changeTime,1000);
var images = ["./images/car.jpg","./images/car2.jpg","./images/car3.jpg"]

var thisid = 0;
function changeImage(){
  const img = document.getElementById('image');
  img.setAttribute('src',images[thisid]);
  thisid++;
  if (thisid==3){thisid = 0};
}
setInterval(changeImage,3000);