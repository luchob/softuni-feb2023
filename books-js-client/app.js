let loadBooksBtn = document.getElementById("loadBooks");

loadBooksBtn.addEventListener('click', reloadBooks)

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

      row.appendChild(titleCol)
      row.appendChild(authorCol)
      row.appendChild(isbnCol)
      row.appendChild(actionCol)

      booksCntr.appendChild(row)
  }))

}