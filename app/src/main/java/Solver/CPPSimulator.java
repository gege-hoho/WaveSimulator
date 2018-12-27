package Solver;



//all CPPSimulator Objects uses the Same Native Object!
public class CPPSimulator {
    public static final int cell_count = 100; /*Todo: implement cell_count everywhere (eg in native code)
    known dependencies:
    Wrapper.cpp  Java_Solver_CPPSimulator_setWave    */
    public static CPPSimulator sim; //have to be static to allow screen rotation
    private static long SWE_Pointer = 0;
    public CPPSimulator(){
        System.loadLibrary("SWELib");
        if(SWE_Pointer == 0) {
            reset();
        }
        //setWave(20,20,5,25);
    }
    public static void setWave(int x, int y, int r, float h)
    {
        setWave(x,y,r,h,SWE_Pointer);
        //SWE_Pointer = setWave(x,y,r,h,SWE_Pointer);
    }
    public static void reset()
    {
        SWE_Pointer = init();//creates a new SWE_Block Object
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
    private static native void setWave(int x, int y, int r, float h,long ptr);
    private static native void delete(long ptr);
    private static native float getHeight(int x, int y, long ptr);
    private static native float getBathymetry(int x, int y, long ptr);
    private static native void simulatetimestep(long ptr);
}
