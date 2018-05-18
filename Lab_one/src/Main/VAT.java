package Main;

public class VAT
{
    private int a;
    private float p;
    private int x;

    private float v;
    private int w;

    public VAT(int a, float p, int x)
    {
        this.a = a;
        this.p = p;
        this.x = x;

        this.v = (p/100)* a * x;
        this.w = a * x;
    }

    public int getA() {
        return a;
    }

    public float getP() {
        return p;
    }

    public int getX() {
        return x;
    }

    public float getV() {
        return v;
    }

    public int getW() {
        return w;
    }

}
