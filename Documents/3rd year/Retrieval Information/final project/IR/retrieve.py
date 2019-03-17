import parse_file
import nltk
import pymongo
import parse_file


def showCollection(collection):
    myClient = pymongo.MongoClient("mongodb://127.0.0.1:27017/")
    mydb = myClient["ir"]
    col = mydb[collection]
    return col


def findWords(str , col):
    words = []
    wordsTokenized = nltk.word_tokenize(str)
    for word in wordsTokenized:
        docs = []
        # docs.append(word)
        if (word=='&' or word=='|' or word=='!' or word=='(' or word==')'):
            words.append(word)
            continue
        sound = parse_file.sdx(word)
        # docs.append(sound)
        searchResult = col.find_one({"soundex": sound})
        if(searchResult):
            for i in searchResult["locations"]:
                docs.append(i["doc"])
        else:
            docs.append([])
        words.append(docs)
    return words


def query(words):
    docs = words
    flag = False
    docs_sub = []
    i = 0
    while i < (len(docs)):
        if docs[i] == ")":
            docs_sub_end = i
            flag = False
        elif docs[i] == "(":
            docs_sub_start = i
            flag = True
            i += 1
            continue
        if flag == True:
            docs_sub.append(docs[i])
        i += 1
    if len(docs_sub) > 0:
        sub = query(docs_sub)
        docs[docs_sub_start] = sub[0]
        j = 0
        while j < (docs_sub_end - docs_sub_start):
            del docs[docs_sub_start + 1]
            j += 1
    i = 0
    while i < (len(docs)):
        doc = []
        if docs[i] == "&":
            for d1 in docs[i-1]:
                for d2 in docs[i+1]:
                    if d1 == d2:
                        doc.append(d1)
            docs[i+1] = doc
            del docs[i-1]
            del docs[i-1]
            i -= 2
        else:
            i += 1
    i = 0
    while i < (len(docs)):
        doc = []
        if docs[i] == "|":
            for d1 in docs[i - 1]:
                doc.append(d1)
                for d2 in docs[i + 1]:
                    doc.append(d2)
            docs[i + 1] = list(set(doc))
            del docs[i-1]
            del docs[i-1]
            i -= 2
        else:
            i += 1

    return docs


def showDocs(docs, col):
    documents = []
    for doc in docs[0]:
        d = []
        searchResult = col.find_one({"id": doc})
        print('searchResults {}'.format(searchResult))
        if searchResult is None:
            return ""
        d.append(searchResult["name"])
        d.append(searchResult["author"])
        documents.append(d)
    return documents
