public class Buku {
    private String judul;
    private String pengarang;
    private String isbn;
    private String genre;
    private String status;
    private int tahun;
    private String penerbit;

    public Buku(String judul, String pengarang, String isbn, String genre, String status, int tahun, String penerbit) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.isbn = isbn;
        this.genre = genre;
        this.status = status;
        this.tahun = tahun;
        this.penerbit = penerbit;
    }

    public Object[] toTableRow() {
        return new Object[]{judul, pengarang, isbn, genre, status, tahun, penerbit};
    }
}
