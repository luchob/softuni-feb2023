yieldUnescaped '<!DOCTYPE html>'
html(lang: 'en') {
    head {
        meta('http-equiv': '"Content-Type" content="text/html; charset=utf-8"')
        title("Books")
        link(rel: "stylesheet", type: "text/css", href: "/css/styles.css")
    }
    body {
        div {
            table(border: "1") {
                tr {
                    th("Title ")
                    th("Author")
                    th("ISBN")
                }
                books.each { book ->
                    tr {
                        td("$book.title")
                        td("$book.author.name")
                        td("$book.isbn")
                    }
                }
            }
        }
    }
}