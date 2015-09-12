package booksoft;
public class Usuario extends Libro {
    private int cantPres=0;
    private String cc;
    private Libro[] prestado=new Libro[5];
    private boolean out;

    public int getCantPres() {
        return cantPres;
    }
    public void setCantPres(int cantPres) {
        this.cantPres = cantPres;
    }
    public String getCc() {
        return cc;
    }
    public void setCc(String cc) {
        this.cc = cc;
    }
    public Libro[] getPrestado() {
        return prestado;
    }
    public void setPrestado(Libro[] prestado) {
        this.prestado = prestado;
    }
    
    public void prestarLibro(Usuario Libro){
        
            cantPres+=1;
            this.setCant(this.getCant()-1);
            BookSoft.libPrestados+=1;
            System.out.println("El libro fue agregado a su lista de prestamos.");
            System.out.println("Actualmente tiene "+BookSoft.libPrestados+" libros prestados");
            out=true;
    }
    public void devolverLibro(){
            if(cantPres==0)
                System.out.println("No tiene libros pendientes.");
            else{
            cantPres-=1;
            BookSoft.libPrestados-=1;
            this.setCant(this.getCant()+1);
            System.out.println("El libro fue devuelto con exito.");
            System.out.println("Actualmente tiene "+BookSoft.libPrestados+" libros prestados");
            }
            if (cantPres==0) {
                out=false;
            }
        }

    public void librosPrestados(){
        if (cantPres==0)
            System.out.println("Actualmente no tiene libros prestados");
        if (out==true){
            //System.out.println("Nombre del libro: "+getNombre());
            buscarLibro();
                    
        }
    }
}
