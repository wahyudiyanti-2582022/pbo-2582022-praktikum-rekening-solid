public class LaporanBank {
    private static final int LEBAR = 35;

    // Contoh: "========== REKENING AWAL =========="
    public void cetakJudul(String judul) {
        StringBuilder baris = new StringBuilder("========== " + judul + " ");
        while (baris.length() < LEBAR) {
            baris.append('=');
        }
        System.out.println(baris);
    }

    public void cetakBarisKosong() {
        System.out.println();
    }

    public void cetakDaftar(String judul, Rekening[] semua) {
        cetakJudul(judul);
        for (Rekening r : semua) {
            System.out.println(r.getNomor() + " | "
                    + String.format("%-6s", r.getPemilik()) + " | "
                    + String.format("%12s", Rekening.formatRupiah(r.getSaldo())));
            System.out.println("      " + r.keterangan());
        }
    }

    public void cetakTotal(Rekening[] semua) {
        int total = 0;
        for (Rekening r : semua) {
            total += r.getSaldo();
        }
        System.out.println("-----------------------------------");
        System.out.println("Total dana bank : " + Rekening.formatRupiah(total));
    }
}