function send() {
    var author = document.getElementById("author").value;
    var content = document.getElementById("message").value;
    document.getElementById("message").value="";
    const json = {
          author: author,
          content: content,
    };
    fetch("/", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(json),
    });
    setTimeout(function(){document.formMenu.submit();}, 300);
}
function search() {
    if(event.keyCode == 13) {
        send();
    } else if (event.keyCode == 27) {
        window.location.reload();
        }
    }

function authorEnter() {
    if(event.keyCode == 13) {
        document.getElementById("message").focus();
    }
}

function start() {
    let author = document.getElementById("author").value;
    if (author) {
        document.getElementById("message").focus();
    } else {
        document.getElementById("author").focus();
    }
}