public class PdfDocument implements Document {
    @Override
    public void save() {
        System.out.println("[PDF] Saving document...");
    }
    @Override
    public void open() {
        System.out.println("[PDF] Opening document...");
    }
    @Override
    public void close() {
        System.out.println("[PDF] Closing document...");
    }
}
