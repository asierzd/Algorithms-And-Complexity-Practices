package P0;

public class Entero {
    private int num;

    public Entero()
    {
        this.num=0;
    }

    public Entero(int v)
    {
        this.num=v;
    }

    public void setValor(int v)
    {
        this.num=v;
    }

    public int getValor()
    {
        return this.num;
    }

    public String toString()
    {
        return "Entero: "+this.num;
    }

}
