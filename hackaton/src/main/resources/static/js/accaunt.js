window.addEventListener("DOMContentLoaded", () => {
  const savedLogin = sessionStorage.getItem("savedLogin");
  const l = sessionStorage.getItem("InLogin");
  console.log(l);
  console.log(savedLogin)
  if (savedLogin) {
    document.getElementById("login_text").textContent = savedLogin;
    console.log("Логин получен:", savedLogin); // Для отладки
  } else {
    console.log("Логин не найден в sessionStorage");
  }
});
