package org.DSA;

public class GetStoredProcedureParamsDup {
    public void testing()
    {

    }
    public String getStoredParamsFunc() throws Exception {
        try{
            int a = 5/0;
            return "val";
        }
        catch (Exception e){
            throw new Exception("some exception");
        }
    }
}
