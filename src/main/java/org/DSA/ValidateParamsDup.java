package org.DSA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidateParamsDup {

    public static void main(String[] args) throws Exception {
        List<String> ans = new ArrayList<>();
        GetStoredProcedureParamsDup getStoredProcedureParamsDup = new GetStoredProcedureParamsDup();
        ans = Collections.singletonList(getStoredProcedureParamsDup.getStoredParamsFunc());
        System.out.println(ans);

    }
}
