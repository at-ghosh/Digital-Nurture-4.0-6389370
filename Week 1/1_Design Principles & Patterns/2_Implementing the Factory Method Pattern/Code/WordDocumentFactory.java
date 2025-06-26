public class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        Document doc = new WordDocument();
        doc.printInfo();
        return doc;
    }
}
