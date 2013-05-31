package singletonthreads;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Antonio
 */
public class ProcessOne implements Runnable{

    private static ProcessOne uniqueInstance;
    private Thread t;
    
    private ProcessOne(){
            t= new Thread(this);
            t.start();
    }
    
    public static synchronized ProcessOne getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new ProcessOne();            
        }
        return uniqueInstance;
    }
    @Override
    public void run() {        
        try {
            for (int i=0;i<10;i++){
                System.out.println("This is process One running");
                t.sleep(2000L);
            }                        
        } catch (InterruptedException ex) {
            Logger.getLogger(ProcessOne.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
