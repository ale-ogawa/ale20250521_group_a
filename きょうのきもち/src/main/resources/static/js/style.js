const CLASSNAME = "-visible";
const TIMEOUT = 1500;
const $target = $(".style_kokoro_title");

setInterval(() => {
  $target.addClass(CLASSNAME);
  setTimeout(() => {
    $target.removeClass(CLASSNAME);
  }, TIMEOUT);
}, TIMEOUT * 2);