public class ExcelDocument implements Document {
    @Override
    public void save() {
        System.out.println("[Excel] Saving document...");
    }
    @Override
    public void open() {
        System.out.println("[Excel] Opening document...");
    }
    @Override
    public void close() {
        System.out.println("[Excel] Closing document...");
    }
}
