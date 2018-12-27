package Solver;

public class CPPSimulator {
    private long SWE_Pointer;
    public CPPSimulator(){
        System.loadLibrary("SWELib");
        SWE_Pointer = init(); //creates a new SWE_Block Object

    }
    public float getHeight(int x, int y)
    {
        return getHeight(x,y,SWE_Pointer);
    }
    public float getBathymetry(int x, int y)
    {
        return getBathymetry(x,y,SWE_Pointer);
    }
    public void simulatetimestep()
    {
        simulatetimestep(SWE_Pointer);
    }
    protected void finalize()
    {
        delete(SWE_Pointer);//free up Memory
    }
    private static native long init();
    private static native void delete(long ptr);
    private static native float getHeight(int x, int y, long ptr);
    private static native float getBathymetry(int x, int y, long ptr);
    private static native void simulatetimestep(long ptr);
}
