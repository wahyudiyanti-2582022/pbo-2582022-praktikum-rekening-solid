public class Deposito extends Rekening implements BerBunga {
    private double bungaPersen;

    public Deposito(String nomor, String pemilik, int saldo, double bungaPersen) {
        super(nomor, pemilik, saldo);
        this.bungaPersen = bungaPersen;
    }

    // Deposito tanpa biaya admin
    @Override
    public int biayaAdminBulanan() {
        return 0;
    }

    @Override
    public int tambahBunga() {
        int bunga = (int) Math.round(saldo * bungaPersen / 100);
        setor(bunga);
        return bunga;
    }

    @Override
    public String keterangan() {
        return "Deposito, bunga " + bungaPersen + "% per bulan";
    }

    // Percobaan awal: tarik melempar new UnsupportedOperationException("Deposito tidak bisa ditarik").
    // Hasil saat dijalankan:
    // Exception in thread "main" java.lang.UnsupportedOperationException: Deposito tidak bisa ditarik
    // Itu melanggar kontrak Rekening.tarik (tidak pernah melempar exception),
    // jadi diperbaiki: deposito tidak bisa ditarik -> kembalikan false, saldo tidak berubah.
    @Override
    public boolean tarik(int jumlah) {
        return false;
    }
}