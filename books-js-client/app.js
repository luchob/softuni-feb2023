let loadBooksBtn = document.getElementById("loadBooks");

loadBooksBtn.addEventListener('click', reloadBooks)

// TODO: create new book

function reloadBooks() {

  let booksCntr = document.getElementById('books-container')
  booksCntr.innerHTML = ''

  fetch("http://localhost:8080/api/books").
    then(response => response.json()).
    then(json => json.forEach(book => {
      // create row
      let row = document.createElement('tr')

      let titleCol = document.createElement('td')
      let authorCol = document.createElement('td')
      let isbnCol = document.createElement('td')
      let actionCol = document.createElement('td')

      //book
      titleCol.textContent = book.title
      // atuhor
      authorCol.textContent = book.author.name
      isbnCol.textContent = book.isbn
      //actions
      //delete btn
      let deleteBtn = document.createElement('button')
      deleteBtn.innerText = 'DELETE'
      deleteBtn.dataset.id = book.id
      deleteBtn.addEventListener('click', deleteBtnClicked)

      actionCol.appendChild(deleteBtn)

      row.appendChild(titleCol)
      row.appendChild(authorCol)
      row.appendChild(isbnCol)
      row.appendChild(actionCol)

      booksCntr.appendChild(row)
  }))

}

function deleteBtnClicked(event) {
  let bookId = event.target.dataset.id;

  deleteBook(bookId)
}

function deleteBook(bookId) {

  var requestOptions = {
    method: 'DELETE'
  }

  fetch(`http://localhost:8080/api/books/${bookId}`, requestOptions).
    then(_ => reloadBooks()).
    catch(error => console.log('error', error))

}