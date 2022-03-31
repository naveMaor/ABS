package Shai;

import time.Timeline;
import utills.BackgroundFunc;

public class TempPrintFunc {

    public static void printYazAfterPromote(){
        System.out.println("Yaz was: " );
        Timeline.printPreviousCurrTime();
        System.out.println("Yaz now: " );
        Timeline.printStaticCurrTime();
    }




    public void func7(){
        Timeline.promoteStaticCurrTime();
        printYazAfterPromote();
        BackgroundFunc.handleLoans();
    }
}
