public class FactoryMethodTest {
    public static void main(String[] args) {
        DocumentFactory[] factories = {
            new WordDocumentFactory(),
            new PdfDocumentFactory(),
            new ExcelDocumentFactory()
        };
        String[] types = {"Word", "PDF", "Excel"};
        System.out.println("Document Processing Table:");
        System.out.println("Type     | Open         | Save         | Close");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < factories.length; i++) {
            System.out.printf("%-9s| ", types[i]);
            Document doc = factories[i].createDocument();
            doc.open();
            doc.save();
            doc.close();
        }
        System.out.println("\nProcessing all documents:");
        for (DocumentFactory factory : factories) {
            factory.processDocument();
        }
    }
}
