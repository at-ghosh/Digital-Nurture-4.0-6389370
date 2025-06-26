public abstract class DocumentFactory {
    public abstract Document createDocument();

    public void processDocument() {
        Document doc = createDocument();
        System.out.println("--- Processing Start ---");
        doc.open();
        doc.save();
        doc.close();
        System.out.println("--- Processing End ---");
    }
}
