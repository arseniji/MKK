
let intervalId9 = 0;

const form = document.querySelector('.form-table');



const input_email = document.querySelector('.email');
const input_passwd1 = document.querySelector('.passwd1');
const input_passwd2 = document.querySelector('.passwd2');
const input_login = document.querySelector('.login');

const input_phone = document.querySelector('.phone_number');
const input_data = document.querySelector('.data');



const error_data = document.getElementById('error-message');

const error_login = document.getElementById('error-message_login');
const error_passwd1 = document.getElementById('error-message_passwd1');
const error_passwd2 = document.getElementById('error-message_passwd2');
const error_phone = document.getElementById('error-message_phone');
const error_email = document.getElementById('error-message_email');



const regex_email = /^[^\s@]+@[^\s@]+\.[^\s@]{2,4}$/;
const regex_password = /^(?=.*[a-zа-яё])(?=.*[A-ZА-ЯЁ])(?=.*[0123456789])(?=.*\d)(?=.*[~!?@#$%^&*_\-+()\[\]{}><\/\\|"'.,:;])[A-ZА-ЯЁa-zа-яё\d~!?@#$%^&*_\-+()\[\]{}><\/\\|"'.,:;]{8,128}$/;
const regex_login = /^[A-Za-z\d0123456789]{3,16}$/;//

const regex_number = /^\+\d{11}$/;

const regex = [regex_login, regex_email, regex_password, regex_password ]

function at_moment_regex(input_re, re_input, err_mes){
  const emailValue = input_re.value.trim();

  if (re_input.test(emailValue)) {
    input_re.style.borderColor = '#08497e';
    input_re.style.boxShadow = '0 0 5px rgba(102, 175, 233, 0.6)'
    input_re.style.backgroundColor = 'white'
    err_mes.style.display="none";
  } else {
    input_re.style.borderColor = '#ab3a0d';
    input_re.style.boxShadow = '0 0 5px rgba(158, 23, 13, 0.6)'
    input_re.style.backgroundColor = 'rgba(255, 220, 218, 0.6)'
    err_mes.style.display="block";
  }
}

form.addEventListener('submit', (event) => {
  event.preventDefault();

  const mas_pol = [input_login, input_email, input_passwd1, input_passwd2];
  let isFormValid = true;
  let i = 0;
  mas_pol.forEach((el) => {
    if (el.value.trim() === '' ) {
      el.style.borderColor = '#ab3a0d';
      el.style.boxShadow = '0 0 5px rgba(158, 23, 13, 0.6)';
      el.style.backgroundColor = 'rgba(255, 220, 218, 0.6)';
      isFormValid = false;
    } else if (!regex[i].test(el.value)) {
      el.style.borderColor = '#ab3a0d';
      el.style.boxShadow = '0 0 5px rgba(158, 23, 13, 0.6)';
      el.style.backgroundColor = 'rgba(255, 220, 218, 0.6)';
      isFormValid = false;
    } else {
      el.style.borderColor = '#08497e';
      el.style.boxShadow = '0 0 5px rgba(102, 175, 233, 0.6)';
      el.style.backgroundColor = 'white';
    }
    i++;
  });

  if (isFormValid) {
    const login = document.querySelector(".login").value;
          sessionStorage.setItem("savedLogin", login);
          console.log(login);
        
          // Перенаправляем с задержкой 100 мс
          setTimeout(() => {
            window.location.href = "accaunt.html";
          }, 1000);
    alert("Форма отправлена");
    form.reset();
  } else {
    alert("Заполните все обязательные поля");
  }
});




input_email.addEventListener('blur', function () {
  at_moment_regex(input_email, regex_email, error_email);
});
input_passwd1.addEventListener('blur' , () =>{
  at_moment_regex(input_passwd1, regex_password, error_passwd1);
});
input_passwd2.addEventListener('blur', () =>{

  const passwd1 = input_passwd1.value.trim();
  const passwd2 = input_passwd2.value.trim();
  if (passwd1 != passwd2) {
    input_passwd2.style.borderColor = '#ab3a0d';
    input_passwd2.style.boxShadow = '0 0 5px rgba(158, 23, 13, 0.6)'
    input_passwd2.style.backgroundColor = '#ffdcdc';
    error_passwd2.style.display="block";
    error_passwd2.textContent="Пароли не совпадают";
    
  }
  else {
    input_passwd2.style.borderColor = '#08497e';
    input_passwd2.style.boxShadow = '0 0 5px rgba(102, 175, 233, 0.6)'
    input_passwd2.style.backgroundColor = 'white'
    error_passwd2.style.display="none";
    error_passwd2.textContent="";
  }
});
input_login.addEventListener('blur', () => {
  at_moment_regex(input_login, regex_login, error_login);
})

input_phone.addEventListener('blur', ()=>{
  at_moment_regex(input_phone, regex_number, error_phone);
});
input_data.addEventListener('blur', () => {
  const in_data = input_data.value;
  const dataa = new Date(in_data);

  if (isNaN(dataa.getTime())) {
    error_data.textContent = "Некорректная дата";
    error_data.style.display = "block";
  } 

  else if (dataa.getFullYear() < 1920) {
    error_data.textContent = "Дата должна быть не раньше 1920 года";
    error_data.style.display = "block";
  } 

  else {
    error_data.style.display = "none";
  }
});

