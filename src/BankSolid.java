public class BankSolid {
    public static void main(String[] args) {
        final int PREMI_ASURANSI = 50000;

        Tabungan ani = new Tabungan("101", "Ani", 1000000, 2.5);
        Tabungan citra = new Tabungan("102", "Citra", 300000, 2.0);
        Giro budi = new Giro("201", "Budi", 200000, 500000);

        Rekening[] semua = { ani, citra, budi };
        BerBunga[] berbunga = { ani, citra };

        ProsesAkhirBulan proses = new ProsesAkhirBulan();
        LaporanBank laporan = new LaporanBank();

        laporan.cetakDaftar("REKENING AWAL", semua);
        laporan.cetakBarisKosong();

        laporan.cetakJudul("AKHIR BULAN");
        proses.potongBiayaAdmin(semua);
        proses.tambahBunga(berbunga);
        proses.autodebet(semua, PREMI_ASURANSI);
        laporan.cetakBarisKosong();

        laporan.cetakDaftar("REKENING AKHIR", semua);
        laporan.cetakTotal(semua);
    }
}