public interface Document {
    void open();
    void save();
    void close();
    default void printInfo() {
        System.out.println("Document interface in use.");
    }
}
