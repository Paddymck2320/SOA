/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.ait.esper;

import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

/**
 *
 * @author A00261481
 */
public class Ex3_BasicAggregation {
    
     public static void generateEvent(EPRuntime runtime)
    {
        int min1 = 0;
        int max1 = 5;
        String names[] = {"Joe", "Mary", "Simon", "Joan", "Evan", "Keith"};
        int number = (int)(Math.random()*(max1-min1+1)+min1);
        String name = names[number];
        
        int min2 = 1;
        int max2 = 100;
        int age = (int)(Math.random()*(max2-min2+1)+min2);
        
        PersonEvent evt = new PersonEvent(name, age);
        System.out.println("Sending Event: " + evt.toString());
        runtime.sendEvent(evt);
    }
    public static void main(String args[]){
       
        // Get default engine instance
        EPServiceProvider engine = EPServiceProviderManager.getDefaultProvider();
        
        // Register an event - tells the engine to listen for PersonEvents
        engine.getEPAdministrator().getConfiguration().addEventType(PersonEvent.class);
        
        // Create an Event Processing Language (EPL) statement
        // When a PersonEvent arrives, get the name and age..
        String epl = "select count(*) as total, sum(age) as sumAge from PersonEvent";
        EPStatement statement = engine.getEPAdministrator().createEPL(epl);
        
        // Callback to invoke when a PersonEvent arrives
        // This happens after the statement above is ran 
        statement.addListener( (newData, oldData) -> {
            long total = (long) newData[0].get("total");
            int sumAge = (int) newData[0].get("sumAge");
            System.out.println(String.format("total: %d, sumAge: %d", total, sumAge));
        });
        
        // Send an event into the engine
        for(int i=0; i<20; i++){
            generateEvent(engine.getEPRuntime());
        }	
    }
    
}
