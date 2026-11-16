public abstract class Rekening {
    // nomor dan pemilik tetap private: anak harus lewat getter
    private String nomor;
    private String pemilik;

    // protected: boleh dipakai langsung oleh class turunan
    protected int saldo;

    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    public String getNomor() {
        return nomor;
    }

    public String getPemilik() {
        return pemilik;
    }

    public int getSaldo() {
        return saldo;
    }

    // Baris kedua laporan, misalnya "Tabungan, bunga 2.5% per bulan"
    public abstract String keterangan();

    // Setiap jenis rekening wajib menentukan biaya adminnya sendiri
    public abstract int biayaAdminBulanan();

    public int potongBiayaAdmin() {
        int biaya = biayaAdminBulanan();
        saldo -= biaya;
        return biaya;
    }

    public boolean setor(int jumlah) {
        if (jumlah <= 0) {
            return false;
        }
        saldo += jumlah;
        return true;
    }

    /*
     * KONTRAK tarik (berlaku untuk Rekening dan SEMUA turunannya):
     * - mengembalikan true kalau penarikan berhasil (saldo berkurang sebesar jumlah),
     * - mengembalikan false kalau gagal (saldo tidak berubah),
     * - tidak pernah melempar exception.
     */
    public boolean tarik(int jumlah) {
        if (jumlah <= 0 || jumlah > saldo) {
            return false;
        }
        saldo -= jumlah;
        return true;
    }

    // 120000 -> "Rp120.000", -15000 -> "-Rp15.000"
    protected static String formatRupiah(int angka) {
        if (angka < 0) {
            return "-" + formatRupiah(-angka);
        }
        String digit = String.valueOf(angka);
        StringBuilder hasil = new StringBuilder();
        int hitung = 0;
        for (int i = digit.length() - 1; i >= 0; i--) {
            hasil.insert(0, digit.charAt(i));
            hitung++;
            if (hitung % 3 == 0 && i > 0) {
                hasil.insert(0, '.');
            }
        }
        return "Rp" + hasil;
    }
}