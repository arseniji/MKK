
let intervalId9 = 0;

const form = document.querySelector('.form-table');

const input_passwd1 = document.querySelector('.passwd1');

const input_login = document.querySelector('.login');

const error_login = document.getElementById('error-message_login');
const error_passwd1 = document.getElementById('error-message_passwd1');




const regex_password = /^(?=.*[a-zа-яё])(?=.*[A-ZА-ЯЁ])(?=.*[0123456789])(?=.*\d)(?=.*[~!?@#$%^&*_\-+()\[\]{}><\/\\|"'.,:;])[A-ZА-ЯЁa-zа-яё\d~!?@#$%^&*_\-+()\[\]{}><\/\\|"'.,:;]{8,128}$/;
const regex_login = /^[A-Za-z\d0123456789]{3,16}$/;//



const regex = [regex_login, regex_password ]

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
  const mas_pol = [input_login, input_passwd1];
  let isFormValid = true;

  mas_pol.forEach((el, i) => {
      if (el.value.trim() === '' || !regex[i].test(el.value)) {
          el.style.borderColor = '#ab3a0d';
          el.style.boxShadow = '0 0 5px rgba(158, 23, 13, 0.6)';
          el.style.backgroundColor = 'rgba(255, 220, 218, 0.6)';
          isFormValid = false;
      } else {
          el.style.borderColor = '#08497e';
          el.style.boxShadow = '0 0 5px rgba(102, 175, 233, 0.6)';
          el.style.backgroundColor = 'white';
      }
  });

  if (isFormValid) {
      const login = document.querySelector(".login").value;
      sessionStorage.setItem("savedLogin", login);
      sessionStorage.setItem("InLogin", 'true');
      console.log(login);
    
      // Перенаправляем с задержкой 100 мс
      setTimeout(() => {
        window.location.href = "accaunt.html";
      }, 1000);
  }
    });
      





input_passwd1.addEventListener('blur' , () =>{
  at_moment_regex(input_passwd1, regex_password, error_passwd1);
});

input_login.addEventListener('blur', () => {
  at_moment_regex(input_login, regex_login, error_login);
})


