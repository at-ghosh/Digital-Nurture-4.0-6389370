public class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        Document doc = new PdfDocument();
        doc.printInfo();
        return doc;
    }
}
