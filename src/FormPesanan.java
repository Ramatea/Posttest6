public abstract class FormPesanan{
    private String Nama;
    private String NoPesanan;
    private String NoTelp;
    private int NoAntrian;

    FormPesanan(String Nama, String NoPesanan, String NoTelp, int nomor_antrian){
        this.Nama = Nama;
        this.NoPesanan = NoPesanan;
        this.NoTelp = NoTelp;
        this.NoAntrian = nomor_antrian;
    }
    
    public void setNoTelp(String NoTelp){
        this.NoTelp = NoTelp;
    }

    public String getNoPesanan(){ return NoPesanan;}

    public final void setNoPesanan(String NoPesanan){
        this.NoPesanan = NoPesanan;
    }

    public String getNama(){ return Nama;}

    public void setNama(String Nama){ this.Nama = Nama;}
    
    public int getNoAntrian(){ return NoAntrian;}

    public void setNoAntrian(int NoAntrian){
        this.NoAntrian = NoAntrian;
    }
    
    @Override public String toString(){

        return "ListPesanan("+"No Antrian = "+ NoAntrian + "nama = " + Nama + ", No Pesanan = " + NoPesanan + ", No Telpon = " + NoTelp + "}";
    }

    public String getNo_telp(){
        return this.NoTelp;
    }

    public int getNo_Antrian(){
        return this.NoAntrian;
    }
    
}
