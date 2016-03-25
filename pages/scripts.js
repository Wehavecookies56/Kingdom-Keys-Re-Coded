$('body').scrollspy({
  target: '#navbar'
});

$("#change-gallery-page-1").on('click',function(){
    $("#gallery-content").find("div[id^='gallery-page']").each(function(){
      $(this).hide();
    });
    $("#gallery-pages").find("li").each(function(){
      $(this).removeClass("active");
    });
    $("#gallery-page1").show();
    $(this).parent().addClass("active");
});

$("#change-gallery-page-2").on('click',function(){
    $("#gallery-content").find("div[id^='gallery-page']").each(function(){
      $(this).hide();
    });
    $("#gallery-pages").find("li").each(function(){
      $(this).removeClass("active");
    });
    $("#gallery-page2").show();
    $(this).parent().addClass("active");
});