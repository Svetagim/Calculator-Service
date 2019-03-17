import bs4
from flask import Flask, render_template, request
import retrieve

app = Flask(__name__)


@app.route('/')
def index():
    return render_template('index.html')


@app.route('/index.html')
def search():
    data = request.args.get('search')
    if data == "":
        return render_template('index.html')
    col = retrieve.showCollection("indexCollection_new")
    words = retrieve.findWords(data, col)
    docs = retrieve.query(words)
    col = retrieve.showCollection("docs")
    documents = retrieve.showDocs(docs, col)
    if documents == "":
        return render_template('index.html')
    with open("templates/index.html") as inf:
        txt = inf.read()
        soup = bs4.BeautifulSoup(txt, features="html.parser")
    for document in documents:
        new_link = soup.new_tag("a", target="_blank", href="/documents/{}".format(document[0]))
        new_link.string = document[0]
        soup.section.append(new_link)

    return str(soup)


@app.route('/documents/<name>')
def displayDoc(name):
    text = []
    data = ""
    with open("documents/{}.txt".format(name)) as fp:
        line = fp.readline()
        while line:
            data += line
            text.append(line)
            line = fp.readline()

    with open("templates/song.html") as inf:
        template = inf.read()
        soup = bs4.BeautifulSoup(template, features="html.parser")
        p = soup.new_tag("p")
        p['class'] = "res"
        body = soup.body
        h1 = soup.new_tag("h1")
        h1['class'] = "res"
        body.append(h1)
        h2 = soup.new_tag("h2")
        h2['class'] = "res"
        body.append(h2)
        body.append(p)
        i = 0
        for line in text:
            if i == 0:
                body.h1.append(line)
            elif i == 1:
                body.h2.append(line)
            else:
                body.p.append(line)
                body.p.append(soup.new_tag("br"))
            i += 1
    return str(soup)


@app.route('/admin.html')
def admin():
    return render_template('admin.html')


if __name__ == '__main__':
    app.run(debug=True, host='127.0.0.1')
