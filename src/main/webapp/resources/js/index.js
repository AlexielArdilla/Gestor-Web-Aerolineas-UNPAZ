// '.tbl-content' consumed little space for vertical scrollbar, scrollbar width depend on browser/os/platfrom. Here calculate the scollbar width .
$(window).on("load resize ", function() {
  var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();
  $('.tbl-header').css({'padding-right':scrollWidth});
}).resize();

//******Blink exceso equipaje
$(function() {
    var on = false;
    window.setInterval(function() {
        on = !on;
        if (on) {
            $('.exceso-5.0').addClass('invalid-blink')
        } else {
            $('.invalid-blink').removeClass('invalid-blink')
        }
    }, 2000);
});