public class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        Document doc = new ExcelDocument();
        doc.printInfo();
        return doc;
    }
}
