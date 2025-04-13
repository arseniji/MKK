
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
  // 1. Проверяем статус входа (используем правильный ключ)
  const isLoggedIn = sessionStorage.getItem('InLogin') === 'true';
  console.log(isLoggedIn);
  
  // 2. Находим кнопку
  const authBtn = document.querySelector('.auth-btn');
  if (!authBtn) return;
  
  // 3. Если пользователь вошел
  if (isLoggedIn) {
      // Меняем текст и поведение кнопки
      authBtn.setAttribute('data-i18n', 'menu.profile');
      authBtn.onclick = () => window.location.href = 'accaunt.html';
      
      // Обновляем текст (если i18next загружен)
      if (window.i18next) {
          authBtn.textContent = i18next.t('menu.profile');
      } else {
          authBtn.textContent = 'Профиль'; // Фолбэк
      }
      
      
  }
  
  
});
//переводчик


/*// Объединяем все переводы в один объект
const allTranslations = {
  ru: {
    translation: {
      "menu.home": "Главная",
      "menu.cities": "Города",
      "menu.places": "Места",
      "menu.about": "О нас",
      "menu.faq": "FAQ",
      "menu.login": "Войти",
      "hero.title": "Вам открыта новая местность — Краснодарский Край",
      "directions.title": "направления",
      "directions.slide1.title": "Назад в прошлое",
      "directions.slide1.desc": "Легенды, памятники и древние маршруты Краснодарского края",
      "directions.slide5.title": "Создай свое незабываемое приключение",
      "game_section.title": "Путешествие в формате игры",
      "game_section.button": "Хочу присоединиться!",
      "game_section.feature1": "Выполняйте квесты и получайте вознаграждение в виде коинов",
      "game_section.feature2": "Посещайте интересные места и достопримечательности",
      "map.title": "карта городов",
      "footer.home": "Главная",
      "footer.account": "Личный кабинет",
      "footer.faq": "FAQ",
      "footer.about": "О нас",
      "footer.language": "RU/EN",
      "footer.cooperation": "Кнопка для сотрудничества"
    }
  },
  en: {
    translation: {
      "menu.home": "Home",
              "menu.cities": "Cities",
              "menu.places": "Places",
              "menu.about": "About",
              "menu.faq": "FAQ",
              "menu.login": "Login",
              "hero.title": "Discover the new territory — Krasnodar Krai",
              "directions.title": "directions",
              "directions.title": "Directions",
          "directions.slide1.title": "Back to the past",
          "directions.slide1.desc": "Legends, monuments and ancient routes of Krasnodar Krai",
          "directions.slide2.title": "Harmony of soul",
          "directions.slide2.desc": "Landscapes of the region that can restore your energy",
          "directions.slide3.title": "Only forward",
          "directions.slide3.desc": "Mountain routes and active adventures",
          "directions.slide4.title": "Charge of drive",
          "directions.slide4.desc": "Discovery of new sensations and a charge of positive emotions",
          "directions.slide5.title": "Create your unforgettable adventure","game_section.title": "Travel in game format",
          "game_section.button": "I want to join!",
          "game_section.feature1": "Complete quests and earn coin rewards",
          "game_section.feature2": "Visit interesting places and attractions",
          "map.title": "Cities Map",
          "footer.home": "Home",
          "footer.account": "Account",
          "footer.faq": "FAQ",
          "footer.about": "About Us",
          "footer.language": "EN/RU",
          "footer.cooperation": "Partnership"
    }
  },
  ar: {
    translation: {
      "menu.home": "الصفحة الرئيسية",
              "menu.cities": "مدن",
              "menu.places": "أماكن",
              "menu.about": "معلومات عنا",
              "menu.faq": "التعليمات",
              "menu.login": "تسجيل الدخول",
              "hero.title": "أمامك منطقة جديدة - إقليم كراسنودار",
              "directions.title": "الاتجاهات",
              "directions.title": "الاتجاهات",
          "directions.slide1.title": "العودة إلى الماضي",
          "directions.slide1.desc": "أساطير ونصب وطرق قديمة لإقليم كراسنودار",
          "directions.slide2.title": "تناغم الروح",
          "directions.slide2.desc": "مناظر طبيعية للإقليم قادرة على استعادة طاقتك",
          "directions.slide3.title": "إلى الأمام فقط",
          "directions.slide3.desc": "طرق جبلية ومغامرات نشطة",
          "directions.slide4.title": "شحنة من الحماس",
          "directions.slide4.desc": "اكتشاف أحاسيس جديدة وشحنة من المشاعر الإيجابية",
          "directions.slide5.title": "اصنع مغامرتك التي لا تنسى",
          "game_section.title": "السفر في شكل لعبة",
          "game_section.button": "أريد الانضمام!",
          "game_section.feature1": "أكمل المهام واكسب مكافآت العملات",
          "game_section.feature2": "قم بزيارة الأماكن والمعالم السياحية المثيرة للاهتمام",
          "map.title": "خريطة المدن",
          "footer.home": "الصفحة الرئيسية",
          "footer.account": "الحساب الشخصي",
          "footer.faq": "الأسئلة الشائعة",
          "footer.about": "معلومات عنا",
          "footer.language": "AR/EN",
          "footer.cooperation": "تعاون"
    }
  },
  zh: {
    translation: {
      "menu.home": "主页",
              "menu.cities": "城市",
              "menu.places": "地方",
              "menu.about": "关于我们",
              "menu.faq": "常见问题",
              "menu.login": "登录",
              "hero.title": "向您开放的新领土 - 克拉斯诺达尔边疆区",
              "directions.title": "方向",
              "directions.title": "方向",
          "directions.slide1.title": "回到过去",
          "directions.slide1.desc": "克拉斯诺达尔边疆区的传说、古迹和古老路线",
          "directions.slide2.title": "灵魂和谐",
          "directions.slide2.desc": "能够恢复力量的边疆区风景",
          "directions.slide3.title": "只向前进",
          "directions.slide3.desc": "山地路线和积极冒险",
          "directions.slide4.title": "充满活力",
          "directions.slide4.desc": "发现新感觉和充满积极情绪",
          "directions.slide5.title": "创造你难忘的冒险",
          "game_section.title": "游戏化旅行",
          "game_section.button": "我要加入!",
          "game_section.feature1": "完成任务并获得代币奖励",
          "game_section.feature2": "参观有趣的地方和景点",
          
    }
  }
};

// Инициализируем один раз
i18next.init({
  lng: 'ru',
  resources: allTranslations
}).then(function() {
  updateContent();
});

// Функция обновления контента
function updateContent() {
  document.querySelectorAll('[data-i18n]').forEach(el => {
    el.textContent = i18next.t(el.getAttribute('data-i18n'));
  });
}

// Полная функция смены языка
function changeLanguage(lang) {
  i18next.changeLanguage(lang).then(() => {
    updateContent();
    document.getElementById('current-lang').textContent = lang.toUpperCase();
    
    // RTL для арабского
    if(lang === 'ar') {
      document.body.setAttribute('dir', 'rtl');
      document.body.style.textAlign = 'right';
    } else {
      document.body.removeAttribute('dir');
      document.body.style.textAlign = 'left';
    }
  });
}

// Остальные функции остаются без изменений
function toggleLangDropdown() {
  document.getElementById('lang-dropdown').classList.toggle('show');
}

document.addEventListener('click', function(e) {
  if (!e.target.closest('.lang-switcher')) {
    document.getElementById('lang-dropdown').classList.remove('show');
  }
});

// Инициализация при загрузке
document.addEventListener('DOMContentLoaded', () => {
  updateContent();
});*/