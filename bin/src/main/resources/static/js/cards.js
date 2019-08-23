$(document).ready(function() {
  var imgs = $('.card img');//jQuery class selector
  imgs.each(function(){
    var img = $(this);
    var width = img.width(); //jQuery width method
    var height = img.height(); //jQuery height method
    if(width < height){
       img.addClass('portrait');
    }else{
       img.addClass('landscape');
    }
  })
});