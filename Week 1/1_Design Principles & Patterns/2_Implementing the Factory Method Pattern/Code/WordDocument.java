public class WordDocument implements Document {
    @Override
    public void save() {
        System.out.println("[Word] Saving document...");
    }
    @Override
    public void open() {
        System.out.println("[Word] Opening document...");
    }
    @Override
    public void close() {
        System.out.println("[Word] Closing document...");
    }
}
