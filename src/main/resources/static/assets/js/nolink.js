let allNolinktag = document.querySelectorAll('.nolink');
allNolinktag.forEach(element => {
  element.removeAttribute('href');
});