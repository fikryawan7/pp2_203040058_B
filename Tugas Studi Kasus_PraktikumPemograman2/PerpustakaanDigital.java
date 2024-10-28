import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PerpustakaanDigital extends JFrame {
    private DefaultTableModel tableModel;
    private JTable bukuTable;

    public PerpustakaanDigital() {
        setTitle("Perpustakaan Digital");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tableModel = new DefaultTableModel(new String[]{"Judul", "Pengarang", "ISBN", "Genre", "Status", "Tahun", "Penerbit"}, 0);
        bukuTable = new JTable(tableModel);
        add(new JScrollPane(bukuTable), BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu Utama");

        JMenuItem formInputMenu = new JMenuItem("Form Input Buku");
        formInputMenu.addActionListener(e -> showInputForm());
        menu.add(formInputMenu);

        JMenuItem keluarMenu = new JMenuItem("Keluar");
        keluarMenu.addActionListener(e -> {
            int confirmed = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin keluar?", "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION);
            if (confirmed == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        menu.add(keluarMenu);

        menuBar.add(menu);
        setJMenuBar(menuBar);

        JPanel buttonPanel = new JPanel();
        JButton hapusButton = new JButton("Hapus Buku");
        hapusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hapusBuku();
            }
        });
        buttonPanel.add(hapusButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void showInputForm() {
        InputForm inputForm = new InputForm();
        int result = JOptionPane.showConfirmDialog(this, inputForm, "Form Input Buku", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            Buku buku = inputForm.getBukuFromInput();
            tableModel.addRow(buku.toTableRow());
        }
    }

    private void hapusBuku() {
        int selectedRow = bukuTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Pilih buku yang ingin dihapus.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PerpustakaanDigital().setVisible(true));
    }
}
