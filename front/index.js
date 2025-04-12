document.querySelectorAll('.img_city').forEach(item => {
    item.addEventListener('mouseenter', function() {
      anime({
        targets: this,
        translateY: [-15, 0],
        duration: 800,
        easing: 'spring(1, 80, 10, 0)'
      });
    });
  });
  new Swiper('.popul_scroll', {
    slidesPerView: 3,
    spaceBetween: 50,
    centeredSlides: true,
    initialSlide: 1, 
    navigation: {
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    },
    breakpoints: {
      640: {
        slidesPerView: 1.5,
        centeredSlides: true
      },
      1024: {
        slidesPerView: 3,
        centeredSlides: true
      }
    },
    on: {
      init: function() {
        updateSlideSizes(this);
      },
      slideChange: function() {
        updateSlideSizes(this);
      }
    }
  });

  function updateSlideSizes(swiper) {
    // Параметры анимации
    const activeScale = 1.5;
    const inactiveScale = 0.7;
    const duration = 500;
    
    swiper.slides.forEach((slide, index) => {
        const img = slide.querySelector('.img_city');
        if (!img) return;
        
        anime({
            targets: img,
            scale: index === swiper.activeIndex ? activeScale : inactiveScale,
            opacity: index === swiper.activeIndex ? 1 : 0.6,
            duration: duration,
            easing: 'easeOutElastic(1, .8)',
            elasticity: 400
        });
    });
}
  window.addEventListener('DOMContentLoaded', function() {
    if (sessionStorage.getItem('InLogin') === 'true') {
      document.querySelectorAll('.buttons').forEach(button => {
          button.style.display = 'none';
      });
      document.getElementById('user-profile').style.display = 'block';
  }
  
  // Обработчик кнопки выхода
  document.getElementById('logoutButton')?.addEventListener('click', function() {
      sessionStorage.removeItem('isLoggedIn');
      window.location.href = 'index.html';
  });
});