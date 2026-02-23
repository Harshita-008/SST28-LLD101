public interface IInvoiceRepository {
    void save(String name, String content);
    int countLines(String name);
}
