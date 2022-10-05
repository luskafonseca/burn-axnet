
/* =============================================*/
function funcao1()
{
alert("Parabéns ! Sua inscrição foi realizada com sucesso ! Aguarde que nossa equipe entrará em contato com você.");
}
function funcao2()
{
alert("Equipe Excluida");
}
function funcao3()
{
alert("Atualizado ! ");
}

(function($) {
  
  "use strict";  

  $(window).on('load', function() {

  /*Page Loader active
    ========================================================*/
    $('#preloader').fadeOut();

  // Sticky Nav
    $(window).on('scroll', function() {
        if ($(window).scrollTop() > 200) {
            $('.scrolling-navbar').addClass('top-nav-collapse');
        } else {
            $('.scrolling-navbar').removeClass('top-nav-collapse');
        }
    });

    /* ==========================================================================
       countdown timer
       ========================================================================== */
     jQuery('#clock').countdown('2022/10/22',function(event){
      var $this=jQuery(this).html(event.strftime(''
      +'<div class="time-entry dias"><span>%-D</span> Dias</div> '
      +'<div class="time-entry horas"><span>%H</span> Horas</div> '
      +'<div class="time-entry minutos"><span>%M</span> Minutos</div> '
      +'<div class="time-entry segundos"><span>%S</span> Segundos</div> '));
    });

    /* slicknav mobile menu active  */
    $('.mobile-menu').slicknav({
        prependTo: '.navbar-header',
        parentTag: 'liner',
        allowParentLinks: true,
        duplicate: true,
        label: '',
      });

      /* WOW Scroll Spy
    ========================================================*/
     var wow = new WOW({
      //disabled for mobile
        mobile: false
    });
    wow.init();

    /* Nivo Lightbox 
    ========================================================*/
    $('.lightbox').nivoLightbox({
        effect: 'fadeScale',
        keyboardNav: true,
      });

    // one page navigation 
    $('.navbar-nav').onePageNav({
            currentClass: 'active'
    }); 

    /* Back Top Link active
    ========================================================*/
      var offset = 200;
      var duration = 500;
      $(window).scroll(function() {
        if ($(this).scrollTop() > offset) {
          $('.back-to-top').fadeIn(400);
        } else {
          $('.back-to-top').fadeOut(400);
        }
      });

      $('.back-to-top').on('click',function(event) {
        event.preventDefault();
        $('html, body').animate({
          scrollTop: 0
        }, 600);
        return false;
      });

  });      

}(jQuery));
