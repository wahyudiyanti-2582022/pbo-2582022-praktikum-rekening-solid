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

    @Override
    public boolean tarik(int jumlah) {
        throw new UnsupportedOperationException("Deposito tidak bisa ditarik");
    }
}