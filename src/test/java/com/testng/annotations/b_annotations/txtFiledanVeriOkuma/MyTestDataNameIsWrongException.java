package com.testng.annotations.b_annotations.txtFiledanVeriOkuma;

public class MyTestDataNameIsWrongException extends Exception
{

    public MyTestDataNameIsWrongException(String message) {
        super(message);//parent'in Exception'nin yaptigi isin aynisini yap
    }
}
