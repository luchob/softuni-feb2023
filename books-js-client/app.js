let loadBooksBtn = document.getElementById('loadBooks')
let createFrom = document.getElementById('createBookForm')

loadBooksBtn.addEventListener('click', reloadBooks);
createFrom.addEventListener(  "submit", createBook);

function createBook(event) {

  event.preventDefault();

  const form = event.currentTarget;
  const url = form.action;
  const formData = new FormData(form);
  const plainFormData = Object.fromEntries(formData.entries());
  const formDataAsJSONString = JSON.stringify(plainFormData);


  var requestOptions = {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: formDataAsJSONString
  };

  fetch(`http://localhost:8080/api/books`, requestOptions)
  .then(_ => {
    reloadBooks();
    form.reset();
  })
  .catch(error => console.log('error', error));
}

function deleteBook(bookId) {

  var requestOptions = {
    method: 'DELETE'
  };


  fetch(`http://localhost:8080/api/books/${bookId}`, requestOptions)
  .then(_ => {reloadBooks()})
  .catch(error => console.log('error', error));
}

function onDeleteBookClicked(event) {
  deleteBook(event.target.dataset.id)
}

function reloadBooks() {
  var requestOptions = {
    method: 'GET',
    redirect: 'follow'
  };

  let authorsContainer = document.getElementById('authors-container')
  authorsContainer.innerHTML = ''

  fetch("http://localhost:8080/api/books", requestOptions)
  .then(response => response.json())
  .then(json => json.forEach(book => {
    // here we will create some elements and add them to the table.
    let row = document.createElement('tr')

    //4 x td - title, author isbn, action
    let titleCol = document.createElement('td')
    let authorCol = document.createElement('td')
    let isbnCol = document.createElement('td')
    let actionCol = document.createElement('td')
    //

    titleCol.textContent = book.title
    authorCol.textContent = book.author.name
    isbnCol.textContent = book.isbn

    //actions
    let actionBtn = document.createElement('button')
    actionBtn.innerText = 'DELETE'
    actionBtn.dataset.id = book.id
    actionBtn.addEventListener('click', onDeleteBookClicked)
    //
    actionCol.appendChild(actionBtn)

    // add the columns to the parent row
    row.appendChild(titleCol)
    row.appendChild(authorCol)
    row.appendChild(isbnCol)
    row.appendChild(actionCol)

    authorsContainer.appendChild(row);
  }))
  .catch(error => console.log('error', error));
}