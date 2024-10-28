import java.awt.*;
import javax.swing.*;

public class InputForm extends JPanel {
    private JTextField judulField, pengarangField, isbnField, penerbitField;
    private JTextArea deskripsiArea;
    private JRadioButton tersediaRadio, dipinjamRadio;
    private JComboBox<String> genreComboBox;
    private JSlider tahunSlider;
    private JSpinner tahunSpinner;

    public InputForm() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        judulField = new JTextField();
        pengarangField = new JTextField();
        isbnField = new JTextField();
        penerbitField = new JTextField();
        deskripsiArea = new JTextArea(3, 20);
        tersediaRadio = new JRadioButton("Tersedia");
        dipinjamRadio = new JRadioButton("Dipinjam");
        ButtonGroup statusGroup = new ButtonGroup();
        statusGroup.add(tersediaRadio);
        statusGroup.add(dipinjamRadio);

        genreComboBox = new JComboBox<>(new String[]{"Novel", "Puisi", "Sejarah", "Sains", "Biografi", "Drama"});
        tahunSlider = new JSlider(1900, 2023);
        tahunSpinner = new JSpinner(new SpinnerNumberModel(2023, 1900, 2023, 1));

        tahunSlider.addChangeListener(e -> tahunSpinner.setValue(tahunSlider.getValue()));
        tahunSpinner.addChangeListener(e -> tahunSlider.setValue((Integer) tahunSpinner.getValue()));

        // tambahkan panel
        addComponent(gbc, new JLabel("Judul Buku:"), 0, 0);
        addComponent(gbc, judulField, 1, 0, 2);
        addComponent(gbc, new JLabel("Pengarang:"), 0, 1);
        addComponent(gbc, pengarangField, 1, 1, 2);
        addComponent(gbc, new JLabel("ISBN:"), 0, 2);
        addComponent(gbc, isbnField, 1, 2, 2);
        addComponent(gbc, new JLabel("Deskripsi:"), 0, 3);
        addComponent(gbc, new JScrollPane(deskripsiArea), 1, 3, 2);
        addComponent(gbc, new JLabel("Status:"), 0, 4);
        JPanel statusPanel = new JPanel();
        statusPanel.add(tersediaRadio);
        statusPanel.add(dipinjamRadio);
        addComponent(gbc, statusPanel, 1, 4, 2);
        addComponent(gbc, new JLabel("Genre:"), 0, 5);
        addComponent(gbc, genreComboBox, 1, 5, 2);
        addComponent(gbc, new JLabel("Penerbit:"), 0, 6);
        addComponent(gbc, penerbitField, 1, 6, 2);
        addComponent(gbc, new JLabel("Tahun Penerbitan:"), 0, 7);
        JPanel tahunPanel = new JPanel();
        tahunPanel.add(tahunSlider);
        tahunPanel.add(tahunSpinner);
        addComponent(gbc, tahunPanel, 1, 7, 2);
    }

    private void addComponent(GridBagConstraints gbc, Component comp, int x, int y, int width) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        add(comp, gbc);
    }

    private void addComponent(GridBagConstraints gbc, Component comp, int x, int y) {
        addComponent(gbc, comp, x, y, 1);
    }

    public Buku getBukuFromInput() {
        String judul = judulField.getText();
        String pengarang = pengarangField.getText();
        String isbn = isbnField.getText();
        String penerbit = penerbitField.getText();
        String status = tersediaRadio.isSelected() ? "Tersedia" : "Dipinjam";
        String genre = (String) genreComboBox.getSelectedItem();
        int tahun = (int) tahunSpinner.getValue();

        return new Buku(judul, pengarang, isbn, genre, status, tahun, penerbit);
    }
}
